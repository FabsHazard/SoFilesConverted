package org.greenrobot.essentials.hash;

import java.io.UnsupportedEncodingException;
import java.util.zip.Checksum;

public class PrimitiveDataChecksum implements Checksum {
    private final Checksum checksum;

    public PrimitiveDataChecksum(Checksum checksum2) {
        this.checksum = checksum2;
    }

    public void update(int i) {
        this.checksum.update(i);
    }

    public void update(byte[] bArr, int i, int i2) {
        this.checksum.update(bArr, i, i2);
    }

    public long getValue() {
        return this.checksum.getValue();
    }

    public void reset() {
        this.checksum.reset();
    }

    public void updateUtf8(String str) {
        if (str != null) {
            try {
                byte[] bytes = str.getBytes("UTF-8");
                update(bytes, 0, bytes.length);
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void updateUtf8(String[] strArr) {
        if (strArr != null) {
            for (String updateUtf8 : strArr) {
                updateUtf8(updateUtf8);
            }
        }
    }

    public void updateBoolean(boolean z) {
        update(z ? 1 : 0);
    }

    public void updateShort(short s) {
        update((s >>> 8) & 255);
        update((int) s & 255);
    }

    public void updateInt(int i) {
        update((i >>> 24) & 255);
        update((i >>> 16) & 255);
        update((i >>> 8) & 255);
        update(i & 255);
    }

    public void updateLong(long j) {
        update(((int) (j >>> 56)) & 255);
        update(((int) (j >>> 48)) & 255);
        update(((int) (j >>> 40)) & 255);
        update(((int) (j >>> 32)) & 255);
        update(((int) (j >>> 24)) & 255);
        update(((int) (j >>> 16)) & 255);
        update(((int) (j >>> 8)) & 255);
        update((int) (j & 255));
    }

    public void updateFloat(float f) {
        updateInt(Float.floatToIntBits(f));
    }

    public void updateDouble(double d) {
        updateLong(Double.doubleToLongBits(d));
    }

    public void update(byte[] bArr) {
        if (bArr != null) {
            update(bArr, 0, bArr.length);
        }
    }

    public void update(short[] sArr) {
        if (sArr != null) {
            for (short updateShort : sArr) {
                updateShort(updateShort);
            }
        }
    }

    public void update(int[] iArr) {
        if (iArr != null) {
            for (int updateInt : iArr) {
                updateInt(updateInt);
            }
        }
    }

    public void update(long[] jArr) {
        if (jArr != null) {
            for (long updateLong : jArr) {
                updateLong(updateLong);
            }
        }
    }

    public void update(float[] fArr) {
        if (fArr != null) {
            for (float updateFloat : fArr) {
                updateFloat(updateFloat);
            }
        }
    }

    public void update(double[] dArr) {
        if (dArr != null) {
            for (double updateDouble : dArr) {
                updateDouble(updateDouble);
            }
        }
    }
}
