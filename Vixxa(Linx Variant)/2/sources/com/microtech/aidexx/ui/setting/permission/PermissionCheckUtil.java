package com.microtech.aidexx.ui.setting.permission;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.BleUtil;
import com.microtech.aidexx.utils.LocationUtils;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001e\u0010\t\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ&\u0010\n\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bJ\u001e\u0010\r\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\b0\u000f2\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0011\u001a\u00020\bH\u0002J\u001e\u0010\u0012\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\u0013\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\u0014\u001a\u00020\u00042\u000e\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bJB\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00102\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cJD\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0001\u0010\u001e\u001a\u00020\u001f2\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0002¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/ui/setting/permission/PermissionCheckUtil;", "", "()V", "checkAutoStart", "", "context", "Lcom/microtech/aidexx/base/BaseActivity;", "itemView", "Lcom/microtech/aidexx/views/SettingItemWidget;", "checkBattery", "checkBluetooth", "bluetoothItem", "locationItem", "checkCamera", "checkLocation", "Lkotlin/Pair;", "", "checkItemView", "checkNetWork", "checkNotification", "checkStorage", "genCheckItem", "Landroid/content/Context;", "title", "", "value", "noDivider", "onClick", "Lkotlin/Function1;", "updateCheckItem", "rightIcon", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionCheckUtil.kt */
public final class PermissionCheckUtil {
    public static final PermissionCheckUtil INSTANCE = new PermissionCheckUtil();

    private PermissionCheckUtil() {
    }

    public final void checkBluetooth(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget, SettingItemWidget settingItemWidget2) {
        PermissionCheckUtil$checkBluetooth$onClick$1 permissionCheckUtil$checkBluetooth$onClick$1;
        String str;
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "bluetoothItem");
        Intrinsics.checkNotNullParameter(settingItemWidget2, "locationItem");
        Ref.IntRef intRef = new Ref.IntRef();
        if (checkLocation(baseActivity, settingItemWidget2).getFirst().booleanValue()) {
            if (Build.VERSION.SDK_INT >= 31) {
                PermissionsUtil.INSTANCE.checkPermissions(baseActivity, PermissionGroups.INSTANCE.getBluetooth(), new PermissionCheckUtil$checkBluetooth$1(intRef));
            }
            if (intRef.element == 0 && !BleUtil.isBleEnable(baseActivity)) {
                intRef.element = 3;
            }
        } else {
            intRef.element = 1;
        }
        if (intRef.element == 0) {
            permissionCheckUtil$checkBluetooth$onClick$1 = null;
        } else {
            permissionCheckUtil$checkBluetooth$onClick$1 = new PermissionCheckUtil$checkBluetooth$onClick$1(intRef, baseActivity);
        }
        int i = R.drawable.ic_access;
        if (intRef.element != 0) {
            str = baseActivity.getString(intRef.element == 1 ? R.string.permission_info_notEnable : R.string.permission_info_manualSetting);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
            i = R.drawable.ic_warnning;
        } else {
            str = "";
        }
        updateCheckItem(baseActivity, settingItemWidget, str, i, permissionCheckUtil$checkBluetooth$onClick$1);
    }

    private final Pair<Boolean, SettingItemWidget> checkLocation(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        String str;
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 31) {
            return TuplesKt.to(true, settingItemWidget);
        }
        Ref.IntRef intRef = new Ref.IntRef();
        PermissionsUtil.INSTANCE.checkPermissions(baseActivity, PermissionGroups.INSTANCE.getLocation(), new PermissionCheckUtil$checkLocation$1(intRef));
        if (intRef.element != 0 && !LocationUtils.INSTANCE.isLocationServiceEnable(baseActivity)) {
            intRef.element = 2;
        }
        int i = R.drawable.ic_access;
        if (intRef.element != 0) {
            i = R.drawable.ic_warnning;
            str = baseActivity.getString(R.string.permission_info_manualSetting);
            Intrinsics.checkNotNullExpressionValue(str, "getString(...)");
        } else {
            str = "";
        }
        updateCheckItem(baseActivity, settingItemWidget, str, i, intRef.element != 0 ? new PermissionCheckUtil$checkLocation$onClick$1(intRef, baseActivity) : null);
        if (intRef.element != 0) {
            z = false;
        }
        return TuplesKt.to(Boolean.valueOf(z), settingItemWidget);
    }

    public final void checkNotification(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        PermissionCheckUtil$checkNotification$onClick$1 permissionCheckUtil$checkNotification$onClick$1;
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "itemView");
        Context context = baseActivity;
        boolean areNotificationsEnabled = NotificationManagerCompat.from(context).areNotificationsEnabled();
        if (areNotificationsEnabled) {
            permissionCheckUtil$checkNotification$onClick$1 = null;
        } else {
            permissionCheckUtil$checkNotification$onClick$1 = new PermissionCheckUtil$checkNotification$onClick$1(baseActivity);
        }
        updateCheckItem(context, settingItemWidget, "", areNotificationsEnabled ? R.drawable.ic_access : R.drawable.ic_warnning, permissionCheckUtil$checkNotification$onClick$1);
    }

    public final void checkBattery(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        PermissionCheckUtil$checkBattery$onClick$1 permissionCheckUtil$checkBattery$onClick$1;
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "itemView");
        Object systemService = baseActivity.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        boolean isIgnoringBatteryOptimizations = ((PowerManager) systemService).isIgnoringBatteryOptimizations(baseActivity.getPackageName());
        if (isIgnoringBatteryOptimizations) {
            permissionCheckUtil$checkBattery$onClick$1 = null;
        } else {
            permissionCheckUtil$checkBattery$onClick$1 = new PermissionCheckUtil$checkBattery$onClick$1(baseActivity);
        }
        updateCheckItem(baseActivity, settingItemWidget, "", isIgnoringBatteryOptimizations ? R.drawable.ic_access : R.drawable.ic_warnning, permissionCheckUtil$checkBattery$onClick$1);
    }

    public final void checkStorage(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        PermissionCheckUtil$checkStorage$onClick$1 permissionCheckUtil$checkStorage$onClick$1;
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "itemView");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        PermissionsUtil.INSTANCE.checkPermissions(baseActivity, PermissionGroups.INSTANCE.getStorage(), new PermissionCheckUtil$checkStorage$1(booleanRef));
        if (booleanRef.element) {
            permissionCheckUtil$checkStorage$onClick$1 = null;
        } else {
            permissionCheckUtil$checkStorage$onClick$1 = new PermissionCheckUtil$checkStorage$onClick$1(baseActivity);
        }
        updateCheckItem(baseActivity, settingItemWidget, "", booleanRef.element ? R.drawable.ic_access : R.drawable.ic_warnning, permissionCheckUtil$checkStorage$onClick$1);
    }

    public final void checkCamera(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        PermissionCheckUtil$checkCamera$onClick$1 permissionCheckUtil$checkCamera$onClick$1;
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "itemView");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        PermissionsUtil.INSTANCE.checkPermissions(baseActivity, PermissionGroups.INSTANCE.getCamera(), new PermissionCheckUtil$checkCamera$1(booleanRef));
        if (booleanRef.element) {
            permissionCheckUtil$checkCamera$onClick$1 = null;
        } else {
            permissionCheckUtil$checkCamera$onClick$1 = new PermissionCheckUtil$checkCamera$onClick$1(baseActivity);
        }
        updateCheckItem(baseActivity, settingItemWidget, "", booleanRef.element ? R.drawable.ic_access : R.drawable.ic_warnning, permissionCheckUtil$checkCamera$onClick$1);
    }

    public final void checkNetWork(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        PermissionCheckUtil$checkNetWork$onClick$1 permissionCheckUtil$checkNetWork$onClick$1;
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "itemView");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        PermissionsUtil.INSTANCE.checkPermissions(baseActivity, new String[]{"android.permission.INTERNET"}, new PermissionCheckUtil$checkNetWork$1(booleanRef));
        if (booleanRef.element) {
            permissionCheckUtil$checkNetWork$onClick$1 = null;
        } else {
            permissionCheckUtil$checkNetWork$onClick$1 = new PermissionCheckUtil$checkNetWork$onClick$1(baseActivity);
        }
        updateCheckItem(baseActivity, settingItemWidget, "", booleanRef.element ? R.drawable.ic_access : R.drawable.ic_warnning, permissionCheckUtil$checkNetWork$onClick$1);
    }

    public final void checkAutoStart(BaseActivity<?, ?> baseActivity, SettingItemWidget settingItemWidget) {
        Intrinsics.checkNotNullParameter(baseActivity, "context");
        Intrinsics.checkNotNullParameter(settingItemWidget, "itemView");
        PermissionCheckUtil$checkAutoStart$onClick$1 permissionCheckUtil$checkAutoStart$onClick$1 = new PermissionCheckUtil$checkAutoStart$onClick$1(baseActivity);
        int i = R.drawable.ic_warnning;
        String string = baseActivity.getString(R.string.permission_autoStart_tip);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        updateCheckItem(baseActivity, settingItemWidget, string, i, permissionCheckUtil$checkAutoStart$onClick$1);
    }

    public static /* synthetic */ SettingItemWidget genCheckItem$default(PermissionCheckUtil permissionCheckUtil, Context context, String str, String str2, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "";
        }
        String str3 = str2;
        if ((i & 8) != 0) {
            z = false;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            function1 = null;
        }
        return permissionCheckUtil.genCheckItem(context, str, str3, z2, function1);
    }

    public final SettingItemWidget genCheckItem(Context context, String str, String str2, boolean z, Function1<? super SettingItemWidget, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "value");
        SettingItemWidget settingItemWidget = new SettingItemWidget(context);
        settingItemWidget.setValue(str2);
        settingItemWidget.setTitle(str);
        settingItemWidget.getLeftImage().setVisibility(8);
        settingItemWidget.getSwitch().setVisibility(8);
        settingItemWidget.getRightImage().setVisibility(0);
        settingItemWidget.getRightImage().setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_scanning));
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        rotateAnimation.setDuration(1000);
        settingItemWidget.getRightImage().startAnimation(rotateAnimation);
        settingItemWidget.setDividerState(!z);
        ExtendsKt.setDebounceClickListener$default(settingItemWidget, 0, new PermissionCheckUtil$$ExternalSyntheticLambda0(function1, settingItemWidget), 1, (Object) null);
        return settingItemWidget;
    }

    /* access modifiers changed from: private */
    public static final void genCheckItem$lambda$0(Function1 function1, SettingItemWidget settingItemWidget, View view) {
        Intrinsics.checkNotNullParameter(settingItemWidget, "$itemView");
        if (function1 != null) {
            function1.invoke(settingItemWidget);
        }
    }

    static /* synthetic */ void updateCheckItem$default(PermissionCheckUtil permissionCheckUtil, Context context, SettingItemWidget settingItemWidget, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i2 & 16) != 0) {
            function1 = null;
        }
        permissionCheckUtil.updateCheckItem(context, settingItemWidget, str2, i, function1);
    }

    private final void updateCheckItem(Context context, SettingItemWidget settingItemWidget, String str, int i, Function1<? super SettingItemWidget, Unit> function1) {
        settingItemWidget.setValue(str);
        settingItemWidget.getRightImage().getAnimation().cancel();
        settingItemWidget.getRightImage().setImageDrawable(ContextCompat.getDrawable(context, i));
        ExtendsKt.setDebounceClickListener$default(settingItemWidget, 0, new PermissionCheckUtil$$ExternalSyntheticLambda1(function1, settingItemWidget), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void updateCheckItem$lambda$1(Function1 function1, SettingItemWidget settingItemWidget, View view) {
        Intrinsics.checkNotNullParameter(settingItemWidget, "$itemView");
        if (function1 != null) {
            function1.invoke(settingItemWidget);
        }
    }
}
