package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MultiFormatUPCEANReader */
public final class b5 extends g5 {
    private final q7[] a;

    public b5(Map<l1, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(l1.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new o2());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new l7());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new q2());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new s7());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new o2());
            arrayList.add(new q2());
            arrayList.add(new s7());
        }
        this.a = (q7[]) arrayList.toArray(new q7[arrayList.size()]);
    }

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        Collection collection;
        boolean z;
        Iterator<int[]> it = q7.b(rVar).iterator();
        while (it.hasNext()) {
            int[] next = it.next();
            q7[] q7VarArr = this.a;
            int i2 = 0;
            while (true) {
                if (i2 < q7VarArr.length) {
                    try {
                        s6 a2 = q7VarArr[i2].a(i, rVar, next, map);
                        boolean z2 = a2.c() == BarcodeFormat.EAN_13 && a2.k().charAt(0) == '0';
                        if (map == null) {
                            collection = null;
                        } else {
                            collection = (Collection) map.get(l1.POSSIBLE_FORMATS);
                        }
                        if (collection != null) {
                            if (!collection.contains(BarcodeFormat.UPC_A)) {
                                z = false;
                                return (z2 || !z) ? a2 : new s6(a2.k().substring(1), a2.i(), a2.j(), BarcodeFormat.UPC_A);
                            }
                        }
                        z = true;
                        if (z2) {
                        }
                    } catch (a unused) {
                        i2++;
                    }
                }
            }
        }
        throw a.a();
    }
}
