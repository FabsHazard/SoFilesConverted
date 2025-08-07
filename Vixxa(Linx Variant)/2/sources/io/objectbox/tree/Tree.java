package io.objectbox.tree;

import io.objectbox.BoxStore;
import io.objectbox.InternalAccess;
import java.io.Closeable;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public class Tree implements Closeable {
    private long handle;
    private String pathSeparatorRegex = "\\.";
    private long rootId;
    private final BoxStore store;

    static native long nativeCreate(long j, long j2);

    static native long nativeCreateWithUid(long j, String str);

    static native void nativeDelete(long j);

    /* access modifiers changed from: package-private */
    public native void nativeClearTransaction(long j);

    /* access modifiers changed from: package-private */
    public native LeafNode nativeGetLeafById(long j, long j2);

    /* access modifiers changed from: package-private */
    public native long nativeGetRootId(long j);

    /* access modifiers changed from: package-private */
    public native long nativePutBranch(long j, long j2, long j3, long j4, @Nullable String str);

    /* access modifiers changed from: package-private */
    public native long nativePutMetaBranch(long j, long j2, long j3, String str, @Nullable String str2);

    /* access modifiers changed from: package-private */
    public native long[] nativePutMetaBranches(long j, long j2, String[] strArr);

    /* access modifiers changed from: package-private */
    public native long nativePutMetaLeaf(long j, long j2, long j3, String str, short s, boolean z, @Nullable String str2);

    /* access modifiers changed from: package-private */
    public native long nativePutValueFP(long j, long j2, long j3, long j4, double d);

    /* access modifiers changed from: package-private */
    public native long nativePutValueInteger(long j, long j2, long j3, long j4, long j5);

    /* access modifiers changed from: package-private */
    public native long nativePutValueString(long j, long j2, long j3, long j4, @Nullable String str);

    /* access modifiers changed from: package-private */
    public native boolean nativeSetTransaction(long j, long j2);

    public Tree(BoxStore boxStore, String str) {
        this.store = boxStore;
        if (boxStore == null) {
            throw new IllegalArgumentException("store must not be null");
        } else if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("uid must be 0 or not empty");
        } else {
            this.handle = nativeCreateWithUid(boxStore.getNativeStore(), str);
        }
    }

    public Tree(BoxStore boxStore, long j) {
        this.store = boxStore;
        this.rootId = j;
        if (boxStore != null) {
            this.handle = nativeCreate(boxStore.getNativeStore(), j);
            return;
        }
        throw new IllegalArgumentException("store must not be null");
    }

    /* access modifiers changed from: package-private */
    public long getHandle() {
        return this.handle;
    }

    public String getPathSeparatorRegex() {
        return this.pathSeparatorRegex;
    }

    public void setPathSeparatorRegex(String str) {
        this.pathSeparatorRegex = str;
    }

    public long getRootId() {
        return this.rootId;
    }

    public BoxStore getStore() {
        return this.store;
    }

    public Branch getRoot() {
        return new Branch(this, nativeGetRootId(this.handle));
    }

    public void close() {
        nativeDelete(this.handle);
        this.handle = 0;
    }

    public void runInTx(Runnable runnable) {
        this.store.runInTx(createTxRunnable(runnable));
    }

    public void runInReadTx(Runnable runnable) {
        this.store.runInReadTx(createTxRunnable(runnable));
    }

    public <T> T callInTx(Callable<T> callable) throws Exception {
        return this.store.callInTx(createTxCallable(callable));
    }

    public <T> T callInTxNoThrow(Callable<T> callable) {
        try {
            return this.store.callInTx(createTxCallable(callable));
        } catch (Exception e) {
            throw new RuntimeException("Callable threw exception", e);
        }
    }

    public <T> T callInReadTx(Callable<T> callable) {
        return this.store.callInReadTx(createTxCallable(callable));
    }

    private Runnable createTxRunnable(Runnable runnable) {
        return new Tree$$ExternalSyntheticLambda0(this, runnable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createTxRunnable$0$io-objectbox-tree-Tree  reason: not valid java name */
    public /* synthetic */ void m338lambda$createTxRunnable$0$ioobjectboxtreeTree(Runnable runnable) {
        boolean nativeSetTransaction = nativeSetTransaction(this.handle, InternalAccess.getHandle(InternalAccess.getActiveTx(this.store)));
        try {
            runnable.run();
        } finally {
            if (nativeSetTransaction) {
                nativeClearTransaction(this.handle);
            }
        }
    }

    private <T> Callable<T> createTxCallable(Callable<T> callable) {
        return new Tree$$ExternalSyntheticLambda1(this, callable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createTxCallable$1$io-objectbox-tree-Tree  reason: not valid java name */
    public /* synthetic */ Object m337lambda$createTxCallable$1$ioobjectboxtreeTree(Callable callable) throws Exception {
        boolean nativeSetTransaction = nativeSetTransaction(this.handle, InternalAccess.getHandle(InternalAccess.getActiveTx(this.store)));
        try {
            return callable.call();
        } finally {
            if (nativeSetTransaction) {
                nativeClearTransaction(this.handle);
            }
        }
    }

    @Nullable
    public Leaf getLeaf(long j) {
        LeafNode nativeGetLeafById = nativeGetLeafById(this.handle, j);
        if (nativeGetLeafById == null) {
            return null;
        }
        return new Leaf(nativeGetLeafById);
    }

    @Nullable
    public String getString(long j) {
        Leaf leaf = getLeaf(j);
        if (leaf != null) {
            return leaf.asString();
        }
        return null;
    }

    @Nullable
    public Long getInteger(long j) {
        Leaf leaf = getLeaf(j);
        if (leaf != null) {
            return leaf.asInt();
        }
        return null;
    }

    @Nullable
    public Double getDouble(long j) {
        Leaf leaf = getLeaf(j);
        if (leaf != null) {
            return leaf.asDouble();
        }
        return null;
    }

    public long putMetaBranch(long j, long j2, String str) {
        return nativePutMetaBranch(this.handle, j, j2, str, (String) null);
    }

    public long putMetaBranch(long j, long j2, String str, @Nullable String str2) {
        return nativePutMetaBranch(this.handle, j, j2, str, str2);
    }

    public long[] putMetaBranches(String[] strArr) {
        return nativePutMetaBranches(this.handle, 0, strArr);
    }

    public long[] putMetaBranches(long j, String[] strArr) {
        return nativePutMetaBranches(this.handle, j, strArr);
    }

    public long putMetaLeaf(long j, long j2, String str, short s) {
        return nativePutMetaLeaf(this.handle, j, j2, str, s, false, (String) null);
    }

    public long putMetaLeaf(long j, long j2, String str, short s, boolean z) {
        return nativePutMetaLeaf(this.handle, j, j2, str, s, z, (String) null);
    }

    public long putMetaLeaf(long j, long j2, String str, short s, boolean z, @Nullable String str2) {
        return nativePutMetaLeaf(this.handle, j, j2, str, s, z, str2);
    }

    public long putBranch(long j, long j2, long j3, @Nullable String str) {
        return nativePutBranch(this.handle, j, j2, j3, str);
    }

    public long putBranch(long j, long j2, @Nullable String str) {
        return nativePutBranch(this.handle, 0, j, j2, str);
    }

    public long putBranch(long j, long j2) {
        return nativePutBranch(this.handle, 0, j, j2, (String) null);
    }

    public long putValue(long j, long j2, long j3, long j4) {
        return nativePutValueInteger(this.handle, j, j2, j3, j4);
    }

    public long putValue(long j, long j2, long j3) {
        return nativePutValueInteger(this.handle, 0, j, j2, j3);
    }

    public long putValue(long j, long j2, double d) {
        return nativePutValueFP(this.handle, 0, j, j2, d);
    }

    public long putValue(long j, long j2, long j3, double d) {
        return nativePutValueFP(this.handle, j, j2, j3, d);
    }

    public long putValue(long j, long j2, long j3, String str) {
        return nativePutValueString(this.handle, j, j2, j3, str);
    }

    public long putValue(long j, long j2, String str) {
        return nativePutValueString(this.handle, 0, j, j2, str);
    }

    public long put(Leaf leaf) {
        long id = leaf.getId();
        long parentBranchId = leaf.getParentBranchId();
        long metaId = leaf.getMetaId();
        short valueType = leaf.getValueType();
        if (valueType != 23) {
            switch (valueType) {
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return nativePutValueInteger(this.handle, id, parentBranchId, metaId, leaf.getInt());
                case 7:
                case 8:
                    return nativePutValueFP(this.handle, id, parentBranchId, metaId, leaf.getDouble());
                case 9:
                    break;
                default:
                    throw new UnsupportedOperationException("Unsupported value type: " + leaf.getValueType());
            }
        }
        return nativePutValueString(this.handle, id, parentBranchId, metaId, leaf.getString());
    }
}
