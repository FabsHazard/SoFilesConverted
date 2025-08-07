package com.microtech.aidexx.ui.welcome.guide.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentPermissionCheckBinding;
import com.microtech.aidexx.ui.setting.permission.PermissionCheckUtil;
import com.microtech.aidexx.views.SettingItemWidget;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0002J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u000fH\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/PermissionCheckFragment;", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/GuideBaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentPermissionCheckBinding;", "()V", "batteryItem", "Lcom/microtech/aidexx/views/SettingItemWidget;", "bluetoothItem", "checkJob", "Lkotlinx/coroutines/Job;", "isChecking", "", "locationItem", "notificationItem", "addItemToView", "", "item", "checkAllPermission", "getPageName", "", "initView", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "resetView", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionCheckFragment.kt */
public final class PermissionCheckFragment extends GuideBaseFragment<BaseViewModel, FragmentPermissionCheckBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public SettingItemWidget batteryItem;
    /* access modifiers changed from: private */
    public SettingItemWidget bluetoothItem;
    private Job checkJob;
    /* access modifiers changed from: private */
    public boolean isChecking;
    /* access modifiers changed from: private */
    public SettingItemWidget locationItem;
    /* access modifiers changed from: private */
    public SettingItemWidget notificationItem;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentPermissionCheckBinding inflate = FragmentPermissionCheckBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initView();
        ConstraintLayout root = ((FragmentPermissionCheckBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onResume() {
        super.onResume();
        checkAllPermission();
    }

    private final void initView() {
        FragmentPermissionCheckBinding fragmentPermissionCheckBinding = (FragmentPermissionCheckBinding) getBinding();
        TextView textView = fragmentPermissionCheckBinding.checkOnce;
        Intrinsics.checkNotNullExpressionValue(textView, "checkOnce");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new PermissionCheckFragment$$ExternalSyntheticLambda0(this), 1, (Object) null);
        fragmentPermissionCheckBinding.tip.setText(getString(R.string.permission_desc_ph, getString(R.string.app_name)));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1$lambda$0(PermissionCheckFragment permissionCheckFragment, View view) {
        Intrinsics.checkNotNullParameter(permissionCheckFragment, "this$0");
        permissionCheckFragment.checkAllPermission();
    }

    private final void checkAllPermission() {
        if (!this.isChecking) {
            this.isChecking = true;
            resetView();
            this.checkJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new PermissionCheckFragment$checkAllPermission$1(this, (Continuation<? super PermissionCheckFragment$checkAllPermission$1>) null), 3, (Object) null);
        }
    }

    public void onPause() {
        super.onPause();
        Job job = this.checkJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.isChecking = false;
    }

    private final void resetView() {
        ((FragmentPermissionCheckBinding) getBinding()).permissionItems.removeAllViews();
        PermissionCheckUtil permissionCheckUtil = PermissionCheckUtil.INSTANCE;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        String string = getString(R.string.permission_item_location);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.locationItem = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil, requireActivity, string, (String) null, false, (Function1) null, 28, (Object) null);
        SettingItemWidget settingItemWidget = null;
        if (Build.VERSION.SDK_INT < 31) {
            SettingItemWidget settingItemWidget2 = this.locationItem;
            if (settingItemWidget2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationItem");
                settingItemWidget2 = null;
            }
            addItemToView(settingItemWidget2);
        }
        PermissionCheckUtil permissionCheckUtil2 = PermissionCheckUtil.INSTANCE;
        FragmentActivity requireActivity2 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity2, "requireActivity(...)");
        String string2 = getString(R.string.permission_item_ble);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SettingItemWidget genCheckItem$default = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil2, requireActivity2, string2, (String) null, false, (Function1) null, 28, (Object) null);
        this.bluetoothItem = genCheckItem$default;
        if (genCheckItem$default == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bluetoothItem");
            genCheckItem$default = null;
        }
        addItemToView(genCheckItem$default);
        PermissionCheckUtil permissionCheckUtil3 = PermissionCheckUtil.INSTANCE;
        FragmentActivity requireActivity3 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity3, "requireActivity(...)");
        String string3 = getString(R.string.permission_item_notifi);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        SettingItemWidget genCheckItem$default2 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil3, requireActivity3, string3, (String) null, false, (Function1) null, 28, (Object) null);
        this.notificationItem = genCheckItem$default2;
        if (genCheckItem$default2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("notificationItem");
            genCheckItem$default2 = null;
        }
        addItemToView(genCheckItem$default2);
        PermissionCheckUtil permissionCheckUtil4 = PermissionCheckUtil.INSTANCE;
        FragmentActivity requireActivity4 = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity4, "requireActivity(...)");
        String string4 = getString(R.string.permission_item_battery);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        SettingItemWidget genCheckItem$default3 = PermissionCheckUtil.genCheckItem$default(permissionCheckUtil4, requireActivity4, string4, (String) null, true, (Function1) null, 20, (Object) null);
        this.batteryItem = genCheckItem$default3;
        if (genCheckItem$default3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("batteryItem");
        } else {
            settingItemWidget = genCheckItem$default3;
        }
        addItemToView(settingItemWidget);
    }

    private final void addItemToView(SettingItemWidget settingItemWidget) {
        ((FragmentPermissionCheckBinding) getBinding()).permissionItems.addView(settingItemWidget);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/PermissionCheckFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/PermissionCheckFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PermissionCheckFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PermissionCheckFragment newInstance() {
            return new PermissionCheckFragment();
        }
    }

    public String getPageName() {
        String string = getString(R.string.permission);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }
}
