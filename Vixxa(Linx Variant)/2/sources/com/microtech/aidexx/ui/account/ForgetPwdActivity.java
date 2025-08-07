package com.microtech.aidexx.ui.account;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityForgetPwdBinding;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\rH\u0002J\u0012\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/ui/account/ForgetPwdActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/ui/account/AccountViewModel;", "Lcom/microtech/aidexx/databinding/ActivityForgetPwdBinding;", "()V", "needMaskedAccount", "", "oldAccount", "", "checkAccount", "account", "getAccount", "getChangePWDVerifyCode", "", "email", "getVerCode", "getViewBinding", "initGpView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ForgetPwdActivity.kt */
public final class ForgetPwdActivity extends BaseActivity<AccountViewModel, ActivityForgetPwdBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_ACCOUNT = "EXTRA_ACCOUNT";
    public static final String EXTRA_ACCOUNT_MASKED = "EXTRA_NEED_MASKED";
    private boolean needMaskedAccount;
    private String oldAccount = "";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/account/ForgetPwdActivity$Companion;", "", "()V", "EXTRA_ACCOUNT", "", "EXTRA_ACCOUNT_MASKED", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ForgetPwdActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ActivityForgetPwdBinding getViewBinding() {
        ActivityForgetPwdBinding inflate = ActivityForgetPwdBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityForgetPwdBinding) getBinding()).getRoot());
        initGpView();
        ActivityForgetPwdBinding activityForgetPwdBinding = (ActivityForgetPwdBinding) getBinding();
        activityForgetPwdBinding.actionBar.getLeftIcon().setOnClickListener(new ForgetPwdActivity$$ExternalSyntheticLambda1(this));
        activityForgetPwdBinding.btnGetCode.setOnClickListener(new ForgetPwdActivity$$ExternalSyntheticLambda2(this));
        String stringExtra = getIntent().getStringExtra(EXTRA_ACCOUNT);
        if (stringExtra != null) {
            Intrinsics.checkNotNull(stringExtra);
            this.oldAccount = stringExtra;
            boolean booleanExtra = getIntent().getBooleanExtra(EXTRA_ACCOUNT_MASKED, false);
            this.needMaskedAccount = booleanExtra;
            if (booleanExtra) {
                activityForgetPwdBinding.etUsername.setClickable(false);
                activityForgetPwdBinding.etUsername.setFocusable(false);
            }
            AppCompatEditText appCompatEditText = activityForgetPwdBinding.etUsername;
            if (this.needMaskedAccount) {
                stringExtra = StringUtils.INSTANCE.getMaskedEmail(stringExtra);
            }
            appCompatEditText.setText(stringExtra);
        }
        ((AccountViewModel) getViewModel()).getTimeLeft().observe(this, new ForgetPwdActivity$sam$androidx_lifecycle_Observer$0(new ForgetPwdActivity$onCreate$1$4(activityForgetPwdBinding, this)));
        ((ActivityForgetPwdBinding) getBinding()).buttonRegist.setOnClickListener(new ForgetPwdActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$0(ForgetPwdActivity forgetPwdActivity, View view) {
        Intrinsics.checkNotNullParameter(forgetPwdActivity, "this$0");
        forgetPwdActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3$lambda$1(ForgetPwdActivity forgetPwdActivity, View view) {
        Intrinsics.checkNotNullParameter(forgetPwdActivity, "this$0");
        forgetPwdActivity.getVerCode();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$4(ForgetPwdActivity forgetPwdActivity, View view) {
        Intrinsics.checkNotNullParameter(forgetPwdActivity, "this$0");
        String account = forgetPwdActivity.getAccount();
        String valueOf = String.valueOf(((ActivityForgetPwdBinding) forgetPwdActivity.getBinding()).etPwd.getText());
        String valueOf2 = String.valueOf(((ActivityForgetPwdBinding) forgetPwdActivity.getBinding()).etPwdConfirm.getText());
        String valueOf3 = String.valueOf(((ActivityForgetPwdBinding) forgetPwdActivity.getBinding()).etCode.getText());
        if (forgetPwdActivity.checkAccount(account)) {
            if (valueOf3.length() == 0) {
                String string = forgetPwdActivity.getString(R.string.user_sign_toast_codeEmpty);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
            } else if (valueOf.length() == 0) {
                Dialogs.showMessage$default(Dialogs.INSTANCE, forgetPwdActivity, (String) null, forgetPwdActivity.getResources().getString(R.string.user_sign_toast_pwdEmpty), (String) null, (String) null, (Function0) null, 58, (Object) null);
            } else if (!StringUtils.INSTANCE.checkPwd(valueOf)) {
                Dialogs.showMessage$default(Dialogs.INSTANCE, forgetPwdActivity, (String) null, forgetPwdActivity.getResources().getString(R.string.user_sign_toast_pwdFormat), (String) null, (String) null, (Function0) null, 58, (Object) null);
            } else if (!Intrinsics.areEqual((Object) valueOf, (Object) valueOf2)) {
                Dialogs.showMessage$default(Dialogs.INSTANCE, forgetPwdActivity, (String) null, forgetPwdActivity.getResources().getString(R.string.user_sign_toast_repwdError), (String) null, (String) null, (Function0) null, 58, (Object) null);
            } else {
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(forgetPwdActivity), (CoroutineContext) null, (CoroutineStart) null, new ForgetPwdActivity$onCreate$2$1(forgetPwdActivity, account, valueOf, valueOf3, (Continuation<? super ForgetPwdActivity$onCreate$2$1>) null), 3, (Object) null);
            }
        }
    }

    private final void initGpView() {
        ActivityForgetPwdBinding activityForgetPwdBinding = (ActivityForgetPwdBinding) getBinding();
        activityForgetPwdBinding.etUsername.setHint(getString(R.string.user_email));
        activityForgetPwdBinding.etUsername.setCompoundDrawablesRelativeWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_fun_5), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    private final void getVerCode() {
        String account = getAccount();
        if (checkAccount(account)) {
            if (Intrinsics.areEqual((Object) getString(R.string.user_sign_getCode), (Object) ((ActivityForgetPwdBinding) getBinding()).btnGetCode.getText())) {
                getChangePWDVerifyCode(account);
            } else {
                new StandardDialog.Setter(this).content(getString(R.string.user_sign_getCode_retryTip)).confirmBtnText(getString(R.string.com_action_ok)).setPositive(new ForgetPwdActivity$$ExternalSyntheticLambda0(this, account)).create().show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void getVerCode$lambda$6(ForgetPwdActivity forgetPwdActivity, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(forgetPwdActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$email");
        dialogInterface.dismiss();
        forgetPwdActivity.getChangePWDVerifyCode(str);
    }

    private final void getChangePWDVerifyCode(String str) {
        Dialogs.INSTANCE.showWait(getString(R.string.com_loading));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ForgetPwdActivity$getChangePWDVerifyCode$1(this, str, (Continuation<? super ForgetPwdActivity$getChangePWDVerifyCode$1>) null), 3, (Object) null);
    }

    private final String getAccount() {
        if (this.needMaskedAccount) {
            return this.oldAccount;
        }
        return StringsKt.trim((CharSequence) String.valueOf(((ActivityForgetPwdBinding) getBinding()).etUsername.getText())).toString();
    }

    private final boolean checkAccount(String str) {
        if (str.length() == 0) {
            String string = getString(R.string.user_sign_toast_emailEmpty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
            return false;
        } else if (StringUtils.INSTANCE.checkEmail(str)) {
            return true;
        } else {
            String string2 = getString(R.string.user_sign_toast_emailError);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
            return false;
        }
    }
}
