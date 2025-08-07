package com.microtech.aidexx.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/utils/EncryptUtils;", "", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EncryptUtils.kt */
public final class EncryptUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/utils/EncryptUtils$Companion;", "", "()V", "encodeBase64", "", "byte", "", "md5", "input", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EncryptUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String md5(String str) {
            char[] encodeHex = Hex.encodeHex(DigestUtils.md5(str));
            Intrinsics.checkNotNullExpressionValue(encodeHex, "encodeHex(...)");
            return new String(encodeHex);
        }

        public final String encodeBase64(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            byte[] encodeBase64 = Base64.encodeBase64(bArr);
            Intrinsics.checkNotNullExpressionValue(encodeBase64, "encodeBase64(...)");
            return new String(encodeBase64, Charsets.UTF_8);
        }
    }
}
