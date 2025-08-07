package com.huawei.hms.scankit.p;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.feature.dynamic.f.e;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

/* compiled from: Utils */
public class w7 {
    private static String a = null;
    private static String b = null;
    public static boolean c = true;

    public static boolean a(int[][] iArr, int i) {
        return i >= 0 && i < iArr.length;
    }

    public static int b(int i) {
        if (i == 8191) {
            return HmsScanBase.ALL_SCAN_TYPE;
        }
        if (i == HmsScanBase.QRCODE_SCAN_TYPE) {
            return 256;
        }
        if (i == HmsScanBase.AZTEC_SCAN_TYPE) {
            return 4096;
        }
        if (i == HmsScanBase.DATAMATRIX_SCAN_TYPE) {
            return 16;
        }
        if (i == HmsScanBase.PDF417_SCAN_TYPE) {
            return 2048;
        }
        if (i == HmsScanBase.CODE39_SCAN_TYPE) {
            return 2;
        }
        if (i == HmsScanBase.CODE93_SCAN_TYPE) {
            return 4;
        }
        if (i == HmsScanBase.CODE128_SCAN_TYPE) {
            return 1;
        }
        if (i == HmsScanBase.EAN13_SCAN_TYPE) {
            return 32;
        }
        if (i == HmsScanBase.EAN8_SCAN_TYPE) {
            return 64;
        }
        if (i == HmsScanBase.ITF14_SCAN_TYPE) {
            return 128;
        }
        if (i == HmsScanBase.UPCCODE_A_SCAN_TYPE) {
            return 512;
        }
        if (i == HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return 1024;
        }
        if (i == HmsScanBase.CODABAR_SCAN_TYPE) {
            return 8;
        }
        if (i == HmsScanBase.WX_SCAN_TYPE) {
            return 16384;
        }
        if (i == HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE) {
            return 8192;
        }
        return i;
    }

    public static int c(Context context) {
        int identifier;
        if (context.getResources() == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    public static boolean d() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty("get", "sys.hw_multiwin_for_camera", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (Exception | RuntimeException unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        return (context instanceof Activity) && ((Activity) context).isInMultiWindowMode();
    }

    public static boolean f(Context context) {
        try {
            return e.e.equalsIgnoreCase(SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (Exception | RuntimeException unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 5.5d;
    }

    public static boolean h(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 8.0d && ((float) displayMetrics.widthPixels) / ((float) displayMetrics.heightPixels) > 1.3f;
    }

    public static boolean i(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 7.0d;
    }

    public static boolean j(Context context) {
        return Settings.Global.getInt(context.getContentResolver(), a(), 0) == 0;
    }

    public static boolean a(int[] iArr, int i) {
        return i >= 0 && i < iArr.length;
    }

    public static boolean e() {
        String str = Build.BRAND;
        return str != null && str.toLowerCase().equals("samsung");
    }

    public static boolean a(byte[] bArr, int i) {
        return i >= 0 && i < bArr.length;
    }

    public static boolean a(byte[][] bArr, int i) {
        return i >= 0 && i < bArr.length;
    }

    public static boolean d(Context context) {
        String configuration = context.getResources().getConfiguration().toString();
        return configuration.contains("hwMultiwindow-magic") || configuration.contains("hw-magic-windows");
    }

    public static boolean a(String[] strArr, int i) {
        return i >= 0 && i < strArr.length;
    }

    public static boolean c(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        return rotation == 0 || rotation == 2;
    }

    public static boolean a(float[] fArr, int i) {
        return i >= 0 && i < fArr.length;
    }

    public static boolean c() {
        if (!"ar".equals(Locale.getDefault().getLanguage()) && !"ur".equals(Locale.getDefault().getLanguage()) && !"ug".equals(Locale.getDefault().getLanguage()) && !"iw".equals(Locale.getDefault().getLanguage()) && !"fa".equals(Locale.getDefault().getLanguage())) {
            return false;
        }
        return true;
    }

    public static HmsScan[] a(HmsScan[] hmsScanArr) {
        if (!(hmsScanArr == null || hmsScanArr.length == 0)) {
            for (HmsScan hmsScan : hmsScanArr) {
                if (hmsScan != null) {
                    hmsScan.scanType = b(hmsScan.scanType);
                }
            }
        }
        return hmsScanArr;
    }

    public static int a(int i) {
        if (i <= 0) {
            return HmsScanBase.ALL_SCAN_TYPE;
        }
        if (((i - 1) & i) == 0) {
            return i;
        }
        int i2 = HmsScanBase.AZTEC_SCAN_TYPE;
        int b2 = (i & i2) != 0 ? b(i2) : 0;
        int i3 = HmsScanBase.CODABAR_SCAN_TYPE;
        if ((i & i3) != 0) {
            b2 |= b(i3);
        }
        int i4 = HmsScanBase.CODE39_SCAN_TYPE;
        if ((i & i4) != 0) {
            b2 |= b(i4);
        }
        int i5 = HmsScanBase.CODE93_SCAN_TYPE;
        if ((i & i5) != 0) {
            b2 |= b(i5);
        }
        int i6 = HmsScanBase.CODE128_SCAN_TYPE;
        if ((i & i6) != 0) {
            b2 |= b(i6);
        }
        int i7 = HmsScanBase.DATAMATRIX_SCAN_TYPE;
        if ((i & i7) != 0) {
            b2 |= b(i7);
        }
        int i8 = HmsScanBase.EAN8_SCAN_TYPE;
        if ((i & i8) != 0) {
            b2 |= b(i8);
        }
        int i9 = HmsScanBase.EAN13_SCAN_TYPE;
        if ((i & i9) != 0) {
            b2 |= b(i9);
        }
        int i10 = HmsScanBase.QRCODE_SCAN_TYPE;
        if ((i & i10) != 0) {
            b2 |= b(i10);
        }
        int i11 = HmsScanBase.ITF14_SCAN_TYPE;
        if ((i & i11) != 0) {
            b2 |= b(i11);
        }
        int i12 = HmsScanBase.PDF417_SCAN_TYPE;
        if ((i & i12) != 0) {
            b2 |= b(i12);
        }
        int i13 = HmsScanBase.UPCCODE_A_SCAN_TYPE;
        if ((i & i13) != 0) {
            b2 |= b(i13);
        }
        int i14 = HmsScanBase.UPCCODE_E_SCAN_TYPE;
        if ((i & i14) != 0) {
            b2 |= b(i14);
        }
        int i15 = HmsScanBase.MULTI_FUNCTIONAL_SCAN_TYPE;
        if ((i & i15) != 0) {
            b2 |= b(i15);
        }
        int i16 = HmsScanBase.WX_SCAN_TYPE;
        return (i & i16) != 0 ? b2 | b(i16) : b2;
    }

    public static boolean b() {
        try {
            return "-1".equalsIgnoreCase(SystemPropUtils.getProperty("get", "sys.multiwin_for_camera", "android.os.SystemProperties", GrsBaseInfo.CountryCodeSource.UNKNOWN));
        } catch (Exception | RuntimeException unused) {
            return false;
        }
    }

    public static boolean b(Activity activity) {
        return a(activity) == 102;
    }

    public static boolean b(Context context) {
        if (a(context) && TextUtils.isEmpty(b)) {
            b = context.getSharedPreferences("scanExt", 0).getString("scanExt", "unSet");
        }
        return "forbid".equals(b);
    }

    private static String b(Context context, Intent intent) {
        Uri data = new Intent(intent).getData();
        if (DocumentsContract.isDocumentUri(context, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                return a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + documentId.split(":")[1]);
            } else if (!"com.android.providers.downloads.documents".equals(data.getAuthority())) {
                return null;
            } else {
                try {
                    return a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), (String) null);
                } catch (NumberFormatException unused) {
                    o4.b("ScankitUtils", "NumberFormatException in withAppendedId");
                    return null;
                } catch (Exception unused2) {
                    o4.b("ScankitUtils", "Exception in withAppendedId");
                    return null;
                }
            }
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            return a(context, data, (String) null);
        } else {
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i, int i2) {
        if (bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
            return null;
        }
        return a(bitmap, ((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
    }

    public static Bitmap a(Bitmap bitmap, float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        float f3 = 1.0f / f;
        float f4 = 1.0f / f2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = (int) (((float) width) * f);
        int i2 = (int) (((float) height) * f2);
        int[] iArr = new int[(width * height)];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int[] iArr2 = new int[(i * i2)];
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                iArr2[(i3 * i) + i4] = iArr[(((int) (((float) i3) * f4)) * width) + ((int) (((float) i4) * f3))];
            }
        }
        Log.d(">>>", "dstPixels:" + i + " x " + i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr2, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static int a(Context context, String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid()) == -1 ? -1 : 0;
    }

    public static String a(String str) {
        return AppOpsManager.permissionToOp(str);
    }

    private static String a() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        }
        if (!str.equalsIgnoreCase("VIVO") && !str.equalsIgnoreCase("OPPO")) {
            return "navigationbar_is_min";
        }
        return "navigation_gesture_on";
    }

    public static ResolveInfo a(Intent intent, String str, Activity activity) {
        intent.setPackage(str);
        List<ResolveInfo> queryIntentActivities = activity.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return queryIntentActivities.get(0);
        }
        return null;
    }

    public static boolean a(String str, Activity activity) {
        PackageInfo packageInfo;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            o4.c("Utils", "NameNotFoundException Exception");
            packageInfo = null;
        }
        if (packageInfo == null) {
            return false;
        }
        int i = packageInfo.applicationInfo.flags;
        boolean z = (i & 1) == 1;
        boolean z2 = (i & 128) == 1;
        if (z || z2) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(android.app.Activity r7) {
        /*
            r0 = -1
            java.lang.String r1 = "com.huawei.android.app.ActivityManagerEx"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            java.lang.String r2 = "getActivityWindowMode"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            java.lang.Class<android.app.Activity> r5 = android.app.Activity.class
            r6 = 0
            r4[r6] = r5     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r4)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            r2.setAccessible(r3)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            java.lang.Object[] r7 = new java.lang.Object[]{r7}     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            java.lang.Object r7 = r2.invoke(r1, r7)     // Catch:{ ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException -> 0x0030 }
            if (r7 != 0) goto L_0x0023
            return r0
        L_0x0023:
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{  }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{  }
            int r7 = r7.intValue()     // Catch:{  }
            return r7
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.app.Activity):int");
    }

    public static boolean a(Context context) {
        if (TextUtils.isEmpty(a)) {
            try {
                a = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("scanExt", "unSet");
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("scanerror", "checkPermission NameNotFoundException");
            } catch (Exception unused2) {
                Log.e("scanerror", "checkPermission Exception");
            }
        }
        return "readUri".equals(a);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setRotate(f, (float) (width / 2), (float) (height / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        if (!createBitmap.equals(bitmap) && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i) {
        if (i == 0) {
            return a(bitmap, 90.0f);
        }
        if (i == 2) {
            return a(bitmap, 270.0f);
        }
        if (i != 3) {
            return bitmap;
        }
        return a(bitmap, 180.0f);
    }

    public static Bitmap a(Context context, Intent intent) {
        Bitmap a2;
        Bitmap bitmap;
        if (!a(context)) {
            String b2 = b(context, intent);
            if (TextUtils.isEmpty(b2)) {
                return null;
            }
            if (Build.VERSION.SDK_INT <= 28 || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion <= 28) {
                o4.a("ScanBitmap", "compressBitmap below android 29");
                bitmap = ScanUtil.compressBitmap(context, b2);
            } else {
                o4.a("ScanBitmap", "compressBitmap above android 29");
                bitmap = ScanUtil.compressBitmapForAndroid29(context, b2);
            }
            if (bitmap != null) {
                return bitmap;
            }
            o4.a("ScanBitmap", "compressBitmap above android 29");
            return ScanUtil.compressBitmapForAndroid29(context, b2);
        }
        Uri data = intent.getData();
        if (data == null || (a2 = a(context, data)) == null) {
            return null;
        }
        return a2;
    }

    private static String a(Context context, Uri uri, String str) {
        String str2 = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, (String[]) null, (String) null);
            if (query != null) {
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex("_data"));
                }
                query.close();
            }
            return str2;
        } catch (IllegalStateException unused) {
            o4.b("ScankitUtils", "IllegalStateException in getImagePath");
            return null;
        } catch (Exception unused2) {
            o4.b("ScankitUtils", "Exception in getImagePath");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047 A[SYNTHETIC, Splitter:B:24:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0051 A[SYNTHETIC, Splitter:B:30:0x0051] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap a(android.content.Context r7, android.net.Uri r8) {
        /*
            java.lang.String r0 = "IOException in getImagePath"
            java.lang.String r1 = "ScankitUtils"
            android.graphics.BitmapFactory$Options r2 = new android.graphics.BitmapFactory$Options
            r2.<init>()
            r3 = 1
            r2.inJustDecodeBounds = r3
            android.content.Context r3 = r7.getApplicationContext()
            android.content.ContentResolver r3 = r3.getContentResolver()
            r4 = 0
            java.io.InputStream r8 = r3.openInputStream(r8)     // Catch:{ IOException -> 0x003f, all -> 0x003d }
            if (r8 == 0) goto L_0x0037
            byte[] r3 = a((java.io.InputStream) r8)     // Catch:{ IOException -> 0x0040 }
            int r5 = r3.length     // Catch:{ IOException -> 0x0040 }
            r6 = 0
            android.graphics.BitmapFactory.decodeByteArray(r3, r6, r5, r2)     // Catch:{ IOException -> 0x0040 }
            a((android.content.Context) r7, (android.graphics.BitmapFactory.Options) r2)     // Catch:{ IOException -> 0x0040 }
            int r7 = r3.length     // Catch:{ IOException -> 0x0040 }
            android.graphics.Bitmap r7 = android.graphics.BitmapFactory.decodeByteArray(r3, r6, r7, r2)     // Catch:{ IOException -> 0x0040 }
            r8.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0033
        L_0x0030:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L_0x0033:
            return r7
        L_0x0034:
            r7 = move-exception
            r4 = r8
            goto L_0x004f
        L_0x0037:
            if (r8 == 0) goto L_0x004e
            r8.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004e
        L_0x003d:
            r7 = move-exception
            goto L_0x004f
        L_0x003f:
            r8 = r4
        L_0x0040:
            java.lang.String r7 = "compressBitmapFromUri IOException"
            com.huawei.hms.scankit.p.o4.b(r1, r7)     // Catch:{ all -> 0x0034 }
            if (r8 == 0) goto L_0x004e
            r8.close()     // Catch:{ IOException -> 0x004b }
            goto L_0x004e
        L_0x004b:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L_0x004e:
            return r4
        L_0x004f:
            if (r4 == 0) goto L_0x0058
            r4.close()     // Catch:{ IOException -> 0x0055 }
            goto L_0x0058
        L_0x0055:
            com.huawei.hms.scankit.p.o4.b(r1, r0)
        L_0x0058:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.content.Context, android.net.Uri):android.graphics.Bitmap");
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r9, android.graphics.BitmapFactory.Options r10) {
        /*
            java.lang.String r0 = "exception"
            int r1 = r10.outWidth
            int r2 = r10.outHeight
            if (r1 == 0) goto L_0x005f
            if (r2 != 0) goto L_0x000b
            goto L_0x005f
        L_0x000b:
            if (r1 <= r2) goto L_0x000e
            r1 = r2
        L_0x000e:
            r2 = 0
            r3 = 1
            java.lang.String r4 = "activity"
            java.lang.Object r9 = r9.getSystemService(r4)     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            android.app.ActivityManager r9 = (android.app.ActivityManager) r9     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            android.app.ActivityManager$MemoryInfo r4 = new android.app.ActivityManager$MemoryInfo     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            r4.<init>()     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            r9.getMemoryInfo(r4)     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            r5 = 4652218415073722368(0x4090000000000000, double:1024.0)
            r7 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r5 = java.lang.Math.pow(r5, r7)     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            long r7 = r4.totalMem     // Catch:{ NullPointerException -> 0x003b, Exception -> 0x0035 }
            double r7 = (double) r7
            double r7 = r7 / r5
            r4 = 4617878467915022336(0x4016000000000000, double:5.5)
            int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r9 >= 0) goto L_0x0033
            goto L_0x0040
        L_0x0033:
            r9 = r2
            goto L_0x0041
        L_0x0035:
            java.lang.String r9 = "Exception"
            com.huawei.hms.scankit.p.o4.b(r0, r9)
            goto L_0x0040
        L_0x003b:
            java.lang.String r9 = "NullPointerException"
            com.huawei.hms.scankit.p.o4.b(r0, r9)
        L_0x0040:
            r9 = r3
        L_0x0041:
            if (r9 == 0) goto L_0x0046
            r9 = 1200(0x4b0, float:1.682E-42)
            goto L_0x0048
        L_0x0046:
            r9 = 3000(0xbb8, float:4.204E-42)
        L_0x0048:
            if (r1 <= r9) goto L_0x0052
            float r0 = (float) r1
            float r9 = (float) r9
            float r0 = r0 / r9
            int r9 = java.lang.Math.round(r0)
            goto L_0x0053
        L_0x0052:
            r9 = r3
        L_0x0053:
            r10.inSampleSize = r9
            r10.inJustDecodeBounds = r2
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            r10.inPreferredConfig = r9
            r10.inPurgeable = r3
            r10.inInputShareable = r3
        L_0x005f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w7.a(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }
}
