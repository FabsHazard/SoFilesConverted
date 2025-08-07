package com.microtech.aidexx.views.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;

public class TabViewGroup extends RelativeLayout implements TabView {
    private Context mContext;
    private TextView mTvNumber;
    private TextView mTvTitle;

    public void onScroll(float f) {
    }

    public TabViewGroup(Context context) {
        super(context);
        init(context);
    }

    public TabViewGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public TabViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.lib_pub_view_tab, this);
        this.mTvTitle = (TextView) inflate.findViewById(R.id.tv_title);
        this.mTvNumber = (TextView) inflate.findViewById(R.id.tv_number);
    }

    public void setText(String str) {
        this.mTvTitle.setText(str);
    }

    public void setPadding(int i) {
        setPadding(i, 0, i, 0);
    }

    public void setNumber(String str, int i) {
        this.mTvNumber.setText(str);
        this.mTvNumber.setVisibility(i);
    }

    public void notifyData(boolean z) {
        this.mTvTitle.setTextColor(ContextCompat.getColor(this.mContext, z ? R.color.lib_pub_color_main : R.color.lib_pub_color_gray));
    }
}
