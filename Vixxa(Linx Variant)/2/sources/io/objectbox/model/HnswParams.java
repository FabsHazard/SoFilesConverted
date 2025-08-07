package io.objectbox.model;

import com.github.mikephil.charting.utils.Utils;
import io.objectbox.flatbuffers.BaseVector;
import io.objectbox.flatbuffers.Constants;
import io.objectbox.flatbuffers.FlatBufferBuilder;
import io.objectbox.flatbuffers.Table;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.UShort;
import net.lingala.zip4j.util.InternalZipConstants;

public final class HnswParams extends Table {
    public static void ValidateVersion() {
        Constants.FLATBUFFERS_23_5_26();
    }

    public static HnswParams getRootAsHnswParams(ByteBuffer byteBuffer) {
        return getRootAsHnswParams(byteBuffer, new HnswParams());
    }

    public static HnswParams getRootAsHnswParams(ByteBuffer byteBuffer, HnswParams hnswParams) {
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        return hnswParams.__assign(byteBuffer.getInt(byteBuffer.position()) + byteBuffer.position(), byteBuffer);
    }

    public void __init(int i, ByteBuffer byteBuffer) {
        __reset(i, byteBuffer);
    }

    public HnswParams __assign(int i, ByteBuffer byteBuffer) {
        __init(i, byteBuffer);
        return this;
    }

    public long dimensions() {
        int __offset = __offset(4);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public long neighborsPerNode() {
        int __offset = __offset(6);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public long indexingSearchCount() {
        int __offset = __offset(8);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public long flags() {
        int __offset = __offset(10);
        if (__offset != 0) {
            return ((long) this.bb.getInt(__offset + this.bb_pos)) & InternalZipConstants.ZIP_64_SIZE_LIMIT;
        }
        return 0;
    }

    public int distanceType() {
        int __offset = __offset(12);
        if (__offset != 0) {
            return this.bb.getShort(__offset + this.bb_pos) & UShort.MAX_VALUE;
        }
        return 0;
    }

    public float reparationBacklinkProbability() {
        int __offset = __offset(14);
        if (__offset != 0) {
            return this.bb.getFloat(__offset + this.bb_pos);
        }
        return 0.0f;
    }

    public long vectorCacheHintSizeKb() {
        int __offset = __offset(16);
        if (__offset != 0) {
            return this.bb.getLong(__offset + this.bb_pos);
        }
        return 0;
    }

    public static int createHnswParams(FlatBufferBuilder flatBufferBuilder, long j, long j2, long j3, long j4, int i, float f, long j5) {
        flatBufferBuilder.startTable(7);
        addVectorCacheHintSizeKb(flatBufferBuilder, j5);
        addReparationBacklinkProbability(flatBufferBuilder, f);
        addFlags(flatBufferBuilder, j4);
        addIndexingSearchCount(flatBufferBuilder, j3);
        addNeighborsPerNode(flatBufferBuilder, j2);
        addDimensions(flatBufferBuilder, j);
        addDistanceType(flatBufferBuilder, i);
        return endHnswParams(flatBufferBuilder);
    }

    public static void startHnswParams(FlatBufferBuilder flatBufferBuilder) {
        flatBufferBuilder.startTable(7);
    }

    public static void addDimensions(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(0, (int) j, 0);
    }

    public static void addNeighborsPerNode(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(1, (int) j, 0);
    }

    public static void addIndexingSearchCount(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(2, (int) j, 0);
    }

    public static void addFlags(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addInt(3, (int) j, 0);
    }

    public static void addDistanceType(FlatBufferBuilder flatBufferBuilder, int i) {
        flatBufferBuilder.addShort(4, (short) i, 0);
    }

    public static void addReparationBacklinkProbability(FlatBufferBuilder flatBufferBuilder, float f) {
        flatBufferBuilder.addFloat(5, f, Utils.DOUBLE_EPSILON);
    }

    public static void addVectorCacheHintSizeKb(FlatBufferBuilder flatBufferBuilder, long j) {
        flatBufferBuilder.addLong(6, j, 0);
    }

    public static int endHnswParams(FlatBufferBuilder flatBufferBuilder) {
        return flatBufferBuilder.endTable();
    }

    public static final class Vector extends BaseVector {
        public Vector __assign(int i, int i2, ByteBuffer byteBuffer) {
            __reset(i, i2, byteBuffer);
            return this;
        }

        public HnswParams get(int i) {
            return get(new HnswParams(), i);
        }

        public HnswParams get(HnswParams hnswParams, int i) {
            return hnswParams.__assign(HnswParams.__indirect(__element(i), this.bb), this.bb);
        }
    }
}
