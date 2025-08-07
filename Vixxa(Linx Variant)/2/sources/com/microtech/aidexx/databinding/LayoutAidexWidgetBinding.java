package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class LayoutAidexWidgetBinding implements ViewBinding {
    public final ImageView ivLogo;
    public final ImageView ivWidgetBg;
    public final RelativeLayout llContainer;
    public final LinearLayout llValue;
    private final RelativeLayout rootView;
    public final TextView titleUpdateTime;
    public final TextView widgetGlucoseValue;
    public final RelativeLayout widgetRoot;
    public final ImageView widgetTrend;
    public final TextView widgetUnit;
    public final TextView widgetUpdateTime;

    private LayoutAidexWidgetBinding(RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, RelativeLayout relativeLayout2, LinearLayout linearLayout, TextView textView, TextView textView2, RelativeLayout relativeLayout3, ImageView imageView3, TextView textView3, TextView textView4) {
        this.rootView = relativeLayout;
        this.ivLogo = imageView;
        this.ivWidgetBg = imageView2;
        this.llContainer = relativeLayout2;
        this.llValue = linearLayout;
        this.titleUpdateTime = textView;
        this.widgetGlucoseValue = textView2;
        this.widgetRoot = relativeLayout3;
        this.widgetTrend = imageView3;
        this.widgetUnit = textView3;
        this.widgetUpdateTime = textView4;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static LayoutAidexWidgetBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static LayoutAidexWidgetBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.layout_aidex_widget, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LayoutAidexWidgetBinding bind(View view) {
        int i = R.id.iv_logo;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.iv_widget_bg;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.llContainer;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                if (relativeLayout != null) {
                    i = R.id.ll_value;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.title_update_time;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.widget_glucose_value;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                RelativeLayout relativeLayout2 = (RelativeLayout) view;
                                i = R.id.widget_trend;
                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView3 != null) {
                                    i = R.id.widget_unit;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.widget_update_time;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            return new LayoutAidexWidgetBinding(relativeLayout2, imageView, imageView2, relativeLayout, linearLayout, textView, textView2, relativeLayout2, imageView3, textView3, textView4);
                                        }
                                    }
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
