package io.objectbox;

import io.objectbox.exception.DbException;
import io.objectbox.internal.CursorFactory;
import java.io.Closeable;

public class Transaction implements Closeable {
    static boolean TRACK_CREATION_STACK;
    private volatile boolean closed;
    private final Throwable creationThrowable;
    private int initialCommitCount;
    private final boolean readOnly;
    private final BoxStore store;
    private final long transaction;

    /* access modifiers changed from: package-private */
    public native void nativeAbort(long j);

    /* access modifiers changed from: package-private */
    public native int[] nativeCommit(long j);

    /* access modifiers changed from: package-private */
    public native long nativeCreateCursor(long j, String str, Class<?> cls);

    /* access modifiers changed from: package-private */
    public native long nativeCreateKeyValueCursor(long j);

    /* access modifiers changed from: package-private */
    public native void nativeDestroy(long j);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsActive(long j);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsOwnerThread(long j);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsReadOnly(long j);

    /* access modifiers changed from: package-private */
    public native boolean nativeIsRecycled(long j);

    /* access modifiers changed from: package-private */
    public native void nativeRecycle(long j);

    /* access modifiers changed from: package-private */
    public native void nativeRenew(long j);

    /* access modifiers changed from: package-private */
    public native void nativeReset(long j);

    public Transaction(BoxStore boxStore, long j, int i) {
        this.store = boxStore;
        this.transaction = j;
        this.initialCommitCount = i;
        this.readOnly = nativeIsReadOnly(j);
        this.creationThrowable = TRACK_CREATION_STACK ? new Throwable() : null;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    /* access modifiers changed from: package-private */
    public void checkOpen() {
        if (this.closed) {
            throw new IllegalStateException("Transaction is closed");
        }
    }

    public synchronized void close() {
        if (!this.closed) {
            this.closed = true;
            this.store.unregisterTransaction(this);
            if (!nativeIsOwnerThread(this.transaction)) {
                boolean nativeIsActive = nativeIsActive(this.transaction);
                boolean nativeIsRecycled = nativeIsRecycled(this.transaction);
                if (nativeIsActive || nativeIsRecycled) {
                    String str = " (initial commit count: " + this.initialCommitCount + ").";
                    if (nativeIsActive) {
                        System.err.println("Transaction is still active" + str);
                    } else {
                        System.out.println("Hint: use closeThreadResources() to avoid finalizing recycled transactions" + str);
                        System.out.flush();
                    }
                    if (this.creationThrowable != null) {
                        System.err.println("Transaction was initially created here:");
                        this.creationThrowable.printStackTrace();
                    }
                    System.err.flush();
                }
            }
            if (!this.store.isNativeStoreClosed()) {
                nativeDestroy(this.transaction);
            }
        }
    }

    public void commit() {
        checkOpen();
        this.store.txCommitted(this, nativeCommit(this.transaction));
    }

    public void commitAndClose() {
        commit();
        close();
    }

    public void abort() {
        checkOpen();
        nativeAbort(this.transaction);
    }

    public void reset() {
        checkOpen();
        this.initialCommitCount = this.store.commitCount;
        nativeReset(this.transaction);
    }

    public void recycle() {
        checkOpen();
        nativeRecycle(this.transaction);
    }

    public void renew() {
        checkOpen();
        this.initialCommitCount = this.store.commitCount;
        nativeRenew(this.transaction);
    }

    public KeyValueCursor createKeyValueCursor() {
        checkOpen();
        return new KeyValueCursor(nativeCreateKeyValueCursor(this.transaction));
    }

    public <T> Cursor<T> createCursor(Class<T> cls) {
        checkOpen();
        EntityInfo<T> entityInfo = this.store.getEntityInfo(cls);
        CursorFactory<T> cursorFactory = entityInfo.getCursorFactory();
        long nativeCreateCursor = nativeCreateCursor(this.transaction, entityInfo.getDbName(), cls);
        if (nativeCreateCursor != 0) {
            return cursorFactory.createCursor(this, nativeCreateCursor, this.store);
        }
        throw new DbException("Could not create native cursor");
    }

    public BoxStore getStore() {
        return this.store;
    }

    public boolean isActive() {
        return !this.closed && nativeIsActive(this.transaction);
    }

    public boolean isRecycled() {
        checkOpen();
        return nativeIsRecycled(this.transaction);
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isReadOnly() {
        return this.readOnly;
    }

    public boolean isObsolete() {
        return this.initialCommitCount != this.store.commitCount;
    }

    /* access modifiers changed from: package-private */
    public long internalHandle() {
        return this.transaction;
    }

    public String toString() {
        return "TX " + Long.toString(this.transaction, 16) + " (" + (this.readOnly ? "read-only" : "write") + ", initialCommitCount=" + this.initialCommitCount + ")";
    }
}
