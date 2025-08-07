package com.igexin.push.extension.distribution.basic.a;

import com.igexin.push.core.a.a.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.extension.distribution.basic.b.c;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import org.json.JSONObject;

public class g implements a {
    private static final String a = ("EXT-" + g.class.getName());

    public com.igexin.push.core.a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return com.igexin.push.core.a.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (jSONObject.has("do") && jSONObject.has("actionid") && jSONObject.has(TransmitterActivityKt.OPERATION_TYPE) && jSONObject.has("intent") && jSONObject.has("do_failed") && jSONObject.has("t")) {
                String string = jSONObject.getString("intent");
                String string2 = jSONObject.getString("t");
                String string3 = jSONObject.getString("do");
                String string4 = jSONObject.getString("do_failed");
                if ((!string2.equals("0") && !string2.equals("1")) || string4.equals("") || string3.equals("0")) {
                    return null;
                }
                c cVar = new c();
                cVar.setType("startintent");
                cVar.setActionId(jSONObject.getString("actionid"));
                cVar.setDoActionId(jSONObject.getString("do"));
                cVar.b(string);
                cVar.a(string2);
                cVar.c(jSONObject.getString("do_failed"));
                return cVar;
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.igexin.a.a.c.b.a(a + "|executeAction err intent=" + r8.b() + " t=" + r8.a(), new java.lang.Object[0]);
        com.igexin.push.core.a.e.a().a(r7.getTaskId(), r7.getMessageId(), r8.c());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x009d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.igexin.push.core.bean.PushTaskBean r7, com.igexin.push.core.bean.BaseAction r8) {
        /*
            r6 = this;
            java.lang.String r0 = " t="
            java.lang.String r1 = "StartIntentAction err intent="
            com.igexin.push.extension.distribution.basic.b.c r8 = (com.igexin.push.extension.distribution.basic.b.c) r8
            java.lang.String r2 = r8.b()     // Catch:{ Exception -> 0x00de }
            r3 = 0
            android.content.Intent r2 = com.igexin.push.util.b.a((java.lang.String) r2, (int) r3)     // Catch:{ Exception -> 0x00de }
            java.lang.String r4 = r8.a()     // Catch:{ Exception -> 0x009d }
            java.lang.String r5 = "0"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x003a
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r2.setFlags(r1)     // Catch:{ Exception -> 0x009d }
            android.content.Context r1 = com.igexin.push.core.d.e     // Catch:{ Exception -> 0x009d }
            r1.startActivity(r2)     // Catch:{ Exception -> 0x009d }
            com.igexin.push.core.a.e r1 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x009d }
            java.lang.String r2 = r7.getTaskId()     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = r7.getMessageId()     // Catch:{ Exception -> 0x009d }
        L_0x0031:
            java.lang.String r5 = r8.getDoActionId()     // Catch:{ Exception -> 0x009d }
        L_0x0035:
            r1.a((java.lang.String) r2, (java.lang.String) r4, (java.lang.String) r5)     // Catch:{ Exception -> 0x009d }
            goto L_0x00de
        L_0x003a:
            java.lang.String r4 = r8.a()     // Catch:{ Exception -> 0x009d }
            java.lang.String r5 = "1"
            boolean r4 = r4.equals(r5)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x00de
            android.content.Context r4 = com.igexin.push.core.d.e     // Catch:{ Exception -> 0x009d }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x009d }
            java.util.List r4 = r4.queryIntentServices(r2, r3)     // Catch:{ Exception -> 0x009d }
            if (r4 == 0) goto L_0x006a
            int r4 = r4.size()     // Catch:{ Exception -> 0x009d }
            if (r4 <= 0) goto L_0x006a
            android.content.Context r1 = com.igexin.push.core.d.e     // Catch:{ Exception -> 0x009d }
            r1.startService(r2)     // Catch:{ Exception -> 0x009d }
            com.igexin.push.core.a.e r1 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x009d }
            java.lang.String r2 = r7.getTaskId()     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = r7.getMessageId()     // Catch:{ Exception -> 0x009d }
            goto L_0x0031
        L_0x006a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009d }
            r2.<init>(r1)     // Catch:{ Exception -> 0x009d }
            java.lang.String r1 = r8.b()     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r1 = r1.append(r0)     // Catch:{ Exception -> 0x009d }
            java.lang.String r2 = r8.a()     // Catch:{ Exception -> 0x009d }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x009d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x009d }
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x009d }
            com.igexin.a.a.c.b.a((java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x009d }
            com.igexin.push.core.a.e r1 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x009d }
            java.lang.String r2 = r7.getTaskId()     // Catch:{ Exception -> 0x009d }
            java.lang.String r4 = r7.getMessageId()     // Catch:{ Exception -> 0x009d }
            java.lang.String r5 = r8.c()     // Catch:{ Exception -> 0x009d }
            goto L_0x0035
        L_0x009d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00de }
            r1.<init>()     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = a     // Catch:{ Exception -> 0x00de }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = "|executeAction err intent="
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.String r2 = r8.b()     // Catch:{ Exception -> 0x00de }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ Exception -> 0x00de }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x00de }
            java.lang.String r1 = r8.a()     // Catch:{ Exception -> 0x00de }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ Exception -> 0x00de }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00de }
            java.lang.Object[] r1 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00de }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x00de }
            com.igexin.push.core.a.e r0 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00de }
            java.lang.String r1 = r7.getTaskId()     // Catch:{ Exception -> 0x00de }
            java.lang.String r7 = r7.getMessageId()     // Catch:{ Exception -> 0x00de }
            java.lang.String r8 = r8.c()     // Catch:{ Exception -> 0x00de }
            r0.a((java.lang.String) r1, (java.lang.String) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x00de }
        L_0x00de:
            r7 = 1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.g.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
