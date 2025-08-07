package com.tencent.bugly.proguard;

import com.github.mikephil.charting.utils.Utils;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class k {
    protected String a = "GBK";
    private ByteBuffer b;

    /* compiled from: BUGLY */
    public static class a {
        public byte a;
        public int b;
    }

    public k() {
    }

    public k(byte[] bArr) {
        this.b = ByteBuffer.wrap(bArr);
    }

    public k(byte[] bArr, byte b2) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.b = wrap;
        wrap.position(4);
    }

    public final void a(byte[] bArr) {
        ByteBuffer byteBuffer = this.b;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        this.b = ByteBuffer.wrap(bArr);
    }

    private static int a(a aVar, ByteBuffer byteBuffer) {
        byte b2 = byteBuffer.get();
        aVar.a = (byte) (b2 & 15);
        aVar.b = (b2 & 240) >> 4;
        if (aVar.b != 15) {
            return 1;
        }
        aVar.b = byteBuffer.get();
        return 2;
    }

    private void a(a aVar) {
        a(aVar, this.b);
    }

    private void a(int i) {
        ByteBuffer byteBuffer = this.b;
        byteBuffer.position(byteBuffer.position() + i);
    }

    private boolean b(int i) {
        try {
            a aVar = new a();
            while (true) {
                int a2 = a(aVar, this.b.duplicate());
                if (i <= aVar.b) {
                    break;
                } else if (aVar.a == 11) {
                    break;
                } else {
                    a(a2);
                    a(aVar.a);
                }
            }
            if (i == aVar.b) {
                return true;
            }
            return false;
        } catch (h | BufferUnderflowException unused) {
        }
    }

    private void a() {
        a aVar = new a();
        do {
            a(aVar);
            a(aVar.a);
        } while (aVar.a != 11);
    }

    private void b() {
        a aVar = new a();
        a(aVar);
        a(aVar.a);
    }

    private void a(byte b2) {
        int i = 0;
        switch (b2) {
            case 0:
                a(1);
                return;
            case 1:
                a(2);
                return;
            case 2:
                a(4);
                return;
            case 3:
                a(8);
                return;
            case 4:
                a(4);
                return;
            case 5:
                a(8);
                return;
            case 6:
                int i2 = this.b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                a(i2);
                return;
            case 7:
                a(this.b.getInt());
                return;
            case 8:
                int a2 = a(0, 0, true);
                while (i < a2 * 2) {
                    b();
                    i++;
                }
                return;
            case 9:
                int a3 = a(0, 0, true);
                while (i < a3) {
                    b();
                    i++;
                }
                return;
            case 10:
                a();
                return;
            case 11:
            case 12:
                return;
            case 13:
                a aVar = new a();
                a(aVar);
                if (aVar.a == 0) {
                    a(a(0, 0, true));
                    return;
                }
                throw new h("skipField with invalid type, type value: " + b2 + ", " + aVar.a);
            default:
                throw new h("invalid type.");
        }
    }

    public final boolean a(int i, boolean z) {
        return a((byte) 0, i, z) != 0;
    }

    public final byte a(byte b2, int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b3 = aVar.a;
            if (b3 == 0) {
                return this.b.get();
            }
            if (b3 == 12) {
                return 0;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return b2;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final short a(short s, int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 0) {
                return (short) this.b.get();
            }
            if (b2 == 1) {
                return this.b.getShort();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return s;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final int a(int i, int i2, boolean z) {
        if (b(i2)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 0) {
                return this.b.get();
            }
            if (b2 == 1) {
                return this.b.getShort();
            }
            if (b2 == 2) {
                return this.b.getInt();
            }
            if (b2 == 12) {
                return 0;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return i;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final long a(long j, int i, boolean z) {
        int i2;
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 0) {
                i2 = this.b.get();
            } else if (b2 == 1) {
                i2 = this.b.getShort();
            } else if (b2 == 2) {
                i2 = this.b.getInt();
            } else if (b2 == 3) {
                return this.b.getLong();
            } else {
                if (b2 == 12) {
                    return 0;
                }
                throw new h("type mismatch.");
            }
            return (long) i2;
        } else if (!z) {
            return j;
        } else {
            throw new h("require field not exist.");
        }
    }

    private float a(float f, int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 4) {
                return this.b.getFloat();
            }
            if (b2 == 12) {
                return 0.0f;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return f;
        } else {
            throw new h("require field not exist.");
        }
    }

    private double a(double d, int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 4) {
                return (double) this.b.getFloat();
            }
            if (b2 == 5) {
                return this.b.getDouble();
            }
            if (b2 == 12) {
                return Utils.DOUBLE_EPSILON;
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return d;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final String b(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 6) {
                int i2 = this.b.get();
                if (i2 < 0) {
                    i2 += 256;
                }
                byte[] bArr = new byte[i2];
                this.b.get(bArr);
                try {
                    return new String(bArr, this.a);
                } catch (UnsupportedEncodingException unused) {
                    return new String(bArr);
                }
            } else if (b2 == 7) {
                int i3 = this.b.getInt();
                if (i3 > 104857600 || i3 < 0) {
                    throw new h("String too long: ".concat(String.valueOf(i3)));
                }
                byte[] bArr2 = new byte[i3];
                this.b.get(bArr2);
                try {
                    return new String(bArr2, this.a);
                } catch (UnsupportedEncodingException unused2) {
                    return new String(bArr2);
                }
            } else {
                throw new h("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final <K, V> HashMap<K, V> a(Map<K, V> map, int i, boolean z) {
        return (HashMap) a(new HashMap(), map, i, z);
    }

    private <K, V> Map<K, V> a(Map<K, V> map, Map<K, V> map2, int i, boolean z) {
        if (map2 == null || map2.isEmpty()) {
            return new HashMap();
        }
        Map.Entry next = map2.entrySet().iterator().next();
        Object key = next.getKey();
        Object value = next.getValue();
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 8) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    for (int i2 = 0; i2 < a2; i2++) {
                        map.put(a(key, 0, true), a(value, 1, true));
                    }
                } else {
                    throw new h("size invalid: ".concat(String.valueOf(a2)));
                }
            } else {
                throw new h("type mismatch.");
            }
        } else if (z) {
            throw new h("require field not exist.");
        }
        return map;
    }

    private boolean[] d(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    boolean[] zArr = new boolean[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        zArr[i2] = a(0, true);
                    }
                    return zArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final byte[] c(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            byte b2 = aVar.a;
            if (b2 == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    byte[] bArr = new byte[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        bArr[i2] = a(bArr[0], 0, true);
                    }
                    return bArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            } else if (b2 == 13) {
                a aVar2 = new a();
                a(aVar2);
                if (aVar2.a == 0) {
                    int a3 = a(0, 0, true);
                    if (a3 >= 0) {
                        byte[] bArr2 = new byte[a3];
                        this.b.get(bArr2);
                        return bArr2;
                    }
                    throw new h("invalid size, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a + ", size: " + a3);
                }
                throw new h("type mismatch, tag: " + i + ", type: " + aVar.a + ", " + aVar2.a);
            } else {
                throw new h("type mismatch.");
            }
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private short[] e(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    short[] sArr = new short[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        sArr[i2] = a(sArr[0], 0, true);
                    }
                    return sArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private int[] f(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    int[] iArr = new int[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        iArr[i2] = a(iArr[0], 0, true);
                    }
                    return iArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private long[] g(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    long[] jArr = new long[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        jArr[i2] = a(jArr[0], 0, true);
                    }
                    return jArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private float[] h(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    float[] fArr = new float[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        fArr[i2] = a(fArr[0], 0, true);
                    }
                    return fArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private double[] i(int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    double[] dArr = new double[a2];
                    for (int i2 = 0; i2 < a2; i2++) {
                        dArr[i2] = a(dArr[0], 0, true);
                    }
                    return dArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    private <T> T[] a(T[] tArr, int i, boolean z) {
        if (tArr != null && tArr.length != 0) {
            return b(tArr[0], i, z);
        }
        throw new h("unable to get type of key and value.");
    }

    private <T> List<T> a(List<T> list, int i, boolean z) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        Object[] b2 = b(list.get(0), i, z);
        if (b2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object add : b2) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private <T> T[] b(T t, int i, boolean z) {
        if (b(i)) {
            a aVar = new a();
            a(aVar);
            if (aVar.a == 9) {
                int a2 = a(0, 0, true);
                if (a2 >= 0) {
                    T[] tArr = (Object[]) Array.newInstance(t.getClass(), a2);
                    for (int i2 = 0; i2 < a2; i2++) {
                        tArr[i2] = a(t, 0, true);
                    }
                    return tArr;
                }
                throw new h("size invalid: ".concat(String.valueOf(a2)));
            }
            throw new h("type mismatch.");
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final m a(m mVar, int i, boolean z) {
        if (b(i)) {
            try {
                m mVar2 = (m) mVar.getClass().newInstance();
                a aVar = new a();
                a(aVar);
                if (aVar.a == 10) {
                    mVar2.a(this);
                    a();
                    return mVar2;
                }
                throw new h("type mismatch.");
            } catch (Exception e) {
                throw new h(e.getMessage());
            }
        } else if (!z) {
            return null;
        } else {
            throw new h("require field not exist.");
        }
    }

    public final <T> Object a(T t, int i, boolean z) {
        if (t instanceof Byte) {
            return Byte.valueOf(a((byte) 0, i, z));
        }
        if (t instanceof Boolean) {
            return Boolean.valueOf(a(i, z));
        }
        if (t instanceof Short) {
            return Short.valueOf(a(0, i, z));
        }
        if (t instanceof Integer) {
            return Integer.valueOf(a(0, i, z));
        }
        if (t instanceof Long) {
            return Long.valueOf(a(0, i, z));
        }
        if (t instanceof Float) {
            return Float.valueOf(a(0.0f, i, z));
        }
        if (t instanceof Double) {
            return Double.valueOf(a((double) Utils.DOUBLE_EPSILON, i, z));
        }
        if (t instanceof String) {
            return String.valueOf(b(i, z));
        }
        if (t instanceof Map) {
            return a((Map) t, i, z);
        }
        if (t instanceof List) {
            return a((List) t, i, z);
        }
        if (t instanceof m) {
            return a((m) t, i, z);
        }
        if (!t.getClass().isArray()) {
            throw new h("read object error: unsupport type.");
        } else if ((t instanceof byte[]) || (t instanceof Byte[])) {
            return c(i, z);
        } else {
            if (t instanceof boolean[]) {
                return d(i, z);
            }
            if (t instanceof short[]) {
                return e(i, z);
            }
            if (t instanceof int[]) {
                return f(i, z);
            }
            if (t instanceof long[]) {
                return g(i, z);
            }
            if (t instanceof float[]) {
                return h(i, z);
            }
            if (t instanceof double[]) {
                return i(i, z);
            }
            return a((T[]) (Object[]) t, i, z);
        }
    }

    public final int a(String str) {
        this.a = str;
        return 0;
    }
}
