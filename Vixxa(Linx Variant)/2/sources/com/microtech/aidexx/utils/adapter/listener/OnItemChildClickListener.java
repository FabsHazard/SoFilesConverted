package com.microtech.aidexx.utils.adapter.listener;

import android.view.View;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;

public interface OnItemChildClickListener {
    void onItemChildClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i);
}
