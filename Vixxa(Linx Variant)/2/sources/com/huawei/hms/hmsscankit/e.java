package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y3;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.UUID;

/* compiled from: RemoteDecoder */
public class e {
    private static volatile x3 a;
    private static volatile IRemoteDecoderDelegate b;
    private static volatile w3 c;
    private static volatile IRemoteFrameDecoderDelegate d;

    /* compiled from: RemoteDecoder */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    static HmsScan[] a(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] hmsScanArr = new HmsScan[0];
        if (b == null) {
            IRemoteCreator c2 = f.c(context);
            if (c2 == null) {
                return hmsScanArr;
            }
            try {
                b = c2.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("RemoteDecoder", "RemoteException");
            }
        }
        if (b == null) {
            return hmsScanArr;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
            bundle.putAll(y3.a(context));
            HmsScan[] decodeWithBitmap = b.decodeWithBitmap(ObjectWrapper.wrap(bitmap), ObjectWrapper.wrap(bundle));
            if (decodeWithBitmap != null) {
                return decodeWithBitmap;
            }
            return hmsScanArr;
        } catch (RemoteException unused2) {
            o4.b("RemoteDecoder", "RemoteException");
            return hmsScanArr;
        }
    }

    static HmsScanResult a(Context context, byte[] bArr, int i, int i2, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScanResult hmsScanResult = new HmsScanResult(4096, new HmsScan[0]);
        if (b == null) {
            IRemoteCreator c2 = f.c(context);
            if (c2 == null) {
                return hmsScanResult;
            }
            try {
                b = c2.newRemoteDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("RemoteDecoder", "RemoteException");
            }
        }
        if (b == null) {
            return hmsScanResult;
        }
        try {
            Bundle bundle = new Bundle();
            if (hmsScanAnalyzerOptions != null) {
                bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
            }
            bundle.putInt(DetailRect.TYPE_TRANS, 3);
            bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
            bundle.putAll(y3.a(context));
            HmsScanResult decodeWithBuffer = b.decodeWithBuffer(bArr, i, i2, ObjectWrapper.wrap(bundle));
            if (decodeWithBuffer != null) {
                return decodeWithBuffer;
            }
            return hmsScanResult;
        } catch (RemoteException unused2) {
            o4.b("RemoteDecoder", "RemoteException");
            return hmsScanResult;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c A[SYNTHETIC, Splitter:B:27:0x006c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.huawei.hms.ml.scan.HmsScanResult a(android.content.Context r15, com.huawei.hms.ml.scan.HmsScanFrame r16, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r17) {
        /*
            r0 = r17
            com.huawei.hms.ml.scan.HmsScanResult r1 = new com.huawei.hms.ml.scan.HmsScanResult
            r2 = 0
            com.huawei.hms.ml.scan.HmsScan[] r3 = new com.huawei.hms.ml.scan.HmsScan[r2]
            r4 = 4096(0x1000, float:5.74E-42)
            r1.<init>(r4, r3)
            java.lang.String r3 = "use decodeCompatibility"
            java.lang.String r5 = "Scankit"
            android.util.Log.d(r5, r3)
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r3 = d
            java.lang.String r6 = "RemoteDecoder"
            r7 = 0
            if (r3 != 0) goto L_0x0068
            java.lang.String r3 = "use remote decoder"
            android.util.Log.d(r6, r3)
            android.content.Context r3 = com.huawei.hms.hmsscankit.f.e(r15)     // Catch:{ NoSuchMethodException | InvocationTargetException -> 0x0024 }
            goto L_0x0025
        L_0x0024:
            r3 = r15
        L_0x0025:
            java.lang.ClassLoader r8 = r3.getClassLoader()     // Catch:{ IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0043, InstantiationException -> 0x003d }
            java.lang.String r9 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r8 = r8.loadClass(r9)     // Catch:{ IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0043, InstantiationException -> 0x003d }
            java.lang.ClassLoader r3 = r3.getClassLoader()     // Catch:{ IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0043, InstantiationException -> 0x003d }
            java.lang.String r9 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r3.loadClass(r9)     // Catch:{ IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0043, InstantiationException -> 0x003d }
            java.lang.Object r3 = r8.newInstance()     // Catch:{ IllegalAccessException -> 0x0049, ClassNotFoundException -> 0x0043, InstantiationException -> 0x003d }
            goto L_0x004f
        L_0x003d:
            java.lang.String r3 = "InstantiationException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r6, (java.lang.String) r3)
            goto L_0x004e
        L_0x0043:
            java.lang.String r3 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r6, (java.lang.String) r3)
            goto L_0x004e
        L_0x0049:
            java.lang.String r3 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r6, (java.lang.String) r3)
        L_0x004e:
            r3 = r7
        L_0x004f:
            boolean r8 = r3 instanceof android.os.IBinder
            if (r8 == 0) goto L_0x0068
            android.os.IBinder r3 = (android.os.IBinder) r3
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r3 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r3)
            if (r3 != 0) goto L_0x005c
            return r1
        L_0x005c:
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r1 = r3.newRemoteFrameDecoderDelegate()     // Catch:{ Exception -> 0x0063 }
            d = r1     // Catch:{ Exception -> 0x0063 }
            goto L_0x0068
        L_0x0063:
            java.lang.String r1 = "remoteception"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r6, (java.lang.String) r1)
        L_0x0068:
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r1 = d
            if (r1 == 0) goto L_0x010c
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ RemoteException -> 0x0107 }
            r1.<init>()     // Catch:{ RemoteException -> 0x0107 }
            java.lang.String r3 = "Screen"
            android.graphics.Point r8 = new android.graphics.Point     // Catch:{ RemoteException -> 0x0107 }
            int r9 = r16.getWidth()     // Catch:{ RemoteException -> 0x0107 }
            int r10 = r16.getHeight()     // Catch:{ RemoteException -> 0x0107 }
            r8.<init>(r9, r10)     // Catch:{ RemoteException -> 0x0107 }
            r1.putParcelable(r3, r8)     // Catch:{ RemoteException -> 0x0107 }
            java.lang.String r3 = "Rect"
            android.graphics.Rect r8 = new android.graphics.Rect     // Catch:{ RemoteException -> 0x0107 }
            int r9 = r16.getWidth()     // Catch:{ RemoteException -> 0x0107 }
            int r10 = r16.getHeight()     // Catch:{ RemoteException -> 0x0107 }
            r8.<init>(r2, r2, r9, r10)     // Catch:{ RemoteException -> 0x0107 }
            r1.putParcelable(r3, r8)     // Catch:{ RemoteException -> 0x0107 }
            com.huawei.hms.scankit.p.w3 r3 = c     // Catch:{ RemoteException -> 0x0107 }
            if (r3 != 0) goto L_0x00c4
            com.huawei.hms.scankit.p.w3 r3 = new com.huawei.hms.scankit.p.w3     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            java.lang.String r8 = "PhotoMode"
            r3.<init>(r1, r8)     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            c = r3     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            com.huawei.hms.scankit.p.w3 r3 = c     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            java.lang.String r8 = "single"
            r3.a(r8)     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            com.huawei.hms.scankit.p.w3 r3 = c     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            int r8 = r16.getHeight()     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            int r9 = r16.getWidth()     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            int r8 = r8 * r9
            com.huawei.hms.scankit.p.w3$c r7 = r3.a((boolean) r2, (int) r8)     // Catch:{ RuntimeException -> 0x00bf, Exception -> 0x00b9 }
            goto L_0x00c4
        L_0x00b9:
            java.lang.String r3 = "Exception"
            com.huawei.hms.scankit.p.o4.b(r6, r3)     // Catch:{ RemoteException -> 0x0107 }
            goto L_0x00c4
        L_0x00bf:
            java.lang.String r3 = "RuntimeException"
            com.huawei.hms.scankit.p.o4.b(r6, r3)     // Catch:{ RemoteException -> 0x0107 }
        L_0x00c4:
            if (r0 == 0) goto L_0x00cd
            int r0 = r0.mode     // Catch:{ RemoteException -> 0x0107 }
            int r0 = com.huawei.hms.scankit.p.w7.b((int) r0)     // Catch:{ RemoteException -> 0x0107 }
            goto L_0x00cf
        L_0x00cd:
            r0 = 8191(0x1fff, float:1.1478E-41)
        L_0x00cf:
            r13 = r0
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r8 = d     // Catch:{ RemoteException -> 0x0107 }
            android.graphics.YuvImage r0 = r16.getYuvImage()     // Catch:{ RemoteException -> 0x0107 }
            byte[] r9 = r0.getYuvData()     // Catch:{ RemoteException -> 0x0107 }
            int r10 = r16.getWidth()     // Catch:{ RemoteException -> 0x0107 }
            int r11 = r16.getHeight()     // Catch:{ RemoteException -> 0x0107 }
            com.huawei.hms.feature.dynamic.IObjectWrapper r14 = com.huawei.hms.feature.dynamic.ObjectWrapper.wrap(r1)     // Catch:{ RemoteException -> 0x0107 }
            r12 = 0
            com.huawei.hms.scankit.p.s6[] r0 = r8.decode(r9, r10, r11, r12, r13, r14)     // Catch:{ RemoteException -> 0x0107 }
            com.huawei.hms.ml.scan.HmsScan[] r0 = com.huawei.hms.scankit.p.y6.a((com.huawei.hms.scankit.p.s6[]) r0)     // Catch:{ RemoteException -> 0x0107 }
            com.huawei.hms.scankit.p.w3 r1 = c     // Catch:{ RemoteException -> 0x0107 }
            if (r1 == 0) goto L_0x00f8
            com.huawei.hms.scankit.p.w3 r1 = c     // Catch:{ RemoteException -> 0x0107 }
            r1.a((com.huawei.hms.ml.scan.HmsScan[]) r0, (com.huawei.hms.scankit.p.w3.c) r7)     // Catch:{ RemoteException -> 0x0107 }
        L_0x00f8:
            int r1 = r0.length     // Catch:{ RemoteException -> 0x0107 }
            if (r1 != 0) goto L_0x0101
            com.huawei.hms.ml.scan.HmsScanResult r1 = new com.huawei.hms.ml.scan.HmsScanResult     // Catch:{ RemoteException -> 0x0107 }
            r1.<init>(r4, r0)     // Catch:{ RemoteException -> 0x0107 }
            return r1
        L_0x0101:
            com.huawei.hms.ml.scan.HmsScanResult r1 = new com.huawei.hms.ml.scan.HmsScanResult     // Catch:{ RemoteException -> 0x0107 }
            r1.<init>(r2, r0)     // Catch:{ RemoteException -> 0x0107 }
            return r1
        L_0x0107:
            java.lang.String r0 = "RemoteException"
            android.util.Log.e(r5, r0)
        L_0x010c:
            com.huawei.hms.ml.scan.HmsScanResult r0 = new com.huawei.hms.ml.scan.HmsScanResult
            com.huawei.hms.ml.scan.HmsScan[] r1 = new com.huawei.hms.ml.scan.HmsScan[r2]
            r0.<init>(r4, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.e.a(android.content.Context, com.huawei.hms.ml.scan.HmsScanFrame, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions):com.huawei.hms.ml.scan.HmsScanResult");
    }

    private static void a(Bundle bundle) {
        if (DynamicModuleInitializer.getContext() == null) {
            try {
                f.b(AGConnectInstance.getInstance().getContext());
            } catch (ClassNotFoundException unused) {
                o4.b("RemoteDecoder", "buildBitmapLog ClassNotFoundException");
            } catch (NoSuchMethodException unused2) {
                o4.b("RemoteDecoder", "buildBitmapLog NoSuchMethodException");
            } catch (InvocationTargetException unused3) {
                o4.b("RemoteDecoder", "buildBitmapLog InvocationTargetException");
            } catch (IllegalAccessException unused4) {
                o4.b("RemoteDecoder", "buildBitmapLog IllegalAccessException");
            } catch (Exception unused5) {
                o4.b("RemoteDecoder", "buildBitmapLog Exception");
            } catch (NoClassDefFoundError unused6) {
                o4.b("RemoteDecoder", "buildBitmapLog NoClassDefFoundError");
                return;
            }
        }
        if (a == null) {
            try {
                a = new x3();
                a.c(bundle);
            } catch (RuntimeException unused7) {
                o4.b("RemoteDecoder", "buildBitmapLog RuntimeException");
            } catch (Exception unused8) {
                o4.b("RemoteDecoder", "buildBitmapLog Exception");
            }
        }
    }

    public static Bundle a(String str, int i, int i2, int i3, HmsBuildBitmapOption hmsBuildBitmapOption) {
        int i4;
        Bundle bundle = new Bundle();
        if (str == null) {
            i4 = -1;
        } else {
            i4 = str.length();
        }
        bundle.putInt("contentLength", i4);
        bundle.putInt("scanType", i);
        bundle.putInt("reqWidth", i2);
        bundle.putInt("reqHeight", i3);
        bundle.putString("buildBitmapOption", hmsBuildBitmapOption == null ? "null" : hmsBuildBitmapOption.toString());
        bundle.putString(WiseOpenHianalyticsData.UNION_API_NAME, "BuildBitmap");
        bundle.putLong(WiseOpenHianalyticsData.UNION_CALLTIME, System.currentTimeMillis());
        bundle.putString("transId", UUID.randomUUID().toString());
        return bundle;
    }

    public static void a(int i, Bitmap bitmap, Bundle bundle) {
        int i2;
        if (bundle != null) {
            bundle.putInt(WiseOpenHianalyticsData.UNION_RESULT, i);
            int i3 = -1;
            if (bitmap == null) {
                i2 = -1;
            } else {
                i2 = bitmap.getWidth();
            }
            bundle.putInt("outputWidth", i2);
            if (bitmap != null) {
                i3 = bitmap.getHeight();
            }
            bundle.putInt("outputHeight", i3);
            long j = bundle.getLong(WiseOpenHianalyticsData.UNION_CALLTIME);
            bundle.putLong(WiseOpenHianalyticsData.UNION_COSTTIME, System.currentTimeMillis() - j);
            bundle.putString(WiseOpenHianalyticsData.UNION_CALLTIME, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(j)));
            a(bundle);
        }
    }
}
