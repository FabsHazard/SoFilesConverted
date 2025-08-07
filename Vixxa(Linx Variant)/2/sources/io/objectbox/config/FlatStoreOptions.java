package io.objectbox.config;

import io.objectbox.flatbuffers.BaseVector;
import io.objectbox.flatbuffers.ByteVector;
import io.objectbox.flatbuffers.Constants;
import io.objectbox.flatbuffers.FlatBufferBuilder;
import io.objectbox.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UByte;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

public final class FlatStoreOptions extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static FlatStoreOptions getRootAsFlatStoreOptions(ByteBuffer byteBuffer) {
        return getRootAsFlatStoreOptions(byteBuffer, new FlatStoreOptions());
    }

    public static FlatStoreOptions getRootAsFlatStoreOptions(ByteBuffer byteBuffer, FlatStoreOptions flatStoreOptions) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return flatStoreOptions.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public FlatStoreOptions __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public String directoryPath() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer directoryPathAsByteBuffer() {
        return __vector_as_bytebuffer(4, 1);
    }

    public ByteBuffer directoryPathInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 4, 1);
    }

    public int modelBytes(int i) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return this.bb.get(__vector(__offset) + i) & UByte.MAX_VALUE;
        }
        return 0;
    }

    public int modelBytesLength() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return __vector_len(__offset);
        }
        return 0;
    }

    public ByteVector modelBytesVector() {
        return modelBytesVector(new ByteVector());
    }

    public ByteVector modelBytesVector(ByteVector byteVector) {
        int __offset = __offset(6);
        if (__offset != 0) {
            return byteVector.__assign(__vector(__offset), this.bb);
        }
        return null;
    }

    public ByteBuffer modelBytesAsByteBuffer() {
        return __vector_as_bytebuffer(6, 1);
    }

    public ByteBuffer modelBytesInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 6, 1);
    }

    public long maxDbSizeInKbyte() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return this.bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public long fileMode() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public long maxReaders() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public int validateOnOpenPages() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos) & UShort.MAX_VALUE;
        }
        return 0;
    }

    public long validateOnOpenPageLimit() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return this.bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public int putPaddingMode() {
        int __offset = __offset(18);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos) & UShort.MAX_VALUE;
        }
        return 0;
    }

    public boolean skipReadSchema() {
        int __offset = __offset(20);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean usePreviousCommit() {
        int __offset = __offset(22);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean usePreviousCommitOnValidationFailure() {
        int __offset = __offset(24);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public boolean readOnly() {
        int __offset = __offset(26);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public long debugFlags() {
        int __offset = __offset(28);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public boolean noReaderThreadLocals() {
        int __offset = __offset(30);
        return (__offset == 0 || this.bb.get(__offset + this.bb_pos) == 0) ? false : true;
    }

    public long maxDataSizeInKbyte() {
        int __offset = __offset(32);
        if (__offset != 0) {
            return this.bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public int validateOnOpenKv() {
        int __offset = __offset(34);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos) & UShort.MAX_VALUE;
        }
        return 0;
    }

    public String backupFile() {
        int __offset = __offset(36);
        if (__offset != 0) {
            return __string(__offset + this.bb_pos);
        }
        return null;
    }

    public ByteBuffer backupFileAsByteBuffer() {
        return __vector_as_bytebuffer(36, 1);
    }

    public ByteBuffer backupFileInByteBuffer(ByteBuffer byteBuffer) {
        return __vector_in_bytebuffer(byteBuffer, 36, 1);
    }

    public long backupRestoreFlags() {
        int __offset = __offset(38);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public static int createFlatStoreOptions(FlatBufferBuilder flatBufferBuilder, int i, int i2, long j, long j2, long j3, int i3, long j4, int i4, boolean z, boolean z2, boolean z3, boolean z4, long j5, boolean z5, long j6, int i5, int i6, long j7) {
        FlatBufferBuilder flatBufferBuilder2 = flatBufferBuilder;
        flatBufferBuilder.startTable(18);
        addMaxDataSizeInKbyte(flatBufferBuilder, j6);
        long j8 = j4;
        addValidateOnOpenPageLimit(flatBufferBuilder, j4);
        long j9 = j;
        addMaxDbSizeInKbyte(flatBufferBuilder, j);
        addBackupRestoreFlags(flatBufferBuilder, j7);
        addBackupFile(flatBufferBuilder, i6);
        addDebugFlags(flatBufferBuilder, j5);
        long j10 = j3;
        addMaxReaders(flatBufferBuilder, j3);
        long j11 = j2;
        addFileMode(flatBufferBuilder, j2);
        int i7 = i2;
        addModelBytes(flatBufferBuilder, i2);
        addDirectoryPath(flatBufferBuilder, i);
        addValidateOnOpenKv(flatBufferBuilder, i5);
        int i8 = i4;
        addPutPaddingMode(flatBufferBuilder, i4);
        int i9 = i3;
        addValidateOnOpenPages(flatBufferBuilder, i3);
        addNoReaderThreadLocals(flatBufferBuilder, z5);
        addReadOnly(flatBufferBuilder, z4);
        addUsePreviousCommitOnValidationFailure(flatBufferBuilder, z3);
        addUsePreviousCommit(flatBufferBuilder, z2);
        addSkipReadSchema(flatBufferBuilder, z);
        return endFlatStoreOptions(flatBufferBuilder);
    }

    public static void startFlatStoreOptions(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(18);
    }

    public static void addDirectoryPath(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(0, i, 0);
    }

    public static void addModelBytes(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(1, i, 0);
    }

    public static int createModelBytesVector(FlatBufferBuilder flatBufferBuilder, byte[] bArr) {
        return flatBufferBuilder.createByteVector(bArr);
    }

    public static int createModelBytesVector(FlatBufferBuilder flatBufferBuilder, ByteBuffer byteBuffer) {
        return flatBufferBuilder.createByteVector(byteBuffer);
    }

    public static void startModelBytesVector(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.startVector(1, i, 1);
    }

    public static void addMaxDbSizeInKbyte(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(2, j, 0);
    }

    public static void addFileMode(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(3, (int) j, 0);
    }

    public static void addMaxReaders(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(4, (int) j, 0);
    }

    public static void addValidateOnOpenPages(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(5, (short) i, 0);
    }

    public static void addValidateOnOpenPageLimit(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(6, j, 0);
    }

    public static void addPutPaddingMode(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(7, (short) i, 0);
    }

    public static void addSkipReadSchema(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(8, z, false);
    }

    public static void addUsePreviousCommit(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(9, z, false);
    }

    public static void addUsePreviousCommitOnValidationFailure(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(10, z, false);
    }

    public static void addReadOnly(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(11, z, false);
    }

    public static void addDebugFlags(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(12, (int) j, 0);
    }

    public static void addNoReaderThreadLocals(FlatBufferBuilder flatBufferBuilder, boolean z) {
        flatBufferBuilder.addBoolean(13, z, false);
    }

    public static void addMaxDataSizeInKbyte(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(14, j, 0);
    }

    public static void addValidateOnOpenKv(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(15, (short) i, 0);
    }

    public static void addBackupFile(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addOffset(16, i, 0);
    }

    public static void addBackupRestoreFlags(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(17, (int) j, 0);
    }

    public static int endFlatStoreOptions(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static void finishFlatStoreOptionsBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finish(i);
    }

    public static void finishSizePrefixedFlatStoreOptionsBuffer(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.finishSizePrefixed(i);
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public FlatStoreOptions get(int i) {
            return get(new FlatStoreOptions(), i);
        }

        public FlatStoreOptions get(FlatStoreOptions flatStoreOptions, int i) {
            return flatStoreOptions.__assign(FlatStoreOptions.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
