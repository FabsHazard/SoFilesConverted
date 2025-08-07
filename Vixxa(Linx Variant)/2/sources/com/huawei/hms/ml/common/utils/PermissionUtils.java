package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermissionUtils {
    public static List<Boolean> checkPermissions(Context context, List<String> list) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        ArrayList arrayList = new ArrayList();
        for (String checkPermission : list) {
            arrayList.add(Boolean.valueOf(packageManager.checkPermission(checkPermission, packageName) != -1));
        }
        return arrayList;
    }

    public static boolean checkPermission(Context context, String str) {
        return checkPermissions(context, Arrays.asList(new String[]{str})).get(0).booleanValue();
    }
}
