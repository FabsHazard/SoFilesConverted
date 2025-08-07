package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

public class i1 {
    private String a;
    private String b;
    private String c;
    private String d;
    private long e;

    public i1(String str, String str2, String str3, String str4, long j) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = j;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.c);
        b1Var.d(this.b);
        b1Var.a(this.d);
        b1Var.c(String.valueOf(this.e));
        if ("oper".equals(this.b) && z.i(this.a, "oper")) {
            p0 a2 = y.a().a(this.a, this.e);
            String a3 = a2.a();
            Boolean valueOf = Boolean.valueOf(a2.b());
            b1Var.f(a3);
            b1Var.e(String.valueOf(valueOf));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.a, this.b, q0.g(), arrayList, replace).a();
    }
}
