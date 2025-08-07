package io.objectbox;

import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BoxStore$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ BoxStore f$0;
    public final /* synthetic */ Callable f$1;
    public final /* synthetic */ TxCallback f$2;

    public /* synthetic */ BoxStore$$ExternalSyntheticLambda1(BoxStore boxStore, Callable callable, TxCallback txCallback) {
        this.f$0 = boxStore;
        this.f$1 = callable;
        this.f$2 = txCallback;
    }

    public final void run() {
        this.f$0.m299lambda$callInTxAsync$2$ioobjectboxBoxStore(this.f$1, this.f$2);
    }
}
