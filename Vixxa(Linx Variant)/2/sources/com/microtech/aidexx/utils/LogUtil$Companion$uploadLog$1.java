package com.microtech.aidexx.utils;

import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.ui.setting.log.FeedbackUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.utils.LogUtil$Companion$uploadLog$1", f = "LogUtil.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LogUtil.kt */
final class LogUtil$Companion$uploadLog$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $logFile;
    final /* synthetic */ String $logPath;
    final /* synthetic */ boolean $mute;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LogUtil$Companion$uploadLog$1(File file, String str, boolean z, Continuation<? super LogUtil$Companion$uploadLog$1> continuation) {
        super(2, continuation);
        this.$logFile = file;
        this.$logPath = str;
        this.$mute = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LogUtil$Companion$uploadLog$1(this.$logFile, this.$logPath, this.$mute, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LogUtil$Companion$uploadLog$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedbackUtil.INSTANCE.zipAndUpload(ExtendsKt.getContext(), this.$logFile, this.$logPath, this.$mute);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
