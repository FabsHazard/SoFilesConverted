package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.ml.scan.HmsScanFrameOptions;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.c5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ScanUtil {
    public static final int CAMERA_ININT_ERROR = -1000;
    static final String CONTEXT_METHOD = "initializeModule";
    static final String CONTEXT_PATH = "com.huawei.hms.feature.DynamicModuleInitializer";
    static final String CREATOR_PATH = "com.huawei.hms.scankit.Creator";
    public static final int ERROR_ABNORMAL_RESTART = 3;
    public static final int ERROR_INVALID_PARAM = 4;
    public static final int ERROR_NO_CAMERA_PERMISSION = 1;
    public static final int ERROR_NO_READ_PERMISSION = 2;
    private static final int LITE_VERSION = 10320300;
    private static final int MAX_BITMAP_SIZE = 52428800;
    static final String MODULE_SCANKIT = "huawei_module_scankit";
    static final String MODULE_SCANKIT_LOCAL = "huawei_module_scankit_local";
    private static final int NEW_VERSION = 21002300;
    public static final String RESULT = "SCAN_RESULT";
    public static final String RESULT_CODE = "SCAN_RESULT_CODE";
    public static final int SCAN_NO_DETECTED = 4096;
    public static final int SUCCESS = 0;
    private static final int WR_VERSION = 20100300;
    static int remoteVersion = Integer.MIN_VALUE;
    static int version = Integer.MIN_VALUE;

    public static Bitmap buildBitmap(String str, int i, int i2, int i3, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        return new c5().a(str, i, i2, i3, hmsBuildBitmapOption);
    }

    private static HmsScanResult checkHmsScan(HmsScan[] hmsScanArr, HmsScanFrameOptions hmsScanFrameOptions) {
        if (hmsScanArr.length == 0) {
            return new HmsScanResult(4096, (HmsScan[]) null);
        }
        if (hmsScanArr[0].getOriginalValue() == "" && hmsScanArr[0].getZoomValue() > 1.0d) {
            return new HmsScanResult(4098, hmsScanArr);
        }
        if (hmsScanArr[0].getOriginalValue() != "") {
            return new HmsScanResult(0, hmsScanArr);
        }
        return new HmsScanResult(4096, hmsScanArr);
    }

    private static boolean checkVersion(int i, int i2) {
        if (i == LITE_VERSION && (i2 < NEW_VERSION || i2 == WR_VERSION)) {
            return true;
        }
        if (i != LITE_VERSION) {
            return i < NEW_VERSION || i == WR_VERSION;
        }
        return false;
    }

    public static Bitmap compressBitmap(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        dealBitmapFactoryOption(context, options);
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: android.net.Uri} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0066 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005f A[SYNTHETIC, Splitter:B:13:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0077 A[SYNTHETIC, Splitter:B:30:0x0077] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0094 A[SYNTHETIC, Splitter:B:39:0x0094] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap compressBitmapForAndroid29(android.content.Context r12, java.lang.String r13) {
        /*
            java.lang.String r0 = "_id"
            java.lang.String r1 = "Exception"
            java.lang.String r2 = "exception"
            r3 = 1
            r4 = 0
            android.content.ContentResolver r5 = r12.getContentResolver()     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            java.lang.String[] r7 = new java.lang.String[r3]     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            r8 = 0
            r7[r8] = r0     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            java.lang.String r9 = "_data=?"
            java.lang.String[] r10 = new java.lang.String[r3]     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            r10[r8] = r13     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            r11 = 0
            r8 = r9
            r9 = r10
            r10 = r11
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ NullPointerException -> 0x006f, Exception -> 0x0065, all -> 0x0063 }
            if (r5 == 0) goto L_0x003d
            boolean r6 = r5.moveToFirst()     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            if (r6 == 0) goto L_0x003d
            int r13 = r5.getColumnIndex(r0)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            int r13 = r5.getInt(r13)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            android.net.Uri r0 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            java.lang.String r13 = java.lang.String.valueOf(r13)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            android.net.Uri r13 = android.net.Uri.withAppendedPath(r0, r13)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
        L_0x003b:
            r4 = r13
            goto L_0x005d
        L_0x003d:
            java.io.File r0 = new java.io.File     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            r0.<init>(r13)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            boolean r0 = r0.exists()     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            if (r0 == 0) goto L_0x005d
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            r0.<init>()     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            java.lang.String r6 = "_data"
            r0.put(r6, r13)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            android.content.ContentResolver r13 = r12.getContentResolver()     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            android.net.Uri r13 = r13.insert(r6, r0)     // Catch:{ NullPointerException -> 0x0070, Exception -> 0x0066 }
            goto L_0x003b
        L_0x005d:
            if (r5 == 0) goto L_0x007e
            r5.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007e
        L_0x0063:
            r12 = move-exception
            goto L_0x0092
        L_0x0065:
            r5 = r4
        L_0x0066:
            com.huawei.hms.scankit.p.o4.b(r2, r1)     // Catch:{ all -> 0x0090 }
            if (r5 == 0) goto L_0x007e
            r5.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007e
        L_0x006f:
            r5 = r4
        L_0x0070:
            java.lang.String r13 = "NullPointerException"
            com.huawei.hms.scankit.p.o4.b(r2, r13)     // Catch:{ all -> 0x0090 }
            if (r5 == 0) goto L_0x007e
            r5.close()     // Catch:{ Exception -> 0x007b }
            goto L_0x007e
        L_0x007b:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
        L_0x007e:
            android.graphics.BitmapFactory$Options r13 = new android.graphics.BitmapFactory$Options
            r13.<init>()
            r13.inJustDecodeBounds = r3
            getBitmapFromUri(r12, r4, r13)
            dealBitmapFactoryOption(r12, r13)
            android.graphics.Bitmap r12 = getBitmapFromUri(r12, r4, r13)
            return r12
        L_0x0090:
            r12 = move-exception
            r4 = r5
        L_0x0092:
            if (r4 == 0) goto L_0x009b
            r4.close()     // Catch:{ Exception -> 0x0098 }
            goto L_0x009b
        L_0x0098:
            com.huawei.hms.scankit.p.o4.b(r2, r1)
        L_0x009b:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.compressBitmapForAndroid29(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void dealBitmapFactoryOption(android.content.Context r9, android.graphics.BitmapFactory.Options r10) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.dealBitmapFactoryOption(android.content.Context, android.graphics.BitmapFactory$Options):void");
    }

    public static HmsScanResult decode(Context context, HmsScanFrame hmsScanFrame, HmsScanFrameOptions hmsScanFrameOptions) {
        HmsScanAnalyzerOptions hmsScanAnalyzerOptions;
        if (hmsScanFrame == null || (hmsScanFrame.getYuvImage() == null && hmsScanFrame.getBitmap() == null)) {
            return new HmsScanResult(4, new HmsScan[0]);
        }
        o4.c("Scankit", "frame height " + hmsScanFrame.getHeight() + " width " + hmsScanFrame.getWidth());
        if (hmsScanFrame.getHeight() * hmsScanFrame.getHeight() > 52428800 || hmsScanFrame.getHeight() * hmsScanFrame.getHeight() == 0) {
            o4.d("ScanUtil", "input image is invalid:" + hmsScanFrame.getWidth() + " " + hmsScanFrame.getHeight());
            return new HmsScanResult(4, new HmsScan[0]);
        }
        try {
            if (version == Integer.MIN_VALUE) {
                int a = f.a(context);
                version = a;
                if (a == LITE_VERSION && remoteVersion == Integer.MIN_VALUE) {
                    remoteVersion = DynamicModule.getRemoteVersion(context.getApplicationContext(), MODULE_SCANKIT);
                }
            }
        } catch (Exception unused) {
            o4.b("Scankit", "get remote version failed");
        }
        if (hmsScanFrameOptions == null || !hmsScanFrameOptions.isMultiMode()) {
            if (hmsScanFrameOptions == null) {
                hmsScanAnalyzerOptions = new HmsScanAnalyzerOptions.Creator().create();
            } else {
                hmsScanAnalyzerOptions = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(hmsScanFrameOptions.getType(), new int[0]).setPhotoMode(hmsScanFrameOptions.isPhotoMode()).setParseResult(hmsScanFrameOptions.isParseResult()).create();
            }
            if (hmsScanFrame.getBitmap() != null) {
                return checkHmsScan(e.a(context, hmsScanFrame.getBitmap(), hmsScanAnalyzerOptions), hmsScanFrameOptions);
            }
            if (hmsScanFrame.getYuvImage() == null) {
                return new HmsScanResult(4, new HmsScan[0]);
            }
            Log.i("scankit", "local version " + version + " remote version" + remoteVersion);
            if (checkVersion(version, remoteVersion)) {
                return e.a(context, hmsScanFrame, hmsScanAnalyzerOptions);
            }
            return e.a(context, hmsScanFrame.getYuvImage().getYuvData(), hmsScanFrame.getYuvImage().getWidth(), hmsScanFrame.getYuvImage().getHeight(), hmsScanAnalyzerOptions);
        }
        HmsScan[] a2 = a.a(context, hmsScanFrame, new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(hmsScanFrameOptions.getType(), new int[0]).setPhotoMode(hmsScanFrameOptions.isPhotoMode()).setParseResult(hmsScanFrameOptions.isParseResult()).create());
        if (a2.length == 0) {
            return new HmsScanResult(4096, a2);
        }
        if (a2.length == 1 && a2[0].getZoomValue() > 1.0d && TextUtils.isEmpty(a2[0].getOriginalValue())) {
            return new HmsScanResult(4098, a2);
        }
        if (a2.length < 1 || TextUtils.isEmpty(a2[0].getOriginalValue())) {
            return new HmsScanResult(4096, a2);
        }
        return new HmsScanResult(0, a2);
    }

    public static HmsScan[] decodeWithBitmap(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        if (bitmap != null && bitmap.getWidth() * bitmap.getHeight() <= 52428800) {
            return e.a(context, bitmap, hmsScanAnalyzerOptions);
        }
        if (bitmap != null) {
            o4.d("ScanUtil", "input image is too large:" + bitmap.getWidth());
        }
        return new HmsScan[0];
    }

    public static HmsScan[] detectForHmsDector(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return a.a(context, mLFrame, hmsScanAnalyzerOptions);
    }

    private static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            o4.a("ScanBitmap", "uri == null");
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), (Rect) null, options);
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (FileNotFoundException unused) {
            o4.b("exception", "FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            o4.b("exception", "IOException");
            return null;
        } catch (Exception unused3) {
            o4.b("exception", "Exception");
            return null;
        }
    }

    public static boolean isScanAvailable(Context context) {
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int startScan(android.app.Activity r5, int r6, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r7) {
        /*
            java.lang.String r0 = "exception"
            java.lang.String r1 = "startScan before"
            java.lang.String r2 = "ScanUtil"
            com.huawei.hms.scankit.p.o4.c(r2, r1)
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0022, RuntimeException -> 0x001c }
            java.lang.String r3 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0022, RuntimeException -> 0x001c }
            r4 = 16384(0x4000, float:2.2959E-41)
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch:{ NameNotFoundException -> 0x0022, RuntimeException -> 0x001c }
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo     // Catch:{ NameNotFoundException -> 0x0022, RuntimeException -> 0x001c }
            int r0 = r1.targetSdkVersion     // Catch:{ NameNotFoundException -> 0x0022, RuntimeException -> 0x001c }
            goto L_0x0029
        L_0x001c:
            java.lang.String r1 = "RuntimeException"
            com.huawei.hms.scankit.p.o4.b(r0, r1)
            goto L_0x0027
        L_0x0022:
            java.lang.String r1 = "NameNotFoundException"
            com.huawei.hms.scankit.p.o4.b(r0, r1)
        L_0x0027:
            r0 = 28
        L_0x0029:
            java.lang.String r1 = "android.permission.CAMERA"
            boolean r0 = selfPermissionGranted(r5, r0, r1)
            boolean r1 = com.huawei.hms.scankit.p.w7.c
            if (r1 != 0) goto L_0x003a
            java.lang.String r5 = "startScan failed"
            com.huawei.hms.scankit.p.o4.c(r2, r5)
            r5 = 3
            return r5
        L_0x003a:
            if (r0 == 0) goto L_0x0066
            android.content.Intent r0 = new android.content.Intent
            java.lang.Class<com.huawei.hms.hmsscankit.ScanKitActivity> r1 = com.huawei.hms.hmsscankit.ScanKitActivity.class
            r0.<init>(r5, r1)
            if (r7 == 0) goto L_0x005a
            int r1 = r7.mode
            java.lang.String r3 = "ScanFormatValue"
            r0.putExtra(r3, r1)
            int r1 = r7.viewType
            java.lang.String r3 = "ScanViewValue"
            r0.putExtra(r3, r1)
            boolean r7 = r7.errorCheck
            java.lang.String r1 = "ScanErrorCheck"
            r0.putExtra(r1, r7)
        L_0x005a:
            java.lang.String r7 = "startScan success"
            com.huawei.hms.scankit.p.o4.c(r2, r7)
            r7 = 0
            com.huawei.hms.scankit.p.w7.c = r7
            r5.startActivityForResult(r0, r6)
            return r7
        L_0x0066:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.ScanUtil.startScan(android.app.Activity, int, com.huawei.hms.ml.scan.HmsScanAnalyzerOptions):int");
    }

    public static boolean selfPermissionGranted(Context context, int i, String str) {
        if (i >= 23) {
            if (w7.a(str) == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
            return false;
        } else if (w7.a(context, str) == 0) {
            return true;
        }
        return false;
    }
}
