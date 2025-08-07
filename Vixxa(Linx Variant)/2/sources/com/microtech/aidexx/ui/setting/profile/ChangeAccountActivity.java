package com.microtech.aidexx.ui.setting.profile;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityChangeAccountBinding;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.views.button.StateButton;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0002J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0010H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0018"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/ChangeAccountActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityChangeAccountBinding;", "()V", "pVm", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "getPVm", "()Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "pVm$delegate", "Lkotlin/Lazy;", "checkAccount", "", "account", "", "doIt", "", "getViewBinding", "initView", "logout", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "sendVCode", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChangeAccountActivity.kt */
public final class ChangeAccountActivity extends BaseActivity<BaseViewModel, ActivityChangeAccountBinding> {
    private final Lazy pVm$delegate;

    public ChangeAccountActivity() {
        ComponentActivity componentActivity = this;
        this.pVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new ChangeAccountActivity$special$$inlined$viewModels$default$2(componentActivity), new ChangeAccountActivity$special$$inlined$viewModels$default$1(componentActivity), new ChangeAccountActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ProfileViewModel getPVm() {
        return (ProfileViewModel) this.pVm$delegate.getValue();
    }

    public ActivityChangeAccountBinding getViewBinding() {
        ActivityChangeAccountBinding inflate = ActivityChangeAccountBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityChangeAccountBinding) getBinding()).getRoot());
        initView();
    }

    private final void initView() {
        ActivityChangeAccountBinding activityChangeAccountBinding = (ActivityChangeAccountBinding) getBinding();
        activityChangeAccountBinding.etUsername.setHint(getString(R.string.com_inputHint, new Object[]{getString(R.string.user_phone)}));
        activityChangeAccountBinding.etCode.setHint(getString(R.string.com_inputHint, new Object[]{getString(R.string.user_getCode)}));
        ExtendsKt.setDebounceClickListener$default(activityChangeAccountBinding.actionBar.getLeftIcon(), 0, new ChangeAccountActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        TextView textView = activityChangeAccountBinding.btnGetCode;
        Intrinsics.checkNotNullExpressionValue(textView, "btnGetCode");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new ChangeAccountActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
        StateButton stateButton = activityChangeAccountBinding.btnSure;
        Intrinsics.checkNotNullExpressionValue(stateButton, "btnSure");
        ExtendsKt.setDebounceClickListener$default(stateButton, 0, new ChangeAccountActivity$$ExternalSyntheticLambda2(this), 1, (Object) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChangeAccountActivity$initView$1$4(this, activityChangeAccountBinding, (Continuation<? super ChangeAccountActivity$initView$1$4>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$0(ChangeAccountActivity changeAccountActivity, View view) {
        Intrinsics.checkNotNullParameter(changeAccountActivity, "this$0");
        changeAccountActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$1(ChangeAccountActivity changeAccountActivity, View view) {
        Intrinsics.checkNotNullParameter(changeAccountActivity, "this$0");
        changeAccountActivity.sendVCode();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3$lambda$2(ChangeAccountActivity changeAccountActivity, View view) {
        Intrinsics.checkNotNullParameter(changeAccountActivity, "this$0");
        changeAccountActivity.doIt();
    }

    private final void sendVCode() {
        String obj = StringsKt.trim((CharSequence) String.valueOf(((ActivityChangeAccountBinding) getBinding()).etUsername.getText())).toString();
        if (checkAccount(obj)) {
            Dialogs.INSTANCE.showWait(getString(R.string.com_loading));
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChangeAccountActivity$sendVCode$1(this, obj, (Continuation<? super ChangeAccountActivity$sendVCode$1>) null), 3, (Object) null);
        }
    }

    private final boolean checkAccount(String str) {
        if (str.length() == 0) {
            String string = getString(R.string.user_sign_toast_phoneEmpty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
            return false;
        } else if (StringUtils.INSTANCE.checkPhoneNumber(str)) {
            return true;
        } else {
            String string2 = getString(R.string.user_sign_toast_phoneError);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
            return false;
        }
    }

    private final void doIt() {
        String obj = StringsKt.trim((CharSequence) String.valueOf(((ActivityChangeAccountBinding) getBinding()).etUsername.getText())).toString();
        String obj2 = StringsKt.trim((CharSequence) String.valueOf(((ActivityChangeAccountBinding) getBinding()).etCode.getText())).toString();
        if (obj.length() == 0) {
            String string = getString(R.string.user_sign_toast_phoneEmpty);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else if (!StringUtils.INSTANCE.checkPhoneNumber(obj) || !StringUtils.INSTANCE.checkVerCode(obj2)) {
            String string2 = getString(R.string.user_sign_toast_phoneCodeError);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        } else if (!NetUtil.isNetAvailable(this)) {
            String string3 = getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            ExtendsKt.toast(string3);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChangeAccountActivity$doIt$1(this, obj, obj2, (Continuation<? super ChangeAccountActivity$doIt$1>) null), 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void logout() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), (CoroutineStart) null, new ChangeAccountActivity$logout$1(this, (Continuation<? super ChangeAccountActivity$logout$1>) null), 2, (Object) null);
    }
}
