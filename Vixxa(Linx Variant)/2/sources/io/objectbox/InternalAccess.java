package io.objectbox;

import io.objectbox.sync.SyncClient;
import javax.annotation.Nullable;

public class InternalAccess {
    public static Transaction getActiveTx(BoxStore boxStore) {
        Transaction transaction = boxStore.activeTx.get();
        if (transaction != null) {
            transaction.checkOpen();
            return transaction;
        }
        throw new IllegalStateException("No active transaction");
    }

    public static long getHandle(Transaction transaction) {
        return transaction.internalHandle();
    }

    public static void setSyncClient(BoxStore boxStore, @Nullable SyncClient syncClient) {
        boxStore.setSyncClient(syncClient);
    }

    public static <T> Cursor<T> getWriter(Box<T> box) {
        return box.getWriter();
    }

    public static <T> Cursor<T> getActiveTxCursor(Box<T> box) {
        return box.getActiveTxCursor();
    }

    public static <T> long getActiveTxCursorHandle(Box<T> box) {
        return box.getActiveTxCursor().internalHandle();
    }

    public static <T> void commitWriter(Box<T> box, Cursor<T> cursor) {
        box.commitWriter(cursor);
    }

    public static void enableCreationStackTracking() {
        Transaction.TRACK_CREATION_STACK = true;
        Cursor.TRACK_CREATION_STACK = true;
    }
}
