package com.microtech.aidexx.ui.main.home;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$initEvent$5 extends Lambda implements Function1<ShareUserInfo, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$initEvent$5(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ShareUserInfo) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ShareUserInfo shareUserInfo) {
        String str;
        TransmitterEntity entity;
        Intrinsics.checkNotNullParameter(shareUserInfo, "it");
        ViewBinding binding = this.this$0.getBinding();
        HomeFragment homeFragment = this.this$0;
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) binding;
        int i = 0;
        if (Intrinsics.areEqual((Object) shareUserInfo.getDataProviderId(), (Object) UserInfoManager.Companion.instance().userId())) {
            boolean z = true;
            invoke$lambda$1$changeUi(fragmentHomeBinding, true);
            TextView textView = fragmentHomeBinding.tvSn;
            DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
            if (deviceModel == null || (entity = deviceModel.getEntity()) == null || (str = entity.getDeviceSn()) == null) {
                str = "";
            }
            textView.setText(str);
            Boolean bool = BuildConfig.showConnectStates;
            Intrinsics.checkNotNullExpressionValue(bool, "showConnectStates");
            if (bool.booleanValue()) {
                ImageView imageView = fragmentHomeBinding.ivConnectState;
                Intrinsics.checkNotNullExpressionValue(imageView, "ivConnectState");
                View view = imageView;
                CharSequence text = fragmentHomeBinding.tvSn.getText();
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                if (text.length() <= 0) {
                    z = false;
                }
                if (z) {
                    i = 4;
                }
                view.setVisibility(i);
            }
            DeviceModel deviceModel2 = TransmitterManager.Companion.instance().getDefault();
            DeviceModel.GlucoseLevel glucoseLevel = null;
            if (deviceModel2 != null && deviceModel2.isDataValid() && deviceModel2.getMalFunctionList().isEmpty()) {
                glucoseLevel = deviceModel2.getGlucoseLevel();
            }
            HomeBackGroundSelector.Companion.instance().getHomeBg(glucoseLevel);
            return;
        }
        invoke$lambda$1$changeUi(fragmentHomeBinding, false);
        homeFragment.updateShareUserData();
    }

    private static final void invoke$lambda$1$changeUi(FragmentHomeBinding fragmentHomeBinding, boolean z) {
        ImageView imageView = fragmentHomeBinding.userCenter;
        Intrinsics.checkNotNullExpressionValue(imageView, "userCenter");
        int i = 0;
        imageView.setVisibility(z ? 0 : 8);
        ImageView imageView2 = fragmentHomeBinding.welfareCenter;
        Intrinsics.checkNotNullExpressionValue(imageView2, "welfareCenter");
        imageView2.setVisibility(z ? 0 : 8);
        TextView textView = fragmentHomeBinding.dataOwner;
        Intrinsics.checkNotNullExpressionValue(textView, "dataOwner");
        textView.setVisibility(!z ? 0 : 8);
        ConstraintLayout root = fragmentHomeBinding.frgShare.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        root.setVisibility(!z ? 0 : 8);
        FragmentContainerView fragmentContainerView = fragmentHomeBinding.fcvPanel;
        Intrinsics.checkNotNullExpressionValue(fragmentContainerView, "fcvPanel");
        View view = fragmentContainerView;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
