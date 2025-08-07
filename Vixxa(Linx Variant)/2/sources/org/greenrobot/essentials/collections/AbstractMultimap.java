package org.greenrobot.essentials.collections;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMultimap<K, V, C extends Collection<V>> implements Map<K, C> {
    protected Map<K, C> map;

    /* access modifiers changed from: protected */
    public abstract C createNewCollection();

    protected AbstractMultimap(Map<K, C> map2) {
        this.map = map2;
    }

    public void putAll(Map<? extends K, ? extends C> map2) {
        this.map.putAll(map2);
    }

    public synchronized int size() {
        return this.map.size();
    }

    public synchronized boolean isEmpty() {
        return this.map.isEmpty();
    }

    public synchronized boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public synchronized boolean containsValue(Object obj) {
        return this.map.containsValue(obj);
    }

    public synchronized C get(Object obj) {
        return (Collection) this.map.get(obj);
    }

    public synchronized C remove(Object obj) {
        return (Collection) this.map.remove(obj);
    }

    public synchronized void clear() {
        this.map.clear();
    }

    public synchronized Set<K> keySet() {
        return this.map.keySet();
    }

    public synchronized Collection<C> values() {
        return this.map.values();
    }

    public synchronized boolean equals(Object obj) {
        return this.map.equals(obj);
    }

    public synchronized int hashCode() {
        return this.map.hashCode();
    }

    public synchronized int putElement(K k, V v) {
        Collection collection;
        collection = (Collection) this.map.get(k);
        if (collection == null) {
            collection = createNewCollection();
            this.map.put(k, collection);
        }
        collection.add(v);
        return collection.size();
    }

    public synchronized C put(K k, C c) {
        return (Collection) this.map.put(k, c);
    }

    public synchronized Set<Map.Entry<K, C>> entrySet() {
        return this.map.entrySet();
    }

    public synchronized boolean putElements(K k, Collection<V> collection) {
        Collection collection2;
        collection2 = (Collection) this.map.get(k);
        if (collection2 == null) {
            collection2 = createNewCollection();
            this.map.put(k, collection2);
        }
        return collection2.addAll(collection);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001e, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean removeElement(K r2, V r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<K, C> r0 = r1.map     // Catch:{ all -> 0x001f }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x001f }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x000e:
            boolean r3 = r0.remove(r3)     // Catch:{ all -> 0x001f }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x001f }
            if (r0 == 0) goto L_0x001d
            java.util.Map<K, C> r0 = r1.map     // Catch:{ all -> 0x001f }
            r0.remove(r2)     // Catch:{ all -> 0x001f }
        L_0x001d:
            monitor-exit(r1)
            return r3
        L_0x001f:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001f }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.essentials.collections.AbstractMultimap.removeElement(java.lang.Object, java.lang.Object):boolean");
    }

    public synchronized int countElements(K k) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            return 0;
        }
        return collection.size();
    }

    public synchronized int countElements() {
        int i;
        i = 0;
        for (C size : this.map.values()) {
            i += size.size();
        }
        return i;
    }

    public synchronized boolean containsElement(K k, V v) {
        Collection collection = (Collection) this.map.get(k);
        if (collection == null) {
            return false;
        }
        return collection.contains(v);
    }

    public synchronized boolean containsElement(V v) {
        for (C contains : this.map.values()) {
            if (contains.contains(v)) {
                return true;
            }
        }
        return false;
    }

    public synchronized C valuesElements() {
        C createNewCollection;
        createNewCollection = createNewCollection();
        for (C addAll : this.map.values()) {
            createNewCollection.addAll(addAll);
        }
        return createNewCollection;
    }
}
