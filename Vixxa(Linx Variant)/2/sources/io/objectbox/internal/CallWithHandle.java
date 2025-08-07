package io.objectbox.internal;

public interface CallWithHandle<RESULT> {
    RESULT call(long j);
}
