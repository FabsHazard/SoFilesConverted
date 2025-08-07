package com.microtech.aidexx.service;

import android.content.res.Resources;
import androidx.core.app.ActivityCompat;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.ContextUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.eventbus.AlertInfo;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "time", "", "type", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainService.kt */
final class MainService$observeAlert$1 extends Lambda implements Function2<String, Integer, Unit> {
    final /* synthetic */ MainService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainService$observeAlert$1(MainService mainService) {
        super(2);
        this.this$0 = mainService;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(String str, int i) {
        String str2;
        boolean z;
        Intrinsics.checkNotNullParameter(str, CrashHianalyticsData.TIME);
        Resources resources = ContextUtil.Companion.getResources();
        boolean z2 = !AidexxApp.Companion.getInstance().isForeground();
        switch (i) {
            case 1:
                str2 = str + ' ' + resources.getString(R.string.cgm_warning_high);
                break;
            case 2:
                str2 = str + ' ' + resources.getString(R.string.cgm_warning_low);
                break;
            case 3:
                str2 = str + ' ' + resources.getString(R.string.cgm_warning_urgentLow);
                z = true;
                break;
            case 4:
                str2 = str + ' ' + resources.getString(R.string.cgm_trend_fallQuick_1);
                break;
            case 5:
                str2 = str + ' ' + resources.getString(R.string.cgm_trend_riseQuick_1);
                break;
            case 6:
                str2 = str + ' ' + resources.getString(R.string.noti_signalLost);
                z2 = true;
                break;
            default:
                str2 = "";
                break;
        }
        z = false;
        this.this$0.process(i, z);
        if (i == 4) {
            i = 5;
        }
        if (!z2) {
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_SHOW_ALERT, new AlertInfo(str2, i, false));
        } else if (z2) {
            if (ActivityCompat.checkSelfPermission(this.this$0, "android.permission.POST_NOTIFICATIONS") == 0) {
                LocalNotificationManager.INSTANCE.notificationAlert(this.this$0, str2, i);
            } else {
                LogUtil.Companion.eAiDEX("No notification permission, can't post alert");
            }
        }
    }
}
