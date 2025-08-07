package io.objectbox.flatbuffers;

import com.github.mikephil.charting.utils.Utils;
import java.nio.ByteBuffer;
import kotlin.UByte;
import kotlin.UShort;
import kotlin.text.Typography;
import net.lingala.zip4j.util.InternalZipConstants;

public class FlexBuffers {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    /* access modifiers changed from: private */
    public static final ReadBuf EMPTY_BB = new ArrayReadWriteBuf(new byte[]{0}, 1);
    public static final int FBT_BLOB = 25;
    public static final int FBT_BOOL = 26;
    public static final int FBT_FLOAT = 3;
    public static final int FBT_INDIRECT_FLOAT = 8;
    public static final int FBT_INDIRECT_INT = 6;
    public static final int FBT_INDIRECT_UINT = 7;
    public static final int FBT_INT = 1;
    public static final int FBT_KEY = 4;
    public static final int FBT_MAP = 9;
    public static final int FBT_NULL = 0;
    public static final int FBT_STRING = 5;
    public static final int FBT_UINT = 2;
    public static final int FBT_VECTOR = 10;
    public static final int FBT_VECTOR_BOOL = 36;
    public static final int FBT_VECTOR_FLOAT = 13;
    public static final int FBT_VECTOR_FLOAT2 = 18;
    public static final int FBT_VECTOR_FLOAT3 = 21;
    public static final int FBT_VECTOR_FLOAT4 = 24;
    public static final int FBT_VECTOR_INT = 11;
    public static final int FBT_VECTOR_INT2 = 16;
    public static final int FBT_VECTOR_INT3 = 19;
    public static final int FBT_VECTOR_INT4 = 22;
    public static final int FBT_VECTOR_KEY = 14;
    public static final int FBT_VECTOR_STRING_DEPRECATED = 15;
    public static final int FBT_VECTOR_UINT = 12;
    public static final int FBT_VECTOR_UINT2 = 17;
    public static final int FBT_VECTOR_UINT3 = 20;
    public static final int FBT_VECTOR_UINT4 = 23;

    static boolean isTypeInline(int i) {
        return i <= 3 || i == 26;
    }

    static boolean isTypedVector(int i) {
        return (i >= 11 && i <= 15) || i == 36;
    }

    static boolean isTypedVectorElementType(int i) {
        return (i >= 1 && i <= 4) || i == 26;
    }

    static int toTypedVector(int i, int i2) {
        if (i2 == 0) {
            return i + 10;
        }
        if (i2 == 2) {
            return i + 15;
        }
        if (i2 == 3) {
            return i + 18;
        }
        if (i2 != 4) {
            return 0;
        }
        return i + 21;
    }

    static int toTypedVectorElementType(int i) {
        return i - 10;
    }

    /* access modifiers changed from: private */
    public static int indirect(ReadBuf readBuf, int i, int i2) {
        return (int) (((long) i) - readUInt(readBuf, i, i2));
    }

    /* access modifiers changed from: private */
    public static long readUInt(ReadBuf readBuf, int i, int i2) {
        if (i2 == 1) {
            return (long) Unsigned.byteToUnsignedInt(readBuf.get(i));
        }
        if (i2 == 2) {
            return (long) Unsigned.shortToUnsignedInt(readBuf.getShort(i));
        }
        if (i2 == 4) {
            return Unsigned.intToUnsignedLong(readBuf.getInt(i));
        }
        if (i2 != 8) {
            return -1;
        }
        return readBuf.getLong(i);
    }

    /* access modifiers changed from: private */
    public static int readInt(ReadBuf readBuf, int i, int i2) {
        return (int) readLong(readBuf, i, i2);
    }

    /* access modifiers changed from: private */
    public static long readLong(ReadBuf readBuf, int i, int i2) {
        int i3;
        if (i2 == 1) {
            i3 = readBuf.get(i);
        } else if (i2 == 2) {
            i3 = readBuf.getShort(i);
        } else if (i2 == 4) {
            i3 = readBuf.getInt(i);
        } else if (i2 != 8) {
            return -1;
        } else {
            return readBuf.getLong(i);
        }
        return (long) i3;
    }

    /* access modifiers changed from: private */
    public static double readDouble(ReadBuf readBuf, int i, int i2) {
        if (i2 == 4) {
            return (double) readBuf.getFloat(i);
        }
        if (i2 != 8) {
            return -1.0d;
        }
        return readBuf.getDouble(i);
    }

    @Deprecated
    public static Reference getRoot(ByteBuffer byteBuffer) {
        return getRoot(byteBuffer.hasArray() ? new ArrayReadWriteBuf(byteBuffer.array(), byteBuffer.limit()) : new ByteBufferReadWriteBuf(byteBuffer));
    }

    public static Reference getRoot(ReadBuf readBuf) {
        int limit = readBuf.limit();
        byte b = readBuf.get(limit - 1);
        int i = limit - 2;
        return new Reference(readBuf, i - b, b, Unsigned.byteToUnsignedInt(readBuf.get(i)));
    }

    public static class Reference {
        /* access modifiers changed from: private */
        public static final Reference NULL_REFERENCE = new Reference(FlexBuffers.EMPTY_BB, 0, 1, 0);
        private ReadBuf bb;
        private int byteWidth;
        private int end;
        private int parentWidth;
        private int type;

        Reference(ReadBuf readBuf, int i, int i2, int i3) {
            this(readBuf, i, i2, 1 << (i3 & 3), i3 >> 2);
        }

        Reference(ReadBuf readBuf, int i, int i2, int i3, int i4) {
            this.bb = readBuf;
            this.end = i;
            this.parentWidth = i2;
            this.byteWidth = i3;
            this.type = i4;
        }

        public int getType() {
            return this.type;
        }

        public boolean isNull() {
            return this.type == 0;
        }

        public boolean isBoolean() {
            return this.type == 26;
        }

        public boolean isNumeric() {
            return isIntOrUInt() || isFloat();
        }

        public boolean isIntOrUInt() {
            return isInt() || isUInt();
        }

        public boolean isFloat() {
            int i = this.type;
            return i == 3 || i == 8;
        }

        public boolean isInt() {
            int i = this.type;
            return i == 1 || i == 6;
        }

        public boolean isUInt() {
            int i = this.type;
            return i == 2 || i == 7;
        }

        public boolean isString() {
            return this.type == 5;
        }

        public boolean isKey() {
            return this.type == 4;
        }

        public boolean isVector() {
            int i = this.type;
            return i == 10 || i == 9;
        }

        public boolean isTypedVector() {
            return FlexBuffers.isTypedVector(this.type);
        }

        public boolean isMap() {
            return this.type == 9;
        }

        public boolean isBlob() {
            return this.type == 25;
        }

        public int asInt() {
            int i = this.type;
            if (i == 1) {
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 2) {
                return (int) FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 3) {
                return (int) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 5) {
                return Integer.parseInt(asString());
            }
            if (i == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            } else if (i == 7) {
                ReadBuf readBuf2 = this.bb;
                return (int) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            } else if (i == 8) {
                ReadBuf readBuf3 = this.bb;
                return (int) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            } else if (i == 10) {
                return asVector().size();
            } else {
                if (i != 26) {
                    return 0;
                }
                return FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
        }

        public long asUInt() {
            int i = this.type;
            if (i == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i == 3) {
                return (long) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 10) {
                return (long) asVector().size();
            }
            if (i == 26) {
                return (long) FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 5) {
                return Long.parseLong(asString());
            }
            if (i == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            } else if (i == 7) {
                ReadBuf readBuf2 = this.bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
            } else if (i != 8) {
                return 0;
            } else {
                ReadBuf readBuf3 = this.bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.parentWidth);
            }
        }

        public long asLong() {
            int i = this.type;
            if (i == 1) {
                return FlexBuffers.readLong(this.bb, this.end, this.parentWidth);
            }
            if (i == 2) {
                return FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
            }
            if (i == 3) {
                return (long) FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 5) {
                try {
                    return Long.parseLong(asString());
                } catch (NumberFormatException unused) {
                    return 0;
                }
            } else if (i == 6) {
                ReadBuf readBuf = this.bb;
                return FlexBuffers.readLong(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            } else if (i == 7) {
                ReadBuf readBuf2 = this.bb;
                return FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.parentWidth);
            } else if (i == 8) {
                ReadBuf readBuf3 = this.bb;
                return (long) FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
            } else if (i == 10) {
                return (long) asVector().size();
            } else {
                if (i != 26) {
                    return 0;
                }
                return (long) FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
        }

        public double asFloat() {
            int i = this.type;
            if (i == 3) {
                return FlexBuffers.readDouble(this.bb, this.end, this.parentWidth);
            }
            if (i == 1) {
                return (double) FlexBuffers.readInt(this.bb, this.end, this.parentWidth);
            }
            if (i != 2) {
                if (i == 5) {
                    return Double.parseDouble(asString());
                }
                if (i == 6) {
                    ReadBuf readBuf = this.bb;
                    return (double) FlexBuffers.readInt(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
                } else if (i == 7) {
                    ReadBuf readBuf2 = this.bb;
                    return (double) FlexBuffers.readUInt(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth);
                } else if (i == 8) {
                    ReadBuf readBuf3 = this.bb;
                    return FlexBuffers.readDouble(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth);
                } else if (i == 10) {
                    return (double) asVector().size();
                } else {
                    if (i != 26) {
                        return Utils.DOUBLE_EPSILON;
                    }
                }
            }
            return (double) FlexBuffers.readUInt(this.bb, this.end, this.parentWidth);
        }

        public Key asKey() {
            if (!isKey()) {
                return Key.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Key(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public String asString() {
            if (isString()) {
                int access$200 = FlexBuffers.indirect(this.bb, this.end, this.parentWidth);
                ReadBuf readBuf = this.bb;
                int i = this.byteWidth;
                return this.bb.getString(access$200, (int) FlexBuffers.readUInt(readBuf, access$200 - i, i));
            } else if (!isKey()) {
                return "";
            } else {
                int access$2002 = FlexBuffers.indirect(this.bb, this.end, this.byteWidth);
                int i2 = access$2002;
                while (this.bb.get(i2) != 0) {
                    i2++;
                }
                return this.bb.getString(access$2002, i2 - access$2002);
            }
        }

        public Map asMap() {
            if (!isMap()) {
                return Map.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Map(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public Vector asVector() {
            if (isVector()) {
                ReadBuf readBuf = this.bb;
                return new Vector(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
            }
            int i = this.type;
            if (i == 15) {
                ReadBuf readBuf2 = this.bb;
                return new TypedVector(readBuf2, FlexBuffers.indirect(readBuf2, this.end, this.parentWidth), this.byteWidth, 4);
            } else if (!FlexBuffers.isTypedVector(i)) {
                return Vector.empty();
            } else {
                ReadBuf readBuf3 = this.bb;
                return new TypedVector(readBuf3, FlexBuffers.indirect(readBuf3, this.end, this.parentWidth), this.byteWidth, FlexBuffers.toTypedVectorElementType(this.type));
            }
        }

        public Blob asBlob() {
            if (!isBlob() && !isString()) {
                return Blob.empty();
            }
            ReadBuf readBuf = this.bb;
            return new Blob(readBuf, FlexBuffers.indirect(readBuf, this.end, this.parentWidth), this.byteWidth);
        }

        public boolean asBoolean() {
            if (isBoolean()) {
                if (this.bb.get(this.end) != 0) {
                    return true;
                }
                return false;
            } else if (asUInt() != 0) {
                return true;
            } else {
                return false;
            }
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }

        /* access modifiers changed from: package-private */
        public StringBuilder toString(StringBuilder sb) {
            int i = this.type;
            if (i != 36) {
                switch (i) {
                    case 0:
                        return sb.append("null");
                    case 1:
                    case 6:
                        return sb.append(asLong());
                    case 2:
                    case 7:
                        return sb.append(asUInt());
                    case 3:
                    case 8:
                        return sb.append(asFloat());
                    case 4:
                        return asKey().toString(sb.append(Typography.quote)).append(Typography.quote);
                    case 5:
                        return sb.append(Typography.quote).append(asString()).append(Typography.quote);
                    case 9:
                        return asMap().toString(sb);
                    case 10:
                        return asVector().toString(sb);
                    case 11:
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                        break;
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                        throw new FlexBufferException("not_implemented:" + this.type);
                    case 25:
                        return asBlob().toString(sb);
                    case 26:
                        return sb.append(asBoolean());
                    default:
                        return sb;
                }
            }
            return sb.append(asVector());
        }
    }

    private static abstract class Object {
        ReadBuf bb;
        int byteWidth;
        int end;

        public abstract StringBuilder toString(StringBuilder sb);

        Object(ReadBuf readBuf, int i, int i2) {
            this.bb = readBuf;
            this.end = i;
            this.byteWidth = i2;
        }

        public String toString() {
            return toString(new StringBuilder(128)).toString();
        }
    }

    private static abstract class Sized extends Object {
        protected final int size;

        Sized(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
            this.size = (int) FlexBuffers.readUInt(this.bb, i - i2, i2);
        }

        public int size() {
            return this.size;
        }
    }

    public static class Blob extends Sized {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        static final Blob EMPTY = new Blob(FlexBuffers.EMPTY_BB, 1, 1);

        static {
            Class<FlexBuffers> cls = FlexBuffers.class;
        }

        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        Blob(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Blob empty() {
            return EMPTY;
        }

        public ByteBuffer data() {
            ByteBuffer wrap = ByteBuffer.wrap(this.bb.data());
            wrap.position(this.end);
            wrap.limit(this.end + size());
            return wrap.asReadOnlyBuffer().slice();
        }

        public byte[] getBytes() {
            int size = size();
            byte[] bArr = new byte[size];
            for (int i = 0; i < size; i++) {
                bArr[i] = this.bb.get(this.end + i);
            }
            return bArr;
        }

        public byte get(int i) {
            return this.bb.get(this.end + i);
        }

        public String toString() {
            return this.bb.getString(this.end, size());
        }

        public StringBuilder toString(StringBuilder sb) {
            sb.append(Typography.quote);
            sb.append(this.bb.getString(this.end, size()));
            return sb.append(Typography.quote);
        }
    }

    public static class Key extends Object {
        /* access modifiers changed from: private */
        public static final Key EMPTY = new Key(FlexBuffers.EMPTY_BB, 0, 0);

        Key(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Key empty() {
            return EMPTY;
        }

        public StringBuilder toString(StringBuilder sb) {
            return sb.append(toString());
        }

        public String toString() {
            int i = this.end;
            while (this.bb.get(i) != 0) {
                i++;
            }
            return this.bb.getString(this.end, i - this.end);
        }

        /* access modifiers changed from: package-private */
        public int compareTo(byte[] bArr) {
            byte b;
            byte b2;
            int i = this.end;
            int i2 = 0;
            do {
                b = this.bb.get(i);
                b2 = bArr[i2];
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
                if (i2 == bArr.length) {
                    int i3 = b - b2;
                    if (i3 != 0 || this.bb.get(i) == 0) {
                        return i3;
                    }
                    return 1;
                }
            } while (b == b2);
            return b - b2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Key)) {
                return false;
            }
            Key key = (Key) obj;
            if (key.end == this.end && key.byteWidth == this.byteWidth) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.end ^ this.byteWidth;
        }
    }

    public static class Map extends Vector {
        private static final Map EMPTY_MAP = new Map(FlexBuffers.EMPTY_BB, 1, 1);
        private final byte[] comparisonBuffer = new byte[4];

        Map(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Map empty() {
            return EMPTY_MAP;
        }

        public Reference get(String str) {
            int binarySearch = binarySearch((CharSequence) str);
            if (binarySearch < 0 || binarySearch >= this.size) {
                return Reference.NULL_REFERENCE;
            }
            return get(binarySearch);
        }

        public Reference get(byte[] bArr) {
            int binarySearch = binarySearch(bArr);
            if (binarySearch < 0 || binarySearch >= this.size) {
                return Reference.NULL_REFERENCE;
            }
            return get(binarySearch);
        }

        public KeyVector keys() {
            int i = this.end - (this.byteWidth * 3);
            return new KeyVector(new TypedVector(this.bb, FlexBuffers.indirect(this.bb, i, this.byteWidth), FlexBuffers.readInt(this.bb, i + this.byteWidth, this.byteWidth), 4));
        }

        public Vector values() {
            return new Vector(this.bb, this.end, this.byteWidth);
        }

        public StringBuilder toString(StringBuilder sb) {
            sb.append("{ ");
            KeyVector keys = keys();
            int size = size();
            Vector values = values();
            for (int i = 0; i < size; i++) {
                sb.append(Typography.quote).append(keys.get(i).toString()).append("\" : ");
                sb.append(values.get(i).toString());
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" }");
            return sb;
        }

        private int binarySearch(CharSequence charSequence) {
            int i = this.size - 1;
            int i2 = this.end - (this.byteWidth * 3);
            int access$200 = FlexBuffers.indirect(this.bb, i2, this.byteWidth);
            int access$100 = FlexBuffers.readInt(this.bb, i2 + this.byteWidth, this.byteWidth);
            int i3 = 0;
            while (i3 <= i) {
                int i4 = (i3 + i) >>> 1;
                int compareCharSequence = compareCharSequence(FlexBuffers.indirect(this.bb, (i4 * access$100) + access$200, access$100), charSequence);
                if (compareCharSequence < 0) {
                    i3 = i4 + 1;
                } else if (compareCharSequence <= 0) {
                    return i4;
                } else {
                    i = i4 - 1;
                }
            }
            return -(i3 + 1);
        }

        private int binarySearch(byte[] bArr) {
            int i = this.size - 1;
            int i2 = this.end - (this.byteWidth * 3);
            int access$200 = FlexBuffers.indirect(this.bb, i2, this.byteWidth);
            int access$100 = FlexBuffers.readInt(this.bb, i2 + this.byteWidth, this.byteWidth);
            int i3 = 0;
            while (i3 <= i) {
                int i4 = (i3 + i) >>> 1;
                int compareBytes = compareBytes(this.bb, FlexBuffers.indirect(this.bb, (i4 * access$100) + access$200, access$100), bArr);
                if (compareBytes < 0) {
                    i3 = i4 + 1;
                } else if (compareBytes <= 0) {
                    return i4;
                } else {
                    i = i4 - 1;
                }
            }
            return -(i3 + 1);
        }

        private int compareBytes(ReadBuf readBuf, int i, byte[] bArr) {
            byte b;
            byte b2;
            int i2 = 0;
            do {
                b = readBuf.get(i);
                b2 = bArr[i2];
                if (b == 0) {
                    return b - b2;
                }
                i++;
                i2++;
                if (i2 == bArr.length) {
                    int i3 = b - b2;
                    if (i3 != 0 || readBuf.get(i) == 0) {
                        return i3;
                    }
                    return 1;
                }
            } while (b == b2);
            return b - b2;
        }

        private int compareCharSequence(int i, CharSequence charSequence) {
            int limit = this.bb.limit();
            int length = charSequence.length();
            int i2 = 0;
            while (i2 < length) {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                byte b = this.bb.get(i);
                if (b == 0) {
                    return -charAt;
                }
                if (b < 0) {
                    break;
                } else if (((char) b) != charAt) {
                    return b - charAt;
                } else {
                    i++;
                    i2++;
                }
            }
            while (i < limit) {
                int encodeUtf8CodePoint = Utf8.encodeUtf8CodePoint(charSequence, i2, this.comparisonBuffer);
                if (encodeUtf8CodePoint == 0) {
                    return this.bb.get(i);
                }
                int i3 = 0;
                while (i3 < encodeUtf8CodePoint) {
                    int i4 = i + 1;
                    byte b2 = this.bb.get(i);
                    byte b3 = this.comparisonBuffer[i3];
                    if (b2 == 0) {
                        return -b3;
                    }
                    if (b2 != b3) {
                        return b2 - b3;
                    }
                    i3++;
                    i = i4;
                }
                i2 += encodeUtf8CodePoint == 4 ? 2 : 1;
            }
            return 0;
        }
    }

    public static class Vector extends Sized {
        private static final Vector EMPTY_VECTOR = new Vector(FlexBuffers.EMPTY_BB, 1, 1);

        public /* bridge */ /* synthetic */ int size() {
            return super.size();
        }

        public /* bridge */ /* synthetic */ String toString() {
            return super.toString();
        }

        Vector(ReadBuf readBuf, int i, int i2) {
            super(readBuf, i, i2);
        }

        public static Vector empty() {
            return EMPTY_VECTOR;
        }

        public boolean isEmpty() {
            return this == EMPTY_VECTOR;
        }

        public StringBuilder toString(StringBuilder sb) {
            sb.append("[ ");
            int size = size();
            for (int i = 0; i < size; i++) {
                get(i).toString(sb);
                if (i != size - 1) {
                    sb.append(", ");
                }
            }
            sb.append(" ]");
            return sb;
        }

        public Reference get(int i) {
            long size = (long) size();
            long j = (long) i;
            if (j >= size) {
                return Reference.NULL_REFERENCE;
            }
            int byteToUnsignedInt = Unsigned.byteToUnsignedInt(this.bb.get((int) (((long) this.end) + (size * ((long) this.byteWidth)) + j)));
            return new Reference(this.bb, this.end + (i * this.byteWidth), this.byteWidth, byteToUnsignedInt);
        }
    }

    public static class TypedVector extends Vector {
        private static final TypedVector EMPTY_VECTOR = new TypedVector(FlexBuffers.EMPTY_BB, 1, 1, 1);
        private final int elemType;

        TypedVector(ReadBuf readBuf, int i, int i2, int i3) {
            super(readBuf, i, i2);
            this.elemType = i3;
        }

        public static TypedVector empty() {
            return EMPTY_VECTOR;
        }

        public boolean isEmptyVector() {
            return this == EMPTY_VECTOR;
        }

        public int getElemType() {
            return this.elemType;
        }

        public Reference get(int i) {
            if (i >= size()) {
                return Reference.NULL_REFERENCE;
            }
            return new Reference(this.bb, this.end + (i * this.byteWidth), this.byteWidth, 1, this.elemType);
        }
    }

    public static class KeyVector {
        private final TypedVector vec;

        KeyVector(TypedVector typedVector) {
            this.vec = typedVector;
        }

        public Key get(int i) {
            if (i >= size()) {
                return Key.EMPTY;
            }
            return new Key(this.vec.bb, FlexBuffers.indirect(this.vec.bb, this.vec.end + (i * this.vec.byteWidth), this.vec.byteWidth), 1);
        }

        public int size() {
            return this.vec.size();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < this.vec.size(); i++) {
                this.vec.get(i).toString(sb);
                if (i != this.vec.size() - 1) {
                    sb.append(", ");
                }
            }
            return sb.append("]").toString();
        }
    }

    public static class FlexBufferException extends RuntimeException {
        FlexBufferException(String str) {
            super(str);
        }
    }

    static class Unsigned {
        static int byteToUnsignedInt(byte b) {
            return b & UByte.MAX_VALUE;
        }

        static long intToUnsignedLong(int i) {
            return ((long) i) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }

        static int shortToUnsignedInt(short s) {
            return s & UShort.MAX_VALUE;
        }

        Unsigned() {
        }
    }
}
