package io.objectbox.kotlin;

import io.objectbox.TxCallback;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "", "V", "", "result", "error", "", "txFinished", "(Ljava/lang/Object;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* compiled from: BoxStore.kt */
final class BoxStoreKt$awaitCallInTx$2$1<T> implements TxCallback {
    final /* synthetic */ Continuation<V> $continuation;

    BoxStoreKt$awaitCallInTx$2$1(Continuation<? super V> continuation) {
        this.$continuation = continuation;
    }

    public final void txFinished(V v, Throwable th) {
        if (th != null) {
            Continuation<V> continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m343constructorimpl(ResultKt.createFailure(th)));
            return;
        }
        Continuation<V> continuation2 = this.$continuation;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m343constructorimpl(v));
    }
}
