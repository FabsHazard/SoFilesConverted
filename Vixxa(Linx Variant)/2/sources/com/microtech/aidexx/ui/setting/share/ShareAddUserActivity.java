package com.microtech.aidexx.ui.setting.share;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityShareAddUserBinding;
import com.microtech.aidexx.utils.NetUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareAddUserActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityShareAddUserBinding;", "()V", "sfViewModel", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "getSfViewModel", "()Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "sfViewModel$delegate", "Lkotlin/Lazy;", "getViewBinding", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareAddUserActivity.kt */
public final class ShareAddUserActivity extends BaseActivity<BaseViewModel, ActivityShareAddUserBinding> {
    private final Lazy sfViewModel$delegate;

    public ShareAddUserActivity() {
        ComponentActivity componentActivity = this;
        this.sfViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ShareFollowViewModel.class), new ShareAddUserActivity$special$$inlined$viewModels$default$2(componentActivity), new ShareAddUserActivity$special$$inlined$viewModels$default$1(componentActivity), new ShareAddUserActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ShareFollowViewModel getSfViewModel() {
        return (ShareFollowViewModel) this.sfViewModel$delegate.getValue();
    }

    public ActivityShareAddUserBinding getViewBinding() {
        ActivityShareAddUserBinding inflate = ActivityShareAddUserBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityShareAddUserBinding) getBinding()).getRoot());
        ActivityShareAddUserBinding activityShareAddUserBinding = (ActivityShareAddUserBinding) getBinding();
        activityShareAddUserBinding.actionBar.getLeftIcon().setOnClickListener(new ShareAddUserActivity$$ExternalSyntheticLambda0(this));
        activityShareAddUserBinding.btnAddShareSave.setOnClickListener(new ShareAddUserActivity$$ExternalSyntheticLambda1(activityShareAddUserBinding, this));
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(ShareAddUserActivity shareAddUserActivity, View view) {
        Intrinsics.checkNotNullParameter(shareAddUserActivity, "this$0");
        shareAddUserActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(ActivityShareAddUserBinding activityShareAddUserBinding, ShareAddUserActivity shareAddUserActivity, View view) {
        Intrinsics.checkNotNullParameter(activityShareAddUserBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(shareAddUserActivity, "this$0");
        String obj = activityShareAddUserBinding.etAddAccountValue.getText().toString();
        String obj2 = activityShareAddUserBinding.etAddAliasValue.getText().toString();
        if (obj.length() == 0) {
            String string = shareAddUserActivity.getString(R.string.share_add_account_accountHint);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            ExtendsKt.toast(string);
        } else if (NetUtil.isNetAvailable(shareAddUserActivity)) {
            WaitDialog.show((Activity) shareAddUserActivity, (CharSequence) shareAddUserActivity.getString(R.string.com_loading));
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(shareAddUserActivity), (CoroutineContext) null, (CoroutineStart) null, new ShareAddUserActivity$onCreate$1$2$1(shareAddUserActivity, obj, obj2, (Continuation<? super ShareAddUserActivity$onCreate$1$2$1>) null), 3, (Object) null);
        } else {
            String string2 = shareAddUserActivity.getResources().getString(R.string.com_network_unused);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            ExtendsKt.toast(string2);
        }
    }
}
