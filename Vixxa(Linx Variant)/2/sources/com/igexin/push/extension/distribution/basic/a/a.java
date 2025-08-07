package com.igexin.push.extension.distribution.basic.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.b;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.d;
import com.igexin.push.extension.distribution.basic.c.e;
import com.igexin.push.extension.distribution.basic.g.c;
import com.igexin.sdk.PushConsts;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

public class a implements com.igexin.push.core.a.a.a {
    private static final String a = ("EXT-" + a.class.getName());

    private int a() {
        try {
            Field field = Class.forName("com.android.internal.R$id").getField("icon");
            field.setAccessible(true);
            return field.getInt((Object) null);
        } catch (Exception unused) {
            return 0;
        }
    }

    private int a(com.igexin.push.extension.distribution.basic.b.a aVar, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            if (!TextUtils.isEmpty(d.ax)) {
                int identifier = d.e.getResources().getIdentifier(d.ax, "drawable", d.c);
                if (identifier == 0) {
                    identifier = d.e.getResources().getIdentifier(d.ax, "mipmap", d.c);
                }
                if (identifier > 0) {
                    return identifier;
                }
            }
            int identifier2 = d.e.getResources().getIdentifier("push_small", "drawable", d.c);
            if (identifier2 == 0) {
                identifier2 = d.e.getResources().getIdentifier("push_small", "mipmap", d.c);
            }
            if (identifier2 != 0) {
                String str = a;
                b.a(str, "|push_small.png is set, use default push_small");
                b.a(str + "|push_small.png is set, use default push_small", new Object[0]);
                return identifier2;
            }
            String str2 = a;
            b.c(str2, "|push_small.png is missing");
            b.a(str2 + "|push_small.png is missing", new Object[0]);
            return d.e.getApplicationInfo().icon;
        }
        if (!TextUtils.isEmpty(d.ay) && (i2 = d.e.getResources().getIdentifier(d.ay, "drawable", d.c)) == 0) {
            i2 = d.e.getResources().getIdentifier(d.ay, "mipmap", d.c);
        }
        int identifier3 = d.e.getResources().getIdentifier("push", "drawable", d.c);
        if (identifier3 == 0) {
            identifier3 = d.e.getResources().getIdentifier("push", "mipmap", d.c);
        }
        if (TextUtils.isEmpty(aVar.s()) || "null".equals(aVar.s())) {
            return i2 > 0 ? i2 : identifier3;
        }
        if (aVar.s().startsWith("@")) {
            String s = aVar.s();
            return s.substring(1, s.length()).endsWith(NotificationCompat.CATEGORY_EMAIL) ? 17301647 : 17301651;
        }
        if (!"push".equals(aVar.s()) || i2 <= 0) {
            i = d.e.getResources().getIdentifier(aVar.s(), "drawable", d.c);
            if (i == 0) {
                i = d.e.getResources().getIdentifier(aVar.s(), "mipmap", d.c);
            }
        } else {
            i = i2;
        }
        return i > 0 ? i : i2 > 0 ? i2 : identifier3;
    }

    private int a(String str) {
        int i = 0;
        for (int i2 = 0; i2 != str.length(); i2++) {
            i = (i * 131) + str.charAt(i2);
        }
        if (i == Integer.MIN_VALUE) {
            i = 1;
        }
        return Math.abs(i);
    }

    private Notification.Builder a(com.igexin.push.extension.distribution.basic.b.a aVar) {
        Notification.Builder builder = new Notification.Builder(d.e);
        NotificationManager notificationManager = (NotificationManager) d.e.getSystemService("notification");
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE});
            int g = aVar.j() ? 4 : aVar.g();
            Class<?> cls2 = notificationManager.getClass();
            if (((Parcelable) cls2.getMethod("getNotificationChannel", new Class[]{String.class}).invoke(notificationManager, new Object[]{aVar.e()})) == null) {
                Parcelable parcelable = (Parcelable) constructor.newInstance(new Object[]{aVar.e(), aVar.f(), Integer.valueOf(g)});
                Method method = cls2.getMethod("createNotificationChannel", new Class[]{Class.forName("android.app.NotificationChannel")});
                Method method2 = cls.getMethod("enableVibration", new Class[]{Boolean.TYPE});
                Method method3 = cls.getMethod("setSound", new Class[]{Uri.class, AudioAttributes.class});
                method2.invoke(parcelable, new Object[]{Boolean.valueOf(aVar.A())});
                if (!aVar.B()) {
                    method3.invoke(parcelable, new Object[]{null, null});
                } else if (!TextUtils.isEmpty(aVar.C())) {
                    method3.invoke(parcelable, new Object[]{b(aVar.C()), null});
                }
                method.invoke(notificationManager, new Object[]{parcelable});
            }
            builder.getClass().getMethod("setChannelId", new Class[]{String.class}).invoke(builder, new Object[]{aVar.e()});
        } catch (Exception unused) {
        }
        return builder;
    }

    private Notification a(Notification notification, com.igexin.push.extension.distribution.basic.b.a aVar) {
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        if (aVar.B()) {
            if (TextUtils.isEmpty(aVar.C())) {
                notification.defaults |= 1;
            } else {
                notification.sound = b(aVar.C());
            }
        }
        notification.flags = aVar.E() ? notification.flags | 16 : notification.flags | 32;
        if (aVar.A()) {
            notification.defaults |= 2;
        }
        notification.icon = a(aVar, true);
        return notification;
    }

    private PendingIntent a(Intent intent) {
        return PendingIntent.getService(d.e, new Random().nextInt(1000), intent, (com.igexin.push.extension.distribution.basic.g.d.a(d.e) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 67108864);
    }

    private PendingIntent a(String str, String str2, int i, com.igexin.push.extension.distribution.basic.b.a aVar, boolean z) {
        Intent intent = new Intent(com.igexin.push.extension.distribution.basic.c.b.a);
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, d.a);
        intent.putExtra("actionid", aVar.getDoActionId());
        intent.putExtra("accesstoken", e.d);
        intent.putExtra("notifID", i);
        String str3 = "";
        intent.putExtra("notifyStyle", aVar.x() + str3);
        intent.putExtra("id", aVar.i() + str3);
        intent.putExtra("bigStyle", aVar.l() + str3);
        intent.putExtra("isFloat", z);
        intent.putExtra("checkpackage", d.e.getPackageName());
        intent.putExtra("feedbackid", aVar.getActionId().substring(aVar.getActionId().length() - 1));
        String q = aVar.q();
        if (q == null) {
            q = str3;
        }
        intent.putExtra("title", q);
        String r = aVar.r();
        if (r == null) {
            r = str3;
        }
        intent.putExtra("content", r);
        String a2 = aVar.a();
        if (a2 == null) {
            a2 = str3;
        }
        intent.putExtra("url", a2);
        String b = aVar.b();
        if (b == null) {
            b = str3;
        }
        intent.putExtra("intentUri", b);
        String c = aVar.c();
        if (c != null) {
            str3 = c;
        }
        intent.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, str3);
        if (c.a("4.4.3.13", "2.11.0.0") < 0) {
            return PendingIntent.getBroadcast(d.e, new Random().nextInt(1000), intent, 134217728);
        }
        try {
            Intent intent2 = new Intent(d.e, Class.forName("com.igexin.sdk.GetuiActivity"));
            intent2.setFlags(268435456);
            intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent2.putExtra("broadcast_intent", intent);
            return PendingIntent.getActivity(d.e, new Random().nextInt(1000), intent2, 201326592);
        } catch (Throwable unused) {
            Intent intent3 = new Intent(PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent3.setAction(PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent3.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent3.putExtra("broadcast_intent", intent);
            return PendingIntent.getBroadcast(d.e, new Random().nextInt(1000), intent3, 201326592);
        }
    }

    private PendingIntent a(String str, String str2, String str3, int i, com.igexin.push.extension.distribution.basic.b.a aVar, boolean z) {
        try {
            Intent intent = new Intent(d.e, Class.forName(com.igexin.push.extension.distribution.basic.g.e.a(e.a)));
            intent.putExtra("taskid", str2);
            intent.putExtra("messageid", str3);
            intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, d.a);
            intent.putExtra("appkey", str);
            intent.putExtra("actionid", aVar.getDoActionId());
            intent.putExtra("notifyStyle", aVar.x() + "");
            intent.putExtra("id", aVar.i() + "");
            intent.putExtra("feedbackid", aVar.getActionId().substring(aVar.getActionId().length() - 1));
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_DELETE);
            return a(intent);
        } catch (Exception e) {
            b.a(a + "|getDelPendingIntent err：" + e.toString(), new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.lang.String r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, com.igexin.push.extension.distribution.basic.b.a r25) {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "notification_arrived"
            java.lang.String r2 = "4.4.3.13"
            android.content.Context r3 = com.igexin.push.core.d.e
            if (r3 != 0) goto L_0x000b
            return
        L_0x000b:
            r3 = 1902131808(0x71603a60, float:1.1103234E30)
            r4 = 0
            r5 = 0
            android.content.Context r6 = com.igexin.push.core.d.e     // Catch:{ all -> 0x00e7 }
            java.lang.Class r6 = r1.b((android.content.Context) r6)     // Catch:{ all -> 0x00e7 }
            if (r6 == 0) goto L_0x011f
            java.lang.String r7 = com.igexin.push.core.d.a     // Catch:{ all -> 0x00e7 }
            if (r7 == 0) goto L_0x011f
            android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x00e7 }
            android.content.Context r8 = com.igexin.push.core.d.e     // Catch:{ all -> 0x00e7 }
            r7.<init>(r8, r6)     // Catch:{ all -> 0x00e7 }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ all -> 0x00e4 }
            r5.<init>()     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = "action"
            r8 = 10011(0x271b, float:1.4028E-41)
            r5.putInt(r6, r8)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = "com.igexin.sdk.message.GTNotificationMessage"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ all -> 0x00e4 }
            r8 = 7
            r9 = 3
            r10 = 4
            r11 = 2
            r12 = 1
            java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r8[r4] = r13     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r8[r12] = r13     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r8[r11] = r13     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r8[r9] = r13     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r8[r10] = r13     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r14 = 5
            r8[r14] = r13     // Catch:{ all -> 0x0080 }
            java.lang.Class<java.lang.String> r13 = java.lang.String.class
            r14 = 6
            r8[r14] = r13     // Catch:{ all -> 0x0080 }
            java.lang.reflect.Constructor r8 = r6.getConstructor(r8)     // Catch:{ all -> 0x0080 }
            java.lang.String r17 = r25.a()     // Catch:{ all -> 0x0080 }
            java.lang.String r18 = r25.b()     // Catch:{ all -> 0x0080 }
            java.lang.String r19 = r25.c()     // Catch:{ all -> 0x0080 }
            r13 = r21
            r14 = r22
            r15 = r23
            r16 = r24
            java.lang.Object[] r13 = new java.lang.Object[]{r13, r14, r15, r16, r17, r18, r19}     // Catch:{ all -> 0x0080 }
            java.lang.Object r8 = r8.newInstance(r13)     // Catch:{ all -> 0x0080 }
            java.io.Serializable r8 = (java.io.Serializable) r8     // Catch:{ all -> 0x0080 }
            r5.putSerializable(r0, r8)     // Catch:{ all -> 0x0080 }
            goto L_0x00c9
        L_0x0080:
            java.lang.String r8 = "2.12.0.0"
            int r8 = com.igexin.push.extension.distribution.basic.g.c.a(r2, r8)     // Catch:{ all -> 0x00e4 }
            if (r8 != 0) goto L_0x00a6
            java.lang.Class[] r0 = new java.lang.Class[r11]     // Catch:{ all -> 0x00e4 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r0[r4] = r8     // Catch:{ all -> 0x00e4 }
            java.lang.Class<java.lang.String> r8 = java.lang.String.class
            r0[r12] = r8     // Catch:{ all -> 0x00e4 }
            java.lang.reflect.Constructor r0 = r6.getConstructor(r0)     // Catch:{ all -> 0x00e4 }
            java.lang.String r6 = "notification_arrive"
            java.lang.Object[] r8 = new java.lang.Object[]{r21, r22}     // Catch:{ all -> 0x00e4 }
            java.lang.Object r0 = r0.newInstance(r8)     // Catch:{ all -> 0x00e4 }
            java.io.Serializable r0 = (java.io.Serializable) r0     // Catch:{ all -> 0x00e4 }
            r5.putSerializable(r6, r0)     // Catch:{ all -> 0x00e4 }
            goto L_0x00c9
        L_0x00a6:
            java.lang.Class[] r8 = new java.lang.Class[r10]     // Catch:{ all -> 0x00e4 }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r8[r4] = r10     // Catch:{ all -> 0x00e4 }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r8[r12] = r10     // Catch:{ all -> 0x00e4 }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r8[r11] = r10     // Catch:{ all -> 0x00e4 }
            java.lang.Class<java.lang.String> r10 = java.lang.String.class
            r8[r9] = r10     // Catch:{ all -> 0x00e4 }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r8)     // Catch:{ all -> 0x00e4 }
            java.lang.Object[] r8 = new java.lang.Object[]{r21, r22, r23, r24}     // Catch:{ all -> 0x00e4 }
            java.lang.Object r6 = r6.newInstance(r8)     // Catch:{ all -> 0x00e4 }
            java.io.Serializable r6 = (java.io.Serializable) r6     // Catch:{ all -> 0x00e4 }
            r5.putSerializable(r0, r6)     // Catch:{ all -> 0x00e4 }
        L_0x00c9:
            r7.putExtras(r5)     // Catch:{ all -> 0x00e4 }
            android.content.Context r0 = com.igexin.push.core.d.e     // Catch:{ all -> 0x00e4 }
            boolean r0 = r1.a((android.content.Context) r0)     // Catch:{ all -> 0x00e4 }
            if (r0 == 0) goto L_0x00de
            com.igexin.push.extension.distribution.basic.c.a r0 = com.igexin.push.extension.distribution.basic.c.a.a()     // Catch:{ all -> 0x00e4 }
            android.content.Context r5 = com.igexin.push.core.d.e     // Catch:{ all -> 0x00e4 }
            r0.a(r5, r7, r3)     // Catch:{ all -> 0x00e4 }
            goto L_0x011f
        L_0x00de:
            android.content.Context r0 = com.igexin.push.core.d.e     // Catch:{ all -> 0x00e4 }
            r0.startService(r7)     // Catch:{ all -> 0x00e4 }
            goto L_0x011f
        L_0x00e4:
            r0 = move-exception
            r5 = r7
            goto L_0x00e8
        L_0x00e7:
            r0 = move-exception
        L_0x00e8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = a
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = "|"
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r4)
            boolean r0 = r0 instanceof java.lang.IllegalStateException
            if (r0 == 0) goto L_0x011f
            java.lang.String r0 = "2.13.1.0"
            int r0 = com.igexin.push.extension.distribution.basic.g.c.a(r2, r0)
            if (r0 < 0) goto L_0x011f
            com.igexin.push.extension.distribution.basic.c.a r0 = com.igexin.push.extension.distribution.basic.c.a.a()
            android.content.Context r2 = com.igexin.push.core.d.e
            r0.a(r2, r5, r3)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.igexin.push.extension.distribution.basic.b.a):void");
    }

    private boolean a(Context context) {
        return c.a("4.4.3.13", "2.13.1.0") >= 0 && com.igexin.push.extension.distribution.basic.g.b.b();
    }

    private Uri b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Uri.parse("android.resource://" + d.e.getPackageName() + "/raw/" + str.toLowerCase());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private Class b(Context context) {
        try {
            com.igexin.push.extension.distribution.basic.d.a.a();
            String c = com.igexin.push.extension.distribution.basic.d.a.c();
            if (!TextUtils.isEmpty(c)) {
                return Class.forName(c);
            }
            return null;
        } catch (Throwable th) {
            b.a(a + Logger.c + th.toString(), new Object[0]);
            return null;
        }
    }

    private Bitmap c(String str) {
        if (str != null) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile != null) {
                    return decodeFile;
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.a a(com.igexin.push.core.bean.PushTaskBean r11, com.igexin.push.core.bean.BaseAction r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.igexin.push.extension.distribution.basic.b.a
            if (r0 == 0) goto L_0x006e
            r0 = r12
            com.igexin.push.extension.distribution.basic.b.a r0 = (com.igexin.push.extension.distribution.basic.b.a) r0
            java.lang.String r2 = r0.t()
            java.lang.String r7 = r0.p()
            java.lang.String r8 = r11.getTaskId()
            java.lang.String r11 = r11.getMessageId()
            r1 = 1
            java.lang.String r3 = ""
            r4 = 0
            if (r7 == 0) goto L_0x0033
            com.igexin.push.extension.distribution.basic.c.c r5 = com.igexin.push.extension.distribution.basic.c.c.a()
            java.lang.String r5 = r5.a((java.lang.String) r7)
            boolean r6 = r5.equals(r3)
            if (r6 == 0) goto L_0x0030
            r0.c((boolean) r4)
            r9 = r1
            goto L_0x0034
        L_0x0030:
            r0.h((java.lang.String) r5)
        L_0x0033:
            r9 = r4
        L_0x0034:
            if (r2 == 0) goto L_0x004b
            com.igexin.push.extension.distribution.basic.c.c r5 = com.igexin.push.extension.distribution.basic.c.c.a()
            java.lang.String r5 = r5.a((java.lang.String) r2)
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0048
            r0.d((boolean) r4)
            goto L_0x004c
        L_0x0048:
            r0.n(r5)
        L_0x004b:
            r1 = r4
        L_0x004c:
            if (r1 != 0) goto L_0x0054
            if (r9 == 0) goto L_0x0051
            goto L_0x0054
        L_0x0051:
            com.igexin.push.core.a r11 = com.igexin.push.core.a.success
            return r11
        L_0x0054:
            if (r1 == 0) goto L_0x005e
            r6 = 2
            r1 = r10
            r3 = r8
            r4 = r11
            r5 = r12
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (com.igexin.push.core.bean.BaseAction) r5, (int) r6)
        L_0x005e:
            if (r9 == 0) goto L_0x006b
            r0 = 8
            r3 = r10
            r4 = r7
            r5 = r8
            r6 = r11
            r7 = r12
            r8 = r0
            r3.a((java.lang.String) r4, (java.lang.String) r5, (java.lang.String) r6, (com.igexin.push.core.bean.BaseAction) r7, (int) r8)
        L_0x006b:
            com.igexin.push.core.a r11 = com.igexin.push.core.a.wait
            return r11
        L_0x006e:
            com.igexin.push.core.a r11 = com.igexin.push.core.a.stop
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):com.igexin.push.core.a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e4, code lost:
        if (r5 >= 1) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:?, code lost:
        r15.b(0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:132:0x028b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:75:0x0168 */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0057 A[Catch:{ Exception -> 0x02bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0064 A[Catch:{ Exception -> 0x02bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071 A[Catch:{ Exception -> 0x02bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ac A[Catch:{ Exception -> 0x02bd }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ca A[Catch:{ Exception -> 0x02bd }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r21) {
        /*
            r20 = this;
            r0 = r21
            java.lang.String r1 = "is_noclear"
            java.lang.String r2 = ".png"
            java.lang.String r3 = "isFloat"
            java.lang.String r4 = "priority"
            java.lang.String r5 = "bigStyle"
            java.lang.String r6 = "text"
            java.lang.String r7 = "title"
            java.lang.String r8 = "id"
            java.lang.String r9 = "notifyStyle"
            java.lang.String r10 = "notifyid"
            java.lang.String r11 = "big_text"
            java.lang.String r12 = "big_image_url"
            java.lang.String r13 = "logo"
            java.lang.String r14 = "logo_url"
            java.lang.String r15 = " NotificationAction.parseAction() : "
            r16 = 0
            r17 = r15
            com.igexin.push.extension.distribution.basic.b.a r15 = new com.igexin.push.extension.distribution.basic.b.a     // Catch:{ Exception -> 0x02bd }
            r15.<init>()     // Catch:{ Exception -> 0x02bd }
            r18 = r10
            java.lang.String r10 = "notification"
            r15.setType(r10)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r10 = "actionid"
            java.lang.String r10 = r0.getString(r10)     // Catch:{ Exception -> 0x02bd }
            r15.setActionId(r10)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r10 = "do"
            java.lang.String r10 = r0.getString(r10)     // Catch:{ Exception -> 0x02bd }
            r15.setDoActionId(r10)     // Catch:{ Exception -> 0x02bd }
            boolean r10 = r0.has(r9)     // Catch:{ Exception -> 0x02bd }
            r19 = r1
            r1 = 0
            if (r10 == 0) goto L_0x0050
            int r9 = r0.getInt(r9)     // Catch:{ Exception -> 0x0050 }
            goto L_0x0051
        L_0x0050:
            r9 = r1
        L_0x0051:
            boolean r10 = r0.has(r8)     // Catch:{ Exception -> 0x02bd }
            if (r10 == 0) goto L_0x005e
            java.lang.String r8 = r0.getString(r8)     // Catch:{ Exception -> 0x02bd }
            r15.f((java.lang.String) r8)     // Catch:{ Exception -> 0x02bd }
        L_0x005e:
            boolean r8 = r0.has(r7)     // Catch:{ Exception -> 0x02bd }
            if (r8 == 0) goto L_0x006b
            java.lang.String r7 = r0.getString(r7)     // Catch:{ Exception -> 0x02bd }
            r15.j(r7)     // Catch:{ Exception -> 0x02bd }
        L_0x006b:
            boolean r7 = r0.has(r6)     // Catch:{ Exception -> 0x02bd }
            if (r7 == 0) goto L_0x0078
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x02bd }
            r15.k(r6)     // Catch:{ Exception -> 0x02bd }
        L_0x0078:
            java.lang.String r6 = r15.q()     // Catch:{ Exception -> 0x02bd }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02bd }
            r7 = 4
            if (r6 == 0) goto L_0x00aa
            java.lang.String r6 = r15.r()     // Catch:{ Exception -> 0x02bd }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x00aa
            if (r9 == r7) goto L_0x00aa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            r0.<init>()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = "|title and content is empty, not support"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02bd }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02bd }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02bd }
            return r16
        L_0x00aa:
            if (r9 != r7) goto L_0x00ca
            r15.f((int) r7)     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            r0.<init>()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = "Do not support notifyStyle4"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02bd }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02bd }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02bd }
            return r16
        L_0x00ca:
            java.lang.String r6 = a     // Catch:{ Exception -> 0x02bd }
            java.lang.String r8 = "parse notify style 0"
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.String) r8)     // Catch:{ Exception -> 0x02bd }
            r15.f((int) r1)     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r0.has(r5)     // Catch:{ Exception -> 0x02bd }
            r8 = 3
            r9 = 1
            if (r6 == 0) goto L_0x00e6
            int r5 = r0.getInt(r5)     // Catch:{ Exception -> 0x00e1 }
            goto L_0x00e2
        L_0x00e1:
            r5 = r1
        L_0x00e2:
            if (r5 > r8) goto L_0x00e6
            if (r5 >= r9) goto L_0x00e7
        L_0x00e6:
            r5 = r1
        L_0x00e7:
            r15.c((int) r5)     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r0.has(r14)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r10 = "http"
            if (r6 == 0) goto L_0x0103
            java.lang.String r6 = r0.getString(r14)     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r6.startsWith(r10)     // Catch:{ Exception -> 0x02bd }
            if (r6 == 0) goto L_0x0103
            java.lang.String r6 = r0.getString(r14)     // Catch:{ Exception -> 0x02bd }
            r15.m(r6)     // Catch:{ Exception -> 0x02bd }
        L_0x0103:
            boolean r6 = r0.has(r13)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r14 = ""
            if (r6 == 0) goto L_0x0151
            java.lang.String r6 = r0.getString(r13)     // Catch:{ Exception -> 0x02bd }
            boolean r6 = r14.equals(r6)     // Catch:{ Exception -> 0x02bd }
            if (r6 != 0) goto L_0x0151
            java.lang.String r6 = r0.getString(r13)     // Catch:{ Exception -> 0x02bd }
            int r13 = r6.lastIndexOf(r2)     // Catch:{ Exception -> 0x02bd }
            r7 = -1
            if (r13 != r7) goto L_0x012b
            java.lang.String r13 = ".jpeg"
            int r13 = r6.lastIndexOf(r13)     // Catch:{ Exception -> 0x02bd }
            if (r13 == r7) goto L_0x0129
            goto L_0x012b
        L_0x0129:
            r6 = r14
            goto L_0x014e
        L_0x012b:
            int r2 = r6.indexOf(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 != r7) goto L_0x0137
            java.lang.String r2 = ".jpeg"
            int r2 = r6.indexOf(r2)     // Catch:{ Exception -> 0x02bd }
        L_0x0137:
            if (r2 == r7) goto L_0x014e
            java.lang.String r6 = r6.substring(r1, r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = "^\\d+$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x02bd }
            java.util.regex.Matcher r2 = r2.matcher(r6)     // Catch:{ Exception -> 0x02bd }
            boolean r2 = r2.matches()     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x014e
            goto L_0x0129
        L_0x014e:
            r15.l(r6)     // Catch:{ Exception -> 0x02bd }
        L_0x0151:
            boolean r2 = r0.has(r4)     // Catch:{ Exception -> 0x0168 }
            if (r2 == 0) goto L_0x016b
            int r2 = r0.getInt(r4)     // Catch:{ Exception -> 0x0168 }
            r4 = -3
            if (r2 <= r4) goto L_0x0164
            if (r2 >= r8) goto L_0x0164
            r15.b((int) r2)     // Catch:{ Exception -> 0x0168 }
            goto L_0x016b
        L_0x0164:
            r15.b((int) r1)     // Catch:{ Exception -> 0x0168 }
            goto L_0x016b
        L_0x0168:
            r15.b((int) r1)     // Catch:{ Exception -> 0x02bd }
        L_0x016b:
            if (r5 != r9) goto L_0x0185
            boolean r2 = r0.has(r12)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0185
            java.lang.String r2 = r0.getString(r12)     // Catch:{ Exception -> 0x02bd }
            boolean r2 = r2.startsWith(r10)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0185
            java.lang.String r2 = r0.getString(r12)     // Catch:{ Exception -> 0x02bd }
            r15.i(r2)     // Catch:{ Exception -> 0x02bd }
            goto L_0x01bd
        L_0x0185:
            r2 = 2
            if (r5 != r2) goto L_0x01a0
            boolean r2 = r0.has(r11)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x01a0
            java.lang.String r2 = r0.getString(r11)     // Catch:{ Exception -> 0x02bd }
            boolean r2 = r2.equals(r14)     // Catch:{ Exception -> 0x02bd }
            if (r2 != 0) goto L_0x01a0
            java.lang.String r2 = r0.getString(r11)     // Catch:{ Exception -> 0x02bd }
            r15.g((java.lang.String) r2)     // Catch:{ Exception -> 0x02bd }
            goto L_0x01bd
        L_0x01a0:
            if (r5 != r8) goto L_0x01bd
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            r0.<init>()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = "big style = 3 doesn't support"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02bd }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02bd }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02bd }
            return r16
        L_0x01bd:
            boolean r2 = r0.has(r3)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x01ca
            boolean r2 = r0.getBoolean(r3)     // Catch:{ Exception -> 0x02bd }
            r15.b((boolean) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x01ca:
            r2 = r19
            boolean r3 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r3 == 0) goto L_0x01da
            boolean r2 = r0.getBoolean(r2)     // Catch:{ Exception -> 0x02bd }
            r2 = r2 ^ r9
            r15.g((boolean) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x01da:
            java.lang.String r2 = "is_novibrate"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x01ec
            java.lang.String r2 = "is_novibrate"
            boolean r2 = r0.getBoolean(r2)     // Catch:{ Exception -> 0x02bd }
            r2 = r2 ^ r9
            r15.e((boolean) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x01ec:
            java.lang.String r2 = "is_noring"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x01fe
            java.lang.String r2 = "is_noring"
            boolean r2 = r0.getBoolean(r2)     // Catch:{ Exception -> 0x02bd }
            r2 = r2 ^ r9
            r15.f((boolean) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x01fe:
            java.lang.String r2 = "color"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x020f
            java.lang.String r2 = "color"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02bd }
            r15.o(r2)     // Catch:{ Exception -> 0x02bd }
        L_0x020f:
            java.lang.String r2 = "channel"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0220
            java.lang.String r2 = "channel"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02bd }
            r15.d((java.lang.String) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x0220:
            java.lang.String r2 = "channelName"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0231
            java.lang.String r2 = "channelName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02bd }
            r15.e((java.lang.String) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x0231:
            java.lang.String r2 = "channelLevel"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0242
            java.lang.String r2 = "channelLevel"
            int r2 = r0.getInt(r2)     // Catch:{ Exception -> 0x02bd }
            r15.a((int) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x0242:
            java.lang.String r2 = "badgeAddNum"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0253
            java.lang.String r2 = "badgeAddNum"
            int r2 = r0.optInt(r2)     // Catch:{ Exception -> 0x02bd }
            r15.h((int) r2)     // Catch:{ Exception -> 0x02bd }
        L_0x0253:
            java.lang.String r2 = "ringName"
            boolean r2 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r2 == 0) goto L_0x0264
            java.lang.String r2 = "ringName"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ Exception -> 0x02bd }
            r15.p(r2)     // Catch:{ Exception -> 0x02bd }
        L_0x0264:
            int r2 = r15.g()     // Catch:{ Exception -> 0x02bd }
            r3 = 4
            if (r2 > r3) goto L_0x0271
            int r2 = r15.g()     // Catch:{ Exception -> 0x02bd }
            if (r2 >= 0) goto L_0x0274
        L_0x0271:
            r15.a((int) r8)     // Catch:{ Exception -> 0x02bd }
        L_0x0274:
            r2 = r18
            boolean r3 = r0.has(r2)     // Catch:{ Exception -> 0x02bd }
            if (r3 == 0) goto L_0x02bc
            java.lang.String r3 = r0.optString(r2)     // Catch:{ NumberFormatException -> 0x028b }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x028b }
            r15.g((int) r3)     // Catch:{ NumberFormatException -> 0x028b }
            r15.a((boolean) r9)     // Catch:{ NumberFormatException -> 0x028b }
            goto L_0x02bc
        L_0x028b:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            r4 = r17
            r3.<init>(r4)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.optString(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r2 = "_"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02bd }
            r2.<init>()     // Catch:{ Exception -> 0x02bd }
            java.lang.String r3 = a     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ Exception -> 0x02bd }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ Exception -> 0x02bd }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x02bd }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x02bd }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x02bd }
        L_0x02bc:
            return r15
        L_0x02bd:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public void a(String str, String str2, String str3, BaseAction baseAction, int i) {
        String str4;
        String str5 = str;
        int i2 = i;
        String str6 = "width=" + e.c + "&height=" + e.b;
        if (!str.contains(str6)) {
            str4 = (str.indexOf("?") > 0 ? new StringBuilder().append(str).append(ContainerUtils.FIELD_DELIMITER) : new StringBuilder().append(str).append("?")).append(str6).toString();
        } else {
            str4 = str5;
        }
        String str7 = str2;
        com.igexin.push.extension.distribution.basic.f.c cVar = new com.igexin.push.extension.distribution.basic.f.c(str4, str, str7, baseAction, i, new b(this, baseAction, str7, str3, str, i));
        if (i2 == 2) {
            com.igexin.push.extension.distribution.basic.b.a aVar = (com.igexin.push.extension.distribution.basic.b.a) baseAction;
            aVar.e(aVar.w() + 1);
        } else if (i2 == 8) {
            com.igexin.push.extension.distribution.basic.b.a aVar2 = (com.igexin.push.extension.distribution.basic.b.a) baseAction;
            aVar2.d(aVar2.o() + 1);
        }
        com.igexin.a.a.b.c.b().a(new com.igexin.push.extension.distribution.basic.f.a(cVar), false, true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0206  */
    /* JADX WARNING: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r17, java.lang.String r18, java.lang.String r19, com.igexin.push.extension.distribution.basic.b.a r20, int r21) {
        /*
            r16 = this;
            r7 = r16
            r8 = r18
            r9 = r20
            java.util.Map<java.lang.String, java.lang.Integer> r0 = com.igexin.push.core.d.ad
            java.lang.Integer r1 = java.lang.Integer.valueOf(r21)
            r0.put(r8, r1)
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r0 = com.igexin.push.core.d.ac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.StringBuilder r1 = r1.append(r8)
            java.lang.String r2 = ":"
            java.lang.StringBuilder r1 = r1.append(r2)
            r10 = r19
            java.lang.StringBuilder r1 = r1.append(r10)
            java.lang.String r1 = r1.toString()
            java.lang.Object r0 = r0.get(r1)
            com.igexin.push.core.bean.PushTaskBean r0 = (com.igexin.push.core.bean.PushTaskBean) r0
            java.lang.String r11 = ""
            if (r0 == 0) goto L_0x0078
            byte[] r1 = r0.getMsgExtra()
            if (r1 == 0) goto L_0x0042
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r9.c((java.lang.String) r2)
        L_0x0042:
            java.util.List r0 = r0.getActionChains()
            java.util.Iterator r0 = r0.iterator()
        L_0x004a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0078
            java.lang.Object r1 = r0.next()
            com.igexin.push.core.bean.BaseAction r1 = (com.igexin.push.core.bean.BaseAction) r1
            boolean r2 = r1 instanceof com.igexin.push.core.bean.k
            if (r2 == 0) goto L_0x0067
            r2 = r1
            com.igexin.push.core.bean.k r2 = (com.igexin.push.core.bean.k) r2
            java.lang.String r2 = r2.a()
            if (r2 != 0) goto L_0x0064
            r2 = r11
        L_0x0064:
            r9.a((java.lang.String) r2)
        L_0x0067:
            boolean r2 = r1 instanceof com.igexin.push.extension.distribution.basic.b.d
            if (r2 == 0) goto L_0x004a
            com.igexin.push.extension.distribution.basic.b.d r1 = (com.igexin.push.extension.distribution.basic.b.d) r1
            java.lang.String r1 = r1.a()
            if (r1 != 0) goto L_0x0074
            r1 = r11
        L_0x0074:
            r9.b((java.lang.String) r1)
            goto L_0x004a
        L_0x0078:
            r5 = 0
            r0 = r16
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r20
            android.app.PendingIntent r12 = r0.a((java.lang.String) r1, (java.lang.String) r2, (int) r3, (com.igexin.push.extension.distribution.basic.b.a) r4, (boolean) r5)
            r6 = 0
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r21
            r5 = r20
            android.app.PendingIntent r0 = r0.a(r1, r2, r3, r4, r5, r6)
            android.content.Context r1 = com.igexin.push.core.d.e
            java.lang.String r2 = "notification"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.app.NotificationManager r1 = (android.app.NotificationManager) r1
            java.lang.String r2 = r20.u()
            java.lang.String r3 = r20.q()
            java.lang.String r4 = r20.r()
            r5 = 1
            if (r2 == 0) goto L_0x00dd
            boolean r11 = r11.equals(r2)
            if (r11 != 0) goto L_0x00dd
            android.graphics.Bitmap r2 = r7.c(r2)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r13 = a
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r13 = "|use net logo bitmap is null = "
            java.lang.StringBuilder r11 = r11.append(r13)
            if (r2 != 0) goto L_0x00ce
            r13 = r5
            goto L_0x00cf
        L_0x00ce:
            r13 = r6
        L_0x00cf:
            java.lang.StringBuilder r11 = r11.append(r13)
            java.lang.String r11 = r11.toString()
            java.lang.Object[] r13 = new java.lang.Object[r6]
            com.igexin.a.a.c.b.a((java.lang.String) r11, (java.lang.Object[]) r13)
            goto L_0x00de
        L_0x00dd:
            r2 = 0
        L_0x00de:
            if (r2 != 0) goto L_0x00ee
            int r2 = r7.a((com.igexin.push.extension.distribution.basic.b.a) r9, (boolean) r6)
            android.content.Context r11 = com.igexin.push.extension.distribution.basic.c.e.a
            android.content.res.Resources r11 = r11.getResources()
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeResource(r11, r2)
        L_0x00ee:
            android.app.Notification r11 = new android.app.Notification
            r11.<init>()
            android.app.Notification$Builder r11 = new android.app.Notification$Builder
            android.content.Context r13 = com.igexin.push.core.d.e
            r11.<init>(r13)
            int r13 = android.os.Build.VERSION.SDK_INT
            r14 = 26
            if (r13 < r14) goto L_0x0104
            android.app.Notification$Builder r11 = r7.a((com.igexin.push.extension.distribution.basic.b.a) r9)
        L_0x0104:
            int r13 = r7.a((com.igexin.push.extension.distribution.basic.b.a) r9, (boolean) r5)
            if (r13 == 0) goto L_0x013b
            android.content.Context r14 = com.igexin.push.core.d.e
            android.content.res.Resources r14 = r14.getResources()
            android.graphics.drawable.Drawable r14 = r14.getDrawable(r13)
            if (r14 != 0) goto L_0x013b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = a
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "|showNotification smallIconId: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r13)
            java.lang.String r1 = " couldn't find resource"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Object[] r1 = new java.lang.Object[r6]
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
            return
        L_0x013b:
            boolean r14 = android.text.TextUtils.isEmpty(r3)
            if (r14 != 0) goto L_0x0144
            r11.setContentTitle(r3)
        L_0x0144:
            boolean r14 = android.text.TextUtils.isEmpty(r4)
            if (r14 != 0) goto L_0x014d
            r11.setContentText(r4)
        L_0x014d:
            android.app.Notification$Builder r13 = r11.setSmallIcon(r13)
            java.lang.String r14 = r20.r()
            android.app.Notification$Builder r13 = r13.setTicker(r14)
            long r14 = java.lang.System.currentTimeMillis()
            android.app.Notification$Builder r13 = r13.setWhen(r14)
            android.app.Notification$Builder r2 = r13.setLargeIcon(r2)
            android.app.Notification$Builder r2 = r2.setContentIntent(r12)
            r2.setDeleteIntent(r0)
            r11.setShowWhen(r5)
            java.lang.String r0 = r20.y()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0184
            java.lang.String r0 = r20.y()     // Catch:{ all -> 0x0184 }
            int r0 = android.graphics.Color.parseColor(r0)     // Catch:{ all -> 0x0184 }
            r11.setColor(r0)     // Catch:{ all -> 0x0184 }
        L_0x0184:
            int r0 = r20.l()
            com.igexin.push.extension.distribution.basic.a.c r2 = com.igexin.push.extension.distribution.basic.a.c.BIG_IMAGE
            int r2 = r2.a()
            if (r0 != r2) goto L_0x01b1
            java.lang.String r0 = r20.m()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01da
            android.graphics.Bitmap r0 = r7.c(r0)
            if (r0 == 0) goto L_0x01da
            int r2 = r20.h()
            r11.setPriority(r2)
            android.app.Notification$BigPictureStyle r2 = new android.app.Notification$BigPictureStyle
            r2.<init>()
            android.app.Notification$BigPictureStyle r0 = r2.bigPicture(r0)
            goto L_0x01d7
        L_0x01b1:
            int r0 = r20.l()
            com.igexin.push.extension.distribution.basic.a.c r2 = com.igexin.push.extension.distribution.basic.a.c.LONG_TEXT
            int r2 = r2.a()
            if (r0 != r2) goto L_0x01da
            java.lang.String r0 = r20.k()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x01da
            int r2 = r20.h()
            r11.setPriority(r2)
            android.app.Notification$BigTextStyle r2 = new android.app.Notification$BigTextStyle
            r2.<init>()
            android.app.Notification$BigTextStyle r0 = r2.bigText(r0)
        L_0x01d7:
            r11.setStyle(r0)
        L_0x01da:
            boolean r0 = r20.j()
            if (r0 == 0) goto L_0x01f0
            boolean r0 = r20.A()
            if (r0 != 0) goto L_0x01ec
            boolean r0 = r20.B()
            if (r0 == 0) goto L_0x01f0
        L_0x01ec:
            r0 = 2
            r11.setPriority(r0)
        L_0x01f0:
            android.app.Notification r0 = r11.getNotification()
            r7.a((android.app.Notification) r0, (com.igexin.push.extension.distribution.basic.b.a) r9)
            r2 = r21
            com.igexin.push.extension.distribution.basic.g.f.a(r1, r2, r0, r6, r9)
            java.lang.String r0 = "4.4.3.13"
            java.lang.String r1 = "2.12.0.0"
            int r0 = com.igexin.push.extension.distribution.basic.g.c.a(r0, r1)
            if (r0 < 0) goto L_0x0211
            r0 = r16
            r1 = r18
            r2 = r19
            r5 = r20
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (com.igexin.push.extension.distribution.basic.b.a) r5)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.a.a(java.lang.String, java.lang.String, java.lang.String, com.igexin.push.extension.distribution.basic.b.a, int):void");
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        int i;
        if (pushTaskBean != null && (baseAction instanceof com.igexin.push.extension.distribution.basic.b.a)) {
            com.igexin.push.extension.distribution.basic.b.a aVar = (com.igexin.push.extension.distribution.basic.b.a) baseAction;
            int a2 = !aVar.d() ? a(pushTaskBean.getTaskId()) : aVar.z();
            try {
                i = Integer.parseInt(aVar.getActionId().substring(aVar.getActionId().length() - 1)) + 30000;
            } catch (Exception unused) {
                i = 0;
            }
            a(pushTaskBean.getAppKey(), pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), aVar, a2);
            if (i != 0) {
                com.igexin.push.core.a.e.a().a(pushTaskBean, i + "", "notifyStyle:" + aVar.x());
            }
            pushTaskBean.setPerActionid(Integer.parseInt(aVar.getActionId()));
            pushTaskBean.setCurrentActionid(Integer.parseInt(aVar.getDoActionId()));
        }
        return true;
    }
}
