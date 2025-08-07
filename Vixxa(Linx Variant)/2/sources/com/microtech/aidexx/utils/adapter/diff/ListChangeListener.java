package com.microtech.aidexx.utils.adapter.diff;

import java.util.List;

public interface ListChangeListener<T> {
    void onCurrentListChanged(List<T> list, List<T> list2);
}
