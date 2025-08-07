package io.objectbox.annotation;

public @interface HnswFlags {
    boolean debugLogs() default false;

    boolean debugLogsDetailed() default false;

    boolean reparationLimitCandidates() default false;

    boolean vectorCacheSimdPaddingOff() default false;
}
