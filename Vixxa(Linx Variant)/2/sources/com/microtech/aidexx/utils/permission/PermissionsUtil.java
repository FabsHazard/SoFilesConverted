package com.microtech.aidexx.utils.permission;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AlertDialog;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import com.tencent.bugly.BuglyStrategy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0002J3\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ3\u0010 \u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0010\b\u0002\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ;\u0010\"\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u00052\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020\t¢\u0006\u0002\u0010'J3\u0010(\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\u001fJ\u0010\u0010)\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\"\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X.¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/utils/permission/PermissionsUtil;", "", "()V", "callBackMap", "", "", "Lkotlin/Function0;", "", "goSystemSettingShowing", "", "getGoSystemSettingShowing", "()Z", "setGoSystemSettingShowing", "(Z)V", "mPermissionDialog", "Landroidx/appcompat/app/AlertDialog;", "getMPermissionDialog", "()Landroidx/appcompat/app/AlertDialog;", "setMPermissionDialog", "(Landroidx/appcompat/app/AlertDialog;)V", "mRequestCode", "Ljava/util/concurrent/atomic/AtomicInteger;", "permissions", "", "", "[Ljava/lang/String;", "cancelPermissionDialog", "checkAndRequestPermissions", "context", "Landroid/app/Activity;", "allow", "(Landroid/app/Activity;[Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "checkPermissions", "needRequest", "onRequestPermissionsResult", "requestCode", "grantResults", "", "showSystemSetting", "(Landroid/app/Activity;I[Ljava/lang/String;[IZ)V", "requestPermissions", "showSystemPermissionsSettingDialog", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PermissionUtil.kt */
public final class PermissionsUtil {
    public static final PermissionsUtil INSTANCE = new PermissionsUtil();
    private static final Map<Integer, Function0<Unit>> callBackMap = new LinkedHashMap();
    private static boolean goSystemSettingShowing;
    private static AlertDialog mPermissionDialog;
    private static AtomicInteger mRequestCode = new AtomicInteger(BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
    private static String[] permissions;

    private PermissionsUtil() {
    }

    public final AlertDialog getMPermissionDialog() {
        return mPermissionDialog;
    }

    public final void setMPermissionDialog(AlertDialog alertDialog) {
        mPermissionDialog = alertDialog;
    }

    public final boolean getGoSystemSettingShowing() {
        return goSystemSettingShowing;
    }

    public final void setGoSystemSettingShowing(boolean z) {
        goSystemSettingShowing = z;
    }

    public static /* synthetic */ void checkPermissions$default(PermissionsUtil permissionsUtil, Activity activity, String[] strArr, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        permissionsUtil.checkPermissions(activity, strArr, function0);
    }

    public final void checkPermissions(Activity activity, String[] strArr, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        List arrayList = new ArrayList();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (ContextCompat.checkSelfPermission(activity, strArr[i]) != 0) {
                arrayList.add(strArr[i]);
            }
        }
        if (arrayList.size() > 0 && function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void requestPermissions$default(PermissionsUtil permissionsUtil, Activity activity, String[] strArr, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        permissionsUtil.requestPermissions(activity, strArr, function0);
    }

    public final void requestPermissions(Activity activity, String[] strArr, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        int andIncrement = mRequestCode.getAndIncrement();
        callBackMap.put(Integer.valueOf(andIncrement), function0);
        ActivityCompat.requestPermissions(activity, strArr, andIncrement);
    }

    public static /* synthetic */ void checkAndRequestPermissions$default(PermissionsUtil permissionsUtil, Activity activity, String[] strArr, Function0 function0, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = null;
        }
        permissionsUtil.checkAndRequestPermissions(activity, strArr, function0);
    }

    public final void checkAndRequestPermissions(Activity activity, String[] strArr, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(activity, "context");
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        List arrayList = new ArrayList();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (ContextCompat.checkSelfPermission(activity, strArr[i]) != 0) {
                arrayList.add(strArr[i]);
            }
        }
        if (arrayList.size() > 0) {
            int andIncrement = mRequestCode.getAndIncrement();
            callBackMap.put(Integer.valueOf(andIncrement), function0);
            ActivityCompat.requestPermissions(activity, strArr, andIncrement);
        } else if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ void onRequestPermissionsResult$default(PermissionsUtil permissionsUtil, Activity activity, int i, String[] strArr, int[] iArr, boolean z, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            z = true;
        }
        permissionsUtil.onRequestPermissionsResult(activity, i, strArr, iArr, z);
    }

    public final void onRequestPermissionsResult(Activity activity, int i, String[] strArr, int[] iArr, boolean z) {
        Activity activity2 = activity;
        String[] strArr2 = strArr;
        int[] iArr2 = iArr;
        Intrinsics.checkNotNullParameter(activity2, "context");
        Intrinsics.checkNotNullParameter(strArr2, "permissions");
        Intrinsics.checkNotNullParameter(iArr2, "grantResults");
        permissions = strArr2;
        List arrayList = new ArrayList();
        if (callBackMap.containsKey(Integer.valueOf(i))) {
            int length = iArr2.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (iArr2[i2] == -1) {
                    arrayList.add(strArr2[i2]);
                }
            }
            if (!arrayList.isEmpty()) {
                Iterable<String> iterable = arrayList;
                if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
                    for (String shouldShowRequestPermissionRationale : iterable) {
                        if (!activity2.shouldShowRequestPermissionRationale(shouldShowRequestPermissionRationale)) {
                            LogUtil.Companion.d$default(LogUtil.Companion, "权限" + CollectionsKt.joinToString$default(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + "被拒绝并不再提示", (String) null, 2, (Object) null);
                            if (z) {
                                showSystemPermissionsSettingDialog(activity);
                                return;
                            }
                            return;
                        }
                    }
                }
                LogUtil.Companion.d$default(LogUtil.Companion, "权限" + CollectionsKt.joinToString$default(iterable, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + "被拒绝", (String) null, 2, (Object) null);
                return;
            }
            Function0 function0 = callBackMap.get(Integer.valueOf(i));
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    private final void showSystemPermissionsSettingDialog(Activity activity) {
        if (mPermissionDialog == null) {
            StandardDialog.Setter setter = new StandardDialog.Setter(activity);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = activity.getString(R.string.permission_abandon_tip);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            PermissionGroups permissionGroups = PermissionGroups.INSTANCE;
            String[] strArr = permissions;
            String[] strArr2 = null;
            if (strArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissions");
                strArr = null;
            }
            String funcToPermission = permissionGroups.getFuncToPermission(activity, strArr);
            PermissionGroups permissionGroups2 = PermissionGroups.INSTANCE;
            String[] strArr3 = permissions;
            if (strArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("permissions");
            } else {
                strArr2 = strArr3;
            }
            String format = String.format(string, Arrays.copyOf(new Object[]{funcToPermission, permissionGroups2.getFuncToPermission(activity, strArr2)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            mPermissionDialog = setter.content(format).setPositive(activity.getString(R.string.app_goSetting), new PermissionsUtil$$ExternalSyntheticLambda0(activity)).setCancel(activity.getString(R.string.com_action_cancel), new PermissionsUtil$$ExternalSyntheticLambda1()).create();
        }
        AlertDialog alertDialog = mPermissionDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
        goSystemSettingShowing = true;
    }

    /* access modifiers changed from: private */
    public static final void showSystemPermissionsSettingDialog$lambda$1(Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(activity, "$context");
        INSTANCE.cancelPermissionDialog();
        goSystemSettingShowing = false;
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.addFlags(BasicMeasure.EXACTLY);
        intent.addFlags(8388608);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: private */
    public static final void showSystemPermissionsSettingDialog$lambda$2(DialogInterface dialogInterface, int i) {
        INSTANCE.cancelPermissionDialog();
        goSystemSettingShowing = false;
    }

    private final void cancelPermissionDialog() {
        AlertDialog alertDialog = mPermissionDialog;
        if (alertDialog != null) {
            if (alertDialog != null) {
                alertDialog.cancel();
            }
            mPermissionDialog = null;
        }
    }
}
