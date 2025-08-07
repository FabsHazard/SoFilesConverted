package com.microtech.aidexx.common.net.convert;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000  2\u00020\u0001:\u0001 Ba\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012'\b\u0002\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0005\u0012'\b\u0002\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005¢\u0006\u0002\u0010\u000fJC\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001bJ5\u0010\u001c\u001a\f\u0012\u0004\u0012\u00020\u001d\u0012\u0002\b\u00030\u00112\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0016¢\u0006\u0002\u0010\u001fR-\u0010\u000b\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R-\u0010\u0004\u001a!\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/microtech/aidexx/common/net/convert/GsonConverterFactory;", "Lretrofit2/Converter$Factory;", "gson", "Lcom/google/gson/Gson;", "checkBizCodeIsSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bodyStr", "", "afterConvert", "", "result", "", "(Lcom/google/gson/Gson;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "requestBodyConverter", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "type", "Ljava/lang/reflect/Type;", "parameterAnnotations", "", "", "methodAnnotations", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "responseBodyConverter", "Lokhttp3/ResponseBody;", "annotations", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/Converter;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GsonConverterFactory.kt */
public final class GsonConverterFactory extends Converter.Factory {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Function1<Object, Unit> afterConvert;
    private final Function1<String, Throwable> checkBizCodeIsSuccess;
    private final Gson gson;

    public /* synthetic */ GsonConverterFactory(Gson gson2, Function1 function1, Function1 function12, DefaultConstructorMarker defaultConstructorMarker) {
        this(gson2, function1, function12);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ GsonConverterFactory(Gson gson2, Function1 function1, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(gson2, (i & 2) != 0 ? null : function1, (i & 4) != 0 ? null : function12);
    }

    private GsonConverterFactory(Gson gson2, Function1<? super String, ? extends Throwable> function1, Function1<Object, Unit> function12) {
        this.gson = gson2;
        this.checkBizCodeIsSuccess = function1;
        this.afterConvert = function12;
    }

    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, TransmitterActivityKt.OPERATION_TYPE);
        Intrinsics.checkNotNullParameter(annotationArr, "annotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        TypeAdapter<?> adapter = this.gson.getAdapter(TypeToken.get(type));
        Gson gson2 = this.gson;
        Intrinsics.checkNotNull(adapter);
        return new GsonResponseBodyConverter<>(gson2, adapter, this.checkBizCodeIsSuccess, this.afterConvert);
    }

    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(type, TransmitterActivityKt.OPERATION_TYPE);
        Intrinsics.checkNotNullParameter(annotationArr, "parameterAnnotations");
        Intrinsics.checkNotNullParameter(annotationArr2, "methodAnnotations");
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        TypeAdapter<?> adapter = this.gson.getAdapter(TypeToken.get(type));
        Gson gson2 = this.gson;
        Intrinsics.checkNotNull(adapter);
        return new GsonRequestBodyConverter<>(gson2, adapter);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jf\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062'\b\u0002\u0010\u0007\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\b2'\b\u0002\u0010\u000e\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\bH\u0007¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/common/net/convert/GsonConverterFactory$Companion;", "", "()V", "create", "Lcom/microtech/aidexx/common/net/convert/GsonConverterFactory;", "gson", "Lcom/google/gson/Gson;", "checkBizCodeIsSuccess", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "bodyStr", "", "afterConvert", "result", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GsonConverterFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GsonConverterFactory create() {
            return create$default(this, (Gson) null, (Function1) null, (Function1) null, 7, (Object) null);
        }

        public final GsonConverterFactory create(Gson gson) {
            return create$default(this, gson, (Function1) null, (Function1) null, 6, (Object) null);
        }

        public final GsonConverterFactory create(Gson gson, Function1<? super String, ? extends Throwable> function1) {
            return create$default(this, gson, function1, (Function1) null, 4, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ GsonConverterFactory create$default(Companion companion, Gson gson, Function1 function1, Function1 function12, int i, Object obj) {
            if ((i & 1) != 0) {
                gson = new Gson();
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            if ((i & 4) != 0) {
                function12 = null;
            }
            return companion.create(gson, function1, function12);
        }

        public final GsonConverterFactory create(Gson gson, Function1<? super String, ? extends Throwable> function1, Function1<Object, Unit> function12) {
            if (gson != null) {
                return new GsonConverterFactory(gson, function1, function12, (DefaultConstructorMarker) null);
            }
            throw new NullPointerException("gson == null");
        }
    }
}
