package com.igexin.push.core.c;

import com.huawei.hms.framework.common.hianalytics.HianalyticsBaseData;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.a.a.b.c;
import com.igexin.push.config.l;
import com.igexin.push.core.d;
import com.igexin.sdk.PushConsts;
import org.json.JSONObject;

public class b extends com.igexin.push.f.a.b {
    public static final String a = "com.igexin.push.core.c.b";

    public b(String str) {
        super(str);
        b();
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0220 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0240 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x025a A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0274 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0294 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x02b4 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x02d4 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02f4 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0314 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0334 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0358 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0378 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016b A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0187 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0195 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01a3 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b5 A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01ca A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01dc A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ee A[Catch:{ all -> 0x0388 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01fe  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(byte[] r23) {
        /*
            r22 = this;
            java.lang.String r0 = "sdk.hide.righticon.blacklist"
            java.lang.String r1 = "sdk.httpdata.maxsize"
            java.lang.String r2 = "sdk.polling.exit.heartbeat.cnt"
            java.lang.String r3 = "sdk.polling.login.interval"
            java.lang.String r4 = "sdk.polling.dis.cnt"
            java.lang.String r5 = "sdk.watchout.service"
            java.lang.String r6 = "sdk.watchout.app"
            java.lang.String r7 = "sdk.report.initialize.enable"
            java.lang.String r8 = "sdk.needlook.enable"
            java.lang.String r9 = "sdk.feature.setsilenttime.enable"
            java.lang.String r10 = "sdk.domainbackup.enable"
            java.lang.String r11 = "sdk.feature.sendmessage.enable"
            java.lang.String r12 = "sdk.startservice.limit"
            java.lang.String r13 = "sdk.ups.push.disable.brand"
            java.lang.String r14 = "sdk.sdcard.enabled"
            java.lang.String r15 = "tag"
            r16 = r0
            java.lang.String r0 = "config"
            r17 = r1
            java.lang.String r1 = "result"
            r18 = r2
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x038d }
            r19 = r3
            r3 = r23
            r2.<init>(r3)     // Catch:{ all -> 0x038d }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ all -> 0x038d }
            r3.<init>(r2)     // Catch:{ all -> 0x038d }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x038d }
            r2.<init>()     // Catch:{ all -> 0x038d }
            r20 = r4
            java.lang.String r4 = a     // Catch:{ all -> 0x038d }
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x038d }
            java.lang.String r4 = "|parse sdk config from server resp = "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x038d }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x038d }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x038d }
            r21 = r5
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ all -> 0x038d }
            com.igexin.a.a.c.b.a((java.lang.String) r2, (java.lang.Object[]) r5)     // Catch:{ all -> 0x038d }
            com.igexin.push.core.b.i r2 = com.igexin.push.core.b.i.a()     // Catch:{ all -> 0x038d }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x038d }
            r2.c((long) r4)     // Catch:{ all -> 0x038d }
            boolean r2 = r3.has(r1)     // Catch:{ all -> 0x038d }
            if (r2 == 0) goto L_0x038a
            java.lang.String r2 = "ok"
            java.lang.String r1 = r3.getString(r1)     // Catch:{ all -> 0x038d }
            boolean r1 = r2.equals(r1)     // Catch:{ all -> 0x038d }
            if (r1 == 0) goto L_0x038a
            boolean r1 = r3.has(r0)     // Catch:{ all -> 0x038d }
            if (r1 != 0) goto L_0x0080
            goto L_0x038a
        L_0x0080:
            boolean r1 = r3.has(r15)     // Catch:{ all -> 0x038d }
            if (r1 == 0) goto L_0x008c
            java.lang.String r1 = r3.getString(r15)     // Catch:{ all -> 0x038d }
            com.igexin.push.config.l.s = r1     // Catch:{ all -> 0x038d }
        L_0x008c:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x038d }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ all -> 0x038d }
            r1.<init>(r0)     // Catch:{ all -> 0x038d }
            boolean r0 = r1.has(r14)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x00b7
            r0 = 1
            boolean r0 = r1.optBoolean(r14, r0)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x00ad
            com.igexin.sdk.a.b r0 = new com.igexin.sdk.a.b     // Catch:{ all -> 0x038d }
            android.content.Context r2 = com.igexin.push.core.d.e     // Catch:{ all -> 0x038d }
            r0.<init>(r2)     // Catch:{ all -> 0x038d }
            r0.b()     // Catch:{ all -> 0x038d }
            goto L_0x00b7
        L_0x00ad:
            com.igexin.sdk.a.b r0 = new com.igexin.sdk.a.b     // Catch:{ all -> 0x038d }
            android.content.Context r2 = com.igexin.push.core.d.e     // Catch:{ all -> 0x038d }
            r0.<init>(r2)     // Catch:{ all -> 0x038d }
            r0.a()     // Catch:{ all -> 0x038d }
        L_0x00b7:
            boolean r0 = r1.has(r13)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x00c3
            java.lang.String r0 = r1.getString(r13)     // Catch:{ all -> 0x038d }
            com.igexin.push.config.l.L = r0     // Catch:{ all -> 0x038d }
        L_0x00c3:
            java.lang.String r0 = com.igexin.push.config.l.L     // Catch:{ all -> 0x038d }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x00cf
            java.lang.String r0 = "null"
            com.igexin.push.config.l.L = r0     // Catch:{ all -> 0x038d }
        L_0x00cf:
            boolean r0 = r1.has(r12)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x00db
            java.lang.String r0 = r1.getString(r12)     // Catch:{ all -> 0x038d }
            com.igexin.push.config.l.K = r0     // Catch:{ all -> 0x038d }
        L_0x00db:
            boolean r0 = r1.has(r11)     // Catch:{ all -> 0x038d }
            java.lang.String r2 = "false"
            java.lang.String r3 = "true"
            if (r0 == 0) goto L_0x00fb
            java.lang.String r0 = r1.getString(r11)     // Catch:{ all -> 0x038d }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038d }
            if (r4 != 0) goto L_0x00f5
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x038d }
            if (r4 == 0) goto L_0x00fb
        L_0x00f5:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x038d }
            com.igexin.push.config.l.g = r0     // Catch:{ all -> 0x038d }
        L_0x00fb:
            boolean r0 = r1.has(r10)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x0117
            java.lang.String r0 = r1.getString(r10)     // Catch:{ all -> 0x038d }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038d }
            if (r4 != 0) goto L_0x0111
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x038d }
            if (r4 == 0) goto L_0x0117
        L_0x0111:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x038d }
            com.igexin.push.config.l.f = r0     // Catch:{ all -> 0x038d }
        L_0x0117:
            boolean r0 = r1.has(r9)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x013d
            java.lang.String r0 = r1.getString(r9)     // Catch:{ all -> 0x038d }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038d }
            if (r4 != 0) goto L_0x012d
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x013d
        L_0x012d:
            int r0 = com.igexin.push.config.l.b     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x013d
            com.igexin.push.core.v r0 = com.igexin.push.core.v.a()     // Catch:{ all -> 0x038d }
            java.lang.String r4 = "server"
            r5 = 12
            r9 = 0
            r0.a((int) r5, (int) r9, (java.lang.String) r4)     // Catch:{ all -> 0x038d }
        L_0x013d:
            boolean r0 = r1.has(r8)     // Catch:{ all -> 0x038d }
            if (r0 == 0) goto L_0x0163
            java.lang.String r0 = r1.getString(r8)     // Catch:{ all -> 0x038d }
            boolean r4 = r0.equals(r3)     // Catch:{ all -> 0x038d }
            if (r4 != 0) goto L_0x0153
            boolean r4 = r0.equals(r2)     // Catch:{ all -> 0x038d }
            if (r4 == 0) goto L_0x0163
        L_0x0153:
            boolean r4 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x038d }
            com.igexin.push.config.l.k = r4     // Catch:{ all -> 0x038d }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x038d }
            r4 = r22
            r4.d(r0)     // Catch:{ all -> 0x0388 }
            goto L_0x0165
        L_0x0163:
            r4 = r22
        L_0x0165:
            boolean r0 = r1.has(r7)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = r1.getString(r7)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x017b
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x0181
        L_0x017b:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.m = r0     // Catch:{ all -> 0x0388 }
        L_0x0181:
            boolean r0 = r1.has(r6)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x018d
            java.lang.String r0 = r1.getString(r6)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.i = r0     // Catch:{ all -> 0x0388 }
        L_0x018d:
            r0 = r21
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x019b
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.j = r0     // Catch:{ all -> 0x0388 }
        L_0x019b:
            r0 = r20
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x01ad
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.t = r0     // Catch:{ all -> 0x0388 }
        L_0x01ad:
            r0 = r19
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x01c2
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0388 }
            int r0 = r0 * 1000
            long r5 = (long) r0     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.u = r5     // Catch:{ all -> 0x0388 }
        L_0x01c2:
            r0 = r18
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x01d4
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.v = r0     // Catch:{ all -> 0x0388 }
        L_0x01d4:
            r0 = r17
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x01e6
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.w = r0     // Catch:{ all -> 0x0388 }
        L_0x01e6:
            r0 = r16
            boolean r5 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x01f4
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.x = r0     // Catch:{ all -> 0x0388 }
        L_0x01f4:
            java.lang.String r0 = "sdk.taskid.blacklist"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            java.lang.String r5 = "none"
            if (r0 == 0) goto L_0x0218
            java.lang.String r0 = "sdk.taskid.blacklist"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.y = r0     // Catch:{ all -> 0x0388 }
            java.lang.String r0 = com.igexin.push.config.l.y     // Catch:{ all -> 0x0388 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0388 }
            if (r0 != 0) goto L_0x0216
            com.igexin.push.core.w r0 = com.igexin.push.core.w.a()     // Catch:{ all -> 0x0388 }
            r0.e()     // Catch:{ all -> 0x0388 }
            goto L_0x0218
        L_0x0216:
            com.igexin.push.config.l.y = r5     // Catch:{ all -> 0x0388 }
        L_0x0218:
            java.lang.String r0 = "sdk.applink.feedback.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0238
            java.lang.String r0 = "sdk.applink.feedback.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r6 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r6 != 0) goto L_0x0232
            boolean r6 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r6 == 0) goto L_0x0238
        L_0x0232:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.z = r0     // Catch:{ all -> 0x0388 }
        L_0x0238:
            java.lang.String r0 = "sdk.applink.domains"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0252
            java.lang.String r0 = "sdk.applink.domains"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.A = r0     // Catch:{ all -> 0x0388 }
            java.lang.String r0 = com.igexin.push.config.l.A     // Catch:{ all -> 0x0388 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0252
            com.igexin.push.config.l.A = r5     // Catch:{ all -> 0x0388 }
        L_0x0252:
            java.lang.String r0 = "sdk.del.alarm.brand"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x026c
            java.lang.String r0 = "sdk.del.alarm.brand"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.B = r0     // Catch:{ all -> 0x0388 }
            java.lang.String r0 = com.igexin.push.config.l.B     // Catch:{ all -> 0x0388 }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x026c
            com.igexin.push.config.l.B = r5     // Catch:{ all -> 0x0388 }
        L_0x026c:
            java.lang.String r0 = "sdk.miuipush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x028c
            java.lang.String r0 = "sdk.miuipush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x0286
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x028c
        L_0x0286:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.C = r0     // Catch:{ all -> 0x0388 }
        L_0x028c:
            java.lang.String r0 = "sdk.flymepush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x02ac
            java.lang.String r0 = "sdk.flymepush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x02a6
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x02ac
        L_0x02a6:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.D = r0     // Catch:{ all -> 0x0388 }
        L_0x02ac:
            java.lang.String r0 = "sdk.hmspush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x02cc
            java.lang.String r0 = "sdk.hmspush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x02c6
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x02cc
        L_0x02c6:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.E = r0     // Catch:{ all -> 0x0388 }
        L_0x02cc:
            java.lang.String r0 = "sdk.colorospush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x02ec
            java.lang.String r0 = "sdk.colorospush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x02e6
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x02ec
        L_0x02e6:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.F = r0     // Catch:{ all -> 0x0388 }
        L_0x02ec:
            java.lang.String r0 = "sdk.vivopush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x030c
            java.lang.String r0 = "sdk.vivopush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x0306
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x030c
        L_0x0306:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.G = r0     // Catch:{ all -> 0x0388 }
        L_0x030c:
            java.lang.String r0 = "sdk.stpush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x032c
            java.lang.String r0 = "sdk.stpush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x0326
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x032c
        L_0x0326:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.I = r0     // Catch:{ all -> 0x0388 }
        L_0x032c:
            java.lang.String r0 = "sdk.fcmpush.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0350
            java.lang.String r0 = "sdk.fcmpush.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r5 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r5 != 0) goto L_0x0346
            boolean r5 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r5 == 0) goto L_0x0350
        L_0x0346:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0388 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.H = r0     // Catch:{ all -> 0x0388 }
        L_0x0350:
            java.lang.String r0 = "sdk.oaid.enable"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0370
            java.lang.String r0 = "sdk.oaid.enable"
            java.lang.String r0 = r1.getString(r0)     // Catch:{ all -> 0x0388 }
            boolean r3 = r0.equals(r3)     // Catch:{ all -> 0x0388 }
            if (r3 != 0) goto L_0x036a
            boolean r2 = r0.equals(r2)     // Catch:{ all -> 0x0388 }
            if (r2 == 0) goto L_0x0370
        L_0x036a:
            boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.J = r0     // Catch:{ all -> 0x0388 }
        L_0x0370:
            java.lang.String r0 = "sdk.upload.gzip.limit"
            boolean r0 = r1.has(r0)     // Catch:{ all -> 0x0388 }
            if (r0 == 0) goto L_0x0380
            java.lang.String r0 = "sdk.upload.gzip.limit"
            long r0 = r1.getLong(r0)     // Catch:{ all -> 0x0388 }
            com.igexin.push.config.l.M = r0     // Catch:{ all -> 0x0388 }
        L_0x0380:
            com.igexin.push.config.a r0 = com.igexin.push.config.a.a()     // Catch:{ all -> 0x0388 }
            r0.f()     // Catch:{ all -> 0x0388 }
            goto L_0x03b3
        L_0x0388:
            r0 = move-exception
            goto L_0x0390
        L_0x038a:
            r4 = r22
            return
        L_0x038d:
            r0 = move-exception
            r4 = r22
        L_0x0390:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r2 = "|"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)
        L_0x03b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.c.b.c(byte[]):void");
    }

    private void d(byte[] bArr) {
        try {
            c.b().a(new c(this, bArr), false, true);
        } catch (Exception unused) {
        }
    }

    public void a(byte[] bArr) throws Exception {
        if (bArr != null) {
            c(bArr);
        }
    }

    public void b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(PushConsts.CMD_ACTION, "sdkconfig");
            jSONObject.put("cid", d.s);
            jSONObject.put(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID, d.a);
            jSONObject.put(HianalyticsBaseData.SDK_VERSION, "4.4.3.13");
            jSONObject.put("tag", l.s);
            b(jSONObject.toString().getBytes());
        } catch (Exception unused) {
        }
    }

    public int b_() {
        return 0;
    }
}
