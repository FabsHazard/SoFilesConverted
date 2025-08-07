package com.microtech.aidexx.data;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"com/microtech/aidexx/data/CloudCgmHistorySync$initGsonBuilder$1", "Lcom/google/gson/ExclusionStrategy;", "shouldSkipClass", "", "clazz", "Ljava/lang/Class;", "shouldSkipField", "field", "Lcom/google/gson/FieldAttributes;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CloudCgmHistorySync.kt */
public final class CloudCgmHistorySync$initGsonBuilder$1 implements ExclusionStrategy {
    public boolean shouldSkipClass(Class<?> cls) {
        return false;
    }

    CloudCgmHistorySync$initGsonBuilder$1() {
    }

    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        String str = null;
        if (Intrinsics.areEqual((Object) "rawOne", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) "rawTwo", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) "rawVc", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) "rawIsValid", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) "calibrationIsValid", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) "cf", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (Intrinsics.areEqual((Object) "index", (Object) fieldAttributes != null ? fieldAttributes.getName() : null)) {
            return true;
        }
        if (fieldAttributes != null) {
            str = fieldAttributes.getName();
        }
        if (Intrinsics.areEqual((Object) TypedValues.CycleType.S_WAVE_OFFSET, (Object) str)) {
            return true;
        }
        return false;
    }
}
