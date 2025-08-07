package com.microtech.aidexx.ui.main.home.panel;

import androidx.fragment.app.FragmentActivity;
import com.microtech.aidexx.ui.pair.TransmitterActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucosePanelFragment.kt */
final class GlucosePanelFragment$deleteAndToPair$1$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ FragmentActivity $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlucosePanelFragment$deleteAndToPair$1$1$1(FragmentActivity fragmentActivity) {
        super(0);
        this.$it = fragmentActivity;
    }

    public final void invoke() {
        ActivityUtil activityUtil = ActivityUtil.INSTANCE;
        FragmentActivity fragmentActivity = this.$it;
        Intrinsics.checkNotNullExpressionValue(fragmentActivity, "$it");
        activityUtil.toActivity(fragmentActivity, TransmitterActivity.class);
        Dialogs.INSTANCE.dismissWait();
    }
}
