package com.microtech.aidexx.ui.main.home.panel;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.FragmentWarmingUpBinding;
import com.microtech.aidexx.ui.main.home.HomeStateManager;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0012H\u0002J$\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/WarmingUpFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentWarmingUpBinding;", "()V", "countTimer", "Landroid/os/CountDownTimer;", "getCountTimer", "()Landroid/os/CountDownTimer;", "setCountTimer", "(Landroid/os/CountDownTimer;)V", "rotateAnimation", "Landroid/view/animation/RotateAnimation;", "getRotateAnimation", "()Landroid/view/animation/RotateAnimation;", "setRotateAnimation", "(Landroid/view/animation/RotateAnimation;)V", "createTimer", "", "remain", "", "initAnim", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: WarmingUpFragment.kt */
public final class WarmingUpFragment extends BaseFragment<BaseViewModel, FragmentWarmingUpBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private CountDownTimer countTimer;
    private RotateAnimation rotateAnimation;

    @JvmStatic
    public static final WarmingUpFragment newInstance() {
        return Companion.newInstance();
    }

    public final CountDownTimer getCountTimer() {
        return this.countTimer;
    }

    public final void setCountTimer(CountDownTimer countDownTimer) {
        this.countTimer = countDownTimer;
    }

    public final RotateAnimation getRotateAnimation() {
        return this.rotateAnimation;
    }

    public final void setRotateAnimation(RotateAnimation rotateAnimation2) {
        this.rotateAnimation = rotateAnimation2;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentWarmingUpBinding inflate = FragmentWarmingUpBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        initAnim();
        HomeStateManager.Companion.setOnWarmingUpTimeLeftListener(new WarmingUpFragment$onCreateView$1(this));
        ((FragmentWarmingUpBinding) getBinding()).bgPanelBlank.setBackgroundResource(ThemeManager.INSTANCE.isLight() ? R.drawable.bg_panel_blank_light : R.drawable.bg_panel_blank_dark);
        ConstraintLayout root = ((FragmentWarmingUpBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public final void createTimer(int i) {
        if (i > 1) {
            long minutesToMillis = ExtendsKt.minutesToMillis(i);
            CountDownTimer countDownTimer = this.countTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            CountDownTimer warmingUpFragment$createTimer$1 = new WarmingUpFragment$createTimer$1(minutesToMillis, this);
            this.countTimer = warmingUpFragment$createTimer$1;
            warmingUpFragment$createTimer$1.start();
            return;
        }
        ((FragmentWarmingUpBinding) getBinding()).tvRemain.setText("1");
        ((FragmentWarmingUpBinding) getBinding()).tvWarmingUp.setText(getString(R.string.ble_state_sensor_warming));
        CountDownTimer countDownTimer2 = this.countTimer;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
    }

    private final void initAnim() {
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.rotateAnimation = rotateAnimation2;
        rotateAnimation2.setDuration(1500);
        RotateAnimation rotateAnimation3 = this.rotateAnimation;
        if (rotateAnimation3 != null) {
            rotateAnimation3.setInterpolator(new LinearInterpolator());
        }
        RotateAnimation rotateAnimation4 = this.rotateAnimation;
        if (rotateAnimation4 != null) {
            rotateAnimation4.setRepeatCount(-1);
        }
        RotateAnimation rotateAnimation5 = this.rotateAnimation;
        if (rotateAnimation5 != null) {
            rotateAnimation5.setFillAfter(true);
        }
    }

    public void onResume() {
        AidexXHistoryEntity latestHistory;
        super.onResume();
        ((FragmentWarmingUpBinding) getBinding()).bgPanel.startAnimation(this.rotateAnimation);
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel != null && (latestHistory = deviceModel.getLatestHistory()) != null) {
            createTimer(60 - latestHistory.timeOffset);
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
        CountDownTimer countDownTimer = this.countTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        ((FragmentWarmingUpBinding) getBinding()).bgPanel.clearAnimation();
        HomeStateManager.Companion.setOnWarmingUpTimeLeftListener((Function1<? super Integer, Unit>) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/WarmingUpFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/home/panel/WarmingUpFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: WarmingUpFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final WarmingUpFragment newInstance() {
            return new WarmingUpFragment();
        }
    }
}
