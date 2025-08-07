package com.igexin.push.core.a.a;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.igexin.a.a.c.b;
import com.igexin.push.config.k;
import com.igexin.push.core.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.l;
import com.igexin.push.core.c;
import org.json.JSONObject;

public class i implements a {
    private static final String a = k.a;

    private void a(String... strArr) {
        try {
            b.a(a + "|del condition taskid = " + strArr.toString(), new Object[0]);
            c.a().k().a(CrashHianalyticsData.MESSAGE, new String[]{"taskid"}, strArr);
        } catch (Throwable th) {
            b.a(a + "|del condition" + th.toString(), new Object[0]);
        }
    }

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("do") || !jSONObject.has("actionid") || !jSONObject.has("taskid")) {
                return null;
            }
            l lVar = new l();
            lVar.setType("terminatetask");
            lVar.setActionId(jSONObject.getString("actionid"));
            lVar.setDoActionId(jSONObject.getString("do"));
            lVar.a(jSONObject.getString("taskid"));
            lVar.a(jSONObject.optBoolean("force"));
            return lVar;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008d, code lost:
        if (r3 == null) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0094, code lost:
        if (r3 != null) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.igexin.push.core.bean.PushTaskBean r14, com.igexin.push.core.bean.BaseAction r15) {
        /*
            r13 = this;
            r0 = r15
            com.igexin.push.core.bean.l r0 = (com.igexin.push.core.bean.l) r0
            java.lang.String r1 = r0.a()
            android.content.Context r2 = com.igexin.push.core.d.e
            java.lang.String r3 = "notification"
            java.lang.Object r2 = r2.getSystemService(r3)
            android.app.NotificationManager r2 = (android.app.NotificationManager) r2
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x0097
            r3 = 0
            com.igexin.push.core.c r6 = com.igexin.push.core.c.a()     // Catch:{ all -> 0x0093 }
            com.igexin.push.b.b r7 = r6.k()     // Catch:{ all -> 0x0093 }
            java.lang.String r8 = "message"
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "taskid"
            r9[r5] = r6     // Catch:{ all -> 0x0093 }
            java.lang.String[] r10 = new java.lang.String[r4]     // Catch:{ all -> 0x0093 }
            r10[r5] = r1     // Catch:{ all -> 0x0093 }
            java.lang.String r12 = "id ASC"
            r11 = 0
            android.database.Cursor r3 = r7.a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0093 }
            if (r3 == 0) goto L_0x008c
            boolean r6 = r3.moveToFirst()     // Catch:{ all -> 0x0093 }
            if (r6 == 0) goto L_0x0050
            java.lang.String r6 = "messageid"
            int r6 = r3.getColumnIndex(r6)     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = r3.getString(r6)     // Catch:{ all -> 0x0093 }
            com.igexin.push.core.a.e r7 = com.igexin.push.core.a.e.a()     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = r7.a((java.lang.String) r1, (java.lang.String) r6)     // Catch:{ all -> 0x0093 }
            goto L_0x0052
        L_0x0050:
            java.lang.String r6 = ""
        L_0x0052:
            boolean r7 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x0093 }
            if (r7 != 0) goto L_0x008c
            java.util.Map<java.lang.String, com.igexin.push.core.bean.PushTaskBean> r7 = com.igexin.push.core.d.ac     // Catch:{ all -> 0x0093 }
            java.lang.Object r6 = r7.get(r6)     // Catch:{ all -> 0x0093 }
            com.igexin.push.core.bean.PushTaskBean r6 = (com.igexin.push.core.bean.PushTaskBean) r6     // Catch:{ all -> 0x0093 }
            if (r6 == 0) goto L_0x0065
            r6.setStop(r4)     // Catch:{ all -> 0x0093 }
        L_0x0065:
            java.lang.String[] r6 = new java.lang.String[r4]     // Catch:{ all -> 0x0093 }
            r6[r5] = r1     // Catch:{ all -> 0x0093 }
            r13.a((java.lang.String[]) r6)     // Catch:{ all -> 0x0093 }
            java.util.Map<java.lang.String, java.lang.Integer> r6 = com.igexin.push.core.d.ad     // Catch:{ all -> 0x0093 }
            boolean r6 = r6.containsKey(r1)     // Catch:{ all -> 0x0093 }
            if (r6 == 0) goto L_0x008c
            java.util.Map<java.lang.String, java.lang.Integer> r6 = com.igexin.push.core.d.ad     // Catch:{ all -> 0x0093 }
            java.lang.Object r6 = r6.get(r1)     // Catch:{ all -> 0x0093 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0093 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0093 }
            r2.cancel(r6)     // Catch:{ all -> 0x0093 }
            java.util.Map<java.lang.String, java.lang.Integer> r6 = com.igexin.push.core.d.ad     // Catch:{ all -> 0x008a }
            r6.remove(r1)     // Catch:{ all -> 0x008a }
            r1 = r4
            goto L_0x008d
        L_0x008a:
            r1 = r4
            goto L_0x0094
        L_0x008c:
            r1 = r5
        L_0x008d:
            if (r3 == 0) goto L_0x0098
        L_0x008f:
            r3.close()
            goto L_0x0098
        L_0x0093:
            r1 = r5
        L_0x0094:
            if (r3 == 0) goto L_0x0098
            goto L_0x008f
        L_0x0097:
            r1 = r5
        L_0x0098:
            if (r1 != 0) goto L_0x00c2
            boolean r0 = r0.b()     // Catch:{ all -> 0x00c2 }
            if (r0 == 0) goto L_0x00c2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c2 }
            r0.<init>()     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = a     // Catch:{ all -> 0x00c2 }
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x00c2 }
            java.lang.String r1 = " | cancelAll()"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x00c2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00c2 }
            java.lang.Object[] r1 = new java.lang.Object[r5]     // Catch:{ all -> 0x00c2 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ all -> 0x00c2 }
            r2.cancelAll()     // Catch:{ all -> 0x00c2 }
            android.content.Context r0 = com.igexin.push.core.d.e     // Catch:{ all -> 0x00c2 }
            com.igexin.assist.sdk.a.k(r0)     // Catch:{ all -> 0x00c2 }
        L_0x00c2:
            java.lang.String r0 = r15.getDoActionId()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x00df
            com.igexin.push.core.w r0 = com.igexin.push.core.w.a()
            java.lang.String r1 = r14.getTaskId()
            java.lang.String r14 = r14.getMessageId()
            java.lang.String r15 = r15.getDoActionId()
            r0.b(r1, r14, r15)
        L_0x00df:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.i.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
