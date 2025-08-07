package com.microtech.aidexx.views.selector.base;

import com.contrarywind.adapter.WheelAdapter;
import java.util.List;

public class ArrayWheelAdapter<T> implements WheelAdapter {
    private final List<T> items;

    public ArrayWheelAdapter(List<T> list) {
        this.items = list;
    }

    public Object getItem(int i) {
        if (i < 0 || i >= this.items.size()) {
            return "";
        }
        return this.items.get(i);
    }

    public int getItemsCount() {
        return this.items.size();
    }

    public int indexOf(Object obj) {
        return this.items.indexOf(obj);
    }
}
