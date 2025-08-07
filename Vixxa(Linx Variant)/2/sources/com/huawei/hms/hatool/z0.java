package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.Map;

public class z0 {
    private String a;
    public l1 b;

    public z0(String str) {
        this.a = str;
        this.b = new l1(str);
        s.c().a(this.a, this.b);
    }

    private s0 b(int i) {
        if (i == 0) {
            return this.b.c();
        }
        if (i == 1) {
            return this.b.b();
        }
        if (i == 2) {
            return this.b.d();
        }
        if (i != 3) {
            return null;
        }
        return this.b.a();
    }

    private boolean c(int i) {
        String str;
        if (i != 2) {
            s0 b2 = b(i);
            if (b2 != null && !TextUtils.isEmpty(b2.h())) {
                return true;
            }
            str = "verifyURL(): URL check failed. type: " + i;
        } else if ("_default_config_tag".equals(this.a)) {
            return true;
        } else {
            str = "verifyURL(): type: preins. Only default config can report Pre-install data.";
        }
        v.e("hmsSdk", str);
        return false;
    }

    public void a(int i) {
        v.d("hmsSdk", "onReport. TAG: " + this.a + ", TYPE: " + i);
        g0.a().a(this.a, i);
    }

    public void a(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onEvent. TAG: " + this.a + ", TYPE: " + i + ", eventId : " + str);
        if (e1.a(str) || !c(i)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a + ", TYPE: " + i);
            return;
        }
        if (!e1.a((Map<String, String>) linkedHashMap)) {
            v.e("hmsSdk", "onEvent() parameter mapValue will be cleared.TAG: " + this.a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        g0.a().a(this.a, i, str, linkedHashMap);
    }

    public void a(Context context, String str, String str2) {
        v.d("hmsSdk", "onEvent(context). TAG: " + this.a + ", eventId : " + str);
        if (context == null) {
            v.e("hmsSdk", "context is null in onevent ");
        } else if (e1.a(str) || !c(0)) {
            v.e("hmsSdk", "onEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a);
        } else {
            if (!e1.a("value", str2, 65536)) {
                v.e("hmsSdk", "onEvent() parameter VALUE is overlong, content will be cleared.TAG: " + this.a);
                str2 = "";
            }
            g0.a().a(this.a, context, str, str2);
        }
    }

    public void a(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf() is executed.TAG : " + this.a);
        if (s0Var == null) {
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setMaintConf(): config for maint is null!");
            this.b.a((s0) null);
            return;
        }
        this.b.a(s0Var);
    }

    public void b(int i, String str, LinkedHashMap<String, String> linkedHashMap) {
        v.d("hmsSdk", "onStreamEvent. TAG: " + this.a + ", TYPE: " + i + ", eventId : " + str);
        if (e1.a(str) || !c(i)) {
            v.e("hmsSdk", "onStreamEvent() parameters check fail. Nothing will be recorded.TAG: " + this.a + ", TYPE: " + i);
            return;
        }
        if (!e1.a((Map<String, String>) linkedHashMap)) {
            v.e("hmsSdk", "onStreamEvent() parameter mapValue will be cleared.TAG: " + this.a + ", TYPE: " + i);
            linkedHashMap = null;
        }
        g0.a().b(this.a, i, str, linkedHashMap);
    }

    public void b(s0 s0Var) {
        v.c("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf() is executed.TAG: " + this.a);
        if (s0Var == null) {
            this.b.b((s0) null);
            v.e("hmsSdk", "HiAnalyticsInstanceImpl.setOperConf(): config for oper is null!");
            return;
        }
        this.b.b(s0Var);
    }
}
