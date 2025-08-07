package kotlin;

import net.lingala.zip4j.util.InternalZipConstants;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport0 {
    public static /* synthetic */ int m(int i, int i2) {
        return (int) ((((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) / (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    public static /* synthetic */ String m(CharSequence charSequence, CharSequence[] charSequenceArr) {
        if (charSequence != null) {
            StringBuilder sb = new StringBuilder();
            if (charSequenceArr.length > 0) {
                sb.append(charSequenceArr[0]);
                for (int i = 1; i < charSequenceArr.length; i++) {
                    sb.append(charSequence);
                    sb.append(charSequenceArr[i]);
                }
            }
            return sb.toString();
        }
        throw new NullPointerException("delimiter");
    }

    public static /* synthetic */ int m$1(int i, int i2) {
        return (int) ((((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT) % (((long) i2) & InternalZipConstants.ZIP_64_SIZE_LIMIT));
    }

    public static /* synthetic */ long m$1(long j, long j2) {
        if (j2 < 0) {
            return (j ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE) ? 0 : 1;
        }
        if (j >= 0) {
            return j / j2;
        }
        int i = 1;
        long j3 = ((j >>> 1) / j2) << 1;
        if (((j - (j3 * j2)) ^ Long.MIN_VALUE) < (j2 ^ Long.MIN_VALUE)) {
            i = 0;
        }
        return j3 + ((long) i);
    }
}
