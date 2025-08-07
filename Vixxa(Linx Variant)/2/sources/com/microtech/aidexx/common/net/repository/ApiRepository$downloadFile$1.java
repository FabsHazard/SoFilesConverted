package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.repository.ApiRepository;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/microtech/aidexx/common/net/repository/ApiRepository$NetResult;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.ApiRepository$downloadFile$1", f = "ApiRepository.kt", i = {0, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {40, 41, 67, 70, 75, 78}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "targetFile", "fileOutStream", "currentLength", "buffer", "bufferIs", "readLength", "length", "bufferSize"}, s = {"L$0", "L$0", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "J$0", "I$0"})
/* compiled from: ApiRepository.kt */
final class ApiRepository$downloadFile$1 extends SuspendLambda implements Function2<FlowCollector<? super ApiRepository.NetResult<? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $downloadPath;
    final /* synthetic */ String $downloadUrl;
    final /* synthetic */ String $fileName;
    int I$0;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ApiRepository$downloadFile$1(String str, String str2, String str3, Continuation<? super ApiRepository$downloadFile$1> continuation) {
        super(2, continuation);
        this.$downloadUrl = str;
        this.$downloadPath = str2;
        this.$fileName = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ApiRepository$downloadFile$1 apiRepository$downloadFile$1 = new ApiRepository$downloadFile$1(this.$downloadUrl, this.$downloadPath, this.$fileName, continuation);
        apiRepository$downloadFile$1.L$0 = obj;
        return apiRepository$downloadFile$1;
    }

    public final Object invoke(FlowCollector<? super ApiRepository.NetResult<String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ApiRepository$downloadFile$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v25, resolved type: java.io.Closeable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v25, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: java.io.Closeable} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        r1.L$0 = r2;
        r1.label = 2;
        r5 = com.microtech.aidexx.common.net.ApiService.Companion.getInstance().downloadFile(r1.$downloadUrl, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b4, code lost:
        if (r5 != r0) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b7, code lost:
        r5 = (com.microtech.aidexx.common.net.ApiResult) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bb, code lost:
        if ((r5 instanceof com.microtech.aidexx.common.net.ApiResult.Success) == false) goto L_0x01ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00bd, code lost:
        r5 = (okhttp3.ResponseBody) ((com.microtech.aidexx.common.net.ApiResult.Success) r5).getResult();
        r6 = r5.contentLength();
        r8 = new java.io.File(r1.$downloadPath, r1.$fileName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d6, code lost:
        if (r8.exists() == false) goto L_0x00db;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d8, code lost:
        r8.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00db, code lost:
        r9 = new java.io.FileOutputStream(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r10 = (java.io.FileOutputStream) r9;
        r11 = new kotlin.jvm.internal.Ref.IntRef();
        r13 = new byte[8192];
        r5 = new java.io.BufferedInputStream(r5.byteStream(), 8192);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r15 = new kotlin.jvm.internal.Ref.IntRef();
        r16 = null;
        r17 = null;
        r19 = r13;
        r13 = r2;
        r2 = 8192;
        r12 = r10;
        r10 = r19;
        r14 = r8;
        r8 = (java.io.BufferedInputStream) r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0112, code lost:
        r4 = r8.read(r10, r3, r2);
        r15.element = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0119, code lost:
        if (r4 == -1) goto L_0x015e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x011b, code lost:
        r12.write(r10, 0, r15.element);
        r11.element += r15.element;
        r18 = r0;
        r3 = new com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Loading((int) ((((float) r11.element) / ((float) r6)) * ((float) 100)));
        r1.L$0 = r13;
        r1.L$1 = r14;
        r1.L$2 = r9;
        r1.L$3 = r12;
        r1.L$4 = r11;
        r1.L$5 = r10;
        r1.L$6 = r5;
        r1.L$7 = r8;
        r1.L$8 = r15;
        r1.J$0 = r6;
        r1.I$0 = r2;
        r1.label = 3;
        r0 = r13.emit(r3, r1);
        r3 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0158, code lost:
        if (r0 != r3) goto L_0x015b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x015a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x015b, code lost:
        r0 = r3;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x015e, code lost:
        r3 = r0;
        r0 = new com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Success(r14.getAbsolutePath());
        r1.L$0 = r9;
        r1.L$1 = r5;
        r1.L$2 = null;
        r1.L$3 = null;
        r1.L$4 = null;
        r1.L$5 = null;
        r1.L$6 = null;
        r1.L$7 = null;
        r1.L$8 = null;
        r1.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0182, code lost:
        if (r13.emit(r0, r1) != r3) goto L_0x0185;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0184, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0185, code lost:
        r2 = r5;
        r3 = r9;
        r4 = r16;
        r0 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0190, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0193, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0194, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0195, code lost:
        r2 = r0;
        r9 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0198, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0199, code lost:
        r4 = r0;
        r2 = r5;
        r3 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x019d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x019e, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01a2, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01a3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a4, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:?, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a6, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01a7, code lost:
        r3 = r0;
        kotlin.io.CloseableKt.closeFinally(r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01ab, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01ac, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01af, code lost:
        if ((r5 instanceof com.microtech.aidexx.common.net.ApiResult.Failure) == false) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01b1, code lost:
        r5 = (com.microtech.aidexx.common.net.ApiResult.Failure) r5;
        r1.L$0 = null;
        r1.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01cd, code lost:
        if (r2.emit(new com.microtech.aidexx.common.net.repository.ApiRepository.NetResult.Failure(r5.getCode(), r5.getMsg()), r1) != r3) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01cf, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01d2, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:49:0x018d, B:57:0x019c] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0085;
                case 1: goto L_0x007d;
                case 2: goto L_0x0073;
                case 3: goto L_0x0033;
                case 4: goto L_0x001e;
                case 5: goto L_0x0019;
                case 6: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0014:
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x01d0
        L_0x0019:
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x01d0
        L_0x001e:
            java.lang.Object r0 = r1.L$1
            r2 = r0
            java.io.Closeable r2 = (java.io.Closeable) r2
            java.lang.Object r0 = r1.L$0
            r3 = r0
            java.io.Closeable r3 = (java.io.Closeable) r3
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x002f }
            r0 = 0
            r4 = 0
            goto L_0x018b
        L_0x002f:
            r0 = move-exception
            r4 = r0
            goto L_0x019c
        L_0x0033:
            int r2 = r1.I$0
            long r5 = r1.J$0
            java.lang.Object r7 = r1.L$8
            kotlin.jvm.internal.Ref$IntRef r7 = (kotlin.jvm.internal.Ref.IntRef) r7
            java.lang.Object r8 = r1.L$7
            java.io.BufferedInputStream r8 = (java.io.BufferedInputStream) r8
            java.lang.Object r9 = r1.L$6
            java.io.Closeable r9 = (java.io.Closeable) r9
            java.lang.Object r10 = r1.L$5
            byte[] r10 = (byte[]) r10
            java.lang.Object r11 = r1.L$4
            kotlin.jvm.internal.Ref$IntRef r11 = (kotlin.jvm.internal.Ref.IntRef) r11
            java.lang.Object r12 = r1.L$3
            java.io.FileOutputStream r12 = (java.io.FileOutputStream) r12
            java.lang.Object r13 = r1.L$2
            java.io.Closeable r13 = (java.io.Closeable) r13
            java.lang.Object r14 = r1.L$1
            java.io.File r14 = (java.io.File) r14
            java.lang.Object r15 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r15 = (kotlinx.coroutines.flow.FlowCollector) r15
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ all -> 0x006d }
            r3 = r0
            r16 = 0
            r17 = 0
            r19 = r15
            r15 = r7
            r6 = r5
            r5 = r9
            r9 = r13
            r13 = r19
            goto L_0x015b
        L_0x006d:
            r0 = move-exception
            r4 = r0
            r2 = r9
            r3 = r13
            goto L_0x019c
        L_0x0073:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r22)
            r5 = r22
            goto L_0x00b7
        L_0x007d:
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r22)
            goto L_0x00a0
        L_0x0085:
            kotlin.ResultKt.throwOnFailure(r22)
            java.lang.Object r2 = r1.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Loading r5 = new com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Loading
            r5.<init>(r3)
            r6 = r1
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r1.L$0 = r2
            r7 = 1
            r1.label = r7
            java.lang.Object r5 = r2.emit(r5, r6)
            if (r5 != r0) goto L_0x00a0
            return r0
        L_0x00a0:
            com.microtech.aidexx.common.net.ApiService$Companion r5 = com.microtech.aidexx.common.net.ApiService.Companion
            com.microtech.aidexx.common.net.ApiService r5 = r5.getInstance()
            java.lang.String r6 = r1.$downloadUrl
            r7 = r1
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r1.L$0 = r2
            r8 = 2
            r1.label = r8
            java.lang.Object r5 = r5.downloadFile(r6, r7)
            if (r5 != r0) goto L_0x00b7
            return r0
        L_0x00b7:
            com.microtech.aidexx.common.net.ApiResult r5 = (com.microtech.aidexx.common.net.ApiResult) r5
            boolean r6 = r5 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r6 == 0) goto L_0x01ac
            com.microtech.aidexx.common.net.ApiResult$Success r5 = (com.microtech.aidexx.common.net.ApiResult.Success) r5
            java.lang.Object r5 = r5.getResult()
            okhttp3.ResponseBody r5 = (okhttp3.ResponseBody) r5
            long r6 = r5.contentLength()
            java.io.File r8 = new java.io.File
            java.lang.String r9 = r1.$downloadPath
            java.lang.String r10 = r1.$fileName
            r8.<init>(r9, r10)
            boolean r9 = r8.exists()
            if (r9 == 0) goto L_0x00db
            r8.delete()
        L_0x00db:
            java.io.FileOutputStream r9 = new java.io.FileOutputStream
            r9.<init>(r8)
            java.io.Closeable r9 = (java.io.Closeable) r9
            r10 = r9
            java.io.FileOutputStream r10 = (java.io.FileOutputStream) r10     // Catch:{ all -> 0x01a3 }
            kotlin.jvm.internal.Ref$IntRef r11 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x01a3 }
            r11.<init>()     // Catch:{ all -> 0x01a3 }
            r12 = 8192(0x2000, float:1.14794E-41)
            byte[] r13 = new byte[r12]     // Catch:{ all -> 0x01a3 }
            java.io.BufferedInputStream r14 = new java.io.BufferedInputStream     // Catch:{ all -> 0x01a3 }
            java.io.InputStream r5 = r5.byteStream()     // Catch:{ all -> 0x01a3 }
            r14.<init>(r5, r12)     // Catch:{ all -> 0x01a3 }
            r5 = r14
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x01a3 }
            r14 = r5
            java.io.BufferedInputStream r14 = (java.io.BufferedInputStream) r14     // Catch:{ all -> 0x0198 }
            kotlin.jvm.internal.Ref$IntRef r15 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ all -> 0x0198 }
            r15.<init>()     // Catch:{ all -> 0x0198 }
            r16 = 0
            r17 = 0
            r19 = r13
            r13 = r2
            r2 = r12
            r12 = r10
            r10 = r19
            r20 = r14
            r14 = r8
            r8 = r20
        L_0x0112:
            int r4 = r8.read(r10, r3, r2)     // Catch:{ all -> 0x0198 }
            r15.element = r4     // Catch:{ all -> 0x0198 }
            r3 = -1
            if (r4 == r3) goto L_0x015e
            int r3 = r15.element     // Catch:{ all -> 0x0198 }
            r4 = 0
            r12.write(r10, r4, r3)     // Catch:{ all -> 0x0198 }
            int r3 = r11.element     // Catch:{ all -> 0x0198 }
            int r4 = r15.element     // Catch:{ all -> 0x0198 }
            int r3 = r3 + r4
            r11.element = r3     // Catch:{ all -> 0x0198 }
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Loading r3 = new com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Loading     // Catch:{ all -> 0x0198 }
            int r4 = r11.element     // Catch:{ all -> 0x0198 }
            float r4 = (float) r4     // Catch:{ all -> 0x0198 }
            r18 = r0
            float r0 = (float) r6     // Catch:{ all -> 0x0198 }
            float r4 = r4 / r0
            r0 = 100
            float r0 = (float) r0     // Catch:{ all -> 0x0198 }
            float r4 = r4 * r0
            int r0 = (int) r4     // Catch:{ all -> 0x0198 }
            r3.<init>(r0)     // Catch:{ all -> 0x0198 }
            r1.L$0 = r13     // Catch:{ all -> 0x0198 }
            r1.L$1 = r14     // Catch:{ all -> 0x0198 }
            r1.L$2 = r9     // Catch:{ all -> 0x0198 }
            r1.L$3 = r12     // Catch:{ all -> 0x0198 }
            r1.L$4 = r11     // Catch:{ all -> 0x0198 }
            r1.L$5 = r10     // Catch:{ all -> 0x0198 }
            r1.L$6 = r5     // Catch:{ all -> 0x0198 }
            r1.L$7 = r8     // Catch:{ all -> 0x0198 }
            r1.L$8 = r15     // Catch:{ all -> 0x0198 }
            r1.J$0 = r6     // Catch:{ all -> 0x0198 }
            r1.I$0 = r2     // Catch:{ all -> 0x0198 }
            r0 = 3
            r1.label = r0     // Catch:{ all -> 0x0198 }
            java.lang.Object r0 = r13.emit(r3, r1)     // Catch:{ all -> 0x0198 }
            r3 = r18
            if (r0 != r3) goto L_0x015b
            return r3
        L_0x015b:
            r0 = r3
            r3 = 0
            goto L_0x0112
        L_0x015e:
            r3 = r0
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Success r0 = new com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Success     // Catch:{ all -> 0x0198 }
            java.lang.String r2 = r14.getAbsolutePath()     // Catch:{ all -> 0x0198 }
            r0.<init>(r2)     // Catch:{ all -> 0x0198 }
            r1.L$0 = r9     // Catch:{ all -> 0x0198 }
            r1.L$1 = r5     // Catch:{ all -> 0x0198 }
            r2 = 0
            r1.L$2 = r2     // Catch:{ all -> 0x0198 }
            r1.L$3 = r2     // Catch:{ all -> 0x0198 }
            r1.L$4 = r2     // Catch:{ all -> 0x0198 }
            r1.L$5 = r2     // Catch:{ all -> 0x0198 }
            r1.L$6 = r2     // Catch:{ all -> 0x0198 }
            r1.L$7 = r2     // Catch:{ all -> 0x0198 }
            r1.L$8 = r2     // Catch:{ all -> 0x0198 }
            r2 = 4
            r1.label = r2     // Catch:{ all -> 0x0198 }
            java.lang.Object r0 = r13.emit(r0, r1)     // Catch:{ all -> 0x0198 }
            if (r0 != r3) goto L_0x0185
            return r3
        L_0x0185:
            r2 = r5
            r3 = r9
            r4 = r16
            r0 = r17
        L_0x018b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002f }
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0194 }
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            return r5
        L_0x0194:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L_0x01a5
        L_0x0198:
            r0 = move-exception
            r4 = r0
            r2 = r5
            r3 = r9
        L_0x019c:
            throw r4     // Catch:{ all -> 0x019d }
        L_0x019d:
            r0 = move-exception
            r5 = r0
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0194 }
            throw r5     // Catch:{ all -> 0x0194 }
        L_0x01a3:
            r0 = move-exception
            r2 = r0
        L_0x01a5:
            throw r2     // Catch:{ all -> 0x01a6 }
        L_0x01a6:
            r0 = move-exception
            r3 = r0
            kotlin.io.CloseableKt.closeFinally(r9, r2)
            throw r3
        L_0x01ac:
            r3 = r0
            boolean r0 = r5 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r0 == 0) goto L_0x01d0
            com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Failure r0 = new com.microtech.aidexx.common.net.repository.ApiRepository$NetResult$Failure
            com.microtech.aidexx.common.net.ApiResult$Failure r5 = (com.microtech.aidexx.common.net.ApiResult.Failure) r5
            java.lang.String r4 = r5.getCode()
            java.lang.String r5 = r5.getMsg()
            r0.<init>(r4, r5)
            r4 = r1
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 0
            r1.L$0 = r5
            r5 = 6
            r1.label = r5
            java.lang.Object r0 = r2.emit(r0, r4)
            if (r0 != r3) goto L_0x01d0
            return r3
        L_0x01d0:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.repository.ApiRepository$downloadFile$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
