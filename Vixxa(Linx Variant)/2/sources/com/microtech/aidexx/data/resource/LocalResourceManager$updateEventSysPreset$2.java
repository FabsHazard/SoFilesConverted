package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.utils.LogUtil;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager$updateEventSysPreset$2", f = "LocalResourceManager.kt", i = {}, l = {256}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$updateEventSysPreset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $unzipPath;
    final /* synthetic */ VersionMenu $versionMenu;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$updateEventSysPreset$2(String str, VersionMenu versionMenu, Continuation<? super LocalResourceManager$updateEventSysPreset$2> continuation) {
        super(2, continuation);
        this.$unzipPath = str;
        this.$versionMenu = versionMenu;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LocalResourceManager$updateEventSysPreset$2 localResourceManager$updateEventSysPreset$2 = new LocalResourceManager$updateEventSysPreset$2(this.$unzipPath, this.$versionMenu, continuation);
        localResourceManager$updateEventSysPreset$2.L$0 = obj;
        return localResourceManager$updateEventSysPreset$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((LocalResourceManager$updateEventSysPreset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = false;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Deferred[] deferredArr = {BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LocalResourceManager$updateEventSysPreset$2$updateTasks$1(this.$unzipPath, this.$versionMenu, (Continuation<? super LocalResourceManager$updateEventSysPreset$2$updateTasks$1>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LocalResourceManager$updateEventSysPreset$2$updateTasks$2(this.$unzipPath, this.$versionMenu, (Continuation<? super LocalResourceManager$updateEventSysPreset$2$updateTasks$2>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LocalResourceManager$updateEventSysPreset$2$updateTasks$3(this.$unzipPath, this.$versionMenu, (Continuation<? super LocalResourceManager$updateEventSysPreset$2$updateTasks$3>) null), 3, (Object) null), BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new LocalResourceManager$updateEventSysPreset$2$updateTasks$4(this.$unzipPath, this.$versionMenu, (Continuation<? super LocalResourceManager$updateEventSysPreset$2$updateTasks$4>) null), 3, (Object) null)};
            this.label = 1;
            obj = AwaitKt.awaitAll(CollectionsKt.listOf(deferredArr), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Iterable iterable = (Iterable) obj;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (!((Boolean) it.next()).booleanValue()) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        z = true;
        LogUtil.Companion companion = LogUtil.Companion;
        String access$getTAG$p = LocalResourceManager.TAG;
        Intrinsics.checkNotNullExpressionValue(access$getTAG$p, "access$getTAG$p(...)");
        companion.d("系统预设升级完成", access$getTAG$p);
        return Boxing.boxBoolean(z);
    }
}
