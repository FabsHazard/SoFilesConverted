package com.igexin.push.core.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import androidx.work.WorkRequest;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.b;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.push.c.i;
import com.igexin.push.core.CoreConsts;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.h;
import com.igexin.push.core.c;
import com.igexin.push.core.d;
import com.igexin.push.core.r;
import com.igexin.push.core.v;
import com.igexin.push.core.w;
import com.igexin.push.core.x;
import com.igexin.push.d.c.f;
import com.igexin.push.d.c.k;
import com.igexin.push.d.c.l;
import com.igexin.push.d.c.n;
import com.igexin.push.d.c.p;
import com.igexin.push.util.a;
import com.igexin.push.util.o;
import com.igexin.sdk.PushConsts;
import com.microtech.aidexx.utils.TimeUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends a {
    private static SparseArray<a> b;
    private static e c;
    private ExecutorService a = new ThreadPoolExecutor(0, 1, 30, TimeUnit.SECONDS, new LinkedBlockingQueue());

    private e() {
        SparseArray<a> sparseArray = new SparseArray<>();
        b = sparseArray;
        sparseArray.put(0, new k());
        b.put(5, new m());
        b.put(37, new o());
        b.put(9, new t());
        b.put(20, new s());
        b.put(26, new j());
        b.put(97, new l());
    }

    public static e a() {
        if (c == null) {
            c = new e();
        }
        return c;
    }

    public static boolean a(long j) {
        return a.a(j);
    }

    private void l() {
        c.a().i().i();
        if (w.a().b()) {
            b.a("CoreAction|network changed check condition status", new Object[0]);
            w.a().f();
        }
    }

    public Class a(Context context) {
        return x.a().b(context);
    }

    public String a(String str, String str2) {
        return str + ":" + str2;
    }

    public void a(Intent intent) {
        b.a("CoreAction|onServiceInitialize ##", new Object[0]);
        if (intent != null) {
            c.a().a(false);
            d.m = false;
            if (d.l) {
                r.a().c();
                d.m = true;
            }
            if (o.a(d.e) && d.X != null) {
                String name = x.a().b(d.e).getName();
                if (!name.equals(CoreConsts.p)) {
                    byte[] b2 = com.igexin.a.b.a.b(name.getBytes());
                    if (b2 != null) {
                        com.igexin.push.util.d.a(b2, d.X, false);
                    }
                } else if (new File(d.X).delete()) {
                    b.a("del " + d.X + " success ~~~", new Object[0]);
                }
            }
        }
    }

    public void a(Bundle bundle) {
        v.a().a(bundle);
    }

    public void a(PushTaskBean pushTaskBean, String str) {
        a(pushTaskBean, AssistPushConsts.PUSHMESSAGE_ACTION_MULTI_BRAND_RECEIVE + str, "ok");
    }

    public void a(PushTaskBean pushTaskBean, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "pushmessage_feedback");
            jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, pushTaskBean.getAppid());
            jSONObject.put("id", String.valueOf(currentTimeMillis));
            jSONObject.put("appkey", pushTaskBean.getAppKey());
            jSONObject.put("messageid", pushTaskBean.getMessageId());
            jSONObject.put("taskid", pushTaskBean.getTaskId());
            jSONObject.put("actionid", str);
            jSONObject.put(WiseOpenHianalyticsData.UNION_RESULT, str2);
            jSONObject.put("timestamp", String.valueOf(System.currentTimeMillis()));
        } catch (Exception unused) {
        }
        String jSONObject2 = jSONObject.toString();
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.b();
        bVar.a = (int) currentTimeMillis;
        bVar.d = "17258000";
        bVar.e = jSONObject2;
        bVar.g = d.s;
        com.igexin.push.core.b.e.a().a(new h(currentTimeMillis, jSONObject2, (byte) 3, d.l ? currentTimeMillis : 0));
        if (c.a().i() != null) {
            c.a().i().a("C-" + d.s, bVar);
        }
        b.a("feedback|" + pushTaskBean.getTaskId() + Logger.c + pushTaskBean.getMessageId() + Logger.c + str, new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        this.a.execute(new f(this, str));
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, String str) {
        try {
            PushTaskBean pushTaskBean = new PushTaskBean();
            pushTaskBean.parse(jSONObject);
            a(pushTaskBean, str);
        } catch (Exception e) {
            b.a("CoreAction " + e.toString(), new Object[0]);
        }
    }

    public boolean a(com.igexin.a.a.d.e eVar) {
        return false;
    }

    public boolean a(com.igexin.push.d.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        a aVar = b.get(cVar.i);
        if ((cVar instanceof com.igexin.push.d.c.h) || (cVar instanceof k) || (cVar instanceof l) || (cVar instanceof com.igexin.push.d.c.o) || (cVar instanceof p) || (cVar instanceof f)) {
            b.a("CoreAction|receive : " + cVar.getClass().getName() + " resp ~~~~", new Object[0]);
            com.igexin.a.a.b.a.a.f.a().a(cVar.getClass().getName());
        }
        if ((cVar instanceof k) || (cVar instanceof l) || (cVar instanceof com.igexin.push.d.c.o)) {
            d.D = 0;
            d.E = 1200000;
            i.a().d().b();
        }
        if (aVar != null) {
            aVar.a((Object) cVar);
        }
        com.igexin.push.f.b.b.i().j();
        return true;
    }

    public boolean a(Object obj) {
        com.igexin.push.e.a i = c.a().i();
        if ((obj instanceof com.igexin.push.d.c.c) && i != null) {
            i.a((com.igexin.push.d.c.c) obj);
        } else if (obj instanceof com.igexin.push.d.b.b) {
            b.a("CoreAction|TcpExceptionNotify###", new Object[0]);
            i.f();
        } else if (obj instanceof com.igexin.push.d.b.a) {
            b.a("CoreAction|TcpDisconnectSuccessNotify ###", new Object[0]);
            if (d.l) {
                d.l = false;
                b.a("CoreAction|broadcast online state = offline", new Object[0]);
                r.a().b();
            }
            i.g();
        }
        return false;
    }

    public boolean a(String str, String str2, String str3) {
        return w.a().a(str, str2, str3);
    }

    public boolean a(JSONObject jSONObject, PushTaskBean pushTaskBean) {
        return w.a().a(jSONObject, pushTaskBean);
    }

    public void b() {
        b.a("CoreAction|send heart beat data ........", new Object[0]);
        c.a().i().a("H-" + d.s, new f(), true);
    }

    public void b(Intent intent) {
        if (intent != null && intent.hasExtra("isSlave")) {
            boolean booleanExtra = intent.getBooleanExtra("isSlave", false);
            b.a("CoreAction|onServiceInitializeForSlave isSlave =" + booleanExtra, new Object[0]);
            if (booleanExtra) {
                c.a().a(true);
                if (d.l) {
                    r.a().c();
                }
            }
        }
    }

    public void b(PushTaskBean pushTaskBean, String str) {
        a(pushTaskBean, str, "ok");
    }

    /* access modifiers changed from: package-private */
    public void b(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "received");
            jSONObject.put("id", str);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        n nVar = new n();
        nVar.b();
        nVar.a = (int) System.currentTimeMillis();
        nVar.d = "17258000";
        nVar.e = jSONObject2;
        nVar.g = d.s;
        c.a().i().a("C-" + d.s, nVar);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        try {
            for (h next : com.igexin.push.core.b.e.a().b()) {
                if (next.d() + 20000 <= System.currentTimeMillis()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject(next.b());
                    com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                    bVar.b();
                    bVar.a = (int) currentTimeMillis;
                    bVar.d = "17258000";
                    if (jSONObject.has("extraData")) {
                        bVar.f = com.igexin.push.util.h.a(jSONObject.optString("extraData").getBytes(), 0);
                        jSONObject.remove("extraData");
                    }
                    bVar.e = next.b();
                    bVar.g = d.s;
                    b.a("freshral|" + next.b(), new Object[0]);
                    com.igexin.push.core.b.e.a().a(next.a(), System.currentTimeMillis());
                    c.a().i().a("C-" + d.s, bVar);
                    return;
                }
            }
        } catch (Throwable th) {
            b.a("CoreActionfreshRAL error :" + th.toString(), new Object[0]);
        }
    }

    public void c(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            try {
                String action = intent.getAction();
                if (PushConsts.ACTION_BROADCAST_NETWORK_CHANGE.equals(action)) {
                    if (com.igexin.a.a.b.c.b() != null) {
                        l();
                    }
                } else if (CoreConsts.b.equals(action)) {
                    w.a().a(intent);
                } else if (CoreConsts.a.equals(action)) {
                    String stringExtra = intent.getStringExtra("checkpackage");
                    String stringExtra2 = intent.getStringExtra("accesstoken");
                    b.a("CoreAction|checkpackage = " + stringExtra + " , accesstoken = " + stringExtra2, new Object[0]);
                    if (stringExtra != null && stringExtra2 != null && stringExtra.equals(d.e.getPackageName())) {
                        intent.setAction(CoreConsts.b);
                        intent.putExtra("accesstoken", d.ai);
                        w.a().a(intent);
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setAppid(intent.getStringExtra(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID));
                        pushTaskBean.setMessageId(intent.getStringExtra("messageid"));
                        pushTaskBean.setTaskId(intent.getStringExtra("taskid"));
                        pushTaskBean.setId(intent.getStringExtra("id"));
                        try {
                            int parseInt = Integer.parseInt(intent.getStringExtra("feedbackid")) + 30010;
                            pushTaskBean.setCurrentActionid(parseInt);
                            a().a(pushTaskBean, parseInt + "", (intent.getBooleanExtra("isFloat", false) ? new StringBuilder("notifyFloat:").append(intent.getStringExtra("bigStyle")) : new StringBuilder("notifyStyle:").append(intent.getStringExtra("notifyStyle"))).toString());
                        } catch (Exception unused) {
                        }
                    }
                } else if ("android.intent.action.TIME_SET".equals(action)) {
                    if (com.igexin.push.config.l.b != 0) {
                        com.igexin.push.a.a.c.c().d();
                    }
                } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                    d.q = 1;
                    if (w.a().b()) {
                        w.a().f();
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        c("screen on");
                    }
                } else if ("android.intent.action.SCREEN_OFF".equals(action)) {
                    d.q = 0;
                }
            } catch (Throwable th) {
                b.a("CoreAction" + th.toString(), new Object[0]);
            }
        }
    }

    public void c(PushTaskBean pushTaskBean, String str) {
        this.a.execute(new i(this, pushTaskBean, str));
    }

    public void c(String str) {
        b.a("CoreAction|resetDelayTime from = " + str, new Object[0]);
        if (d.D > WorkRequest.MIN_BACKOFF_MILLIS || (d.D == 0 && d.E == 1200000)) {
            int random = (int) ((Math.random() * 200.0d) + 1000.0d);
            b.a("CoreAction|reConnectDelayTime = " + d.D + ", reset = " + random, new Object[0]);
            com.igexin.push.f.b.f.i().b((long) random);
            return;
        }
        b.a("CoreAction|resetDelayTime ignore, delay = " + d.D, new Object[0]);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "request_deviceid");
            jSONObject.put("id", String.valueOf(currentTimeMillis));
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
        bVar.b();
        bVar.a = (int) currentTimeMillis;
        bVar.d = "17258000";
        bVar.e = jSONObject2;
        bVar.g = d.s;
        c.a().i().a("C-" + d.s, bVar);
        b.a("CoreAction|deviceidReq", new Object[0]);
    }

    public void e() {
        try {
            if (System.currentTimeMillis() - d.G > TimeUtils.oneDayMillis) {
                com.igexin.push.core.b.i.a().b(0);
                com.igexin.push.core.b.i.a().d(System.currentTimeMillis());
            }
            if (d.as <= 5) {
                com.igexin.push.core.b.i.a().b(d.as + 1);
                com.igexin.a.a.b.c.b().a(new g(this), false, true);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean f() {
        return false;
    }

    public void g() {
        String[] list;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        String format = simpleDateFormat.format(new Date());
        File file = new File("/sdcard/libs//");
        String str = d.c;
        if (str == null) {
            str = "unknowPacageName";
        }
        if (file.exists() && (list = file.list()) != null) {
            int length = list.length;
            for (int i = 0; i < length; i++) {
                int length2 = list[i].length();
                if (list[i].startsWith(str) && list[i].endsWith(".log") && length2 > str.length() + 14 && str.equals(list[i].substring(0, length2 - 15))) {
                    try {
                        if (Math.abs((simpleDateFormat.parse(format).getTime() - simpleDateFormat.parse(list[i].substring(str.length() + 1, length2 - 4)).getTime()) / TimeUtils.oneDayMillis) > 6) {
                            File file2 = new File("/sdcard/libs//" + list[i]);
                            if (file2.exists()) {
                                file2.delete();
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public void h() {
        a.e();
    }

    public void i() {
        int i = d.af - 100;
        if (i < 0) {
            i = 0;
        }
        d.af = i;
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<Map.Entry<String, Long>> it = d.ae.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String str = (String) next.getKey();
            if (currentTimeMillis - ((Long) next.getValue()).longValue() > 3600000) {
                it.remove();
            }
        }
    }

    public void j() {
        if (d.N < System.currentTimeMillis()) {
            com.igexin.push.core.b.i.a().a(false);
        }
    }

    public void k() {
        if (!d.Z) {
            d.Z = com.igexin.a.a.b.c.b().a(com.igexin.push.f.b.b.i(), false, true);
        }
        if (!d.aa) {
            d.aa = com.igexin.a.a.b.c.b().a(com.igexin.push.f.b.f.i(), true, true);
        }
        if (!d.ab) {
            c.a().d();
        }
    }
}
