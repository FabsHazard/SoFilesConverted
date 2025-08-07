package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;

/* compiled from: MultiFormatWriter */
public final class c5 implements l8 {

    /* compiled from: MultiFormatWriter */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|(3:25|26|28)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat[] r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.EAN_8     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.UPC_E     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.EAN_13     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.UPC_A     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODE_39     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODE_93     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODE_128     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.ITF     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.PDF_417     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODABAR     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.DATA_MATRIX     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.huawei.hms.scankit.aiscan.common.BarcodeFormat r1 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.AZTEC     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.c5.a.<clinit>():void");
        }
    }

    public s a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<u2, ?> map) throws WriterException {
        l8 l8Var;
        switch (a.a[barcodeFormat.ordinal()]) {
            case 1:
                l8Var = new r2();
                break;
            case 2:
                l8Var = new t7();
                break;
            case 3:
                l8Var = new p2();
                break;
            case 4:
                l8Var = new m7();
                break;
            case 5:
                l8Var = new k6();
                break;
            case 6:
                l8Var = new u0();
                break;
            case 7:
                l8Var = new w0();
                break;
            case 8:
                l8Var = new s0();
                break;
            case 9:
                l8Var = new k4();
                break;
            case 10:
                l8Var = new u5();
                break;
            case 11:
                l8Var = new q0();
                break;
            case 12:
                l8Var = new j1();
                break;
            case 13:
                l8Var = new i();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format " + barcodeFormat);
        }
        return l8Var.a(str, barcodeFormat, i, i2, map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0288, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x028a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x02b8, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x02b9, code lost:
        com.huawei.hms.hmsscankit.e.a(-1014, (android.graphics.Bitmap) null, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x02c7, code lost:
        throw new com.huawei.hms.hmsscankit.WriterException(r0.getMessage());
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02b8 A[ExcHandler: OutOfMemoryError (r0v7 'e' java.lang.OutOfMemoryError A[CUSTOM_DECLARE]), Splitter:B:98:0x0126] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0126 A[SYNTHETIC, Splitter:B:98:0x0126] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.Bitmap a(java.lang.String r27, int r28, int r29, int r30, com.huawei.hms.ml.scan.HmsBuildBitmapOption r31) throws com.huawei.hms.hmsscankit.WriterException {
        /*
            r26 = this;
            r0 = r28
            r7 = r29
            r6 = r30
            r8 = r31
            android.os.Bundle r9 = com.huawei.hms.hmsscankit.e.a((java.lang.String) r27, (int) r28, (int) r29, (int) r30, (com.huawei.hms.ml.scan.HmsBuildBitmapOption) r31)
            r10 = 0
            if (r7 <= 0) goto L_0x02e2
            if (r6 <= 0) goto L_0x02e2
            r1 = 5120(0x1400, float:7.175E-42)
            if (r7 > r1) goto L_0x02e2
            if (r6 > r1) goto L_0x02e2
            boolean r1 = android.text.TextUtils.isEmpty(r27)
            if (r1 != 0) goto L_0x02d5
            int r1 = r27.length()
            r2 = 2953(0xb89, float:4.138E-42)
            if (r1 > r2) goto L_0x02c8
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.QRCODE_SCAN_TYPE
            r2 = 1
            if (r0 != r1) goto L_0x002c
        L_0x002a:
            r3 = r2
            goto L_0x0058
        L_0x002c:
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.PDF417_SCAN_TYPE
            if (r0 != r3) goto L_0x0033
            int r3 = r7 / 30
            goto L_0x0058
        L_0x0033:
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.EAN13_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.EAN8_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.CODE39_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.CODE93_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.CODE128_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.CODABAR_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.ITF14_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.UPCCODE_A_SCAN_TYPE
            if (r0 == r3) goto L_0x0057
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.UPCCODE_E_SCAN_TYPE
            if (r0 != r3) goto L_0x002a
        L_0x0057:
            r3 = 6
        L_0x0058:
            com.huawei.hms.scankit.p.b3 r4 = com.huawei.hms.scankit.p.b3.L
            java.lang.String r5 = r4.toString()
            r11 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r12 = -197381(0xfffffffffffcfcfb, float:NaN)
            if (r8 == 0) goto L_0x0083
            int r5 = r8.margin
            if (r5 != r2) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r3 = r5
        L_0x006b:
            int r5 = r8.bimapColor
            r13 = -1
            if (r5 != r13) goto L_0x0071
            goto L_0x0072
        L_0x0071:
            r11 = r5
        L_0x0072:
            int r5 = r8.bitmapBackgroundColor
            if (r5 != r13) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r12 = r5
        L_0x0078:
            com.huawei.hms.ml.scan.HmsBuildBitmapOption$ErrorCorrectionLevel r5 = r8.QRErrorCorrection
            if (r5 != 0) goto L_0x0081
            java.lang.String r5 = r4.toString()
            goto L_0x0083
        L_0x0081:
            java.lang.String r5 = r5.value
        L_0x0083:
            r13 = r12
            r12 = r11
            r11 = r3
            java.util.Hashtable r14 = new java.util.Hashtable
            r14.<init>()
            com.huawei.hms.scankit.p.u2 r3 = com.huawei.hms.scankit.p.u2.CHARACTER_SET
            java.lang.String r4 = "utf-8"
            r14.put(r3, r4)
            com.huawei.hms.scankit.p.u2 r3 = com.huawei.hms.scankit.p.u2.MARGIN
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r14.put(r3, r4)
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.AZTEC_SCAN_TYPE
            r15 = 2
            r4 = 0
            if (r0 != r3) goto L_0x00a8
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.AZTEC
        L_0x00a3:
            r5 = r0
            r16 = r4
            goto L_0x0113
        L_0x00a8:
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.DATAMATRIX_SCAN_TYPE
            if (r0 != r3) goto L_0x00af
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.DATA_MATRIX
            goto L_0x00a3
        L_0x00af:
            int r3 = com.huawei.hms.ml.scan.HmsScanBase.PDF417_SCAN_TYPE
            if (r0 != r3) goto L_0x00c2
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.PDF_417
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.ERROR_CORRECTION
            java.lang.Integer r3 = java.lang.Integer.valueOf(r15)
            r14.put(r1, r3)
        L_0x00be:
            r5 = r0
            r16 = r2
            goto L_0x0113
        L_0x00c2:
            if (r0 != r1) goto L_0x00cc
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.ERROR_CORRECTION
            r14.put(r1, r5)
            goto L_0x00a3
        L_0x00cc:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.CODABAR_SCAN_TYPE
            if (r0 != r1) goto L_0x00d3
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODABAR
            goto L_0x00be
        L_0x00d3:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.CODE39_SCAN_TYPE
            if (r0 != r1) goto L_0x00da
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODE_39
            goto L_0x00be
        L_0x00da:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.CODE93_SCAN_TYPE
            if (r0 != r1) goto L_0x00e1
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODE_93
            goto L_0x00be
        L_0x00e1:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.CODE128_SCAN_TYPE
            if (r0 != r1) goto L_0x00e8
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.CODE_128
            goto L_0x00be
        L_0x00e8:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.EAN8_SCAN_TYPE
            if (r0 != r1) goto L_0x00ef
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.EAN_8
            goto L_0x00be
        L_0x00ef:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.EAN13_SCAN_TYPE
            if (r0 != r1) goto L_0x00f6
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.EAN_13
            goto L_0x00be
        L_0x00f6:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.ITF14_SCAN_TYPE
            if (r0 != r1) goto L_0x00fd
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.ITF
            goto L_0x00be
        L_0x00fd:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.UPCCODE_A_SCAN_TYPE
            if (r0 != r1) goto L_0x0104
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.UPC_A
            goto L_0x00be
        L_0x0104:
            int r1 = com.huawei.hms.ml.scan.HmsScanBase.UPCCODE_E_SCAN_TYPE
            if (r0 != r1) goto L_0x010b
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.UPC_E
            goto L_0x00be
        L_0x010b:
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE
            com.huawei.hms.scankit.p.u2 r1 = com.huawei.hms.scankit.p.u2.ERROR_CORRECTION
            r14.put(r1, r5)
            goto L_0x00a3
        L_0x0113:
            if (r8 == 0) goto L_0x0126
            android.graphics.Bitmap r0 = r8.logoBitmap
            if (r0 == 0) goto L_0x0126
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE
            if (r5 != r0) goto L_0x011e
            goto L_0x0126
        L_0x011e:
            com.huawei.hms.hmsscankit.WriterException r0 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r1 = "Non-QR code should not contains logos"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0126:
            com.huawei.hms.scankit.aiscan.common.BarcodeFormat r0 = com.huawei.hms.scankit.aiscan.common.BarcodeFormat.QR_CODE     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            if (r5 != r0) goto L_0x01f6
            if (r8 == 0) goto L_0x01f6
            android.graphics.Bitmap r0 = r8.logoBitmap     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            if (r0 == 0) goto L_0x01f6
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.ERROR_CORRECTION     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            com.huawei.hms.scankit.p.b3 r1 = com.huawei.hms.scankit.p.b3.H     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            java.lang.String r1 = r1.toString()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            r14.put(r0, r1)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            com.huawei.hms.scankit.p.u2 r0 = com.huawei.hms.scankit.p.u2.LOGO     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            r14.put(r0, r1)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x02a2, Exception -> 0x028c }
            r0 = r26
            r1 = r27
            r2 = r5
            r3 = r29
            r4 = r30
            r17 = r5
            r5 = r14
            com.huawei.hms.scankit.p.s r0 = r0.a((java.lang.String) r1, (com.huawei.hms.scankit.aiscan.common.BarcodeFormat) r2, (int) r3, (int) r4, (java.util.Map<com.huawei.hms.scankit.p.u2, ?>) r5)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            if (r0 != 0) goto L_0x0155
            return r10
        L_0x0155:
            int r1 = r0.e()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r11 = r11 * r15
            int r1 = r1 - r11
            int r1 = r1 / 8
            int r2 = r0.e()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r2 = r2 / r15
            int r3 = r0.c()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r3 = r3 / r15
            android.graphics.Matrix r4 = new android.graphics.Matrix     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r4.<init>()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r5 = (float) r1     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r6 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r6
            android.graphics.Bitmap r6 = r8.logoBitmap     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r6 = r6.getWidth()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r6 = (float) r6     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r6 = r5 / r6
            android.graphics.Bitmap r11 = r8.logoBitmap     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r11 = r11.getHeight()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r11 = (float) r11     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r5 = r5 / r11
            r4.setScale(r6, r5)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            android.graphics.Bitmap r5 = r8.logoBitmap     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r21 = r5.getWidth()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            android.graphics.Bitmap r6 = r8.logoBitmap     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r22 = r6.getHeight()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r24 = 0
            r19 = 0
            r20 = 0
            r18 = r5
            r23 = r4
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r18, r19, r20, r21, r22, r23, r24)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r5 = r7 * r7
            int[] r5 = new int[r5]     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r6 = 0
        L_0x01a3:
            if (r6 >= r7) goto L_0x01df
            r8 = 0
        L_0x01a6:
            if (r8 >= r7) goto L_0x01dc
            int r11 = r2 - r1
            if (r8 <= r11) goto L_0x01c8
            int r11 = r2 + r1
            if (r8 >= r11) goto L_0x01c8
            int r11 = r3 - r1
            if (r6 <= r11) goto L_0x01c8
            int r11 = r3 + r1
            if (r6 >= r11) goto L_0x01c8
            int r11 = r6 * r7
            int r11 = r11 + r8
            int r14 = r8 - r2
            int r14 = r14 + r1
            int r15 = r6 - r3
            int r15 = r15 + r1
            int r14 = r4.getPixel(r14, r15)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r5[r11] = r14     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            goto L_0x01d9
        L_0x01c8:
            boolean r11 = r0.b((int) r8, (int) r6)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            if (r11 == 0) goto L_0x01d4
            int r11 = r6 * r7
            int r11 = r11 + r8
            r5[r11] = r12     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            goto L_0x01d9
        L_0x01d4:
            int r11 = r6 * r7
            int r11 = r11 + r8
            r5[r11] = r13     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
        L_0x01d9:
            int r8 = r8 + 1
            goto L_0x01a6
        L_0x01dc:
            int r6 = r6 + 1
            goto L_0x01a3
        L_0x01df:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r7, r7, r0)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r4 = 0
            r6 = 0
            r2 = 0
            r0 = r10
            r1 = r5
            r3 = r29
            r5 = r6
            r6 = r29
            r7 = r29
            r0.setPixels(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            goto L_0x027b
        L_0x01f6:
            r17 = r5
            r0 = r26
            r1 = r27
            r2 = r17
            r3 = r29
            r4 = r30
            r5 = r14
            com.huawei.hms.scankit.p.s r0 = r0.a((java.lang.String) r1, (com.huawei.hms.scankit.aiscan.common.BarcodeFormat) r2, (int) r3, (int) r4, (java.util.Map<com.huawei.hms.scankit.p.u2, ?>) r5)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            if (r0 != 0) goto L_0x020a
            return r10
        L_0x020a:
            int r1 = r0.e()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r2 = r0.c()     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            int r3 = r1 * r2
            int[] r3 = new int[r3]     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r4 = 0
        L_0x0217:
            if (r4 >= r2) goto L_0x0233
            r5 = 0
        L_0x021a:
            if (r5 >= r1) goto L_0x0230
            boolean r8 = r0.b((int) r5, (int) r4)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            if (r8 == 0) goto L_0x0228
            int r8 = r4 * r1
            int r8 = r8 + r5
            r3[r8] = r12     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            goto L_0x022d
        L_0x0228:
            int r8 = r4 * r1
            int r8 = r8 + r5
            r3[r8] = r13     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
        L_0x022d:
            int r5 = r5 + 1
            goto L_0x021a
        L_0x0230:
            int r4 = r4 + 1
            goto L_0x0217
        L_0x0233:
            android.graphics.Bitmap$Config r0 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r1, r2, r0)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            r22 = 0
            r23 = 0
            r20 = 0
            r18 = r10
            r19 = r3
            r21 = r1
            r24 = r1
            r25 = r2
            r18.setPixels(r19, r20, r21, r22, r23, r24, r25)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r0 = (float) r1     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r1 = (float) r7     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r1 = r0 / r1
            float r2 = (float) r2     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r3 = (float) r6     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            float r3 = r2 / r3
            r4 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0274
            int r4 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0274
            if (r16 != 0) goto L_0x0261
            goto L_0x0274
        L_0x0261:
            int r4 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r4 <= 0) goto L_0x026d
            float r2 = r2 / r1
            int r0 = (int) r2     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            android.graphics.Bitmap r0 = com.huawei.hms.scankit.p.w7.a((android.graphics.Bitmap) r10, (int) r7, (int) r0)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
        L_0x026b:
            r10 = r0
            goto L_0x027b
        L_0x026d:
            float r0 = r0 / r3
            int r0 = (int) r0     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            android.graphics.Bitmap r0 = com.huawei.hms.scankit.p.w7.a((android.graphics.Bitmap) r10, (int) r0, (int) r6)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
            goto L_0x026b
        L_0x0274:
            java.lang.String r0 = "MultiFormatWriter"
            java.lang.String r1 = "wMultiple == 1f || hMultiple == 1f || !reFormFlag"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ OutOfMemoryError -> 0x02b8, IllegalArgumentException -> 0x028a, Exception -> 0x0288 }
        L_0x027b:
            if (r10 == 0) goto L_0x0282
            r0 = 0
            com.huawei.hms.hmsscankit.e.a((int) r0, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            goto L_0x0287
        L_0x0282:
            r0 = -1015(0xfffffffffffffc09, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r0, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
        L_0x0287:
            return r10
        L_0x0288:
            r0 = move-exception
            goto L_0x028f
        L_0x028a:
            r0 = move-exception
            goto L_0x02a5
        L_0x028c:
            r0 = move-exception
            r17 = r5
        L_0x028f:
            r1 = -1013(0xfffffffffffffc0b, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r1, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            com.huawei.hms.hmsscankit.WriterException r1 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = r17.toString()
            r1.<init>(r0, r2)
            throw r1
        L_0x02a2:
            r0 = move-exception
            r17 = r5
        L_0x02a5:
            r1 = -1016(0xfffffffffffffc08, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r1, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            com.huawei.hms.hmsscankit.WriterException r1 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = r17.toString()
            r1.<init>(r0, r2)
            throw r1
        L_0x02b8:
            r0 = move-exception
            r1 = -1014(0xfffffffffffffc0a, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r1, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            com.huawei.hms.hmsscankit.WriterException r1 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r0 = r0.getMessage()
            r1.<init>((java.lang.String) r0)
            throw r1
        L_0x02c8:
            r0 = -1012(0xfffffffffffffc0c, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r0, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            com.huawei.hms.hmsscankit.WriterException r0 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r1 = "IllegalArgumentException:contents.length > 2953"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02d5:
            r0 = -1011(0xfffffffffffffc0d, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r0, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            com.huawei.hms.hmsscankit.WriterException r0 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r1 = "Content is empty"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x02e2:
            r0 = -1010(0xfffffffffffffc0e, float:NaN)
            com.huawei.hms.hmsscankit.e.a((int) r0, (android.graphics.Bitmap) r10, (android.os.Bundle) r9)
            com.huawei.hms.hmsscankit.WriterException r0 = new com.huawei.hms.hmsscankit.WriterException
            java.lang.String r1 = "IllegalArgumentException:width & height should >0 & <5120"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.c5.a(java.lang.String, int, int, int, com.huawei.hms.ml.scan.HmsBuildBitmapOption):android.graphics.Bitmap");
    }
}
