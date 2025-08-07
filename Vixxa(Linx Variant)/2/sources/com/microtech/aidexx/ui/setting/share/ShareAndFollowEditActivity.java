package com.microtech.aidexx.ui.setting.share;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityShareAndFollowEditBinding;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.dialog.Dialogs;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0016J \u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\u0012\u0010\u001d\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0012\u0010 \u001a\u00020\u00162\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareAndFollowEditActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityShareAndFollowEditBinding;", "Landroid/view/View$OnClickListener;", "()V", "editData", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "editFrom", "", "emergePush", "", "Ljava/lang/Boolean;", "hideState", "normalPush", "sfViewModel", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "getSfViewModel", "()Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "sfViewModel$delegate", "Lkotlin/Lazy;", "checkAndSwitchToMySelf", "", "getViewBinding", "initSwitchState", "isHide", "isNormal", "isUrgent", "initView", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareAndFollowEditActivity.kt */
public final class ShareAndFollowEditActivity extends BaseActivity<BaseViewModel, ActivityShareAndFollowEditBinding> implements View.OnClickListener {
    /* access modifiers changed from: private */
    public ShareUserInfo editData;
    private int editFrom;
    /* access modifiers changed from: private */
    public Boolean emergePush;
    /* access modifiers changed from: private */
    public Boolean hideState;
    /* access modifiers changed from: private */
    public Boolean normalPush;
    private final Lazy sfViewModel$delegate;

    public ShareAndFollowEditActivity() {
        ComponentActivity componentActivity = this;
        this.sfViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ShareFollowViewModel.class), new ShareAndFollowEditActivity$special$$inlined$viewModels$default$2(componentActivity), new ShareAndFollowEditActivity$special$$inlined$viewModels$default$1(componentActivity), new ShareAndFollowEditActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ShareFollowViewModel getSfViewModel() {
        return (ShareFollowViewModel) this.sfViewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityShareAndFollowEditBinding) getBinding()).getRoot());
        initView();
    }

    private final void initSwitchState(boolean z, boolean z2, boolean z3) {
        this.hideState = Boolean.valueOf(z);
        this.normalPush = Boolean.valueOf(z2);
        this.emergePush = Boolean.valueOf(z3);
        ActivityShareAndFollowEditBinding activityShareAndFollowEditBinding = (ActivityShareAndFollowEditBinding) getBinding();
        activityShareAndFollowEditBinding.showOrHide.editItemSwitch.setChecked(!z);
        if (!z) {
            activityShareAndFollowEditBinding.normalNotice.clEditItem.setVisibility(0);
            activityShareAndFollowEditBinding.urgentNotice.clEditItem.setVisibility(0);
            activityShareAndFollowEditBinding.showOrHide.editDivider.setVisibility(0);
            activityShareAndFollowEditBinding.urgentNotice.editDivider.setVisibility(8);
        } else {
            activityShareAndFollowEditBinding.normalNotice.clEditItem.setVisibility(8);
            activityShareAndFollowEditBinding.urgentNotice.clEditItem.setVisibility(8);
            activityShareAndFollowEditBinding.showOrHide.editDivider.setVisibility(8);
        }
        activityShareAndFollowEditBinding.normalNotice.editItemSwitch.setChecked(!z2);
        activityShareAndFollowEditBinding.urgentNotice.editItemSwitch.setChecked(!z3);
    }

    private final void initView() {
        ShareUserInfo shareUserInfo;
        Unit unit;
        Unit unit2;
        ActivityShareAndFollowEditBinding activityShareAndFollowEditBinding = (ActivityShareAndFollowEditBinding) getBinding();
        this.editFrom = getIntent().getIntExtra(ShareAndFollowEditActivityKt.EDIT_FROM, 0);
        if (Build.VERSION.SDK_INT >= 33) {
            shareUserInfo = (ShareUserInfo) getIntent().getParcelableExtra(ShareAndFollowEditActivityKt.EDIT_DATA, ShareUserInfo.class);
        } else {
            shareUserInfo = (ShareUserInfo) getIntent().getParcelableExtra(ShareAndFollowEditActivityKt.EDIT_DATA);
        }
        ShareUserInfo shareUserInfo2 = null;
        if (shareUserInfo != null) {
            if (shareUserInfo.getUserAuthorizationId() != null) {
                this.editData = shareUserInfo;
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                finish();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            finish();
        }
        ShareUserInfo shareUserInfo3 = this.editData;
        if (shareUserInfo3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo3 = null;
        }
        activityShareAndFollowEditBinding.shareAndFollowEditActionbar.setTitle(shareUserInfo3.getDisplayName());
        TextView textView = activityShareAndFollowEditBinding.tvAccountValue;
        ShareUserInfo shareUserInfo4 = this.editData;
        if (shareUserInfo4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo4 = null;
        }
        textView.setText(shareUserInfo4.getMaskedAccount());
        EditText editText = activityShareAndFollowEditBinding.etAliasValue;
        ShareUserInfo shareUserInfo5 = this.editData;
        if (shareUserInfo5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo5 = null;
        }
        editText.setText(shareUserInfo5.getAlias());
        int i = this.editFrom;
        if (i == 1) {
            activityShareAndFollowEditBinding.clEdit.setVisibility(8);
            activityShareAndFollowEditBinding.btnEditDelete.setText(getString(R.string.share_delete_share));
        } else if (i == 2) {
            activityShareAndFollowEditBinding.clEdit.setVisibility(0);
            activityShareAndFollowEditBinding.btnEditDelete.setText(getString(R.string.share_delete_follow));
        }
        activityShareAndFollowEditBinding.shareAndFollowEditActionbar.getLeftIcon().setOnClickListener(new ShareAndFollowEditActivity$$ExternalSyntheticLambda0(this));
        activityShareAndFollowEditBinding.showOrHide.switchEditTitle.setText(getString(R.string.share_setting_switch_title));
        activityShareAndFollowEditBinding.showOrHide.editItemInfo.setText(getString(R.string.share_setting_switch_tip));
        activityShareAndFollowEditBinding.normalNotice.switchEditTitle.setText(getString(R.string.share_setting_normalWarning_title));
        activityShareAndFollowEditBinding.normalNotice.editItemInfo.setText(getString(R.string.share_setting_normalWarning_tip));
        activityShareAndFollowEditBinding.urgentNotice.switchEditTitle.setText(getString(R.string.share_setting_urgentWarning_title));
        activityShareAndFollowEditBinding.urgentNotice.editItemInfo.setText(getString(R.string.share_setting_urgentWarning_tip));
        ShareUserInfo shareUserInfo6 = this.editData;
        if (shareUserInfo6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo6 = null;
        }
        boolean hide = shareUserInfo6.getHide();
        ShareUserInfo shareUserInfo7 = this.editData;
        if (shareUserInfo7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo7 = null;
        }
        boolean normalPush2 = shareUserInfo7.getNormalPush();
        ShareUserInfo shareUserInfo8 = this.editData;
        if (shareUserInfo8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo8 = null;
        }
        initSwitchState(hide, normalPush2, shareUserInfo8.getEmergePush());
        activityShareAndFollowEditBinding.normalNotice.editItemSwitch.setOnCheckedChangeListener(new ShareAndFollowEditActivity$$ExternalSyntheticLambda1(this));
        activityShareAndFollowEditBinding.urgentNotice.editItemSwitch.setOnCheckedChangeListener(new ShareAndFollowEditActivity$$ExternalSyntheticLambda2(this));
        activityShareAndFollowEditBinding.showOrHide.editItemSwitch.setOnCheckedChangeListener(new ShareAndFollowEditActivity$$ExternalSyntheticLambda3(this));
        ActionBarWidget actionBarWidget = activityShareAndFollowEditBinding.shareAndFollowEditActionbar;
        ShareUserInfo shareUserInfo9 = this.editData;
        if (shareUserInfo9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
        } else {
            shareUserInfo2 = shareUserInfo9;
        }
        actionBarWidget.setTitle(shareUserInfo2.getDisplayName());
        View.OnClickListener onClickListener = this;
        activityShareAndFollowEditBinding.btnEditSave.setOnClickListener(onClickListener);
        activityShareAndFollowEditBinding.btnEditDelete.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$3(ShareAndFollowEditActivity shareAndFollowEditActivity, View view) {
        Intrinsics.checkNotNullParameter(shareAndFollowEditActivity, "this$0");
        shareAndFollowEditActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$4(ShareAndFollowEditActivity shareAndFollowEditActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(shareAndFollowEditActivity, "this$0");
        shareAndFollowEditActivity.normalPush = Boolean.valueOf(!z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$5(ShareAndFollowEditActivity shareAndFollowEditActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(shareAndFollowEditActivity, "this$0");
        shareAndFollowEditActivity.emergePush = Boolean.valueOf(!z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7$lambda$6(ShareAndFollowEditActivity shareAndFollowEditActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(shareAndFollowEditActivity, "this$0");
        Boolean valueOf = Boolean.valueOf(!z);
        shareAndFollowEditActivity.hideState = valueOf;
        Intrinsics.checkNotNull(valueOf);
        shareAndFollowEditActivity.initSwitchState(valueOf.booleanValue(), Intrinsics.areEqual((Object) shareAndFollowEditActivity.normalPush, (Object) true), Intrinsics.areEqual((Object) shareAndFollowEditActivity.emergePush, (Object) true));
    }

    public ActivityShareAndFollowEditBinding getViewBinding() {
        ActivityShareAndFollowEditBinding inflate = ActivityShareAndFollowEditBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void onClick(View view) {
        if (Intrinsics.areEqual((Object) view, (Object) ((ActivityShareAndFollowEditBinding) getBinding()).btnEditSave)) {
            String obj = ((ActivityShareAndFollowEditBinding) getBinding()).etAliasValue.getText().toString();
            if (this.hideState == null && this.normalPush == null && this.emergePush == null) {
                ShareUserInfo shareUserInfo = this.editData;
                if (shareUserInfo == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("editData");
                    shareUserInfo = null;
                }
                if (Intrinsics.areEqual((Object) obj, (Object) shareUserInfo.getProviderAlias())) {
                    finish();
                    return;
                }
            }
            if (NetUtil.isNetAvailable(this)) {
                int i = this.editFrom;
                if (i == 1) {
                    WaitDialog.show((Activity) this, (CharSequence) getString(R.string.com_loading));
                    Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ShareAndFollowEditActivity$onClick$1(this, obj, (Continuation<? super ShareAndFollowEditActivity$onClick$1>) null), 3, (Object) null);
                } else if (i == 2) {
                    WaitDialog.show((Activity) this, (CharSequence) getString(R.string.com_loading));
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ShareAndFollowEditActivity$onClick$2(this, obj, (Continuation<? super ShareAndFollowEditActivity$onClick$2>) null), 3, (Object) null);
                }
            } else {
                String string = getResources().getString(R.string.com_network_unused);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ExtendsKt.toast(string);
            }
        } else if (Intrinsics.areEqual((Object) view, (Object) ((ActivityShareAndFollowEditBinding) getBinding()).btnEditDelete)) {
            Dialogs.showWhether$default(Dialogs.INSTANCE, this, (String) null, getResources().getString(R.string.com_delete_confirm), new ShareAndFollowEditActivity$onClick$3(this), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void checkAndSwitchToMySelf() {
        ShareAndFollowEditActivity shareAndFollowEditActivity;
        String str;
        ShareUserInfo shareUserInfo = UserInfoManager.Companion.getShareUserInfo();
        if (shareUserInfo != null) {
            str = shareUserInfo.getUserAuthorizationId();
            shareAndFollowEditActivity = this;
        } else {
            shareAndFollowEditActivity = this;
            str = null;
        }
        ShareUserInfo shareUserInfo2 = shareAndFollowEditActivity.editData;
        if (shareUserInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("editData");
            shareUserInfo2 = null;
        }
        String userAuthorizationId = shareUserInfo2.getUserAuthorizationId();
        Intrinsics.checkNotNull(userAuthorizationId);
        if (Intrinsics.areEqual((Object) str, (Object) userAuthorizationId)) {
            UserInfoManager.Companion.setShareUserInfo((ShareUserInfo) null);
            ShareUserInfo shareUserInfo3 = new ShareUserInfo((String) null, (UserTrendInfo) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (Integer) null, (String) null, (String) null, (UserEntity) null, (CgmDevice) null, (SettingsEntity) null, 32767, (DefaultConstructorMarker) null);
            shareUserInfo3.setDataProviderId(UserInfoManager.Companion.instance().userId());
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_SWITCH_USER, shareUserInfo3);
        }
    }
}
