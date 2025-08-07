package com.microtech.aidexx.ui.setting.alert;

import android.widget.CompoundButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/CompoundButton;", "isChecked", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertSettingsActivity.kt */
final class AlertSettingsActivity$initView$function$1 extends Lambda implements Function2<CompoundButton, Boolean, Unit> {
    public static final AlertSettingsActivity$initView$function$1 INSTANCE = new AlertSettingsActivity$initView$function$1();

    AlertSettingsActivity$initView$function$1() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((CompoundButton) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(compoundButton, "<anonymous parameter 0>");
        AlertUtil.INSTANCE.setSignalLossEnable(z);
    }
}
