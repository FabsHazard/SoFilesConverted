package com.microtech.aidexx;

import android.bluetooth.BluetoothAdapter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClientReleaseTool {
    /* JADX WARNING: Can't wrap try/catch for region: R(3:13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r0 = getDeclaredMethod(r2, "stopScan", java.lang.Integer.TYPE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r5 = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0061 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean releaseAllScanClient() {
        /*
            java.lang.String r0 = "stopScan"
            r1 = 0
            android.bluetooth.BluetoothAdapter r2 = android.bluetooth.BluetoothAdapter.getDefaultAdapter()     // Catch:{ Exception -> 0x0076 }
            java.lang.Object r2 = getIBluetoothManager(r2)     // Catch:{ Exception -> 0x0076 }
            if (r2 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r2 = getIBluetoothGatt(r2)     // Catch:{ Exception -> 0x0076 }
            if (r2 != 0) goto L_0x0015
            return r1
        L_0x0015:
            java.lang.String r3 = "unregisterClient"
            r4 = 1
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0076 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0076 }
            r5[r1] = r6     // Catch:{ Exception -> 0x0076 }
            java.lang.reflect.Method r3 = getDeclaredMethod(r2, r3, r5)     // Catch:{ Exception -> 0x0076 }
            r5 = 2
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0033 }
            r5[r1] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.Class r6 = java.lang.Boolean.TYPE     // Catch:{ Exception -> 0x0033 }
            r5[r4] = r6     // Catch:{ Exception -> 0x0033 }
            java.lang.reflect.Method r0 = getDeclaredMethod(r2, r0, r5)     // Catch:{ Exception -> 0x0033 }
            r5 = r1
            goto L_0x003e
        L_0x0033:
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0076 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0076 }
            r5[r1] = r6     // Catch:{ Exception -> 0x0076 }
            java.lang.reflect.Method r0 = getDeclaredMethod(r2, r0, r5)     // Catch:{ Exception -> 0x0076 }
            r5 = r4
        L_0x003e:
            r6 = r1
        L_0x003f:
            r7 = 40
            if (r6 > r7) goto L_0x006f
            if (r5 != 0) goto L_0x0054
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0054 }
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r1)     // Catch:{ Exception -> 0x0054 }
            java.lang.Object[] r7 = new java.lang.Object[]{r7, r8}     // Catch:{ Exception -> 0x0054 }
            r0.invoke(r2, r7)     // Catch:{ Exception -> 0x0054 }
        L_0x0054:
            if (r5 != r4) goto L_0x0061
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0061 }
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ Exception -> 0x0061 }
            r0.invoke(r2, r7)     // Catch:{ Exception -> 0x0061 }
        L_0x0061:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x006c }
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ Exception -> 0x006c }
            r3.invoke(r2, r7)     // Catch:{ Exception -> 0x006c }
        L_0x006c:
            int r6 = r6 + 1
            goto L_0x003f
        L_0x006f:
            r0.setAccessible(r1)     // Catch:{ Exception -> 0x0076 }
            r3.setAccessible(r1)     // Catch:{ Exception -> 0x0076 }
            return r4
        L_0x0076:
            r0 = move-exception
            r0.printStackTrace()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ClientReleaseTool.releaseAllScanClient():boolean");
    }

    public static Method getDeclaredMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    public static Object getIBluetoothManager(BluetoothAdapter bluetoothAdapter) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        return getDeclaredMethod(BluetoothAdapter.class, "getBluetoothManager", new Class[0]).invoke(bluetoothAdapter, new Object[0]);
    }

    public static Object getIBluetoothGatt(Object obj) throws NoSuchMethodException, IllegalAccessException {
        Method declaredMethod = getDeclaredMethod(obj, "getBluetoothGatt", new Class[0]);
        Object obj2 = new Object();
        try {
            return declaredMethod.invoke(obj, new Object[0]);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            return obj2;
        }
    }
}
