package io.objectbox.model;

public final class HnswFlags {
    public static final int DebugLogs = 1;
    public static final int DebugLogsDetailed = 2;
    public static final int ReparationLimitCandidates = 8;
    public static final int VectorCacheSimdPaddingOff = 4;

    private HnswFlags() {
    }
}
