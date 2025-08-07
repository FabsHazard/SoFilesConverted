package com.microtech.aidexx.common.net;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.DecimalFormat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J+\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/microtech/aidexx/common/net/ApiService$Companion$createGson$1", "Lcom/google/gson/JsonSerializer;", "", "serialize", "Lcom/google/gson/JsonElement;", "value", "typeOfSrc", "Ljava/lang/reflect/Type;", "context", "Lcom/google/gson/JsonSerializationContext;", "(Ljava/lang/Float;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ApiService.kt */
public final class ApiService$Companion$createGson$1 implements JsonSerializer<Float> {
    ApiService$Companion$createGson$1() {
    }

    public JsonElement serialize(Float f, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonPrimitive jsonPrimitive;
        if (f == null) {
            return new JsonPrimitive((Number) 0);
        }
        if (Float.isNaN(f.floatValue())) {
            jsonPrimitive = new JsonPrimitive((Number) 0);
        } else if (Float.isInfinite(f.floatValue()) || ((double) f.floatValue()) < 0.01d) {
            jsonPrimitive = new JsonPrimitive((Number) 0);
        } else {
            jsonPrimitive = new JsonPrimitive(new DecimalFormat(".00").format(f));
        }
        return jsonPrimitive;
    }
}
