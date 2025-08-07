package io.objectbox;

import android.support.v4.media.session.PlaybackStateCompat;
import io.objectbox.config.FlatStoreOptions;
import io.objectbox.exception.DbException;
import io.objectbox.flatbuffers.FlatBufferBuilder;
import io.objectbox.ideasonly.ModelUpdate;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import net.lingala.zip4j.util.InternalZipConstants;
import org.greenrobot.essentials.io.IoUtils;

public class BoxStoreBuilder {
    public static final int DEFAULT_MAX_DB_SIZE_KBYTE = 1048576;
    public static final String DEFAULT_NAME = "objectbox";
    private File baseDirectory;
    @Nullable
    Object context;
    int debugFlags;
    boolean debugRelations;
    File directory;
    final List<EntityInfo<?>> entityInfoList;
    TxCallback<?> failedReadTxAttemptCallback;
    int fileMode;
    private String inMemory;
    private Factory<InputStream> initialDbFileFactory;
    long maxDataSizeInKByte;
    int maxReaders;
    long maxSizeInKByte;
    final byte[] model;
    ModelUpdate modelUpdate;
    private String name;
    boolean noReaderThreadLocals;
    int queryAttempts;
    boolean readOnly;
    @Nullable
    Object relinker;
    boolean skipReadSchema;
    boolean usePreviousCommit;
    short validateOnOpenModeKv;
    short validateOnOpenModePages;
    long validateOnOpenPageLimit;

    public static BoxStoreBuilder createDebugWithoutModel() {
        BoxStoreBuilder boxStoreBuilder = new BoxStoreBuilder();
        boxStoreBuilder.skipReadSchema = true;
        return boxStoreBuilder;
    }

    private BoxStoreBuilder() {
        this.maxSizeInKByte = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.entityInfoList = new ArrayList();
        this.model = null;
    }

    public BoxStoreBuilder(byte[] bArr) {
        this.maxSizeInKByte = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        this.entityInfoList = new ArrayList();
        if (bArr != null) {
            this.model = Arrays.copyOf(bArr, bArr.length);
            return;
        }
        throw new IllegalArgumentException("Model may not be null");
    }

    public BoxStoreBuilder name(String str) {
        checkIsNull(this.directory, "Already has directory, cannot assign name");
        checkIsNull(this.inMemory, "Already set to in-memory database, cannot assign name");
        if (str.contains(InternalZipConstants.ZIP_FILE_SEPARATOR) || str.contains("\\")) {
            throw new IllegalArgumentException("Name may not contain (back) slashes. Use baseDirectory() or directory() to configure alternative directories");
        }
        this.name = str;
        return this;
    }

    public BoxStoreBuilder directory(File file) {
        checkIsNull(this.name, "Already has name, cannot assign directory");
        checkIsNull(this.inMemory, "Already set to in-memory database, cannot assign directory");
        checkIsNull(this.baseDirectory, "Already has base directory, cannot assign directory");
        this.directory = file;
        return this;
    }

    public BoxStoreBuilder baseDirectory(File file) {
        checkIsNull(this.directory, "Already has directory, cannot assign base directory");
        checkIsNull(this.inMemory, "Already set to in-memory database, cannot assign base directory");
        this.baseDirectory = file;
        return this;
    }

    public BoxStoreBuilder inMemory(String str) {
        checkIsNull(this.name, "Already has name, cannot switch to in-memory database");
        checkIsNull(this.directory, "Already has directory, cannot switch to in-memory database");
        checkIsNull(this.baseDirectory, "Already has base directory, cannot switch to in-memory database");
        this.inMemory = str;
        return this;
    }

    private static void checkIsNull(@Nullable Object obj, String str) {
        if (obj != null) {
            throw new IllegalStateException(str);
        }
    }

    public BoxStoreBuilder androidContext(Object obj) {
        if (obj != null) {
            this.context = getApplicationContext(obj);
            return this;
        }
        throw new NullPointerException("Context may not be null");
    }

    private Object getApplicationContext(Object obj) {
        try {
            return obj.getClass().getMethod("getApplicationContext", new Class[0]).invoke(obj, new Object[0]);
        } catch (Exception e) {
            throw new RuntimeException("context must be a valid Android Context", e);
        }
    }

    public BoxStoreBuilder androidReLinker(Object obj) {
        if (this.context == null) {
            throw new IllegalArgumentException("Set a Context using androidContext(context) first");
        } else if (obj != null) {
            this.relinker = obj;
            return this;
        } else {
            throw new NullPointerException("ReLinkerInstance may not be null");
        }
    }

    static File getAndroidDbDir(Object obj, @Nullable String str) {
        return new File(getAndroidBaseDir(obj), dbName(str));
    }

    private static String dbName(@Nullable String str) {
        return str != null ? str : DEFAULT_NAME;
    }

    static File getAndroidBaseDir(Object obj) {
        return new File(getAndroidFilesDir(obj), DEFAULT_NAME);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: java.io.File} */
    /* JADX WARNING: Multi-variable type inference failed */
    @javax.annotation.Nonnull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.io.File getAndroidFilesDir(java.lang.Object r4) {
        /*
            java.lang.Class r0 = r4.getClass()     // Catch:{ Exception -> 0x0040 }
            java.lang.String r1 = "getFilesDir"
            r2 = 0
            java.lang.Class[] r3 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0040 }
            java.lang.reflect.Method r0 = r0.getMethod(r1, r3)     // Catch:{ Exception -> 0x0040 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r1 = r0.invoke(r4, r1)     // Catch:{ Exception -> 0x0040 }
            java.io.File r1 = (java.io.File) r1     // Catch:{ Exception -> 0x0040 }
            if (r1 != 0) goto L_0x0027
            java.io.PrintStream r1 = java.lang.System.err     // Catch:{ Exception -> 0x0040 }
            java.lang.String r3 = "getFilesDir() returned null - retrying once..."
            r1.println(r3)     // Catch:{ Exception -> 0x0040 }
            java.lang.Object[] r1 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r4 = r0.invoke(r4, r1)     // Catch:{ Exception -> 0x0040 }
            r1 = r4
            java.io.File r1 = (java.io.File) r1     // Catch:{ Exception -> 0x0040 }
        L_0x0027:
            if (r1 == 0) goto L_0x0038
            boolean r4 = r1.exists()
            if (r4 == 0) goto L_0x0030
            return r1
        L_0x0030:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Android files dir does not exist"
            r4.<init>(r0)
            throw r4
        L_0x0038:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "Android files dir is null"
            r4.<init>(r0)
            throw r4
        L_0x0040:
            r4 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Could not init with given Android context (must be sub class of android.content.Context)"
            r0.<init>(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.BoxStoreBuilder.getAndroidFilesDir(java.lang.Object):java.io.File");
    }

    public BoxStoreBuilder fileMode(int i) {
        this.fileMode = i;
        return this;
    }

    public BoxStoreBuilder maxReaders(int i) {
        this.maxReaders = i;
        return this;
    }

    public BoxStoreBuilder noReaderThreadLocals() {
        this.noReaderThreadLocals = true;
        return this;
    }

    public void entity(EntityInfo<?> entityInfo) {
        this.entityInfoList.add(entityInfo);
    }

    /* access modifiers changed from: package-private */
    public BoxStoreBuilder modelUpdate(ModelUpdate modelUpdate2) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public BoxStoreBuilder maxSizeInKByte(long j) {
        if (j > this.maxDataSizeInKByte) {
            this.maxSizeInKByte = j;
            return this;
        }
        throw new IllegalArgumentException("maxSizeInKByte must be larger than maxDataSizeInKByte.");
    }

    public BoxStoreBuilder maxDataSizeInKByte(long j) {
        if (j < this.maxSizeInKByte) {
            this.maxDataSizeInKByte = j;
            return this;
        }
        throw new IllegalArgumentException("maxDataSizeInKByte must be smaller than maxSizeInKByte.");
    }

    public BoxStoreBuilder readOnly() {
        this.readOnly = true;
        return this;
    }

    public BoxStoreBuilder usePreviousCommit() {
        this.usePreviousCommit = true;
        return this;
    }

    public BoxStoreBuilder validateOnOpen(short s) {
        if (s < 1 || s > 5) {
            throw new IllegalArgumentException("Must be one of ValidateOnOpenModePages");
        }
        this.validateOnOpenModePages = s;
        return this;
    }

    public BoxStoreBuilder validateOnOpenPageLimit(long j) {
        short s = this.validateOnOpenModePages;
        if (s != 2 && s != 3) {
            throw new IllegalStateException("Must call validateOnOpen(mode) with mode Regular or WithLeaves first");
        } else if (j >= 1) {
            this.validateOnOpenPageLimit = j;
            return this;
        } else {
            throw new IllegalArgumentException("limit must be positive");
        }
    }

    public BoxStoreBuilder validateOnOpenKv() {
        this.validateOnOpenModeKv = 1;
        return this;
    }

    public BoxStoreBuilder validateOnOpenKv(short s) {
        if (s < 1 || s > 1) {
            throw new IllegalArgumentException("Must be one of ValidateOnOpenModeKv");
        }
        this.validateOnOpenModeKv = s;
        return this;
    }

    @Deprecated
    public BoxStoreBuilder debugTransactions() {
        this.debugFlags |= 3;
        return this;
    }

    public BoxStoreBuilder debugFlags(int i) {
        this.debugFlags = i;
        return this;
    }

    public BoxStoreBuilder debugRelations() {
        this.debugRelations = true;
        return this;
    }

    public BoxStoreBuilder queryAttempts(int i) {
        if (i >= 1) {
            this.queryAttempts = i;
            return this;
        }
        throw new IllegalArgumentException("Query attempts must >= 1");
    }

    public BoxStoreBuilder failedReadTxAttemptCallback(TxCallback<?> txCallback) {
        this.failedReadTxAttemptCallback = txCallback;
        return this;
    }

    static /* synthetic */ InputStream lambda$initialDbFile$0(File file) throws Exception {
        return new FileInputStream(file);
    }

    public BoxStoreBuilder initialDbFile(File file) {
        return initialDbFile((Factory<InputStream>) new BoxStoreBuilder$$ExternalSyntheticLambda0(file));
    }

    public BoxStoreBuilder initialDbFile(Factory<InputStream> factory) {
        this.initialDbFileFactory = factory;
        return this;
    }

    /* access modifiers changed from: package-private */
    public byte[] buildFlatStoreOptions(String str) {
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder();
        flatBufferBuilder.forceDefaults(true);
        int createString = flatBufferBuilder.createString((CharSequence) str);
        FlatStoreOptions.startFlatStoreOptions(flatBufferBuilder);
        FlatStoreOptions.addDirectoryPath(flatBufferBuilder, createString);
        FlatStoreOptions.addMaxDbSizeInKbyte(flatBufferBuilder, this.maxSizeInKByte);
        FlatStoreOptions.addFileMode(flatBufferBuilder, (long) this.fileMode);
        FlatStoreOptions.addMaxReaders(flatBufferBuilder, (long) this.maxReaders);
        short s = this.validateOnOpenModePages;
        if (s != 0) {
            FlatStoreOptions.addValidateOnOpenPages(flatBufferBuilder, s);
            long j = this.validateOnOpenPageLimit;
            if (j != 0) {
                FlatStoreOptions.addValidateOnOpenPageLimit(flatBufferBuilder, j);
            }
        }
        short s2 = this.validateOnOpenModeKv;
        if (s2 != 0) {
            FlatStoreOptions.addValidateOnOpenKv(flatBufferBuilder, s2);
        }
        if (this.skipReadSchema) {
            FlatStoreOptions.addSkipReadSchema(flatBufferBuilder, true);
        }
        if (this.usePreviousCommit) {
            FlatStoreOptions.addUsePreviousCommit(flatBufferBuilder, true);
        }
        if (this.readOnly) {
            FlatStoreOptions.addReadOnly(flatBufferBuilder, true);
        }
        if (this.noReaderThreadLocals) {
            FlatStoreOptions.addNoReaderThreadLocals(flatBufferBuilder, true);
        }
        int i = this.debugFlags;
        if (i != 0) {
            FlatStoreOptions.addDebugFlags(flatBufferBuilder, (long) i);
        }
        long j2 = this.maxDataSizeInKByte;
        if (j2 > 0) {
            FlatStoreOptions.addMaxDataSizeInKbyte(flatBufferBuilder, j2);
        }
        flatBufferBuilder.finish(FlatStoreOptions.endFlatStoreOptions(flatBufferBuilder));
        return flatBufferBuilder.sizedByteArray();
    }

    public BoxStore build() {
        Object obj;
        if (this.inMemory != null) {
            this.directory = new File(BoxStore.IN_MEMORY_PREFIX + this.inMemory);
        }
        if (this.directory == null && this.baseDirectory == null && (obj = this.context) != null) {
            File androidBaseDir = getAndroidBaseDir(obj);
            if (!androidBaseDir.exists()) {
                androidBaseDir.mkdir();
                if (!androidBaseDir.exists()) {
                    throw new RuntimeException("Could not init Android base dir at " + androidBaseDir.getAbsolutePath());
                }
            }
            if (androidBaseDir.isDirectory()) {
                this.baseDirectory = androidBaseDir;
            } else {
                throw new RuntimeException("Android base dir is not a dir: " + androidBaseDir.getAbsolutePath());
            }
        }
        if (this.directory == null) {
            this.directory = getDbDir(this.baseDirectory, this.name);
        }
        if (this.inMemory == null) {
            checkProvisionInitialDbFile();
        }
        return new BoxStore(this);
    }

    private void checkProvisionInitialDbFile() {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream;
        Exception e;
        BufferedInputStream bufferedInputStream2;
        BufferedOutputStream bufferedOutputStream2;
        if (this.initialDbFileFactory != null) {
            File file = new File(BoxStore.getCanonicalPath(this.directory), "data.mdb");
            if (!file.exists()) {
                try {
                    bufferedInputStream = this.initialDbFileFactory.provide();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream2 = new BufferedInputStream(bufferedInputStream);
                            try {
                                bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream = bufferedInputStream2;
                                Exception exc = e;
                                bufferedOutputStream = null;
                                e = exc;
                                try {
                                    throw new DbException("Could not provision initial data file", (Throwable) e);
                                } catch (Throwable th) {
                                    th = th;
                                    IoUtils.safeClose(bufferedOutputStream);
                                    IoUtils.safeClose(bufferedInputStream);
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedInputStream = bufferedInputStream2;
                                Throwable th3 = th;
                                bufferedOutputStream = null;
                                th = th3;
                                IoUtils.safeClose(bufferedOutputStream);
                                IoUtils.safeClose(bufferedInputStream);
                                throw th;
                            }
                        } catch (Exception e3) {
                            e = e3;
                            Exception exc2 = e;
                            bufferedOutputStream = null;
                            e = exc2;
                            throw new DbException("Could not provision initial data file", (Throwable) e);
                        } catch (Throwable th4) {
                            th = th4;
                            Throwable th32 = th;
                            bufferedOutputStream = null;
                            th = th32;
                            IoUtils.safeClose(bufferedOutputStream);
                            IoUtils.safeClose(bufferedInputStream);
                            throw th;
                        }
                        try {
                            IoUtils.copyAllBytes(bufferedInputStream2, bufferedOutputStream2);
                            IoUtils.safeClose(bufferedOutputStream2);
                            IoUtils.safeClose(bufferedInputStream2);
                        } catch (Exception e4) {
                            e = e4;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream = bufferedInputStream2;
                            throw new DbException("Could not provision initial data file", (Throwable) e);
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedOutputStream = bufferedOutputStream2;
                            bufferedInputStream = bufferedInputStream2;
                            IoUtils.safeClose(bufferedOutputStream);
                            IoUtils.safeClose(bufferedInputStream);
                            throw th;
                        }
                    } else {
                        throw new DbException("Factory did not provide a resource");
                    }
                } catch (Exception e5) {
                    bufferedInputStream = null;
                    e = e5;
                    bufferedOutputStream = null;
                    throw new DbException("Could not provision initial data file", (Throwable) e);
                } catch (Throwable th6) {
                    bufferedInputStream = null;
                    th = th6;
                    bufferedOutputStream = null;
                    IoUtils.safeClose(bufferedOutputStream);
                    IoUtils.safeClose(bufferedInputStream);
                    throw th;
                }
            }
        }
    }

    static File getDbDir(@Nullable File file, @Nullable String str) {
        String dbName = dbName(str);
        if (file != null) {
            return new File(file, dbName);
        }
        return new File(dbName);
    }

    public BoxStore buildDefault() {
        BoxStore build = build();
        BoxStore.setDefault(build);
        return build;
    }
}
