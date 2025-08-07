package io.objectbox.reactive;

import java.util.Set;

public class DataPublisherUtils {
    public static <T> void removeObserverFromCopyOnWriteSet(Set<DataObserver<T>> set, DataObserver<T> dataObserver) {
        if (set != null) {
            for (DataObserver next : set) {
                if (next.equals(dataObserver)) {
                    set.remove(next);
                } else if (next instanceof DelegatingObserver) {
                    DataObserver dataObserver2 = next;
                    while (dataObserver2 instanceof DelegatingObserver) {
                        dataObserver2 = ((DelegatingObserver) dataObserver2).getObserverDelegate();
                    }
                    if (dataObserver2 == null || dataObserver2.equals(dataObserver)) {
                        set.remove(next);
                    }
                }
            }
        }
    }
}
