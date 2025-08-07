package com.microtech.aidexx.ui.main.home.panel;

import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.FragmentWarmingUpBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "timeOffset", "", "invoke", "(Ljava/lang/Integer;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: WarmingUpFragment.kt */
final class WarmingUpFragment$onCreateView$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ WarmingUpFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WarmingUpFragment$onCreateView$1(WarmingUpFragment warmingUpFragment) {
        super(1);
        this.this$0 = warmingUpFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Integer num) {
        if (num != null) {
            this.this$0.createTimer(60 - num.intValue());
        } else {
            ((FragmentWarmingUpBinding) this.this$0.getBinding()).tvRemain.setText(this.this$0.getResources().getString(R.string.com_unknown));
        }
    }
}
