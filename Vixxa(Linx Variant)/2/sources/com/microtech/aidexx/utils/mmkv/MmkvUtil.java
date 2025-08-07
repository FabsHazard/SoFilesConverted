package com.microtech.aidexx.utils.mmkv;

import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/utils/mmkv/MmkvUtil;", "", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MmkvUtil.kt */
public final class MmkvUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MMKV INSTANCE = MMKV.defaultMMKV();
    /* access modifiers changed from: private */
    public static final MMKV SETTING;

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0013J7\u0010\u0014\u001a\u0004\u0018\u0001H\u0015\"\b\b\u0000\u0010\u0015*\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00150\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0004¢\u0006\u0002\u0010\u001aJ\u0016\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\nJ\u0016\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0016\u0010 \u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0011J\u0016\u0010!\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0013J \u0010\"\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0004J\u0016\u0010$\u001a\u00020\u001d2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/utils/mmkv/MmkvUtil$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/mmkv/MMKV;", "kotlin.jvm.PlatformType", "SETTING", "getSETTING", "()Lcom/tencent/mmkv/MMKV;", "decodeBoolean", "", "key", "", "defValue", "decodeFloat", "", "decodeInt", "", "decodeLong", "", "decodeParcelable", "T", "Landroid/os/Parcelable;", "clazz", "Ljava/lang/Class;", "target", "(Ljava/lang/String;Ljava/lang/Class;Lcom/tencent/mmkv/MMKV;)Landroid/os/Parcelable;", "decodeString", "encodeBoolean", "", "value", "encodeFloat", "encodeInt", "encodeLong", "encodeParcelable", "parcelable", "encodeString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MmkvUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MMKV getSETTING() {
            return MmkvUtil.SETTING;
        }

        public final void encodeString(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "value");
            MmkvUtil.INSTANCE.encode(str, str2);
        }

        public final String decodeString(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(str2, "defValue");
            String decodeString = MmkvUtil.INSTANCE.decodeString(str, str2);
            Intrinsics.checkNotNull(decodeString);
            return decodeString;
        }

        public final void encodeBoolean(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "key");
            MmkvUtil.INSTANCE.encode(str, z);
        }

        public final boolean decodeBoolean(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "key");
            return MmkvUtil.INSTANCE.decodeBool(str, z);
        }

        public final long decodeLong(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "key");
            return MmkvUtil.INSTANCE.decodeLong(str, j);
        }

        public final void encodeLong(String str, long j) {
            Intrinsics.checkNotNullParameter(str, "key");
            MmkvUtil.INSTANCE.encode(str, j);
        }

        public final int decodeInt(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "key");
            return MmkvUtil.INSTANCE.decodeInt(str, i);
        }

        public final void encodeInt(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "key");
            MmkvUtil.INSTANCE.encode(str, i);
        }

        public final float decodeFloat(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "key");
            return MmkvUtil.INSTANCE.decodeFloat(str, f);
        }

        public final void encodeFloat(String str, float f) {
            Intrinsics.checkNotNullParameter(str, "key");
            MmkvUtil.INSTANCE.encode(str, f);
        }

        public static /* synthetic */ Parcelable decodeParcelable$default(Companion companion, String str, Class cls, MMKV mmkv, int i, Object obj) {
            if ((i & 4) != 0) {
                mmkv = MmkvUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(mmkv, "access$getINSTANCE$cp(...)");
            }
            return companion.decodeParcelable(str, cls, mmkv);
        }

        public final <T extends Parcelable> T decodeParcelable(String str, Class<T> cls, MMKV mmkv) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(mmkv, TypedValues.AttributesType.S_TARGET);
            return mmkv.decodeParcelable(str, cls);
        }

        public static /* synthetic */ void encodeParcelable$default(Companion companion, String str, Parcelable parcelable, MMKV mmkv, int i, Object obj) {
            if ((i & 4) != 0) {
                mmkv = MmkvUtil.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(mmkv, "access$getINSTANCE$cp(...)");
            }
            companion.encodeParcelable(str, parcelable, mmkv);
        }

        public final void encodeParcelable(String str, Parcelable parcelable, MMKV mmkv) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(parcelable, "parcelable");
            Intrinsics.checkNotNullParameter(mmkv, TypedValues.AttributesType.S_TARGET);
            mmkv.encode(str, parcelable);
        }
    }

    static {
        MMKV mmkvWithID = MMKV.mmkvWithID("setting");
        Intrinsics.checkNotNullExpressionValue(mmkvWithID, "mmkvWithID(...)");
        SETTING = mmkvWithID;
    }
}
