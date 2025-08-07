package com.github.mikephil.charting.data;

import android.util.Log;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class DataSet<T extends Entry> extends BaseDataSet<T> {
    protected List<T> mEntries;
    protected float mXMax = -3.4028235E38f;
    protected float mXMin = Float.MAX_VALUE;
    protected float mYMax = -3.4028235E38f;
    protected float mYMin = Float.MAX_VALUE;

    public enum Rounding {
        UP,
        DOWN,
        CLOSEST
    }

    public abstract DataSet<T> copy();

    public DataSet(List<T> list, String str) {
        super(str);
        this.mEntries = list;
        if (list == null) {
            this.mEntries = new CopyOnWriteArrayList();
        }
        calcMinMax();
    }

    public void calcMinMax() {
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        List<T> list = this.mEntries;
        if (list != null && !list.isEmpty()) {
            for (T calcMinMax : this.mEntries) {
                calcMinMax(calcMinMax);
            }
        }
    }

    public void calcMinMaxY(float f, float f2) {
        int entryIndex;
        int entryIndex2;
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        List<T> list = this.mEntries;
        if (list != null && !list.isEmpty() && (entryIndex2 = getEntryIndex(f2, Float.NaN, Rounding.UP)) >= (entryIndex = getEntryIndex(f, Float.NaN, Rounding.DOWN))) {
            int i = entryIndex;
            while (entryIndex <= entryIndex2) {
                Entry entryForIndex = getEntryForIndex(entryIndex);
                if (entryForIndex == null || entryForIndex.getX() >= f) {
                    break;
                }
                i++;
                entryIndex++;
            }
            int i2 = entryIndex2;
            while (entryIndex2 >= i) {
                Entry entryForIndex2 = getEntryForIndex(entryIndex2);
                if (entryForIndex2 == null || entryForIndex2.getX() <= f2) {
                    break;
                }
                i2--;
                entryIndex2--;
            }
            if (i2 >= i) {
                Entry entryForIndex3 = getEntryForIndex(i2);
                if (i2 == 0 && entryForIndex3.getX() > f2) {
                    return;
                }
                if (entryForIndex3 == null || entryForIndex3.getX() >= f) {
                    while (i <= i2) {
                        calcMinMaxY((Entry) this.mEntries.get(i));
                        i++;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMax(T t) {
        if (t != null) {
            calcMinMaxX(t);
            calcMinMaxY(t);
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMaxX(T t) {
        if (t.getX() < this.mXMin) {
            this.mXMin = t.getX();
        }
        if (t.getX() > this.mXMax) {
            this.mXMax = t.getX();
        }
    }

    /* access modifiers changed from: protected */
    public void calcMinMaxY(T t) {
        if (t.getY() < this.mYMin) {
            this.mYMin = t.getY();
        }
        if (t.getY() > this.mYMax) {
            this.mYMax = t.getY();
        }
    }

    public int getEntryCount() {
        return this.mEntries.size();
    }

    @Deprecated
    public List<T> getValues() {
        return this.mEntries;
    }

    public List<T> getEntries() {
        return this.mEntries;
    }

    @Deprecated
    public void setValues(List<T> list) {
        setEntries(list);
    }

    public void setEntries(List<T> list) {
        this.mEntries = list;
        notifyDataSetChanged();
    }

    /* access modifiers changed from: protected */
    public void copy(DataSet dataSet) {
        super.copy(dataSet);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(toSimpleString());
        for (int i = 0; i < this.mEntries.size(); i++) {
            stringBuffer.append(((Entry) this.mEntries.get(i)).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public String toSimpleString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DataSet, label: " + (getLabel() == null ? "" : getLabel()) + ", entries: " + this.mEntries.size() + "\n");
        return stringBuffer.toString();
    }

    public float getYMin() {
        return this.mYMin;
    }

    public float getYMax() {
        return this.mYMax;
    }

    public float getXMin() {
        return this.mXMin;
    }

    public float getXMax() {
        return this.mXMax;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0055, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addEntryOrdered(T r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.util.List<T> r0 = r3.mEntries     // Catch:{ all -> 0x0056 }
            if (r0 != 0) goto L_0x0010
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ all -> 0x0056 }
            r0.<init>()     // Catch:{ all -> 0x0056 }
            r3.mEntries = r0     // Catch:{ all -> 0x0056 }
        L_0x0010:
            r3.calcMinMax(r4)     // Catch:{ all -> 0x0056 }
            java.util.List<T> r0 = r3.mEntries     // Catch:{ all -> 0x0056 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0056 }
            if (r0 != 0) goto L_0x004f
            java.util.List<T> r0 = r3.mEntries     // Catch:{ all -> 0x0056 }
            int r1 = r0.size()     // Catch:{ all -> 0x0056 }
            int r1 = r1 + -1
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0056 }
            com.github.mikephil.charting.data.Entry r0 = (com.github.mikephil.charting.data.Entry) r0     // Catch:{ all -> 0x0056 }
            float r0 = r0.getX()     // Catch:{ all -> 0x0056 }
            float r1 = r4.getX()     // Catch:{ all -> 0x0056 }
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x004f
            float r0 = r4.getX()     // Catch:{ all -> 0x0056 }
            com.github.mikephil.charting.data.DataSet$Rounding r1 = com.github.mikephil.charting.data.DataSet.Rounding.UP     // Catch:{ all -> 0x0056 }
            r2 = 2143289344(0x7fc00000, float:NaN)
            int r0 = r3.getEntryIndex(r0, r2, r1)     // Catch:{ all -> 0x0056 }
            java.util.List<T> r1 = r3.mEntries     // Catch:{ all -> 0x0056 }
            int r1 = r1.size()     // Catch:{ all -> 0x0056 }
            if (r1 <= r0) goto L_0x0054
            java.util.List<T> r1 = r3.mEntries     // Catch:{ all -> 0x0056 }
            r1.add(r0, r4)     // Catch:{ all -> 0x0056 }
            goto L_0x0054
        L_0x004f:
            java.util.List<T> r0 = r3.mEntries     // Catch:{ all -> 0x0056 }
            r0.add(r4)     // Catch:{ all -> 0x0056 }
        L_0x0054:
            monitor-exit(r3)
            return
        L_0x0056:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0056 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.DataSet.addEntryOrdered(com.github.mikephil.charting.data.Entry):void");
    }

    public void addEntries(List<T> list) {
        if (list != null && !list.isEmpty()) {
            if (this.mEntries == null) {
                this.mEntries = new CopyOnWriteArrayList();
            }
            for (T t : list) {
                calcMinMax(t);
                this.mEntries.add(t);
            }
        }
    }

    public void clear() {
        this.mEntries.clear();
        notifyDataSetChanged();
    }

    public boolean addEntry(T t) {
        if (t == null) {
            return false;
        }
        List entries = getEntries();
        if (entries == null) {
            entries = new ArrayList();
        }
        calcMinMax(t);
        return entries.add(t);
    }

    public boolean removeEntry(T t) {
        List<T> list;
        if (t == null || (list = this.mEntries) == null) {
            return false;
        }
        boolean remove = list.remove(t);
        if (remove) {
            calcMinMax();
        }
        return remove;
    }

    public int getEntryIndex(Entry entry) {
        return this.mEntries.indexOf(entry);
    }

    public T getEntryForXValue(float f, float f2, Rounding rounding) {
        try {
            int entryIndex = getEntryIndex(f, f2, rounding);
            if (entryIndex > -1) {
                return (Entry) this.mEntries.get(entryIndex);
            }
            return null;
        } catch (Exception e) {
            Log.e("getEntryForXValue", e.getMessage());
            return null;
        }
    }

    public int getEntryIndexForXValue(float f, float f2, Rounding rounding) {
        try {
            int entryIndex = getEntryIndex(f, f2, rounding);
            if (entryIndex > -1) {
                return entryIndex;
            }
            return 0;
        } catch (Exception e) {
            Log.e("getEntryIndexForXValue", e.getMessage());
            return 0;
        }
    }

    public T getEntryForXValue(float f, float f2) {
        return getEntryForXValue(f, f2, Rounding.CLOSEST);
    }

    public T getEntryForIndex(int i) {
        if (i < 0) {
            try {
                return (Entry) this.mEntries.get(0);
            } catch (Exception e) {
                Log.e("DataSet", e.getMessage());
                return null;
            }
        } else if (i <= this.mEntries.size() - 1) {
            return (Entry) this.mEntries.get(i);
        } else {
            int size = this.mEntries.size() - 1;
            if (size < 0) {
                return null;
            }
            return (Entry) this.mEntries.get(size);
        }
    }

    public int getEntryIndex(float f, float f2, Rounding rounding) {
        int i;
        Entry entry;
        List<T> list = this.mEntries;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int size = this.mEntries.size() - 1;
        int i2 = 0;
        while (i2 < size) {
            int i3 = (i2 + size) / 2;
            float x = ((Entry) this.mEntries.get(i3)).getX() - f;
            int i4 = i3 + 1;
            float abs = Math.abs(x);
            float abs2 = Math.abs(((Entry) this.mEntries.get(i4)).getX() - f);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d = (double) x;
                    if (d < Utils.DOUBLE_EPSILON) {
                        if (d >= Utils.DOUBLE_EPSILON) {
                        }
                    }
                }
                size = i3;
            }
            i2 = i4;
        }
        if (size == -1) {
            return size;
        }
        float x2 = ((Entry) this.mEntries.get(size)).getX();
        if (rounding == Rounding.UP) {
            if (x2 < f && size < this.mEntries.size() - 1) {
                size++;
            }
        } else if (rounding == Rounding.DOWN && x2 > f && size > 0) {
            size--;
        }
        if (Float.isNaN(f2)) {
            return size;
        }
        while (size > 0 && ((Entry) this.mEntries.get(size - 1)).getX() == x2) {
            size--;
        }
        float y = ((Entry) this.mEntries.get(size)).getY();
        loop2:
        while (true) {
            i = size;
            do {
                size++;
                if (size >= this.mEntries.size()) {
                    break loop2;
                }
                entry = (Entry) this.mEntries.get(size);
                if (entry.getX() != x2) {
                    break loop2;
                }
            } while (Math.abs(entry.getY() - f2) > Math.abs(y - f2));
            y = f2;
        }
        return i;
    }

    public List<T> getEntriesForXValue(float f) {
        ArrayList arrayList = new ArrayList();
        int size = this.mEntries.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            Entry entry = (Entry) this.mEntries.get(i2);
            if (entry == null) {
                return arrayList;
            }
            if (f == entry.getX()) {
                while (i2 > 0 && ((Entry) this.mEntries.get(i2 - 1)).getX() == f) {
                    i2--;
                }
                int size2 = this.mEntries.size();
                while (i2 < size2) {
                    Entry entry2 = (Entry) this.mEntries.get(i2);
                    if (entry2.getX() != f) {
                        break;
                    }
                    arrayList.add(entry2);
                    i2++;
                }
            } else if (f > entry.getX()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }

    public List<T> getEntriesForXRange(float f, float f2) {
        if (f > f2) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = this.mEntries.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            Entry entry = (Entry) this.mEntries.get(i2);
            if (f <= entry.getX() && f2 >= entry.getX()) {
                while (i2 > 0) {
                    int i3 = i2 - 1;
                    if (f > ((Entry) this.mEntries.get(i3)).getX() || f2 < ((Entry) this.mEntries.get(i3)).getX()) {
                        break;
                    }
                    i2--;
                }
                int size2 = this.mEntries.size();
                while (i2 < size2) {
                    Entry entry2 = (Entry) this.mEntries.get(i2);
                    if (f > entry2.getX() || f2 < entry2.getX()) {
                        break;
                    }
                    arrayList.add(entry2);
                    i2++;
                }
            } else if (f > entry.getX()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }
}
