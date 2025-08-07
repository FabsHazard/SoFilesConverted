package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class FragmentTrendIntroBinding implements ViewBinding {
    private final LinearLayoutCompat rootView;
    public final ImageView trend1;
    public final ImageView trend2;
    public final ImageView trend3;
    public final ImageView trend4;
    public final ImageView trend5;
    public final ImageView trend6;
    public final ImageView trend7;
    public final TextView trendIntroTips;

    private FragmentTrendIntroBinding(LinearLayoutCompat linearLayoutCompat, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, TextView textView) {
        this.rootView = linearLayoutCompat;
        this.trend1 = imageView;
        this.trend2 = imageView2;
        this.trend3 = imageView3;
        this.trend4 = imageView4;
        this.trend5 = imageView5;
        this.trend6 = imageView6;
        this.trend7 = imageView7;
        this.trendIntroTips = textView;
    }

    public LinearLayoutCompat getRoot() {
        return this.rootView;
    }

    public static FragmentTrendIntroBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTrendIntroBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_trend_intro, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTrendIntroBinding bind(View view) {
        int i = R.id.trend_1;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.trend_2;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView2 != null) {
                i = R.id.trend_3;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView3 != null) {
                    i = R.id.trend_4;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView4 != null) {
                        i = R.id.trend_5;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView5 != null) {
                            i = R.id.trend_6;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView6 != null) {
                                i = R.id.trend_7;
                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView7 != null) {
                                    i = R.id.trend_intro_tips;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        return new FragmentTrendIntroBinding((LinearLayoutCompat) view, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, textView);
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
