package com.igexin.push.core.a.a;

import android.content.Intent;
import android.net.Uri;
import com.igexin.push.config.k;
import com.igexin.push.core.a;
import com.igexin.push.core.a.e;
import com.igexin.push.core.bean.BaseAction;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.core.d;
import org.json.JSONException;
import org.json.JSONObject;

public class g implements a {
    private static final String a = k.a;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0063, code lost:
        if (r12.contains(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        if (r12.contains(com.huawei.hms.framework.common.ContainerUtils.KEY_VALUE_DELIMITER) != false) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.igexin.push.core.bean.k r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r0 = r11.a()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            int r12 = r0.indexOf(r12)
            r1 = -1
            if (r12 != r1) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r2 = "&"
            int r3 = r0.indexOf(r2)
            r4 = 0
            java.lang.String r5 = "="
            r6 = 0
            if (r3 != r1) goto L_0x0036
            int r1 = r12 + -1
            java.lang.String r1 = r0.substring(r4, r1)
            java.lang.String r12 = r0.substring(r12)
            boolean r0 = r12.contains(r5)
            if (r0 == 0) goto L_0x00a4
        L_0x002b:
            int r0 = r12.indexOf(r5)
            int r0 = r0 + 1
            java.lang.String r6 = r12.substring(r0)
            goto L_0x00a4
        L_0x0036:
            int r7 = r12 + -1
            char r8 = r0.charAt(r7)
            r9 = 63
            if (r8 != r9) goto L_0x0066
            java.lang.String r1 = r0.substring(r4, r12)
            int r2 = r3 + 1
            java.lang.String r2 = r0.substring(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r12 = r0.substring(r12, r3)
            boolean r0 = r12.contains(r5)
            if (r0 == 0) goto L_0x00a4
            goto L_0x002b
        L_0x0066:
            char r3 = r0.charAt(r7)
            r8 = 38
            java.lang.String r9 = ""
            if (r3 != r8) goto L_0x00a3
            java.lang.String r3 = r0.substring(r4, r7)
            java.lang.String r12 = r0.substring(r12)
            int r0 = r12.indexOf(r2)
            if (r0 == r1) goto L_0x0086
            java.lang.String r9 = r12.substring(r0)
            java.lang.String r12 = r12.substring(r4, r0)
        L_0x0086:
            int r0 = r12.indexOf(r5)
            int r0 = r0 + 1
            java.lang.String r12 = r12.substring(r0)
            r6 = r12
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.StringBuilder r12 = r12.append(r3)
            java.lang.StringBuilder r12 = r12.append(r9)
            java.lang.String r1 = r12.toString()
            goto L_0x00a4
        L_0x00a3:
            r1 = r9
        L_0x00a4:
            r11.a((java.lang.String) r1)
            r11.b((java.lang.String) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.a.a.g.a(com.igexin.push.core.bean.k, java.lang.String):void");
    }

    public a a(PushTaskBean pushTaskBean, BaseAction baseAction) {
        return a.success;
    }

    public BaseAction a(JSONObject jSONObject) {
        try {
            if (!jSONObject.has("url") || !jSONObject.has("do") || !jSONObject.has("actionid")) {
                return null;
            }
            String string = jSONObject.getString("url");
            if (string.equals("")) {
                return null;
            }
            com.igexin.push.core.bean.k kVar = new com.igexin.push.core.bean.k();
            kVar.setType("startweb");
            kVar.setActionId(jSONObject.getString("actionid"));
            kVar.setDoActionId(jSONObject.getString("do"));
            kVar.a(string);
            if (jSONObject.has("is_withcid")) {
                if (jSONObject.getString("is_withcid").equals("true")) {
                    kVar.a(true);
                }
            }
            if (jSONObject.has("is_withnettype") && jSONObject.getString("is_withnettype").equals("true")) {
                kVar.b(true);
            }
            return kVar;
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean b(PushTaskBean pushTaskBean, BaseAction baseAction) {
        com.igexin.push.core.bean.k kVar = (com.igexin.push.core.bean.k) baseAction;
        a(kVar, "targetpkgname");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setPackage(kVar.b());
        intent.setData(Uri.parse(kVar.c()));
        try {
            d.e.startActivity(intent);
        } catch (Exception unused) {
        }
        if (baseAction.getDoActionId().equals("")) {
            return true;
        }
        e.a().a(pushTaskBean.getTaskId(), pushTaskBean.getMessageId(), baseAction.getDoActionId());
        return true;
    }
}
