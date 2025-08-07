package io.objectbox.sync.internal;

import io.objectbox.sync.ConnectivityMonitor;
import javax.annotation.Nullable;

public class Platform {
    @Nullable
    public ConnectivityMonitor getConnectivityMonitor() {
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static io.objectbox.sync.internal.Platform findPlatform() {
        /*
            java.lang.Object r0 = io.objectbox.BoxStore.getContext()
            if (r0 == 0) goto L_0x003c
            r1 = 0
            java.lang.String r2 = "android.content.Context"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            java.lang.String r3 = "io.objectbox.android.internal.AndroidPlatform"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            java.lang.String r4 = "create"
            r5 = 1
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            r6 = 0
            r5[r6] = r2     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            java.lang.reflect.Method r2 = r3.getMethod(r4, r5)     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            java.lang.Object[] r0 = new java.lang.Object[]{r0}     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            java.lang.Object r0 = r2.invoke(r1, r0)     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            io.objectbox.sync.internal.Platform r0 = (io.objectbox.sync.internal.Platform) r0     // Catch:{ NoSuchMethodException -> 0x002f, IllegalAccessException -> 0x002d, InvocationTargetException -> 0x002a, ClassNotFoundException -> 0x0031 }
            return r0
        L_0x002a:
            r0 = move-exception
        L_0x002b:
            r1 = r0
            goto L_0x0031
        L_0x002d:
            r0 = move-exception
            goto L_0x002b
        L_0x002f:
            r0 = move-exception
            goto L_0x002b
        L_0x0031:
            if (r1 != 0) goto L_0x0034
            goto L_0x003c
        L_0x0034:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r2 = "AndroidPlatform could not be created."
            r0.<init>(r2, r1)
            throw r0
        L_0x003c:
            io.objectbox.sync.internal.Platform r0 = new io.objectbox.sync.internal.Platform
            r0.<init>()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.sync.internal.Platform.findPlatform():io.objectbox.sync.internal.Platform");
    }
}
