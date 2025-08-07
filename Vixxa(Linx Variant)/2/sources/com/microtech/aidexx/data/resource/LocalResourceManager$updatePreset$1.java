package com.microtech.aidexx.data.resource;

import com.microtech.aidexx.db.entity.event.preset.BaseSysPreset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.data.resource.LocalResourceManager", f = "LocalResourceManager.kt", i = {0, 0, 2}, l = {292, 294, 313}, m = "updatePreset", n = {"clazz", "it", "clazz"}, s = {"L$0", "L$1", "L$0"})
/* compiled from: LocalResourceManager.kt */
final class LocalResourceManager$updatePreset$1<T extends BaseSysPreset> extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalResourceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocalResourceManager$updatePreset$1(LocalResourceManager localResourceManager, Continuation<? super LocalResourceManager$updatePreset$1> continuation) {
        super(continuation);
        this.this$0 = localResourceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePreset((String) null, (String) null, (String) null, (Class) null, this);
    }
}
