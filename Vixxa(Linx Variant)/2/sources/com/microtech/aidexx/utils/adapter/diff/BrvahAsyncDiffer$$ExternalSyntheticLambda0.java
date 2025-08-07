package com.microtech.aidexx.utils.adapter.diff;

import androidx.recyclerview.widget.DiffUtil;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BrvahAsyncDiffer$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ BrvahAsyncDiffer f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ DiffUtil.DiffResult f$3;
    public final /* synthetic */ Runnable f$4;

    public /* synthetic */ BrvahAsyncDiffer$$ExternalSyntheticLambda0(BrvahAsyncDiffer brvahAsyncDiffer, int i, List list, DiffUtil.DiffResult diffResult, Runnable runnable) {
        this.f$0 = brvahAsyncDiffer;
        this.f$1 = i;
        this.f$2 = list;
        this.f$3 = diffResult;
        this.f$4 = runnable;
    }

    public final void run() {
        BrvahAsyncDiffer.submitList$lambda$1$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
