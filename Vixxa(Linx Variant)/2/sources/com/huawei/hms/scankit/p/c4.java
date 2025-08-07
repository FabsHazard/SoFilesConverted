package com.huawei.hms.scankit.p;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.UByte;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: HighLevelEncoder */
public final class c4 {
    static final String[] b = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] c = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};
    private static final int[][] d;
    static final int[][] e;
    private final byte[] a;

    /* compiled from: HighLevelEncoder */
    static class a<State> implements Comparator<b7> {
        a() {
        }

        /* renamed from: a */
        public int compare(b7 b7Var, b7 b7Var2) {
            return b7Var.b() - b7Var2.b();
        }
    }

    static {
        int[] iArr = new int[2];
        iArr[1] = 256;
        iArr[0] = 5;
        int[][] iArr2 = (int[][]) Array.newInstance(Integer.TYPE, iArr);
        d = iArr2;
        iArr2[0][32] = 1;
        for (int i = 65; i <= 90; i++) {
            d[0][i] = i - 63;
        }
        d[1][32] = 1;
        for (int i2 = 97; i2 <= 122; i2++) {
            d[1][i2] = i2 - 95;
        }
        d[2][32] = 1;
        for (int i3 = 48; i3 <= 57; i3++) {
            d[2][i3] = i3 - 46;
        }
        int[] iArr3 = d[2];
        iArr3[44] = 12;
        iArr3[46] = 13;
        int[] iArr4 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, WebSocketProtocol.PAYLOAD_SHORT, 127};
        for (int i4 = 0; i4 < 28; i4++) {
            d[3][iArr4[i4]] = i4;
        }
        int[] iArr5 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i5 = 0; i5 < 31; i5++) {
            int i6 = iArr5[i5];
            if (i6 > 0) {
                d[4][i6] = i5;
            }
        }
        int[] iArr6 = new int[2];
        iArr6[1] = 6;
        iArr6[0] = 6;
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, iArr6);
        e = iArr7;
        for (int[] fill : iArr7) {
            Arrays.fill(fill, -1);
        }
        int[][] iArr8 = e;
        if (w7.a(iArr8, 0) && w7.a(iArr8[0], 4)) {
            iArr8[0][4] = 0;
        }
        if (w7.a(iArr8, 1) && w7.a(iArr8[1], 4)) {
            iArr8[1][4] = 0;
        }
        if (w7.a(iArr8, 1) && w7.a(iArr8[1], 0)) {
            iArr8[1][0] = 28;
        }
        if (w7.a(iArr8, 3) && w7.a(iArr8[3], 4)) {
            iArr8[3][4] = 0;
        }
        if (w7.a(iArr8, 2) && w7.a(iArr8[2], 4)) {
            iArr8[2][4] = 0;
        }
        if (w7.a(iArr8, 2) && w7.a(iArr8[2], 0)) {
            iArr8[2][0] = 15;
        }
    }

    public c4(byte[] bArr) {
        this.a = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.r a() {
        /*
            r8 = this;
            com.huawei.hms.scankit.p.b7 r0 = com.huawei.hms.scankit.p.b7.e
            java.util.List r0 = java.util.Collections.singletonList(r0)
            r1 = 0
            r2 = r1
        L_0x0008:
            byte[] r3 = r8.a
            int r4 = r3.length
            if (r2 >= r4) goto L_0x004d
            int r4 = r2 + 1
            int r5 = r3.length
            if (r4 >= r5) goto L_0x0015
            byte r5 = r3[r4]
            goto L_0x0016
        L_0x0015:
            r5 = r1
        L_0x0016:
            byte r3 = r3[r2]
            r6 = 13
            if (r3 == r6) goto L_0x0037
            r6 = 44
            r7 = 32
            if (r3 == r6) goto L_0x0033
            r6 = 46
            if (r3 == r6) goto L_0x002f
            r6 = 58
            if (r3 == r6) goto L_0x002b
            goto L_0x003d
        L_0x002b:
            if (r5 != r7) goto L_0x003d
            r3 = 5
            goto L_0x003e
        L_0x002f:
            if (r5 != r7) goto L_0x003d
            r3 = 3
            goto L_0x003e
        L_0x0033:
            if (r5 != r7) goto L_0x003d
            r3 = 4
            goto L_0x003e
        L_0x0037:
            r3 = 10
            if (r5 != r3) goto L_0x003d
            r3 = 2
            goto L_0x003e
        L_0x003d:
            r3 = r1
        L_0x003e:
            if (r3 <= 0) goto L_0x0046
            java.util.Collection r0 = a((java.lang.Iterable<com.huawei.hms.scankit.p.b7>) r0, (int) r2, (int) r3)
            r2 = r4
            goto L_0x004a
        L_0x0046:
            java.util.Collection r0 = r8.a(r0, r2)
        L_0x004a:
            int r2 = r2 + 1
            goto L_0x0008
        L_0x004d:
            com.huawei.hms.scankit.p.c4$a r1 = new com.huawei.hms.scankit.p.c4$a
            r1.<init>()
            java.lang.Object r0 = java.util.Collections.min(r0, r1)
            com.huawei.hms.scankit.p.b7 r0 = (com.huawei.hms.scankit.p.b7) r0
            byte[] r1 = r8.a
            com.huawei.hms.scankit.p.r r0 = r0.a((byte[]) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.c4.a():com.huawei.hms.scankit.p.r");
    }

    private Collection<b7> a(Iterable<b7> iterable, int i) {
        LinkedList linkedList = new LinkedList();
        for (b7 a2 : iterable) {
            a(a2, i, (Collection<b7>) linkedList);
        }
        return a(linkedList);
    }

    private void a(b7 b7Var, int i, Collection<b7> collection) {
        if (w7.a(this.a, i)) {
            char c2 = (char) (this.a[i] & UByte.MAX_VALUE);
            int[][] iArr = d;
            boolean z = w7.a(iArr, b7Var.c()) && w7.a(iArr[b7Var.c()], (int) c2) && iArr[b7Var.c()][c2] > 0;
            b7 b7Var2 = null;
            for (int i2 = 0; i2 <= 4; i2++) {
                int[][] iArr2 = d;
                int i3 = (!w7.a(iArr2, i2) || !w7.a(iArr2[i2], (int) c2)) ? 0 : iArr2[i2][c2];
                if (i3 > 0) {
                    if (b7Var2 == null) {
                        b7Var2 = b7Var.b(i);
                    }
                    if (!z || i2 == b7Var.c() || i2 == 2) {
                        collection.add(b7Var2.a(i2, i3));
                    }
                    if (!z && e[b7Var.c()][i2] >= 0) {
                        collection.add(b7Var2.b(i2, i3));
                    }
                }
            }
            int[][] iArr3 = d;
            if (w7.a(iArr3, b7Var.c()) && w7.a(iArr3[b7Var.c()], (int) c2)) {
                if (b7Var.a() > 0 || iArr3[b7Var.c()][c2] == 0) {
                    collection.add(b7Var.a(i));
                }
            }
        }
    }

    private static Collection<b7> a(Iterable<b7> iterable, int i, int i2) {
        LinkedList linkedList = new LinkedList();
        for (b7 a2 : iterable) {
            a(a2, i, i2, linkedList);
        }
        return a(linkedList);
    }

    private static void a(b7 b7Var, int i, int i2, Collection<b7> collection) {
        b7 b2 = b7Var.b(i);
        collection.add(b2.a(4, i2));
        if (b7Var.c() != 4) {
            collection.add(b2.b(4, i2));
        }
        if (i2 == 3 || i2 == 4) {
            collection.add(b2.a(2, 16 - i2).a(2, 1));
        }
        if (b7Var.a() > 0) {
            collection.add(b7Var.a(i).a(i + 1));
        }
    }

    private static Collection<b7> a(Iterable<b7> iterable) {
        LinkedList linkedList = new LinkedList();
        for (b7 next : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    linkedList.add(next);
                    break;
                }
                b7 b7Var = (b7) it.next();
                if (b7Var.a(next)) {
                    break;
                } else if (next.a(b7Var)) {
                    it.remove();
                }
            }
        }
        return linkedList;
    }
}
