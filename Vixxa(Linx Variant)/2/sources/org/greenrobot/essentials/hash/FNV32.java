package org.greenrobot.essentials.hash;

import java.util.zip.Checksum;
import kotlin.UByte;
import net.lingala.zip4j.util.InternalZipConstants;

public class FNV32 implements Checksum {
    private static final int INITIAL_VALUE = -2128831035;
    private static final int MULTIPLIER = 16777619;
    private int hash = INITIAL_VALUE;

    public void update(int i) {
        this.hash = ((i & 255) ^ this.hash) * MULTIPLIER;
    }

    public void update(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            this.hash = (this.hash ^ (bArr[i] & UByte.MAX_VALUE)) * MULTIPLIER;
            i++;
        }
    }

    public long getValue() {
        return ((long) this.hash) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    public void reset() {
        this.hash = INITIAL_VALUE;
    }
}
