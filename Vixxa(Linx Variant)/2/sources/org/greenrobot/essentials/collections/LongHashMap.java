package org.greenrobot.essentials.collections;

import java.util.Arrays;

public class LongHashMap<T> {
    protected static final int DEFAULT_CAPACITY = 16;
    private int capacity;
    private volatile int size;
    private Entry<T>[] table;
    private int threshold;

    public static final class Entry<T> {
        public final long key;
        Entry<T> next;
        public T value;

        Entry(long j, T t, Entry<T> entry) {
            this.key = j;
            this.value = t;
            this.next = entry;
        }
    }

    public static <T> LongHashMap<T> createSynchronized() {
        return new Synchronized(16);
    }

    public static <T> LongHashMap<T> createSynchronized(int i) {
        return new Synchronized(i);
    }

    public LongHashMap() {
        this(16);
    }

    public LongHashMap(int i) {
        this.capacity = i;
        this.threshold = (i * 4) / 3;
        this.table = new Entry[i];
    }

    public boolean containsKey(long j) {
        for (Entry<T> entry = this.table[((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return true;
            }
        }
        return false;
    }

    public T get(long j) {
        for (Entry<T> entry = this.table[((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity]; entry != null; entry = entry.next) {
            if (entry.key == j) {
                return entry.value;
            }
        }
        return null;
    }

    public T put(long j, T t) {
        int i = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i];
        for (Entry<T> entry2 = entry; entry2 != null; entry2 = entry2.next) {
            if (entry2.key == j) {
                T t2 = entry2.value;
                entry2.value = t;
                return t2;
            }
        }
        this.table[i] = new Entry<>(j, t, entry);
        this.size++;
        if (this.size <= this.threshold) {
            return null;
        }
        setCapacity(this.capacity * 2);
        return null;
    }

    public T remove(long j) {
        int i = ((((int) (j >>> 32)) ^ ((int) j)) & Integer.MAX_VALUE) % this.capacity;
        Entry<T> entry = this.table[i];
        Entry<T> entry2 = null;
        while (entry != null) {
            Entry<T> entry3 = entry.next;
            if (entry.key == j) {
                if (entry2 == null) {
                    this.table[i] = entry3;
                } else {
                    entry2.next = entry3;
                }
                this.size--;
                return entry.value;
            }
            entry2 = entry;
            entry = entry3;
        }
        return null;
    }

    public long[] keys() {
        long[] jArr = new long[this.size];
        int i = 0;
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                jArr[i] = entry.key;
                entry = entry.next;
                i++;
            }
        }
        return jArr;
    }

    public Entry<T>[] entries() {
        Entry<T>[] entryArr = new Entry[this.size];
        int i = 0;
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                entryArr[i] = entry;
                entry = entry.next;
                i++;
            }
        }
        return entryArr;
    }

    public void clear() {
        this.size = 0;
        Arrays.fill(this.table, (Object) null);
    }

    public int size() {
        return this.size;
    }

    public void setCapacity(int i) {
        Entry<T>[] entryArr = new Entry[i];
        for (Entry<T> entry : this.table) {
            while (entry != null) {
                long j = entry.key;
                int i2 = ((((int) j) ^ ((int) (j >>> 32))) & Integer.MAX_VALUE) % i;
                Entry<T> entry2 = entry.next;
                entry.next = entryArr[i2];
                entryArr[i2] = entry;
                entry = entry2;
            }
        }
        this.table = entryArr;
        this.capacity = i;
        this.threshold = (i * 4) / 3;
    }

    public void reserveRoom(int i) {
        setCapacity((i * 5) / 3);
    }

    protected static class Synchronized<T> extends LongHashMap<T> {
        public Synchronized(int i) {
            super(i);
        }

        public synchronized boolean containsKey(long j) {
            return LongHashMap.super.containsKey(j);
        }

        public synchronized T get(long j) {
            return LongHashMap.super.get(j);
        }

        public synchronized T put(long j, T t) {
            return LongHashMap.super.put(j, t);
        }

        public synchronized T remove(long j) {
            return LongHashMap.super.remove(j);
        }

        public synchronized long[] keys() {
            return LongHashMap.super.keys();
        }

        public synchronized Entry<T>[] entries() {
            return LongHashMap.super.entries();
        }

        public synchronized void clear() {
            LongHashMap.super.clear();
        }

        public synchronized void setCapacity(int i) {
            LongHashMap.super.setCapacity(i);
        }

        public synchronized void reserveRoom(int i) {
            LongHashMap.super.reserveRoom(i);
        }
    }
}
