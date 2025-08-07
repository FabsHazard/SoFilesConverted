package com.microtech.aidexx.ui.pair;

import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.PairCheckDialogBinding;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtechmd.blecomm.controller.BleControllerProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\rR\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairCheckDialog;", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "themeResId", "", "(Landroidx/appcompat/app/AppCompatActivity;I)V", "bind", "Lcom/microtech/aidexx/databinding/PairCheckDialogBinding;", "mContext", "onPass", "Lkotlin/Function1;", "Lcom/microtechmd/blecomm/controller/BleControllerProxy;", "Lkotlin/ParameterName;", "name", "info", "", "getOnPass", "()Lkotlin/jvm/functions/Function1;", "setOnPass", "(Lkotlin/jvm/functions/Function1;)V", "build", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairCheckDialog.kt */
public final class PairCheckDialog extends AlertDialog {
    /* access modifiers changed from: private */
    public PairCheckDialogBinding bind;
    /* access modifiers changed from: private */
    public AppCompatActivity mContext;
    private Function1<? super BleControllerProxy, Unit> onPass;

    public final Function1<BleControllerProxy, Unit> getOnPass() {
        return this.onPass;
    }

    public final void setOnPass(Function1<? super BleControllerProxy, Unit> function1) {
        this.onPass = function1;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PairCheckDialog(AppCompatActivity appCompatActivity) {
        this(appCompatActivity, 0);
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PairCheckDialog(AppCompatActivity appCompatActivity, int i) {
        super(appCompatActivity, i);
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        this.mContext = appCompatActivity;
    }

    public final PairCheckDialog build(BleControllerProxy bleControllerProxy) {
        Intrinsics.checkNotNullParameter(bleControllerProxy, TransmitterActivityKt.BLE_INFO);
        PairCheckDialogBinding pairCheckDialogBinding = null;
        PairCheckDialogBinding bind2 = PairCheckDialogBinding.bind(LayoutInflater.from(getContext()).inflate(R.layout.pair_check_dialog, (ViewGroup) null));
        Intrinsics.checkNotNullExpressionValue(bind2, "bind(...)");
        this.bind = bind2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        PairCheckDialogBinding pairCheckDialogBinding2 = this.bind;
        if (pairCheckDialogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding2 = null;
        }
        pairCheckDialogBinding2.tvNotSame.setText(getContext().getString(R.string.ble_pairList_snInput_error));
        PairCheckDialogBinding pairCheckDialogBinding3 = this.bind;
        if (pairCheckDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding3 = null;
        }
        pairCheckDialogBinding3.btnReselect.setText(getContext().getString(R.string.ble_pairList_snInput_repick));
        String string = getContext().getString(R.string.ble_pairList_snInput_scan);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getContext().getString(R.string.ble_pairList_snInput, new Object[]{string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CharSequence charSequence = string2;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(this.mContext.getColor(R.color.green_65)), indexOf$default, string.length() + indexOf$default, 33);
        spannableString.setSpan(new AbsoluteSizeSpan((int) DensityUtils.sp2px(16.0f)), indexOf$default, string.length() + indexOf$default, 33);
        spannableString.setSpan(new PairCheckDialog$build$1(this, getContext().getColor(R.color.green_65)), indexOf$default, string.length() + indexOf$default, 33);
        spannableStringBuilder.append(spannableString);
        PairCheckDialogBinding pairCheckDialogBinding4 = this.bind;
        if (pairCheckDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding4 = null;
        }
        pairCheckDialogBinding4.pairTips.setText(spannableStringBuilder);
        PairCheckDialogBinding pairCheckDialogBinding5 = this.bind;
        if (pairCheckDialogBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding5 = null;
        }
        pairCheckDialogBinding5.pairTips.setMovementMethod(LinkMovementMethod.getInstance());
        PairCheckDialogBinding pairCheckDialogBinding6 = this.bind;
        if (pairCheckDialogBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding6 = null;
        }
        pairCheckDialogBinding6.pairTips.setHighlightColor(0);
        PairCheckDialogBinding pairCheckDialogBinding7 = this.bind;
        if (pairCheckDialogBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding7 = null;
        }
        pairCheckDialogBinding7.btnReselect.setOnClickListener(new PairCheckDialog$$ExternalSyntheticLambda0(this));
        SnInputFilter snInputFilter = new SnInputFilter(bleControllerProxy.getSn().length());
        PairCheckDialogBinding pairCheckDialogBinding8 = this.bind;
        if (pairCheckDialogBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding8 = null;
        }
        pairCheckDialogBinding8.etVerCode.setFilters((InputFilter[]) new SnInputFilter[]{snInputFilter});
        snInputFilter.setOnInputComplete(new PairCheckDialog$build$3(this, bleControllerProxy));
        PairCheckDialogBinding pairCheckDialogBinding9 = this.bind;
        if (pairCheckDialogBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding9 = null;
        }
        pairCheckDialogBinding9.ivClosePairCheck.setOnClickListener(new PairCheckDialog$$ExternalSyntheticLambda1(this));
        PairCheckDialogBinding pairCheckDialogBinding10 = this.bind;
        if (pairCheckDialogBinding10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
        } else {
            pairCheckDialogBinding = pairCheckDialogBinding10;
        }
        setView(pairCheckDialogBinding.getRoot());
        setCanceledOnTouchOutside(false);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        LiveEventBus.get(EventBusKey.RESULT_SCAN, String.class).observe(this.mContext, new PairCheckDialog$$ExternalSyntheticLambda2(bleControllerProxy, this));
        return this;
    }

    /* access modifiers changed from: private */
    public static final void build$lambda$0(PairCheckDialog pairCheckDialog, View view) {
        Intrinsics.checkNotNullParameter(pairCheckDialog, "this$0");
        pairCheckDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void build$lambda$1(PairCheckDialog pairCheckDialog, View view) {
        Intrinsics.checkNotNullParameter(pairCheckDialog, "this$0");
        pairCheckDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void build$lambda$2(BleControllerProxy bleControllerProxy, PairCheckDialog pairCheckDialog, String str) {
        Intrinsics.checkNotNullParameter(bleControllerProxy, "$info");
        Intrinsics.checkNotNullParameter(pairCheckDialog, "this$0");
        if (StringsKt.equals(str, bleControllerProxy.getSn(), true)) {
            pairCheckDialog.dismiss();
            Function1<? super BleControllerProxy, Unit> function1 = pairCheckDialog.onPass;
            if (function1 != null) {
                function1.invoke(bleControllerProxy);
                return;
            }
            return;
        }
        PairCheckDialogBinding pairCheckDialogBinding = pairCheckDialog.bind;
        PairCheckDialogBinding pairCheckDialogBinding2 = null;
        if (pairCheckDialogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding = null;
        }
        ConstraintLayout constraintLayout = pairCheckDialogBinding.clReselect;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "clReselect");
        constraintLayout.setVisibility(0);
        PairCheckDialogBinding pairCheckDialogBinding3 = pairCheckDialog.bind;
        if (pairCheckDialogBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
            pairCheckDialogBinding3 = null;
        }
        TextView textView = pairCheckDialogBinding3.tvNotSame;
        Intrinsics.checkNotNullExpressionValue(textView, "tvNotSame");
        textView.setVisibility(0);
        PairCheckDialogBinding pairCheckDialogBinding4 = pairCheckDialog.bind;
        if (pairCheckDialogBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bind");
        } else {
            pairCheckDialogBinding2 = pairCheckDialogBinding4;
        }
        ImageView imageView = pairCheckDialogBinding2.ivClosePairCheck;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivClosePairCheck");
        imageView.setVisibility(8);
    }
}
