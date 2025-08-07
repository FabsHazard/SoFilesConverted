package com.microtech.aidexx.ui.upgrade;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.fragment.app.DialogFragment;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.common.net.entity.VersionInfo;
import com.microtech.aidexx.data.resource.AppUpgradeManager;
import com.microtech.aidexx.data.resource.LocalResourceManager;
import com.microtech.aidexx.databinding.DialogAppUpdateBinding;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001a\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/ui/upgrade/AppUpdateFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "binding", "Lcom/microtech/aidexx/databinding/DialogAppUpdateBinding;", "getBinding", "()Lcom/microtech/aidexx/databinding/DialogAppUpdateBinding;", "setBinding", "(Lcom/microtech/aidexx/databinding/DialogAppUpdateBinding;)V", "updateInfo", "Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onViewCreated", "view", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AppUpdateFragment.kt */
public final class AppUpdateFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "AppUpdateFragment";
    public DialogAppUpdateBinding binding;
    /* access modifiers changed from: private */
    public UpgradeInfo updateInfo;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/upgrade/AppUpdateFragment$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AppUpdateFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final DialogAppUpdateBinding getBinding() {
        DialogAppUpdateBinding dialogAppUpdateBinding = this.binding;
        if (dialogAppUpdateBinding != null) {
            return dialogAppUpdateBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogAppUpdateBinding dialogAppUpdateBinding) {
        Intrinsics.checkNotNullParameter(dialogAppUpdateBinding, "<set-?>");
        this.binding = dialogAppUpdateBinding;
    }

    public void onCreate(Bundle bundle) {
        UpgradeInfo upgradeInfo;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                upgradeInfo = (UpgradeInfo) arguments.getParcelable("upgradeInfo", UpgradeInfo.class);
            } else {
                upgradeInfo = (UpgradeInfo) arguments.getParcelable("upgradeInfo");
            }
            this.updateInfo = upgradeInfo;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogAppUpdateBinding inflate = DialogAppUpdateBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        RelativeLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0069, code lost:
        r2 = (r2 = r2.getAppUpdateInfo()).getInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            super.onViewCreated(r7, r8)
            com.microtech.aidexx.databinding.DialogAppUpdateBinding r7 = r6.getBinding()
            com.microtech.aidexx.views.button.StateButton r7 = r7.btOk
            androidx.fragment.app.FragmentActivity r8 = r6.requireActivity()
            int r0 = com.microtech.aidexx.R.string.version_update_sure
            java.lang.String r8 = r8.getString(r0)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            com.microtech.aidexx.databinding.DialogAppUpdateBinding r7 = r6.getBinding()
            android.widget.TextView r7 = r7.btCancel
            androidx.fragment.app.FragmentActivity r8 = r6.requireActivity()
            int r0 = com.microtech.aidexx.R.string.version_update_ignore
            java.lang.String r8 = r8.getString(r0)
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            r7 = r6
            androidx.lifecycle.LifecycleOwner r7 = (androidx.lifecycle.LifecycleOwner) r7
            androidx.lifecycle.LifecycleCoroutineScope r7 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r7)
            r0 = r7
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            com.microtech.aidexx.ui.upgrade.AppUpdateFragment$onViewCreated$1 r7 = new com.microtech.aidexx.ui.upgrade.AppUpdateFragment$onViewCreated$1
            r8 = 0
            r7.<init>(r6, r8)
            r3 = r7
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            r4 = 3
            r5 = 0
            r1 = 0
            r2 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r0, r1, r2, r3, r4, r5)
            com.microtech.aidexx.databinding.DialogAppUpdateBinding r7 = r6.getBinding()
            android.widget.TextView r0 = r7.tvTitle
            kotlin.jvm.internal.StringCompanionObject r1 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            int r1 = com.microtech.aidexx.R.string.version_update
            java.lang.String r1 = r6.getString(r1)
            java.lang.String r2 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.microtech.aidexx.common.net.entity.UpgradeInfo r2 = r6.updateInfo
            if (r2 == 0) goto L_0x0074
            com.microtech.aidexx.common.net.entity.VersionInfo r2 = r2.getAppUpdateInfo()
            if (r2 == 0) goto L_0x0074
            com.microtech.aidexx.common.net.entity.VersionData r2 = r2.getInfo()
            if (r2 == 0) goto L_0x0074
            java.lang.String r2 = r2.getVersion()
            goto L_0x0075
        L_0x0074:
            r2 = r8
        L_0x0075:
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            r3 = 1
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r3)
            java.lang.String r1 = java.lang.String.format(r1, r2)
            java.lang.String r2 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.widget.TextView r0 = r7.tvContent
            com.microtech.aidexx.common.net.entity.UpgradeInfo r1 = r6.updateInfo
            if (r1 == 0) goto L_0x00a2
            com.microtech.aidexx.common.net.entity.VersionInfo r1 = r1.getAppUpdateInfo()
            if (r1 == 0) goto L_0x00a2
            com.microtech.aidexx.common.net.entity.VersionData r1 = r1.getInfo()
            if (r1 == 0) goto L_0x00a2
            java.lang.String r8 = r1.getDescription()
        L_0x00a2:
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r0.setText(r8)
            com.microtech.aidexx.views.button.StateButton r8 = r7.btOk
            com.microtech.aidexx.ui.upgrade.AppUpdateFragment$$ExternalSyntheticLambda0 r0 = new com.microtech.aidexx.ui.upgrade.AppUpdateFragment$$ExternalSyntheticLambda0
            r0.<init>(r6)
            r8.setOnClickListener(r0)
            android.widget.TextView r8 = r7.btCancel
            com.microtech.aidexx.common.net.entity.UpgradeInfo r0 = r6.updateInfo
            if (r0 == 0) goto L_0x00c6
            com.microtech.aidexx.common.net.entity.VersionInfo r0 = r0.getAppUpdateInfo()
            if (r0 == 0) goto L_0x00c6
            boolean r0 = r0.isForce()
            if (r0 != r3) goto L_0x00c6
            r0 = 8
            goto L_0x00c7
        L_0x00c6:
            r0 = 0
        L_0x00c7:
            r8.setVisibility(r0)
            android.widget.TextView r7 = r7.btCancel
            com.microtech.aidexx.ui.upgrade.AppUpdateFragment$$ExternalSyntheticLambda1 r8 = new com.microtech.aidexx.ui.upgrade.AppUpdateFragment$$ExternalSyntheticLambda1
            r8.<init>(r6)
            r7.setOnClickListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.upgrade.AppUpdateFragment.onViewCreated(android.view.View, android.os.Bundle):void");
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$2(AppUpdateFragment appUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(appUpdateFragment, "this$0");
        UpgradeInfo upgradeInfo = appUpdateFragment.updateInfo;
        if (upgradeInfo != null) {
            AppUpgradeManager.INSTANCE.startUpgrade(upgradeInfo);
        }
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$5$lambda$4(AppUpdateFragment appUpdateFragment, View view) {
        VersionInfo resourceUpdateInfo;
        Intrinsics.checkNotNullParameter(appUpdateFragment, "this$0");
        appUpdateFragment.dismissAllowingStateLoss();
        LogUtil.Companion.xLogE("暂不更新", TAG);
        UpgradeInfo upgradeInfo = appUpdateFragment.updateInfo;
        if (upgradeInfo != null && (resourceUpdateInfo = upgradeInfo.getResourceUpdateInfo()) != null && resourceUpdateInfo.getInfo() != null) {
            LocalResourceManager localResourceManager = LocalResourceManager.INSTANCE;
            UpgradeInfo upgradeInfo2 = appUpdateFragment.updateInfo;
            localResourceManager.startUpgrade(upgradeInfo2 != null ? upgradeInfo2.getResourceUpdateInfo() : null);
        }
    }

    public void onStart() {
        Window window;
        Resources resources;
        DisplayMetrics displayMetrics;
        super.onStart();
        setCancelable(false);
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
        Dialog dialog2 = getDialog();
        if (dialog2 != null && (window = dialog2.getWindow()) != null) {
            window.setBackgroundDrawableResource(R.color.transparent);
            WindowManager.LayoutParams attributes = window.getAttributes();
            Context context = getContext();
            if (!(context == null || (resources = context.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                attributes.width = displayMetrics.widthPixels - (ExtendsKt.dp2px((Number) 40) * 2);
                attributes.height = (int) (((double) attributes.width) * 1.1d);
            }
            window.setAttributes(attributes);
        }
    }
}
