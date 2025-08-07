package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BarcodeValue */
final class m {
    private final Map<Integer, Integer> a = new HashMap();

    m() {
    }

    /* access modifiers changed from: package-private */
    public void a(int i) {
        Integer num = this.a.get(Integer.valueOf(i));
        if (num == null) {
            num = 0;
        }
        this.a.put(Integer.valueOf(i), Integer.valueOf(num.intValue() + 1));
    }

    /* access modifiers changed from: package-private */
    public int[] a() {
        ArrayList arrayList = new ArrayList();
        int i = -1;
        for (Map.Entry next : this.a.entrySet()) {
            if (((Integer) next.getValue()).intValue() > i) {
                i = ((Integer) next.getValue()).intValue();
                arrayList.clear();
                arrayList.add((Integer) next.getKey());
            } else if (((Integer) next.getValue()).intValue() == i) {
                arrayList.add((Integer) next.getKey());
            }
        }
        return n5.a((Collection<Integer>) arrayList);
    }
}
