package com.microtech.aidexx.ui.setting.profile.health;

import com.microtech.aidexx.common.net.entity.MenuEntity;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: Comparisons.kt */
public final class OtherDiseaseActivity$initView$1$1$invokeSuspend$lambda$3$$inlined$sortedByDescending$2<T> implements Comparator {
    public final int compare(T t, T t2) {
        String dictionaryId = ((MenuEntity) t2).getDictionaryId();
        int i = 0;
        Comparable valueOf = Integer.valueOf(dictionaryId != null ? dictionaryId.length() : 0);
        String dictionaryId2 = ((MenuEntity) t).getDictionaryId();
        if (dictionaryId2 != null) {
            i = dictionaryId2.length();
        }
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
    }
}
