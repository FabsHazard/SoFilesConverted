package com.tencent.bugly.proguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
public final class i {
    private StringBuilder a;
    private int b;

    private void a(String str) {
        for (int i = 0; i < this.b; i++) {
            this.a.append(9);
        }
        if (str != null) {
            this.a.append(str).append(": ");
        }
    }

    public i(StringBuilder sb, int i) {
        this.a = sb;
        this.b = i;
    }

    public final i a(boolean z, String str) {
        a(str);
        this.a.append(z ? 'T' : 'F').append(10);
        return this;
    }

    public final i a(byte b2, String str) {
        a(str);
        this.a.append(b2).append(10);
        return this;
    }

    private i a(char c, String str) {
        a(str);
        this.a.append(c).append(10);
        return this;
    }

    public final i a(short s, String str) {
        a(str);
        this.a.append(s).append(10);
        return this;
    }

    public final i a(int i, String str) {
        a(str);
        this.a.append(i).append(10);
        return this;
    }

    public final i a(long j, String str) {
        a(str);
        this.a.append(j).append(10);
        return this;
    }

    private i a(float f, String str) {
        a(str);
        this.a.append(f).append(10);
        return this;
    }

    private i a(double d, String str) {
        a(str);
        this.a.append(d).append(10);
        return this;
    }

    public final i a(String str, String str2) {
        a(str2);
        if (str == null) {
            this.a.append("null\n");
        } else {
            this.a.append(str).append(10);
        }
        return this;
    }

    public final i a(byte[] bArr, String str) {
        a(str);
        if (bArr == null) {
            this.a.append("null\n");
            return this;
        } else if (bArr.length == 0) {
            this.a.append(bArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(bArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (byte a2 : bArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(short[] sArr, String str) {
        a(str);
        if (sArr == null) {
            this.a.append("null\n");
            return this;
        } else if (sArr.length == 0) {
            this.a.append(sArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(sArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (short a2 : sArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(int[] iArr, String str) {
        a(str);
        if (iArr == null) {
            this.a.append("null\n");
            return this;
        } else if (iArr.length == 0) {
            this.a.append(iArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(iArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (int a2 : iArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(long[] jArr, String str) {
        a(str);
        if (jArr == null) {
            this.a.append("null\n");
            return this;
        } else if (jArr.length == 0) {
            this.a.append(jArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(jArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (long a2 : jArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(float[] fArr, String str) {
        a(str);
        if (fArr == null) {
            this.a.append("null\n");
            return this;
        } else if (fArr.length == 0) {
            this.a.append(fArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(fArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (float a2 : fArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private i a(double[] dArr, String str) {
        a(str);
        if (dArr == null) {
            this.a.append("null\n");
            return this;
        } else if (dArr.length == 0) {
            this.a.append(dArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(dArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (double a2 : dArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    public final <K, V> i a(Map<K, V> map, String str) {
        a(str);
        if (map == null) {
            this.a.append("null\n");
            return this;
        } else if (map.isEmpty()) {
            this.a.append(map.size()).append(", {}\n");
            return this;
        } else {
            this.a.append(map.size()).append(", {\n");
            i iVar = new i(this.a, this.b + 1);
            i iVar2 = new i(this.a, this.b + 2);
            for (Map.Entry next : map.entrySet()) {
                iVar.a('(', (String) null);
                iVar2.a(next.getKey(), (String) null);
                iVar2.a(next.getValue(), (String) null);
                iVar.a(')', (String) null);
            }
            a('}', (String) null);
            return this;
        }
    }

    private <T> i a(T[] tArr, String str) {
        a(str);
        if (tArr == null) {
            this.a.append("null\n");
            return this;
        } else if (tArr.length == 0) {
            this.a.append(tArr.length).append(", []\n");
            return this;
        } else {
            this.a.append(tArr.length).append(", [\n");
            i iVar = new i(this.a, this.b + 1);
            for (T a2 : tArr) {
                iVar.a(a2, (String) null);
            }
            a(']', (String) null);
            return this;
        }
    }

    private <T> i a(Collection<T> collection, String str) {
        if (collection != null) {
            return a((T[]) collection.toArray(), str);
        }
        a(str);
        this.a.append("null\t");
        return this;
    }

    private <T> i a(T t, String str) {
        if (t == null) {
            this.a.append("null\n");
        } else if (t instanceof Byte) {
            a(((Byte) t).byteValue(), str);
        } else if (t instanceof Boolean) {
            a(((Boolean) t).booleanValue(), str);
        } else if (t instanceof Short) {
            a(((Short) t).shortValue(), str);
        } else if (t instanceof Integer) {
            a(((Integer) t).intValue(), str);
        } else if (t instanceof Long) {
            a(((Long) t).longValue(), str);
        } else if (t instanceof Float) {
            a(((Float) t).floatValue(), str);
        } else if (t instanceof Double) {
            a(((Double) t).doubleValue(), str);
        } else if (t instanceof String) {
            a((String) t, str);
        } else if (t instanceof Map) {
            a((Map) t, str);
        } else if (t instanceof List) {
            a((List) t, str);
        } else if (t instanceof m) {
            a((m) t, str);
        } else if (t instanceof byte[]) {
            a((byte[]) t, str);
        } else if (t instanceof boolean[]) {
            a((boolean[]) t, str);
        } else if (t instanceof short[]) {
            a((short[]) t, str);
        } else if (t instanceof int[]) {
            a((int[]) t, str);
        } else if (t instanceof long[]) {
            a((long[]) t, str);
        } else if (t instanceof float[]) {
            a((float[]) t, str);
        } else if (t instanceof double[]) {
            a((double[]) t, str);
        } else if (t.getClass().isArray()) {
            a((T[]) (Object[]) t, str);
        } else {
            throw new j("write object error: unsupport type.");
        }
        return this;
    }

    public final i a(m mVar, String str) {
        a('{', str);
        if (mVar == null) {
            this.a.append(9).append("null");
        } else {
            mVar.a(this.a, this.b + 1);
        }
        a('}', (String) null);
        return this;
    }
}
