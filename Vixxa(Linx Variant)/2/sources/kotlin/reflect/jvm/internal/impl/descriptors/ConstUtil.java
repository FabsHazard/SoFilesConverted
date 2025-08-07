package kotlin.reflect.jvm.internal.impl.descriptors;

import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: ConstUtil.kt */
public final class ConstUtil {
    public static final ConstUtil INSTANCE = new ConstUtil();

    private ConstUtil() {
    }

    @JvmStatic
    public static final boolean canBeUsedForConstVal(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, TransmitterActivityKt.OPERATION_TYPE);
        return ConstUtilKt.canBeUsedForConstVal(kotlinType);
    }
}
