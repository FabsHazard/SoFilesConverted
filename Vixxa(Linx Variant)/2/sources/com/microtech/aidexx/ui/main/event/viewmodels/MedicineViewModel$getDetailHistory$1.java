package com.microtech.aidexx.ui.main.event.viewmodels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.viewmodels.MedicineViewModel", f = "MedicineViewModel.kt", i = {}, l = {66}, m = "getDetailHistory", n = {}, s = {})
/* compiled from: MedicineViewModel.kt */
final class MedicineViewModel$getDetailHistory$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MedicineViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MedicineViewModel$getDetailHistory$1(MedicineViewModel medicineViewModel, Continuation<? super MedicineViewModel$getDetailHistory$1> continuation) {
        super(continuation);
        this.this$0 = medicineViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getDetailHistory(this);
    }
}
