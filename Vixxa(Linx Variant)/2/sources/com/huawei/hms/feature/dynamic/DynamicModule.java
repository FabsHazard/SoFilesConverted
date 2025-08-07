package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NEED_UPDATE = 2;
    public static final int MODULE_NORMAL = 0;
    public static final int MODULE_NOT_EXIST = 1;
    public static final int MODULE_NOT_PRESET_HSF = 5;
    public static final int MODULE_NOT_READY = 4;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.huawei.hms.feature.dynamic.e.c();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.huawei.hms.feature.dynamic.e.e();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new com.huawei.hms.feature.dynamic.e.d();
    public static final VersionPolicy PREFER_REMOTE = new com.huawei.hms.feature.dynamic.e.e();
    public static final String b = "DynamicModule";
    public static final int c = 256;
    public static final int d = -100;
    public static final ThreadLocal<HashMap<String, Boolean>> e = new ThreadLocal<>();
    public static final ThreadLocal<HashMap<String, String>> f = new ThreadLocal<>();
    public static final ThreadLocal<HashMap<String, IDynamicLoader>> g = new ThreadLocal<>();
    public static final ThreadLocal<HashMap<String, ClassLoader>> h = new ThreadLocal<>();
    public static int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static int l;
    public static HashMap<String, Boolean> m = new HashMap<>();
    public static HashMap<String, Boolean> n = new HashMap<>();
    public Context a;

    public static class DynamicLoaderClassLoader {
        public static HashMap<String, ClassLoader> a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            a.put(str, classLoader);
        }
    }

    public static class LoadingException extends Exception {
        public Bundle a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.a = bundle;
        }

        public Bundle getBundle() {
            return this.a;
        }
    }

    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    public static class a extends HashMap<String, ClassLoader> {
        public final /* synthetic */ String a;
        public final /* synthetic */ ClassLoader b;

        public a(String str, ClassLoader classLoader) {
            this.a = str;
            this.b = classLoader;
            put(str, classLoader);
        }
    }

    public static class b extends HashMap<String, ClassLoader> {
        public final /* synthetic */ String a;
        public final /* synthetic */ ClassLoader b;

        public b(String str, ClassLoader classLoader) {
            this.a = str;
            this.b = classLoader;
            put(str, classLoader);
        }
    }

    public static class c implements Callable<Bundle> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ Bundle b;

        public c(Context context, Bundle bundle) {
            this.a = context;
            this.b = bundle;
        }

        public Bundle call() {
            try {
                return DynamicModule.queryHMSModuleBundle(this.a, b.e, this.b);
            } catch (Exception e) {
                Logger.w(DynamicModule.b, "Query provider error.", (Throwable) e);
                return new Bundle();
            }
        }
    }

    public static class d extends HashMap<String, Boolean> {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
            put(str, true);
        }
    }

    public static class e extends HashMap<String, String> {
        public final /* synthetic */ String a;
        public final /* synthetic */ String b;

        public e(String str, String str2) {
            this.a = str;
            this.b = str2;
            put(str, str2);
        }
    }

    public static class f extends HashMap<String, IDynamicLoader> {
        public final /* synthetic */ String a;
        public final /* synthetic */ IBinder b;

        public f(String str, IBinder iBinder) {
            this.a = str;
            this.b = iBinder;
            put(str, IDynamicLoader.Stub.asInterface(iBinder));
        }
    }

    public static class g extends Exception {
        public g(String str) {
            super(str);
        }

        public /* synthetic */ g(String str, a aVar) {
            this(str);
        }
    }

    public DynamicModule(Context context) {
        this.a = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0088 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.content.Context r9, java.lang.String r10, android.os.Bundle r11) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.String r0 = "huawei_module_dynamicloader"
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r2 = 0
            r3 = 0
            android.os.Bundle r1 = queryHMSModuleBundle(r9, r0, r11)     // Catch:{ LoadingException -> 0x003e, Exception -> 0x0022 }
            java.lang.String r4 = "module_version"
            int r4 = r1.getInt(r4)     // Catch:{ LoadingException -> 0x003e, Exception -> 0x0022 }
            java.lang.String r5 = "copy_type"
            int r5 = r1.getInt(r5)     // Catch:{ LoadingException -> 0x0020, Exception -> 0x001e }
            boolean r10 = a((java.lang.String) r10, (int) r5)     // Catch:{ LoadingException -> 0x0020, Exception -> 0x001e }
            goto L_0x0076
        L_0x001e:
            r10 = move-exception
            goto L_0x0024
        L_0x0020:
            r10 = move-exception
            goto L_0x0040
        L_0x0022:
            r10 = move-exception
            r4 = r2
        L_0x0024:
            java.lang.String r5 = b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Get hms loader info failed:"
            r6.<init>(r7)
            java.lang.String r10 = r10.getMessage()
            java.lang.StringBuilder r10 = r6.append(r10)
            java.lang.String r10 = r10.toString()
            com.huawei.hms.common.util.Logger.w(r5, r10)
        L_0x003c:
            r10 = r2
            goto L_0x0076
        L_0x003e:
            r10 = move-exception
            r4 = r2
        L_0x0040:
            java.lang.String r3 = b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "Get loader in HMS failed:"
            r5.<init>(r6)
            java.lang.String r6 = r10.getMessage()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hms.common.util.Logger.w(r3, r5)
            android.os.Bundle r3 = r10.getBundle()
            if (r3 == 0) goto L_0x006c
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r3 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException
            java.lang.String r5 = r10.getMessage()
            android.os.Bundle r10 = r10.getBundle()
            r3.<init>(r5, r10)
            goto L_0x003c
        L_0x006c:
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r3 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException
            java.lang.String r10 = r10.getMessage()
            r3.<init>(r10)
            goto L_0x003c
        L_0x0076:
            android.os.Bundle r0 = com.huawei.hms.feature.dynamic.AssetLoadManager.getAssetModuleInfo(r9, r0)
            java.lang.String r5 = "local_asset_module_version"
            int r5 = r0.getInt(r5)
            java.lang.String r6 = "module_path"
            java.lang.String r0 = r0.getString(r6)
            if (r4 != 0) goto L_0x0095
            if (r5 != 0) goto L_0x0095
            java.lang.String r9 = b
            java.lang.String r10 = "No available dynamic loader in HMS and asset."
            com.huawei.hms.common.util.Logger.w(r9, r10)
            if (r3 != 0) goto L_0x0094
            return r2
        L_0x0094:
            throw r3
        L_0x0095:
            java.lang.String r2 = b
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r7 = "HMS loader version:"
            r3.<init>(r7)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r7 = ", asset loader version:"
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            com.huawei.hms.common.util.Logger.i(r2, r3)
            java.lang.String r3 = "loader_version"
            java.lang.String r7 = "loader_path"
            if (r4 <= r5) goto L_0x00ff
            java.lang.String r8 = "Choose dynamicLoader in HMS."
            com.huawei.hms.common.util.Logger.i(r2, r8)
            if (r10 == 0) goto L_0x00c8
            java.lang.String r10 = "Need to copy HMS dynamicLoader to local dir."
            com.huawei.hms.common.util.Logger.i(r2, r10)
            com.huawei.hms.feature.dynamic.ModuleCopy.copyModule(r9, r1)
        L_0x00c8:
            java.lang.String r10 = r1.getString(r6)
            boolean r1 = android.text.TextUtils.isEmpty(r10)
            if (r1 != 0) goto L_0x00f3
            java.io.File r1 = new java.io.File
            r1.<init>(r10)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x00f3
            boolean r1 = com.huawei.hms.feature.dynamic.ModuleCopy.isLocalModuleFile(r9, r10)
            if (r1 != 0) goto L_0x00ec
            boolean r9 = com.huawei.hms.feature.dynamic.f.c.a(r9, r10)
            if (r9 != 0) goto L_0x00ec
            java.lang.String r9 = "checkPathValidity failed, choose assets loader as default."
            goto L_0x00f5
        L_0x00ec:
            r11.putString(r7, r10)
            r11.putInt(r3, r4)
            goto L_0x00fe
        L_0x00f3:
            java.lang.String r9 = "HMS dynamicloader is not available, choose assets loader as default."
        L_0x00f5:
            com.huawei.hms.common.util.Logger.i(r2, r9)
            r11.putString(r7, r0)
            r11.putInt(r3, r5)
        L_0x00fe:
            return r4
        L_0x00ff:
            java.lang.String r9 = "Choose dynamicLoader in asset."
            com.huawei.hms.common.util.Logger.i(r2, r9)
            r11.putString(r7, r0)
            r11.putInt(r3, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.a(android.content.Context, java.lang.String, android.os.Bundle):int");
    }

    public static int a(VersionPolicy versionPolicy) {
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.e) {
            return 1;
        }
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.d) {
            return 2;
        }
        return versionPolicy instanceof com.huawei.hms.feature.dynamic.e.c ? 3 : 0;
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(b.k), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                Logger.w(b, "Get remote context is null, module:" + str);
                return null;
            } else if (unwrap instanceof Context) {
                Logger.i(b, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            } else if (unwrap instanceof Bundle) {
                Logger.i(b, "Get module info bundle for " + str);
                return a(context, str, bundle, iDynamicLoader, (Bundle) unwrap);
            } else if (!unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                Logger.w(b, "Get remote context is null, module:" + str);
                return null;
            } else {
                Logger.w(b, "Successfully get the bundle in exception.");
                throw new LoadingException("Failed to load, please check the bundle in exception.", (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(load), new Object[0]));
            }
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.w(b, "Failed to get module context for:" + str, (Throwable) e3);
            return null;
        }
    }

    public static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader, Bundle bundle2) throws LoadingException {
        Object obj;
        bundle.putInt(b.w, 4);
        if (AssetLoadManager.getAssetModuleInfo(context, str).getInt(b.m, 0) > 0) {
            try {
                obj = ObjectWrapper.unwrap(iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(b.k), ObjectWrapper.wrap(bundle)));
            } catch (RemoteException e2) {
                Logger.w(b, "tryWithAssetsModule RemoteException.", (Throwable) e2);
                obj = null;
            }
            if (obj instanceof Context) {
                Logger.i(b, "get dynamic module context for:" + str + " from assets fallback success.");
                return (Context) obj;
            }
            Logger.w(b, "tryWithAssetsModule get dynamicContext failed: null or wrong type.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        Logger.i(b, "No fallback module in assets.");
        throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
    }

    public static Bundle a(Context context, Bundle bundle) throws g {
        try {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            FutureTask futureTask = new FutureTask(new c(context, bundle));
            newSingleThreadExecutor.execute(futureTask);
            Bundle bundle2 = (Bundle) futureTask.get((long) l, TimeUnit.MILLISECONDS);
            String string = bundle2.getString(b.r);
            if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                Logger.w(b, "The loader_path:" + string + " is not available.");
                throw new g("The loader_path in queryBundle is empty or not exist.", (a) null);
            }
            Logger.i(b, "Query HMS module:huawei_module_dynamicloader info success.");
            return bundle2;
        } catch (TimeoutException unused) {
            Logger.w(b, "Query hms provider timeout: over " + l + " ms, choose the local loader fallback.");
            return new Bundle();
        } catch (Exception e2) {
            Logger.w(b, "FutureTask: query provider exception.", (Throwable) e2);
            throw new g("failed to get :huawei_module_dynamicloader info.", (a) null);
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy) throws LoadingException {
        Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
        if (moduleInfo.getInt(b.k) > 0) {
            try {
                return c(context, str, moduleInfo);
            } catch (LoadingException e2) {
                Logger.w(b, "Failed to load remote module.", (Throwable) e2);
                if (getLocalVersion(context, str) > 0) {
                    Logger.d(b, "Local module version is valid, use local fallback.");
                    return new DynamicModule(context.getApplicationContext());
                }
                throw e2;
            }
        } else if (moduleInfo.getInt(b.l) > 0) {
            Logger.i(b, "Remote version is invalid, use local context.");
            return new DynamicModule(context.getApplicationContext());
        } else {
            throw new LoadingException("Query remote version and local version failed.");
        }
    }

    public static DynamicModule a(Context context, String str, VersionPolicy versionPolicy, Bundle bundle) throws LoadingException {
        int a2 = a(versionPolicy);
        String string = bundle.getString(b.r);
        Logger.i(b, "The loader path for module:" + str + " is:" + string + ", and versionType is:" + a2);
        if (!TextUtils.isEmpty(string)) {
            Boolean bool = n.get(str);
            Boolean bool2 = m.get(str);
            bundle.putString(b.j, str);
            bundle.putInt(b.w, a2);
            boolean z = false;
            bundle.putBoolean(b.x, bool != null ? bool.booleanValue() : false);
            if (bool2 != null) {
                z = bool2.booleanValue();
            }
            bundle.putBoolean(b.y, z);
            try {
                return b(context, str, bundle);
            } catch (LoadingException e2) {
                throw e2;
            } catch (Exception e3) {
                Logger.e(b, "Other exception,", (Throwable) e3);
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                return new DynamicModule(context);
            }
        } else {
            throw new LoadingException("Cannot find a valid dynamic loader in HMS or local.");
        }
    }

    public static IDynamicInstall a(Context context, String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (com.huawei.hms.feature.dynamic.f.c.a(context, str)) {
                        return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.e.a(str, ClassLoader.getSystemClassLoader()).loadClass(b.g).getConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Logger.w(b, "check path failed: invalid.");
                    throw new LoadingException("getHMSDynamicInstaller: checkPathValidity failed.");
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e2.getMessage());
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.");
    }

    public static IDynamicLoader a(Context context, String str, String str2, ClassLoader classLoader) {
        if (classLoader == null) {
            try {
                classLoader = new com.huawei.hms.feature.dynamic.e.a(str2, ClassLoader.getSystemClassLoader());
                h.set(new b(str, classLoader));
            } catch (Exception e2) {
                Logger.w(b, "Get iDynamicLoader failed.", (Throwable) e2);
                return null;
            }
        }
        return IDynamicLoader.Stub.asInterface((IBinder) classLoader.loadClass(b.f).getConstructor(new Class[0]).newInstance(new Object[0]));
    }

    public static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            cls = context.getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
        } catch (ClassNotFoundException unused) {
            Logger.w(b, "ClassLoader class not found when use client context.");
            cls = null;
        }
        if (cls == null) {
            try {
                cls = ((ClassLoader) Objects.requireNonNull(DynamicModule.class.getClassLoader())).loadClass(DynamicLoaderClassLoader.class.getName());
                if (cls == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return cls;
    }

    public static void a(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        if (context == null || versionPolicy == null || str == null || str.length() == 0 || str.length() > 256 || bundle == null) {
            throw new LoadingException("Null param, please check it.");
        }
    }

    public static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            g.set(new f(str, (IBinder) classLoader.loadClass(b.f).getConstructor(new Class[0]).newInstance(new Object[0])));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new LoadingException("Failed to get loader interface:" + e2.getMessage());
        }
    }

    public static boolean a(String str, int i2) {
        if (i2 == 1) {
            Boolean bool = n.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } else if (i2 != 2) {
            return i2 == 3 || i2 == 4;
        } else {
            Boolean bool2 = m.get(str);
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.huawei.hms.common.util.Logger.w(b, "Get loader interface failed.", (java.lang.Throwable) r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007a, code lost:
        if (com.huawei.hms.feature.dynamic.f.c.a(r8, r6) == false) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        r8 = new com.huawei.hms.feature.dynamic.e.a(r6, java.lang.ClassLoader.getSystemClassLoader());
        a(r9, (java.lang.ClassLoader) r8);
        r1.invoke((java.lang.Object) null, new java.lang.Object[]{r9, r8});
        e.set(new com.huawei.hms.feature.dynamic.DynamicModule.d(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0099, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009a, code lost:
        com.huawei.hms.common.util.Logger.w(r2, "The loaderPath is invalid.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a6, code lost:
        throw new com.huawei.hms.feature.dynamic.DynamicModule.LoadingException("getHMSModuleInfo: checkPathValidity failed.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00aa, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ab, code lost:
        com.huawei.hms.common.util.Logger.w(b, "failed to load.", (java.lang.Throwable) r8);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00aa A[ExcHandler: Exception (r8v4 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle b(android.content.Context r8, java.lang.String r9) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            r0 = 0
            java.lang.Class r1 = a((android.content.Context) r8)     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.String r2 = "getsClassLoader"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r4)     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.String r4 = "setsClassLoader"
            r5 = 2
            java.lang.Class[] r5 = new java.lang.Class[r5]     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r5[r0] = r6     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.Class<java.lang.ClassLoader> r6 = java.lang.ClassLoader.class
            r5[r3] = r6     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r5)     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.Object[] r4 = new java.lang.Object[]{r9}     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            r5 = 0
            java.lang.Object r2 = r2.invoke(r5, r4)     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.ClassLoader r2 = (java.lang.ClassLoader) r2     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            if (r2 == 0) goto L_0x004d
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            if (r2 != r8) goto L_0x0038
            goto L_0x00b2
        L_0x0038:
            java.lang.String r8 = b     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.String r1 = "Cached loader is available, ready to use it."
            com.huawei.hms.common.util.Logger.i(r8, r1)     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            a((java.lang.String) r9, (java.lang.ClassLoader) r2)     // Catch:{ LoadingException -> 0x0043, Exception -> 0x00aa }
            goto L_0x004b
        L_0x0043:
            r8 = move-exception
            java.lang.String r1 = b     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
            java.lang.String r2 = "Get loader interface failed."
            com.huawei.hms.common.util.Logger.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r8)     // Catch:{ LoadingException -> 0x00c9, Exception -> 0x00aa }
        L_0x004b:
            r0 = r3
            goto L_0x00b2
        L_0x004d:
            java.lang.String r2 = b     // Catch:{ g -> 0x00b2 }
            java.lang.String r3 = "No available cached loader, query remote."
            com.huawei.hms.common.util.Logger.i(r2, r3)     // Catch:{ g -> 0x00b2 }
            android.os.Bundle r3 = c(r8, r9)     // Catch:{ g -> 0x00b2 }
            java.lang.Class<com.huawei.hms.feature.dynamic.DynamicModule> r4 = com.huawei.hms.feature.dynamic.DynamicModule.class
            monitor-enter(r4)     // Catch:{ g -> 0x00b2 }
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.String>> r6 = f     // Catch:{ all -> 0x00a7 }
            java.lang.Object r6 = r6.get()     // Catch:{ all -> 0x00a7 }
            java.lang.Object r6 = java.util.Objects.requireNonNull(r6)     // Catch:{ all -> 0x00a7 }
            java.util.HashMap r6 = (java.util.HashMap) r6     // Catch:{ all -> 0x00a7 }
            java.lang.Object r6 = r6.get(r9)     // Catch:{ all -> 0x00a7 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x00a7 }
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00a7 }
            if (r7 == 0) goto L_0x0075
            monitor-exit(r4)     // Catch:{ all -> 0x00a7 }
            return r3
        L_0x0075:
            monitor-exit(r4)     // Catch:{ all -> 0x00a7 }
            boolean r8 = com.huawei.hms.feature.dynamic.f.c.a(r8, r6)     // Catch:{ g -> 0x00b2 }
            if (r8 == 0) goto L_0x009a
            com.huawei.hms.feature.dynamic.e.a r8 = new com.huawei.hms.feature.dynamic.e.a     // Catch:{ g -> 0x00b2 }
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ g -> 0x00b2 }
            r8.<init>(r6, r2)     // Catch:{ g -> 0x00b2 }
            a((java.lang.String) r9, (java.lang.ClassLoader) r8)     // Catch:{ g -> 0x00b2 }
            java.lang.Object[] r8 = new java.lang.Object[]{r9, r8}     // Catch:{ g -> 0x00b2 }
            r1.invoke(r5, r8)     // Catch:{ g -> 0x00b2 }
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r8 = e     // Catch:{ g -> 0x00b2 }
            com.huawei.hms.feature.dynamic.DynamicModule$d r1 = new com.huawei.hms.feature.dynamic.DynamicModule$d     // Catch:{ g -> 0x00b2 }
            r1.<init>(r9)     // Catch:{ g -> 0x00b2 }
            r8.set(r1)     // Catch:{ g -> 0x00b2 }
            return r3
        L_0x009a:
            java.lang.String r8 = "The loaderPath is invalid."
            com.huawei.hms.common.util.Logger.w(r2, r8)     // Catch:{ g -> 0x00b2 }
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r8 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException     // Catch:{ g -> 0x00b2 }
            java.lang.String r1 = "getHMSModuleInfo: checkPathValidity failed."
            r8.<init>(r1)     // Catch:{ g -> 0x00b2 }
            throw r8     // Catch:{ g -> 0x00b2 }
        L_0x00a7:
            r8 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00a7 }
            throw r8     // Catch:{ g -> 0x00b2 }
        L_0x00aa:
            r8 = move-exception
            java.lang.String r1 = b
            java.lang.String r2 = "failed to load."
            com.huawei.hms.common.util.Logger.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r8)
        L_0x00b2:
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r8.put(r9, r0)
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r9 = e
            r9.set(r8)
            android.os.Bundle r8 = new android.os.Bundle
            r8.<init>()
            return r8
        L_0x00c9:
            r8 = move-exception
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.b(android.content.Context, java.lang.String):android.os.Bundle");
    }

    public static DynamicModule b(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        String str2 = b;
        Logger.i(str2, "dynamic-api version: 10024300");
        a(context, versionPolicy, str, bundle);
        try {
            int a2 = a(context, str, bundle);
            if (a2 >= 10015300) {
                Logger.i(str2, "Load start in new-version-policy.");
                return a(context, str, versionPolicy, bundle);
            } else if (a2 > 0) {
                Logger.i(str2, "Load start in old-version-policy.");
                return a(context, str, versionPolicy);
            } else {
                throw new LoadingException("Cannot find a valid dynamicLoader in HMS and local.");
            }
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception e3) {
            Logger.e(b, "Other exception:" + e3);
            throw new LoadingException("Load failed.");
        }
    }

    public static DynamicModule b(Context context, String str, Bundle bundle) throws LoadingException {
        ClassLoader classLoader;
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, ClassLoader>> threadLocal = h;
            if (threadLocal.get() != null) {
                if (threadLocal.get().get(str) != null) {
                    Logger.i(b, "Cached loader for module is available, ready to use it.");
                    classLoader = (ClassLoader) threadLocal.get().get(str);
                }
            }
            Logger.i(b, "No available cached loader for module:" + str);
            classLoader = null;
        }
        IDynamicLoader a2 = a(context, str, bundle.getString(b.r), classLoader);
        if (a2 != null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context a3 = a(context, str, bundle, a2);
            if (a3 != null) {
                return new DynamicModule(a3);
            }
            throw new LoadingException("New version policy: Failed to get module context: null.");
        }
        throw new LoadingException("Failed to get iDynamicLoader: null.");
    }

    public static IDynamicInstall b(Context context) throws LoadingException {
        int i2;
        String str = null;
        int i3 = 0;
        try {
            Bundle a2 = a(context, (Bundle) null);
            str = a2.getString(b.r);
            i2 = a2.getInt(b.q);
        } catch (Exception e2) {
            Logger.w(b, "Cannot get remote HMS dynamicLoader.", (Throwable) e2);
            i2 = 0;
        }
        try {
            i3 = getLocalVersion(context, b.e);
        } catch (Exception e3) {
            Logger.w(b, "Cannot find local dynamicLoader fallback.", (Throwable) e3);
        }
        String str2 = b;
        Logger.i(str2, "DynamicLoader remoteHMSVersion:" + i2 + ", hmsLoaderPath:" + str + ", localLoaderVersion:" + i3);
        int max = Math.max(i2, i3);
        if (max <= 10009300) {
            Logger.w(str2, "The current version:" + max + " is too low.");
            throw new LoadingException("The loader version:" + max + " is too low to support HFF.");
        } else if (i2 > i3) {
            Logger.i(str2, "Choose hms dynamicLoader: " + str);
            i = 1;
            return a(context, str);
        } else {
            Logger.i(str2, "Choose local dynamicLoader fallback: ");
            i = 2;
            return c(context);
        }
    }

    public static Bundle c(Context context, String str) throws LoadingException, g {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = queryHMSModuleBundle.getString(b.r);
            if (!TextUtils.isEmpty(string)) {
                if (new File(string).exists()) {
                    f.set(new e(str, string));
                    Logger.i(b, "Query remote version by module name:" + str + " success.");
                    return queryHMSModuleBundle;
                }
            }
            Logger.w(b, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            queryHMSModuleBundle.putInt(b.k, -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new g("failed to Query remote version.", (a) null);
        }
    }

    public static DynamicModule c(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                bool = (Boolean) ((HashMap) Objects.requireNonNull(e.get())).get(str);
                iDynamicLoader = (IDynamicLoader) ((HashMap) Objects.requireNonNull(g.get())).get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.");
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context a2 = a(context, str, bundle, iDynamicLoader);
            if (a2 != null) {
                return new DynamicModule(a2);
            }
            throw new LoadingException("Failed to get remote module context: null");
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.");
        }
    }

    public static IDynamicInstall c(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(b.g).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e2) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e2.getMessage());
        }
    }

    public static void enable3rdPhone(String str, boolean z) {
        m.put(str, Boolean.valueOf(z));
    }

    public static void enableLowEMUI(String str, boolean z) {
        n.put(str, Boolean.valueOf(z));
    }

    public static Set<String> getInstalledModuleInfo() {
        return d.a().a;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString(b.j, str);
        bundle.putInt(b.l, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(b, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = AssetLoadManager.d + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt((Object) null);
        } catch (ClassNotFoundException unused) {
            Logger.w(b, "Cannot find the class of module descriptor for " + str);
            return 0;
        } catch (Exception e2) {
            Logger.w(b, "Get local module info failed.", (Throwable) e2);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (((java.lang.Boolean) r1.get().get(r5)).booleanValue() == false) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        return c(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.huawei.hms.common.util.Logger.w(b, "Query remote module info in HMS failed.", (java.lang.Throwable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        return new android.os.Bundle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle getRemoteModuleInfo(android.content.Context r4, java.lang.String r5) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.Class<com.huawei.hms.feature.dynamic.DynamicModule> r0 = com.huawei.hms.feature.dynamic.DynamicModule.class
            monitor-enter(r0)     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r1 = e     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x0058 }
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x0058 }
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0058 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0058 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0037
        L_0x0029:
            android.os.Bundle r2 = b(r4, r5)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "module_version"
            int r3 = r2.getInt(r3)     // Catch:{ all -> 0x0058 }
            if (r3 <= 0) goto L_0x0037
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            return r2
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            java.lang.Object r0 = r1.get()     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            boolean r0 = r0.booleanValue()     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            if (r0 == 0) goto L_0x0076
            android.os.Bundle r4 = c(r4, r5)     // Catch:{ g -> 0x004f }
            return r4
        L_0x004f:
            r4 = move-exception
            java.lang.String r0 = b     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            java.lang.String r1 = "Query remote module info in HMS failed."
            com.huawei.hms.common.util.Logger.w((java.lang.String) r0, (java.lang.String) r1, (java.lang.Throwable) r4)     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
            goto L_0x0076
        L_0x0058:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r4     // Catch:{ LoadingException -> 0x007c, Exception -> 0x005b }
        L_0x005b:
            r4 = move-exception
            java.lang.String r0 = b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Get remote module info for "
            r1.<init>(r2)
            java.lang.StringBuilder r5 = r1.append(r5)
            java.lang.String r1 = " failed."
            java.lang.StringBuilder r5 = r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.huawei.hms.common.util.Logger.w((java.lang.String) r0, (java.lang.String) r5, (java.lang.Throwable) r4)
        L_0x0076:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            return r4
        L_0x007c:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.getRemoteModuleInfo(android.content.Context, java.lang.String):android.os.Bundle");
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle c2 = c(context, str);
            if (c2 != null && !c2.isEmpty()) {
                return c2.getInt(b.k);
            }
            Logger.w(b, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (g e2) {
            Logger.w(b, "Query remote module:" + str + " exception:" + e2);
            return 0;
        }
    }

    public static void install(Context context, int i2) {
        String str = b;
        Logger.i(str, "dynamic-api version: 10024300");
        if (context == null) {
            Logger.e(str, "The input context is null.");
            return;
        }
        try {
            l = i2;
            Logger.i(str, "Query HMS provider timeOut is set to:" + l + " ms.");
            IDynamicInstall b2 = b(context);
            if (b2 != null) {
                Bundle install = b2.install(ObjectWrapper.wrap(context), new Bundle());
                if (install != null) {
                    d.a().a(install);
                    Logger.i(str, "Install module success.");
                    return;
                }
                throw new LoadingException("Get install info failed: moduleBundle is null.");
            }
            throw new LoadingException("Get dynamicInstaller failed.");
        } catch (RemoteException | LoadingException | NullPointerException e2) {
            if (i == 2 || getLocalVersion(context, b.e) <= 0) {
                Logger.w(b, "Install module failed.", e2);
                return;
            }
            String str2 = b;
            Logger.i(str2, "Ready to use local loader-fallback to retry:");
            Bundle install2 = c(context).install(ObjectWrapper.wrap(context), new Bundle());
            if (install2 != null) {
                d.a().a(install2);
                Logger.i(str2, "Retry install module with local loader-fallback success.");
                return;
            }
            throw new LoadingException("Retry: get install info failed: moduleBundle is null.");
        } catch (RemoteException | LoadingException | NullPointerException e3) {
            Logger.w(b, "Retry failed with local loader-fallback.", e3);
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return b(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV2(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Bundle bundle = new Bundle();
        bundle.putString(b.s, b.t);
        return b(context, versionPolicy, str, bundle);
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return loadV3(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        bundle.putString(b.s, b.u);
        return b(context, versionPolicy, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, g {
        return queryHMSModuleBundle(context, str, (Bundle) null);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str, Bundle bundle) throws LoadingException, g {
        try {
            if (com.huawei.hms.feature.dynamic.f.c.a(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    Bundle call = contentResolver.call(Uri.parse(b.a), str, (String) null, bundle);
                    if (call != null) {
                        int i2 = call.getInt(b.h);
                        String string = call.getString(b.r);
                        String str2 = b;
                        Logger.i(str2, "bundle info: errorCode:" + i2 + ", moduleVersion:" + call.getInt(b.k) + ", modulePath:" + call.getString(b.n) + ", loader_version:" + call.getInt(b.q) + ", loaderPath:" + string + ", armeabiType:" + call.getInt(b.v));
                        if (i2 == 0) {
                            return call;
                        }
                        Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i2);
                        throw new LoadingException("Query " + str + " unavailable, errorCode:" + i2, call);
                    }
                    Logger.w(b, "Failed to get bundle info:null.");
                    throw new g("Query remote version failed: null bundle info.", (a) null);
                }
                throw new g("Query remote version failed: null contentResolver.", (a) null);
            }
            Logger.w(b, "No valid HMS Core in this device.");
            throw new g("HMS Core is not installed.", (a) null);
        } catch (LoadingException e2) {
            throw e2;
        } catch (Exception unused) {
            throw new g("failed to get :" + str + " info from HMS Core.", (a) null);
        }
    }

    public final Context getModuleContext() {
        return this.a;
    }
}
