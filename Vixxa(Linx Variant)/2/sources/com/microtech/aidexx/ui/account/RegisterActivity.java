package com.microtech.aidexx.ui.account;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityRegisterBinding;
import com.microtech.aidexx.ui.main.MainActivity;
import com.microtech.aidexx.ui.welcome.guide.GuidanceActivity;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.ToastUtil;
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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u0006H\u0014J\u0012\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0015H\u0002¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/account/RegisterActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/ui/account/AccountViewModel;", "Lcom/microtech/aidexx/databinding/ActivityRegisterBinding;", "()V", "checkAndRegister", "", "getVerCode", "getViewBinding", "guide", "initEvent", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoginSuccess", "needToGuide", "", "register", "name", "", "verCode", "password", "sendRegisterEmailVerificationCode", "email", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RegisterActivity.kt */
public final class RegisterActivity extends BaseActivity<AccountViewModel, ActivityRegisterBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "RegisterActivity";

    public ActivityRegisterBinding getViewBinding() {
        ActivityRegisterBinding inflate = ActivityRegisterBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityRegisterBinding) getBinding()).getRoot());
        initView();
        initEvent();
    }

    private final void initView() {
        ActivityRegisterBinding activityRegisterBinding = (ActivityRegisterBinding) getBinding();
        activityRegisterBinding.txtUserProtocal.setText(StringUtils.initProtocol$default(StringUtils.INSTANCE, this, 2, (String) null, (String) null, 12, (Object) null));
        activityRegisterBinding.txtUserProtocal.setMovementMethod(LinkMovementMethod.getInstance());
        activityRegisterBinding.actionBar.getLeftIcon().setOnClickListener(new RegisterActivity$$ExternalSyntheticLambda1(this));
        activityRegisterBinding.btnGetCode.setOnClickListener(new RegisterActivity$$ExternalSyntheticLambda2(this));
        activityRegisterBinding.buttonRegist.setOnClickListener(new RegisterActivity$$ExternalSyntheticLambda3(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$0(RegisterActivity registerActivity, View view) {
        Intrinsics.checkNotNullParameter(registerActivity, "this$0");
        registerActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(RegisterActivity registerActivity, View view) {
        Intrinsics.checkNotNullParameter(registerActivity, "this$0");
        registerActivity.getVerCode();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(RegisterActivity registerActivity, View view) {
        Intrinsics.checkNotNullParameter(registerActivity, "this$0");
        registerActivity.checkAndRegister();
    }

    private final void initEvent() {
        ((AccountViewModel) getViewModel()).getTimeLeft().observe(this, new RegisterActivity$sam$androidx_lifecycle_Observer$0(new RegisterActivity$initEvent$1(this)));
    }

    private final void getVerCode() {
        String obj = StringsKt.trim((CharSequence) String.valueOf(((ActivityRegisterBinding) getBinding()).etUsername.getText())).toString();
        CharSequence charSequence = obj;
        if (charSequence.length() == 0) {
            String string = getString(R.string.user_sign_toast_emailEmpty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else if (!StringUtils.INSTANCE.checkEmail(obj) || StringsKt.indexOf$default(charSequence, " ", 0, false, 6, (Object) null) != -1) {
            String string2 = getString(R.string.user_sign_toast_emailError);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        } else if (Intrinsics.areEqual((Object) getString(R.string.user_sign_getCode), (Object) ((ActivityRegisterBinding) getBinding()).btnGetCode.getText())) {
            sendRegisterEmailVerificationCode(obj);
        } else {
            new StandardDialog.Setter(this).content(getString(R.string.user_sign_getCode_retryTip)).confirmBtnText(getString(R.string.com_action_ok)).setPositive(new RegisterActivity$$ExternalSyntheticLambda0(this, obj)).create().show();
        }
    }

    /* access modifiers changed from: private */
    public static final void getVerCode$lambda$4(RegisterActivity registerActivity, String str, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(registerActivity, "this$0");
        Intrinsics.checkNotNullParameter(str, "$user");
        dialogInterface.dismiss();
        registerActivity.sendRegisterEmailVerificationCode(str);
    }

    private final void sendRegisterEmailVerificationCode(String str) {
        Dialogs.INSTANCE.showWait(getString(R.string.com_loading));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new RegisterActivity$sendRegisterEmailVerificationCode$1(this, str, (Continuation<? super RegisterActivity$sendRegisterEmailVerificationCode$1>) null), 3, (Object) null);
    }

    private final void checkAndRegister() {
        String obj = StringsKt.trim((CharSequence) String.valueOf(((ActivityRegisterBinding) getBinding()).etUsername.getText())).toString();
        String obj2 = StringsKt.trim((CharSequence) String.valueOf(((ActivityRegisterBinding) getBinding()).etPwd.getText())).toString();
        String obj3 = StringsKt.trim((CharSequence) String.valueOf(((ActivityRegisterBinding) getBinding()).etPwdConfirm.getText())).toString();
        String obj4 = StringsKt.trim((CharSequence) String.valueOf(((ActivityRegisterBinding) getBinding()).etCode.getText())).toString();
        if (obj.length() == 0) {
            String string = getString(R.string.user_sign_toast_emailEmpty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toastShort(string);
        } else if (obj4.length() == 0) {
            String string2 = getString(R.string.user_sign_toast_codeEmpty);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toastShort(string2);
        } else if (obj2.length() == 0) {
            Dialogs.showMessage$default(Dialogs.INSTANCE, this, (String) null, getString(R.string.user_sign_toast_pwdEmpty), (String) null, (String) null, (Function0) null, 58, (Object) null);
        } else if (!StringUtils.INSTANCE.checkPwd(obj2)) {
            Dialogs.showMessage$default(Dialogs.INSTANCE, this, (String) null, getString(R.string.user_sign_toast_pwdFormat), (String) null, (String) null, (Function0) null, 58, (Object) null);
        } else if (!Intrinsics.areEqual((Object) obj2, (Object) obj3)) {
            Dialogs.showMessage$default(Dialogs.INSTANCE, this, (String) null, getString(R.string.user_sign_toast_repwdError), (String) null, (String) null, (Function0) null, 58, (Object) null);
        } else if (!StringUtils.INSTANCE.checkEmail(obj)) {
            Dialogs.showMessage$default(Dialogs.INSTANCE, this, (String) null, getString(R.string.user_sign_toast_emailError), (String) null, (String) null, (Function0) null, 58, (Object) null);
        } else if (!((ActivityRegisterBinding) getBinding()).checkProtocal.isChecked()) {
            Dialogs.showMessage$default(Dialogs.INSTANCE, this, (String) null, getString(R.string.user_sign_toast_agreementError), (String) null, (String) null, (Function0) null, 58, (Object) null);
        } else {
            register(obj, obj4, obj2);
        }
    }

    private final void register(String str, String str2, String str3) {
        if (!NetUtil.isNetAvailable(this)) {
            ToastUtil toastUtil = ToastUtil.INSTANCE;
            String string = getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toastUtil.showShort(string);
            return;
        }
        Dialogs.INSTANCE.showWait(getString(R.string.com_actionState_doing, new Object[]{getString(R.string.com_action_login)}));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new RegisterActivity$register$1(this, str, str3, str2, (Continuation<? super RegisterActivity$register$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void guide() {
        ThemeManager.INSTANCE.applyDayNight();
        startActivity(new Intent(this, GuidanceActivity.class));
        finish();
    }

    static /* synthetic */ void onLoginSuccess$default(RegisterActivity registerActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        registerActivity.onLoginSuccess(z);
    }

    private final void onLoginSuccess(boolean z) {
        ThemeManager.INSTANCE.applyDayNight();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/account/RegisterActivity$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: RegisterActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((AccountViewModel) getViewModel()).getTimeLeft().removeObservers(this);
    }
}
