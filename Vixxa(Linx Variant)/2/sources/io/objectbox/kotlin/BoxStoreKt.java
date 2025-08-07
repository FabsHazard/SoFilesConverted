package io.objectbox.kotlin;

import androidx.exifinterface.media.ExifInterface;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000$\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00010\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\u0006\b\u0000\u0010\t\u0018\u0001*\u00020\u0003H\b\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\t0\b\"\b\b\u0000\u0010\t*\u00020\u0002*\u00020\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\t0\u000bH\b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"awaitCallInTx", "V", "", "Lio/objectbox/BoxStore;", "callable", "Ljava/util/concurrent/Callable;", "(Lio/objectbox/BoxStore;Ljava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "boxFor", "Lio/objectbox/Box;", "T", "clazz", "Lkotlin/reflect/KClass;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: BoxStore.kt */
public final class BoxStoreKt {
    public static final /* synthetic */ <T> Box<T> boxFor(BoxStore boxStore) {
        Intrinsics.checkNotNullParameter(boxStore, "<this>");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        Box<T> boxFor = boxStore.boxFor(cls);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(T::class.java)");
        Box box = boxFor;
        return boxFor;
    }

    public static final <T> Box<T> boxFor(BoxStore boxStore, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(boxStore, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Box<T> boxFor = boxStore.boxFor(JvmClassMappingKt.getJavaClass(kClass));
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(clazz.java)");
        return boxFor;
    }

    public static final <V> Object awaitCallInTx(BoxStore boxStore, Callable<V> callable, Continuation<? super V> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        boxStore.callInTxAsync(callable, new BoxStoreKt$awaitCallInTx$2$1(safeContinuation));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
