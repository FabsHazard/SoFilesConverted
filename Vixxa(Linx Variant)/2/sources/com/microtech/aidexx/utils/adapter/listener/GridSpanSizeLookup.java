package com.microtech.aidexx.utils.adapter.listener;

import androidx.recyclerview.widget.GridLayoutManager;

public interface GridSpanSizeLookup {
    int getSpanSize(GridLayoutManager gridLayoutManager, int i, int i2);
}
