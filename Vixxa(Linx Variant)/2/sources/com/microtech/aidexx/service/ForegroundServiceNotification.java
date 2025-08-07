package com.microtech.aidexx.service;

import android.app.PendingIntent;
import android.content.Context;
import android.widget.RemoteViews;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.ContextUtil;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.UnitManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/service/ForegroundServiceNotification;", "Landroid/widget/RemoteViews;", "context", "Landroid/content/Context;", "pendingIntent", "Landroid/app/PendingIntent;", "packageName", "", "(Landroid/content/Context;Landroid/app/PendingIntent;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setGlucose", "", "datetime", "glucose", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ForegroundServiceNotification.kt */
public final class ForegroundServiceNotification extends RemoteViews {
    private final Context context;

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForegroundServiceNotification(Context context2, PendingIntent pendingIntent, String str) {
        super(str, R.layout.remoteviews_notification);
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(pendingIntent, "pendingIntent");
        this.context = context2;
        setOnClickPendingIntent(R.id.notice, pendingIntent);
    }

    public final void setGlucose(String str, Float f) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "datetime");
        setTextViewText(R.id.tv_time, str);
        int i = R.id.tv_glucose;
        if (f == null || (str2 = GlucoseUtilKt.toGlucoseStringWithLowAndHigh(f.floatValue(), ContextUtil.Companion.getResources())) == null) {
            str2 = this.context.getResources().getString(R.string.com_unknown);
            Intrinsics.checkNotNullExpressionValue(str2, "getString(...)");
        }
        setTextViewText(i, str2);
        setTextViewText(R.id.tv_unit, UnitManager.INSTANCE.getDisplayUnit());
    }
}
