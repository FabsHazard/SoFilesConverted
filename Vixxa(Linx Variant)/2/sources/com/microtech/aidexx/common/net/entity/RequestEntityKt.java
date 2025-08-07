package com.microtech.aidexx.common.net.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\n¢\u0006\u0002\u0010\f\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"BG_RECENT_COUNT", "", "CAL_RECENT_COUNT", "CGM_RECENT_COUNT", "EVENT_RECENT_COUNT", "PAGE_SIZE", "PAGE_SIZE_CGM", "toQueryMap", "", "", "T", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "(Lcom/microtech/aidexx/common/net/entity/ReqEntity;)Ljava/util/Map;", "app_gpGrxMmolRelease"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class RequestEntityKt {
    public static final int BG_RECENT_COUNT = 5000;
    public static final int CAL_RECENT_COUNT = 5000;
    public static final int CGM_RECENT_COUNT = 5000;
    public static final int EVENT_RECENT_COUNT = 5000;
    public static final int PAGE_SIZE = 500;
    public static final int PAGE_SIZE_CGM = 5000;

    public static final <T extends ReqEntity> Map<String, String> toQueryMap(T t) {
        Pair pair;
        String str;
        Intrinsics.checkNotNullParameter(t, "<this>");
        Iterable<KProperty1> memberProperties = KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(t.getClass()));
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(memberProperties, 10)), 16));
        for (KProperty1 kProperty1 : memberProperties) {
            Object obj = kProperty1.get(t);
            if (obj != null) {
                String name = kProperty1.getName();
                if (Reflection.getOrCreateKotlinClass(obj.getClass()).isData()) {
                    str = "";
                } else {
                    str = String.valueOf(obj);
                }
                pair = TuplesKt.to(name, str);
                if (pair != null) {
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                }
            }
            pair = TuplesKt.to("", "");
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        Map<String, String> mutableMap = MapsKt.toMutableMap(linkedHashMap);
        mutableMap.remove("");
        return mutableMap;
    }
}
