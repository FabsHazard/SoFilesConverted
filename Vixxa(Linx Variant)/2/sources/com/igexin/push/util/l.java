package com.igexin.push.util;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Process;
import android.util.Base64;
import com.igexin.a.a.c.b;
import com.igexin.push.core.d;
import java.lang.reflect.Method;

public class l {
    private static int a = Integer.MIN_VALUE;
    private static String b = "GT_PM";
    private static Object c;

    private static int a() {
        int i = a;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (d.e != null) {
            try {
                Class<?> cls = Class.forName(new String(Base64.decode("YW5kcm9pZC5vcy5Vc2VySGFuZGxl", 0)));
                Method declaredMethod = cls.getDeclaredMethod(new String(Base64.decode("Z2V0VXNlcklk", 0)), new Class[]{Integer.TYPE});
                declaredMethod.setAccessible(true);
                int intValue = ((Integer) declaredMethod.invoke(cls, new Object[]{Integer.valueOf(Process.myUid())})).intValue();
                a = intValue;
                return intValue;
            } catch (Throwable th) {
                b.b(b, th.getMessage());
            }
        }
        return 0;
    }

    private static PackageInfo a(Object obj, String str, int i) {
        Parcel obtain;
        Parcel obtain2;
        PackageInfo packageInfo = null;
        try {
            IBinder asBinder = ((IInterface) obj).asBinder();
            obtain = Parcel.obtain();
            obtain2 = Parcel.obtain();
            obtain.writeInterfaceToken(asBinder.getInterfaceDescriptor());
            obtain.writeString(str);
            obtain.writeLong((long) i);
            obtain.writeInt(a());
            asBinder.transact(3, obtain, obtain2, 0);
            obtain2.readException();
            if (obtain2.readInt() != 0) {
                packageInfo = (PackageInfo) PackageInfo.CREATOR.createFromParcel(obtain2);
            }
            obtain2.recycle();
            obtain.recycle();
        } catch (Throwable th) {
            b.a(b + th.toString(), new Object[0]);
        }
        return packageInfo;
    }

    public static PackageInfo a(String str, int i) throws PackageManager.NameNotFoundException {
        PackageInfo a2 = a(str, i, a());
        if (a2 != null) {
            return a2;
        }
        throw new PackageManager.NameNotFoundException(str + " not found");
    }

    private static PackageInfo a(String str, int i, int i2) {
        PackageInfo packageInfo;
        try {
            if (c == null) {
                c = Class.forName(new String(Base64.decode("YW5kcm9pZC5hcHAuQWN0aXZpdHlUaHJlYWQ=", 0))).getMethod(new String(Base64.decode("Z2V0UGFja2FnZU1hbmFnZXI=", 0)), new Class[0]).invoke((Object) null, new Object[0]);
            }
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = a(c, str, i);
            } else {
                String str2 = new String(Base64.decode("Z2V0UGFja2FnZUluZm8=", 0));
                packageInfo = (PackageInfo) c.getClass().getMethod(str2, new Class[]{String.class, Integer.TYPE, Integer.TYPE}).invoke(c, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
            }
            return packageInfo;
        } catch (Throwable th) {
            b.b(b, th.getMessage());
            return null;
        }
    }
}
