package com.microtech.aidexx.common.net.interceptors;

import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.common.net.RSAUtil;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/common/net/interceptors/DataEncryptInterceptor;", "Lokhttp3/Interceptor;", "()V", "canEncrypt", "", "mediaType", "Lokhttp3/MediaType;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataEncryptInterceptor.kt */
public final class DataEncryptInterceptor implements Interceptor {
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        LogUtil.Companion.eAiDEX("| " + request);
        RequestBody body = request.body();
        MediaType contentType = body != null ? body.contentType() : null;
        String method = request.method();
        if (!Intrinsics.areEqual((Object) method, (Object) "GET")) {
            Boolean bool = BuildConfig.enableEncrypt;
            Intrinsics.checkNotNullExpressionValue(bool, "enableEncrypt");
            if (bool.booleanValue()) {
                if (canEncrypt(contentType)) {
                    Buffer buffer = new Buffer();
                    if (body != null) {
                        body.writeTo(buffer);
                    }
                    String readUtf8 = buffer.readUtf8();
                    if (readUtf8.length() > 0) {
                        LogUtil.Companion.eAiDEX("| Request Params:" + readUtf8);
                        String encryptByPublicKey = RSAUtil.encryptByPublicKey(readUtf8, RSAUtil.getPublicKey(RSAUtil.PUBLIC_KEY));
                        Intrinsics.checkNotNullExpressionValue(encryptByPublicKey, "encryptByPublicKey(...)");
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("encryptData", encryptByPublicKey);
                        RequestBody.Companion companion = RequestBody.Companion;
                        String jSONObject2 = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                        RequestBody create = companion.create(jSONObject2, contentType);
                        buffer.close();
                        Request.Builder header = request.newBuilder().header("Content-Type", String.valueOf(create.contentType()));
                        String valueOf = String.valueOf(create.contentLength());
                        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                        request = header.header("Content-Length", valueOf).method(method, create).build();
                    }
                } else {
                    request = request.newBuilder().header("encryption", "disable").build();
                }
            }
        }
        Response proceed = chain.proceed(request);
        ResponseBody body2 = proceed.body();
        if (body2 == null) {
            return proceed;
        }
        String header$default = Response.header$default(proceed, "encryption", (String) null, 2, (Object) null);
        if (header$default == null || !Intrinsics.areEqual((Object) header$default, (Object) "enabled")) {
            LogUtil.Companion.eAiDEX("| Response:" + proceed.request().url().encodedPath() + ", " + proceed.peekBody(Long.MAX_VALUE).string());
            return proceed;
        }
        try {
            String decryptByPrivateKey = RSAUtil.decryptByPrivateKey(new JSONObject(body2.string()).getString("encryptData"), RSAUtil.getPrivateKey(RSAUtil.PRIVATE_KEY));
            Intrinsics.checkNotNullExpressionValue(decryptByPrivateKey, "decryptByPrivateKey(...)");
            body2.close();
            proceed = proceed.newBuilder().body(ResponseBody.Companion.create(decryptByPrivateKey, contentType)).build();
            LogUtil.Companion.eAiDEX("| Response:" + proceed.request().url().encodedPath() + ", " + decryptByPrivateKey);
            return proceed;
        } catch (Exception e) {
            LogUtil.Companion.eAiDEX(ExceptionsKt.stackTraceToString(e));
            return proceed;
        }
    }

    private final boolean canEncrypt(MediaType mediaType) {
        String type = mediaType != null ? mediaType.type() : null;
        String subtype = mediaType != null ? mediaType.subtype() : null;
        if (StringsKt.equals(type, "multipart", true) || StringsKt.equals(type, "image", true) || StringsKt.equals$default(subtype, "pdf", false, 2, (Object) null) || StringsKt.equals$default(subtype, "form-data", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }
}
