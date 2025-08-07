package io.objectbox;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BoxStore$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ BoxStore f$0;
    public final /* synthetic */ Runnable f$1;
    public final /* synthetic */ TxCallback f$2;

    public /* synthetic */ BoxStore$$ExternalSyntheticLambda2(BoxStore boxStore, Runnable runnable, TxCallback txCallback) {
        this.f$0 = boxStore;
        this.f$1 = runnable;
        this.f$2 = txCallback;
    }

    public final void run() {
        this.f$0.m300lambda$runInTxAsync$1$ioobjectboxBoxStore(this.f$1, this.f$2);
    }
}
