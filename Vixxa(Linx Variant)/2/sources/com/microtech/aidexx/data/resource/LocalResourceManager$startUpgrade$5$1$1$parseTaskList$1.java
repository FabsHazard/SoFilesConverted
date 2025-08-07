package com.microtech.aidexx.data.resource;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1", f = "LocalResourceManager.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ VersionMenu $it;
    final /* synthetic */ String $unzipPath;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1(String str, VersionMenu versionMenu, Continuation<? super LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1> continuation) {
        super(2, continuation);
        this.$unzipPath = str;
        this.$it = versionMenu;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1(this.$unzipPath, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((LocalResourceManager$startUpgrade$5$1$1$parseTaskList$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = LocalResourceManager.INSTANCE.updateEventSysPreset(this.$unzipPath, this.$it, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
