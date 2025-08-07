package com.microtech.aidexx.utils.adapter.listener;

import android.view.View;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;

public interface OnItemChildLongClickListener {
    boolean onItemChildLongClick(BaseQuickAdapter<?, ?> baseQuickAdapter, View view, int i);
}
