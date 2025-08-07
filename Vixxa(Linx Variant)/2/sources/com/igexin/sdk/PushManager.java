package com.igexin.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.igexin.a.a.c.a.c;
import com.igexin.a.a.c.b;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.core.g;
import com.igexin.push.core.x;
import com.igexin.push.util.a;
import com.igexin.push.util.d;
import com.igexin.sdk.message.BindAliasCmdMessage;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.SetTagCmdMessage;
import com.igexin.sdk.message.UnBindAliasCmdMessage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PushManager {
    private static final ExecutorService a = Executors.newSingleThreadExecutor();
    private long b;
    private long c;
    private long d;
    private byte[] e;
    private Class f;
    private String g;
    private String h;
    /* access modifiers changed from: private */
    public g i;
    private final String j;

    private PushManager() {
        this.j = "[PushManager]";
    }

    /* synthetic */ PushManager(d dVar) {
        this();
    }

    private int a(int i2, String str) {
        return (TextUtils.isEmpty(str) || !str.contains("_")) ? i2 : (i2 == 60001 || i2 == 60002) ? str.startsWith(AssistPushConsts.HW_PREFIX) ? i2 + 18 : str.startsWith(AssistPushConsts.XM_PREFIX) ? i2 + 48 : str.startsWith(AssistPushConsts.OPPO_PREFIX) ? i2 + 28 : str.startsWith(AssistPushConsts.VIVO_PREFIX) ? i2 + 38 : str.startsWith(AssistPushConsts.MZ_PREFIX) ? i2 + 58 : str.startsWith(AssistPushConsts.ST_PREFIX) ? i2 + 78 : str.startsWith(AssistPushConsts.FCM_PREFIX) ? i2 + 98 : i2 : i2;
    }

    private Class a(Context context) {
        Class cls = this.f;
        return cls != null ? cls : x.a().b(context);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "MD5"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch:{ Exception -> 0x003a }
            byte[] r6 = r6.getBytes()     // Catch:{ Exception -> 0x003a }
            r0.update(r6)     // Catch:{ Exception -> 0x003a }
            byte[] r6 = r0.digest()     // Catch:{ Exception -> 0x003a }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = ""
            r0.<init>(r1)     // Catch:{ Exception -> 0x003a }
            int r1 = r6.length     // Catch:{ Exception -> 0x003a }
            r2 = 0
        L_0x001a:
            if (r2 >= r1) goto L_0x0035
            byte r3 = r6[r2]     // Catch:{ Exception -> 0x003a }
            if (r3 >= 0) goto L_0x0022
            int r3 = r3 + 256
        L_0x0022:
            r4 = 16
            if (r3 >= r4) goto L_0x002b
            java.lang.String r4 = "0"
            r0.append(r4)     // Catch:{ Exception -> 0x003a }
        L_0x002b:
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ Exception -> 0x003a }
            r0.append(r3)     // Catch:{ Exception -> 0x003a }
            int r2 = r2 + 1
            goto L_0x001a
        L_0x0035:
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x003a }
            return r6
        L_0x003a:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.a(java.lang.String):java.lang.String");
    }

    private void a(Context context, GTCmdMessage gTCmdMessage) {
        try {
            Class c2 = x.a().c(context);
            if (c2 != null) {
                Intent intent = new Intent(context, c2);
                Bundle bundle = new Bundle();
                bundle.putInt(PushConsts.CMD_ACTION, 10010);
                bundle.putSerializable(PushConsts.KEY_CMD_MSG, gTCmdMessage);
                intent.putExtras(bundle);
                context.startService(intent);
            }
        } catch (Throwable th) {
            b.a("PushManager|" + th.toString(), new Object[0]);
        }
    }

    private void a(Context context, String str, String str2) {
        a(context, (GTCmdMessage) new BindAliasCmdMessage(str, str2, 10010));
    }

    private boolean a(Context context, Intent intent) {
        return x.a().a(context, intent);
    }

    private void b(Context context) {
        if (this.i == null) {
            a.execute(new d(this, context));
        }
    }

    private void b(Context context, String str, String str2) {
        a(context, (GTCmdMessage) new UnBindAliasCmdMessage(str, str2, 10011));
    }

    private void c(Context context) {
        if (this.i != null) {
            a.execute(new e(this, context));
        }
    }

    private void c(Context context, String str, String str2) {
        a(context, (GTCmdMessage) new SetTagCmdMessage(str, str2, PushConsts.SET_TAG_RESULT));
    }

    /* access modifiers changed from: private */
    public Application d(Context context) {
        if (context == null || !e(context)) {
            return null;
        }
        return context instanceof Application ? (Application) context : (Application) context.getApplicationContext();
    }

    private boolean e(Context context) {
        return true;
    }

    private static void f(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("NULL context");
        }
    }

    public static PushManager getInstance() {
        return f.a;
    }

    private <T extends Activity> void registerPushActivity(Context context, Class<T> cls) {
        String str;
        if (cls != null) {
            try {
                Class.forName(cls.getName());
                if (a.a(context, (Class) cls)) {
                    str = cls.getName();
                } else {
                    return;
                }
            } catch (Exception e2) {
                c.a().a("[PushManager]can't load activity = " + e2.toString());
                b.a("PushManager|registerPushActiviy|" + e2.toString(), new Object[0]);
                return;
            } catch (Throwable th) {
                b.a("PushManager|registerPushActiviy|" + th.toString(), new Object[0]);
                return;
            }
        } else {
            Log.d("PushManager", "call -> registerPushActiviy, parameter [activity] is null");
            str = "";
        }
        this.h = str;
        if (this.f != null) {
            Intent intent = new Intent(context.getApplicationContext(), this.f);
            intent.putExtra("ua", this.h);
            a(context, intent);
        }
    }

    public boolean bindAlias(Context context, String str) {
        return bindAlias(context, str, "bindAlias_" + System.currentTimeMillis());
    }

    public boolean bindAlias(Context context, String str, String str2) {
        c.a().a("[PushManager]call bindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d < 1000) {
            c.a().a("[PushManager]call - > bindAlias failed, it be called too frequently");
            a(context, str2, "30001");
            return false;
        }
        this.d = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "bindAlias");
        bundle.putString("alias", str);
        bundle.putString("sn", str2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public void checkManifest(Context context) throws GetuiPushException {
        a.b(context);
    }

    public String getClientid(Context context) {
        byte[] a2;
        String a3;
        String str = "";
        if (this.e == null) {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
                String a4 = com.igexin.push.util.b.a(applicationInfo);
                if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                    if (TextUtils.isEmpty(a4)) {
                        a4 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
                    }
                    String string = TextUtils.isEmpty(str) ? applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY) : str;
                    if (TextUtils.isEmpty(str)) {
                        str = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET);
                    }
                    if (TextUtils.isEmpty(a4)) {
                        a4 = com.igexin.push.core.b.a.a(context);
                    }
                    if (TextUtils.isEmpty(string)) {
                        string = com.igexin.push.core.b.a.b(context);
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = com.igexin.push.core.b.a.c(context);
                    }
                    String trim = a4.trim();
                    String trim2 = str.trim();
                    String trim3 = string.trim();
                    if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(trim3) && (a3 = a(trim + trim2 + trim3 + context.getPackageName())) != null) {
                        this.e = a3.getBytes();
                    }
                }
            } catch (Exception e2) {
                b.a("PushManager|" + e2.toString(), new Object[0]);
            }
        }
        if (this.e == null || (a2 = d.a(context.getFilesDir().getPath() + "/init.pid")) == null || this.e.length != a2.length) {
            return null;
        }
        int length = a2.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (this.e[i2] ^ a2[i2]);
        }
        return new String(bArr);
    }

    public String getVersion(Context context) {
        return "4.4.3.13";
    }

    public void initialize(Context context) {
        try {
            f(context);
            if (TextUtils.isEmpty(this.g)) {
                Class cls = (Class) com.igexin.push.util.b.a(context, GTIntentService.class).second;
                if (cls != null) {
                    this.g = cls.getName();
                    c.a().a("[PushManager] initialize intentService = " + this.g);
                } else {
                    c.a().a("[PushManager] initialize intentService = NULL!");
                }
            }
            if (this.f == null) {
                Class cls2 = (Class) com.igexin.push.util.b.a(context, PushService.class).second;
                this.f = cls2;
                if (cls2 == null) {
                    c.a().a("[PushManager] initialize uService = NULL!");
                } else {
                    c.a().a("[PushManager] initialize uService = " + this.f.getName());
                }
            }
            initialize(context, this.f);
        } catch (Exception e2) {
            b.a("PushManager|initialize|" + e2.toString(), new Object[0]);
            c.a().a("[PushManager] initialize sdk error = " + e2.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0039, code lost:
        if (r3 != false) goto L_0x003b;
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T extends android.app.Service> void initialize(android.content.Context r7, java.lang.Class<T> r8) {
        /*
            r6 = this;
            java.lang.String r0 = "[PushManager]start pushService = "
            r1 = 0
            com.igexin.a.a.c.a.c r2 = com.igexin.a.a.c.a.c.a()     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "[PushManager]Start initializing sdk"
            r2.a((java.lang.String) r3)     // Catch:{ all -> 0x0091 }
            android.content.Context r2 = r7.getApplicationContext()     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = r2.getPackageName()     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "PushManager"
            boolean r3 = com.igexin.push.util.a.a((java.lang.String) r3, (android.content.Context) r7, r8)     // Catch:{ all -> 0x0091 }
            if (r3 != 0) goto L_0x002d
            java.lang.String r7 = "PushManager|init checkServiceSetCorrectly false"
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ all -> 0x0091 }
            com.igexin.a.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x0091 }
            com.igexin.a.a.c.a.c r7 = com.igexin.a.a.c.a.c.a()     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = "[PushManager]initialize failed,please check your push service!!"
            r7.a((java.lang.String) r8)     // Catch:{ all -> 0x0091 }
            return
        L_0x002d:
            if (r8 == 0) goto L_0x003b
            java.lang.String r3 = com.igexin.push.core.CoreConsts.p     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = r8.getName()     // Catch:{ all -> 0x0091 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0091 }
            if (r3 == 0) goto L_0x003d
        L_0x003b:
            java.lang.Class<com.igexin.sdk.PushService> r8 = com.igexin.sdk.PushService.class
        L_0x003d:
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x0091 }
            android.content.Context r4 = r7.getApplicationContext()     // Catch:{ all -> 0x0091 }
            r3.<init>(r4, r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "action"
            java.lang.String r5 = com.igexin.sdk.PushConsts.ACTION_SERVICE_INITIALIZE     // Catch:{ all -> 0x0091 }
            r3.putExtra(r4, r5)     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "op_app"
            r3.putExtra(r4, r2)     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = "us"
            java.lang.String r4 = r8.getName()     // Catch:{ all -> 0x0091 }
            r3.putExtra(r2, r4)     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = r6.g     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x0064
            java.lang.String r4 = "uis"
            r3.putExtra(r4, r2)     // Catch:{ all -> 0x0091 }
        L_0x0064:
            java.lang.String r2 = r6.h     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x006d
            java.lang.String r4 = "ua"
            r3.putExtra(r4, r2)     // Catch:{ all -> 0x0091 }
        L_0x006d:
            boolean r2 = r6.a((android.content.Context) r7, (android.content.Intent) r3)     // Catch:{ all -> 0x0091 }
            if (r2 == 0) goto L_0x008d
            r6.f = r8     // Catch:{ all -> 0x0091 }
            com.igexin.a.a.c.a.c r2 = com.igexin.a.a.c.a.c.a()     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r3.<init>(r0)     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r8.getName()     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r8 = r3.append(r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0091 }
            r2.a((java.lang.String) r8)     // Catch:{ all -> 0x0091 }
        L_0x008d:
            r6.b(r7)     // Catch:{ all -> 0x0091 }
            goto L_0x00c4
        L_0x0091:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r0 = "PushManager|initialize|"
            r8.<init>(r0)
            java.lang.String r0 = r7.toString()
            java.lang.StringBuilder r8 = r8.append(r0)
            java.lang.String r8 = r8.toString()
            java.lang.Object[] r0 = new java.lang.Object[r1]
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r0)
            com.igexin.a.a.c.a.c r8 = com.igexin.a.a.c.a.c.a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "[PushManager]initialize sdk error = "
            r0.<init>(r1)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r7 = r0.append(r7)
            java.lang.String r7 = r7.toString()
            r8.a((java.lang.String) r7)
        L_0x00c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.sdk.PushManager.initialize(android.content.Context, java.lang.Class):void");
    }

    public boolean isPushTurnedOn(Context context) {
        return new com.igexin.sdk.a.d(context).c();
    }

    @Deprecated
    public <T extends GTIntentService> void registerPushIntentService(Context context, Class<T> cls) {
        String str;
        c.a().a("[PushManager]call registerPushIntentService");
        if (cls != null) {
            try {
                Class.forName(cls.getName());
                if (!a.a(new Intent(context, cls), context)) {
                    c.a().a("[PushManager]call - > registerPushIntentService, parameter [userIntentService] is set, but didn't find class \"" + cls.getName() + "\", please check your AndroidManifest");
                    return;
                }
                str = cls.getName();
            } catch (Exception e2) {
                c.a().a("[PushManager]error, can't load IntentService = " + e2.toString());
                b.a("PushManager|registerPushIntentService|" + e2.toString(), new Object[0]);
                return;
            } catch (Throwable th) {
                b.a("PushManager|registerPushIntentService|" + th.toString(), new Object[0]);
                c.a().a("[PushManager]registerPushIntentService failed = " + th.toString());
                return;
            }
        } else {
            Log.d("PushManager", "call -> registerPushIntentService, parameter [userIntentService] is null, use default Receiver");
            str = "";
        }
        this.g = str;
        if (this.f != null) {
            Intent intent = new Intent(context.getApplicationContext(), this.f);
            intent.putExtra("uis", this.g);
            a(context, intent);
        }
    }

    public boolean sendApplinkFeedback(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            c.a().a("[PushManager]call - > sendApplinkFeedback failed, parameter is illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "sendApplinkFeedback");
        bundle.putString("url", str);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean sendFeedbackMessage(Context context, String str, String str2, int i2) {
        boolean z = (i2 >= 60001 && i2 <= 60999) || (i2 >= 90001 && i2 <= 90999);
        if (str == null || str2 == null || !z) {
            c.a().a("[PushManager]call - > sendFeedbackMessage failed, parameter is illegal");
            return false;
        }
        int a2 = a(i2, str2);
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "sendFeedbackMessage");
        bundle.putString("taskid", str);
        bundle.putString("messageid", str2);
        bundle.putString("actionid", String.valueOf(a2));
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean sendMessage(Context context, String str, byte[] bArr) {
        long currentTimeMillis = System.currentTimeMillis();
        if (str == null || bArr == null || ((long) bArr.length) > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM || currentTimeMillis - this.c < 1000) {
            c.a().a("[PushManager]call - > sendMessage failed, parameter is illegal or it be called too frequently");
            return false;
        }
        this.c = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "sendMessage");
        bundle.putString("taskid", str);
        bundle.putByteArray("extraData", bArr);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean setBadgeNum(Context context, int i2) {
        try {
            f(context);
            c.a().a("[PushManager] call - > setBadgeNum");
            Bundle bundle = new Bundle();
            bundle.putString(PushConsts.CMD_ACTION, "setBadgeNum");
            bundle.putInt("badgeNum", i2);
            Intent intent = new Intent(context.getApplicationContext(), a(context));
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return a(context, intent);
        } catch (Throwable th) {
            b.c("PushManager", th.getMessage());
            c.a().a("[PushManager] setBadgeNum  error = " + th.toString());
            return false;
        }
    }

    public void setDebugLogger(Context context, IUserLoggerInterface iUserLoggerInterface) {
        if (context == null || iUserLoggerInterface == null) {
            throw new IllegalArgumentException("context or loggerInterface can not be null");
        } else if (!a.c(context)) {
            iUserLoggerInterface.log("only run in debug mode");
        } else {
            try {
                if (e(context)) {
                    c.a().a(context, iUserLoggerInterface);
                } else {
                    iUserLoggerInterface.log("setDebugLogger, must be called in main process!");
                }
            } catch (Throwable unused) {
            }
        }
    }

    public boolean setDeviceToken(Context context, String str) {
        try {
            Context applicationContext = context.getApplicationContext();
            if (TextUtils.isEmpty(str)) {
                c.a().a("[PushManager] setDeviceToken error = token is empty");
                return false;
            } else if (str.equalsIgnoreCase("InvalidAppKey")) {
                c.a().a("[PushManager] setDeviceToken error = token is InvalidAppKey");
                return false;
            } else {
                f(applicationContext);
                Bundle bundle = new Bundle();
                bundle.putString(PushConsts.CMD_ACTION, "setDeviceToken");
                bundle.putString(AssistPushConsts.MSG_TYPE_TOKEN, str);
                Intent intent = new Intent(applicationContext.getApplicationContext(), a(applicationContext));
                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                return a(applicationContext, intent);
            }
        } catch (Throwable th) {
            b.c("PushManager", th.toString());
            c.a().a("[PushManager] setDeviceToken  error = " + th.toString());
            return false;
        }
    }

    public boolean setHeartbeatInterval(Context context, int i2) {
        if (i2 < 0) {
            c.a().a("[PushManager]call -> setHeartbeatInterval failed, parameter [interval] < 0, illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "setHeartbeatInterval");
        bundle.putInt("interval", i2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    @Deprecated
    public boolean setHwBadgeNum(Context context, int i2) {
        c.a().a("[PushManager]call - > setHwBadgeNum");
        try {
            Bundle bundle = new Bundle();
            bundle.putString(PushConsts.CMD_ACTION, "setHwBadgeNum");
            bundle.putInt("badgeNum", i2);
            Intent intent = new Intent(context.getApplicationContext(), a(context));
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return a(context, intent);
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean setNotificationIcon(Context context, String str, String str2) {
        try {
            f(context);
            Bundle bundle = new Bundle();
            bundle.putString(PushConsts.CMD_ACTION, "setNotificationIcon");
            bundle.putString("smallIcon", str);
            bundle.putString("largeIcon", str2);
            Intent intent = new Intent(context.getApplicationContext(), a(context));
            intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
            intent.putExtra("bundle", bundle);
            return a(context, intent);
        } catch (Throwable th) {
            c.a().a("[PushManager] setNotificationIcon  error = " + th.toString());
            return false;
        }
    }

    public boolean setSilentTime(Context context, int i2, int i3) {
        if (i2 < 0 || i2 >= 24 || i3 < 0 || i3 > 23) {
            c.a().a("[PushManager]call - > setSilentTime failed, parameter [beginHour] or [duration] value exceeding");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "setSilentTime");
        bundle.putInt("beginHour", i2);
        bundle.putInt(TypedValues.TransitionType.S_DURATION, i3);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public boolean setSocketTimeout(Context context, int i2) {
        if (i2 < 0) {
            c.a().a("[PushManager]call - > setSocketTimeout failed, parameter [timeout] < 0, illegal");
            return false;
        }
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "setSocketTimeout");
        bundle.putInt("timeout", i2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }

    public int setTag(Context context, Tag[] tagArr, String str) {
        if (tagArr == null) {
            c.a().a("[PushManager]call -> setTag failed, parameter [tags] is null");
            b.a("PushManager|tags is null", new Object[0]);
            c(context, str, "20006");
            return PushConsts.SETTAG_ERROR_NULL;
        } else if (str == null) {
            c.a().a("[PushManager]call -> setTag failed, parameter [sn] is null");
            b.a("PushManager|sn is null", new Object[0]);
            c(context, str, "20007");
            return PushConsts.SETTAG_SN_NULL;
        } else if (((long) tagArr.length) > 200) {
            c.a().a("[PushManager]call -> setTag failed, parameter [tags] len > 200 is exceeds");
            b.a("PushManager|tags len > 200 is exceeds", new Object[0]);
            c(context, str, PushConsts.SEND_MESSAGE_ERROR_GENERAL);
            return PushConsts.SETTAG_ERROR_COUNT;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.b < 1000) {
                c.a().a("[PushManager]call - > setTag failed, it be called too frequently");
                c(context, str, PushConsts.SEND_MESSAGE_ERROR_TIME_OUT);
                return PushConsts.SETTAG_ERROR_FREQUENCY;
            }
            StringBuilder sb = new StringBuilder();
            for (Tag tag : tagArr) {
                if (!(tag == null || tag.getName() == null)) {
                    if (tag.getName().contains(" ") || tag.getName().contains(",")) {
                        c.a().a("[PushManager]call -> setTag failed, the tag [" + tag.getName() + "] is not illegal");
                        c(context, str, "20011");
                        return PushConsts.SETTAG_TAG_ILLEGAL;
                    }
                    sb.append(tag.getName());
                    sb.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
                c.a().a("[PushManager]call setTag");
                Bundle bundle = new Bundle();
                bundle.putString(PushConsts.CMD_ACTION, "setTag");
                bundle.putString("tags", sb.toString());
                bundle.putString("sn", str);
                this.b = currentTimeMillis;
                Intent intent = new Intent(context.getApplicationContext(), a(context));
                intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
                intent.putExtra("bundle", bundle);
                a(context, intent);
                return 0;
            }
            c(context, str, "20006");
            return PushConsts.SETTAG_ERROR_NULL;
        }
    }

    public void turnOffPush(Context context) {
        c.a().a("[PushManager]call turnOffPush");
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "turnOffPush");
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        a(context, intent);
        c(context);
    }

    public void turnOnPush(Context context) {
        c.a().a("[PushManager]call turnOnPush");
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_SERVICE_INITIALIZE_SLAVE);
        intent.putExtra("op_app", context.getApplicationContext().getPackageName());
        intent.putExtra("isSlave", true);
        a(context, intent);
        b(context);
    }

    public boolean unBindAlias(Context context, String str, boolean z) {
        return unBindAlias(context, str, z, "unBindAlias_" + System.currentTimeMillis());
    }

    public boolean unBindAlias(Context context, String str, boolean z, String str2) {
        c.a().a("[PushManager]call unBindAlias");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.d < 1000) {
            c.a().a("[PushManager]call - > unBindAlias failed, it be called too frequently");
            b(context, str2, "30001");
            return false;
        }
        this.d = currentTimeMillis;
        Bundle bundle = new Bundle();
        bundle.putString(PushConsts.CMD_ACTION, "unbindAlias");
        bundle.putString("alias", str);
        bundle.putBoolean("isSeft", z);
        bundle.putString("sn", str2);
        Intent intent = new Intent(context.getApplicationContext(), a(context));
        intent.putExtra(PushConsts.CMD_ACTION, PushConsts.ACTION_BROADCAST_PUSHMANAGER);
        intent.putExtra("bundle", bundle);
        return a(context, intent);
    }
}
