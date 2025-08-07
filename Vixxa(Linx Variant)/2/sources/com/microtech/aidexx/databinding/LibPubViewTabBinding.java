package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class LibPubViewTabBinding implements ViewBinding {
    private final View rootView;
    public final TextView tvNumber;
    public final TextView tvTitle;

    private LibPubViewTabBinding(View view, TextView textView, TextView textView2) {
        this.rootView = view;
        this.tvNumber = textView;
        this.tvTitle = textView2;
    }

    public View getRoot() {
        return this.rootView;
    }

    public static LibPubViewTabBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.lib_pub_view_tab, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    public static LibPubViewTabBinding bind(View view) {
        int i = R.id.tv_number;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_title;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                return new LibPubViewTabBinding(view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
