package com.microtech.aidexx.ui.account;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.LoginType;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.databinding.ActivityLoginEmailBinding;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.main.MainActivity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.welcome.guide.GuidanceActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.EncryptUtils;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.ToastUtil;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\u0003H\u0016J\b\u0010\r\u001a\u00020\u000bH\u0002J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0017\u001a\u00020\u0006H\u0002J\b\u0010\u0018\u001a\u00020\u000bH\u0014J\b\u0010\u0019\u001a\u00020\u000bH\u0002¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/account/LoginActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/ui/account/AccountViewModel;", "Lcom/microtech/aidexx/databinding/ActivityLoginEmailBinding;", "()V", "checkAccount", "", "account", "", "needTip", "checkLoginInfo", "", "getViewBinding", "guide", "login", "name", "password", "type", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onLoginSuccess", "needToGuide", "onResume", "toMain", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LoginActivity.kt */
public final class LoginActivity extends BaseActivity<AccountViewModel, ActivityLoginEmailBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "LoginActivity";

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityLoginEmailBinding) getBinding()).getRoot());
        ((ActivityLoginEmailBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new LoginActivity$$ExternalSyntheticLambda0(this));
        ((ActivityLoginEmailBinding) getBinding()).buttonLogin.setOnClickListener(new LoginActivity$$ExternalSyntheticLambda1(this));
        ((ActivityLoginEmailBinding) getBinding()).tvForget.setOnClickListener(new LoginActivity$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$0(LoginActivity loginActivity, View view) {
        Intrinsics.checkNotNullParameter(loginActivity, "this$0");
        loginActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$1(LoginActivity loginActivity, View view) {
        Intrinsics.checkNotNullParameter(loginActivity, "this$0");
        loginActivity.checkLoginInfo();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$3(LoginActivity loginActivity, View view) {
        Intrinsics.checkNotNullParameter(loginActivity, "this$0");
        String obj = StringsKt.trim((CharSequence) String.valueOf(((ActivityLoginEmailBinding) loginActivity.getBinding()).etUsername.getText())).toString();
        if (!loginActivity.checkAccount(obj, false)) {
            obj = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString(ForgetPwdActivity.EXTRA_ACCOUNT, obj);
        Unit unit = Unit.INSTANCE;
        ActivityUtil.INSTANCE.toActivity((Context) loginActivity, bundle, (Class<?>) ForgetPwdActivity.class);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= 33 && ActivityCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            PermissionsUtil.requestPermissions$default(PermissionsUtil.INSTANCE, this, new String[]{"android.permission.POST_NOTIFICATIONS"}, (Function0) null, 4, (Object) null);
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginActivity$onResume$1(this, (Continuation<? super LoginActivity$onResume$1>) null), 3, (Object) null);
    }

    public ActivityLoginEmailBinding getViewBinding() {
        ActivityLoginEmailBinding inflate = ActivityLoginEmailBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    static /* synthetic */ boolean checkAccount$default(LoginActivity loginActivity, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return loginActivity.checkAccount(str, z);
    }

    private final boolean checkAccount(String str, boolean z) {
        if (str.length() == 0) {
            if (z) {
                String string = getString(R.string.user_sign_toast_emailEmpty);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
            }
            return false;
        } else if (StringUtils.INSTANCE.checkEmail(str)) {
            return true;
        } else {
            if (z) {
                String string2 = getString(R.string.user_sign_toast_emailError);
                Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                ExtendsKt.toast(string2);
            }
            return false;
        }
    }

    private final void checkLoginInfo() {
        String obj = StringsKt.trim((CharSequence) String.valueOf(((ActivityLoginEmailBinding) getBinding()).etUsername.getText())).toString();
        String obj2 = StringsKt.trim((CharSequence) String.valueOf(((ActivityLoginEmailBinding) getBinding()).etPwd.getText())).toString();
        if (checkAccount$default(this, obj, false, 2, (Object) null)) {
            if (obj2.length() == 0) {
                String string = getString(R.string.user_sign_toast_pwdEmpty);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
                return;
            }
            login(obj, EncryptUtils.Companion.md5(obj2), 2);
        }
    }

    private final void login(String str, String str2, @LoginType int i) {
        if (!NetUtil.isNetAvailable(this)) {
            ToastUtil toastUtil = ToastUtil.INSTANCE;
            String string = getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            toastUtil.showShort(string);
            return;
        }
        Dialogs.INSTANCE.showWait(getString(R.string.com_actionState_doing, new Object[]{getString(R.string.com_action_login)}));
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginActivity$login$1(this, str, str2, i, (Continuation<? super LoginActivity$login$1>) null), 3, (Object) null);
    }

    static /* synthetic */ void onLoginSuccess$default(LoginActivity loginActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        loginActivity.onLoginSuccess(z);
    }

    /* access modifiers changed from: private */
    public final void onLoginSuccess(boolean z) {
        String language;
        String curLanguageTag = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        if (!(settingEntity == null || (language = settingEntity.getLanguage()) == null)) {
            if (!Intrinsics.areEqual((Object) curLanguageTag, (Object) language)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new LoginActivity$onLoginSuccess$1$1(curLanguageTag, z, this, language, (Continuation<? super LoginActivity$onLoginSuccess$1$1>) null), 3, (Object) null);
                return;
            } else if (Intrinsics.areEqual((Object) language, (Object) "ar")) {
                LanguageResourceManager.INSTANCE.setAppLocale(LanguageResourceManager.INSTANCE.getCurLanguageTag());
            }
        }
        if (z) {
            guide();
        } else {
            toMain();
        }
    }

    /* access modifiers changed from: private */
    public final void toMain() {
        ThemeManager.INSTANCE.applyDayNight();
        startActivity(new Intent(this, MainActivity.class));
        ActivityUtil.INSTANCE.finishToMain();
    }

    /* access modifiers changed from: private */
    public final void guide() {
        ThemeManager.INSTANCE.applyDayNight();
        startActivity(new Intent(this, GuidanceActivity.class));
        ActivityUtil.INSTANCE.finishToMain();
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/account/LoginActivity$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LoginActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
