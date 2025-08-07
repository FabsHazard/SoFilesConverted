package com.microtech.aidexx.ui.pair;

import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.databinding.PairCheckDialogBinding;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "input", "Lkotlin/Pair;", "", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairCheckDialog.kt */
final class PairCheckDialog$build$3 extends Lambda implements Function1<Pair<? extends Boolean, ? extends String>, Unit> {
    final /* synthetic */ BleControllerProxy $info;
    final /* synthetic */ PairCheckDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PairCheckDialog$build$3(PairCheckDialog pairCheckDialog, BleControllerProxy bleControllerProxy) {
        super(1);
        this.this$0 = pairCheckDialog;
        this.$info = bleControllerProxy;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Boolean, String>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<Boolean, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "input");
        PairCheckDialogBinding pairCheckDialogBinding = null;
        if (pair.getFirst().booleanValue()) {
            Object systemService = this.this$0.getContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            PairCheckDialogBinding access$getBind$p = this.this$0.bind;
            if (access$getBind$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bind");
                access$getBind$p = null;
            }
            inputMethodManager.hideSoftInputFromWindow(access$getBind$p.etVerCode.getWindowToken(), 2);
            PairCheckDialogBinding access$getBind$p2 = this.this$0.bind;
            if (access$getBind$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bind");
                access$getBind$p2 = null;
            }
            access$getBind$p2.etVerCode.clearFocus();
            if (StringsKt.equals(pair.getSecond(), this.$info.getSn(), true)) {
                this.this$0.dismiss();
                Function1<BleControllerProxy, Unit> onPass = this.this$0.getOnPass();
                if (onPass != null) {
                    onPass.invoke(this.$info);
                    return;
                }
                return;
            }
            PairCheckDialogBinding access$getBind$p3 = this.this$0.bind;
            if (access$getBind$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bind");
                access$getBind$p3 = null;
            }
            ConstraintLayout constraintLayout = access$getBind$p3.clReselect;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "clReselect");
            constraintLayout.setVisibility(0);
            PairCheckDialogBinding access$getBind$p4 = this.this$0.bind;
            if (access$getBind$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bind");
                access$getBind$p4 = null;
            }
            TextView textView = access$getBind$p4.tvNotSame;
            Intrinsics.checkNotNullExpressionValue(textView, "tvNotSame");
            textView.setVisibility(0);
            PairCheckDialogBinding access$getBind$p5 = this.this$0.bind;
            if (access$getBind$p5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bind");
            } else {
                pairCheckDialogBinding = access$getBind$p5;
            }
            ImageView imageView = pairCheckDialogBinding.ivClosePairCheck;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivClosePairCheck");
            imageView.setVisibility(8);
            return;
        }
        PairCheckDialogBinding access$getBind$p6 = this.this$0.bind;
        if (access$getBind$p6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            access$getBind$p6 = null;
        }
        ConstraintLayout constraintLayout2 = access$getBind$p6.clReselect;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "clReselect");
        constraintLayout2.setVisibility(8);
        PairCheckDialogBinding access$getBind$p7 = this.this$0.bind;
        if (access$getBind$p7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            access$getBind$p7 = null;
        }
        TextView textView2 = access$getBind$p7.tvNotSame;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvNotSame");
        textView2.setVisibility(8);
        PairCheckDialogBinding access$getBind$p8 = this.this$0.bind;
        if (access$getBind$p8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
        } else {
            pairCheckDialogBinding = access$getBind$p8;
        }
        ImageView imageView2 = pairCheckDialogBinding.ivClosePairCheck;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivClosePairCheck");
        imageView2.setVisibility(0);
    }
}
