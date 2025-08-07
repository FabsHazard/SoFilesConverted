package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultiFormatOneDReader */
public final class z4 extends g5 {
    private static final g5[] b = new g5[0];
    private final g5[] a;

    public z4(Map<l1, ?> map) {
        Collection collection;
        if (map == null) {
            collection = null;
        } else {
            collection = (Collection) map.get(l1.POSSIBLE_FORMATS);
        }
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new b5(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new t0(false));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new v0());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new r0());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new j4());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new p0());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new b5(map));
            arrayList.add(new t0());
            arrayList.add(new p0());
            arrayList.add(new v0());
            arrayList.add(new r0());
            arrayList.add(new j4());
        }
        this.a = (g5[]) arrayList.toArray(b);
    }

    public s6 a(int i, r rVar, Map<l1, ?> map) throws a {
        g5[] g5VarArr = this.a;
        int i2 = 0;
        while (i2 < g5VarArr.length) {
            try {
                return g5VarArr[i2].a(i, rVar, map);
            } catch (a unused) {
                i2++;
            }
        }
        throw a.a();
    }
}
