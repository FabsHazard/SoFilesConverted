package com.igexin.push.core.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.igexin.push.core.a;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.bean.i;
import com.igexin.push.util.n;
import org.json.JSONException;
import org.json.JSONObject;

public class h implements a {
    private static final String a = "com.igexin.push.core.a.a.h";

    private static void a(Context context, String str) {
        try {
            PackageInfo b = n.b(context);
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(b.packageName);
            ResolveInfo next = context.getPackageManager().queryIntentActivities(intent, 0).iterator().next();
            if (next != null) {
                String str2 = next.activityInfo.packageName;
                String str3 = next.activityInfo.name;
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setFlags(270532608);
                intent2.setComponent(new ComponentName(str2, str3));
                context.startActivity(intent2);
            }
        } catch (Exception unused) {
        }
    }

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            i iVar = new i();
            iVar.setType("startapp");
            iVar.setActionId(jSONObject.getString("actionid"));
            iVar.setDoActionId(jSONObject.getString("do"));
            if (jSONObject.has("appstartupid")) {
                iVar.a(jSONObject.getJSONObject("appstartupid").getString("android"));
            }
            if (jSONObject.has("is_autostart")) {
                iVar.d(jSONObject.getString("is_autostart"));
            }
            if (jSONObject.has(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID)) {
                iVar.b(jSONObject.getString(MLApplicationSetting.BundleKeyConstants.AppInfo.APPID));
            }
            if (jSONObject.has("noinstall_action")) {
                iVar.c(jSONObject.getString("noinstall_action"));
            }
            return iVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x004a A[SYNTHETIC, Splitter:B:12:0x004a] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086 A[Catch:{ Exception -> 0x00d4 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(com.igexin.push.core.bean.PushTaskBean r9, com.igexin.push.core.bean.BaseAction r10) {
        /*
            r8 = this;
            r0 = 1
            if (r9 == 0) goto L_0x00d4
            if (r10 == 0) goto L_0x00d4
            r1 = r10
            com.igexin.push.core.bean.i r1 = (com.igexin.push.core.bean.i) r1
            java.lang.String r2 = r1.b()
            java.lang.String r3 = ""
            boolean r3 = r2.equals(r3)
            r4 = 0
            if (r3 == 0) goto L_0x0019
            java.lang.String r2 = com.igexin.push.core.d.a
        L_0x0017:
            r3 = r0
            goto L_0x0027
        L_0x0019:
            java.lang.String r3 = com.igexin.push.core.d.a
            java.lang.String r5 = r1.b()
            boolean r3 = r3.equals(r5)
            if (r3 == 0) goto L_0x0026
            goto L_0x0017
        L_0x0026:
            r3 = r4
        L_0x0027:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "doStartApp|"
            r5.<init>(r6)
            java.lang.StringBuilder r5 = r5.append(r3)
            java.lang.String r6 = "|"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r2)
            java.lang.String r5 = r5.toString()
            java.lang.Object[] r4 = new java.lang.Object[r4]
            com.igexin.a.a.c.b.a((java.lang.String) r5, (java.lang.Object[]) r4)
            java.lang.String r4 = "true"
            r5 = 0
            if (r3 == 0) goto L_0x0086
            com.igexin.push.core.r r3 = com.igexin.push.core.r.a()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r6 = r9.getTaskId()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r7 = r9.getMessageId()     // Catch:{ Exception -> 0x00d4 }
            r3.a((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x00d4 }
            com.igexin.push.core.bean.i r10 = (com.igexin.push.core.bean.i) r10     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = r10.d()     // Catch:{ Exception -> 0x00d4 }
            boolean r10 = r10.equals(r4)     // Catch:{ Exception -> 0x00d4 }
            if (r10 == 0) goto L_0x006c
            android.content.Context r10 = com.igexin.push.core.d.e     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r2 = com.igexin.push.core.d.c     // Catch:{ Exception -> 0x00d4 }
            a((android.content.Context) r10, (java.lang.String) r2)     // Catch:{ Exception -> 0x00d4 }
        L_0x006c:
            java.lang.String r10 = r1.getDoActionId()     // Catch:{ Exception -> 0x00d4 }
            if (r10 == 0) goto L_0x00d4
            com.igexin.push.core.a.e r10 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r2 = r9.getTaskId()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r9 = r9.getMessageId()     // Catch:{ Exception -> 0x00d4 }
        L_0x007e:
            java.lang.String r1 = r1.getDoActionId()     // Catch:{ Exception -> 0x00d4 }
        L_0x0082:
            r10.a((java.lang.String) r2, (java.lang.String) r9, (java.lang.String) r1)     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d4
        L_0x0086:
            com.igexin.push.core.r r10 = com.igexin.push.core.r.a()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r3 = r9.getTaskId()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r6 = r9.getMessageId()     // Catch:{ Exception -> 0x00d4 }
            r10.a((java.lang.String) r3, (java.lang.String) r6, (java.lang.String) r2, (java.lang.String) r5)     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r10 = r1.d()     // Catch:{ Exception -> 0x00d4 }
            boolean r10 = r10.equals(r4)     // Catch:{ Exception -> 0x00d4 }
            if (r10 == 0) goto L_0x00c1
            java.lang.String r10 = r1.a()     // Catch:{ Exception -> 0x00d4 }
            boolean r10 = com.igexin.push.util.a.a((java.lang.String) r10)     // Catch:{ Exception -> 0x00d4 }
            if (r10 == 0) goto L_0x00aa
            goto L_0x00c1
        L_0x00aa:
            java.lang.String r10 = r1.c()     // Catch:{ Exception -> 0x00d4 }
            if (r10 == 0) goto L_0x00d4
            com.igexin.push.core.a.e r10 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r2 = r9.getTaskId()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r9 = r9.getMessageId()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r1 = r1.c()     // Catch:{ Exception -> 0x00d4 }
            goto L_0x0082
        L_0x00c1:
            java.lang.String r10 = r1.getDoActionId()     // Catch:{ Exception -> 0x00d4 }
            if (r10 == 0) goto L_0x00d4
            com.igexin.push.core.a.e r10 = com.igexin.push.core.a.e.a()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r2 = r9.getTaskId()     // Catch:{ Exception -> 0x00d4 }
            java.lang.String r9 = r9.getMessageId()     // Catch:{ Exception -> 0x00d4 }
            goto L_0x007e
        L_0x00d4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.h.b(com.igexin.push.core.bean.PushTaskBean, com.igexin.push.core.bean.BaseAction):boolean");
    }
}
