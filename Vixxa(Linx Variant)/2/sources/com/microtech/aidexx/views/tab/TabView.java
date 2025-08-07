package com.microtech.aidexx.views.tab;

public interface TabView {
    void notifyData(boolean z);

    void onScroll(float f);

    void setNumber(String str, int i);

    void setPadding(int i);

    void setText(String str);
}
