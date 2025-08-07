package io.objectbox.internal;

import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import javax.annotation.Nullable;

public interface CursorFactory<T> {
    Cursor<T> createCursor(Transaction transaction, long j, @Nullable BoxStore boxStore);
}
