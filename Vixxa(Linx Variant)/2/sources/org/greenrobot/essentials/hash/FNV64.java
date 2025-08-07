package org.greenrobot.essentials.hash;

import java.util.zip.Checksum;

public class FNV64 implements Checksum {
    private static final long INITIAL_VALUE = -3750763034362895579L;
    private static final long MULTIPLIER = 1099511628211L;
    private long hash = INITIAL_VALUE;

    public void update(int i) {
        this.hash = (this.hash ^ (255 & ((long) i))) * MULTIPLIER;
    }

    public void update(byte[] bArr, int i, int i2) {
        int i3 = i2 + i;
        while (i < i3) {
            this.hash = (this.hash ^ (((long) bArr[i]) & 255)) * MULTIPLIER;
            i++;
        }
    }

    public long getValue() {
        return this.hash;
    }

    public void reset() {
        this.hash = INITIAL_VALUE;
    }
}
