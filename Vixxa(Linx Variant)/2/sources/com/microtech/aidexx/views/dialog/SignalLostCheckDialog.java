package com.microtech.aidexx.views.dialog;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.SignalLostCheckDialogBinding;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\n\u001a\u00020\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/views/dialog/SignalLostCheckDialog;", "Landroidx/appcompat/app/AlertDialog;", "context", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "themeResId", "", "(Landroidx/appcompat/app/AppCompatActivity;I)V", "mContext", "signalLostCheckStep", "build", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SignalLostCheckDialog.kt */
public final class SignalLostCheckDialog extends AlertDialog {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static SignalLostCheckDialog INSTANCE;
    private AppCompatActivity mContext;
    private int signalLostCheckStep;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SignalLostCheckDialog(AppCompatActivity appCompatActivity) {
        this(appCompatActivity, 0);
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SignalLostCheckDialog(AppCompatActivity appCompatActivity, int i) {
        super(appCompatActivity, i);
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        this.mContext = appCompatActivity;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/microtech/aidexx/views/dialog/SignalLostCheckDialog$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/views/dialog/SignalLostCheckDialog;", "dismiss", "", "instance", "context", "Landroidx/appcompat/app/AppCompatActivity;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: SignalLostCheckDialog.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized SignalLostCheckDialog instance(AppCompatActivity appCompatActivity) {
            SignalLostCheckDialog access$getINSTANCE$cp;
            Intrinsics.checkNotNullParameter(appCompatActivity, "context");
            if (SignalLostCheckDialog.INSTANCE == null) {
                SignalLostCheckDialog.INSTANCE = new SignalLostCheckDialog(appCompatActivity).build();
            }
            access$getINSTANCE$cp = SignalLostCheckDialog.INSTANCE;
            Intrinsics.checkNotNull(access$getINSTANCE$cp);
            return access$getINSTANCE$cp;
        }

        public final void dismiss() {
            SignalLostCheckDialog access$getINSTANCE$cp;
            SignalLostCheckDialog access$getINSTANCE$cp2 = SignalLostCheckDialog.INSTANCE;
            if (access$getINSTANCE$cp2 != null && access$getINSTANCE$cp2.isShowing() && (access$getINSTANCE$cp = SignalLostCheckDialog.INSTANCE) != null) {
                access$getINSTANCE$cp.dismiss();
            }
        }
    }

    public final SignalLostCheckDialog build() {
        setCancelable(false);
        SignalLostCheckDialogBinding bind = SignalLostCheckDialogBinding.bind(LayoutInflater.from(this.mContext).inflate(R.layout.signal_lost_check_dialog, (ViewGroup) null));
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        bind.content.setText(this.mContext.getString(R.string.user_warning_signalLost_alert_check));
        bind.buttonConfirm.setText(this.mContext.getString(R.string.user_warning_signalLost_action_using));
        bind.buttonCancel.setText(this.mContext.getString(R.string.user_warning_signalLost_action_remove));
        bind.buttonConfirm.setOnClickListener(new SignalLostCheckDialog$$ExternalSyntheticLambda0(this, bind));
        bind.buttonCancel.setOnClickListener(new SignalLostCheckDialog$$ExternalSyntheticLambda1(this, bind));
        setView(bind.getRoot());
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(17170445);
        }
        this.mContext.getLifecycle().addObserver(new SignalLostCheckDialog$build$3(this));
        setOnDismissListener(new SignalLostCheckDialog$$ExternalSyntheticLambda2(this, bind));
        return this;
    }

    /* access modifiers changed from: private */
    public static final void build$lambda$0(SignalLostCheckDialog signalLostCheckDialog, SignalLostCheckDialogBinding signalLostCheckDialogBinding, View view) {
        Intrinsics.checkNotNullParameter(signalLostCheckDialog, "this$0");
        Intrinsics.checkNotNullParameter(signalLostCheckDialogBinding, "$viewBind");
        int i = signalLostCheckDialog.signalLostCheckStep;
        if (i == 0) {
            signalLostCheckDialogBinding.content.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_alert_reuse));
            signalLostCheckDialogBinding.buttonConfirm.setText(signalLostCheckDialog.mContext.getString(R.string.com_action_sure));
            View view2 = signalLostCheckDialogBinding.dialogDivider;
            Intrinsics.checkNotNullExpressionValue(view2, "dialogDivider");
            view2.setVisibility(8);
            TextView textView = signalLostCheckDialogBinding.buttonCancel;
            Intrinsics.checkNotNullExpressionValue(textView, "buttonCancel");
            textView.setVisibility(8);
            signalLostCheckDialog.signalLostCheckStep = 1;
        } else if (i == 1) {
            signalLostCheckDialog.dismiss();
        } else if (i == 11) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(signalLostCheckDialog), (CoroutineContext) null, (CoroutineStart) null, new SignalLostCheckDialog$build$1$1(signalLostCheckDialog, (Continuation<? super SignalLostCheckDialog$build$1$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void build$lambda$1(SignalLostCheckDialog signalLostCheckDialog, SignalLostCheckDialogBinding signalLostCheckDialogBinding, View view) {
        Intrinsics.checkNotNullParameter(signalLostCheckDialog, "this$0");
        Intrinsics.checkNotNullParameter(signalLostCheckDialogBinding, "$viewBind");
        int i = signalLostCheckDialog.signalLostCheckStep;
        if (i == 0) {
            signalLostCheckDialogBinding.content.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_alert_checkRemove));
            signalLostCheckDialogBinding.buttonConfirm.setText(signalLostCheckDialog.mContext.getString(R.string.com_action_sure));
            signalLostCheckDialogBinding.buttonCancel.setText(signalLostCheckDialog.mContext.getString(R.string.com_action_cancel));
            signalLostCheckDialog.signalLostCheckStep = 11;
        } else if (i == 11) {
            signalLostCheckDialogBinding.content.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_alert_check));
            signalLostCheckDialogBinding.buttonConfirm.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_action_using));
            signalLostCheckDialogBinding.buttonCancel.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_action_remove));
            signalLostCheckDialog.signalLostCheckStep = 0;
        }
    }

    /* access modifiers changed from: private */
    public static final void build$lambda$2(SignalLostCheckDialog signalLostCheckDialog, SignalLostCheckDialogBinding signalLostCheckDialogBinding, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(signalLostCheckDialog, "this$0");
        Intrinsics.checkNotNullParameter(signalLostCheckDialogBinding, "$viewBind");
        signalLostCheckDialog.signalLostCheckStep = 0;
        signalLostCheckDialogBinding.content.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_alert_check));
        signalLostCheckDialogBinding.buttonConfirm.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_action_using));
        signalLostCheckDialogBinding.buttonCancel.setText(signalLostCheckDialog.mContext.getString(R.string.user_warning_signalLost_action_remove));
        View view = signalLostCheckDialogBinding.dialogDivider;
        Intrinsics.checkNotNullExpressionValue(view, "dialogDivider");
        view.setVisibility(0);
        TextView textView = signalLostCheckDialogBinding.buttonCancel;
        Intrinsics.checkNotNullExpressionValue(textView, "buttonCancel");
        textView.setVisibility(0);
    }
}
