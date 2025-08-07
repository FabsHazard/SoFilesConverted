package com.microtech.aidexx.ui.main.home.panel;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.FragmentGlucosePanelBinding;
import com.microtech.aidexx.ui.main.home.HomeBackGroundSelector;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtechmd.blecomm.parser.AidexXHistoryEntity;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u0006\t\u0018\u0000 \u001c2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0002J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u000eH\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002R\u0010\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentGlucosePanelBinding;", "()V", "handler", "com/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment$handler$1", "Lcom/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment$handler$1;", "mObserver", "com/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment$mObserver$1", "Lcom/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment$mObserver$1;", "timer", "Ljava/util/Timer;", "deleteAndToPair", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onResume", "resetState", "update", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucosePanelFragment.kt */
public final class GlucosePanelFragment extends BaseFragment<BaseViewModel, FragmentGlucosePanelBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final GlucosePanelFragment$handler$1 handler = new GlucosePanelFragment$handler$1(this, Looper.getMainLooper());
    private final GlucosePanelFragment$mObserver$1 mObserver = new GlucosePanelFragment$mObserver$1(this);
    private Timer timer;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucosePanelFragment.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend[] r0 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.FAST_UP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.SLOW_UP     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.panel.GlucosePanelFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final GlucosePanelFragment newInstance() {
        return Companion.newInstance();
    }

    /* access modifiers changed from: private */
    public final void deleteAndToPair() {
        if (isAdded()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new GlucosePanelFragment$deleteAndToPair$1(this, (Continuation<? super GlucosePanelFragment$deleteAndToPair$1>) null), 3, (Object) null);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentGlucosePanelBinding inflate = FragmentGlucosePanelBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ((FragmentGlucosePanelBinding) getBinding()).bgPanel.setBackgroundResource(ThemeManager.INSTANCE.isLight() ? R.drawable.bg_panel_blank_light : R.drawable.bg_panel_blank_dark);
        ((FragmentGlucosePanelBinding) getBinding()).btToPair.setOnClickListener(new GlucosePanelFragment$$ExternalSyntheticLambda0(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_UNIT_CHANGE, (LifecycleOwner) this, new GlucosePanelFragment$onCreateView$2(this));
        ConstraintLayout root = ((FragmentGlucosePanelBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    /* access modifiers changed from: private */
    public static final void onCreateView$lambda$0(GlucosePanelFragment glucosePanelFragment, View view) {
        Intrinsics.checkNotNullParameter(glucosePanelFragment, "this$0");
        glucosePanelFragment.deleteAndToPair();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(new GlucosePanelFragment$onCreate$$inlined$schedule$1(this), 0, TimeUtils.oneMinuteMillis);
        LifecycleOwner lifecycleOwner = this;
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_PAIR_RESULT, lifecycleOwner, new GlucosePanelFragment$onCreate$2(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_HYP_CHANGE, lifecycleOwner, new GlucosePanelFragment$onCreate$3(this));
    }

    public void onResume() {
        super.onResume();
        MessageDistributor.Companion.instance().observer(this.mObserver);
        this.handler.sendEmptyMessageDelayed(2006, 50);
    }

    public void onDestroy() {
        super.onDestroy();
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
        }
        MessageDistributor.Companion.instance().removeObserver(this.mObserver);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/home/panel/GlucosePanelFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GlucosePanelFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final GlucosePanelFragment newInstance() {
            return new GlucosePanelFragment();
        }
    }

    /* access modifiers changed from: private */
    public final void resetState() {
        ((FragmentGlucosePanelBinding) getBinding()).tvValueTime.setVisibility(8);
        ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseValue.setText(getResources().getString(R.string.com_unknown));
        ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setVisibility(8);
        ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(8);
        ((FragmentGlucosePanelBinding) getBinding()).btToPair.setVisibility(8);
        if (UserInfoManager.Companion.getShareUserInfo() == null) {
            HomeBackGroundSelector.Companion.instance().getHomeBg((DeviceModel.GlucoseLevel) null);
        }
        ((FragmentGlucosePanelBinding) getBinding()).bgPanel.setBackgroundResource(HomeBackGroundSelector.Companion.instance().getBgForTrend((DeviceModel.GlucoseTrend) null, (DeviceModel.GlucoseLevel) null));
        EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, false);
    }

    /* access modifiers changed from: private */
    public final void update() {
        String str;
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel != null) {
            if (deviceModel.getLatestHistory() != null) {
                AidexXHistoryEntity latestHistory = deviceModel.getLatestHistory();
                Intrinsics.checkNotNull(latestHistory);
                if (latestHistory.timeOffset < 60) {
                    return;
                }
            }
            if (isAdded() && getActivity() != null && !requireActivity().isFinishing()) {
                if (!deviceModel.isDataValid() || !deviceModel.getMalFunctionList().isEmpty()) {
                    resetState();
                } else {
                    EventBusManager.INSTANCE.send(EventBusKey.UPDATE_NOTIFICATION, true);
                    ((FragmentGlucosePanelBinding) getBinding()).tvValueTime.setVisibility(0);
                    Integer minutesAgo = deviceModel.getMinutesAgo();
                    if (minutesAgo != null && minutesAgo.intValue() == 0) {
                        ((FragmentGlucosePanelBinding) getBinding()).tvValueTime.setText(getResources().getString(R.string.com_time_ago_justNow));
                    } else {
                        ((FragmentGlucosePanelBinding) getBinding()).tvValueTime.setText(getResources().getString(R.string.com_time_ago_minute, new Object[]{ExtendsKt.getNumberFormatWithLocale().format(deviceModel.getMinutesAgo())}));
                    }
                    if (getContext() != null) {
                        TextView textView = ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseValue;
                        Float glucose = deviceModel.getGlucose();
                        if (glucose != null) {
                            float floatValue = glucose.floatValue();
                            Resources resources = getResources();
                            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                            str = GlucoseUtilKt.toGlucoseStringWithLowAndHigh(floatValue, resources);
                        } else {
                            str = null;
                        }
                        textView.setText(str);
                        ((FragmentGlucosePanelBinding) getBinding()).tvUnit.setText(UnitManager.INSTANCE.getDisplayUnit());
                    }
                    View view = ((FragmentGlucosePanelBinding) getBinding()).bgPanel;
                    DeviceModel.GlucoseTrend glucoseTrend = deviceModel.getGlucoseTrend();
                    int i = glucoseTrend == null ? -1 : WhenMappings.$EnumSwitchMapping$0[glucoseTrend.ordinal()];
                    view.setRotation((i == 1 || i == 2) ? 180.0f : i != 3 ? 0.0f : -90.0f);
                    ((FragmentGlucosePanelBinding) getBinding()).bgPanel.setBackgroundResource(HomeBackGroundSelector.Companion.instance().getBgForTrend(deviceModel.getGlucoseTrend(), deviceModel.getGlucoseLevel()));
                    if (UserInfoManager.Companion.getShareUserInfo() == null) {
                        HomeBackGroundSelector.Companion.instance().getHomeBg(deviceModel.getGlucoseLevel());
                    }
                }
            }
            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(8);
            if (deviceModel.getMinutesAgo() != null) {
                Integer minutesAgo2 = deviceModel.getMinutesAgo();
                Intrinsics.checkNotNull(minutesAgo2);
                int intValue = minutesAgo2.intValue();
                if (intValue >= 0 && intValue < 16 && isAdded()) {
                    ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(8);
                    ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText("");
                    if (!deviceModel.getMalFunctionList().isEmpty()) {
                        int intValue2 = deviceModel.getMalFunctionList().get(0).intValue();
                        if (intValue2 == 2) {
                            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(0);
                            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText(getResources().getString(R.string.ble_state_sensor_batteryLow));
                        } else if (intValue2 == 8) {
                            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(0);
                            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText(getResources().getString(R.string.ble_state_sensor_error));
                        } else if (intValue2 == 32) {
                            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(0);
                            ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText(getResources().getString(R.string.ble_state_sensor_error_critical));
                        }
                    } else {
                        AidexXHistoryEntity latestHistory2 = deviceModel.getLatestHistory();
                        if (latestHistory2 != null && latestHistory2.isValid == 1) {
                            if (latestHistory2.status == 1) {
                                ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(0);
                                ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText(getResources().getString(R.string.ble_state_sensor_invalid));
                            } else if (latestHistory2.status == 2) {
                                ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(0);
                                ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText(getResources().getString(R.string.ble_state_sensor_error));
                            }
                        }
                    }
                }
            }
            if (getActivity() != null && !requireActivity().isFinishing() && isAdded()) {
                Integer sensorRemainingTime = deviceModel.getSensorRemainingTime();
                ((FragmentGlucosePanelBinding) getBinding()).btToPair.setVisibility(8);
                if (sensorRemainingTime == null) {
                    ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setVisibility(8);
                } else if (sensorRemainingTime.intValue() == -1 || sensorRemainingTime.intValue() <= 0) {
                    ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setText(getString(R.string.ble_state_sensor_expired_tip));
                    ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setText("");
                    ((FragmentGlucosePanelBinding) getBinding()).tvGlucoseState.setVisibility(8);
                    ((FragmentGlucosePanelBinding) getBinding()).btToPair.setVisibility(0);
                    ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setVisibility(0);
                    String deviceSn = deviceModel.getEntity().getDeviceSn();
                    if (deviceSn != null && MmkvManager.INSTANCE.needShowExpiredDialog(deviceSn)) {
                        Dialogs dialogs = Dialogs.INSTANCE;
                        FragmentActivity activity = getActivity();
                        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
                        Dialogs.showWhether$default(dialogs, (AppCompatActivity) activity, (String) null, getString(R.string.ble_state_sensor_expired_tip), new GlucosePanelFragment$update$4$1(this), (Function0) null, (String) null, getString(R.string.com_action_pair), (String) null, 0, 434, (Object) null);
                        MmkvManager.INSTANCE.shownExpiredDialog(deviceSn);
                    }
                } else if (sensorRemainingTime.intValue() < 24) {
                    TextView textView2 = ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime;
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String string = getResources().getString(R.string.com_time_remain_hour);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    String format = String.format(string, Arrays.copyOf(new Object[]{ExtendsKt.getNumberFormatWithLocale().format(sensorRemainingTime)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                    textView2.setText(format);
                    ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setVisibility(0);
                } else if (sensorRemainingTime.intValue() <= deviceModel.getEntity().getExpirationTime() * 24) {
                    int intValue3 = new BigDecimal(sensorRemainingTime.intValue()).divide(new BigDecimal(24), RoundingMode.CEILING).intValue();
                    TextView textView3 = ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime;
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    String string2 = getResources().getString(R.string.com_time_remain_day);
                    Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                    String format2 = String.format(string2, Arrays.copyOf(new Object[]{ExtendsKt.getNumberFormatWithLocale().format(Integer.valueOf(intValue3))}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                    textView3.setText(format2);
                    ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setVisibility(0);
                } else {
                    ((FragmentGlucosePanelBinding) getBinding()).tvSensorRemainTime.setVisibility(8);
                }
            }
        }
    }
}
