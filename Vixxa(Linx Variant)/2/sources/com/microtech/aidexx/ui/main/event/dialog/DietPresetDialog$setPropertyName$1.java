package com.microtech.aidexx.ui.main.event.dialog;

import com.microtech.aidexx.db.entity.event.DietDetail;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.dialog.DietPresetDialog", f = "DietPresetDialog.kt", i = {0, 0}, l = {97}, m = "setPropertyName", n = {"this", "dietDetailEntity"}, s = {"L$0", "L$1"})
/* compiled from: DietPresetDialog.kt */
final class DietPresetDialog$setPropertyName$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DietPresetDialog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DietPresetDialog$setPropertyName$1(DietPresetDialog dietPresetDialog, Continuation<? super DietPresetDialog$setPropertyName$1> continuation) {
        super(continuation);
        this.this$0 = dietPresetDialog;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setPropertyName((DietDetail) null, this);
    }
}
