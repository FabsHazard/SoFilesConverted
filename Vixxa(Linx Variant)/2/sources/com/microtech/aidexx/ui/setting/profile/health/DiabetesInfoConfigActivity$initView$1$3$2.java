package com.microtech.aidexx.ui.setting.profile.health;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.common.ExtendsKt;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "time", "Ljava/util/Date;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DiabetesInfoConfigActivity.kt */
final class DiabetesInfoConfigActivity$initView$1$3$2 extends Lambda implements Function1<Date, Unit> {
    final /* synthetic */ DiabetesInfoConfigActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiabetesInfoConfigActivity$initView$1$3$2(DiabetesInfoConfigActivity diabetesInfoConfigActivity) {
        super(1);
        this.this$0 = diabetesInfoConfigActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Date) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Date date) {
        Intrinsics.checkNotNullParameter(date, CrashHianalyticsData.TIME);
        CharSequence dateAndYM$default = ExtendsKt.dateAndYM$default(date, (String) null, 1, (Object) null);
        if (dateAndYM$default != null && dateAndYM$default.length() != 0) {
            DiabetesInfoConfigActivity diabetesInfoConfigActivity = this.this$0;
            String dateAndTimeS$default = ExtendsKt.dateAndTimeS$default(date, (String) null, 1, (Object) null);
            Intrinsics.checkNotNull(dateAndTimeS$default);
            diabetesInfoConfigActivity.diagnosisDate = dateAndTimeS$default;
            this.this$0.setDiagnosisDate();
        }
    }
}
