package com.microtech.aidexx.ui.setting.permission;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityPermissionCheckBinding;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\b\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0011H\u0014J\b\u0010\u0019\u001a\u00020\u0011H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/microtech/aidexx/ui/setting/permission/PermissionCheckActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityPermissionCheckBinding;", "()V", "autoStartItem", "Lcom/microtech/aidexx/views/SettingItemWidget;", "batteryItem", "bluetoothItem", "cameraItem", "isChecking", "", "locationItem", "netItem", "notificationItem", "storageItem", "addItemToView", "", "item", "checkAllPermission", "getViewBinding", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "resetView", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionCheckActivity.kt */
public final class PermissionCheckActivity extends BaseActivity<BaseViewModel, ActivityPermissionCheckBinding> {
    /* access modifiers changed from: private */
    public SettingItemWidget autoStartItem;
    /* access modifiers changed from: private */
    public SettingItemWidget batteryItem;
    /* access modifiers changed from: private */
    public SettingItemWidget bluetoothItem;
    /* access modifiers changed from: private */
    public SettingItemWidget cameraItem;
    /* access modifiers changed from: private */
    public boolean isChecking;
    /* access modifiers changed from: private */
    public SettingItemWidget locationItem;
    /* access modifiers changed from: private */
    public SettingItemWidget netItem;
    /* access modifiers changed from: private */
    public SettingItemWidget notificationItem;
    /* access modifiers changed from: private */
    public SettingItemWidget storageItem;

    public ActivityPermissionCheckBinding getViewBinding() {
        ActivityPermissionCheckBinding inflate = ActivityPermissionCheckBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityPermissionCheckBinding) getBinding()).getRoot());
        ActivityPermissionCheckBinding activityPermissionCheckBinding = (ActivityPermissionCheckBinding) getBinding();
        activityPermissionCheckBinding.actionBar.getLeftIcon().setOnClickListener(new PermissionCheckActivity$$ExternalSyntheticLambda0(this));
        TextView textView = activityPermissionCheckBinding.checkOnce;
        Intrinsics.checkNotNullExpressionValue(textView, "checkOnce");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new PermissionCheckActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
        activityPermissionCheckBinding.tip.setText(getString(R.string.permission_desc_ph, new Object[]{getString(R.string.app_name)}));
        resetView();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$0(PermissionCheckActivity permissionCheckActivity, View view) {
        Intrinsics.checkNotNullParameter(permissionCheckActivity, "this$0");
        permissionCheckActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$2$lambda$1(PermissionCheckActivity permissionCheckActivity, View view) {
        Intrinsics.checkNotNullParameter(permissionCheckActivity, "this$0");
        permissionCheckActivity.checkAllPermission();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        checkAllPermission();
    }

    private final void resetView() {
        ((ActivityPermissionCheckBinding) getBinding()).itemLl.removeAllViews();
        PermissionCheckUtil permissionCheckUtil = PermissionCheckUtil.INSTANCE;
        Context context = this;
        String string = getString(R.string.permission_item_network);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        SettingItemWidget genCheckItem$default = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil, context, string, (String) null, false, (Function1) null, 28, (Object) null);
        this.netItem = genCheckItem$default;
        SettingItemWidget settingItemWidget = null;
        if (genCheckItem$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("netItem");
            genCheckItem$default = null;
        }
        addItemToView(genCheckItem$default);
        PermissionCheckUtil permissionCheckUtil2 = PermissionCheckUtil.INSTANCE;
        String string2 = getString(R.string.permission_item_location);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.locationItem = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil2, context, string2, (String) null, false, (Function1) null, 28, (Object) null);
        if (Build.VERSION.SDK_INT < 31) {
            SettingItemWidget settingItemWidget2 = this.locationItem;
            if (settingItemWidget2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationItem");
                settingItemWidget2 = null;
            }
            addItemToView(settingItemWidget2);
        }
        PermissionCheckUtil permissionCheckUtil3 = PermissionCheckUtil.INSTANCE;
        String string3 = getString(R.string.permission_item_ble);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        SettingItemWidget genCheckItem$default2 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil3, context, string3, (String) null, false, (Function1) null, 28, (Object) null);
        this.bluetoothItem = genCheckItem$default2;
        if (genCheckItem$default2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothItem");
            genCheckItem$default2 = null;
        }
        addItemToView(genCheckItem$default2);
        PermissionCheckUtil permissionCheckUtil4 = PermissionCheckUtil.INSTANCE;
        String string4 = getString(R.string.permission_item_notifi);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        SettingItemWidget genCheckItem$default3 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil4, context, string4, (String) null, false, (Function1) null, 28, (Object) null);
        this.notificationItem = genCheckItem$default3;
        if (genCheckItem$default3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationItem");
            genCheckItem$default3 = null;
        }
        addItemToView(genCheckItem$default3);
        PermissionCheckUtil permissionCheckUtil5 = PermissionCheckUtil.INSTANCE;
        String string5 = getString(R.string.permission_item_battery);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        SettingItemWidget genCheckItem$default4 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil5, context, string5, (String) null, false, (Function1) null, 28, (Object) null);
        this.batteryItem = genCheckItem$default4;
        if (genCheckItem$default4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batteryItem");
            genCheckItem$default4 = null;
        }
        addItemToView(genCheckItem$default4);
        PermissionCheckUtil permissionCheckUtil6 = PermissionCheckUtil.INSTANCE;
        String string6 = getString(R.string.permission_item_autoStart);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        SettingItemWidget genCheckItem$default5 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil6, context, string6, (String) null, false, (Function1) null, 28, (Object) null);
        this.autoStartItem = genCheckItem$default5;
        if (genCheckItem$default5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("autoStartItem");
            genCheckItem$default5 = null;
        }
        addItemToView(genCheckItem$default5);
        PermissionCheckUtil permissionCheckUtil7 = PermissionCheckUtil.INSTANCE;
        String string7 = getString(R.string.permission_item_storage);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        SettingItemWidget genCheckItem$default6 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil7, context, string7, (String) null, false, (Function1) null, 28, (Object) null);
        this.storageItem = genCheckItem$default6;
        if (genCheckItem$default6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("storageItem");
            genCheckItem$default6 = null;
        }
        addItemToView(genCheckItem$default6);
        PermissionCheckUtil permissionCheckUtil8 = PermissionCheckUtil.INSTANCE;
        String string8 = getString(R.string.permission_item_camera);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        SettingItemWidget genCheckItem$default7 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil8, context, string8, (String) null, true, (Function1) null, 20, (Object) null);
        this.cameraItem = genCheckItem$default7;
        if (genCheckItem$default7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraItem");
        } else {
            settingItemWidget = genCheckItem$default7;
        }
        addItemToView(settingItemWidget);
    }

    private final void checkAllPermission() {
        if (!this.isChecking) {
            this.isChecking = true;
            resetView();
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new PermissionCheckActivity$checkAllPermission$1(this, (Continuation<? super PermissionCheckActivity$checkAllPermission$1>) null), 3, (Object) null);
        }
    }

    private final void addItemToView(SettingItemWidget settingItemWidget) {
        ((ActivityPermissionCheckBinding) getBinding()).itemLl.addView(settingItemWidget);
    }
}
