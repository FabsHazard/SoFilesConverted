package com.microtech.aidexx.ui.main.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.work.PeriodicWorkRequest;
import com.bumptech.glide.Glide;
import com.contrarywind.timer.MessageHandler;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.AidexBleAdapter;
import com.microtech.aidexx.ble.PendingIntentReceiver;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.compliance.EnquireManager;
import com.microtech.aidexx.common.net.entity.WelfareInfo;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.FragmentHomeBinding;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.ui.main.MainActivity;
import com.microtech.aidexx.ui.main.home.chart.ChartViewHolder;
import com.microtech.aidexx.ui.main.home.followers.FollowSwitchActivity;
import com.microtech.aidexx.ui.main.home.panel.GlucosePanelFragment;
import com.microtech.aidexx.ui.main.home.panel.NeedPairFragment;
import com.microtech.aidexx.ui.main.home.panel.NewOrUsedSensorFragment;
import com.microtech.aidexx.ui.main.home.panel.WarmingUpFragment;
import com.microtech.aidexx.ui.setting.SettingActivity;
import com.microtech.aidexx.ui.setting.SettingActivityKt;
import com.microtech.aidexx.ui.setting.share.ShareFollowViewModel;
import com.microtech.aidexx.ui.web.WebActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 M2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002MNB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010*\u001a\u00020%H\u0002J\b\u0010+\u001a\u00020%H\u0002J\b\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020%H\u0002J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0012\u00101\u001a\u00020%2\b\u00102\u001a\u0004\u0018\u000103H\u0016J$\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u0010:\u001a\u00020%H\u0016J\b\u0010;\u001a\u00020%H\u0016J\b\u0010<\u001a\u00020%H\u0016J\u001a\u0010=\u001a\u00020%2\u0006\u0010>\u001a\u0002052\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020\bH\u0003J\b\u0010A\u001a\u00020%H\u0002J\u0010\u0010B\u001a\u00020%2\u0006\u0010C\u001a\u00020\u0013H\u0002J\u001c\u0010D\u001a\u00020%2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0FH\u0002J\u0010\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020\u0013H\u0002J\b\u0010I\u001a\u00020%H\u0002J\b\u0010J\u001a\u00020%H\u0002J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u00020%H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\u0010\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010!\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010$\u0012\u0004\u0012\u00020%0#X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentHomeBinding;", "()V", "chartViewHolder", "Lcom/microtech/aidexx/ui/main/home/chart/ChartViewHolder;", "checkStep", "", "fixedRateToGetFollowListJob", "Lkotlinx/coroutines/Job;", "homeViewModel", "Lcom/microtech/aidexx/ui/main/home/HomeViewModel;", "getHomeViewModel", "()Lcom/microtech/aidexx/ui/main/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "initOrientation", "lastPageTag", "", "latestAppTime", "mHandler", "Landroid/os/Handler;", "mainActivity", "Lcom/microtech/aidexx/ui/main/MainActivity;", "pauseTimestamp", "", "Ljava/lang/Long;", "shareVm", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "getShareVm", "()Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "shareVm$delegate", "switchOrientation", "transChangeCallback", "Lkotlin/Function1;", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "", "welfareDialog", "Landroid/app/AlertDialog;", "welfareInfo", "Lcom/microtech/aidexx/common/net/entity/WelfareInfo;", "checkAndRefreshChart", "checkBtState", "checkPermission", "initEvent", "initView", "judgeState", "landSpace", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDetach", "onPause", "onResume", "onViewCreated", "view", "orientation", "type", "portrait", "replaceFragment", "pageTag", "showConnectState", "state", "Lkotlin/Pair;", "showWelfareDialog", "url", "startFixedRateToGetFollowListJob", "stopFixedRateToGetFollowListJob", "toWelfareCenter", "updateShareUserData", "Companion", "MainHandler", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
public final class HomeFragment extends BaseFragment<BaseViewModel, FragmentHomeBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int INTERVAL_CHART_TO_LATEST = 300000;
    public static final String TAG = "HomeFragment";
    private ChartViewHolder chartViewHolder;
    /* access modifiers changed from: private */
    public int checkStep;
    private Job fixedRateToGetFollowListJob;
    private final Lazy homeViewModel$delegate;
    private final int initOrientation;
    private String lastPageTag;
    private String latestAppTime;
    /* access modifiers changed from: private */
    public Handler mHandler;
    /* access modifiers changed from: private */
    public MainActivity mainActivity;
    private Long pauseTimestamp;
    private final Lazy shareVm$delegate;
    /* access modifiers changed from: private */
    public final int switchOrientation = 1;
    private Function1<? super DeviceModel, Unit> transChangeCallback;
    private AlertDialog welfareDialog;
    /* access modifiers changed from: private */
    public WelfareInfo welfareInfo;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HomeFragment.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.HomeFragment.WhenMappings.<clinit>():void");
        }
    }

    @JvmStatic
    public static final HomeFragment newInstance() {
        return Companion.newInstance();
    }

    public HomeFragment() {
        Fragment fragment = this;
        this.homeViewModel$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(HomeViewModel.class), new HomeFragment$special$$inlined$activityViewModels$default$1(fragment), new HomeFragment$special$$inlined$activityViewModels$default$2((Function0) null, fragment), new HomeFragment$special$$inlined$activityViewModels$default$3(fragment));
        Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, new HomeFragment$special$$inlined$viewModels$default$2(new HomeFragment$special$$inlined$viewModels$default$1(fragment)));
        this.shareVm$delegate = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(ShareFollowViewModel.class), new HomeFragment$special$$inlined$viewModels$default$3(lazy), new HomeFragment$special$$inlined$viewModels$default$4((Function0) null, lazy), new HomeFragment$special$$inlined$viewModels$default$5(fragment, lazy));
        this.transChangeCallback = new HomeFragment$transChangeCallback$1(this);
    }

    /* access modifiers changed from: private */
    public final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ShareFollowViewModel getShareVm() {
        return (ShareFollowViewModel) this.shareVm$delegate.getValue();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.Companion.d("onCreate", TAG);
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.microtech.aidexx.ui.main.MainActivity");
        MainActivity mainActivity2 = (MainActivity) activity;
        this.mainActivity = mainActivity2;
        if (mainActivity2 != null) {
            this.mHandler = new MainHandler(mainActivity2);
        }
        this.pauseTimestamp = null;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\u00030\u00030\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeFragment$MainHandler;", "Landroid/os/Handler;", "activity", "Lcom/microtech/aidexx/ui/main/MainActivity;", "(Lcom/microtech/aidexx/ui/main/MainActivity;)V", "batteryOptimizeDialogKey", "", "bluetoothPermissionDialog", "Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "ignoreBatteryDialog", "notificationDialogKey", "reference", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "storagePermissionDialog", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HomeFragment.kt */
    public static final class MainHandler extends Handler {
        private String batteryOptimizeDialogKey = ("battery-optimize-" + System.currentTimeMillis());
        private StandardDialog bluetoothPermissionDialog;
        private StandardDialog ignoreBatteryDialog;
        private String notificationDialogKey = ("notification-" + System.currentTimeMillis());
        private final WeakReference<MainActivity> reference;
        private StandardDialog storagePermissionDialog;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MainHandler(MainActivity mainActivity) {
            super(Looper.getMainLooper());
            Intrinsics.checkNotNullParameter(mainActivity, "activity");
            this.reference = new WeakReference<>(mainActivity);
        }

        public void handleMessage(Message message) {
            Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
            MainActivity mainActivity = (MainActivity) this.reference.get();
            if (mainActivity != null && !mainActivity.isFinishing()) {
                switch (message.what) {
                    case MessageHandler.WHAT_SMOOTH_SCROLL:
                        StandardDialog standardDialog = this.storagePermissionDialog;
                        if (standardDialog != null) {
                            standardDialog.dismiss();
                        }
                        String string = mainActivity.getString(R.string.permission_storage_title_ph, new Object[]{mainActivity.getString(R.string.app_name)});
                        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                        String string2 = mainActivity.getString(R.string.permission_storage_desc);
                        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
                        this.storagePermissionDialog = EnquireManager.showEnquireOrNot$default(EnquireManager.Companion.instance(), mainActivity, string, string2, new HomeFragment$MainHandler$handleMessage$1$1(mainActivity), (Function0) null, (String) null, 16, (Object) null);
                        return;
                    case 2001:
                        StandardDialog standardDialog2 = this.bluetoothPermissionDialog;
                        if (standardDialog2 != null) {
                            standardDialog2.dismiss();
                        }
                        String string3 = mainActivity.getString(R.string.permission_ble_title_ph, new Object[]{mainActivity.getString(R.string.app_name)});
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        String string4 = mainActivity.getString(R.string.permission_ble_desc);
                        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                        this.bluetoothPermissionDialog = EnquireManager.showEnquireOrNot$default(EnquireManager.Companion.instance(), mainActivity, string3, string4, new HomeFragment$MainHandler$handleMessage$1$2(mainActivity), (Function0) null, (String) null, 16, (Object) null);
                        return;
                    case 2002:
                        mainActivity.enableLocation();
                        return;
                    case 2003:
                        Object systemService = mainActivity.getSystemService("power");
                        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                        if (!((PowerManager) systemService).isIgnoringBatteryOptimizations(mainActivity.getPackageName())) {
                            StandardDialog standardDialog3 = this.ignoreBatteryDialog;
                            if (standardDialog3 != null) {
                                standardDialog3.dismiss();
                            }
                            this.ignoreBatteryDialog = Dialogs.showWhether$default(Dialogs.INSTANCE, mainActivity, (String) null, mainActivity.getString(R.string.permission_battery_ph, new Object[]{mainActivity.getString(R.string.app_name)}), new HomeFragment$MainHandler$handleMessage$1$5(mainActivity), HomeFragment$MainHandler$handleMessage$1$6.INSTANCE, this.batteryOptimizeDialogKey, (String) null, (String) null, 0, 450, (Object) null);
                            return;
                        }
                        return;
                    case PendingIntentReceiver.REQUEST_CODE:
                        mainActivity.enableBluetooth();
                        return;
                    case 2005:
                        Dialogs dialogs = Dialogs.INSTANCE;
                        String string5 = mainActivity.getString(R.string.permission_notify_desc);
                        this.ignoreBatteryDialog = Dialogs.showWhether$default(dialogs, mainActivity, mainActivity.getString(R.string.permission_notify_title_ph, new Object[]{mainActivity.getString(R.string.app_name)}), string5, new HomeFragment$MainHandler$handleMessage$1$3(mainActivity), HomeFragment$MainHandler$handleMessage$1$4.INSTANCE, this.notificationDialogKey, (String) null, (String) null, 0, 448, (Object) null);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public void onResume() {
        super.onResume();
        LogUtil.Companion.d("onResume", TAG);
        ChartViewHolder chartViewHolder2 = this.chartViewHolder;
        if (chartViewHolder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
            chartViewHolder2 = null;
        }
        chartViewHolder2.refreshMax();
        orientation(this.initOrientation);
        if (UserInfoManager.Companion.getShareUserInfo() != null) {
            startFixedRateToGetFollowListJob();
        }
        checkPermission();
        checkBtState();
        checkAndRefreshChart();
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel == null || !deviceModel.isPaired()) {
            HomeStateManager.Companion.instance().setState(HomeFragmentKt.needPair);
        }
    }

    private final void checkBtState() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$checkBtState$1(this, (Continuation<? super HomeFragment$checkBtState$1>) null), 3, (Object) null);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.Handler] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Handler] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5, types: [android.os.Handler] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7, types: [androidx.fragment.app.FragmentTransaction] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void checkPermission() {
        /*
            r9 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            com.microtech.aidexx.db.entity.UserEntity r0 = r0.getUserEntity()
            r1 = 0
            if (r0 == 0) goto L_0x0037
            int r0 = r0.isUnitGuide()
            if (r0 != 0) goto L_0x0037
            androidx.fragment.app.FragmentActivity r0 = r9.getActivity()
            if (r0 == 0) goto L_0x0023
            androidx.fragment.app.FragmentManager r0 = r0.getSupportFragmentManager()
            if (r0 == 0) goto L_0x0023
            androidx.fragment.app.FragmentTransaction r1 = r0.beginTransaction()
        L_0x0023:
            if (r1 == 0) goto L_0x0031
            com.microtech.aidexx.ui.main.home.UnitChoseFragment r0 = new com.microtech.aidexx.ui.main.home.UnitChoseFragment
            r0.<init>()
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            java.lang.String r2 = "UnitChoseFragment"
            r1.add((androidx.fragment.app.Fragment) r0, (java.lang.String) r2)
        L_0x0031:
            if (r1 == 0) goto L_0x0036
            r1.commitAllowingStateLoss()
        L_0x0036:
            return
        L_0x0037:
            com.microtech.aidexx.utils.permission.PermissionsUtil r0 = com.microtech.aidexx.utils.permission.PermissionsUtil.INSTANCE
            boolean r0 = r0.getGoSystemSettingShowing()
            if (r0 == 0) goto L_0x0040
            return
        L_0x0040:
            kotlin.jvm.internal.Ref$BooleanRef r0 = new kotlin.jvm.internal.Ref$BooleanRef
            r0.<init>()
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r2 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r2 = r2.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r2 = r2.getDefault()
            r3 = 31
            java.lang.String r4 = "requireActivity(...)"
            if (r2 == 0) goto L_0x009e
            boolean r5 = r2.isPaired()
            if (r5 == 0) goto L_0x009e
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r3) goto L_0x007b
            com.microtech.aidexx.utils.permission.PermissionsUtil r5 = com.microtech.aidexx.utils.permission.PermissionsUtil.INSTANCE
            androidx.fragment.app.FragmentActivity r6 = r9.requireActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            android.app.Activity r6 = (android.app.Activity) r6
            com.microtech.aidexx.utils.permission.PermissionGroups r7 = com.microtech.aidexx.utils.permission.PermissionGroups.INSTANCE
            java.lang.String[] r7 = r7.getBluetooth()
            com.microtech.aidexx.ui.main.home.HomeFragment$checkPermission$1 r8 = new com.microtech.aidexx.ui.main.home.HomeFragment$checkPermission$1
            r8.<init>(r9, r0)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r5.checkPermissions(r6, r7, r8)
            goto L_0x0096
        L_0x007b:
            com.microtech.aidexx.utils.permission.PermissionsUtil r5 = com.microtech.aidexx.utils.permission.PermissionsUtil.INSTANCE
            androidx.fragment.app.FragmentActivity r6 = r9.requireActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
            android.app.Activity r6 = (android.app.Activity) r6
            com.microtech.aidexx.utils.permission.PermissionGroups r7 = com.microtech.aidexx.utils.permission.PermissionGroups.INSTANCE
            java.lang.String[] r7 = r7.getLocation()
            com.microtech.aidexx.ui.main.home.HomeFragment$checkPermission$2 r8 = new com.microtech.aidexx.ui.main.home.HomeFragment$checkPermission$2
            r8.<init>(r9, r0)
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            r5.checkPermissions(r6, r7, r8)
        L_0x0096:
            boolean r0 = r0.element
            if (r0 == 0) goto L_0x009e
            r0 = 1
            r9.checkStep = r0
            return
        L_0x009e:
            com.microtech.aidexx.utils.LocationUtils r0 = com.microtech.aidexx.utils.LocationUtils.INSTANCE
            androidx.fragment.app.FragmentActivity r5 = r9.requireActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
            android.content.Context r5 = (android.content.Context) r5
            boolean r0 = r0.isLocationServiceEnable(r5)
            r4 = 3000(0xbb8, double:1.482E-320)
            java.lang.String r6 = "mHandler"
            if (r0 != 0) goto L_0x00dc
            int r0 = android.os.Build.VERSION.SDK_INT
            if (r0 >= r3) goto L_0x00dc
            if (r2 == 0) goto L_0x00dc
            boolean r0 = r2.isPaired()
            if (r0 == 0) goto L_0x00dc
            android.os.Handler r0 = r9.mHandler
            if (r0 != 0) goto L_0x00c7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r0 = r1
        L_0x00c7:
            r2 = 2002(0x7d2, float:2.805E-42)
            r0.removeMessages(r2)
            android.os.Handler r0 = r9.mHandler
            if (r0 != 0) goto L_0x00d4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x00d5
        L_0x00d4:
            r1 = r0
        L_0x00d5:
            r1.sendEmptyMessageDelayed(r2, r4)
            r0 = 2
            r9.checkStep = r0
            return
        L_0x00dc:
            androidx.fragment.app.FragmentActivity r0 = r9.requireActivity()
            android.content.Context r0 = (android.content.Context) r0
            boolean r0 = com.microtech.aidexx.utils.BleUtil.isBleEnable(r0)
            if (r0 != 0) goto L_0x010d
            if (r2 == 0) goto L_0x010d
            boolean r0 = r2.isPaired()
            if (r0 == 0) goto L_0x010d
            android.os.Handler r0 = r9.mHandler
            if (r0 != 0) goto L_0x00f8
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r0 = r1
        L_0x00f8:
            r2 = 2004(0x7d4, float:2.808E-42)
            r0.removeMessages(r2)
            android.os.Handler r0 = r9.mHandler
            if (r0 != 0) goto L_0x0105
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x0106
        L_0x0105:
            r1 = r0
        L_0x0106:
            r1.sendEmptyMessageDelayed(r2, r4)
            r0 = 3
            r9.checkStep = r0
            return
        L_0x010d:
            android.os.Handler r0 = r9.mHandler
            if (r0 != 0) goto L_0x0115
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r0 = r1
        L_0x0115:
            r2 = 2003(0x7d3, float:2.807E-42)
            r0.removeMessages(r2)
            android.os.Handler r0 = r9.mHandler
            if (r0 != 0) goto L_0x0122
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            goto L_0x0123
        L_0x0122:
            r1 = r0
        L_0x0123:
            r1.sendEmptyMessageDelayed(r2, r4)
            r0 = 6
            r9.checkStep = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.HomeFragment.checkPermission():void");
    }

    private final void showWelfareDialog(String str) {
        Window window;
        long welfareDialogTime = MmkvManager.INSTANCE.getWelfareDialogTime();
        AlertDialog alertDialog = this.welfareDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            return;
        }
        if (TimeUtils.INSTANCE.getCurrentTimeMillis() <= welfareDialogTime || !StringsKt.equals$default(ExtendsKt.formatToYMd(new Date()), ExtendsKt.formatToYMd(new Date(welfareDialogTime)), false, 2, (Object) null)) {
            MmkvManager.INSTANCE.saveWelfareDialogTime(TimeUtils.INSTANCE.getCurrentTimeMillis());
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setCancelable(false);
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_advert_dialog, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_close);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.iv_detail);
            Context context = getContext();
            if (context != null) {
                Glide.with(context).load(str).into(imageView2);
            }
            Intrinsics.checkNotNull(imageView2);
            ExtendsKt.setDebounceClickListener$default(imageView2, 0, new HomeFragment$$ExternalSyntheticLambda0(this), 1, (Object) null);
            Intrinsics.checkNotNull(imageView);
            ExtendsKt.setDebounceClickListener$default(imageView, 0, new HomeFragment$$ExternalSyntheticLambda1(this), 1, (Object) null);
            builder.setView(inflate);
            AlertDialog create = builder.create();
            this.welfareDialog = create;
            if (!(create == null || (window = create.getWindow()) == null)) {
                window.setBackgroundDrawableResource(17170445);
            }
            AlertDialog alertDialog2 = this.welfareDialog;
            if (alertDialog2 != null) {
                alertDialog2.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void showWelfareDialog$lambda$3(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        AlertDialog alertDialog = homeFragment.welfareDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = homeFragment.welfareDialog;
        if (alertDialog2 != null) {
            alertDialog2.cancel();
        }
        homeFragment.toWelfareCenter();
    }

    /* access modifiers changed from: private */
    public static final void showWelfareDialog$lambda$4(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        AlertDialog alertDialog = homeFragment.welfareDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog alertDialog2 = homeFragment.welfareDialog;
        if (alertDialog2 != null) {
            alertDialog2.cancel();
        }
    }

    public void onPause() {
        super.onPause();
        Handler handler = this.mHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            handler = null;
        }
        handler.removeCallbacksAndMessages((Object) null);
        stopFixedRateToGetFollowListJob();
        this.pauseTimestamp = Long.valueOf(System.currentTimeMillis());
    }

    public void onDetach() {
        super.onDetach();
        LogUtil.Companion.d("onDetach", TAG);
        HomeStateManager.Companion.instance().cancel();
        TransmitterManager.Companion.removeOnTransmitterChangeListener(this.transChangeCallback);
        HomeStateManager.Companion.setOnHomeStateChange((Function1<? super String, Unit>) null);
        HomeBackGroundSelector.Companion.instance().setOnLevelChange((Function1<? super Integer, Unit>) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        LogUtil.Companion.d("ChartViewModel homefragment onCreateView", TAG);
        FragmentHomeBinding inflate = FragmentHomeBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ((FragmentHomeBinding) getBinding()).layoutActionbar.setPadding(0, ExtendsKt.getStatusBarHeight() + ExtendsKt.dp2px((Number) 10), 0, 0);
        initView();
        initEvent();
        ConstraintLayout root = ((FragmentHomeBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        LogUtil.Companion.d("ChartViewModel homefragment onViewCreated", TAG);
        ChartViewHolder chartViewHolder2 = new ChartViewHolder((FragmentHomeBinding) getBinding(), this, new HomeFragment$onViewCreated$1(this));
        this.chartViewHolder = chartViewHolder2;
        chartViewHolder2.refreshTimezone();
    }

    private final void initView() {
        ImageView imageView = ((FragmentHomeBinding) getBinding()).welfareCenter;
        Intrinsics.checkNotNullExpressionValue(imageView, "welfareCenter");
        ExtendsKt.setDebounceClickListener$default(imageView, 0, new HomeFragment$$ExternalSyntheticLambda4(this), 1, (Object) null);
        judgeState();
        Boolean bool = BuildConfig.showConnectStates;
        Intrinsics.checkNotNullExpressionValue(bool, "showConnectStates");
        if (bool.booleanValue()) {
            AidexBleAdapter.Companion.getInstance().setOnConnectStateChangeCallback(new HomeFragment$initView$2(this));
        }
        HomeStateManager.Companion.setOnHomeStateChange(new HomeFragment$initView$3(this));
        HomeBackGroundSelector.Companion.instance().setOnLevelChange(new HomeFragment$initView$4(this));
        TransmitterManager.Companion.setOnTransmitterChangeListener(this.transChangeCallback);
        ImageView imageView2 = ((FragmentHomeBinding) getBinding()).ivScale;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivScale");
        ExtendsKt.setDebounceClickListener$default(imageView2, 0, new HomeFragment$$ExternalSyntheticLambda5(this), 1, (Object) null);
        ImageView imageView3 = ((FragmentHomeBinding) getBinding()).ivBack;
        Intrinsics.checkNotNullExpressionValue(imageView3, "ivBack");
        ExtendsKt.setDebounceClickListener$default(imageView3, 0, new HomeFragment$$ExternalSyntheticLambda6(this), 1, (Object) null);
        ImageView imageView4 = ((FragmentHomeBinding) getBinding()).userCenter;
        Intrinsics.checkNotNullExpressionValue(imageView4, "userCenter");
        ExtendsKt.setDebounceClickListener$default(imageView4, 0, new HomeFragment$$ExternalSyntheticLambda7(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.toWelfareCenter();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$6(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.orientation(homeFragment.switchOrientation);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$11(HomeFragment homeFragment, View view) {
        Long convertToCurZoneTs;
        String lastHistoryAppTime;
        Long convertToCurZoneTs2;
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        ChartViewHolder chartViewHolder2 = null;
        if (UserInfoManager.Companion.getShareUserInfo() == null) {
            DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
            if (deviceModel != null && (lastHistoryAppTime = deviceModel.getLastHistoryAppTime()) != null && (convertToCurZoneTs2 = ExtendsKt.convertToCurZoneTs(lastHistoryAppTime)) != null) {
                long longValue = convertToCurZoneTs2.longValue();
                Date date = new Date(longValue);
                ChartViewHolder chartViewHolder3 = homeFragment.chartViewHolder;
                if (chartViewHolder3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
                } else {
                    chartViewHolder2 = chartViewHolder3;
                }
                chartViewHolder2.backToNow(longValue);
                ((FragmentHomeBinding) homeFragment.getBinding()).chartDateTip.setText(ExtendsKt.formatToMd(date));
                return;
            }
            return;
        }
        String str = homeFragment.latestAppTime;
        if (str != null && (convertToCurZoneTs = ExtendsKt.convertToCurZoneTs(str)) != null) {
            long longValue2 = convertToCurZoneTs.longValue();
            Date date2 = new Date(longValue2);
            ChartViewHolder chartViewHolder4 = homeFragment.chartViewHolder;
            if (chartViewHolder4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
            } else {
                chartViewHolder2 = chartViewHolder4;
            }
            chartViewHolder2.backToNow(longValue2);
            ((FragmentHomeBinding) homeFragment.getBinding()).chartDateTip.setText(ExtendsKt.formatToMd(date2));
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$12(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        homeFragment.startActivity(new Intent(homeFragment.getActivity(), SettingActivity.class));
    }

    /* access modifiers changed from: private */
    public final void showConnectState(Pair<Integer, Integer> pair) {
        if (pair.getFirst().intValue() == 0 && pair.getSecond().intValue() == 2) {
            ((FragmentHomeBinding) getBinding()).ivConnectState.setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_connected));
        } else {
            ((FragmentHomeBinding) getBinding()).ivConnectState.setImageDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.ic_disconnect));
        }
    }

    private final void toWelfareCenter() {
        WebActivity.Companion companion = WebActivity.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        WebActivity.Companion.loadWeb$default(companion, requireContext, (String) null, SettingActivityKt.getWelfareCenterUrl(), true, "welfare_center", 2, (Object) null);
    }

    private final void initEvent() {
        FragmentHomeBinding fragmentHomeBinding = (FragmentHomeBinding) getBinding();
        TextView textView = fragmentHomeBinding.dataOwner;
        Intrinsics.checkNotNullExpressionValue(textView, "dataOwner");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new HomeFragment$$ExternalSyntheticLambda2(fragmentHomeBinding), 1, (Object) null);
        ImageView imageView = fragmentHomeBinding.switchUserData;
        Intrinsics.checkNotNullExpressionValue(imageView, "switchUserData");
        ExtendsKt.setDebounceClickListener$default(imageView, 0, new HomeFragment$$ExternalSyntheticLambda3(this), 1, (Object) null);
        LifecycleOwner lifecycleOwner = this;
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_UNPAIR_RESULT, lifecycleOwner, HomeFragment$initEvent$2.INSTANCE);
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_PAIR_RESULT, lifecycleOwner, HomeFragment$initEvent$3.INSTANCE);
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_HYP_CHANGE, lifecycleOwner, HomeFragment$initEvent$4.INSTANCE);
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_SWITCH_USER, lifecycleOwner, new HomeFragment$initEvent$5(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_FOLLOWERS_UPDATED, lifecycleOwner, new HomeFragment$initEvent$6(this));
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$17$lambda$13(FragmentHomeBinding fragmentHomeBinding, View view) {
        Intrinsics.checkNotNullParameter(fragmentHomeBinding, "$this_apply");
        fragmentHomeBinding.switchUserData.performClick();
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$17$lambda$16(HomeFragment homeFragment, View view) {
        Intrinsics.checkNotNullParameter(homeFragment, "this$0");
        ActivityUtil activityUtil = ActivityUtil.INSTANCE;
        Context requireContext = homeFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(homeFragment.getHomeViewModel().getMFollowers());
        Unit unit = Unit.INSTANCE;
        bundle.putParcelableArrayList(FollowSwitchActivity.EXTRA_LIST_DATA, arrayList);
        Unit unit2 = Unit.INSTANCE;
        activityUtil.toActivity(requireContext, bundle, (Class<?>) FollowSwitchActivity.class);
    }

    /* access modifiers changed from: private */
    public final void judgeState() {
        String str;
        TransmitterEntity entity;
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        TextView textView = ((FragmentHomeBinding) getBinding()).tvSn;
        if (deviceModel == null || (entity = deviceModel.getEntity()) == null || (str = entity.getDeviceSn()) == null) {
            str = "";
        }
        textView.setText(str);
        if (deviceModel == null || !deviceModel.isPaired()) {
            replaceFragment(HomeFragmentKt.needPair);
        } else {
            replaceFragment(HomeFragmentKt.glucosePanel);
        }
        Boolean bool = BuildConfig.showConnectStates;
        Intrinsics.checkNotNullExpressionValue(bool, "showConnectStates");
        if (bool.booleanValue()) {
            showConnectState(AidexBleAdapter.Companion.getInstance().getConnectStatus());
            ImageView imageView = ((FragmentHomeBinding) getBinding()).ivConnectState;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivConnectState");
            View view = imageView;
            CharSequence text = ((FragmentHomeBinding) getBinding()).tvSn.getText();
            Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
            int i = 0;
            if (text.length() > 0) {
                i = 4;
            }
            view.setVisibility(i);
        }
    }

    /* access modifiers changed from: private */
    public final void replaceFragment(String str) {
        BaseFragment baseFragment;
        if (!Intrinsics.areEqual((Object) str, (Object) this.lastPageTag)) {
            if (!Intrinsics.areEqual((Object) str, (Object) HomeFragmentKt.glucosePanel)) {
                ((FragmentHomeBinding) getBinding()).homeRoot.setBackgroundResource(0);
            }
            switch (str.hashCode()) {
                case -1767675208:
                    if (str.equals(HomeFragmentKt.warmingUp)) {
                        baseFragment = WarmingUpFragment.Companion.newInstance();
                        break;
                    } else {
                        return;
                    }
                case 865543312:
                    if (str.equals(HomeFragmentKt.needPair)) {
                        baseFragment = NeedPairFragment.Companion.newInstance();
                        break;
                    } else {
                        return;
                    }
                case 900030938:
                    if (str.equals(HomeFragmentKt.newOrUsedSensor)) {
                        baseFragment = NewOrUsedSensorFragment.Companion.newInstance();
                        break;
                    } else {
                        return;
                    }
                case 1677342390:
                    if (str.equals(HomeFragmentKt.glucosePanel)) {
                        baseFragment = GlucosePanelFragment.Companion.newInstance();
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
            if (getChildFragmentManager().findFragmentByTag(str) == null) {
                try {
                    FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
                    Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction(...)");
                    beginTransaction.replace(R.id.fcv_panel, (Fragment) baseFragment, str);
                    beginTransaction.commitAllowingStateLoss();
                } catch (Exception unused) {
                    LogUtil.Companion.eAiDEX("Transaction commitAllowingStateLoss error");
                }
                this.lastPageTag = str;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void orientation(int i) {
        MainActivity mainActivity2 = this.mainActivity;
        ChartViewHolder chartViewHolder2 = null;
        if (mainActivity2 == null || mainActivity2.getMCurrentOrientation() != 2) {
            MainActivity mainActivity3 = this.mainActivity;
            if (mainActivity3 != null && mainActivity3.getMCurrentOrientation() == 1) {
                if (this.switchOrientation == i) {
                    ChartViewHolder chartViewHolder3 = this.chartViewHolder;
                    if (chartViewHolder3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
                    } else {
                        chartViewHolder2 = chartViewHolder3;
                    }
                    chartViewHolder2.notifyOrientationChange();
                    MainActivity mainActivity4 = this.mainActivity;
                    if (mainActivity4 != null) {
                        mainActivity4.setMCurrentOrientation(2);
                    }
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.setRequestedOrientation(0);
                    }
                    landSpace();
                } else {
                    portrait();
                }
            }
        } else if (this.switchOrientation == i) {
            ChartViewHolder chartViewHolder4 = this.chartViewHolder;
            if (chartViewHolder4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
            } else {
                chartViewHolder2 = chartViewHolder4;
            }
            chartViewHolder2.notifyOrientationChange();
            MainActivity mainActivity5 = this.mainActivity;
            if (mainActivity5 != null) {
                mainActivity5.setMCurrentOrientation(1);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.setRequestedOrientation(1);
            }
            portrait();
        } else {
            landSpace();
        }
        MainActivity mainActivity6 = this.mainActivity;
        if (mainActivity6 != null) {
            mainActivity6.fitHomeOrientation();
        }
    }

    private final void landSpace() {
        ((FragmentHomeBinding) getBinding()).bottomSpace.setVisibility(8);
        ((FragmentHomeBinding) getBinding()).layoutState.setVisibility(8);
        ((FragmentHomeBinding) getBinding()).layoutActionbar.setVisibility(8);
        ImageView imageView = ((FragmentHomeBinding) getBinding()).ivScale;
        Context context = getContext();
        imageView.setImageDrawable(context != null ? ContextCompat.getDrawable(context, R.drawable.ic_scale_to_small) : null);
        ((FragmentHomeBinding) getBinding()).serviceView.hide();
    }

    private final void portrait() {
        ((FragmentHomeBinding) getBinding()).layoutState.setVisibility(0);
        ((FragmentHomeBinding) getBinding()).bottomSpace.setVisibility(0);
        ((FragmentHomeBinding) getBinding()).layoutActionbar.setVisibility(0);
        ImageView imageView = ((FragmentHomeBinding) getBinding()).ivScale;
        Context context = getContext();
        imageView.setImageDrawable(context != null ? ContextCompat.getDrawable(context, R.drawable.ic_scale) : null);
        ((FragmentHomeBinding) getBinding()).serviceView.show();
    }

    private final void startFixedRateToGetFollowListJob() {
        Job job = this.fixedRateToGetFollowListJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.fixedRateToGetFollowListJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new HomeFragment$startFixedRateToGetFollowListJob$1(this, (Continuation<? super HomeFragment$startFixedRateToGetFollowListJob$1>) null), 3, (Object) null);
    }

    private final void stopFixedRateToGetFollowListJob() {
        Job job = this.fixedRateToGetFollowListJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0025, code lost:
        r4 = r4.getDeviceSn();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateShareUserData() {
        /*
            r22 = this;
            r0 = r22
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r1 = r1.getShareUserInfo()
            if (r1 == 0) goto L_0x0220
            androidx.viewbinding.ViewBinding r2 = r22.getBinding()
            com.microtech.aidexx.databinding.FragmentHomeBinding r2 = (com.microtech.aidexx.databinding.FragmentHomeBinding) r2
            android.widget.TextView r3 = r2.dataOwner
            java.lang.String r4 = r1.getDisplayName()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            android.widget.TextView r3 = r2.tvSn
            com.microtech.aidexx.ui.setting.share.CgmDevice r4 = r1.getCgmDevice()
            java.lang.String r5 = ""
            if (r4 == 0) goto L_0x002e
            java.lang.String r4 = r4.getDeviceSn()
            if (r4 == 0) goto L_0x002e
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            goto L_0x0031
        L_0x002e:
            r4 = r5
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
        L_0x0031:
            r3.setText(r4)
            java.lang.Boolean r3 = com.microtech.aidexx.BuildConfig.showConnectStates
            java.lang.String r4 = "showConnectStates"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r3 = r3.booleanValue()
            r4 = 1
            r6 = 0
            if (r3 == 0) goto L_0x0068
            android.widget.ImageView r3 = r2.ivConnectState
            java.lang.String r7 = "ivConnectState"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            android.view.View r3 = (android.view.View) r3
            android.widget.TextView r7 = r2.tvSn
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r8 = "getText(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x005f
            r7 = r4
            goto L_0x0060
        L_0x005f:
            r7 = r6
        L_0x0060:
            if (r7 == 0) goto L_0x0064
            r7 = 4
            goto L_0x0065
        L_0x0064:
            r7 = r6
        L_0x0065:
            r3.setVisibility(r7)
        L_0x0068:
            com.microtech.aidexx.databinding.FragmentGlucoseShareBinding r2 = r2.frgShare
            java.lang.String r3 = r1.getSensorStatusDesc()
            java.lang.String r7 = r1.getLatestValueTimeStr()
            if (r3 == 0) goto L_0x0076
            r8 = r6
            goto L_0x0081
        L_0x0076:
            int r8 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r8 = r0.getString(r8)
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            r8 = r8 ^ r4
        L_0x0081:
            if (r8 == 0) goto L_0x0088
            java.lang.String r10 = r1.getGlucoseValue()
            goto L_0x0089
        L_0x0088:
            r10 = 0
        L_0x0089:
            android.widget.TextView r11 = r2.tvGlucoseValueShare
            if (r10 == 0) goto L_0x0091
            r12 = r10
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            goto L_0x0099
        L_0x0091:
            int r12 = com.microtech.aidexx.R.string.com_unknown
            java.lang.String r12 = r0.getString(r12)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
        L_0x0099:
            r11.setText(r12)
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r11 = r1.getUserTrend()
            if (r11 == 0) goto L_0x00ae
            java.lang.String r12 = r11.getAppTime()
            if (r12 == 0) goto L_0x00ae
            java.lang.String r11 = r11.getAppTime()
            r0.latestAppTime = r11
        L_0x00ae:
            com.microtech.aidexx.db.entity.SettingsEntity r11 = r1.getUserSetting()
            r12 = 8
            if (r11 == 0) goto L_0x0126
            java.lang.String r13 = r11.getTimeZone()
            java.lang.String r14 = "timezoneInfo"
            if (r13 != 0) goto L_0x00d0
            com.microtech.aidexx.utils.LogUtil$Companion r11 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r13 = "Share info.appTimeZone == null || info.appTime == null"
            r11.eAiDEX(r13)
            androidx.constraintlayout.widget.ConstraintLayout r11 = r2.timezoneInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r14)
            android.view.View r11 = (android.view.View) r11
            r11.setVisibility(r12)
            goto L_0x0123
        L_0x00d0:
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat
            java.lang.String r15 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r9 = java.util.Locale.ENGLISH
            r13.<init>(r15, r9)
            java.lang.String r9 = r11.getTimeZone()
            java.util.TimeZone r9 = java.util.TimeZone.getTimeZone(r9)
            r13.setTimeZone(r9)
            android.widget.TextView r9 = r2.shareCurrentTime
            android.content.Context r15 = r22.getContext()
            if (r15 == 0) goto L_0x0113
            int r4 = com.microtech.aidexx.R.string.timeZone_time
            com.microtech.aidexx.utils.TimeUtils r16 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
            java.lang.String r17 = r11.getTimeZone()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r17)
            r20 = 2
            r21 = 0
            r18 = 0
            java.lang.String r11 = com.microtech.aidexx.utils.TimeUtils.getTimezoneOffset$default(r16, r17, r18, r20, r21)
            java.util.Date r12 = new java.util.Date
            r12.<init>()
            java.lang.String r12 = r13.format(r12)
            java.lang.Object[] r11 = new java.lang.Object[]{r11, r12}
            java.lang.String r4 = r15.getString(r4, r11)
            goto L_0x0114
        L_0x0113:
            r4 = 0
        L_0x0114:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r9.setText(r4)
            androidx.constraintlayout.widget.ConstraintLayout r4 = r2.timezoneInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r14)
            android.view.View r4 = (android.view.View) r4
            r4.setVisibility(r6)
        L_0x0123:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x012b
        L_0x0126:
            com.microtech.aidexx.ui.main.home.HomeFragment$updateShareUserData$1$1$1$3 r4 = new com.microtech.aidexx.ui.main.home.HomeFragment$updateShareUserData$1$1$1$3
            r4.<init>(r2)
        L_0x012b:
            android.widget.TextView r4 = r2.tvUnitShare
            java.lang.String r9 = "tvUnitShare"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            android.view.View r4 = (android.view.View) r4
            if (r10 == 0) goto L_0x0138
            r10 = 1
            goto L_0x0139
        L_0x0138:
            r10 = r6
        L_0x0139:
            if (r10 == 0) goto L_0x013d
            r10 = r6
            goto L_0x013f
        L_0x013d:
            r10 = 8
        L_0x013f:
            r4.setVisibility(r10)
            android.widget.TextView r4 = r2.tvUnitShare
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r9)
            android.view.View r4 = (android.view.View) r4
            int r4 = r4.getVisibility()
            if (r4 != 0) goto L_0x015c
            android.widget.TextView r4 = r2.tvUnitShare
            com.microtech.aidexx.utils.UnitManager r9 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r9 = r9.getDisplayUnit()
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            r4.setText(r9)
        L_0x015c:
            if (r8 == 0) goto L_0x015f
            r3 = 0
        L_0x015f:
            java.lang.String r4 = "tvGlucoseStateShare"
            java.lang.String r9 = "tvValueTimeShare"
            if (r3 == 0) goto L_0x018d
            android.widget.TextView r10 = r2.tvValueTimeShare
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 8
            r10.setVisibility(r11)
            android.widget.TextView r10 = r2.tvValueTimeShare
            r11 = r5
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r10.setText(r11)
            android.widget.TextView r10 = r2.tvGlucoseStateShare
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
            android.view.View r10 = (android.view.View) r10
            r10.setVisibility(r6)
            android.widget.TextView r10 = r2.tvGlucoseStateShare
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r10.setText(r3)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x018e
        L_0x018d:
            r3 = 0
        L_0x018e:
            if (r3 != 0) goto L_0x01b4
            android.widget.TextView r3 = r2.tvValueTimeShare
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r9)
            android.view.View r3 = (android.view.View) r3
            r3.setVisibility(r6)
            android.widget.TextView r3 = r2.tvValueTimeShare
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r3.setText(r7)
            android.widget.TextView r3 = r2.tvGlucoseStateShare
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.view.View r3 = (android.view.View) r3
            r4 = 8
            r3.setVisibility(r4)
            android.widget.TextView r3 = r2.tvGlucoseStateShare
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x01b4:
            android.widget.TextView r3 = r2.tvSensorRemainTimeShare
            java.lang.String r4 = r1.getSensorLeftTime()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r3 = r1.getUserTrend()
            if (r3 == 0) goto L_0x01ea
            android.view.View r4 = r2.bgPanelShare
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r3 = r3.getGlucoseTrend()
            if (r3 != 0) goto L_0x01cf
            r3 = -1
            goto L_0x01d7
        L_0x01cf:
            int[] r5 = com.microtech.aidexx.ui.main.home.HomeFragment.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r5[r3]
        L_0x01d7:
            r5 = 1
            if (r3 == r5) goto L_0x01e5
            r5 = 2
            if (r3 == r5) goto L_0x01e5
            r5 = 3
            if (r3 == r5) goto L_0x01e2
            r3 = 0
            goto L_0x01e7
        L_0x01e2:
            r3 = -1028390912(0xffffffffc2b40000, float:-90.0)
            goto L_0x01e7
        L_0x01e5:
            r3 = 1127481344(0x43340000, float:180.0)
        L_0x01e7:
            r4.setRotation(r3)
        L_0x01ea:
            android.view.View r2 = r2.bgPanelShare
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector$Companion r3 = com.microtech.aidexx.ui.main.home.HomeBackGroundSelector.Companion
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector r3 = r3.instance()
            if (r8 == 0) goto L_0x01ff
            com.microtech.aidexx.ui.setting.share.UserTrendInfo r4 = r1.getUserTrend()
            if (r4 == 0) goto L_0x01ff
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r4 = r4.getGlucoseTrend()
            goto L_0x0200
        L_0x01ff:
            r4 = 0
        L_0x0200:
            if (r8 == 0) goto L_0x0207
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r5 = r1.getGlucoseLevel()
            goto L_0x0208
        L_0x0207:
            r5 = 0
        L_0x0208:
            int r3 = r3.getBgForTrend(r4, r5)
            r2.setBackgroundResource(r3)
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector$Companion r2 = com.microtech.aidexx.ui.main.home.HomeBackGroundSelector.Companion
            com.microtech.aidexx.ui.main.home.HomeBackGroundSelector r2 = r2.instance()
            if (r8 == 0) goto L_0x021c
            com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseLevel r9 = r1.getGlucoseLevel()
            goto L_0x021d
        L_0x021c:
            r9 = 0
        L_0x021d:
            r2.getHomeBg(r9)
        L_0x0220:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.HomeFragment.updateShareUserData():void");
    }

    private final void checkAndRefreshChart() {
        Long l = this.pauseTimestamp;
        if (l != null) {
            if (System.currentTimeMillis() - l.longValue() >= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
                LogUtil.Companion.xLogI("后台停留超过 5 分钟，唤醒后自动滚动到最新位置", TAG);
                ChartViewHolder chartViewHolder2 = this.chartViewHolder;
                if (chartViewHolder2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
                    chartViewHolder2 = null;
                }
                ChartViewHolder.notifyChartDataChange$default(chartViewHolder2, true, (Date) null, 2, (Object) null);
                return;
            }
            ChartViewHolder chartViewHolder3 = this.chartViewHolder;
            if (chartViewHolder3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
                chartViewHolder3 = null;
            }
            if (chartViewHolder3.getMarkToRefreshChart()) {
                LogUtil.Companion.xLogI("唤醒后需要刷新图表 markToRefreshChart=true", TAG);
                ChartViewHolder chartViewHolder4 = this.chartViewHolder;
                if (chartViewHolder4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("chartViewHolder");
                    chartViewHolder4 = null;
                }
                ChartViewHolder.notifyChartDataChange$default(chartViewHolder4, false, (Date) null, 3, (Object) null);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/HomeFragment$Companion;", "", "()V", "INTERVAL_CHART_TO_LATEST", "", "TAG", "", "newInstance", "Lcom/microtech/aidexx/ui/main/home/HomeFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: HomeFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HomeFragment newInstance() {
            return new HomeFragment();
        }
    }
}
