package com.microtech.aidexx.ota;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J!\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/ota/OtaProgressListener;", "", "needNotOta", "", "onFinish", "isSuccess", "", "onProgress", "progress", "", "bitrate", "", "(ILjava/lang/Float;)V", "onStart", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaProgressListener.kt */
public interface OtaProgressListener {
    void needNotOta();

    void onFinish(boolean z);

    void onProgress(int i, Float f);

    void onStart();

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OtaProgressListener.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onProgress$default(OtaProgressListener otaProgressListener, int i, Float f, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    f = null;
                }
                otaProgressListener.onProgress(i, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onProgress");
        }
    }
}
