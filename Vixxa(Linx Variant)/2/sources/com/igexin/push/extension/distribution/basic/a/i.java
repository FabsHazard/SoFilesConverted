package com.igexin.push.extension.distribution.basic.a;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.igexin.a.a.c.b;
import com.igexin.push.core.a.a.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.extension.distribution.basic.c.e;
import org.json.JSONObject;

public class i implements a {
    private static final String a = ("EXT-" + i.class.getName());

    private void a(String str) {
        if (e.l.a()) {
            try {
                b.a(a + "|del condition taskid = " + str, new Object[0]);
                e.l.a(CrashHianalyticsData.MESSAGE, new String[]{"taskid"}, new String[]{str});
                e.l.close();
            } catch (Throwable th) {
                b.a(a + "|del condition" + th.toString(), new Object[0]);
            }
        }
    }

    public com.igexin.push.core.a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return com.igexin.push.core.a.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("taskid")) {
                return null;
            }
            com.igexin.push.extension.distribution.basic.b.e eVar = new com.igexin.push.extension.distribution.basic.b.e();
            eVar.setType("terminatetask");
            eVar.setActionId(jSONObject.getString("actionid"));
            eVar.setDoActionId(jSONObject.getString("do"));
            eVar.a(jSONObject.getString("taskid"));
            eVar.a(jSONObject.optBoolean("force"));
            return eVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e9, code lost:
        if (r4 == null) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00eb, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f1, code lost:
        if (r4 != null) goto L_0x00eb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.igexin.push.core.bean.PushTaskBean r16, com.igexin.push.core.bean.BaseAction r17) {
        /*
            r15 = this;
            r0 = r17
            com.igexin.push.extension.distribution.basic.b.e r0 = (com.igexin.push.extension.distribution.basic.b.e) r0
            java.lang.String r1 = r0.a()
            android.content.Context r2 = com.igexin.push.core.d.e
            java.lang.String r3 = "notification"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2
            boolean r4 = android.text.TextUtils.isEmpty(r1)
            r5 = 1
            java.lang.String r6 = ""
            r7 = 0
            if (r4 != 0) goto L_0x00f4
            r4 = 0
            com.igexin.push.core.c r8 = com.igexin.push.core.c.a()     // Catch:{ all -> 0x00ef }
            com.igexin.push.b.b r9 = r8.k()     // Catch:{ all -> 0x00ef }
            java.lang.String r10 = "message"
            java.lang.String[] r11 = new java.lang.String[r5]     // Catch:{ all -> 0x00ef }
            java.lang.String r8 = "taskid"
            r11[r7] = r8     // Catch:{ all -> 0x00ef }
            java.lang.String[] r12 = new java.lang.String[r5]     // Catch:{ all -> 0x00ef }
            r12[r7] = r1     // Catch:{ all -> 0x00ef }
            java.lang.String r14 = "id ASC"
            r13 = 0
            android.database.Cursor r4 = r9.a(r10, r11, r12, r13, r14)     // Catch:{ all -> 0x00ef }
            if (r4 == 0) goto L_0x00e7
            boolean r8 = r4.moveToFirst()     // Catch:{ all -> 0x00ef }
            if (r8 == 0) goto L_0x0053
            java.lang.String r8 = "messageid"
            int r8 = r4.getColumnIndex(r8)     // Catch:{ all -> 0x00ef }
            java.lang.String r8 = r4.getString(r8)     // Catch:{ all -> 0x00ef }
            com.igexin.push.core.a.e r9 = com.igexin.push.core.a.e.a()     // Catch:{ all -> 0x00ef }
            java.lang.String r8 = r9.a((java.lang.String) r1, (java.lang.String) r8)     // Catch:{ all -> 0x00ef }
            goto L_0x0054
        L_0x0053:
            r8 = r6
        L_0x0054:
            boolean r9 = r8.equals(r6)     // Catch:{ all -> 0x00ef }
            if (r9 != 0) goto L_0x00e7
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r9 = com.igexin.push.core.d.ac     // Catch:{ all -> 0x00ef }
            java.lang.Object r8 = r9.get(r8)     // Catch:{ all -> 0x00ef }
            com.igexin.push.core.bean.PushTaskBean r8 = (com.igexin.push.core.bean.PushTaskBean) r8     // Catch:{ all -> 0x00ef }
            if (r8 == 0) goto L_0x00e7
            r8.setStop(r5)     // Catch:{ all -> 0x00ef }
            r9 = r15
            r15.a((java.lang.String) r1)     // Catch:{ all -> 0x00f0 }
            int r10 = r8.getPerActionid()     // Catch:{ all -> 0x00f0 }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x00f0 }
            java.lang.String r11 = "0"
            boolean r11 = r10.equals(r11)     // Catch:{ all -> 0x00f0 }
            if (r11 != 0) goto L_0x00c3
            com.igexin.push.core.bean.BaseAction r8 = r8.getBaseAction(r10)     // Catch:{ all -> 0x00f0 }
            java.lang.String r8 = r8.getType()     // Catch:{ all -> 0x00f0 }
            boolean r3 = r8.equals(r3)     // Catch:{ all -> 0x00f0 }
            if (r3 == 0) goto L_0x00c3
            java.util.Map<java.lang.String, java.lang.Integer> r3 = com.igexin.push.core.d.ad     // Catch:{ all -> 0x00f0 }
            boolean r3 = r3.containsKey(r1)     // Catch:{ all -> 0x00f0 }
            if (r3 == 0) goto L_0x00c3
            java.util.Map<java.lang.String, java.lang.Integer> r3 = com.igexin.push.core.d.ad     // Catch:{ all -> 0x00f0 }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x00f0 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x00f0 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x00f0 }
            r2.cancel(r3)     // Catch:{ all -> 0x00f0 }
            java.util.Map<java.lang.String, java.lang.Integer> r3 = com.igexin.push.core.d.ad     // Catch:{ all -> 0x00c1 }
            r3.remove(r1)     // Catch:{ all -> 0x00c1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r3.<init>()     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = a     // Catch:{ all -> 0x00c1 }
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ all -> 0x00c1 }
            java.lang.String r8 = "remove terminateTaskId from cache"
            java.lang.StringBuilder r3 = r3.append(r8)     // Catch:{ all -> 0x00c1 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x00c1 }
            java.lang.Object[] r8 = new java.lang.Object[r7]     // Catch:{ all -> 0x00c1 }
            com.igexin.a.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r8)     // Catch:{ all -> 0x00c1 }
            r3 = r5
            goto L_0x00c4
        L_0x00c1:
            r3 = r5
            goto L_0x00f1
        L_0x00c3:
            r3 = r7
        L_0x00c4:
            com.igexin.push.core.f.b r8 = com.igexin.push.core.f.b.a()     // Catch:{ all -> 0x00f1 }
            r10 = 11111111(0xa98ac7, double:5.489618E-317)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x00f1 }
            com.igexin.push.core.f.a r8 = r8.a((java.lang.Long) r10)     // Catch:{ all -> 0x00f1 }
            if (r8 == 0) goto L_0x00e9
            java.lang.String r10 = r8.b()     // Catch:{ all -> 0x00f1 }
            boolean r1 = r10.equals(r1)     // Catch:{ all -> 0x00f1 }
            if (r1 == 0) goto L_0x00e9
            com.igexin.push.core.f.b r1 = com.igexin.push.core.f.b.a()     // Catch:{ all -> 0x00f1 }
            r1.b(r8)     // Catch:{ all -> 0x00f1 }
            goto L_0x00e9
        L_0x00e7:
            r9 = r15
            r3 = r7
        L_0x00e9:
            if (r4 == 0) goto L_0x00f6
        L_0x00eb:
            r4.close()
            goto L_0x00f6
        L_0x00ef:
            r9 = r15
        L_0x00f0:
            r3 = r7
        L_0x00f1:
            if (r4 == 0) goto L_0x00f6
            goto L_0x00eb
        L_0x00f4:
            r9 = r15
            r3 = r7
        L_0x00f6:
            if (r3 != 0) goto L_0x0120
            boolean r0 = r0.b()     // Catch:{ all -> 0x0120 }
            if (r0 == 0) goto L_0x0120
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0120 }
            r0.<init>()     // Catch:{ all -> 0x0120 }
            java.lang.String r1 = a     // Catch:{ all -> 0x0120 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0120 }
            java.lang.String r1 = " | cancelAll()"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x0120 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0120 }
            java.lang.Object[] r1 = new java.lang.Object[r7]     // Catch:{ all -> 0x0120 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x0120 }
            r2.cancelAll()     // Catch:{ all -> 0x0120 }
            android.content.Context r0 = com.igexin.push.core.d.e     // Catch:{ all -> 0x0120 }
            com.igexin.push.extension.distribution.basic.g.a.c(r0)     // Catch:{ all -> 0x0120 }
        L_0x0120:
            java.lang.String r0 = r17.getDoActionId()
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x013d
            com.igexin.push.core.a.e r0 = com.igexin.push.core.a.e.a()
            java.lang.String r1 = r16.getTaskId()
            java.lang.String r2 = r16.getMessageId()
            java.lang.String r3 = r17.getDoActionId()
            r0.a((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3)
        L_0x013d:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.i.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
