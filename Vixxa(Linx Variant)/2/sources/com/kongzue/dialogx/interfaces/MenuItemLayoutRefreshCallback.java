package com.kongzue.dialogx.interfaces;

import android.view.View;
import android.view.ViewGroup;

public interface MenuItemLayoutRefreshCallback<D> {
    void getView(D d, int i, View view, ViewGroup viewGroup);
}
