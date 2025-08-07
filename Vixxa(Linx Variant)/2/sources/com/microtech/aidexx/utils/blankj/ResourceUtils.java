package com.microtech.aidexx.utils.blankj;

import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.common.ExtendsKt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bJ\u0010\u0010\u0015\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/utils/blankj/ResourceUtils;", "", "()V", "BUFFER_SIZE", "", "copyFileFromAssets", "", "assetsFilePath", "", "destFilePath", "getColorIdByName", "name", "getDimenIdByName", "getDrawable", "Landroid/graphics/drawable/Drawable;", "id", "getDrawableIdByName", "getIdByName", "getLayoutIdByName", "getMipmapIdByName", "getStringIdByName", "getStyleIdByName", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ResourceUtils.kt */
public final class ResourceUtils {
    private static final int BUFFER_SIZE = 8192;
    public static final ResourceUtils INSTANCE = new ResourceUtils();

    private ResourceUtils() {
    }

    public final Drawable getDrawable(int i) {
        return ContextCompat.getDrawable(ExtendsKt.getContext(), i);
    }

    public final int getIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, "id", ExtendsKt.getContext().getPackageName());
    }

    public final int getStringIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, TypedValues.Custom.S_STRING, ExtendsKt.getContext().getPackageName());
    }

    public final int getColorIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, TypedValues.Custom.S_COLOR, ExtendsKt.getContext().getPackageName());
    }

    public final int getDimenIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, "dimen", ExtendsKt.getContext().getPackageName());
    }

    public final int getDrawableIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, "drawable", ExtendsKt.getContext().getPackageName());
    }

    public final int getMipmapIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, "mipmap", ExtendsKt.getContext().getPackageName());
    }

    public final int getLayoutIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, "layout", ExtendsKt.getContext().getPackageName());
    }

    public final int getStyleIdByName(String str) {
        return ExtendsKt.getContext().getResources().getIdentifier(str, "style", ExtendsKt.getContext().getPackageName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0051, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0058, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean copyFileFromAssets(java.lang.String r8, java.lang.String r9) {
        /*
            r7 = this;
            java.lang.String r0 = "assetsFilePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "destFilePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            r1 = 0
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0059 }
            com.microtech.aidexx.AidexxApp r2 = com.microtech.aidexx.common.ExtendsKt.getContext()     // Catch:{ all -> 0x0059 }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ all -> 0x0059 }
            java.io.InputStream r8 = r2.open(r8)     // Catch:{ all -> 0x0059 }
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ all -> 0x0059 }
            r2 = r8
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0052 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0052 }
            r3.<init>(r9)     // Catch:{ all -> 0x0052 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0052 }
            r9 = r3
            java.io.FileOutputStream r9 = (java.io.FileOutputStream) r9     // Catch:{ all -> 0x004b }
            r4 = 8192(0x2000, float:1.14794E-41)
            byte[] r4 = new byte[r4]     // Catch:{ all -> 0x004b }
        L_0x002d:
            int r5 = r2.read(r4)     // Catch:{ all -> 0x004b }
            r6 = -1
            if (r5 == r6) goto L_0x0038
            r9.write(r4, r0, r5)     // Catch:{ all -> 0x004b }
            goto L_0x002d
        L_0x0038:
            r9.flush()     // Catch:{ all -> 0x004b }
            kotlin.io.CloseableKt.closeFinally(r3, r1)     // Catch:{ all -> 0x0052 }
            kotlin.io.CloseableKt.closeFinally(r8, r1)     // Catch:{ all -> 0x0059 }
            r8 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)     // Catch:{ all -> 0x0059 }
            java.lang.Object r8 = kotlin.Result.m343constructorimpl(r8)     // Catch:{ all -> 0x0059 }
            goto L_0x0064
        L_0x004b:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x004d }
        L_0x004d:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r9)     // Catch:{ all -> 0x0052 }
            throw r2     // Catch:{ all -> 0x0052 }
        L_0x0052:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0054 }
        L_0x0054:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)     // Catch:{ all -> 0x0059 }
            throw r2     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r8 = move-exception
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r8 = kotlin.ResultKt.createFailure(r8)
            java.lang.Object r8 = kotlin.Result.m343constructorimpl(r8)
        L_0x0064:
            java.lang.Throwable r9 = kotlin.Result.m346exceptionOrNullimpl(r8)
            if (r9 != 0) goto L_0x006b
            goto L_0x0094
        L_0x006b:
            com.microtech.aidexx.utils.LogUtil$Companion r8 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r9.getMessage()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = " \n "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r9 = kotlin.ExceptionsKt.stackTraceToString(r9)
            java.lang.StringBuilder r9 = r2.append(r9)
            java.lang.String r9 = r9.toString()
            r2 = 2
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r8, r9, r1, r2, r1)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r0)
        L_0x0094:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.blankj.ResourceUtils.copyFileFromAssets(java.lang.String, java.lang.String):boolean");
    }
}
