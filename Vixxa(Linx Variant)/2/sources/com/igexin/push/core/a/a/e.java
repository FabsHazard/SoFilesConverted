package com.igexin.push.core.a.a;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.b;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.config.k;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.g;
import com.igexin.push.core.bean.j;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.core.x;
import com.igexin.push.util.n;
import com.igexin.sdk.GetuiActivity;
import com.igexin.sdk.PushConsts;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Random;

public class e implements a {
    private static final String a = k.a;

    private int a(g gVar, boolean z) {
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
        if (TextUtils.isEmpty(gVar.j()) || "null".equals(gVar.j())) {
            return i2 > 0 ? i2 : identifier3;
        }
        if (gVar.j().startsWith("@")) {
            String j = gVar.j();
            return j.substring(1, j.length()).endsWith(NotificationCompat.CATEGORY_EMAIL) ? 17301647 : 17301651;
        }
        if (!"push".equals(gVar.j()) || i2 <= 0) {
            i = d.e.getResources().getIdentifier(gVar.j(), "drawable", d.c);
            if (i == 0) {
                i = d.e.getResources().getIdentifier(gVar.j(), "mipmap", d.c);
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

    private Notification.Builder a(g gVar) {
        Notification.Builder builder = new Notification.Builder(d.e);
        NotificationManager notificationManager = (NotificationManager) d.e.getSystemService("notification");
        try {
            Class<?> cls = Class.forName("android.app.NotificationChannel");
            Constructor<?> constructor = cls.getConstructor(new Class[]{String.class, CharSequence.class, Integer.TYPE});
            if (constructor != null) {
                Class<?> cls2 = notificationManager.getClass();
                if (((Parcelable) cls2.getMethod("getNotificationChannel", new Class[]{String.class}).invoke(notificationManager, new Object[]{gVar.n()})) == null) {
                    Parcelable parcelable = (Parcelable) constructor.newInstance(new Object[]{gVar.n(), gVar.o(), Integer.valueOf(gVar.p())});
                    Method method = cls2.getMethod("createNotificationChannel", new Class[]{Class.forName("android.app.NotificationChannel")});
                    Method method2 = cls.getMethod("enableVibration", new Class[]{Boolean.TYPE});
                    Method method3 = cls.getMethod("setSound", new Class[]{Uri.class, AudioAttributes.class});
                    method2.invoke(parcelable, new Object[]{Boolean.valueOf(gVar.h())});
                    if (!gVar.i()) {
                        method3.invoke(parcelable, new Object[]{null, null});
                    } else if (!TextUtils.isEmpty(gVar.s())) {
                        method3.invoke(parcelable, new Object[]{b(gVar.s()), null});
                    }
                    method.invoke(notificationManager, new Object[]{parcelable});
                }
                builder.getClass().getMethod("setChannelId", new Class[]{String.class}).invoke(builder, new Object[]{gVar.n()});
            }
        } catch (Throwable unused) {
        }
        return builder;
    }

    private PendingIntent a(Intent intent) {
        return PendingIntent.getService(d.e, new Random().nextInt(1000), intent, (n.a(d.e) < 31 || Build.VERSION.SDK_INT < 30) ? 134217728 : 67108864);
    }

    private PendingIntent a(String str, String str2, String str3, int i, g gVar) {
        Intent intent = new Intent(CoreConsts.b);
        intent.putExtra("taskid", str);
        intent.putExtra("messageid", str2);
        String str4 = "";
        intent.putExtra("title", gVar.e() == null ? str4 : gVar.e());
        intent.putExtra("content", gVar.f() == null ? str4 : gVar.f());
        intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, d.a);
        intent.putExtra("actionid", str3);
        intent.putExtra("accesstoken", d.ai);
        intent.putExtra("notifID", i);
        String a2 = gVar.a();
        if (a2 == null) {
            a2 = str4;
        }
        intent.putExtra("url", a2);
        String b = gVar.b();
        if (b == null) {
            b = str4;
        }
        intent.putExtra("intentUri", b);
        String c = gVar.c();
        if (c != null) {
            str4 = c;
        }
        intent.putExtra(AssistPushConsts.MSG_TYPE_PAYLOAD, str4);
        if (n.a(d.e) < 31 || Build.VERSION.SDK_INT < 30) {
            Intent intent2 = new Intent(d.e, x.a().b(d.e));
            intent2.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
            intent2.putExtra("broadcast_intent", intent);
            return a(intent2);
        }
        Intent intent3 = new Intent(d.e, GetuiActivity.class);
        intent3.setFlags(268435456);
        intent3.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_CLICK);
        intent3.putExtra("broadcast_intent", intent);
        return PendingIntent.getActivity(d.e, new Random().nextInt(1000), intent3, 67108864);
    }

    private PendingIntent a(String str, String str2, String str3, int i, g gVar, boolean z) {
        try {
            Intent intent = new Intent(d.e, x.a().b(d.e));
            intent.putExtra("taskid", str2);
            intent.putExtra("messageid", str3);
            intent.putExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, d.a);
            intent.putExtra("appkey", str);
            intent.putExtra("actionid", gVar.getDoActionId());
            intent.putExtra("feedbackid", gVar.getActionId().substring(gVar.getActionId().length() - 1));
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_NOTIFICATION_DELETE);
            return a(intent);
        } catch (Exception e) {
            b.a(a + "|getDelPendingIntent err：" + e.toString(), new Object[0]);
            return null;
        }
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

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.success;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:62|63|64|65) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00a5, code lost:
        if (r1.lastIndexOf(".jpeg") != -1) goto L_0x00a7;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:64:0x017d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.igexin.push.core.bean.BaseAction a(org.json.JSONObject r23) {
        /*
            r22 = this;
            r0 = r23
            java.lang.String r1 = "channelLevel"
            java.lang.String r2 = "channelName"
            java.lang.String r3 = "channel"
            java.lang.String r4 = "banner_url"
            java.lang.String r5 = "logo_url"
            java.lang.String r6 = "is_chklayout"
            java.lang.String r7 = "ringName"
            java.lang.String r8 = "badgeAddNum"
            java.lang.String r9 = ".png"
            java.lang.String r10 = "is_noring"
            java.lang.String r11 = "is_novibrate"
            java.lang.String r12 = "is_noclear"
            java.lang.String r13 = "notifyid"
            java.lang.String r14 = ""
            java.lang.String r15 = "logo"
            r16 = r13
            java.lang.String r13 = " NotificationAction.parseAction() : "
            r17 = 0
            r18 = r13
            com.igexin.push.core.bean.g r13 = new com.igexin.push.core.bean.g     // Catch:{ JSONException -> 0x01b0 }
            r13.<init>()     // Catch:{ JSONException -> 0x01b0 }
            r19 = r1
            java.lang.String r1 = "notification"
            r13.setType(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r1 = "actionid"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b0 }
            r13.setActionId(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r1 = "do"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b0 }
            r13.setDoActionId(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r1 = "title"
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b0 }
            r20 = r2
            java.lang.String r2 = "text"
            java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x01b0 }
            r13.d((java.lang.String) r1)     // Catch:{ JSONException -> 0x01b0 }
            r13.e((java.lang.String) r2)     // Catch:{ JSONException -> 0x01b0 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ JSONException -> 0x01b0 }
            r21 = r3
            r3 = 0
            if (r1 == 0) goto L_0x0084
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x0084
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b0 }
            r0.<init>()     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r1 = a     // Catch:{ JSONException -> 0x01b0 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r1 = " title & content = null"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01b0 }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ JSONException -> 0x01b0 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ JSONException -> 0x01b0 }
            return r17
        L_0x0084:
            boolean r1 = r0.has(r15)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x00cd
            java.lang.String r1 = r0.getString(r15)     // Catch:{ JSONException -> 0x01b0 }
            boolean r1 = r14.equals(r1)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 != 0) goto L_0x00cd
            java.lang.String r1 = r0.getString(r15)     // Catch:{ JSONException -> 0x01b0 }
            int r2 = r1.lastIndexOf(r9)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r15 = ".jpeg"
            r3 = -1
            if (r2 != r3) goto L_0x00a7
            int r2 = r1.lastIndexOf(r15)     // Catch:{ JSONException -> 0x01b0 }
            if (r2 == r3) goto L_0x00ca
        L_0x00a7:
            int r2 = r1.indexOf(r9)     // Catch:{ JSONException -> 0x01b0 }
            if (r2 != r3) goto L_0x00b1
            int r2 = r1.indexOf(r15)     // Catch:{ JSONException -> 0x01b0 }
        L_0x00b1:
            if (r2 == r3) goto L_0x00c9
            r3 = 0
            java.lang.String r1 = r1.substring(r3, r2)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r2 = "^\\d+$"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ JSONException -> 0x01b0 }
            java.util.regex.Matcher r2 = r2.matcher(r1)     // Catch:{ JSONException -> 0x01b0 }
            boolean r2 = r2.matches()     // Catch:{ JSONException -> 0x01b0 }
            if (r2 == 0) goto L_0x00c9
            goto L_0x00ca
        L_0x00c9:
            r14 = r1
        L_0x00ca:
            r13.f(r14)     // Catch:{ JSONException -> 0x01b0 }
        L_0x00cd:
            boolean r1 = r0.has(r12)     // Catch:{ JSONException -> 0x01b0 }
            r2 = 1
            if (r1 == 0) goto L_0x00dc
            boolean r1 = r0.getBoolean(r12)     // Catch:{ JSONException -> 0x01b0 }
            r1 = r1 ^ r2
            r13.b((boolean) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x00dc:
            boolean r1 = r0.has(r11)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x00ea
            boolean r1 = r0.getBoolean(r11)     // Catch:{ JSONException -> 0x01b0 }
            r1 = r1 ^ r2
            r13.c((boolean) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x00ea:
            boolean r1 = r0.has(r10)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x00f8
            boolean r1 = r0.getBoolean(r10)     // Catch:{ JSONException -> 0x01b0 }
            r1 = r1 ^ r2
            r13.d((boolean) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x00f8:
            boolean r1 = r0.has(r8)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x0105
            int r1 = r0.optInt(r8)     // Catch:{ JSONException -> 0x01b0 }
            r13.c((int) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x0105:
            boolean r1 = r0.has(r7)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x0112
            java.lang.String r1 = r0.getString(r7)     // Catch:{ JSONException -> 0x01b0 }
            r13.k(r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x0112:
            boolean r1 = r0.has(r6)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x011f
            boolean r1 = r0.getBoolean(r6)     // Catch:{ JSONException -> 0x01b0 }
            r13.e((boolean) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x011f:
            boolean r1 = r0.has(r5)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x012c
            java.lang.String r1 = r0.getString(r5)     // Catch:{ JSONException -> 0x01b0 }
            r13.g(r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x012c:
            boolean r1 = r0.has(r4)     // Catch:{ JSONException -> 0x01b0 }
            if (r1 == 0) goto L_0x0139
            java.lang.String r1 = r0.getString(r4)     // Catch:{ JSONException -> 0x01b0 }
            r13.h(r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x0139:
            r1 = r21
            boolean r3 = r0.has(r1)     // Catch:{ JSONException -> 0x01b0 }
            if (r3 == 0) goto L_0x0148
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b0 }
            r13.i(r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x0148:
            r1 = r20
            boolean r3 = r0.has(r1)     // Catch:{ JSONException -> 0x01b0 }
            if (r3 == 0) goto L_0x0157
            java.lang.String r1 = r0.getString(r1)     // Catch:{ JSONException -> 0x01b0 }
            r13.j(r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x0157:
            r1 = r19
            boolean r3 = r0.has(r1)     // Catch:{ JSONException -> 0x01b0 }
            if (r3 == 0) goto L_0x0166
            int r1 = r0.getInt(r1)     // Catch:{ JSONException -> 0x01b0 }
            r13.a((int) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x0166:
            r1 = r16
            boolean r3 = r0.has(r1)     // Catch:{ JSONException -> 0x01b0 }
            if (r3 == 0) goto L_0x01af
            java.lang.String r3 = r0.optString(r1)     // Catch:{ NumberFormatException -> 0x017d }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x017d }
            r13.b((int) r3)     // Catch:{ NumberFormatException -> 0x017d }
            r13.a((boolean) r2)     // Catch:{ NumberFormatException -> 0x017d }
            goto L_0x01af
        L_0x017d:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b0 }
            r3 = r18
            r2.<init>(r3)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r0 = r0.optString(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r1 = "_"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01b0 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x01b0 }
            r1.<init>()     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r2 = a     // Catch:{ JSONException -> 0x01b0 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ JSONException -> 0x01b0 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x01b0 }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ JSONException -> 0x01b0 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ JSONException -> 0x01b0 }
        L_0x01af:
            return r13
        L_0x01b0:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.e.a(org.json.JSONObject):com.igexin.push.core.bean.BaseAction");
    }

    public void a(String str, String str2, String str3, g gVar) {
        String str4 = str2;
        g gVar2 = gVar;
        int a2 = !gVar.d() ? a(str4) : gVar.q();
        d.ad.put(str4, Integer.valueOf(a2));
        PushTaskBean pushTaskBean = d.ac.get(com.igexin.push.core.a.e.a().a(str4, str3));
        String str5 = "";
        if (pushTaskBean != null) {
            byte[] msgExtra = pushTaskBean.getMsgExtra();
            if (msgExtra != null) {
                gVar2.c(new String(msgExtra));
            }
            for (BaseAction next : pushTaskBean.getActionChains()) {
                if (next instanceof com.igexin.push.core.bean.k) {
                    String a3 = ((com.igexin.push.core.bean.k) next).a();
                    if (a3 == null) {
                        a3 = str5;
                    }
                    gVar2.a(a3);
                }
                if (next instanceof j) {
                    String a4 = ((j) next).a();
                    if (a4 == null) {
                        a4 = str5;
                    }
                    gVar2.b(a4);
                }
            }
        }
        int i = a2;
        g gVar3 = gVar;
        PendingIntent a5 = a(str2, str3, gVar.getDoActionId(), i, gVar3);
        PendingIntent a6 = a(str, str2, str3, i, gVar3, false);
        NotificationManager notificationManager = (NotificationManager) d.e.getSystemService("notification");
        int a7 = a(gVar2, false);
        Notification.Builder a8 = Build.VERSION.SDK_INT >= 26 ? a(gVar2) : new Notification.Builder(d.e);
        int a9 = a(gVar2, true);
        if (!TextUtils.isEmpty(gVar.e())) {
            a8.setContentTitle(gVar.e());
        }
        if (!TextUtils.isEmpty(gVar.f())) {
            a8.setContentText(gVar.f());
        }
        a8.setShowWhen(true);
        Notification notification = a8.setSmallIcon(a9).setLargeIcon(BitmapFactory.decodeResource(d.e.getResources(), a7)).setWhen(System.currentTimeMillis()).setContentIntent(a5).setDeleteIntent(a6).getNotification();
        com.igexin.push.util.a.g();
        notification.tickerText = gVar.f();
        notification.defaults = 4;
        notification.ledARGB = -16711936;
        notification.ledOnMS = 1000;
        notification.ledOffMS = 3000;
        notification.flags = 1;
        notification.flags = gVar.g() ? notification.flags | 16 : notification.flags | 32;
        if (gVar.i()) {
            if (TextUtils.isEmpty(gVar.s())) {
                notification.defaults |= 1;
            } else {
                notification.sound = b(gVar.s());
            }
        }
        if (gVar.h()) {
            notification.defaults |= 2;
        }
        if ((gVar.l() == null && gVar.k() == null) || !gVar.m()) {
            if (gVar.r() > 0) {
                com.igexin.push.util.b.a(gVar.r(), false);
                com.igexin.push.util.b.a(gVar.r(), notification);
            }
            notificationManager.notify(a2, notification);
            r a10 = r.a();
            String e = gVar.e() == null ? str5 : gVar.e();
            if (gVar.f() != null) {
                str5 = gVar.f();
            }
            a10.a(str2, str3, e, str5, gVar.a(), gVar.b(), gVar.c());
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        if (pushTaskBean == null || !(baseAction instanceof g)) {
            return true;
        }
        try {
            a(pushTaskBean.getAppKey(), pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), (g) baseAction);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }
}
