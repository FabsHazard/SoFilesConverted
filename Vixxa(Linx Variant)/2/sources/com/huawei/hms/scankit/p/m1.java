package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.util.Log;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.UByte;

/* compiled from: DecodeMultiCodes */
public class m1 {
    private static boolean a = true;
    private static boolean b = false;
    private static boolean c = false;
    private static int d;
    private static LinkedList<i2> e = new LinkedList<>();
    private static LinkedList<c6> f = new LinkedList<>();
    private static LinkedList<c6> g = new LinkedList<>();
    private static boolean h = (!r3.a || r3.c);
    private static boolean i = false;
    private static long j;
    private static boolean k = false;

    static {
        if (DynamicModuleInitializer.getContext() != null) {
            Log.i("ScankitDecode", "static initializer: InitModuleBegin");
            y4.c(DynamicModuleInitializer.getContext(), "detect.ms");
            y4.a(DynamicModuleInitializer.getContext(), "angle.ms");
            y4.b(DynamicModuleInitializer.getContext(), "corner.ms");
            Log.i("ScankitDecode", "static initializer: InitModuleEnd");
            return;
        }
        Log.e("ScankitDecode", "static initializer: context null");
    }

    public static s6 a(List<BarcodeFormat> list, n1 n1Var) {
        if (list.size() > 0) {
            return n1Var.e(list, (i2) null);
        }
        return null;
    }

    public static s6[] b(Bitmap bitmap, x6 x6Var) {
        byte[] bArr = null;
        try {
            x6Var.a = bitmap.getWidth();
            x6Var.b = bitmap.getHeight();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            allocate.flip();
            bArr = new m6(x6Var.a, x6Var.b, allocate).b();
            allocate.clear();
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (UnsupportedOperationException unused2) {
            o4.b("exception", "UnsupportedArgumentException");
        } catch (UnsatisfiedLinkError unused3) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (Exception unused4) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused5) {
            o4.b("exception", "OutOfMemoryError");
        }
        return c(bArr, x6Var);
    }

    public static s6[] c(byte[] bArr, x6 x6Var) {
        s6[] s6VarArr = new s6[0];
        try {
            return a(bArr, x6Var, true);
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
            return s6VarArr;
        } catch (UnsupportedOperationException unused2) {
            o4.b("exception", "UnsupportedArgumentException");
            return s6VarArr;
        } catch (UnsatisfiedLinkError unused3) {
            o4.b("exception", "UnsatisfiedLinkError");
            return s6VarArr;
        } catch (Exception unused4) {
            o4.b("exception", "Exception");
            return s6VarArr;
        } catch (OutOfMemoryError unused5) {
            o4.b("exception", "OutOfMemoryError");
            return s6VarArr;
        }
    }

    public static s6[] a(Bitmap bitmap, x6 x6Var) {
        o4.b("scankit mul", "start decodeMultiCode pre");
        byte[] bArr = null;
        try {
            x6Var.a = bitmap.getWidth();
            x6Var.b = bitmap.getHeight();
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getByteCount());
            bitmap.copyPixelsToBuffer(allocate);
            allocate.flip();
            bArr = new m6(x6Var.a, x6Var.b, allocate).b();
            allocate.clear();
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (UnsupportedOperationException unused2) {
            o4.b("exception", "UnsupportedArgumentException");
        } catch (UnsatisfiedLinkError unused3) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (Exception unused4) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused5) {
            o4.b("exception", "OutOfMemoryError");
        }
        o4.b("scankit mul", "end decodeMultiCode pre");
        return b(bArr, x6Var);
    }

    public static s6[] b(p4 p4Var, x6 x6Var) {
        s6 s6Var;
        boolean z;
        boolean z2;
        float f2;
        s6 s6Var2;
        int i2;
        p4 p4Var2 = p4Var;
        x6 x6Var2 = x6Var;
        o4.c("ScankitDecode", "scankit mode:FULLSDK21100300 VERSION_NAME: 2.11.0.300");
        r3.a(x6Var);
        List arrayList = new ArrayList();
        if (x6Var2.a < 30 || x6Var2.b < 30 || p4Var2 == null) {
            throw new IllegalArgumentException("widthOrHeight is Illeagle");
        }
        List<List<BarcodeFormat>> a2 = n3.a(x6Var2.c);
        List list = a2.get(0);
        List list2 = a2.get(1);
        List list3 = a2.get(2);
        List list4 = a2.get(3);
        List list5 = a2.get(4);
        n1 n1Var = new n1(p4Var2);
        o4.c("Scankit", "decode full image");
        s6 s6Var3 = null;
        if (!a || c) {
            s6Var = null;
        } else {
            s6Var = a((List<BarcodeFormat>) list, n1Var);
            i = false;
            j = System.currentTimeMillis();
        }
        o4.c("Scankit", "decode start detect");
        if (a(s6Var)) {
            arrayList = n1Var.a(0, r3.q);
        }
        o4.c("Scankit", "detect size " + arrayList.size());
        if (arrayList.size() > 0) {
            o4.c("Scankit", "decode use detect");
            s6Var = b(arrayList, n1Var, a2);
            i = true;
        } else {
            o4.c("Scankit", "decode without detect");
            if (r3.c || !r3.a || r3.b) {
                if (a(s6Var) && list3.size() > 0) {
                    s6Var = n1Var.d(list3, (i2) null);
                }
                if (a(s6Var) && list2.size() > 0 && h) {
                    s6Var = n1Var.a((List<BarcodeFormat>) list2, (i2) null);
                }
                if (a(s6Var) && list5.size() > 0) {
                    s6Var = n1Var.b((List<BarcodeFormat>) list5, (i2) null);
                }
                if (a(s6Var) && list4.size() > 0) {
                    s6Var = n1Var.b((List<BarcodeFormat>) list4, (i2) null);
                }
            }
        }
        o4.c("Scankit", "end deocde");
        boolean z3 = !a && b && !c;
        if (x6Var2.e && a(s6Var) && z3) {
            s6Var = a((List<BarcodeFormat>) list, n1Var);
            b = false;
        }
        if (!r3.c) {
            boolean b2 = n1Var.b();
            int i3 = r3.k - 1;
            if (i3 <= 0) {
                i3 = 0;
            }
            r3.k = i3;
            if (arrayList.size() > 0) {
                b2 = b2 || n1Var.b((List<i2>) arrayList);
            }
            if (b2 && n1Var.c(n1Var.a()) < 20.0f) {
                b2 = false;
            }
            if (n1Var.e() > 0.0f) {
                f2 = Math.max(1.0f, n1Var.e());
            } else {
                f2 = Math.max(1.0f, Math.max(n1Var.c(), n1Var.d()));
            }
            s6 a3 = n1.a((List<i2>) arrayList, n1Var);
            s6 a4 = n1.a(n1Var);
            z = arrayList.size() > 0 ? n1.a((List<i2>) arrayList, b2) : false;
            s6 s6Var4 = a4;
            z2 = b2;
            s6Var2 = a3;
            s6Var3 = s6Var4;
        } else {
            f2 = 1.0f;
            s6Var2 = null;
            z2 = false;
            z = false;
        }
        if (s6Var3 == null || s6Var3.h() != -2) {
            i2 = 0;
            d = 0;
        } else {
            d++;
            i2 = 0;
        }
        o4.c("Scankit", "end zoom and expose cal");
        if (s6Var != null && s6Var.k() != null) {
            o4.c("ScankitDecode", "ScanCode successful");
            d = i2;
            s6Var.b(j);
            s6Var.a(System.currentTimeMillis());
            s6Var.a(i);
            s6[] s6VarArr = new s6[1];
            s6VarArr[i2] = s6Var;
            return s6VarArr;
        } else if (z2) {
            o4.c("ScankitDecode", "ScanCode need zoom");
            s6 s6Var5 = new s6(f2);
            s6Var5.c(true);
            d = i2;
            s6[] s6VarArr2 = new s6[1];
            s6VarArr2[i2] = s6Var5;
            return s6VarArr2;
        } else if (arrayList.size() > 0 && s6Var2 != null) {
            o4.c("ScankitDecode", "ScanCode need exposure");
            d = i2;
            s6[] s6VarArr3 = new s6[1];
            s6VarArr3[i2] = s6Var2;
            return s6VarArr3;
        } else if (s6Var3 != null && d == 3) {
            s6Var3.b(true);
            s6Var3.a(-1);
            o4.c("ScankitDecode", "ScanCode need globalexposure");
            d = 0;
            return new s6[]{s6Var3};
        } else if (z) {
            s6 s6Var6 = new s6(1.0f, true);
            float[] fArr = r3.y;
            float f3 = fArr[0];
            float f4 = fArr[1];
            s6Var6.a(new i2(false, f3, f4, fArr[2] - f3, fArr[3] - f4, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
            return new s6[]{s6Var6};
        } else {
            o4.c("ScankitDecode", "ScanCode null");
            return new s6[0];
        }
    }

    public static s6[] a(ByteBuffer byteBuffer, x6 x6Var) {
        return b(byteBuffer.array(), x6Var);
    }

    public static s6[] a(p4 p4Var, x6 x6Var) {
        boolean z;
        s6 a2;
        List<s6> arrayList = new ArrayList<>();
        r3.a(x6Var);
        r3.a(1);
        if (x6Var.a < 30 || x6Var.b < 30 || p4Var == null) {
            throw new IllegalArgumentException("width or Height is Illeagle");
        }
        List<List<BarcodeFormat>> a3 = n3.a(x6Var.c);
        List list = a3.get(0);
        List list2 = a3.get(1);
        List list3 = a3.get(2);
        List list4 = a3.get(3);
        n1 n1Var = new n1(p4Var);
        o4.b("scankit mul", "start detectCodes");
        List<i2> a4 = n1Var.a(1, r3.q);
        o4.b("scankit mul", "end detectCodes");
        if (a4.size() > 0) {
            arrayList = a(a4, n1Var, a3);
        } else if (!((!r3.c && r3.a) || (a2 = a(n1Var, list, list2, list3, list4)) == null || a2.k() == null)) {
            arrayList.add(a2);
        }
        List<s6> a5 = v7.a(arrayList);
        if (r3.g && a5.size() > 0 && a5.get(0).k() != null) {
            return (s6[]) a5.toArray(new s6[0]);
        }
        float f2 = 1.0f;
        if (r3.c || !r3.g) {
            z = false;
        } else {
            if (a5.size() > 0) {
                z = a5.get(0).p();
                f2 = Math.max(1.0f, a5.get(0).l());
            } else {
                z = false;
            }
            int i2 = r3.k - 1;
            if (i2 <= 0) {
                i2 = 0;
            }
            r3.k = i2;
            if (a4.size() > 0) {
                z = z || n1Var.c(a4);
            }
            if (z && n1Var.c(n1Var.a()) < 20.0f) {
                z = false;
            }
            if (z) {
                f2 = Math.max(f2, n1Var.e());
            }
        }
        if (r3.g && z) {
            s6 s6Var = new s6(f2);
            s6Var.c(true);
            a5.clear();
            a5.add(s6Var);
            return (s6[]) a5.toArray(new s6[0]);
        } else if (a5.size() > 0) {
            return (s6[]) a5.toArray(new s6[0]);
        } else {
            return new s6[0];
        }
    }

    private static s6 a(n1 n1Var, List<BarcodeFormat> list, List<BarcodeFormat> list2, List<BarcodeFormat> list3, List<BarcodeFormat> list4) {
        s6 f2 = list.size() > 0 ? n1Var.f(list, (i2) null) : null;
        if (a(f2) && list3.size() > 0) {
            f2 = n1Var.d(list3, (i2) null);
        }
        if (a(f2) && list2.size() > 0 && h) {
            f2 = n1Var.a(list2, (i2) null);
        }
        return (!a(f2) || list4.size() <= 0) ? f2 : n1Var.b(list4, (i2) null);
    }

    public static List<s6> a(List<i2> list, n1 n1Var, List<List<BarcodeFormat>> list2) {
        s6 g2;
        boolean z;
        float f2;
        n1 n1Var2 = n1Var;
        List<List<BarcodeFormat>> list3 = list2;
        boolean z2 = false;
        List list4 = list3.get(0);
        boolean z3 = true;
        List list5 = list3.get(1);
        List list6 = list3.get(2);
        List list7 = list3.get(3);
        List list8 = list3.get(4);
        List list9 = list3.get(5);
        List list10 = list3.get(6);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (i2 < list.size()) {
            n1Var2.i.a();
            i2 i2Var = list.get(i2);
            boolean z4 = i2Var.g() == 5.0f ? z3 : z2;
            boolean z5 = i2Var.g() == 1.0f ? z3 : false;
            boolean z6 = i2Var.g() == 3.0f ? z3 : false;
            boolean z7 = i2Var.g() == 2.0f ? z3 : false;
            boolean z8 = i2Var.g() == 4.0f ? z3 : false;
            boolean z9 = i2Var.g() == 6.0f ? z3 : false;
            boolean z10 = i2Var.g() == 7.0f ? z3 : false;
            if (r3.b) {
                z4 = i2Var.g() == 1.0f ? z3 : false;
                z5 = i2Var.g() == 2.0f ? z3 : false;
                z6 = i2Var.g() == 2.0f ? z3 : false;
                z8 = i2Var.g() == 1.0f ? z3 : false;
                z7 = i2Var.g() == 2.0f ? z3 : false;
            }
            o4.c("scankit mul", "start cropAndRotate");
            n1Var2.b(i2Var);
            o4.c("scankit mul", "end cropAndRotate");
            o4.c("scankit mul", "start decode");
            s6 e2 = (!a((s6) null) || list4.size() <= 0 || !z5) ? null : n1Var2.e(list4, i2Var);
            if (a(e2) && list7.size() > 0 && z6) {
                e2 = n1Var2.b((List<BarcodeFormat>) list7, i2Var);
            }
            if (a(e2) && list6.size() > 0 && z8) {
                e2 = n1Var2.d(list6, i2Var);
            }
            if (a(e2) && list8.size() > 0 && z7) {
                e2 = n1Var2.b((List<BarcodeFormat>) list8, i2Var);
            }
            if (a(e2) && list5.size() > 0 && z4) {
                e2 = n1Var2.a((List<BarcodeFormat>) list5, i2Var);
            }
            if (a(e2) && list9.size() > 0 && z10) {
                e2 = n1Var2.c(list9, i2Var);
            }
            s6 s6Var = (!a(e2) || list10.size() <= 0 || !z9 || (((double) i2Var.h()) <= 0.6d && !r3.c) || (e2 = n1Var2.h(list10, i2Var)) == null || n1.b(n1Var.a(), i2Var)) ? e2 : null;
            if (!r3.g || s6Var == null || !n1Var.b()) {
                z = true;
                if (!(s6Var == null || s6Var.k() == null)) {
                    arrayList.add(s6Var);
                }
            } else {
                if (n1Var.e() > 0.0f) {
                    f2 = Math.max(1.0f, n1Var.e());
                } else {
                    f2 = Math.max(1.0f, Math.max(n1Var.c(), n1Var.d()));
                }
                s6 s6Var2 = new s6(f2);
                z = true;
                s6Var2.c(true);
                arrayList.add(s6Var2);
            }
            i2++;
            z3 = z;
            z2 = false;
        }
        if (arrayList.size() == 0 && list4.size() > 0 && !r3.g && (g2 = n1Var2.g(list4, (i2) null)) != null && g2.k() != null) {
            arrayList.add(g2);
        }
        o4.c("scankit mul", "end decode");
        return arrayList;
    }

    public static s6 b(List<i2> list, n1 n1Var, List<List<BarcodeFormat>> list2) {
        List list3;
        n1 n1Var2 = n1Var;
        List<List<BarcodeFormat>> list4 = list2;
        boolean z = false;
        List list5 = list4.get(0);
        List list6 = list4.get(1);
        List list7 = list4.get(2);
        List list8 = list4.get(3);
        List list9 = list4.get(4);
        List list10 = list4.get(5);
        List list11 = list4.get(6);
        int i2 = 0;
        s6 s6Var = null;
        while (i2 < list.size()) {
            if (i2 > 0) {
                n1Var2.i.a();
            }
            i2 i2Var = list.get(i2);
            boolean z2 = i2Var.g() == 5.0f ? true : z;
            boolean z3 = i2Var.g() == 1.0f ? true : z;
            boolean z4 = i2Var.g() == 2.0f ? true : z;
            boolean z5 = i2Var.g() == 3.0f ? true : z;
            boolean z6 = i2Var.g() == 4.0f ? true : z;
            boolean z7 = i2Var.g() == 6.0f ? true : z;
            boolean z8 = i2Var.g() == 7.0f ? true : z;
            if (r3.b) {
                z2 = i2Var.g() == 1.0f ? true : z;
                z3 = i2Var.g() == 2.0f ? true : z;
                z4 = i2Var.g() == 2.0f ? true : z;
                z5 = i2Var.g() == 2.0f ? true : z;
                z6 = i2Var.g() == 1.0f ? true : z;
            }
            n1Var2.b(i2Var);
            if (a(s6Var) && list5.size() > 0 && z3) {
                b = true;
                s6Var = n1Var2.e(list5, i2Var);
            }
            if (a(s6Var) && list8.size() > 0 && z5) {
                s6Var = n1Var2.b((List<BarcodeFormat>) list8, i2Var);
            }
            if (a(s6Var) && list9.size() > 0 && z4) {
                s6Var = n1Var2.b((List<BarcodeFormat>) list9, i2Var);
            }
            if (a(s6Var) && list7.size() > 0 && z6) {
                s6Var = n1Var2.d(list7, i2Var);
            }
            if (a(s6Var) && list6.size() > 0 && z2) {
                s6Var = n1Var2.a((List<BarcodeFormat>) list6, i2Var);
            }
            if (a(s6Var) && list10.size() > 0 && z8) {
                s6Var = n1Var2.c(list10, i2Var);
            }
            if (!a(s6Var) || list11.size() <= 0 || !z7) {
                list3 = list5;
            } else {
                list3 = list5;
                if (((double) i2Var.h()) > 0.6d || r3.c) {
                    s6 h2 = n1Var2.h(list11, i2Var);
                    s6Var = (h2 == null || n1.b(n1Var.a(), i2Var)) ? h2 : null;
                }
            }
            if (s6Var != null && s6Var.k() != null) {
                break;
            }
            i2++;
            list5 = list3;
            z = false;
        }
        return s6Var;
    }

    private static p4 a(byte[] bArr, x6 x6Var) {
        int i2 = x6Var.a;
        int i3 = x6Var.b;
        if (!x6Var.d) {
            return new e6(bArr, i2, i3, 0, 0, i2, i3, false);
        }
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[i4];
        float f2 = 0.0f;
        for (int i5 = 0; i5 < i3; i5++) {
            for (int i6 = 0; i6 < i2; i6++) {
                byte b2 = bArr[(i5 * i2) + i6];
                f2 += (float) (b2 & UByte.MAX_VALUE);
                bArr2[(((i6 * i3) + i3) - i5) - 1] = b2;
            }
        }
        float f3 = f2 / ((float) i4);
        if (f3 < 25.0f) {
            r3.e = true;
        } else if (f3 > 215.0f) {
            r3.d = true;
        }
        x6Var.a = i3;
        x6Var.b = i2;
        return new e6(bArr2, i3, i2, 0, 0, i3, i2, false);
    }

    public static s6[] b(byte[] bArr, x6 x6Var) {
        o4.b("scankit mul", "start decodeMultiCode");
        s6[] s6VarArr = new s6[0];
        try {
            s6[] a2 = a(bArr, x6Var, false);
            if (r3.g && a2.length > 0 && a2[0].p()) {
                return a2;
            }
            int length = a2.length;
            int[] iArr = new int[length];
            int i2 = 0;
            int i3 = 0;
            while (i2 < a2.length) {
                int i4 = i2 + 1;
                for (int i5 = i4; i5 < a2.length; i5++) {
                    if (((double) v7.a(a2[i2].j(), a2[i5].j())) > 0.7d) {
                        iArr[i5] = 1;
                        i3++;
                    }
                }
                i2 = i4;
            }
            int length2 = a2.length - i3;
            s6VarArr = new s6[length2];
            for (int i6 = 0; i6 < length2; i6++) {
                int i7 = i6;
                while (i7 < length && iArr[i7] == 1) {
                    i7++;
                }
                s6VarArr[i6] = a2[i7];
            }
            o4.b("scankit mul", "end decodeMultiCode");
            return s6VarArr;
        } catch (IllegalArgumentException unused) {
            o4.b("exception", "IllegalArgumentException");
        } catch (UnsupportedOperationException unused2) {
            o4.b("exception", "UnsupportedArgumentException");
        } catch (UnsatisfiedLinkError unused3) {
            o4.b("exception", "UnsatisfiedLinkError");
        } catch (Exception unused4) {
            o4.b("exception", "Exception");
        } catch (OutOfMemoryError unused5) {
            o4.b("exception", "OutOfMemoryError");
        }
    }

    public static void a(boolean z) {
        r3.a = z;
    }

    private static void a() {
        c = false;
        e = new LinkedList<>();
        f = new LinkedList<>();
        g = new LinkedList<>();
        r3.d = false;
        r3.e = false;
    }

    public static s6[] a(byte[] bArr, x6 x6Var, boolean z) {
        int i2;
        int i3;
        o4.c("scankit mul", "start pre");
        LinkedList linkedList = new LinkedList();
        a();
        int min = Math.min(x6Var.a, x6Var.b);
        float f2 = (float) min;
        float max = ((float) Math.max(x6Var.a, x6Var.b)) / f2;
        int i4 = (int) (f2 * 1.78f);
        p4 a2 = a(bArr, x6Var);
        o4.c("Scankit", "init " + k);
        if ((r3.d || r3.e) && k) {
            return new s6[0];
        }
        k = true;
        x6 x6Var2 = new x6(x6Var);
        o4.c("scankit mul", "end pre");
        if (min > 500 && x6Var.a >= x6Var.b && x6Var.e && max > 3.0f) {
            c = true;
            x6Var2.a = i4;
            int i5 = x6Var.a - 1;
            while (i5 >= 0) {
                i5 -= i4;
                int i6 = i5 >= 0 ? i5 : 0;
                x6Var2.h = i6;
                x6Var2.i = 0;
                a(a2, i6, 0, x6Var2);
            }
            Collections.sort(e);
            s6 a3 = a(a2, x6Var2, linkedList, z, true, i4);
            if (a3 != null) {
                return new s6[]{a3};
            }
            e = new LinkedList<>();
            Collections.sort(f);
            HashSet hashSet = new HashSet();
            Iterator it = f.iterator();
            while (it.hasNext()) {
                c6 c6Var = (c6) it.next();
                if (hashSet.add(Integer.valueOf(c6Var.b)) && (i3 = c6Var.b) >= i4 && i3 <= (x6Var.a - 1) - i4) {
                    x6Var2.a = i4;
                    x6Var2.j = true;
                    int i7 = i3 - (i4 / 2);
                    x6Var2.h = i7;
                    x6Var2.i = 0;
                    a(a2, i7, 0, x6Var2);
                }
            }
            Collections.sort(e);
            s6 a4 = a(a2, x6Var2, linkedList, z, true, i4);
            if (a4 != null) {
                return new s6[]{a4};
            }
        } else if (min <= 500 || !x6Var.e || max <= 3.0f) {
            c = false;
            if (z) {
                return b(a2, x6Var);
            }
            return a(a2, x6Var);
        } else {
            c = true;
            x6Var2.b = i4;
            int i8 = x6Var.b - 1;
            while (i8 >= 0) {
                i8 -= i4;
                int i9 = i8 >= 0 ? i8 : 0;
                x6Var2.h = 0;
                x6Var2.i = i9;
                a(a2, 0, i9, x6Var2);
            }
            Collections.sort(e);
            s6 a5 = a(a2, x6Var, linkedList, z, false, i4);
            if (a5 != null) {
                return new s6[]{a5};
            }
            e = new LinkedList<>();
            Collections.sort(g);
            HashSet hashSet2 = new HashSet();
            Iterator it2 = g.iterator();
            while (it2.hasNext()) {
                c6 c6Var2 = (c6) it2.next();
                if (hashSet2.add(Integer.valueOf(c6Var2.b)) && (i2 = c6Var2.b) >= i4 && i2 <= (x6Var.b - 1) - i4) {
                    int i10 = i2 - (i4 / 2);
                    x6Var2.b = i4;
                    x6Var2.j = true;
                    x6Var2.h = 0;
                    x6Var2.i = i10;
                    a(a2, 0, i10, x6Var2);
                }
            }
            Collections.sort(e);
            s6 a6 = a(a2, x6Var, linkedList, z, false, i4);
            if (a6 != null) {
                return new s6[]{a6};
            }
        }
        s6[] s6VarArr = new s6[linkedList.size()];
        linkedList.toArray(s6VarArr);
        return s6VarArr;
    }

    private static void a(p4 p4Var, int i2, int i3, x6 x6Var) {
        r3.a(x6Var);
        byte[] b2 = p4Var.a(i2, i3, x6Var.a, x6Var.b).b();
        int i4 = x6Var.a;
        int i5 = x6Var.b;
        List<i2> a2 = new n1(new e6(b2, i4, i5, 0, 0, i4, i5, false)).a(0, r3.q);
        if (!x6Var.j) {
            a(a2, x6Var);
        }
        for (i2 next : a2) {
            next.a((float) x6Var.h, (float) x6Var.i);
            e.offer(next);
        }
    }

    private static s6 a(p4 p4Var, x6 x6Var, LinkedList<s6> linkedList, boolean z, boolean z2, int i2) {
        n1 n1Var = new n1(p4Var);
        List<List<BarcodeFormat>> a2 = n3.a(x6Var.c);
        if (z) {
            s6 b2 = b(e, n1Var, a2);
            if (b2 == null || b2.k() == null) {
                return null;
            }
            return b2;
        }
        for (s6 offer : a((List<i2>) e, n1Var, a2)) {
            linkedList.offer(offer);
        }
        return null;
    }

    private static void a(List<i2> list, x6 x6Var) {
        for (i2 next : list) {
            if (next.d() < ((float) x6Var.a) * 0.1f) {
                f.offer(new c6(next, x6Var.h));
            } else {
                float d2 = next.d() + next.f();
                int i2 = x6Var.a;
                if (d2 > ((float) i2) * 0.9f) {
                    f.offer(new c6(next, x6Var.h + i2));
                }
            }
            if (next.e() < ((float) x6Var.b) * 0.1f) {
                g.offer(new c6(next, x6Var.i));
            } else {
                float e2 = next.e() + next.c();
                int i3 = x6Var.b;
                if (e2 > ((float) i3) * 0.9f) {
                    g.offer(new c6(next, x6Var.i + i3));
                }
            }
        }
    }

    private static boolean a(s6 s6Var) {
        return s6Var == null || s6Var.k() == null;
    }
}
