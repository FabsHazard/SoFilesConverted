package com.huawei.secure.android.common.ssl.hostname;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

public class a {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public a(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009d, code lost:
        return new java.lang.String(r1, r2, r8.f - r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.c
            r8.d = r0
            r8.e = r0
        L_0x0006:
            int r0 = r8.c
            int r1 = r8.b
            if (r0 < r1) goto L_0x0019
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.d
            int r3 = r8.e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0019:
            char[] r1 = r8.g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L_0x005e
            if (r2 == r5) goto L_0x0051
            r5 = 92
            if (r2 == r5) goto L_0x003e
            if (r2 == r4) goto L_0x0051
            if (r2 == r3) goto L_0x0051
            int r3 = r8.e
            int r4 = r3 + 1
            r8.e = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.c = r0
            goto L_0x0006
        L_0x003e:
            int r0 = r8.e
            int r2 = r0 + 1
            r8.e = r2
            char r2 = r8.b()
            r1[r0] = r2
            int r0 = r8.c
            int r0 = r0 + 1
            r8.c = r0
            goto L_0x0006
        L_0x0051:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.d
            int r3 = r8.e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x005e:
            int r2 = r8.e
            r8.f = r2
            int r0 = r0 + 1
            r8.c = r0
            int r0 = r2 + 1
            r8.e = r0
            r1[r2] = r6
        L_0x006c:
            int r0 = r8.c
            int r1 = r8.b
            if (r0 >= r1) goto L_0x0085
            char[] r2 = r8.g
            char r7 = r2[r0]
            if (r7 != r6) goto L_0x0085
            int r1 = r8.e
            int r7 = r1 + 1
            r8.e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.c = r0
            goto L_0x006c
        L_0x0085:
            if (r0 == r1) goto L_0x0091
            char[] r1 = r8.g
            char r0 = r1[r0]
            if (r0 == r3) goto L_0x0091
            if (r0 == r4) goto L_0x0091
            if (r0 != r5) goto L_0x0006
        L_0x0091:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.g
            int r2 = r8.d
            int r3 = r8.f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.a():java.lang.String");
    }

    private char b() {
        int i = this.c + 1;
        this.c = i;
        if (i != this.b) {
            char c2 = this.g[i];
            if (c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#') {
                return c2;
            }
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    return c2;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case LockFreeTaskQueueCore.CLOSED_SHIFT /*61*/:
                        case '>':
                            return c2;
                        default:
                            return c();
                    }
            }
        } else {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
    }

    private char c() {
        int i;
        int i2;
        int a2 = a(this.c);
        this.c++;
        if (a2 < 128) {
            return (char) a2;
        }
        if (a2 < 192 || a2 > 247) {
            return '?';
        }
        if (a2 <= 223) {
            i2 = a2 & 31;
            i = 1;
        } else if (a2 <= 239) {
            i2 = a2 & 15;
            i = 2;
        } else {
            i2 = a2 & 7;
            i = 3;
        }
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = this.c;
            int i5 = i4 + 1;
            this.c = i5;
            if (i5 == this.b || this.g[i5] != '\\') {
                return '?';
            }
            int i6 = i4 + 2;
            this.c = i6;
            int a3 = a(i6);
            this.c++;
            if ((a3 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (a3 & 63);
        }
        return (char) i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r1 = r6.g;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String d() {
        /*
            r6 = this;
            int r0 = r6.c
            int r1 = r0 + 4
            int r2 = r6.b
            java.lang.String r3 = "Unexpected end of DN: "
            if (r1 >= r2) goto L_0x0096
            r6.d = r0
            int r0 = r0 + 1
            r6.c = r0
        L_0x0010:
            int r0 = r6.c
            int r1 = r6.b
            if (r0 == r1) goto L_0x0054
            char[] r1 = r6.g
            char r2 = r1[r0]
            r4 = 43
            if (r2 == r4) goto L_0x0054
            r4 = 44
            if (r2 == r4) goto L_0x0054
            r4 = 59
            if (r2 != r4) goto L_0x0027
            goto L_0x0054
        L_0x0027:
            r4 = 32
            if (r2 != r4) goto L_0x0042
            r6.e = r0
            int r0 = r0 + 1
            r6.c = r0
        L_0x0031:
            int r0 = r6.c
            int r1 = r6.b
            if (r0 >= r1) goto L_0x0056
            char[] r1 = r6.g
            char r1 = r1[r0]
            if (r1 != r4) goto L_0x0056
            int r0 = r0 + 1
            r6.c = r0
            goto L_0x0031
        L_0x0042:
            r4 = 65
            if (r2 < r4) goto L_0x004f
            r4 = 70
            if (r2 > r4) goto L_0x004f
            int r2 = r2 + 32
            char r2 = (char) r2
            r1[r0] = r2
        L_0x004f:
            int r0 = r0 + 1
            r6.c = r0
            goto L_0x0010
        L_0x0054:
            r6.e = r0
        L_0x0056:
            int r0 = r6.e
            int r1 = r6.d
            int r0 = r0 - r1
            r2 = 5
            if (r0 < r2) goto L_0x0081
            r2 = r0 & 1
            if (r2 == 0) goto L_0x0081
            int r2 = r0 / 2
            byte[] r3 = new byte[r2]
            int r1 = r1 + 1
            r4 = 0
        L_0x0069:
            if (r4 >= r2) goto L_0x0077
            int r5 = r6.a((int) r1)
            byte r5 = (byte) r5
            r3[r4] = r5
            int r1 = r1 + 2
            int r4 = r4 + 1
            goto L_0x0069
        L_0x0077:
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.g
            int r3 = r6.d
            r1.<init>(r2, r3, r0)
            return r1
        L_0x0081:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0096:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = r6.a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.d():java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String e() {
        /*
            r6 = this;
        L_0x0000:
            int r0 = r6.c
            int r1 = r6.b
            r2 = 32
            if (r0 >= r1) goto L_0x0013
            char[] r3 = r6.g
            char r3 = r3[r0]
            if (r3 != r2) goto L_0x0013
            int r0 = r0 + 1
            r6.c = r0
            goto L_0x0000
        L_0x0013:
            if (r0 != r1) goto L_0x0017
            r0 = 0
            return r0
        L_0x0017:
            r6.d = r0
            int r0 = r0 + 1
            r6.c = r0
        L_0x001d:
            int r0 = r6.c
            int r1 = r6.b
            r3 = 61
            if (r0 >= r1) goto L_0x0032
            char[] r4 = r6.g
            char r4 = r4[r0]
            if (r4 == r3) goto L_0x0032
            if (r4 == r2) goto L_0x0032
            int r0 = r0 + 1
            r6.c = r0
            goto L_0x001d
        L_0x0032:
            java.lang.String r4 = "Unexpected end of DN: "
            if (r0 >= r1) goto L_0x00ca
            r6.e = r0
            char[] r1 = r6.g
            char r0 = r1[r0]
            if (r0 != r2) goto L_0x006f
        L_0x003e:
            int r0 = r6.c
            int r1 = r6.b
            if (r0 >= r1) goto L_0x0051
            char[] r5 = r6.g
            char r5 = r5[r0]
            if (r5 == r3) goto L_0x0051
            if (r5 != r2) goto L_0x0051
            int r0 = r0 + 1
            r6.c = r0
            goto L_0x003e
        L_0x0051:
            char[] r5 = r6.g
            char r5 = r5[r0]
            if (r5 != r3) goto L_0x005a
            if (r0 == r1) goto L_0x005a
            goto L_0x006f
        L_0x005a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r2 = r6.a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x006f:
            int r0 = r6.c
            int r0 = r0 + 1
            r6.c = r0
        L_0x0075:
            int r0 = r6.c
            int r1 = r6.b
            if (r0 >= r1) goto L_0x0086
            char[] r1 = r6.g
            char r1 = r1[r0]
            if (r1 != r2) goto L_0x0086
            int r0 = r0 + 1
            r6.c = r0
            goto L_0x0075
        L_0x0086:
            int r0 = r6.e
            int r1 = r6.d
            int r0 = r0 - r1
            r2 = 4
            if (r0 <= r2) goto L_0x00bd
            char[] r0 = r6.g
            int r3 = r1 + 3
            char r3 = r0[r3]
            r4 = 46
            if (r3 != r4) goto L_0x00bd
            char r3 = r0[r1]
            r4 = 79
            if (r3 == r4) goto L_0x00a2
            r4 = 111(0x6f, float:1.56E-43)
            if (r3 != r4) goto L_0x00bd
        L_0x00a2:
            int r3 = r1 + 1
            char r3 = r0[r3]
            r4 = 73
            if (r3 == r4) goto L_0x00ae
            r4 = 105(0x69, float:1.47E-43)
            if (r3 != r4) goto L_0x00bd
        L_0x00ae:
            int r3 = r1 + 2
            char r0 = r0[r3]
            r3 = 68
            if (r0 == r3) goto L_0x00ba
            r3 = 100
            if (r0 != r3) goto L_0x00bd
        L_0x00ba:
            int r1 = r1 + r2
            r6.d = r1
        L_0x00bd:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r6.g
            int r2 = r6.d
            int r3 = r6.e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L_0x00ca:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r4)
            java.lang.String r2 = r6.a
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.hostname.a.e():java.lang.String");
    }

    private String f() {
        int i = this.c + 1;
        this.c = i;
        this.d = i;
        this.e = i;
        while (true) {
            int i2 = this.c;
            if (i2 != this.b) {
                char[] cArr = this.g;
                char c2 = cArr[i2];
                if (c2 == '\"') {
                    this.c = i2 + 1;
                    while (true) {
                        int i3 = this.c;
                        if (i3 >= this.b || this.g[i3] != ' ') {
                            char[] cArr2 = this.g;
                            int i4 = this.d;
                        } else {
                            this.c = i3 + 1;
                        }
                    }
                    char[] cArr22 = this.g;
                    int i42 = this.d;
                    return new String(cArr22, i42, this.e - i42);
                }
                if (c2 == '\\') {
                    cArr[this.e] = b();
                } else {
                    cArr[this.e] = c2;
                }
                this.c++;
                this.e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
    }

    public List<String> b(String str) {
        String str2;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        List<String> emptyList = Collections.emptyList();
        String e2 = e();
        if (e2 == null) {
            return emptyList;
        }
        do {
            int i = this.c;
            if (i < this.b) {
                char c2 = this.g[i];
                if (c2 == '\"') {
                    str2 = f();
                } else if (c2 == '#') {
                    str2 = d();
                } else if (c2 == '+' || c2 == ',' || c2 == ';') {
                    str2 = "";
                } else {
                    str2 = a();
                }
                if (str.equalsIgnoreCase(e2)) {
                    if (emptyList.isEmpty()) {
                        emptyList = new ArrayList<>();
                    }
                    emptyList.add(str2);
                }
                int i2 = this.c;
                if (i2 < this.b) {
                    char c3 = this.g[i2];
                    if (c3 == ',' || c3 == ';' || c3 == '+') {
                        this.c = i2 + 1;
                        e2 = e();
                    } else {
                        throw new IllegalStateException("Malformed DN: " + this.a);
                    }
                }
            }
            return emptyList;
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    private int a(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 < this.b) {
            char[] cArr = this.g;
            char c2 = cArr[i];
            if (c2 >= '0' && c2 <= '9') {
                i2 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i2 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i2 = c2 - '7';
            }
            char c3 = cArr[i4];
            if (c3 >= '0' && c3 <= '9') {
                i3 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i3 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            } else {
                i3 = c3 - '7';
            }
            return (i2 << 4) + i3;
        }
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    public String a(String str) {
        String str2;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = this.a.toCharArray();
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        do {
            int i = this.c;
            if (i == this.b) {
                return null;
            }
            char c2 = this.g[i];
            if (c2 == '\"') {
                str2 = f();
            } else if (c2 == '#') {
                str2 = d();
            } else if (c2 == '+' || c2 == ',' || c2 == ';') {
                str2 = "";
            } else {
                str2 = a();
            }
            if (str.equalsIgnoreCase(e2)) {
                return str2;
            }
            int i2 = this.c;
            if (i2 >= this.b) {
                return null;
            }
            char c3 = this.g[i2];
            if (c3 == ',' || c3 == ';' || c3 == '+') {
                this.c = i2 + 1;
                e2 = e();
            } else {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
