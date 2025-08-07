package com.igexin.push.core;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.c.a.f;
import com.igexin.a.a.c.b;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.assist.sdk.AssistPushManager;
import com.igexin.push.a.a.c;
import com.igexin.push.config.a;
import com.igexin.push.config.l;
import com.igexin.push.core.a.e;
import com.igexin.push.core.b.i;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.util.h;
import com.igexin.push.util.n;
import com.igexin.sdk.PushConsts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.json.JSONObject;

public class v {
    private static v a;

    private v() {
    }

    public static v a() {
        if (a == null) {
            a = new v();
        }
        return a;
    }

    public void a(int i, int i2, String str) {
        l.a = i;
        l.b = i2;
        a.a().b();
        c.c().d();
    }

    public void a(int i, String str) {
        l.d = i;
        a.a().c();
        if (d.l) {
            b.a("setHeartbeatInterval heartbeatReq", new Object[0]);
            if (System.currentTimeMillis() - d.O > 5000) {
                d.O = System.currentTimeMillis();
                e.a().b();
            }
        }
    }

    public void a(Bundle bundle) {
        f a2;
        String str;
        String string = bundle.getString(PushConsts.CMD_ACTION);
        b.a("PushController|action pushmanager action = " + string, new Object[0]);
        if (!TextUtils.isEmpty(string)) {
            if (string.equals("setTag")) {
                a(bundle.getString("tags"), bundle.getString("sn"));
            } else if (string.equals("setSilentTime")) {
                int i = bundle.getInt("beginHour", 0);
                int i2 = bundle.getInt(TypedValues.TransitionType.S_DURATION, 0);
                a(i, i2, d.e.getPackageName());
                AssistPushManager.getInstance().setSilentTime(d.e, i, i2);
            } else if (string.equals("sendMessage")) {
                b.a("PushController onPushManagerMessage recevie action : sendMessage", new Object[0]);
                if (l.g) {
                    String string2 = bundle.getString("taskid");
                    byte[] byteArray = bundle.getByteArray("extraData");
                    b.a("PushController receive broadcast msg data , task id : " + string2 + " ######@##@@@#", new Object[0]);
                    a(string2, byteArray);
                }
            } else if (string.equals("setHeartbeatInterval")) {
                a(bundle.getInt("interval", 0), d.e.getPackageName());
            } else if (string.equals("setSocketTimeout")) {
                b(bundle.getInt("timeout", 0), d.e.getPackageName());
            } else if (string.equals("sendFeedbackMessage")) {
                if (d.af <= 200) {
                    String string3 = bundle.getString("taskid");
                    String string4 = bundle.getString("messageid");
                    String string5 = bundle.getString("actionid");
                    String str2 = string3 + ":" + string4 + ":" + string5;
                    if (d.ae.get(str2) == null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId(string3);
                        pushTaskBean.setMessageId(string4);
                        pushTaskBean.setAppid(d.a);
                        e.a().b(pushTaskBean, string5);
                        d.af++;
                        d.ae.put(str2, Long.valueOf(currentTimeMillis));
                    }
                }
            } else if (string.equals("turnOffPush")) {
                c.a().g();
                AssistPushManager.getInstance().turnOffPush(d.e);
            } else if (string.equals("bindAlias")) {
                String string6 = bundle.getString("alias");
                String string7 = bundle.getString("sn");
                b.a("PushController|onPushManagerMessage bindAlias...", new Object[0]);
                b(string6, string7);
            } else if (string.equals("unbindAlias")) {
                String string8 = bundle.getString("alias");
                String string9 = bundle.getString("sn");
                boolean z = bundle.getBoolean("isSeft");
                b.a("PushController|onPushManagerMessage unbindAlias...", new Object[0]);
                a(string8, string9, z);
            } else if (string.equals("sendApplinkFeedback")) {
                a(bundle.getString("url"));
            } else if (string.equals("setHwBadgeNum")) {
                com.igexin.push.util.b.a(bundle.getInt("badgeNum"), true);
            } else {
                if (string.equals("setNotificationIcon")) {
                    d.ax = bundle.getString("smallIcon", "");
                    d.ay = bundle.getString("largeIcon", "");
                    i.a().a(d.ax, d.ay);
                    a2 = f.a();
                    str = "[PushController] setNotificationIcon success";
                } else if (string.equals("setBadgeNum")) {
                    if (n.a().equalsIgnoreCase("huawei") || n.a().equalsIgnoreCase("honor")) {
                        com.igexin.push.util.b.a(bundle.getInt("badgeNum"), true);
                    } else if (n.a().equalsIgnoreCase("oppo")) {
                        com.igexin.push.util.b.c(bundle.getInt("badgeNum"), true);
                    } else if (n.a().equalsIgnoreCase("vivo")) {
                        com.igexin.push.util.b.b(bundle.getInt("badgeNum"), true);
                    }
                    a2 = f.a();
                    str = "[PushController] setBadgeNum success";
                } else if (string.equals("setDeviceToken")) {
                    String string10 = bundle.getString(AssistPushConsts.MSG_TYPE_TOKEN, "");
                    if (!TextUtils.isEmpty(string10) && d.b().booleanValue() && !string10.equals(d.z)) {
                        i.a().c(string10);
                        if (d.l) {
                            b.a("PushController", "set token online, send addphoneinfo");
                            e.a().e();
                        }
                    }
                    f.a().a("[PushController] setDeviceToken success " + string10);
                    return;
                } else {
                    return;
                }
                a2.a(str);
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            f.a().a("sendApplinkFeedback, url is invalid");
            return;
        }
        try {
            Uri parse = Uri.parse(str);
            String host = parse.getHost();
            String queryParameter = parse.getQueryParameter("p");
            if (parse != null && !TextUtils.isEmpty(host)) {
                if (!TextUtils.isEmpty(queryParameter)) {
                    if (!l.z) {
                        b.a("PushController|isApplinkFeedback is false, not feedback", new Object[0]);
                        return;
                    } else if (!com.igexin.push.util.a.c(host)) {
                        b.a("PushController|checkIsWhiteApplinkDomain is false, not feedback", new Object[0]);
                        return;
                    } else {
                        b.a("PushController|isApplinkFeedback is true and checkIsWhiteApplinkDomain is true, to feedback", new Object[0]);
                        PushTaskBean pushTaskBean = new PushTaskBean();
                        pushTaskBean.setTaskId("getuiapplinkup");
                        pushTaskBean.setMessageId(queryParameter);
                        pushTaskBean.setAppid(d.a);
                        e.a().b(pushTaskBean, PushConsts.SEND_MESSAGE_ERROR);
                        return;
                    }
                }
            }
            b.a("PushController|url " + str + " is invalid", new Object[0]);
        } catch (Exception e) {
            b.a("PushController|" + e.toString(), new Object[0]);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|7|8|9|10|(1:12)(1:13)|14|16) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x006b */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0073 A[Catch:{ Exception -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0075 A[Catch:{ Exception -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "C-"
            java.lang.String r1 = com.igexin.push.core.d.s
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 == 0) goto L_0x0034
            com.igexin.a.a.c.a.f r0 = com.igexin.a.a.c.a.f.a()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "setTag : "
            r1.<init>(r2)
            java.lang.StringBuilder r10 = r1.append(r10)
            java.lang.String r1 = ", failed, has not get clientid"
            java.lang.StringBuilder r10 = r10.append(r1)
            java.lang.String r10 = r10.toString()
            r0.a((java.lang.String) r10)
            com.igexin.push.core.r r10 = com.igexin.push.core.r.a()
            r0 = 20008(0x4e28, float:2.8037E-41)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r10.a((java.lang.String) r11, (java.lang.String) r0)
            return
        L_0x0034:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00b7 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00b7 }
            r1.<init>()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r4 = "action"
            java.lang.String r5 = "set_tag"
            r1.put(r4, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "id"
            java.lang.String r5 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x006b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "cid"
            java.lang.String r5 = com.igexin.push.core.d.s     // Catch:{ Exception -> 0x006b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "appid"
            java.lang.String r5 = com.igexin.push.core.d.a     // Catch:{ Exception -> 0x006b }
            r1.put(r4, r5)     // Catch:{ Exception -> 0x006b }
            java.lang.String r4 = "tags"
            java.lang.String r5 = "utf-8"
            java.lang.String r10 = java.net.URLEncoder.encode(r10, r5)     // Catch:{ Exception -> 0x006b }
            r1.put(r4, r10)     // Catch:{ Exception -> 0x006b }
            java.lang.String r10 = "sn"
            r1.put(r10, r11)     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x00b7 }
            boolean r11 = com.igexin.push.core.d.l     // Catch:{ Exception -> 0x00b7 }
            if (r11 == 0) goto L_0x0075
            r6 = r2
            goto L_0x0078
        L_0x0075:
            r4 = 0
            r6 = r4
        L_0x0078:
            com.igexin.push.core.b.e r11 = com.igexin.push.core.b.e.a()     // Catch:{ Exception -> 0x00b7 }
            com.igexin.push.core.bean.h r8 = new com.igexin.push.core.bean.h     // Catch:{ Exception -> 0x00b7 }
            r5 = 2
            r1 = r8
            r4 = r10
            r1.<init>(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00b7 }
            r11.a((com.igexin.push.core.bean.h) r8)     // Catch:{ Exception -> 0x00b7 }
            com.igexin.push.d.c.b r11 = new com.igexin.push.d.c.b     // Catch:{ Exception -> 0x00b7 }
            r11.<init>()     // Catch:{ Exception -> 0x00b7 }
            r11.b()     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r1 = "17258000"
            r11.d = r1     // Catch:{ Exception -> 0x00b7 }
            r11.e = r10     // Catch:{ Exception -> 0x00b7 }
            com.igexin.push.core.c r10 = com.igexin.push.core.c.a()     // Catch:{ Exception -> 0x00b7 }
            com.igexin.push.e.a r10 = r10.i()     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r0 = com.igexin.push.core.d.s     // Catch:{ Exception -> 0x00b7 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b7 }
            r10.a(r0, r11)     // Catch:{ Exception -> 0x00b7 }
            java.lang.String r10 = "settag"
            r11 = 0
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x00b7 }
            com.igexin.a.a.c.b.a((java.lang.String) r10, (java.lang.Object[]) r11)     // Catch:{ Exception -> 0x00b7 }
        L_0x00b7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.v.a(java.lang.String, java.lang.String):void");
    }

    public void a(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(d.s)) {
            f.a().a("unbindAlias : " + str + ", failed, has not get clientid");
            r.a().c(str2, String.valueOf(PushConsts.ALIAS_CID_LOST));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d.Q > 1000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(d.P)) {
                i.a().f(format);
                i.a().a(0);
            }
            if (d.R < 100) {
                b.a("start unbindAlias ###", new Object[0]);
                d.Q = currentTimeMillis;
                i.a().a(d.R + 1);
                a(str, str2, true, z);
                return;
            }
            b.a("PushController|unbindAlias times exceed", new Object[0]);
            f.a().a("unbindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
            r.a().c(str2, String.valueOf(PushConsts.ALIAS_REQUEST_FILTER));
            return;
        }
        b.a("PushController|unbindAlias frequently called", new Object[0]);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(14:1|2|(1:4)(1:5)|6|(1:8)(1:9)|10|11|12|(1:14)|15|16|(1:18)(1:19)|20|22) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0047 */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[Catch:{ Exception -> 0x00a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051 A[Catch:{ Exception -> 0x00a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r10, java.lang.String r11, boolean r12, boolean r13) {
        /*
            r9 = this;
            java.lang.String r0 = "C-"
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00a7 }
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a7 }
            r1.<init>()     // Catch:{ Exception -> 0x00a7 }
            if (r12 == 0) goto L_0x0010
            java.lang.String r4 = "unbind_alias"
            goto L_0x0012
        L_0x0010:
            java.lang.String r4 = "bind_alias"
        L_0x0012:
            r8 = r4
            if (r12 == 0) goto L_0x0018
            r4 = 8
            goto L_0x0019
        L_0x0018:
            r4 = 7
        L_0x0019:
            r5 = r4
            java.lang.String r4 = "action"
            r1.put(r4, r8)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "id"
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0047 }
            r1.put(r4, r6)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "cid"
            java.lang.String r6 = com.igexin.push.core.d.s     // Catch:{ Exception -> 0x0047 }
            r1.put(r4, r6)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "appid"
            java.lang.String r6 = com.igexin.push.core.d.a     // Catch:{ Exception -> 0x0047 }
            r1.put(r4, r6)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r4 = "alias"
            r1.put(r4, r10)     // Catch:{ Exception -> 0x0047 }
            java.lang.String r10 = "sn"
            r1.put(r10, r11)     // Catch:{ Exception -> 0x0047 }
            if (r12 == 0) goto L_0x0047
            java.lang.String r10 = "is_self"
            r1.put(r10, r13)     // Catch:{ Exception -> 0x0047 }
        L_0x0047:
            java.lang.String r10 = r1.toString()     // Catch:{ Exception -> 0x00a7 }
            boolean r11 = com.igexin.push.core.d.l     // Catch:{ Exception -> 0x00a7 }
            if (r11 == 0) goto L_0x0051
            r6 = r2
            goto L_0x0054
        L_0x0051:
            r11 = 0
            r6 = r11
        L_0x0054:
            com.igexin.push.core.b.e r11 = com.igexin.push.core.b.e.a()     // Catch:{ Exception -> 0x00a7 }
            com.igexin.push.core.bean.h r12 = new com.igexin.push.core.bean.h     // Catch:{ Exception -> 0x00a7 }
            r1 = r12
            r4 = r10
            r1.<init>(r2, r4, r5, r6)     // Catch:{ Exception -> 0x00a7 }
            r11.a((com.igexin.push.core.bean.h) r12)     // Catch:{ Exception -> 0x00a7 }
            com.igexin.push.d.c.b r11 = new com.igexin.push.d.c.b     // Catch:{ Exception -> 0x00a7 }
            r11.<init>()     // Catch:{ Exception -> 0x00a7 }
            r11.b()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r12 = "17258000"
            r11.d = r12     // Catch:{ Exception -> 0x00a7 }
            r11.e = r10     // Catch:{ Exception -> 0x00a7 }
            com.igexin.push.core.c r12 = com.igexin.push.core.c.a()     // Catch:{ Exception -> 0x00a7 }
            com.igexin.push.e.a r12 = r12.i()     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r13.<init>(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r0 = com.igexin.push.core.d.s     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r13 = r13.append(r0)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x00a7 }
            r12.a(r13, r11)     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r11.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r11 = r11.append(r8)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r12 = " = "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x00a7 }
            r11 = 0
            java.lang.Object[] r11 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x00a7 }
            com.igexin.a.a.c.b.a((java.lang.String) r10, (java.lang.Object[]) r11)     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.v.a(java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public void a(String str, byte[] bArr) {
        String str2 = str;
        byte[] bArr2 = bArr;
        if (d.s != null) {
            JSONObject jSONObject = new JSONObject();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                jSONObject.put(PushConsts.CMD_ACTION, "sendmessage");
                jSONObject.put("id", String.valueOf(currentTimeMillis));
                jSONObject.put("cid", d.s);
                jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, d.a);
                jSONObject.put("taskid", str2);
                jSONObject.put("extraData", h.b(bArr2, 0));
                String jSONObject2 = jSONObject.toString();
                com.igexin.push.core.b.e a2 = com.igexin.push.core.b.e.a();
                com.igexin.push.core.bean.h hVar = r5;
                com.igexin.push.core.bean.h hVar2 = new com.igexin.push.core.bean.h(currentTimeMillis, jSONObject2, (byte) 6, currentTimeMillis);
                a2.a(hVar);
                com.igexin.push.d.c.b bVar = new com.igexin.push.d.c.b();
                bVar.b();
                bVar.a = (int) currentTimeMillis;
                bVar.d = d.s;
                bVar.e = jSONObject2;
                bVar.f = bArr2;
                bVar.g = d.s;
                c.a().i().a("C-" + d.s, bVar);
                if (str2 != null && str2.startsWith("4T5@S_")) {
                    b.a("PushController sending lbs report message : " + jSONObject2, new Object[0]);
                }
            } catch (Throwable th) {
                b.a("PushController|" + th.toString(), new Object[0]);
            }
        }
    }

    public void b(int i, String str) {
        l.e = i;
        a.a().d();
    }

    public void b(String str, String str2) {
        if (TextUtils.isEmpty(d.s)) {
            f.a().a("bindAlias : " + str + ", failed, has not get clientid");
            r.a().b(str2, String.valueOf(PushConsts.ALIAS_CID_LOST));
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - d.Q > 1000) {
            String format = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date(currentTimeMillis));
            if (!format.equals(d.P)) {
                i.a().f(format);
                i.a().a(0);
            }
            b.a("-> CoreRuntimeInfo.opAliasTimes:" + d.R, new Object[0]);
            if (d.R < 100) {
                b.a("start bindAlias ###", new Object[0]);
                d.Q = currentTimeMillis;
                i.a().a(d.R + 1);
                a(str, str2, false, true);
                return;
            }
            b.a("PushController|bindAlias times exceed", new Object[0]);
            f.a().a("bindAlias : " + str + ", failed, , the number of calls per day cannot exceed 100");
            r.a().b(str2, String.valueOf(PushConsts.ALIAS_REQUEST_FILTER));
            return;
        }
        b.a("PushController|bindAlias frequently called", new Object[0]);
    }
}
