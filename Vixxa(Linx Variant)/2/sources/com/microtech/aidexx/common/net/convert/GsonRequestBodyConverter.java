package com.microtech.aidexx.common.net.convert;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import retrofit2.Converter;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \f*\u0004\b\u0000\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\fB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/common/net/convert/GsonRequestBodyConverter;", "T", "Lretrofit2/Converter;", "Lokhttp3/RequestBody;", "gson", "Lcom/google/gson/Gson;", "adapter", "Lcom/google/gson/TypeAdapter;", "(Lcom/google/gson/Gson;Lcom/google/gson/TypeAdapter;)V", "convert", "value", "(Ljava/lang/Object;)Lokhttp3/RequestBody;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GsonRequestBodyConverter.kt */
public final class GsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final MediaType MEDIA_TYPE = MediaType.Companion.get("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final TypeAdapter<? super T> adapter;
    private final Gson gson;

    public GsonRequestBodyConverter(Gson gson2, TypeAdapter<? super T> typeAdapter) {
        Intrinsics.checkNotNullParameter(gson2, "gson");
        Intrinsics.checkNotNullParameter(typeAdapter, "adapter");
        this.gson = gson2;
        this.adapter = typeAdapter;
    }

    public RequestBody convert(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter newJsonWriter = this.gson.newJsonWriter(new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.write(newJsonWriter, t);
        newJsonWriter.close();
        return RequestBody.Companion.create(buffer.readByteString(), MEDIA_TYPE);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/common/net/convert/GsonRequestBodyConverter$Companion;", "", "()V", "MEDIA_TYPE", "Lokhttp3/MediaType;", "UTF_8", "Ljava/nio/charset/Charset;", "kotlin.jvm.PlatformType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GsonRequestBodyConverter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
