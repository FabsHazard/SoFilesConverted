package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.microtech.aidexx.utils.TimeUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class u {
    private List<b1> a;
    private String b;
    private String c;
    private String d;

    public u(List<b1> list, String str, String str2, String str3) {
        this.a = list;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    private void a(List<b1> list, String str, String str2) {
        if (!list.isEmpty()) {
            int size = (list.size() / 500) + 1;
            for (int i = 0; i < size; i++) {
                int i2 = i * 500;
                List<b1> subList = list.subList(i2, Math.min(list.size(), i2 + 500));
                String replace = UUID.randomUUID().toString().replace("-", "");
                long currentTimeMillis = System.currentTimeMillis();
                long b2 = ((long) a1.b(str2, str)) * TimeUtils.oneDayMillis;
                ArrayList arrayList = new ArrayList();
                for (b1 next : subList) {
                    if (!c0.a(next.b(), currentTimeMillis, b2)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    new l0(str2, str, this.d, arrayList, replace).a();
                } else {
                    v.e("hmsSdk", "No data to report handler");
                }
            }
        }
    }

    public void a() {
        if ("_default_config_tag".equals(this.c)) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (b1 next : this.a) {
                String c2 = next.c();
                if (TextUtils.isEmpty(c2) || "oper".equals(c2)) {
                    arrayList4.add(next);
                } else if ("maint".equals(c2)) {
                    arrayList.add(next);
                } else if ("preins".equals(c2)) {
                    arrayList2.add(next);
                } else if ("diffprivacy".equals(c2)) {
                    arrayList3.add(next);
                }
            }
            a(arrayList4, "oper", "_default_config_tag");
            a(arrayList, "maint", "_default_config_tag");
            a(arrayList2, "preins", "_default_config_tag");
            a(arrayList3, "diffprivacy", "_default_config_tag");
            return;
        }
        a(this.a, this.c, this.b);
    }
}
