package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
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
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager$updateEventSysPreset$2$updateTasks$2", f = "LocalResourceManager.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$updateEventSysPreset$2$updateTasks$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $unzipPath;
    final /* synthetic */ VersionMenu $versionMenu;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$updateEventSysPreset$2$updateTasks$2(String str, VersionMenu versionMenu, Continuation<? super LocalResourceManager$updateEventSysPreset$2$updateTasks$2> continuation) {
        super(2, continuation);
        this.$unzipPath = str;
        this.$versionMenu = versionMenu;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalResourceManager$updateEventSysPreset$2$updateTasks$2(this.$unzipPath, this.$versionMenu, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((LocalResourceManager$updateEventSysPreset$2$updateTasks$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LocalResourceManager localResourceManager = LocalResourceManager.INSTANCE;
            String str = this.$unzipPath;
            this.label = 1;
            obj = localResourceManager.updatePreset(str, "exercise_sys.json", this.$versionMenu.getExercise_sys(), SportSysPresetEntity.class, this);
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
