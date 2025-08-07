package org.greenrobot.essentials.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class Multimap<K, V> extends AbstractMultimap<K, V, List<V>> {
    private final ListType listType;

    public enum ListType {
        REGULAR,
        THREAD_SAFE,
        LINKED
    }

    public static <K, V> Multimap<K, V> create() {
        return create(ListType.REGULAR);
    }

    public static <K, V> Multimap<K, V> create(ListType listType2) {
        return new Multimap<>(new HashMap(), listType2);
    }

    protected Multimap(Map<K, List<V>> map, ListType listType2) {
        super(map);
        this.listType = listType2;
        if (listType2 == null) {
            throw new IllegalArgumentException("List type may not be null");
        }
    }

    /* renamed from: org.greenrobot.essentials.collections.Multimap$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$greenrobot$essentials$collections$Multimap$ListType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                org.greenrobot.essentials.collections.Multimap$ListType[] r0 = org.greenrobot.essentials.collections.Multimap.ListType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$greenrobot$essentials$collections$Multimap$ListType = r0
                org.greenrobot.essentials.collections.Multimap$ListType r1 = org.greenrobot.essentials.collections.Multimap.ListType.REGULAR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$org$greenrobot$essentials$collections$Multimap$ListType     // Catch:{ NoSuchFieldError -> 0x001d }
                org.greenrobot.essentials.collections.Multimap$ListType r1 = org.greenrobot.essentials.collections.Multimap.ListType.THREAD_SAFE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$org$greenrobot$essentials$collections$Multimap$ListType     // Catch:{ NoSuchFieldError -> 0x0028 }
                org.greenrobot.essentials.collections.Multimap$ListType r1 = org.greenrobot.essentials.collections.Multimap.ListType.LINKED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.essentials.collections.Multimap.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public List<V> createNewCollection() {
        int i = AnonymousClass1.$SwitchMap$org$greenrobot$essentials$collections$Multimap$ListType[this.listType.ordinal()];
        if (i == 1) {
            return new ArrayList();
        }
        if (i == 2) {
            return new CopyOnWriteArrayList();
        }
        if (i == 3) {
            return new LinkedList();
        }
        throw new IllegalStateException("Unknown list type: " + this.listType);
    }
}
