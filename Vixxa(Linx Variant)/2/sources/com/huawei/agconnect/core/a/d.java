package com.huawei.agconnect.core.a;

import android.content.Context;
import android.util.Log;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.core.Service;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Class<?>, Service> a = new HashMap();
    private static Map<Class<?>, Object> b = new HashMap();
    private Map<Class<?>, Service> c = new HashMap();
    private Map<Class<?>, Object> d = new HashMap();

    d(List<Service> list, Context context) {
        a(list, context);
    }

    private Object a(AGConnectInstance aGConnectInstance, Service service) {
        StringBuilder sb;
        String str;
        if (service.getInstance() != null) {
            return service.getInstance();
        }
        Class<?> type = service.getType();
        if (type == null) {
            return null;
        }
        try {
            Constructor a2 = a((Class) type, Context.class, AGConnectInstance.class);
            if (a2 != null) {
                return a2.newInstance(new Object[]{aGConnectInstance.getContext(), aGConnectInstance});
            }
            Constructor a3 = a((Class) type, Context.class);
            return a3 != null ? a3.newInstance(new Object[]{aGConnectInstance.getContext()}) : type.newInstance();
        } catch (InstantiationException e) {
            sb = new StringBuilder("Instantiate service exception ");
            str = e.getLocalizedMessage();
            Log.e("ServiceRepository", sb.append(str).toString());
            return null;
        } catch (InvocationTargetException e2) {
            sb = new StringBuilder("Instantiate service exception ");
            str = e2.getLocalizedMessage();
            Log.e("ServiceRepository", sb.append(str).toString());
            return null;
        } catch (IllegalAccessException e3) {
            sb = new StringBuilder("Instantiate service exception ");
            str = e3.getLocalizedMessage();
            Log.e("ServiceRepository", sb.append(str).toString());
            return null;
        }
    }

    private static Constructor a(Class cls, Class... clsArr) {
        boolean z = false;
        for (Constructor constructor : cls.getDeclaredConstructors()) {
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == clsArr.length) {
                for (int i = 0; i < clsArr.length; i++) {
                    z = parameterTypes[i] == clsArr[i];
                }
                if (z) {
                    return constructor;
                }
            }
        }
        return null;
    }

    private void a(String str, Exception exc) {
        Log.e("ServiceRepository", "Instantiate shared service " + str + exc.getLocalizedMessage());
        Log.e("ServiceRepository", "cause message:" + (exc.getCause() != null ? exc.getCause().getMessage() : ""));
    }

    public <T> T a(AGConnectInstance aGConnectInstance, Class<?> cls) {
        T t;
        Service service = this.c.get(cls);
        if (service == null && (service = a.get(cls)) != null) {
            return b.get(cls);
        }
        if (service == null) {
            return null;
        }
        if (service.isSingleton() && (t = this.d.get(cls)) != null) {
            return t;
        }
        T a2 = a(aGConnectInstance, service);
        if (a2 != null && service.isSingleton()) {
            this.d.put(cls, a2);
        }
        return a2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005b A[Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0064 A[Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.util.List<com.huawei.agconnect.core.Service> r6, android.content.Context r7) {
        /*
            r5 = this;
            if (r6 != 0) goto L_0x0003
            return
        L_0x0003:
            java.util.Iterator r6 = r6.iterator()
        L_0x0007:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0085
            java.lang.Object r0 = r6.next()
            com.huawei.agconnect.core.Service r0 = (com.huawei.agconnect.core.Service) r0
            boolean r1 = r0.isSharedInstance()
            if (r1 == 0) goto L_0x0028
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = a
            java.lang.Class r2 = r0.getInterface()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0031
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = a
            goto L_0x002a
        L_0x0028:
            java.util.Map<java.lang.Class<?>, com.huawei.agconnect.core.Service> r1 = r5.c
        L_0x002a:
            java.lang.Class r2 = r0.getInterface()
            r1.put(r2, r0)
        L_0x0031:
            boolean r1 = r0.isAutoCreated()
            if (r1 == 0) goto L_0x0007
            java.lang.Class r1 = r0.getType()
            if (r1 == 0) goto L_0x0007
            java.util.Map<java.lang.Class<?>, java.lang.Object> r1 = b
            java.lang.Class r2 = r0.getInterface()
            boolean r1 = r1.containsKey(r2)
            if (r1 != 0) goto L_0x0007
            java.lang.Class r1 = r0.getType()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            r2 = 1
            java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r4 = 0
            r2[r4] = r3     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.reflect.Constructor r1 = a((java.lang.Class) r1, (java.lang.Class[]) r2)     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            if (r1 == 0) goto L_0x0064
            java.lang.Object[] r2 = new java.lang.Object[]{r7}     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Object r1 = r1.newInstance(r2)     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            goto L_0x006c
        L_0x0064:
            java.lang.Class r1 = r0.getType()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
        L_0x006c:
            java.util.Map<java.lang.Class<?>, java.lang.Object> r2 = b     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            java.lang.Class r0 = r0.getInterface()     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            r2.put(r0, r1)     // Catch:{ IllegalAccessException -> 0x007e, InstantiationException -> 0x007a, InvocationTargetException -> 0x0076 }
            goto L_0x0007
        L_0x0076:
            r0 = move-exception
            java.lang.String r1 = "TargetException"
            goto L_0x0081
        L_0x007a:
            r0 = move-exception
            java.lang.String r1 = "InstantiationException"
            goto L_0x0081
        L_0x007e:
            r0 = move-exception
            java.lang.String r1 = "AccessException"
        L_0x0081:
            r5.a((java.lang.String) r1, (java.lang.Exception) r0)
            goto L_0x0007
        L_0x0085:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.agconnect.core.a.d.a(java.util.List, android.content.Context):void");
    }
}
