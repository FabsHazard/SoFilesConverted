package com.microtech.aidexx.ui.pair;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.pair.PairedDeviceManager", f = "PairedDeviceManager.kt", i = {}, l = {22}, m = "downloadHistoryDevice", n = {}, s = {})
/* compiled from: PairedDeviceManager.kt */
final class PairedDeviceManager$downloadHistoryDevice$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PairedDeviceManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PairedDeviceManager$downloadHistoryDevice$1(PairedDeviceManager pairedDeviceManager, Continuation<? super PairedDeviceManager$downloadHistoryDevice$1> continuation) {
        super(continuation);
        this.this$0 = pairedDeviceManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadHistoryDevice((String) null, this);
    }
}
