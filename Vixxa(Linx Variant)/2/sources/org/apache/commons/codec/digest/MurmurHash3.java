package org.apache.commons.codec.digest;

import kotlin.UByte;
import net.lingala.zip4j.util.InternalZipConstants;
import org.apache.commons.codec.binary.StringUtils;

public final class MurmurHash3 {
    private static final long C1 = -8663945395140668459L;
    private static final int C1_32 = -862048943;
    private static final long C2 = 5545529020109919103L;
    private static final int C2_32 = 461845907;
    public static final int DEFAULT_SEED = 104729;
    static final int INTEGER_BYTES = 4;
    static final int LONG_BYTES = 8;
    private static final int M = 5;
    private static final int M_32 = 5;
    private static final int N1 = 1390208809;
    private static final int N2 = 944331445;
    @Deprecated
    public static final long NULL_HASHCODE = 2862933555777941757L;
    private static final int N_32 = -430675100;
    private static final int R1 = 31;
    private static final int R1_32 = 15;
    private static final int R2 = 27;
    private static final int R2_32 = 13;
    private static final int R3 = 33;
    static final int SHORT_BYTES = 2;

    /* access modifiers changed from: private */
    public static int fmix32(int i) {
        int i2 = (i ^ (i >>> 16)) * -2048144789;
        int i3 = (i2 ^ (i2 >>> 13)) * -1028477387;
        return i3 ^ (i3 >>> 16);
    }

    private static long fmix64(long j) {
        long j2 = (j ^ (j >>> 33)) * -49064778989728563L;
        long j3 = (j2 ^ (j2 >>> 33)) * -4265267296055464877L;
        return j3 ^ (j3 >>> 33);
    }

    private MurmurHash3() {
    }

    public static int hash32(long j, long j2) {
        return hash32(j, j2, (int) DEFAULT_SEED);
    }

    public static int hash32(long j, long j2, int i) {
        long reverseBytes = Long.reverseBytes(j);
        long reverseBytes2 = Long.reverseBytes(j2);
        int i2 = (int) reverseBytes2;
        return fmix32(mix32((int) (reverseBytes2 >>> 32), mix32(i2, mix32((int) (reverseBytes >>> 32), mix32((int) reverseBytes, i)))) ^ 16);
    }

    public static int hash32(long j) {
        return hash32(j, (int) DEFAULT_SEED);
    }

    public static int hash32(long j, int i) {
        long reverseBytes = Long.reverseBytes(j);
        return fmix32(mix32((int) (reverseBytes >>> 32), mix32((int) reverseBytes, i)) ^ 8);
    }

    @Deprecated
    public static int hash32(byte[] bArr) {
        return hash32(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash32(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i) {
        return hash32(bArr, i, (int) DEFAULT_SEED);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i, int i2) {
        return hash32(bArr, 0, i, i2);
    }

    @Deprecated
    public static int hash32(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i3 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i), i3);
        }
        int i7 = (i4 << 2) + i;
        int i8 = (i + i2) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i5 = bArr[i7 + 2] << 16;
                }
                return fmix32(i3 ^ i2);
            }
            i5 ^= bArr[i7 + 1] << 8;
        }
        i3 ^= Integer.rotateLeft((bArr[i7] ^ i5) * C1_32, 15) * C2_32;
        return fmix32(i3 ^ i2);
    }

    public static int hash32x86(byte[] bArr) {
        return hash32x86(bArr, 0, bArr.length, 0);
    }

    public static int hash32x86(byte[] bArr, int i, int i2, int i3) {
        int i4 = i2 >> 2;
        int i5 = 0;
        for (int i6 = 0; i6 < i4; i6++) {
            i3 = mix32(getLittleEndianInt(bArr, (i6 << 2) + i), i3);
        }
        int i7 = (i4 << 2) + i;
        int i8 = (i + i2) - i7;
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 == 3) {
                    i5 = (bArr[i7 + 2] & UByte.MAX_VALUE) << 16;
                }
                return fmix32(i3 ^ i2);
            }
            i5 ^= (bArr[i7 + 1] & UByte.MAX_VALUE) << 8;
        }
        i3 ^= Integer.rotateLeft(((bArr[i7] & UByte.MAX_VALUE) ^ i5) * C1_32, 15) * C2_32;
        return fmix32(i3 ^ i2);
    }

    @Deprecated
    public static long hash64(long j) {
        return fmix64(((Long.rotateLeft((Long.rotateLeft(Long.reverseBytes(j) * C1, 31) * C2) ^ 104729, 27) * 5) + 1390208809) ^ 8);
    }

    @Deprecated
    public static long hash64(int i) {
        return fmix64((Long.rotateLeft((((long) Integer.reverseBytes(i)) & InternalZipConstants.ZIP_64_SIZE_LIMIT) * C1, 31) * C2) ^ 104733);
    }

    @Deprecated
    public static long hash64(short s) {
        return fmix64((Long.rotateLeft((((((long) s) & 255) << 8) ^ (255 & ((long) ((s & 65280) >> 8)))) * C1, 31) * C2) ^ 104731);
    }

    @Deprecated
    public static long hash64(byte[] bArr) {
        return hash64(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long hash64(byte[] bArr, int i, int i2) {
        return hash64(bArr, i, i2, DEFAULT_SEED);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 2]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0077, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 1]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0081, code lost:
        r2 = r2 ^ (java.lang.Long.rotateLeft(((((long) r0[r4]) & 255) ^ r13) * C1, 31) * C2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0098, code lost:
        return fmix64(((long) r1) ^ r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x004e, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 5]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0059, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 4]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0063, code lost:
        r13 = r13 ^ ((((long) r0[r4 + 3]) & 255) << 24);
     */
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long hash64(byte[] r15, int r16, int r17, int r18) {
        /*
            r0 = r15
            r1 = r17
            r2 = r18
            long r2 = (long) r2
            int r4 = r1 >> 3
            r5 = 0
        L_0x0009:
            r6 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            r8 = 31
            r9 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            if (r5 >= r4) goto L_0x0036
            int r11 = r5 << 3
            int r11 = r16 + r11
            long r11 = getLittleEndianLong(r15, r11)
            long r11 = r11 * r9
            long r8 = java.lang.Long.rotateLeft(r11, r8)
            long r8 = r8 * r6
            long r2 = r2 ^ r8
            r6 = 27
            long r2 = java.lang.Long.rotateLeft(r2, r6)
            r6 = 5
            long r2 = r2 * r6
            r6 = 1390208809(0x52dce729, double:6.86854413E-315)
            long r2 = r2 + r6
            int r5 = r5 + 1
            goto L_0x0009
        L_0x0036:
            int r4 = r4 << 3
            int r4 = r16 + r4
            int r5 = r16 + r1
            int r5 = r5 - r4
            r11 = 255(0xff, double:1.26E-321)
            r13 = 0
            switch(r5) {
                case 1: goto L_0x0081;
                case 2: goto L_0x0077;
                case 3: goto L_0x006d;
                case 4: goto L_0x0063;
                case 5: goto L_0x0059;
                case 6: goto L_0x004e;
                case 7: goto L_0x0045;
                default: goto L_0x0044;
            }
        L_0x0044:
            goto L_0x0092
        L_0x0045:
            int r5 = r4 + 6
            byte r5 = r0[r5]
            long r13 = (long) r5
            long r13 = r13 & r11
            r5 = 48
            long r13 = r13 << r5
        L_0x004e:
            int r5 = r4 + 5
            byte r5 = r0[r5]
            long r6 = (long) r5
            long r5 = r6 & r11
            r7 = 40
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0059:
            int r5 = r4 + 4
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 32
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0063:
            int r5 = r4 + 3
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 24
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x006d:
            int r5 = r4 + 2
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 16
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0077:
            int r5 = r4 + 1
            byte r5 = r0[r5]
            long r5 = (long) r5
            long r5 = r5 & r11
            r7 = 8
            long r5 = r5 << r7
            long r13 = r13 ^ r5
        L_0x0081:
            byte r0 = r0[r4]
            long r4 = (long) r0
            long r4 = r4 & r11
            long r4 = r4 ^ r13
            long r4 = r4 * r9
            long r4 = java.lang.Long.rotateLeft(r4, r8)
            r6 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            long r4 = r4 * r6
            long r2 = r2 ^ r4
        L_0x0092:
            long r0 = (long) r1
            long r0 = r0 ^ r2
            long r0 = fmix64(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash3.hash64(byte[], int, int, int):long");
    }

    public static long[] hash128(byte[] bArr) {
        return hash128(bArr, 0, bArr.length, DEFAULT_SEED);
    }

    public static long[] hash128x64(byte[] bArr) {
        return hash128x64(bArr, 0, bArr.length, 0);
    }

    @Deprecated
    public static long[] hash128(String str) {
        byte[] bytesUtf8 = StringUtils.getBytesUtf8(str);
        return hash128(bytesUtf8, 0, bytesUtf8.length, DEFAULT_SEED);
    }

    @Deprecated
    public static long[] hash128(byte[] bArr, int i, int i2, int i3) {
        return hash128x64Internal(bArr, i, i2, (long) i3);
    }

    public static long[] hash128x64(byte[] bArr, int i, int i2, int i3) {
        return hash128x64Internal(bArr, i, i2, ((long) i3) & InternalZipConstants.ZIP_64_SIZE_LIMIT);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x00a0, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 10]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x00ab, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 9]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x00b5, code lost:
        r6 = r6 ^ (java.lang.Long.rotateLeft((r19 ^ ((long) (r23[r0 + 8] & kotlin.UByte.MAX_VALUE))) * C2, 33) * C1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00cb, code lost:
        r19 = (((long) r23[r0 + 7]) & 255) << 56;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00d6, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 6]) & 255) << 48);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00e1, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 5]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00eb, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 4]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00f6, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 3]) & 255) << 24);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0101, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 2]) & 255) << 16);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x010c, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 1]) & 255) << 8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0116, code lost:
        r4 = r4 ^ (java.lang.Long.rotateLeft((r19 ^ ((long) (r23[r0] & kotlin.UByte.MAX_VALUE))) * C1, 31) * C2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0129, code lost:
        r0 = (long) r1;
        r2 = r4 ^ r0;
        r0 = r0 ^ r6;
        r2 = r2 + r0;
        r0 = r0 + r2;
        r2 = fmix64(r2);
        r0 = fmix64(r0);
        r2 = r2 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0142, code lost:
        return new long[]{r2, r0 + r2};
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0080, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 13]) & 255) << 40);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x008a, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 12]) & 255) << 32);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0095, code lost:
        r19 = r19 ^ ((((long) r23[r0 + 11]) & 255) << 24);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long[] hash128x64Internal(byte[] r23, int r24, int r25, long r26) {
        /*
            r0 = r23
            r1 = r25
            int r2 = r1 >> 4
            r4 = r26
            r6 = r4
            r8 = 0
        L_0x000a:
            r9 = 33
            r10 = 31
            r11 = 5545529020109919103(0x4cf5ad432745937f, double:5.573325460219186E62)
            r13 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            r15 = 8
            if (r8 >= r2) goto L_0x005b
            int r16 = r8 << 4
            int r3 = r24 + r16
            long r17 = getLittleEndianLong(r0, r3)
            int r3 = r3 + r15
            long r15 = getLittleEndianLong(r0, r3)
            long r0 = r17 * r13
            long r0 = java.lang.Long.rotateLeft(r0, r10)
            long r0 = r0 * r11
            long r0 = r0 ^ r4
            r3 = 27
            long r0 = java.lang.Long.rotateLeft(r0, r3)
            long r0 = r0 + r6
            r3 = 5
            long r0 = r0 * r3
            r17 = 1390208809(0x52dce729, double:6.86854413E-315)
            long r0 = r0 + r17
            long r11 = r11 * r15
            long r11 = java.lang.Long.rotateLeft(r11, r9)
            long r11 = r11 * r13
            long r5 = r6 ^ r11
            long r5 = java.lang.Long.rotateLeft(r5, r10)
            long r5 = r5 + r0
            long r5 = r5 * r3
            r3 = 944331445(0x38495ab5, double:4.665617253E-315)
            long r6 = r5 + r3
            int r8 = r8 + 1
            r4 = r0
            r0 = r23
            r1 = r25
            goto L_0x000a
        L_0x005b:
            int r0 = r2 << 4
            int r0 = r24 + r0
            r1 = r25
            int r2 = r24 + r1
            int r2 = r2 - r0
            r3 = 48
            r8 = 40
            r16 = 32
            r17 = 24
            r18 = 16
            r19 = 0
            r21 = 255(0xff, double:1.26E-321)
            switch(r2) {
                case 1: goto L_0x0116;
                case 2: goto L_0x010c;
                case 3: goto L_0x0101;
                case 4: goto L_0x00f6;
                case 5: goto L_0x00eb;
                case 6: goto L_0x00e1;
                case 7: goto L_0x00d6;
                case 8: goto L_0x00cb;
                case 9: goto L_0x00b5;
                case 10: goto L_0x00ab;
                case 11: goto L_0x00a0;
                case 12: goto L_0x0095;
                case 13: goto L_0x008a;
                case 14: goto L_0x0080;
                case 15: goto L_0x0077;
                default: goto L_0x0075;
            }
        L_0x0075:
            goto L_0x0129
        L_0x0077:
            int r2 = r0 + 14
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r19 = r13 << r3
        L_0x0080:
            int r2 = r0 + 13
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r13 = r13 << r8
            long r19 = r19 ^ r13
        L_0x008a:
            int r2 = r0 + 12
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r13 = r13 << r16
            long r19 = r19 ^ r13
        L_0x0095:
            int r2 = r0 + 11
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r13 = r13 << r17
            long r19 = r19 ^ r13
        L_0x00a0:
            int r2 = r0 + 10
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r13 = r13 << r18
            long r19 = r19 ^ r13
        L_0x00ab:
            int r2 = r0 + 9
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r13 = r13 << r15
            long r19 = r19 ^ r13
        L_0x00b5:
            int r2 = r0 + 8
            byte r2 = r23[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            long r13 = (long) r2
            long r13 = r19 ^ r13
            long r13 = r13 * r11
            long r13 = java.lang.Long.rotateLeft(r13, r9)
            r19 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r13 = r13 * r19
            long r6 = r6 ^ r13
        L_0x00cb:
            int r2 = r0 + 7
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            r2 = 56
            long r19 = r13 << r2
        L_0x00d6:
            int r2 = r0 + 6
            byte r2 = r23[r2]
            long r13 = (long) r2
            long r13 = r13 & r21
            long r2 = r13 << r3
            long r19 = r19 ^ r2
        L_0x00e1:
            int r2 = r0 + 5
            byte r2 = r23[r2]
            long r2 = (long) r2
            long r2 = r2 & r21
            long r2 = r2 << r8
            long r19 = r19 ^ r2
        L_0x00eb:
            int r2 = r0 + 4
            byte r2 = r23[r2]
            long r2 = (long) r2
            long r2 = r2 & r21
            long r2 = r2 << r16
            long r19 = r19 ^ r2
        L_0x00f6:
            int r2 = r0 + 3
            byte r2 = r23[r2]
            long r2 = (long) r2
            long r2 = r2 & r21
            long r2 = r2 << r17
            long r19 = r19 ^ r2
        L_0x0101:
            int r2 = r0 + 2
            byte r2 = r23[r2]
            long r2 = (long) r2
            long r2 = r2 & r21
            long r2 = r2 << r18
            long r19 = r19 ^ r2
        L_0x010c:
            int r2 = r0 + 1
            byte r2 = r23[r2]
            long r2 = (long) r2
            long r2 = r2 & r21
            long r2 = r2 << r15
            long r19 = r19 ^ r2
        L_0x0116:
            byte r0 = r23[r0]
            r0 = r0 & 255(0xff, float:3.57E-43)
            long r2 = (long) r0
            long r2 = r19 ^ r2
            r8 = -8663945395140668459(0x87c37b91114253d5, double:-2.8811287363897357E-271)
            long r2 = r2 * r8
            long r2 = java.lang.Long.rotateLeft(r2, r10)
            long r2 = r2 * r11
            long r4 = r4 ^ r2
        L_0x0129:
            long r0 = (long) r1
            long r2 = r4 ^ r0
            long r0 = r0 ^ r6
            long r2 = r2 + r0
            long r0 = r0 + r2
            long r2 = fmix64(r2)
            long r0 = fmix64(r0)
            long r2 = r2 + r0
            long r0 = r0 + r2
            r4 = 2
            long[] r4 = new long[r4]
            r5 = 0
            r4[r5] = r2
            r2 = 1
            r4[r2] = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.codec.digest.MurmurHash3.hash128x64Internal(byte[], int, int, long):long[]");
    }

    private static long getLittleEndianLong(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* access modifiers changed from: private */
    public static int getLittleEndianInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    /* access modifiers changed from: private */
    public static int mix32(int i, int i2) {
        return (Integer.rotateLeft((Integer.rotateLeft(i * C1_32, 15) * C2_32) ^ i2, 13) * 5) + N_32;
    }

    public static class IncrementalHash32x86 {
        private static final int BLOCK_SIZE = 4;
        private int hash;
        private int totalLen;
        private final byte[] unprocessed = new byte[3];
        private int unprocessedLength;

        private static int orBytes(byte b, byte b2, byte b3, byte b4) {
            return (b & UByte.MAX_VALUE) | ((b2 & UByte.MAX_VALUE) << 8) | ((b3 & UByte.MAX_VALUE) << 16) | ((b4 & UByte.MAX_VALUE) << 24);
        }

        public final void start(int i) {
            this.totalLen = 0;
            this.unprocessedLength = 0;
            this.hash = i;
        }

        public final void add(byte[] bArr, int i, int i2) {
            int i3;
            if (i2 > 0) {
                this.totalLen += i2;
                int i4 = this.unprocessedLength;
                if ((i4 + i2) - 4 < 0) {
                    System.arraycopy(bArr, i, this.unprocessed, i4, i2);
                    this.unprocessedLength += i2;
                    return;
                }
                if (i4 > 0) {
                    if (i4 == 1) {
                        i3 = orBytes(this.unprocessed[0], bArr[i], bArr[i + 1], bArr[i + 2]);
                    } else if (i4 == 2) {
                        byte[] bArr2 = this.unprocessed;
                        i3 = orBytes(bArr2[0], bArr2[1], bArr[i], bArr[i + 1]);
                    } else if (i4 == 3) {
                        byte[] bArr3 = this.unprocessed;
                        i3 = orBytes(bArr3[0], bArr3[1], bArr3[2], bArr[i]);
                    } else {
                        throw new IllegalStateException("Unprocessed length should be 1, 2, or 3: " + this.unprocessedLength);
                    }
                    this.hash = MurmurHash3.mix32(i3, this.hash);
                    int i5 = 4 - this.unprocessedLength;
                    i += i5;
                    i2 -= i5;
                }
                int i6 = i2 >> 2;
                for (int i7 = 0; i7 < i6; i7++) {
                    this.hash = MurmurHash3.mix32(MurmurHash3.getLittleEndianInt(bArr, (i7 << 2) + i), this.hash);
                }
                int i8 = i6 << 2;
                int i9 = i2 - i8;
                this.unprocessedLength = i9;
                if (i9 != 0) {
                    System.arraycopy(bArr, i + i8, this.unprocessed, 0, i9);
                }
            }
        }

        public final int end() {
            return finalise(this.hash, this.unprocessedLength, this.unprocessed, this.totalLen);
        }

        /* access modifiers changed from: package-private */
        public int finalise(int i, int i2, byte[] bArr, int i3) {
            byte b;
            int i4;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i4 = (bArr[2] & UByte.MAX_VALUE) << 16;
                    }
                    return MurmurHash3.fmix32(i ^ i3);
                }
                i4 = 0;
                b = i4 ^ ((bArr[1] & UByte.MAX_VALUE) << 8);
            } else {
                b = 0;
            }
            i ^= Integer.rotateLeft((b ^ (bArr[0] & UByte.MAX_VALUE)) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i ^ i3);
        }
    }

    @Deprecated
    public static class IncrementalHash32 extends IncrementalHash32x86 {
        /* access modifiers changed from: package-private */
        @Deprecated
        public int finalise(int i, int i2, byte[] bArr, int i3) {
            byte b;
            int i4;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        i4 = bArr[2] << 16;
                    }
                    return MurmurHash3.fmix32(i ^ i3);
                }
                i4 = 0;
                b = i4 ^ (bArr[1] << 8);
            } else {
                b = 0;
            }
            i ^= Integer.rotateLeft((b ^ bArr[0]) * MurmurHash3.C1_32, 15) * MurmurHash3.C2_32;
            return MurmurHash3.fmix32(i ^ i3);
        }
    }
}
