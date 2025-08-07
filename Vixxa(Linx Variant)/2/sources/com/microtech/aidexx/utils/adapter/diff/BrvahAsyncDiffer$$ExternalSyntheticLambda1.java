package com.microtech.aidexx.utils.adapter.diff;

import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrvahAsyncDiffer$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ BrvahAsyncDiffer f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ Runnable f$4;

    public /* synthetic */ BrvahAsyncDiffer$$ExternalSyntheticLambda1(BrvahAsyncDiffer brvahAsyncDiffer, List list, List list2, int i, Runnable runnable) {
        this.f$0 = brvahAsyncDiffer;
        this.f$1 = list;
        this.f$2 = list2;
        this.f$3 = i;
        this.f$4 = runnable;
    }

    public final void run() {
        BrvahAsyncDiffer.submitList$lambda$1(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
