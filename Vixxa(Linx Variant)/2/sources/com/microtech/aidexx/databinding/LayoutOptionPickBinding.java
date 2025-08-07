package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.contrarywind.view.WheelView;
import com.microtech.aidexx.R;

public final class LayoutOptionPickBinding implements ViewBinding {
    public final TextView ivTitle;
    public final WheelView options1;
    public final WheelView options2;
    public final WheelView options3;
    public final LinearLayout optionspicker;
    private final LinearLayout rootView;
    public final TextView tvOptionCancel;
    public final TextView tvOptionConfirm;

    private LayoutOptionPickBinding(LinearLayout linearLayout, TextView textView, WheelView wheelView, WheelView wheelView2, WheelView wheelView3, LinearLayout linearLayout2, TextView textView2, TextView textView3) {
        this.rootView = linearLayout;
        this.ivTitle = textView;
        this.options1 = wheelView;
        this.options2 = wheelView2;
        this.options3 = wheelView3;
        this.optionspicker = linearLayout2;
        this.tvOptionCancel = textView2;
        this.tvOptionConfirm = textView3;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static LayoutOptionPickBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutOptionPickBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_option_pick, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutOptionPickBinding bind(View view) {
        int i = R.id.iv_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.options1;
            WheelView wheelView = (WheelView) ViewBindings.findChildViewById(view, i);
            if (wheelView != null) {
                i = R.id.options2;
                WheelView wheelView2 = (WheelView) ViewBindings.findChildViewById(view, i);
                if (wheelView2 != null) {
                    i = R.id.options3;
                    WheelView wheelView3 = (WheelView) ViewBindings.findChildViewById(view, i);
                    if (wheelView3 != null) {
                        i = R.id.optionspicker;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout != null) {
                            i = R.id.tv_option_cancel;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.tv_option_confirm;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new LayoutOptionPickBinding((LinearLayout) view, textView, wheelView, wheelView2, wheelView3, linearLayout, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
