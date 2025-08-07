package kotlin.reflect.jvm.internal.impl.types.checker;

import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractNullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NullabilityChecker {
    public static final NullabilityChecker INSTANCE = new NullabilityChecker();

    private NullabilityChecker() {
    }

    public final boolean isSubtypeOfAny(UnwrappedType unwrappedType) {
        Intrinsics.checkNotNullParameter(unwrappedType, TransmitterActivityKt.OPERATION_TYPE);
        return AbstractNullabilityChecker.INSTANCE.hasNotNullSupertype(SimpleClassicTypeSystemContext.INSTANCE.newTypeCheckerState(false, true), FlexibleTypesKt.lowerIfFlexible(unwrappedType), TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE);
    }
}
