package com.huawei.hms.feature.dynamic.e;

import android.util.Log;
import dalvik.system.DexClassLoader;

public final class b extends DexClassLoader {
    public static final String a = "b";

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
        if (!str.startsWith("java.") && !str.startsWith("android.")) {
            try {
                return findClass(str);
            } catch (ClassNotFoundException unused) {
                Log.w(a, "Cannot find The class:" + str);
            }
        }
        return super.loadClass(str, z);
    }
}
