package io.objectbox;

import io.objectbox.converter.PropertyConverter;
import io.objectbox.exception.DbException;
import io.objectbox.exception.DbExceptionListener;
import io.objectbox.exception.DbSchemaException;
import io.objectbox.internal.Feature;
import io.objectbox.internal.NativeLibraryLoader;
import io.objectbox.internal.ObjectBoxThreadPool;
import io.objectbox.reactive.SubscriptionBuilder;
import io.objectbox.sync.SyncClient;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.greenrobot.essentials.collections.LongHashMap;

public class BoxStore implements Closeable {
    public static final String IN_MEMORY_PREFIX = "memory:";
    public static final String JNI_VERSION = "4.0.2";
    private static final String VERSION = "4.0.2-2024-08-19";
    @Nullable
    private static Object context;
    private static BoxStore defaultStore;
    private static final Set<String> openFiles = new HashSet();
    private static volatile Thread openFilesCheckerThread;
    @Nullable
    private static Object relinker;
    final ThreadLocal<Transaction> activeTx = new ThreadLocal<>();
    private final int[] allEntityTypeIds;
    private final Map<Class<?>, Box<?>> boxes = new ConcurrentHashMap();
    private final String canonicalPath;
    private final LongHashMap<Class<?>> classByEntityTypeId = new LongHashMap<>();
    private volatile boolean closed;
    volatile int commitCount;
    private final Map<Class<?>, String> dbNameByClass = new HashMap();
    final boolean debugRelations;
    final boolean debugTxRead;
    final boolean debugTxWrite;
    private final File directory;
    private final Map<Class<?>, Integer> entityTypeIdByClass = new HashMap();
    private final TxCallback<?> failedReadTxAttemptCallback;
    private volatile long handle;
    private int objectBrowserPort;
    private final ObjectClassPublisher objectClassPublisher;
    private final Map<Class<?>, EntityInfo<?>> propertiesByClass = new HashMap();
    private final int queryAttempts;
    @Nullable
    private SyncClient syncClient;
    private final ExecutorService threadPool = new ObjectBoxThreadPool(this);
    private final Set<Transaction> transactions = Collections.newSetFromMap(new WeakHashMap());
    final Object txCommitCountLock = new Object();

    static native long nativeBeginReadTx(long j);

    static native long nativeBeginTx(long j);

    static native int nativeCleanStaleReadTransactions(long j);

    static native long nativeCreateWithFlatOptions(byte[] bArr, byte[] bArr2);

    static native void nativeDelete(long j);

    static native String nativeDiagnose(long j);

    static native void nativeDropAllData(long j);

    static native String nativeGetVersion();

    static native long nativeGloballyActiveEntityTypes();

    private static native boolean nativeHasFeature(int i);

    static native boolean nativeIsObjectBrowserAvailable();

    static native boolean nativeIsReadOnly(long j);

    static native void nativeRegisterCustomType(long j, int i, int i2, String str, Class<? extends PropertyConverter> cls, Class<?> cls2);

    static native int nativeRegisterEntityClass(long j, String str, Class<?> cls);

    static native boolean nativeRemoveDbFiles(String str, boolean z);

    static native void nativeSetDbExceptionListener(long j, @Nullable DbExceptionListener dbExceptionListener);

    static native void nativeSetDebugFlags(long j, int i);

    private native String nativeStartObjectBrowser(long j, @Nullable String str, int i);

    private native boolean nativeStopObjectBrowser(long j);

    static native long nativeSysProcMeminfoKb(String str);

    static native long nativeSysProcStatusKb(String str);

    /* access modifiers changed from: package-private */
    public native long nativeDbSize(long j);

    /* access modifiers changed from: package-private */
    public native long nativeDbSizeOnDisk(long j);

    /* access modifiers changed from: package-private */
    public native long nativePanicModeRemoveAllObjects(long j, int i);

    /* access modifiers changed from: package-private */
    public native long nativeValidate(long j, long j2, boolean z);

    @Nullable
    public static synchronized Object getContext() {
        Object obj;
        synchronized (BoxStore.class) {
            obj = context;
        }
        return obj;
    }

    @Nullable
    public static synchronized Object getRelinker() {
        Object obj;
        synchronized (BoxStore.class) {
            obj = relinker;
        }
        return obj;
    }

    public static synchronized BoxStore getDefault() {
        BoxStore boxStore;
        synchronized (BoxStore.class) {
            boxStore = defaultStore;
            if (boxStore == null) {
                throw new IllegalStateException("Please call buildDefault() before calling this method");
            }
        }
        return boxStore;
    }

    static synchronized void setDefault(BoxStore boxStore) {
        synchronized (BoxStore.class) {
            if (defaultStore == null) {
                defaultStore = boxStore;
            } else {
                throw new IllegalStateException("Default store was already built before. ");
            }
        }
    }

    public static synchronized boolean clearDefaultStore() {
        boolean z;
        synchronized (BoxStore.class) {
            z = defaultStore != null;
            defaultStore = null;
        }
        return z;
    }

    public static String getVersion() {
        return VERSION;
    }

    public static String getVersionNative() {
        NativeLibraryLoader.ensureLoaded();
        return nativeGetVersion();
    }

    public static boolean hasFeature(Feature feature) {
        try {
            NativeLibraryLoader.ensureLoaded();
            return nativeHasFeature(feature.id);
        } catch (UnsatisfiedLinkError e) {
            System.err.println("Old JNI lib? " + e);
            return false;
        }
    }

    public static boolean isObjectBrowserAvailable() {
        return hasFeature(Feature.ADMIN);
    }

    public static boolean isSyncAvailable() {
        return hasFeature(Feature.SYNC);
    }

    public static boolean isSyncServerAvailable() {
        return hasFeature(Feature.SYNC_SERVER);
    }

    BoxStore(BoxStoreBuilder boxStoreBuilder) {
        EntityInfo next;
        BoxStoreBuilder boxStoreBuilder2 = boxStoreBuilder;
        context = boxStoreBuilder2.context;
        relinker = boxStoreBuilder2.relinker;
        NativeLibraryLoader.ensureLoaded();
        File file = boxStoreBuilder2.directory;
        this.directory = file;
        String canonicalPath2 = getCanonicalPath(file);
        this.canonicalPath = canonicalPath2;
        verifyNotAlreadyOpen(canonicalPath2);
        try {
            this.handle = nativeCreateWithFlatOptions(boxStoreBuilder2.buildFlatStoreOptions(canonicalPath2), boxStoreBuilder2.model);
            if (this.handle != 0) {
                int i = boxStoreBuilder2.debugFlags;
                if (i != 0) {
                    this.debugTxRead = (i & 1) != 0;
                    this.debugTxWrite = (i & 2) != 0;
                } else {
                    this.debugTxWrite = false;
                    this.debugTxRead = false;
                }
                this.debugRelations = boxStoreBuilder2.debugRelations;
                Iterator<EntityInfo<?>> it = boxStoreBuilder2.entityInfoList.iterator();
                while (it.hasNext()) {
                    next = it.next();
                    this.dbNameByClass.put(next.getEntityClass(), next.getDbName());
                    int nativeRegisterEntityClass = nativeRegisterEntityClass(this.handle, next.getDbName(), next.getEntityClass());
                    this.entityTypeIdByClass.put(next.getEntityClass(), Integer.valueOf(nativeRegisterEntityClass));
                    this.classByEntityTypeId.put((long) nativeRegisterEntityClass, next.getEntityClass());
                    this.propertiesByClass.put(next.getEntityClass(), next);
                    Property[] allProperties = next.getAllProperties();
                    int length = allProperties.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 < length) {
                            Property property = allProperties[i2];
                            if (property.customType != null) {
                                if (property.converterClass != null) {
                                    nativeRegisterCustomType(this.handle, nativeRegisterEntityClass, 0, property.dbName, property.converterClass, property.customType);
                                } else {
                                    throw new RuntimeException("No converter class for custom type of " + property);
                                }
                            }
                            i2++;
                        }
                    }
                }
                int size = this.classByEntityTypeId.size();
                this.allEntityTypeIds = new int[size];
                long[] keys = this.classByEntityTypeId.keys();
                for (int i3 = 0; i3 < size; i3++) {
                    this.allEntityTypeIds[i3] = (int) keys[i3];
                }
                this.objectClassPublisher = new ObjectClassPublisher(this);
                this.failedReadTxAttemptCallback = boxStoreBuilder2.failedReadTxAttemptCallback;
                this.queryAttempts = Math.max(boxStoreBuilder2.queryAttempts, 1);
                return;
            }
            throw new DbException("Could not create native store");
        } catch (RuntimeException e) {
            throw new RuntimeException("Could not setup up entity " + next.getEntityClass(), e);
        } catch (RuntimeException e2) {
            close();
            throw e2;
        }
    }

    static String getCanonicalPath(File file) {
        if (file.getPath().startsWith(IN_MEMORY_PREFIX)) {
            return file.getPath();
        }
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new DbException("Is not a directory: " + file.getAbsolutePath());
            }
        } else if (!file.mkdirs()) {
            throw new DbException("Could not create directory: " + file.getAbsolutePath());
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            throw new DbException("Could not verify dir", (Throwable) e);
        }
    }

    static void verifyNotAlreadyOpen(String str) {
        Set<String> set = openFiles;
        synchronized (set) {
            isFileOpen(str);
            if (!set.add(str)) {
                throw new DbException("Another BoxStore is still open for this directory: " + str + ". Hint: for most apps it's recommended to keep a BoxStore for the app's life time.");
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0015, code lost:
        if (r0.isAlive() != false) goto L_0x0018;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        return isFileOpenSync(r3, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        r0 = new java.lang.Thread(new io.objectbox.BoxStore$$ExternalSyntheticLambda0(r3));
        r0.setDaemon(true);
        openFilesCheckerThread = r0;
        r0.start();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r0.join(500);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
        r0 = openFilesCheckerThread;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
        if (r0 == null) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean isFileOpen(java.lang.String r3) {
        /*
            java.util.Set<java.lang.String> r0 = openFiles
            monitor-enter(r0)
            boolean r1 = r0.contains(r3)     // Catch:{ all -> 0x0046 }
            r2 = 0
            if (r1 != 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            return r2
        L_0x000c:
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Thread r0 = openFilesCheckerThread
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.isAlive()
            if (r0 != 0) goto L_0x0018
            goto L_0x001d
        L_0x0018:
            boolean r3 = isFileOpenSync(r3, r2)
            return r3
        L_0x001d:
            java.lang.Thread r0 = new java.lang.Thread
            io.objectbox.BoxStore$$ExternalSyntheticLambda0 r1 = new io.objectbox.BoxStore$$ExternalSyntheticLambda0
            r1.<init>(r3)
            r0.<init>(r1)
            r1 = 1
            r0.setDaemon(r1)
            openFilesCheckerThread = r0
            r0.start()
            r1 = 500(0x1f4, double:2.47E-321)
            r0.join(r1)     // Catch:{ InterruptedException -> 0x0036 }
            goto L_0x003a
        L_0x0036:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003a:
            java.util.Set<java.lang.String> r1 = openFiles
            monitor-enter(r1)
            boolean r3 = r1.contains(r3)     // Catch:{ all -> 0x0043 }
            monitor-exit(r1)     // Catch:{ all -> 0x0043 }
            return r3
        L_0x0043:
            r3 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0043 }
            throw r3
        L_0x0046:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0046 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.BoxStore.isFileOpen(java.lang.String):boolean");
    }

    static /* synthetic */ void lambda$isFileOpen$0(String str) {
        isFileOpenSync(str, true);
        openFilesCheckerThread = null;
    }

    static boolean isFileOpenSync(String str, boolean z) {
        boolean contains;
        synchronized (openFiles) {
            int i = 0;
            while (i < 5) {
                Set<String> set = openFiles;
                if (set.contains(str)) {
                    i++;
                    System.gc();
                    if (z && i > 1) {
                        System.runFinalization();
                    }
                    System.gc();
                    if (z && i > 1) {
                        System.runFinalization();
                    }
                    try {
                        set.wait(100);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            contains = openFiles.contains(str);
        }
        return contains;
    }

    public static boolean isDatabaseOpen(Object obj, @Nullable String str) throws IOException {
        return isFileOpen(BoxStoreBuilder.getAndroidDbDir(obj, str).getCanonicalPath());
    }

    public static boolean isDatabaseOpen(@Nullable File file, @Nullable String str) throws IOException {
        return isFileOpen(BoxStoreBuilder.getDbDir(file, str).getCanonicalPath());
    }

    public static boolean isDatabaseOpen(File file) throws IOException {
        return isFileOpen(file.getCanonicalPath());
    }

    public static long sysProcMeminfoKb(String str) {
        NativeLibraryLoader.ensureLoaded();
        return nativeSysProcMeminfoKb(str);
    }

    public static long sysProcStatusKb(String str) {
        NativeLibraryLoader.ensureLoaded();
        return nativeSysProcStatusKb(str);
    }

    @Deprecated
    public long sizeOnDisk() {
        return getDbSize();
    }

    public long getDbSize() {
        return nativeDbSize(getNativeStore());
    }

    public long getDbSizeOnDisk() {
        return nativeDbSizeOnDisk(getNativeStore());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    private void checkOpen() {
        if (isClosed()) {
            throw new IllegalStateException("Store is closed");
        }
    }

    /* access modifiers changed from: package-private */
    public String getDbName(Class<?> cls) {
        return this.dbNameByClass.get(cls);
    }

    /* access modifiers changed from: package-private */
    public Integer getEntityTypeId(Class<?> cls) {
        return this.entityTypeIdByClass.get(cls);
    }

    public int getEntityTypeIdOrThrow(Class<?> cls) {
        Integer num = this.entityTypeIdByClass.get(cls);
        if (num != null) {
            return num.intValue();
        }
        throw new DbSchemaException("No entity registered for " + cls);
    }

    public Collection<Class<?>> getAllEntityClasses() {
        return this.dbNameByClass.keySet();
    }

    /* access modifiers changed from: package-private */
    public int[] getAllEntityTypeIds() {
        return this.allEntityTypeIds;
    }

    /* access modifiers changed from: package-private */
    public Class<?> getEntityClassOrThrow(int i) {
        Class<?> cls = this.classByEntityTypeId.get((long) i);
        if (cls != null) {
            return cls;
        }
        throw new DbSchemaException("No entity registered for type ID " + i);
    }

    /* access modifiers changed from: package-private */
    public <T> EntityInfo<T> getEntityInfo(Class<T> cls) {
        return this.propertiesByClass.get(cls);
    }

    public Transaction beginTx() {
        int i = this.commitCount;
        if (this.debugTxWrite) {
            System.out.println("Begin TX with commit count " + i);
        }
        long nativeBeginTx = nativeBeginTx(getNativeStore());
        if (nativeBeginTx != 0) {
            Transaction transaction = new Transaction(this, nativeBeginTx, i);
            synchronized (this.transactions) {
                this.transactions.add(transaction);
            }
            return transaction;
        }
        throw new DbException("Could not create native transaction");
    }

    public Transaction beginReadTx() {
        int i = this.commitCount;
        if (this.debugTxRead) {
            System.out.println("Begin read TX with commit count " + i);
        }
        long nativeBeginReadTx = nativeBeginReadTx(getNativeStore());
        if (nativeBeginReadTx != 0) {
            Transaction transaction = new Transaction(this, nativeBeginReadTx, i);
            synchronized (this.transactions) {
                this.transactions.add(transaction);
            }
            return transaction;
        }
        throw new DbException("Could not create native read transaction");
    }

    public boolean isClosed() {
        return this.closed;
    }

    public boolean isReadOnly() {
        return nativeIsReadOnly(getNativeStore());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:16|17|18|19|20|(1:22)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0033 A[Catch:{ all -> 0x000f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r5.closed     // Catch:{ all -> 0x0083 }
            boolean r1 = r5.closed     // Catch:{ all -> 0x0083 }
            if (r1 != 0) goto L_0x006f
            int r1 = r5.objectBrowserPort     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0013
            r5.stopObjectBrowser()     // Catch:{ all -> 0x000f }
            goto L_0x0013
        L_0x000f:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x0083 }
        L_0x0013:
            r1 = 1
            r5.closed = r1     // Catch:{ all -> 0x0083 }
            java.util.Set<io.objectbox.Transaction> r1 = r5.transactions     // Catch:{ all -> 0x0083 }
            monitor-enter(r1)     // Catch:{ all -> 0x0083 }
            boolean r2 = r5.hasActiveTransaction()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x003a
            java.io.PrintStream r2 = java.lang.System.out     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "Briefly waiting for active transactions before closing the Store..."
            r2.println(r3)     // Catch:{ all -> 0x006c }
            java.util.Set<io.objectbox.Transaction> r2 = r5.transactions     // Catch:{ InterruptedException -> 0x002d }
            r3 = 1000(0x3e8, double:4.94E-321)
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x002d }
        L_0x002d:
            boolean r2 = r5.hasActiveTransaction()     // Catch:{ all -> 0x006c }
            if (r2 == 0) goto L_0x003a
            java.io.PrintStream r2 = java.lang.System.err     // Catch:{ all -> 0x006c }
            java.lang.String r3 = "Transactions are still active: ensure that all database operations are finished before closing the Store!"
            r2.println(r3)     // Catch:{ all -> 0x006c }
        L_0x003a:
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ all -> 0x006c }
            java.util.Set<io.objectbox.Transaction> r3 = r5.transactions     // Catch:{ all -> 0x006c }
            r2.<init>(r3)     // Catch:{ all -> 0x006c }
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            java.util.Iterator r1 = r2.iterator()     // Catch:{ all -> 0x0083 }
        L_0x0046:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0083 }
            if (r2 == 0) goto L_0x0056
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0083 }
            io.objectbox.Transaction r2 = (io.objectbox.Transaction) r2     // Catch:{ all -> 0x0083 }
            r2.close()     // Catch:{ all -> 0x0083 }
            goto L_0x0046
        L_0x0056:
            long r1 = r5.handle     // Catch:{ all -> 0x0083 }
            r3 = 0
            r5.handle = r3     // Catch:{ all -> 0x0083 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x0063
            nativeDelete(r1)     // Catch:{ all -> 0x0083 }
        L_0x0063:
            java.util.concurrent.ExecutorService r1 = r5.threadPool     // Catch:{ all -> 0x0083 }
            r1.shutdown()     // Catch:{ all -> 0x0083 }
            r5.checkThreadTermination()     // Catch:{ all -> 0x0083 }
            goto L_0x006f
        L_0x006c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x006c }
            throw r0     // Catch:{ all -> 0x0083 }
        L_0x006f:
            monitor-exit(r5)     // Catch:{ all -> 0x0083 }
            if (r0 != 0) goto L_0x0082
            java.util.Set<java.lang.String> r0 = openFiles
            monitor-enter(r0)
            java.lang.String r1 = r5.canonicalPath     // Catch:{ all -> 0x007f }
            r0.remove(r1)     // Catch:{ all -> 0x007f }
            r0.notifyAll()     // Catch:{ all -> 0x007f }
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            goto L_0x0082
        L_0x007f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007f }
            throw r1
        L_0x0082:
            return
        L_0x0083:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0083 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.BoxStore.close():void");
    }

    private void checkThreadTermination() {
        try {
            if (!this.threadPool.awaitTermination(1, TimeUnit.SECONDS)) {
                int activeCount = Thread.activeCount();
                System.err.println("Thread pool not terminated in time; printing stack traces...");
                Thread[] threadArr = new Thread[(activeCount + 2)];
                int enumerate = Thread.enumerate(threadArr);
                for (int i = 0; i < enumerate; i++) {
                    System.err.println("Thread: " + threadArr[i].getName());
                    Thread.dumpStack();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean deleteAllFiles() {
        if (isClosed()) {
            return deleteAllFiles(this.directory);
        }
        throw new IllegalStateException("Store must be closed");
    }

    public static boolean deleteAllFiles(File file) {
        String canonicalPath2 = getCanonicalPath(file);
        if (!isFileOpen(canonicalPath2)) {
            NativeLibraryLoader.ensureLoaded();
            return nativeRemoveDbFiles(canonicalPath2, true);
        }
        throw new IllegalStateException("Cannot delete files: store is still open");
    }

    public static boolean deleteAllFiles(Object obj, @Nullable String str) {
        return deleteAllFiles(BoxStoreBuilder.getAndroidDbDir(obj, str));
    }

    public static boolean deleteAllFiles(@Nullable File file, @Nullable String str) {
        return deleteAllFiles(BoxStoreBuilder.getDbDir(file, str));
    }

    public void removeAllObjects() {
        nativeDropAllData(getNativeStore());
    }

    public void unregisterTransaction(Transaction transaction) {
        synchronized (this.transactions) {
            this.transactions.remove(transaction);
            if (!hasActiveTransaction()) {
                this.transactions.notifyAll();
            }
        }
    }

    private boolean hasActiveTransaction() {
        for (Transaction isActive : this.transactions) {
            if (isActive.isActive()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void txCommitted(Transaction transaction, @Nullable int[] iArr) {
        synchronized (this.txCommitCountLock) {
            this.commitCount++;
            if (this.debugTxWrite) {
                System.out.println("TX committed. New commit count: " + this.commitCount + ", entity types affected: " + (iArr != null ? iArr.length : 0));
            }
        }
        for (Box<?> txCommitted : this.boxes.values()) {
            txCommitted.txCommitted(transaction);
        }
        if (iArr != null) {
            this.objectClassPublisher.publish(iArr);
        }
    }

    public <T> Box<T> boxFor(Class<T> cls) {
        Box<T> box;
        Box<T> box2 = this.boxes.get(cls);
        if (box2 != null) {
            return box2;
        }
        if (this.dbNameByClass.containsKey(cls)) {
            synchronized (this.boxes) {
                box = this.boxes.get(cls);
                if (box == null) {
                    box = new Box<>(this, cls);
                    this.boxes.put(cls, box);
                }
            }
            return box;
        }
        throw new IllegalArgumentException(cls + " is not a known entity. Please add it and trigger generation again.");
    }

    public void runInTx(Runnable runnable) {
        Transaction transaction = this.activeTx.get();
        if (transaction == null) {
            Transaction beginTx = beginTx();
            this.activeTx.set(beginTx);
            try {
                runnable.run();
                beginTx.commit();
            } finally {
                this.activeTx.remove();
                beginTx.close();
            }
        } else if (!transaction.isReadOnly()) {
            runnable.run();
        } else {
            throw new IllegalStateException("Cannot start a transaction while a read only transaction is active");
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public void runInReadTx(java.lang.Runnable r4) {
        /*
            r3 = this;
            java.lang.ThreadLocal<io.objectbox.Transaction> r0 = r3.activeTx
            java.lang.Object r0 = r0.get()
            io.objectbox.Transaction r0 = (io.objectbox.Transaction) r0
            if (r0 != 0) goto L_0x005d
            io.objectbox.Transaction r0 = r3.beginReadTx()
            java.lang.ThreadLocal<io.objectbox.Transaction> r1 = r3.activeTx
            r1.set(r0)
            r4.run()     // Catch:{ all -> 0x0039 }
            java.lang.ThreadLocal<io.objectbox.Transaction> r4 = r3.activeTx
            r4.remove()
            java.util.Map<java.lang.Class<?>, io.objectbox.Box<?>> r4 = r3.boxes
            java.util.Collection r4 = r4.values()
            java.util.Iterator r4 = r4.iterator()
        L_0x0025:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0035
            java.lang.Object r1 = r4.next()
            io.objectbox.Box r1 = (io.objectbox.Box) r1
            r1.readTxFinished(r0)
            goto L_0x0025
        L_0x0035:
            r0.close()
            goto L_0x0060
        L_0x0039:
            r4 = move-exception
            java.lang.ThreadLocal<io.objectbox.Transaction> r1 = r3.activeTx
            r1.remove()
            java.util.Map<java.lang.Class<?>, io.objectbox.Box<?>> r1 = r3.boxes
            java.util.Collection r1 = r1.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x0049:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0059
            java.lang.Object r2 = r1.next()
            io.objectbox.Box r2 = (io.objectbox.Box) r2
            r2.readTxFinished(r0)
            goto L_0x0049
        L_0x0059:
            r0.close()
            throw r4
        L_0x005d:
            r4.run()
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.BoxStore.runInReadTx(java.lang.Runnable):void");
    }

    public <T> T callInReadTxWithRetry(Callable<T> callable, int i, int i2, boolean z) {
        int i3 = 1;
        if (i == 1) {
            return callInReadTx(callable);
        }
        if (i >= 1) {
            long j = (long) i2;
            DbException e = null;
            while (i3 <= i) {
                try {
                    return callInReadTx(callable);
                } catch (DbException e2) {
                    e = e2;
                    String diagnose = diagnose();
                    String str = i3 + " of " + i + " attempts of calling a read TX failed:";
                    if (z) {
                        System.err.println(str);
                        e.printStackTrace();
                        System.err.println(diagnose);
                        System.err.flush();
                        System.gc();
                        System.runFinalization();
                        cleanStaleReadTransactions();
                    }
                    TxCallback<?> txCallback = this.failedReadTxAttemptCallback;
                    if (txCallback != null) {
                        txCallback.txFinished(null, new DbException(str + " \n" + diagnose, (Throwable) e));
                    }
                    try {
                        Thread.sleep(j);
                        j *= 2;
                        i3++;
                    } catch (InterruptedException e3) {
                        e3.printStackTrace();
                        throw e;
                    }
                }
            }
            throw e;
        }
        throw new IllegalArgumentException("Illegal value of attempts: " + i);
    }

    public <T> T callInReadTx(Callable<T> callable) {
        if (this.activeTx.get() == null) {
            Transaction beginReadTx = beginReadTx();
            this.activeTx.set(beginReadTx);
            try {
                T call = callable.call();
                this.activeTx.remove();
                for (Box<?> readTxFinished : this.boxes.values()) {
                    readTxFinished.readTxFinished(beginReadTx);
                }
                beginReadTx.close();
                return call;
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException("Callable threw exception", e2);
            } catch (Throwable th) {
                this.activeTx.remove();
                for (Box<?> readTxFinished2 : this.boxes.values()) {
                    readTxFinished2.readTxFinished(beginReadTx);
                }
                beginReadTx.close();
                throw th;
            }
        } else {
            try {
                return callable.call();
            } catch (Exception e3) {
                throw new RuntimeException("Callable threw exception", e3);
            }
        }
    }

    public <R> R callInTx(Callable<R> callable) throws Exception {
        Transaction transaction = this.activeTx.get();
        if (transaction == null) {
            Transaction beginTx = beginTx();
            this.activeTx.set(beginTx);
            try {
                R call = callable.call();
                beginTx.commit();
                return call;
            } finally {
                this.activeTx.remove();
                beginTx.close();
            }
        } else if (!transaction.isReadOnly()) {
            return callable.call();
        } else {
            throw new IllegalStateException("Cannot start a transaction while a read only transaction is active");
        }
    }

    public <R> R callInTxNoException(Callable<R> callable) {
        try {
            return callInTx(callable);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void runInTxAsync(Runnable runnable, @Nullable TxCallback<Void> txCallback) {
        this.threadPool.submit(new BoxStore$$ExternalSyntheticLambda2(this, runnable, txCallback));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$runInTxAsync$1$io-objectbox-BoxStore  reason: not valid java name */
    public /* synthetic */ void m300lambda$runInTxAsync$1$ioobjectboxBoxStore(Runnable runnable, TxCallback txCallback) {
        try {
            runInTx(runnable);
            if (txCallback != null) {
                txCallback.txFinished(null, (Throwable) null);
            }
        } catch (Throwable th) {
            if (txCallback != null) {
                txCallback.txFinished(null, th);
            }
        }
    }

    public <R> void callInTxAsync(Callable<R> callable, @Nullable TxCallback<R> txCallback) {
        this.threadPool.submit(new BoxStore$$ExternalSyntheticLambda1(this, callable, txCallback));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$callInTxAsync$2$io-objectbox-BoxStore  reason: not valid java name */
    public /* synthetic */ void m299lambda$callInTxAsync$2$ioobjectboxBoxStore(Callable callable, TxCallback txCallback) {
        try {
            Object callInTx = callInTx(callable);
            if (txCallback != null) {
                txCallback.txFinished(callInTx, (Throwable) null);
            }
        } catch (Throwable th) {
            if (txCallback != null) {
                txCallback.txFinished(null, th);
            }
        }
    }

    public String diagnose() {
        return nativeDiagnose(getNativeStore());
    }

    public long validate(long j, boolean z) {
        if (j >= 0) {
            return nativeValidate(getNativeStore(), j, z);
        }
        throw new IllegalArgumentException("pageLimit must be zero or positive");
    }

    public int cleanStaleReadTransactions() {
        return nativeCleanStaleReadTransactions(getNativeStore());
    }

    public void closeThreadResources() {
        for (Box<?> closeThreadResources : this.boxes.values()) {
            closeThreadResources.closeThreadResources();
        }
    }

    public SubscriptionBuilder<Class> subscribe() {
        checkOpen();
        return new SubscriptionBuilder<>(this.objectClassPublisher, (Object) null);
    }

    public <T> SubscriptionBuilder<Class<T>> subscribe(Class<T> cls) {
        checkOpen();
        return new SubscriptionBuilder<>(this.objectClassPublisher, cls);
    }

    @Nullable
    public String startObjectBrowser() {
        verifyObjectBrowserNotRunning();
        int i = 8090;
        while (i < 8100) {
            try {
                String startObjectBrowser = startObjectBrowser(i);
                if (startObjectBrowser != null) {
                    return startObjectBrowser;
                }
                i++;
            } catch (DbException e) {
                if (e.getMessage() == null || !e.getMessage().contains("port")) {
                    throw e;
                }
            }
        }
        return null;
    }

    @Nullable
    public String startObjectBrowser(int i) {
        verifyObjectBrowserNotRunning();
        String nativeStartObjectBrowser = nativeStartObjectBrowser(getNativeStore(), (String) null, i);
        if (nativeStartObjectBrowser != null) {
            this.objectBrowserPort = i;
        }
        return nativeStartObjectBrowser;
    }

    @Nullable
    public String startObjectBrowser(String str) {
        verifyObjectBrowserNotRunning();
        try {
            int port = new URL(str).getPort();
            String nativeStartObjectBrowser = nativeStartObjectBrowser(getNativeStore(), str, 0);
            if (nativeStartObjectBrowser != null) {
                this.objectBrowserPort = port;
            }
            return nativeStartObjectBrowser;
        } catch (MalformedURLException e) {
            throw new RuntimeException("Can not start Object Browser at " + str, e);
        }
    }

    public synchronized boolean stopObjectBrowser() {
        if (this.objectBrowserPort != 0) {
            this.objectBrowserPort = 0;
        } else {
            throw new IllegalStateException("ObjectBrowser has not been started before");
        }
        return nativeStopObjectBrowser(getNativeStore());
    }

    public int getObjectBrowserPort() {
        return this.objectBrowserPort;
    }

    public boolean isObjectBrowserRunning() {
        return this.objectBrowserPort != 0;
    }

    private void verifyObjectBrowserNotRunning() {
        if (this.objectBrowserPort != 0) {
            throw new DbException("ObjectBrowser is already running at port " + this.objectBrowserPort);
        }
    }

    public void setDbExceptionListener(@Nullable DbExceptionListener dbExceptionListener) {
        nativeSetDbExceptionListener(getNativeStore(), dbExceptionListener);
    }

    public Future<?> internalScheduleThread(Runnable runnable) {
        return this.threadPool.submit(runnable);
    }

    public ExecutorService internalThreadPool() {
        return this.threadPool;
    }

    public boolean isDebugRelations() {
        return this.debugRelations;
    }

    public int internalQueryAttempts() {
        return this.queryAttempts;
    }

    public TxCallback<?> internalFailedReadTxAttemptCallback() {
        return this.failedReadTxAttemptCallback;
    }

    /* access modifiers changed from: package-private */
    public void setDebugFlags(int i) {
        nativeSetDebugFlags(getNativeStore(), i);
    }

    /* access modifiers changed from: package-private */
    public long panicModeRemoveAllObjects(int i) {
        return nativePanicModeRemoveAllObjects(getNativeStore(), i);
    }

    public long getNativeStore() {
        checkOpen();
        return this.handle;
    }

    public boolean isNativeStoreClosed() {
        return this.handle == 0;
    }

    @Nullable
    public SyncClient getSyncClient() {
        return this.syncClient;
    }

    /* access modifiers changed from: package-private */
    public void setSyncClient(@Nullable SyncClient syncClient2) {
        this.syncClient = syncClient2;
    }
}
