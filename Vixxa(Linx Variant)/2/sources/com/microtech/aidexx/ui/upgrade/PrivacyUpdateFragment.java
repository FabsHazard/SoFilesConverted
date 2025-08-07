package com.microtech.aidexx.ui.upgrade;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModelKt;
import com.microtech.aidexx.common.Constants;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo;
import com.microtech.aidexx.databinding.DialogPrivacyUpdateBinding;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ui/upgrade/PrivacyUpdateFragment;", "Landroidx/fragment/app/DialogFragment;", "updateInfo", "Lcom/microtech/aidexx/common/net/entity/PolicyUpgradeInfo;", "(Lcom/microtech/aidexx/common/net/entity/PolicyUpgradeInfo;)V", "binding", "Lcom/microtech/aidexx/databinding/DialogPrivacyUpdateBinding;", "getBinding", "()Lcom/microtech/aidexx/databinding/DialogPrivacyUpdateBinding;", "setBinding", "(Lcom/microtech/aidexx/databinding/DialogPrivacyUpdateBinding;)V", "showWhether", "Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "getShowWhether", "()Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "setShowWhether", "(Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PrivacyUpdateFragment.kt */
public final class PrivacyUpdateFragment extends DialogFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "PrivacyUpdateFragment";
    public DialogPrivacyUpdateBinding binding;
    private StandardDialog showWhether;
    private final PolicyUpgradeInfo updateInfo;

    public PrivacyUpdateFragment(PolicyUpgradeInfo policyUpgradeInfo) {
        Intrinsics.checkNotNullParameter(policyUpgradeInfo, "updateInfo");
        this.updateInfo = policyUpgradeInfo;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/upgrade/PrivacyUpdateFragment$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PrivacyUpdateFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final DialogPrivacyUpdateBinding getBinding() {
        DialogPrivacyUpdateBinding dialogPrivacyUpdateBinding = this.binding;
        if (dialogPrivacyUpdateBinding != null) {
            return dialogPrivacyUpdateBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogPrivacyUpdateBinding dialogPrivacyUpdateBinding) {
        Intrinsics.checkNotNullParameter(dialogPrivacyUpdateBinding, "<set-?>");
        this.binding = dialogPrivacyUpdateBinding;
    }

    public final StandardDialog getShowWhether() {
        return this.showWhether;
    }

    public final void setShowWhether(StandardDialog standardDialog) {
        this.showWhether = standardDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        DialogPrivacyUpdateBinding inflate = DialogPrivacyUpdateBinding.inflate(layoutInflater);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        RelativeLayout root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        DialogPrivacyUpdateBinding binding2 = getBinding();
        String string = requireContext().getString(R.string.user_sign_privatePolicy);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = requireContext().getString(R.string.version_policy_update_tip, new Object[]{string});
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        CharSequence charSequence = string2;
        int indexOf$default = StringsKt.indexOf$default(charSequence, string, 0, false, 6, (Object) null);
        SpannableString spannableString = new SpannableString(charSequence);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        String string3 = requireContext().getString(R.string.user_sign_privatePolicy);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String url = this.updateInfo.getUrl();
        if (url == null) {
            url = Constants.INSTANCE.getPrivacyPolicyUrl();
        }
        spannableString.setSpan(new StringUtils.CustomHyperText(requireContext, string3, url, 3, requireContext().getColor(R.color.green_65)), indexOf$default, string.length() + indexOf$default, 33);
        binding2.tvDetail.setText(spannableString);
        binding2.tvDetail.setMovementMethod(LinkMovementMethod.getInstance());
        binding2.tvContent.setText(this.updateInfo.getDescription());
        binding2.btOk.setOnClickListener(new PrivacyUpdateFragment$$ExternalSyntheticLambda0(this));
        binding2.btCancel.setOnClickListener(new PrivacyUpdateFragment$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$0(PrivacyUpdateFragment privacyUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(privacyUpdateFragment, "this$0");
        MmkvManager mmkvManager = MmkvManager.INSTANCE;
        PolicyUpgradeInfo policyUpgradeInfo = privacyUpdateFragment.updateInfo;
        mmkvManager.savePolicyInfo(policyUpgradeInfo, policyUpgradeInfo.getPolicyType());
        MmkvManager.updatePrivacyCheckTime$default(MmkvManager.INSTANCE, 0, 1, (Object) null);
        privacyUpdateFragment.dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$2$lambda$1(PrivacyUpdateFragment privacyUpdateFragment, View view) {
        Intrinsics.checkNotNullParameter(privacyUpdateFragment, "this$0");
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity requireActivity = privacyUpdateFragment.requireActivity();
        Intrinsics.checkNotNull(requireActivity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        privacyUpdateFragment.showWhether = Dialogs.showWhether$default(dialogs, (AppCompatActivity) requireActivity, (String) null, privacyUpdateFragment.getString(R.string.version_policy_update_disagree_ph, privacyUpdateFragment.getString(R.string.app_name)), PrivacyUpdateFragment$onViewCreated$1$2$1.INSTANCE, new PrivacyUpdateFragment$onViewCreated$1$2$2(privacyUpdateFragment), (String) null, privacyUpdateFragment.getString(R.string.com_exitContinue), privacyUpdateFragment.getString(R.string.com_gotIt), 0, DeviceModelKt.GLUCOSE_NUM_ONE_DAY, (Object) null);
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
