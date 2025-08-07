package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.scankit.p.b4;
import com.huawei.hms.scankit.p.o4;
import java.lang.reflect.InvocationTargetException;

/* compiled from: RemoteViewInitializer */
public class f {
    private static volatile Context a;

    public static int a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("huawei_module_scankit_local", Integer.MAX_VALUE);
        } catch (PackageManager.NameNotFoundException unused) {
            o4.b("exception", "NameNotFoundException");
            return Integer.MAX_VALUE;
        }
    }

    public static void b(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        context.getClassLoader().loadClass("com.huawei.hms.feature.DynamicModuleInitializer").getDeclaredMethod("initializeModule", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
    }

    static IRemoteCreator c(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Context e = e(context);
            if (e == null) {
                return null;
            }
            Object newInstance = e.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
            return null;
        } catch (ClassNotFoundException unused) {
            o4.b("exception", "ClassNotFoundException");
            return null;
        } catch (InstantiationException unused2) {
            o4.b("exception", "InstantiationException");
            return null;
        } catch (IllegalAccessException unused3) {
            o4.b("exception", "IllegalAccessException");
            return null;
        } catch (NoSuchMethodException unused4) {
            o4.b("exception", "NoSuchMethodException");
            return null;
        } catch (InvocationTargetException unused5) {
            o4.b("exception", "InvocationTargetException");
            return null;
        }
    }

    static IRemoteCreator d(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Object newInstance = context.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
        } catch (ClassNotFoundException unused) {
            o4.b("exception", "ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            o4.b("exception", "IllegalAccessException");
        } catch (InstantiationException unused3) {
            o4.b("exception", "InvocationTargetException");
        }
        return null;
    }

    public static Context e(Context context) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.i("ScankitSDK", "ScankitSDK Version: SCAN2.11.0.300");
        b(context);
        if (a != null) {
            Log.i("ScankitSDK", "context has been inited");
            return a;
        }
        try {
            b4.a = false;
            Context moduleContext = DynamicModule.load(context.getApplicationContext(), DynamicModule.PREFER_REMOTE, "huawei_module_scankit").getModuleContext();
            int remoteVersion = DynamicModule.getRemoteVersion(context.getApplicationContext(), "huawei_module_scankit");
            int a2 = a(context);
            o4.c("ScankitSDK", "local Version: " + a2 + " remote Version: " + remoteVersion);
            if (a2 > remoteVersion) {
                b(context);
                return context;
            }
            b4.a = true;
            b4.b = String.valueOf(remoteVersion);
            Log.i("ScankitSDK", "use remote scankit " + remoteVersion);
            a = moduleContext;
            return a;
        } catch (DynamicModule.LoadingException unused) {
            b(context);
            o4.b("ScankitSDK", "Remote Load exception");
            return context;
        } catch (ClassNotFoundException unused2) {
            o4.b("ScankitSDK", "ClassNotFoundException exception");
            b(context);
            return context;
        } catch (NoSuchMethodException unused3) {
            o4.b("ScankitSDK", "NoSuchMethodException exception");
            b(context);
            return context;
        } catch (IllegalAccessException unused4) {
            o4.b("ScankitSDK", "IllegalAccessException exception");
            b(context);
            return context;
        } catch (InvocationTargetException unused5) {
            o4.b("ScankitSDK", "InvocationTargetException exception");
            b(context);
            return context;
        } catch (RuntimeException unused6) {
            o4.b("ScankitSDK", "other RuntimeException exception");
            b(context);
            return context;
        } catch (Exception unused7) {
            o4.b("ScankitSDK", "Exception exception");
            b(context);
            return context;
        } catch (Throwable unused8) {
            o4.b("ScankitSDK", "Throwable exception");
            b(context);
            return context;
        }
    }
}
