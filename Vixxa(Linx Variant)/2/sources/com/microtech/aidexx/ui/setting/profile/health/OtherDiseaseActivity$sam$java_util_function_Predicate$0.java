package com.microtech.aidexx.ui.setting.profile.health;

import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtherDiseaseActivity.kt */
final class OtherDiseaseActivity$sam$java_util_function_Predicate$0 implements Predicate {
    private final /* synthetic */ Function1 function;

    OtherDiseaseActivity$sam$java_util_function_Predicate$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.function = function1;
    }

    public final /* synthetic */ boolean test(Object obj) {
        return ((Boolean) this.function.invoke(obj)).booleanValue();
    }
}
