package com.microtech.aidexx.common.net.convert;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002Bo\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012'\b\u0002\u0010\b\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\t\u0012'\b\u0002\u0010\u000f\u001a!\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\t¢\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0002\u0010\u0015R\u0016\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R-\u0010\u000f\u001a!\u0012\u0015\u0012\u0013\u0018\u00018\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R-\u0010\b\u001a!\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/common/net/convert/GsonResponseBodyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/ResponseBody;", "gson", "Lcom/google/gson/Gson;", "adapter", "Lcom/google/gson/TypeAdapter;", "checkBizCodeIsSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bodyStr", "", "afterConvert", "result", "", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "convert", "value", "(Lokhttp3/ResponseBody;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GsonResponseBodyConverter.kt */
public final class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final TypeAdapter<? extends T> adapter;
    private final Function1<T, Unit> afterConvert;
    private final Function1<String, Throwable> checkBizCodeIsSuccess;
    private final Gson gson;

    public GsonResponseBodyConverter(Gson gson2, TypeAdapter<? extends T> typeAdapter, Function1<? super String, ? extends Throwable> function1, Function1<? super T, Unit> function12) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(typeAdapter, "adapter");
        this.gson = gson2;
        this.adapter = typeAdapter;
        this.checkBizCodeIsSuccess = function1;
        this.afterConvert = function12;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GsonResponseBodyConverter(Gson gson2, TypeAdapter typeAdapter, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gson2, typeAdapter, (i & 4) != 0 ? null : function1, (i & 8) != 0 ? null : function12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0031, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T convert(okhttp3.ResponseBody r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.String r0 = "value"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = r3
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = r0
            okhttp3.ResponseBody r1 = (okhttp3.ResponseBody) r1     // Catch:{ all -> 0x002f }
            java.lang.String r3 = r3.string()     // Catch:{ all -> 0x002f }
            kotlin.jvm.functions.Function1<java.lang.String, java.lang.Throwable> r1 = r2.checkBizCodeIsSuccess     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x001d
            java.lang.Object r1 = r1.invoke(r3)     // Catch:{ all -> 0x002f }
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x002f }
            if (r1 != 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            throw r1     // Catch:{ all -> 0x002f }
        L_0x001d:
            com.google.gson.TypeAdapter<? extends T> r1 = r2.adapter     // Catch:{ all -> 0x002f }
            java.lang.Object r3 = r1.fromJson((java.lang.String) r3)     // Catch:{ all -> 0x002f }
            kotlin.jvm.functions.Function1<T, kotlin.Unit> r1 = r2.afterConvert     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x002a
            r1.invoke(r3)     // Catch:{ all -> 0x002f }
        L_0x002a:
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r3
        L_0x002f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.convert.GsonResponseBodyConverter.convert(okhttp3.ResponseBody):java.lang.Object");
    }
}
