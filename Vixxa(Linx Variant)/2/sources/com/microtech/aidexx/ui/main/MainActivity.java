package com.microtech.aidexx.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.activity.ComponentActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.viewpager2.widget.ViewPager2;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.sdk.PushManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseWelcomeActivity;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.databinding.ActivityMainBinding;
import com.microtech.aidexx.ota.OtaManager;
import com.microtech.aidexx.service.LocalNotificationManager;
import com.microtech.aidexx.service.MainService;
import com.microtech.aidexx.ui.account.AccountViewModel;
import com.microtech.aidexx.ui.main.home.HomeViewModel;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.ui.setting.timezonehistory.TimezoneHistoryManager;
import com.microtech.aidexx.ui.welcome.WelcomeActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import com.microtech.aidexx.utils.statusbar.StatusBarHelper;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.mars.xlog.Log;
import java.util.Date;
import java.util.TimeZone;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001*B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\u0006\u0010\u0015\u001a\u00020\u0014J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\b\u0010\u001a\u001a\u00020\u0014H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\b\u0010 \u001a\u00020\u0014H\u0014J\u0012\u0010!\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0014H\u0014J\b\u0010%\u001a\u00020\u0014H\u0014J\u001c\u0010&\u001a\u00020\u00142\b\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010'\u001a\u00020\u0012H\u0002J\u0012\u0010(\u001a\u00020\u00142\b\b\u0002\u0010)\u001a\u00020\u0012H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006+"}, d2 = {"Lcom/microtech/aidexx/ui/main/MainActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/ui/account/AccountViewModel;", "Lcom/microtech/aidexx/databinding/ActivityMainBinding;", "()V", "homeViewModel", "Lcom/microtech/aidexx/ui/main/home/HomeViewModel;", "getHomeViewModel", "()Lcom/microtech/aidexx/ui/main/home/HomeViewModel;", "homeViewModel$delegate", "Lkotlin/Lazy;", "mCurrentOrientation", "", "getMCurrentOrientation", "()I", "setMCurrentOrientation", "(I)V", "checkAndUpdateResourceIfNeeded", "", "checkTimeZoneChange", "", "fitHomeOrientation", "getViewBinding", "initEvent", "initSDKs", "initSmartRefreshLayoutHeaderTipText", "initView", "loadData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onResume", "onStart", "processIntent", "fromOnCreate", "recreateMain", "showDialog", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainActivity.kt */
public final class MainActivity extends BaseActivity<AccountViewModel, ActivityMainBinding> {
    public static final int BG = 3;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EVENT = 4;
    public static final int HISTORY = 0;
    public static final int HOME = 2;
    /* access modifiers changed from: private */
    public static final String TAG = "MainActivity";
    public static final int TRENDS = 1;
    private final Lazy homeViewModel$delegate;
    private int mCurrentOrientation = 1;

    public MainActivity() {
        ComponentActivity componentActivity = this;
        this.homeViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(HomeViewModel.class), new MainActivity$special$$inlined$viewModels$default$2(componentActivity), new MainActivity$special$$inlined$viewModels$default$1(componentActivity), new MainActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    public final int getMCurrentOrientation() {
        return this.mCurrentOrientation;
    }

    public final void setMCurrentOrientation(int i) {
        this.mCurrentOrientation = i;
    }

    private final HomeViewModel getHomeViewModel() {
        return (HomeViewModel) this.homeViewModel$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/ui/main/MainActivity$Companion;", "", "()V", "BG", "", "EVENT", "HISTORY", "HOME", "TAG", "", "kotlin.jvm.PlatformType", "TRENDS", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MainActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent(intent, false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        ThemeManager.INSTANCE.themeConfig();
        super.onCreate(bundle);
        UserInfoManager.Companion.setShareUserInfo((ShareUserInfo) null);
        setContentView((View) ((ActivityMainBinding) getBinding()).getRoot());
        initSDKs();
        fitHomeOrientation();
        initView();
        loadData();
        initEvent();
        processIntent$default(this, getIntent(), false, 2, (Object) null);
        initSmartRefreshLayoutHeaderTipText();
    }

    private final void initEvent() {
        LifecycleOwner lifecycleOwner = this;
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_JUMP_TO_TAB, lifecycleOwner, new MainActivity$initEvent$1(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.DST_CHANGE, lifecycleOwner, new MainActivity$initEvent$2(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_GO_TO_HISTORY, lifecycleOwner, new MainActivity$initEvent$3(this));
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        try {
            if (!ActivityUtil.INSTANCE.isServiceRunning(this, MainService.class)) {
                Intent intent = new Intent(this, MainService.class);
                if (Build.VERSION.SDK_INT >= 33) {
                    if (ActivityCompat.checkSelfPermission(this, "android.permission.BLUETOOTH_CONNECT") == 0) {
                        intent.setAction("START_FOREGROUND");
                        startForegroundService(intent);
                    } else {
                        intent.setAction("NOT_START_FOREGROUND");
                        startService(intent);
                    }
                } else if (Build.VERSION.SDK_INT >= 26) {
                    intent.setAction("START_FOREGROUND");
                    startForegroundService(intent);
                } else {
                    intent.setAction("START_FOREGROUND");
                    startService(intent);
                }
                LogUtil.Companion.eAiDEX("start main service");
                return;
            }
            LogUtil.Companion.eAiDEX("main service is running, need not start");
        } catch (Exception e) {
            LogUtil.Companion.eAiDEX("start main service error:" + e.getMessage());
        }
    }

    private final void loadData() {
        EventUnitManager.loadUnit$default(EventUnitManager.INSTANCE, LanguageResourceManager.INSTANCE.getCurLanguageTag(), (CoroutineScope) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LifecycleOwner lifecycleOwner = this;
        LocalNotificationManager.INSTANCE.cancelLocalNotifications(this, LifecycleOwnerKt.getLifecycleScope(lifecycleOwner));
        if (!checkAndUpdateResourceIfNeeded()) {
            checkTimeZoneChange();
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$onResume$1(this, (Continuation<? super MainActivity$onResume$1>) null), 3, (Object) null);
            OtaManager.Companion.instance().uploadOtaInfo();
        }
    }

    /* access modifiers changed from: private */
    public final void checkTimeZoneChange() {
        if (TimezoneHistoryManager.INSTANCE.getNeedRefreshChart().getFirst().booleanValue()) {
            recreateMain(TimezoneHistoryManager.INSTANCE.getNeedRefreshChart().getSecond().booleanValue());
            TimezoneHistoryManager.INSTANCE.setNeedRefreshChart(new Pair(false, false));
            return;
        }
        TimeZone timeZone = TimeZone.getDefault();
        if (SettingsManager.INSTANCE.getTimezone() != null) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String timezone = SettingsManager.INSTANCE.getTimezone();
            Intrinsics.checkNotNull(timezone);
            String timezoneOffset$default = TimeUtils.getTimezoneOffset$default(timeUtils, timezone, 0, 2, (Object) null);
            TimeUtils timeUtils2 = TimeUtils.INSTANCE;
            String id = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id, "getID(...)");
            if (!Intrinsics.areEqual((Object) timezoneOffset$default, (Object) TimeUtils.getTimezoneOffset$default(timeUtils2, id, 0, 2, (Object) null))) {
                TimezoneHistoryManager timezoneHistoryManager = TimezoneHistoryManager.INSTANCE;
                String timezone2 = SettingsManager.INSTANCE.getTimezone();
                Intrinsics.checkNotNull(timezone2);
                String id2 = timeZone.getID();
                Intrinsics.checkNotNullExpressionValue(id2, "getID(...)");
                timezoneHistoryManager.createTimezoneHistory(timezone2, id2, false, timeZone.getDSTSavings() / 1000);
                SettingsManager settingsManager = SettingsManager.INSTANCE;
                String id3 = timeZone.getID();
                Intrinsics.checkNotNullExpressionValue(id3, "getID(...)");
                settingsManager.setTimezone(id3);
                SettingsManager.INSTANCE.setInDaylightTime(timeZone.inDaylightTime(new Date()));
                recreateMain$default(this, false, 1, (Object) null);
                return;
            }
            boolean inDaylightTime = timeZone.inDaylightTime(new Date());
            if (SettingsManager.INSTANCE.inDaylightTime() == null) {
                SettingsManager.INSTANCE.setInDaylightTime(inDaylightTime);
            } else if (Intrinsics.areEqual((Object) Boolean.valueOf(inDaylightTime), (Object) SettingsManager.INSTANCE.inDaylightTime())) {
            } else {
                if (timeZone.getRawOffset() == TimeZone.getTimeZone(SettingsManager.INSTANCE.getTimezone()).getRawOffset()) {
                    TimezoneHistoryManager timezoneHistoryManager2 = TimezoneHistoryManager.INSTANCE;
                    String timezone3 = SettingsManager.INSTANCE.getTimezone();
                    Intrinsics.checkNotNull(timezone3);
                    String id4 = timeZone.getID();
                    Intrinsics.checkNotNullExpressionValue(id4, "getID(...)");
                    timezoneHistoryManager2.createTimezoneHistory(timezone3, id4, true, timeZone.getDSTSavings() / 1000);
                    SettingsManager settingsManager2 = SettingsManager.INSTANCE;
                    String id5 = timeZone.getID();
                    Intrinsics.checkNotNullExpressionValue(id5, "getID(...)");
                    settingsManager2.setTimezone(id5);
                    SettingsManager.INSTANCE.setInDaylightTime(inDaylightTime);
                    recreateMain$default(this, false, 1, (Object) null);
                    return;
                }
                SettingsManager settingsManager3 = SettingsManager.INSTANCE;
                String id6 = timeZone.getID();
                Intrinsics.checkNotNullExpressionValue(id6, "getID(...)");
                settingsManager3.setTimezone(id6);
                SettingsManager.INSTANCE.setInDaylightTime(inDaylightTime);
                recreateMain(false);
            }
        } else {
            SettingsManager settingsManager4 = SettingsManager.INSTANCE;
            String id7 = timeZone.getID();
            Intrinsics.checkNotNullExpressionValue(id7, "getID(...)");
            settingsManager4.setTimezone(id7);
        }
    }

    static /* synthetic */ void recreateMain$default(MainActivity mainActivity, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        mainActivity.recreateMain(z);
    }

    private final void recreateMain(boolean z) {
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel == null || deviceModel.isSensorExpired() || !z) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new MainActivity$recreateMain$2(this, (Continuation<? super MainActivity$recreateMain$2>) null), 3, (Object) null);
        } else {
            Dialogs.INSTANCE.showMessage(this, getString(R.string.timeZone_alert_title), getString(R.string.timeZone_alert_subtitle), getString(R.string.timeZone_alert_note), getString(R.string.timeZone_alert_yes), new MainActivity$recreateMain$1(this));
        }
    }

    private final void initView() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(this);
        ActivityMainBinding activityMainBinding = (ActivityMainBinding) getBinding();
        ViewPager2 viewPager2 = activityMainBinding.viewpager;
        viewPager2.setAdapter(mainViewPagerAdapter);
        viewPager2.setUserInputEnabled(false);
        viewPager2.setCurrentItem(2, false);
        viewPager2.registerOnPageChangeCallback(new MainActivity$initView$1$1$1(this));
        ((ActivityMainBinding) getBinding()).viewpager.getViewTreeObserver().addOnGlobalLayoutListener(new MainActivity$initView$1$2(this));
        activityMainBinding.mainTabView.setOnTabChange(new MainActivity$initView$1$3(this, activityMainBinding));
    }

    private final void initSDKs() {
        PushManager.getInstance().initialize(this);
        CrashReport.initCrashReport(getApplicationContext(), "b2c5f05676", false);
    }

    private static final void initSDKs$lambda$2(String str) {
        Log.i("PUSH_LOG", str);
    }

    public final void fitHomeOrientation() {
        Window window = getWindow();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        if (this.mCurrentOrientation == 2) {
            ((ActivityMainBinding) getBinding()).mainTabView.setVisibility(8);
            ((ActivityMainBinding) getBinding()).bottomSpace.setVisibility(8);
            if (Build.VERSION.SDK_INT >= 30) {
                WindowInsetsController insetsController = window.getInsetsController();
                if (insetsController != null) {
                    insetsController.hide(WindowInsets.Type.statusBars());
                    insetsController.hide(WindowInsets.Type.navigationBars());
                    insetsController.setSystemBarsBehavior(2);
                }
            } else {
                decorView.setSystemUiVisibility(5894);
            }
        } else {
            ((ActivityMainBinding) getBinding()).mainTabView.setVisibility(0);
            ((ActivityMainBinding) getBinding()).bottomSpace.setVisibility(0);
            if (Build.VERSION.SDK_INT >= 30) {
                window.setDecorFitsSystemWindows(false);
                window.setStatusBarColor(0);
                WindowInsetsController insetsController2 = window.getInsetsController();
                if (insetsController2 != null) {
                    insetsController2.show(WindowInsets.Type.statusBars());
                    insetsController2.show(WindowInsets.Type.navigationBars());
                }
            } else {
                decorView.setSystemUiVisibility(0);
                window.setStatusBarColor(0);
                View decorView2 = window.getDecorView();
                decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1280);
            }
        }
        if (ThemeManager.INSTANCE.isLight()) {
            StatusBarHelper.setStatusBarLightMode(this);
        } else {
            StatusBarHelper.setStatusBarDarkMode(this);
        }
    }

    public ActivityMainBinding getViewBinding() {
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ((ActivityMainBinding) getBinding()).mainTabView.setOnTabChange((Function1<? super Integer, Boolean>) null);
        UserInfoManager.Companion.setShareUserInfo((ShareUserInfo) null);
    }

    public void onBackPressed() {
        ActivityUtil.INSTANCE.toSystemHome(this);
    }

    private final boolean checkAndUpdateResourceIfNeeded() {
        CharSequence upgradeResourceZipFileInfo = MmkvManager.INSTANCE.getUpgradeResourceZipFileInfo();
        if (upgradeResourceZipFileInfo.length() == 0) {
            upgradeResourceZipFileInfo = null;
        }
        if (((String) upgradeResourceZipFileInfo) == null) {
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean(BaseWelcomeActivity.EXT_UPDATE_RESOURCE, true);
        Unit unit = Unit.INSTANCE;
        ActivityUtil.INSTANCE.toActivity((Context) this, bundle, (Class<?>) WelcomeActivity.class);
        finish();
        return true;
    }

    static /* synthetic */ void processIntent$default(MainActivity mainActivity, Intent intent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        mainActivity.processIntent(intent, z);
    }

    private final void processIntent(Intent intent, boolean z) {
        Object obj;
        String str = TAG;
        Intrinsics.checkNotNullExpressionValue(str, "TAG");
        LogUtil.Companion.d("processIntent intent=" + intent + " fromOnCreate=" + z, str);
        if (intent != null) {
            String stringExtra = intent.getStringExtra(AssistPushConsts.MSG_TYPE_PAYLOAD);
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            LogUtil.Companion.xLogI("processIntent payload=" + stringExtra, str);
            if (stringExtra != null) {
                CharSequence charSequence = stringExtra;
                Unit unit = null;
                if (charSequence.length() == 0) {
                    charSequence = null;
                }
                if (((String) charSequence) != null) {
                    intent.removeExtra(AssistPushConsts.MSG_TYPE_PAYLOAD);
                    try {
                        Result.Companion companion = Result.Companion;
                        JSONObject jSONObject = new JSONObject(stringExtra);
                        if (jSONObject.has(UserInfoManager.Companion.instance().userId())) {
                            CharSequence optString = jSONObject.optString(UserInfoManager.Companion.instance().userId());
                            if (optString.length() == 0) {
                                optString = null;
                            }
                            String str2 = (String) optString;
                            if (str2 != null) {
                                getHomeViewModel().switchUser(str2);
                                unit = Unit.INSTANCE;
                            }
                        } else {
                            LogUtil.Companion companion2 = LogUtil.Companion;
                            Intrinsics.checkNotNullExpressionValue(str, "TAG");
                            companion2.xLogE("intent数据未处理", str);
                            unit = Unit.INSTANCE;
                        }
                        obj = Result.m343constructorimpl(unit);
                    } catch (Throwable th) {
                        Result.Companion companion3 = Result.Companion;
                        obj = Result.m343constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable r7 = Result.m346exceptionOrNullimpl(obj);
                    if (r7 != null) {
                        String str3 = TAG;
                        Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                        LogUtil.Companion.xLogE("通知数据解析异常-" + ExceptionsKt.stackTraceToString(r7), str3);
                    }
                }
            }
        }
    }

    private final void initSmartRefreshLayoutHeaderTipText() {
        ClassicsHeader.REFRESH_HEADER_REFRESHING = getString(R.string.refresh_loadNew_loading);
        ClassicsHeader.REFRESH_HEADER_PULLING = getString(R.string.refresh_loadNew_enable);
        ClassicsHeader.REFRESH_HEADER_LOADING = getString(R.string.refresh_loadNew_loading);
        ClassicsHeader.REFRESH_HEADER_FAILED = getString(R.string.refresh_failed);
        ClassicsHeader.REFRESH_HEADER_FINISH = getString(R.string.refresh_complete);
        ClassicsHeader.REFRESH_HEADER_UPDATE = "'" + getString(R.string.refresh_latestTime) + "'MM/dd HH:mm";
        ClassicsHeader.REFRESH_HEADER_RELEASE = getString(R.string.refresh_loadNew_release);
    }
}
