package org.greenrobot.essentials.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class MultimapSet<K, V> extends AbstractMultimap<K, V, Set<V>> {
    private final SetType setType;

    public enum SetType {
        REGULAR,
        THREAD_SAFE
    }

    public static <K, V> MultimapSet<K, V> create() {
        return create(SetType.REGULAR);
    }

    public static <K, V> MultimapSet<K, V> create(SetType setType2) {
        return new MultimapSet<>(new HashMap(), setType2);
    }

    protected MultimapSet(Map<K, Set<V>> map, SetType setType2) {
        super(map);
        this.setType = setType2;
    }

    /* renamed from: org.greenrobot.essentials.collections.MultimapSet$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$greenrobot$essentials$collections$MultimapSet$SetType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                org.greenrobot.essentials.collections.MultimapSet$SetType[] r0 = org.greenrobot.essentials.collections.MultimapSet.SetType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$greenrobot$essentials$collections$MultimapSet$SetType = r0
                org.greenrobot.essentials.collections.MultimapSet$SetType r1 = org.greenrobot.essentials.collections.MultimapSet.SetType.REGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$greenrobot$essentials$collections$MultimapSet$SetType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.essentials.collections.MultimapSet$SetType r1 = org.greenrobot.essentials.collections.MultimapSet.SetType.THREAD_SAFE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.essentials.collections.MultimapSet.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public Set<V> createNewCollection() {
        int i = AnonymousClass1.$SwitchMap$org$greenrobot$essentials$collections$MultimapSet$SetType[this.setType.ordinal()];
        if (i == 1) {
            return new HashSet();
        }
        if (i == 2) {
            return new CopyOnWriteArraySet();
        }
        throw new IllegalStateException("Unknown set type: " + this.setType);
    }
}
