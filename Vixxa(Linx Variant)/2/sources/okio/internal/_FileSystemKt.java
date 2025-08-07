package okio.internal;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Source;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH\u0000\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0000\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", "target", "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: -FileSystem.kt */
public final class _FileSystemKt {
    public static final FileMetadata commonMetadata(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = fileSystem.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException("no such file: " + path);
    }

    public static final boolean commonExists(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(FileSystem fileSystem, Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        ArrayDeque arrayDeque = new ArrayDeque();
        Path path2 = path;
        while (path2 != null && !fileSystem.exists(path2)) {
            arrayDeque.addFirst(path2);
            path2 = path2.parent();
        }
        if (!z || !arrayDeque.isEmpty()) {
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                fileSystem.createDirectory((Path) it.next());
            }
            return;
        }
        throw new IOException(path + " already exist.");
    }

    public static final void commonCopy(FileSystem fileSystem, Path path, Path path2) throws IOException {
        Long l;
        Long l2;
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "source");
        Intrinsics.checkNotNullParameter(path2, TypedValues.AttributesType.S_TARGET);
        Closeable source = fileSystem.source(path);
        Throwable th = null;
        try {
            Source source2 = (Source) source;
            Closeable buffer = Okio.buffer(fileSystem.sink(path2));
            try {
                l2 = Long.valueOf(((BufferedSink) buffer).writeAll(source2));
                th = null;
            } catch (Throwable th2) {
                th = th2;
                l2 = null;
            }
            if (buffer != null) {
                buffer.close();
            }
        } catch (Throwable th3) {
            th = th3;
            l = null;
        }
        if (th == null) {
            Intrinsics.checkNotNull(l2);
            l = Long.valueOf(l2.longValue());
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th4) {
                    if (th == null) {
                        th = th4;
                    } else {
                        ExceptionsKt.addSuppressed(th, th4);
                    }
                }
            }
            if (th == null) {
                Intrinsics.checkNotNull(l);
                return;
            }
            throw th;
        }
        throw th;
    }

    public static final void commonDeleteRecursively(FileSystem fileSystem, Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "fileOrDirectory");
        Iterator it = SequencesKt.sequence(new _FileSystemKt$commonDeleteRecursively$sequence$1(fileSystem, path, (Continuation<? super _FileSystemKt$commonDeleteRecursively$sequence$1>) null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final Sequence<Path> commonListRecursively(FileSystem fileSystem, Path path, boolean z) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "dir");
        return SequencesKt.sequence(new _FileSystemKt$commonListRecursively$1(path, fileSystem, z, (Continuation<? super _FileSystemKt$commonListRecursively$1>) null));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r0 != false) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e1, code lost:
        if (r7 != 0) goto L_0x012f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e3, code lost:
        r6.addLast(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ea, code lost:
        r7 = r6;
        r6 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r3.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0125, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0126, code lost:
        r7 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0127, code lost:
        r7.removeLast();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x012a, code lost:
        throw r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00f5 A[Catch:{ all -> 0x005e }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011f A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(kotlin.sequences.SequenceScope<? super okio.Path> r15, okio.FileSystem r16, kotlin.collections.ArrayDeque<okio.Path> r17, okio.Path r18, boolean r19, boolean r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r0 = r15
            r1 = r18
            r2 = r20
            r3 = r21
            boolean r4 = r3 instanceof okio.internal._FileSystemKt$collectRecursively$1
            if (r4 == 0) goto L_0x001b
            r4 = r3
            okio.internal._FileSystemKt$collectRecursively$1 r4 = (okio.internal._FileSystemKt$collectRecursively$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001b
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0020
        L_0x001b:
            okio.internal._FileSystemKt$collectRecursively$1 r4 = new okio.internal._FileSystemKt$collectRecursively$1
            r4.<init>(r3)
        L_0x0020:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 0
            r8 = 3
            r9 = 2
            r10 = 1
            if (r6 == 0) goto L_0x007d
            if (r6 == r10) goto L_0x0061
            if (r6 == r9) goto L_0x0041
            if (r6 != r8) goto L_0x0039
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x0145
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$4
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r6 = r4.L$3
            okio.Path r6 = (okio.Path) r6
            java.lang.Object r7 = r4.L$2
            kotlin.collections.ArrayDeque r7 = (kotlin.collections.ArrayDeque) r7
            java.lang.Object r10 = r4.L$1
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r3)     // Catch:{ all -> 0x005e }
            goto L_0x00ef
        L_0x005e:
            r0 = move-exception
            goto L_0x0127
        L_0x0061:
            boolean r0 = r4.Z$1
            boolean r1 = r4.Z$0
            java.lang.Object r2 = r4.L$3
            okio.Path r2 = (okio.Path) r2
            java.lang.Object r6 = r4.L$2
            kotlin.collections.ArrayDeque r6 = (kotlin.collections.ArrayDeque) r6
            java.lang.Object r10 = r4.L$1
            okio.FileSystem r10 = (okio.FileSystem) r10
            java.lang.Object r11 = r4.L$0
            kotlin.sequences.SequenceScope r11 = (kotlin.sequences.SequenceScope) r11
            kotlin.ResultKt.throwOnFailure(r3)
            r14 = r2
            r2 = r0
            r0 = r1
            r1 = r14
            goto L_0x00a7
        L_0x007d:
            kotlin.ResultKt.throwOnFailure(r3)
            if (r2 != 0) goto L_0x009d
            r4.L$0 = r0
            r3 = r16
            r4.L$1 = r3
            r6 = r17
            r4.L$2 = r6
            r4.L$3 = r1
            r11 = r19
            r4.Z$0 = r11
            r4.Z$1 = r2
            r4.label = r10
            java.lang.Object r10 = r15.yield(r1, r4)
            if (r10 != r5) goto L_0x00a3
            return r5
        L_0x009d:
            r3 = r16
            r6 = r17
            r11 = r19
        L_0x00a3:
            r10 = r3
            r14 = r11
            r11 = r0
            r0 = r14
        L_0x00a7:
            java.util.List r3 = r10.listOrNull(r1)
            if (r3 != 0) goto L_0x00b1
            java.util.List r3 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00b1:
            r12 = r3
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            if (r12 != 0) goto L_0x012f
            r12 = r1
        L_0x00bb:
            if (r0 == 0) goto L_0x00d9
            boolean r13 = r6.contains(r12)
            if (r13 != 0) goto L_0x00c4
            goto L_0x00d9
        L_0x00c4:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "symlink cycle at "
            r2.<init>(r3)
            java.lang.StringBuilder r1 = r2.append(r1)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x00d9:
            okio.Path r13 = symlinkTarget(r10, r12)
            if (r13 != 0) goto L_0x012b
            if (r0 != 0) goto L_0x00e3
            if (r7 != 0) goto L_0x012f
        L_0x00e3:
            r6.addLast(r12)
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0125 }
            r7 = r6
            r6 = r1
            r1 = r0
            r0 = r2
            r2 = r3
        L_0x00ef:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x005e }
            if (r3 == 0) goto L_0x011f
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x005e }
            okio.Path r3 = (okio.Path) r3     // Catch:{ all -> 0x005e }
            r4.L$0 = r11     // Catch:{ all -> 0x005e }
            r4.L$1 = r10     // Catch:{ all -> 0x005e }
            r4.L$2 = r7     // Catch:{ all -> 0x005e }
            r4.L$3 = r6     // Catch:{ all -> 0x005e }
            r4.L$4 = r2     // Catch:{ all -> 0x005e }
            r4.Z$0 = r1     // Catch:{ all -> 0x005e }
            r4.Z$1 = r0     // Catch:{ all -> 0x005e }
            r4.label = r9     // Catch:{ all -> 0x005e }
            r15 = r11
            r16 = r10
            r17 = r7
            r18 = r3
            r19 = r1
            r20 = r0
            r21 = r4
            java.lang.Object r3 = collectRecursively(r15, r16, r17, r18, r19, r20, r21)     // Catch:{ all -> 0x005e }
            if (r3 != r5) goto L_0x00ef
            return r5
        L_0x011f:
            r7.removeLast()
            r2 = r0
            r1 = r6
            goto L_0x012f
        L_0x0125:
            r0 = move-exception
            r7 = r6
        L_0x0127:
            r7.removeLast()
            throw r0
        L_0x012b:
            int r7 = r7 + 1
            r12 = r13
            goto L_0x00bb
        L_0x012f:
            if (r2 == 0) goto L_0x0148
            r0 = 0
            r4.L$0 = r0
            r4.L$1 = r0
            r4.L$2 = r0
            r4.L$3 = r0
            r4.L$4 = r0
            r4.label = r8
            java.lang.Object r0 = r11.yield(r1, r4)
            if (r0 != r5) goto L_0x0145
            return r5
        L_0x0145:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0148:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Path symlinkTarget(FileSystem fileSystem, Path path) throws IOException {
        Intrinsics.checkNotNullParameter(fileSystem, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(symlinkTarget);
    }
}
