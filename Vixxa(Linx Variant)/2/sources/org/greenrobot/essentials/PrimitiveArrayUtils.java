package org.greenrobot.essentials;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteOrder;
import java.util.NoSuchElementException;
import kotlin.UByte;
import kotlin.jvm.internal.CharCompanionObject;
import sun.misc.Unsafe;

public abstract class PrimitiveArrayUtils {
    private static final PrimitiveArrayUtils instanceSafe = new SafeImpl();
    private static volatile PrimitiveArrayUtils instanceUnsafe;

    public abstract int getIntBE(byte[] bArr, int i);

    public abstract int getIntLE(byte[] bArr, int i);

    public abstract int getIntLE(char[] cArr, int i);

    public abstract long getLongBE(byte[] bArr, int i);

    public abstract long getLongLE(byte[] bArr, int i);

    public static PrimitiveArrayUtils getInstance() {
        PrimitiveArrayUtils primitiveArrayUtils = instanceUnsafe;
        return primitiveArrayUtils == null ? instanceSafe : primitiveArrayUtils;
    }

    public static boolean initUnsafeInstance() {
        if (instanceUnsafe != null || UnsafeImpl.UNSAFE == null) {
            return false;
        }
        synchronized (PrimitiveArrayUtils.class) {
            if (instanceUnsafe != null) {
                return true;
            }
            try {
                instanceUnsafe = new UnsafeImpl();
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }

    public static PrimitiveArrayUtils getInstanceSafe() {
        return instanceSafe;
    }

    private static class UnsafeImpl extends PrimitiveArrayUtils {
        private static final boolean BIG_ENDIAN = ByteOrder.nativeOrder().equals(ByteOrder.BIG_ENDIAN);
        private static final long BYTE_ARRAY_OFFSET;
        private static final long CHAR_ARRAY_OFFSET;
        private static final boolean UNALIGNED;
        /* access modifiers changed from: private */
        public static final Unsafe UNSAFE;

        private UnsafeImpl() {
        }

        static {
            boolean initUnaligned = initUnaligned();
            UNALIGNED = initUnaligned;
            if (initUnaligned) {
                Unsafe initUnsafe = initUnsafe();
                UNSAFE = initUnsafe;
                if (initUnsafe != null) {
                    BYTE_ARRAY_OFFSET = (long) initUnsafe.arrayBaseOffset(byte[].class);
                    CHAR_ARRAY_OFFSET = (long) initUnsafe.arrayBaseOffset(char[].class);
                    return;
                }
                BYTE_ARRAY_OFFSET = 0;
                CHAR_ARRAY_OFFSET = 0;
                return;
            }
            UNSAFE = null;
            BYTE_ARRAY_OFFSET = 0;
            CHAR_ARRAY_OFFSET = 0;
        }

        private static boolean initUnaligned() {
            String property = System.getProperty("java.vendor");
            if (property != null && property.contains("Android")) {
                return guessUnalignedFromOsArch();
            }
            try {
                Method declaredMethod = Class.forName("java.nio.Bits", false, ClassLoader.getSystemClassLoader()).getDeclaredMethod("unaligned", new Class[0]);
                declaredMethod.setAccessible(true);
                return Boolean.TRUE.equals(declaredMethod.invoke((Object) null, new Object[0]));
            } catch (Throwable unused) {
                return guessUnalignedFromOsArch();
            }
        }

        private static boolean guessUnalignedFromOsArch() {
            String property = System.getProperty("os.arch");
            return property != null && property.matches("^(i[3-6]86|x86(_64)?|x64|amd64)$");
        }

        private static Unsafe initUnsafe() {
            Field field;
            try {
                field = Unsafe.class.getDeclaredField("theUnsafe");
            } catch (NoSuchElementException unused) {
                field = Unsafe.class.getDeclaredField("THE_ONE");
            } catch (Throwable unused2) {
            }
            field.setAccessible(true);
            Unsafe unsafe = (Unsafe) field.get((Object) null);
            int i = unsafe.getInt(new byte[]{-54, -2, -70, -66}, (long) unsafe.arrayBaseOffset(byte[].class));
            if (i == -889275714) {
                if (BIG_ENDIAN) {
                    return unsafe;
                }
                System.err.println("Big endian confusion");
            } else if (i == -1095041334) {
                if (!BIG_ENDIAN) {
                    return unsafe;
                }
                System.err.println("Little endian confusion");
            }
            return null;
        }

        public int getIntLE(byte[] bArr, int i) {
            int i2 = UNSAFE.getInt(bArr, BYTE_ARRAY_OFFSET + ((long) i));
            return BIG_ENDIAN ? Integer.reverseBytes(i2) : i2;
        }

        public int getIntLE(char[] cArr, int i) {
            int i2 = UNSAFE.getInt(cArr, CHAR_ARRAY_OFFSET + ((long) (i << 2)));
            return BIG_ENDIAN ? Integer.reverseBytes(i2) : i2;
        }

        public int getIntBE(byte[] bArr, int i) {
            int i2 = UNSAFE.getInt(bArr, BYTE_ARRAY_OFFSET + ((long) i));
            if (BIG_ENDIAN) {
                return i2;
            }
            return Integer.reverseBytes(i2);
        }

        public long getLongLE(byte[] bArr, int i) {
            long j = UNSAFE.getLong(bArr, BYTE_ARRAY_OFFSET + ((long) i));
            return BIG_ENDIAN ? Long.reverseBytes(j) : j;
        }

        public long getLongBE(byte[] bArr, int i) {
            long j = UNSAFE.getLong(bArr, BYTE_ARRAY_OFFSET + ((long) i));
            if (BIG_ENDIAN) {
                return j;
            }
            return Long.reverseBytes(j);
        }
    }

    private static class SafeImpl extends PrimitiveArrayUtils {
        private SafeImpl() {
        }

        public int getIntLE(byte[] bArr, int i) {
            return (bArr[i + 3] << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }

        public int getIntBE(byte[] bArr, int i) {
            return (bArr[i] << 24) | (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8) | ((bArr[i + 1] & UByte.MAX_VALUE) << 16);
        }

        public long getLongLE(byte[] bArr, int i) {
            return (((long) bArr[i + 7]) << 56) | ((long) ((bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16))) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }

        public long getLongBE(byte[] bArr, int i) {
            return (((long) bArr[i]) << 56) | ((long) ((bArr[i + 7] & UByte.MAX_VALUE) | ((bArr[i + 6] & UByte.MAX_VALUE) << 8) | ((bArr[i + 5] & UByte.MAX_VALUE) << 16))) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 1]) & 255) << 48);
        }

        public int getIntLE(char[] cArr, int i) {
            return ((cArr[i + 1] & CharCompanionObject.MAX_VALUE) << 16) | (cArr[i] & CharCompanionObject.MAX_VALUE);
        }
    }
}
