package io.objectbox.config;

public final class TreeOptionFlags {
    public static final int AllowNonUniqueNodes = 8;
    public static final int AutoConsolidateNonUniqueNodes = 32;
    public static final int DebugLogsDisable = 1;
    public static final int DebugLogsEnable = 2;
    public static final int DetectNonUniqueNodes = 16;
    public static final int EnforceUniquePath = 4;

    private TreeOptionFlags() {
    }
}
