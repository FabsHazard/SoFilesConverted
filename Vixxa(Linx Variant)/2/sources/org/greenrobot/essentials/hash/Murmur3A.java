package org.greenrobot.essentials.hash;

import java.util.zip.Checksum;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;
import okhttp3.internal.ws.WebSocketProtocol;
import org.greenrobot.essentials.PrimitiveArrayUtils;

public class Murmur3A implements Checksum {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static PrimitiveArrayUtils primitiveArrayUtils = PrimitiveArrayUtils.getInstance();
    private int h1;
    private int length;
    private int partialK1;
    private int partialK1Pos;
    private final int seed;

    public Murmur3A() {
        this.seed = 0;
    }

    public Murmur3A(int i) {
        this.seed = i;
        this.h1 = i;
    }

    public void update(int i) {
        int i2 = this.partialK1Pos;
        if (i2 == 0) {
            this.partialK1 = i & 255;
            this.partialK1Pos = 1;
        } else if (i2 == 1) {
            this.partialK1 = ((i & 255) << 8) | this.partialK1;
            this.partialK1Pos = 2;
        } else if (i2 == 2) {
            this.partialK1 = ((i & 255) << 16) | this.partialK1;
            this.partialK1Pos = 3;
        } else if (i2 == 3) {
            int i3 = ((i & 255) << 24) | this.partialK1;
            this.partialK1 = i3;
            applyK1(i3);
            this.partialK1Pos = 0;
        }
        this.length++;
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.partialK1Pos != 0 && i2 > 0) {
            update((int) bArr[i]);
            i++;
            i2--;
        }
        int i3 = i2 & 3;
        int i4 = (i2 + i) - i3;
        for (int i5 = i; i5 < i4; i5 += 4) {
            applyK1(primitiveArrayUtils.getIntLE(bArr, i5));
        }
        this.length += i4 - i;
        for (int i6 = 0; i6 < i3; i6++) {
            update((int) bArr[i4 + i6]);
        }
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void updateShort(short s) {
        int i = this.partialK1Pos;
        if (i == 0) {
            this.partialK1 = s & UShort.MAX_VALUE;
            this.partialK1Pos = 2;
        } else if (i == 1) {
            this.partialK1 = ((s & UShort.MAX_VALUE) << 8) | this.partialK1;
            this.partialK1Pos = 3;
        } else if (i == 2) {
            int i2 = ((s & UShort.MAX_VALUE) << 16) | this.partialK1;
            this.partialK1 = i2;
            applyK1(i2);
            this.partialK1Pos = 0;
        } else if (i == 3) {
            int i3 = this.partialK1 | ((s & 255) << 24);
            this.partialK1 = i3;
            applyK1(i3);
            this.partialK1 = (s >> 8) & 255;
            this.partialK1Pos = 1;
        }
        this.length += 2;
    }

    public void updateShort(short... sArr) {
        int i;
        int length2 = sArr.length;
        int i2 = 0;
        if (length2 <= 0 || !((i = this.partialK1Pos) == 0 || i == 2)) {
            int length3 = sArr.length;
            while (i2 < length3) {
                updateShort(sArr[i2]);
                i2++;
            }
            return;
        }
        if (i == 2) {
            int i3 = this.partialK1 | ((sArr[0] & UShort.MAX_VALUE) << 16);
            this.partialK1 = i3;
            applyK1(i3);
            this.partialK1Pos = 0;
            length2--;
            i2 = 1;
        }
        int i4 = (length2 & -2) + i2;
        while (i2 < i4) {
            applyK1((sArr[i2] & UShort.MAX_VALUE) | ((sArr[i2 + 1] & UShort.MAX_VALUE) << 16));
            i2 += 2;
        }
        if (i4 < sArr.length) {
            this.partialK1 = sArr[i4] & UShort.MAX_VALUE;
            this.partialK1Pos = 2;
        }
        this.length += sArr.length * 2;
    }

    public void updateInt(int i) {
        int i2 = this.partialK1Pos;
        if (i2 == 0) {
            applyK1(i);
        } else if (i2 == 1) {
            int i3 = this.partialK1 | ((16777215 & i) << 8);
            this.partialK1 = i3;
            applyK1(i3);
            this.partialK1 = i >>> 24;
        } else if (i2 == 2) {
            int i4 = this.partialK1 | ((65535 & i) << 16);
            this.partialK1 = i4;
            applyK1(i4);
            this.partialK1 = i >>> 16;
        } else if (i2 == 3) {
            int i5 = this.partialK1 | ((i & 255) << 24);
            this.partialK1 = i5;
            applyK1(i5);
            this.partialK1 = i >>> 8;
        }
        this.length += 4;
    }

    public void updateInt(int... iArr) {
        int i = 0;
        if (this.partialK1Pos == 0) {
            int length2 = iArr.length;
            while (i < length2) {
                applyK1(iArr[i]);
                i++;
            }
            this.length += iArr.length * 4;
            return;
        }
        int length3 = iArr.length;
        while (i < length3) {
            updateInt(iArr[i]);
            i++;
        }
    }

    public void updateLong(long j) {
        int i = this.partialK1Pos;
        if (i == 0) {
            applyK1((int) j);
            applyK1((int) (j >>> 32));
        } else if (i == 1) {
            int i2 = (int) (((long) this.partialK1) | ((16777215 & j) << 8));
            this.partialK1 = i2;
            applyK1(i2);
            applyK1((int) (j >>> 24));
            this.partialK1 = (int) (j >>> 56);
        } else if (i == 2) {
            int i3 = (int) (((long) this.partialK1) | ((WebSocketProtocol.PAYLOAD_SHORT_MAX & j) << 16));
            this.partialK1 = i3;
            applyK1(i3);
            applyK1((int) (j >>> 16));
            this.partialK1 = (int) (j >>> 48);
        } else if (i == 3) {
            int i4 = (int) (((255 & j) << 24) | ((long) this.partialK1));
            this.partialK1 = i4;
            applyK1(i4);
            applyK1((int) (j >>> 8));
            this.partialK1 = (int) (j >>> 40);
        }
        this.length += 8;
    }

    public void updateLong(long... jArr) {
        int i = 0;
        if (this.partialK1Pos == 0) {
            int length2 = jArr.length;
            while (i < length2) {
                long j = jArr[i];
                applyK1((int) j);
                applyK1((int) (j >>> 32));
                i++;
            }
            this.length += jArr.length * 8;
            return;
        }
        int length3 = jArr.length;
        while (i < length3) {
            updateLong(jArr[i]);
            i++;
        }
    }

    public void updateFloat(float f) {
        updateInt(Float.floatToIntBits(f));
    }

    public void updateDouble(double d) {
        updateLong(Double.doubleToLongBits(d));
    }

    public void updateBoolean(boolean z) {
        update(z ? 1 : 0);
    }

    private void applyK1(int i) {
        int i2 = i * C1;
        int i3 = (((i2 >>> 17) | (i2 << 15)) * C2) ^ this.h1;
        this.h1 = (((i3 >>> 19) | (i3 << 13)) * 5) - 430675100;
    }

    public long getValue() {
        int i = this.h1;
        if (this.partialK1Pos > 0) {
            int i2 = this.partialK1 * C1;
            i ^= ((i2 >>> 17) | (i2 << 15)) * C2;
        }
        int i3 = i ^ this.length;
        int i4 = (i3 ^ (i3 >>> 16)) * -2048144789;
        int i5 = (i4 ^ (i4 >>> 13)) * -1028477387;
        return ((long) (i5 ^ (i5 >>> 16))) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
    }

    public void reset() {
        this.h1 = this.seed;
        this.length = 0;
        this.partialK1Pos = 0;
    }
}
