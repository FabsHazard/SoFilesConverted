package io.objectbox.internal;

import io.objectbox.InternalAccess;
import io.objectbox.Transaction;
import io.objectbox.exception.DbException;
import java.io.Closeable;

public class DebugCursor implements Closeable {
    private boolean closed;
    private final long handle;
    private final Transaction tx;

    static native long nativeCreate(long j);

    static native void nativeDestroy(long j);

    static native byte[] nativeGet(long j, byte[] bArr);

    static native byte[] nativeSeekOrNext(long j, byte[] bArr);

    public static DebugCursor create(Transaction transaction) {
        long nativeCreate = nativeCreate(InternalAccess.getHandle(transaction));
        if (nativeCreate != 0) {
            return new DebugCursor(transaction, nativeCreate);
        }
        throw new DbException("Could not create native debug cursor");
    }

    public DebugCursor(Transaction transaction, long j) {
        this.tx = transaction;
        this.handle = j;
    }

    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            Transaction transaction = this.tx;
            if (transaction != null && !transaction.getStore().isClosed()) {
                nativeDestroy(this.handle);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!this.closed) {
            close();
            super.finalize();
        }
    }

    public byte[] get(byte[] bArr) {
        return nativeGet(this.handle, bArr);
    }

    public byte[] seekOrNext(byte[] bArr) {
        return nativeSeekOrNext(this.handle, bArr);
    }
}
