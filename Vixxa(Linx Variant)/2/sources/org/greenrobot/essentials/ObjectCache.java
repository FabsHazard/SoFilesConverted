package org.greenrobot.essentials;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ObjectCache<KEY, VALUE> {
    private volatile int countEvicted;
    private volatile int countExpired;
    private volatile int countHit;
    private volatile int countMiss;
    private volatile int countPut;
    private volatile int countPutCountSinceEviction;
    private volatile int countRefCleared;
    private final long expirationMillis;
    private final boolean isExpiring;
    private final boolean isStrongReference;
    private final int maxSize;
    private volatile long nextCleanUpTimestamp;
    private final ReferenceType referenceType;
    private final Map<KEY, CacheEntry<VALUE>> values;

    public enum ReferenceType {
        SOFT,
        WEAK,
        STRONG
    }

    static class CacheEntry<V> {
        final Reference<V> reference;
        final V referenceStrong;
        final long timeCreated = System.currentTimeMillis();

        CacheEntry(Reference<V> reference2, V v) {
            this.reference = reference2;
            this.referenceStrong = v;
        }
    }

    public ObjectCache(ReferenceType referenceType2, int i, long j) {
        this.referenceType = referenceType2;
        boolean z = true;
        this.isStrongReference = referenceType2 == ReferenceType.STRONG;
        this.maxSize = i;
        this.expirationMillis = j;
        this.isExpiring = j <= 0 ? false : z;
        this.values = new LinkedHashMap();
    }

    public VALUE put(KEY key, VALUE value) {
        CacheEntry cacheEntry;
        CacheEntry put;
        if (this.referenceType == ReferenceType.WEAK) {
            cacheEntry = new CacheEntry(new WeakReference(value), null);
        } else if (this.referenceType == ReferenceType.SOFT) {
            cacheEntry = new CacheEntry(new SoftReference(value), null);
        } else {
            cacheEntry = new CacheEntry((Reference) null, value);
        }
        this.countPutCountSinceEviction++;
        this.countPut++;
        if (this.isExpiring && this.nextCleanUpTimestamp == 0) {
            this.nextCleanUpTimestamp = System.currentTimeMillis() + this.expirationMillis + 1;
        }
        synchronized (this) {
            int size = this.values.size();
            int i = this.maxSize;
            if (size >= i) {
                evictToTargetSize(i - 1);
            }
            put = this.values.put(key, cacheEntry);
        }
        return getValueForRemoved(put);
    }

    private VALUE getValueForRemoved(CacheEntry<VALUE> cacheEntry) {
        if (cacheEntry != null) {
            return this.isStrongReference ? cacheEntry.referenceStrong : cacheEntry.reference.get();
        }
        return null;
    }

    private VALUE getValue(KEY key, CacheEntry<VALUE> cacheEntry) {
        if (cacheEntry == null) {
            return null;
        }
        if (this.isStrongReference) {
            return cacheEntry.referenceStrong;
        }
        VALUE value = cacheEntry.reference.get();
        if (value == null) {
            this.countRefCleared++;
            if (key != null) {
                synchronized (this) {
                    this.values.remove(key);
                }
            }
        }
        return value;
    }

    public void putAll(Map<KEY, VALUE> map) {
        int size = this.maxSize - map.size();
        if (this.maxSize > 0 && this.values.size() > size) {
            evictToTargetSize(size);
        }
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public VALUE get(KEY key) {
        CacheEntry cacheEntry;
        synchronized (this) {
            cacheEntry = this.values.get(key);
        }
        VALUE value = null;
        if (cacheEntry != null) {
            if (!this.isExpiring) {
                value = getValue(key, cacheEntry);
            } else if (System.currentTimeMillis() - cacheEntry.timeCreated < this.expirationMillis) {
                value = getValue(key, cacheEntry);
            } else {
                this.countExpired++;
                synchronized (this) {
                    this.values.remove(key);
                }
            }
        }
        if (value != null) {
            this.countHit++;
        } else {
            this.countMiss++;
        }
        return value;
    }

    public synchronized void clear() {
        this.values.clear();
    }

    public VALUE remove(KEY key) {
        return getValueForRemoved(this.values.remove(key));
    }

    public synchronized void evictToTargetSize(int i) {
        if (i <= 0) {
            this.values.clear();
        } else {
            checkCleanUpObsoleteEntries();
            Iterator<KEY> it = this.values.keySet().iterator();
            while (it.hasNext() && this.values.size() > i) {
                this.countEvicted++;
                it.next();
                it.remove();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void checkCleanUpObsoleteEntries() {
        if (this.isStrongReference && !this.isExpiring) {
            return;
        }
        if ((this.isExpiring && this.nextCleanUpTimestamp != 0 && System.currentTimeMillis() > this.nextCleanUpTimestamp) || this.countPutCountSinceEviction > this.maxSize / 2) {
            cleanUpObsoleteEntries();
        }
    }

    public synchronized int cleanUpObsoleteEntries() {
        int i;
        i = 0;
        this.countPutCountSinceEviction = 0;
        long j = 0;
        this.nextCleanUpTimestamp = 0;
        if (this.isExpiring) {
            j = System.currentTimeMillis() - this.expirationMillis;
        }
        Iterator<CacheEntry<VALUE>> it = this.values.values().iterator();
        while (it.hasNext()) {
            CacheEntry next = it.next();
            if (!this.isStrongReference && next.reference == null) {
                this.countRefCleared++;
                i++;
                it.remove();
            } else if (next.timeCreated < j) {
                this.countExpired++;
                i++;
                it.remove();
            }
        }
        return i;
    }

    public synchronized boolean containsKey(KEY key) {
        return this.values.containsKey(key);
    }

    public boolean containsKeyWithValue(KEY key) {
        return get(key) != null;
    }

    public synchronized Set<KEY> keySet() {
        return this.values.keySet();
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public synchronized int size() {
        return this.values.size();
    }

    public int getCountPut() {
        return this.countPut;
    }

    public int getCountHit() {
        return this.countHit;
    }

    public int getCountMiss() {
        return this.countMiss;
    }

    public int getCountExpired() {
        return this.countExpired;
    }

    public int getCountRefCleared() {
        return this.countRefCleared;
    }

    public int getCountEvicted() {
        return this.countEvicted;
    }

    public String toString() {
        return "ObjectCache[maxSize=" + this.maxSize + ", hits=" + this.countHit + ", misses=" + this.countMiss + "]";
    }

    public String getStatsStringRemoved() {
        return "ObjectCache-Removed[expired=" + this.countExpired + ", refCleared=" + this.countRefCleared + ", evicted=" + this.countEvicted;
    }
}
