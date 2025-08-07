package com.microtech.aidexx.base;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.ui.setting.alert.AlertUtil;
import com.microtech.aidexx.ui.web.WebActivity;
import com.microtech.aidexx.ui.welcome.WelcomeActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.utils.BleUtil;
import com.microtech.aidexx.utils.LocationUtils;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.NetUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import com.microtech.aidexx.utils.statusbar.StatusBarHelper;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001cH\u0004J)\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e¢\u0006\u0002\u0010#J\"\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001f2\b\b\u0002\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020\u001aJ\u0006\u0010+\u001a\u00020\u001aJ\b\u0010,\u001a\u00020-H\u0016J\r\u0010.\u001a\u00028\u0001H&¢\u0006\u0002\u0010\tJ\u0010\u0010/\u001a\u00020\u001a2\u0006\u00100\u001a\u000201H\u0007J\b\u00102\u001a\u00020\u001aH\u0016J\b\u00103\u001a\u00020\u001aH\u0002J\b\u00104\u001a\u00020\u001aH\u0002J\u0010\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u000207H\u0016J\u0012\u00108\u001a\u00020\u001a2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\b\u0010;\u001a\u00020\u001aH\u0014J\b\u0010<\u001a\u00020\u001aH\u0014J+\u0010=\u001a\u00020\u001a2\u0006\u0010>\u001a\u00020&2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\u0006\u0010?\u001a\u00020@H\u0016¢\u0006\u0002\u0010AJ\b\u0010B\u001a\u00020\u001aH\u0014J\u0010\u0010C\u001a\u00020\u001a2\u0006\u0010D\u001a\u00020)H\u0016J\u0018\u0010E\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020&2\u0006\u0010F\u001a\u00020)H\u0002J\u001c\u0010G\u001a\u00020\u001a2\b\u0010H\u001a\u0004\u0018\u00010:2\n\u0010I\u001a\u0006\u0012\u0002\b\u00030JR\u001c\u0010\u0007\u001a\u00028\u0001X.¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\u000eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006K"}, d2 = {"Lcom/microtech/aidexx/base/BaseActivity;", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "setMainScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "viewModel", "getViewModel", "()Lcom/microtech/aidexx/base/BaseViewModel;", "setViewModel", "(Lcom/microtech/aidexx/base/BaseViewModel;)V", "Lcom/microtech/aidexx/base/BaseViewModel;", "checkEnvironment", "", "onSuccess", "Lkotlin/Function0;", "checkSelfPermission", "", "", "context", "Landroid/content/Context;", "permissions", "(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;", "dialogAlert", "type", "", "content", "showCustomerService", "", "enableBluetooth", "enableLocation", "getResources", "Landroid/content/res/Resources;", "getViewBinding", "ignoreBatteryOptimization", "activity", "Landroid/app/Activity;", "initViewModel", "initWindow", "observe", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onRequestPermissionsResult", "requestCode", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onWindowFocusChanged", "hasFocus", "process", "isUrgent", "startActivity", "bundle", "cls", "Ljava/lang/Class;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseActivity.kt */
public abstract class BaseActivity<VM extends BaseViewModel, VB extends ViewBinding> extends AppCompatActivity {
    public VB binding;
    public CoroutineScope mainScope;
    public VM viewModel;

    public abstract VB getViewBinding();

    public final VM getViewModel() {
        VM vm = this.viewModel;
        if (vm != null) {
            return vm;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.viewModel = vm;
    }

    public final VB getBinding() {
        VB vb = this.binding;
        if (vb != null) {
            return vb;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(VB vb) {
        Intrinsics.checkNotNullParameter(vb, "<set-?>");
        this.binding = vb;
    }

    public final CoroutineScope getMainScope() {
        CoroutineScope coroutineScope = this.mainScope;
        if (coroutineScope != null) {
            return coroutineScope;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mainScope");
        return null;
    }

    public final void setMainScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<set-?>");
        this.mainScope = coroutineScope;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        LanguageResourceManager languageResourceManager = LanguageResourceManager.INSTANCE;
        LayoutInflater layoutInflater = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(layoutInflater, "getLayoutInflater(...)");
        languageResourceManager.injectFactory2(layoutInflater);
        super.onCreate(bundle);
        setTheme(ThemeManager.INSTANCE.getTheme().getId());
        setBinding(getViewBinding());
        initWindow();
        setMainScope(CoroutineScopeKt.MainScope());
        initViewModel();
        observe();
    }

    private final void initWindow() {
        Window window = getWindow();
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        getBinding().getRoot().setOnApplyWindowInsetsListener(new BaseActivity$$ExternalSyntheticLambda0(this));
        if (Build.VERSION.SDK_INT >= 30) {
            window.setDecorFitsSystemWindows(false);
            window.setStatusBarColor(0);
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController != null) {
                insetsController.show(WindowInsets.Type.statusBars());
                insetsController.show(WindowInsets.Type.navigationBars());
                return;
            }
            return;
        }
        decorView.setSystemUiVisibility(0);
        window.setStatusBarColor(0);
        View decorView2 = window.getDecorView();
        decorView2.setSystemUiVisibility(decorView2.getSystemUiVisibility() | 1280);
    }

    /* access modifiers changed from: private */
    public static final WindowInsets initWindow$lambda$0(BaseActivity baseActivity, View view, WindowInsets windowInsets) {
        int i;
        Intrinsics.checkNotNullParameter(baseActivity, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        if (Build.VERSION.SDK_INT >= 30) {
            i = windowInsets.getInsets(WindowInsets.Type.navigationBars()).bottom;
        } else {
            i = windowInsets.getSystemWindowInsetBottom();
        }
        baseActivity.getBinding().getRoot().setPadding(0, 0, 0, i);
        return windowInsets;
    }

    static /* synthetic */ void dialogAlert$default(BaseActivity baseActivity, int i, String str, boolean z, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 4) != 0) {
                z = false;
            }
            baseActivity.dialogAlert(i, str, z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dialogAlert");
    }

    /* access modifiers changed from: private */
    public final void dialogAlert(int i, String str, boolean z) {
        Dialogs.INSTANCE.showAlert(this, i, (String) null, str, new BaseActivity$dialogAlert$1(this, z));
    }

    private final void observe() {
        LifecycleOwner lifecycleOwner = this;
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_SHOW_ALERT, lifecycleOwner, new BaseActivity$observe$1(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_SIGNAL_LOST_CHECK, lifecycleOwner, new BaseActivity$observe$2(this));
        EventBusManager.INSTANCE.onReceive(EventBusKey.EVENT_RESTART_BLUETOOTH, lifecycleOwner, BaseActivity$observe$3.INSTANCE);
        EventBusManager.INSTANCE.onReceive(EventBusKey.TOKEN_EXPIRED, lifecycleOwner, new BaseActivity$observe$4(this));
    }

    private final void process(int i, boolean z) {
        if (i == 6) {
            SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(settingEntity);
            AlertUtil.INSTANCE.alert(this, settingEntity.getSignalMissingAlertType() - 1, z);
        } else if (i != 7 && i != 8) {
            if (z) {
                SettingsEntity settingEntity2 = SettingsManager.INSTANCE.getSettingEntity();
                Intrinsics.checkNotNull(settingEntity2);
                AlertUtil.INSTANCE.alert(this, settingEntity2.getUrgentAlertType() - 1, true);
                return;
            }
            SettingsEntity settingEntity3 = SettingsManager.INSTANCE.getSettingEntity();
            Intrinsics.checkNotNull(settingEntity3);
            AlertUtil.INSTANCE.alert(this, settingEntity3.getAlertType() - 1, false);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        LogUtil.Companion.eAiDEX("onResume --> " + getClass().getName() + "  needLoadLanguageRes --> " + LanguageResourceManager.INSTANCE.needLoad());
        if (LanguageResourceManager.INSTANCE.needLoad() && !(this instanceof WelcomeActivity)) {
            ActivityUtil.INSTANCE.finishAll();
            Bundle bundle = new Bundle();
            bundle.putBoolean(BaseWelcomeActivity.EXT_UPDATE_RESOURCE, true);
            Unit unit = Unit.INSTANCE;
            ActivityUtil.INSTANCE.toActivity((Context) this, bundle, (Class<?>) WelcomeActivity.class);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        LogUtil.Companion.eAiDEX("onPause --> " + getClass().getName());
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (ThemeManager.INSTANCE.isLight()) {
            StatusBarHelper.setStatusBarLightMode(this);
        } else {
            StatusBarHelper.setStatusBarDarkMode(this);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        PermissionsUtil.onRequestPermissionsResult$default(PermissionsUtil.INSTANCE, this, i, strArr, iArr, false, 16, (Object) null);
    }

    public Resources getResources() {
        if (this instanceof WebActivity) {
            Resources resources = super.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
            return resources;
        }
        Resources resources2 = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        return LanguageResourceManager.INSTANCE.getAidexResourceInspector(this, resources2);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        LogUtil.Companion.eAiDEX("onDestroy --> " + getClass().getName());
        CoroutineScopeKt.cancel$default(getMainScope(), (CancellationException) null, 1, (Object) null);
    }

    public void initViewModel() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.microtech.aidexx.base.BaseActivity>");
        setViewModel((BaseViewModel) new ViewModelProvider(this).get((Class) type));
    }

    /* access modifiers changed from: protected */
    public final void checkEnvironment(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        if (Build.VERSION.SDK_INT >= 31) {
            PermissionsUtil.INSTANCE.checkPermissions(this, PermissionGroups.INSTANCE.getBluetooth(), new BaseActivity$checkEnvironment$1(booleanRef, this));
        } else {
            PermissionsUtil.INSTANCE.checkPermissions(this, PermissionGroups.INSTANCE.getLocation(), new BaseActivity$checkEnvironment$2(booleanRef, this));
        }
        if (!booleanRef.element) {
            Context context = this;
            if (!BleUtil.isBleEnable(context)) {
                enableBluetooth();
            } else if (!LocationUtils.INSTANCE.isLocationServiceEnable(context) && Build.VERSION.SDK_INT < 31) {
                enableLocation();
            } else if (!NetUtil.isNetAvailable(context)) {
                Dialogs.showError$default(Dialogs.INSTANCE, getString(R.string.com_network_unused), 0, 2, (Object) null);
            } else {
                function0.invoke();
            }
        }
    }

    public final void enableBluetooth() {
        Dialogs.showWhether$default(Dialogs.INSTANCE, this, getResources().getString(R.string.permission_item_ble), getResources().getString(R.string.permission_ble_desc), new BaseActivity$enableBluetooth$1(this), (Function0) null, "enableBluetooth", (String) null, (String) null, 0, 464, (Object) null);
    }

    public final void enableLocation() {
        Dialogs.showWhether$default(Dialogs.INSTANCE, this, (String) null, getResources().getString(R.string.permission_location_desc), new BaseActivity$enableLocation$1(this), (Function0) null, "location_service", (String) null, (String) null, 0, 466, (Object) null);
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(getResources().getConfiguration());
    }

    public final String[] checkSelfPermission(Context context, String[] strArr) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (ContextCompat.checkSelfPermission(context, str) == -1) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    public final void startActivity(Bundle bundle, Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        Intent intent = new Intent(this, cls);
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        intent.putExtras(bundle2);
        startActivity(intent);
    }

    public final void ignoreBatteryOptimization(Activity activity) {
        Intent intent;
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            if (ActivityUtil.INSTANCE.isHarmonyOS()) {
                intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$HighPowerApplicationsActivity"));
            } else {
                Intent intent2 = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                intent2.setData(Uri.parse("package:" + activity.getPackageName()));
                intent = intent2;
            }
            activity.startActivity(intent);
        } catch (Exception e) {
            LogUtil.Companion.eAiDEX("Set ignore battery optimizations failed:" + e.getMessage());
        }
    }
}
