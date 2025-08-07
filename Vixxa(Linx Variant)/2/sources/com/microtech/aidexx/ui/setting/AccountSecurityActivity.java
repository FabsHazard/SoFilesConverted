package com.microtech.aidexx.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityOtherSettingBinding;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.account.ForgetPwdActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.EncryptUtils;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.views.SettingItemWidget;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.standard.StandardInputDialog;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ui/setting/AccountSecurityActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityOtherSettingBinding;", "()V", "getViewBinding", "logout", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccountSecurityActivity.kt */
public final class AccountSecurityActivity extends BaseActivity<BaseViewModel, ActivityOtherSettingBinding> {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityOtherSettingBinding) getBinding()).getRoot());
        ActivityOtherSettingBinding activityOtherSettingBinding = (ActivityOtherSettingBinding) getBinding();
        activityOtherSettingBinding.actionBarOtherSetting.getLeftIcon().setOnClickListener(new AccountSecurityActivity$$ExternalSyntheticLambda2(this));
        SettingItemWidget settingItemWidget = activityOtherSettingBinding.settingLogout;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "settingLogout");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget, 0, new AccountSecurityActivity$$ExternalSyntheticLambda3(this), 1, (Object) null);
        SettingItemWidget settingItemWidget2 = activityOtherSettingBinding.settingResetPwd;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget2, "settingResetPwd");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget2, 0, new AccountSecurityActivity$$ExternalSyntheticLambda4(this), 1, (Object) null);
        SettingItemWidget settingItemWidget3 = activityOtherSettingBinding.settingCancelAccount;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget3, "settingCancelAccount");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget3, 0, new AccountSecurityActivity$$ExternalSyntheticLambda5(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$0(AccountSecurityActivity accountSecurityActivity, View view) {
        Intrinsics.checkNotNullParameter(accountSecurityActivity, "this$0");
        accountSecurityActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$1(AccountSecurityActivity accountSecurityActivity, View view) {
        Intrinsics.checkNotNullParameter(accountSecurityActivity, "this$0");
        Dialogs.showWhether$default(Dialogs.INSTANCE, accountSecurityActivity, (String) null, accountSecurityActivity.getString(R.string.user_sign_logout_info), new AccountSecurityActivity$onCreate$1$2$1(accountSecurityActivity), (Function0) null, (String) null, accountSecurityActivity.getString(R.string.user_sign_logout), (String) null, 1, 178, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$3(AccountSecurityActivity accountSecurityActivity, View view) {
        String str;
        UserEntity userEntity;
        UserEntity userEntity2;
        Intrinsics.checkNotNullParameter(accountSecurityActivity, "this$0");
        String str2 = "";
        if (!ExtendsKt.isGp() ? !((userEntity = UserInfoManager.Companion.instance().getUserEntity()) == null || (str = userEntity.getPhone()) == null) : !((userEntity2 = UserInfoManager.Companion.instance().getUserEntity()) == null || (str = userEntity2.getEmail()) == null)) {
            str2 = str;
        }
        Bundle bundle = new Bundle();
        bundle.putString(ForgetPwdActivity.EXTRA_ACCOUNT, str2);
        bundle.putBoolean(ForgetPwdActivity.EXTRA_ACCOUNT_MASKED, true);
        Unit unit = Unit.INSTANCE;
        ActivityUtil.INSTANCE.toActivity((Context) accountSecurityActivity, bundle, (Class<?>) ForgetPwdActivity.class);
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$6(AccountSecurityActivity accountSecurityActivity, View view) {
        Intrinsics.checkNotNullParameter(accountSecurityActivity, "this$0");
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel == null || !deviceModel.isPaired()) {
            new StandardInputDialog.Setter(accountSecurityActivity).title(accountSecurityActivity.getString(R.string.user_sign_logoff_info)).setPositive(new AccountSecurityActivity$$ExternalSyntheticLambda0(accountSecurityActivity)).setCancel(new AccountSecurityActivity$$ExternalSyntheticLambda1()).create().show();
        } else {
            Dialogs.showWhether$default(Dialogs.INSTANCE, accountSecurityActivity, (String) null, accountSecurityActivity.getString(R.string.user_sign_logoff_unpairFirst), new AccountSecurityActivity$onCreate$1$4$1(accountSecurityActivity), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$6$lambda$4(AccountSecurityActivity accountSecurityActivity, DialogInterface dialogInterface, int i, String str) {
        Intrinsics.checkNotNullParameter(accountSecurityActivity, "this$0");
        CharSequence charSequence = str;
        if (charSequence != null && charSequence.length() != 0) {
            dialogInterface.dismiss();
            WaitDialog.show((CharSequence) accountSecurityActivity.getString(R.string.com_loading));
            if (NetUtil.isNetAvailable(accountSecurityActivity)) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(accountSecurityActivity), Dispatchers.getIO(), (CoroutineStart) null, new AccountSecurityActivity$onCreate$1$4$2$1(MapsKt.mutableMapOf(TuplesKt.to("password", EncryptUtils.Companion.md5(str))), accountSecurityActivity, (Continuation<? super AccountSecurityActivity$onCreate$1$4$2$1>) null), 2, (Object) null);
                return;
            }
            WaitDialog.dismiss();
            String string = accountSecurityActivity.getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toastShort(string);
        }
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$7$lambda$6$lambda$5(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void logout() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new AccountSecurityActivity$logout$1(this, (Continuation<? super AccountSecurityActivity$logout$1>) null), 2, (Object) null);
    }

    public ActivityOtherSettingBinding getViewBinding() {
        ActivityOtherSettingBinding inflate = ActivityOtherSettingBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
