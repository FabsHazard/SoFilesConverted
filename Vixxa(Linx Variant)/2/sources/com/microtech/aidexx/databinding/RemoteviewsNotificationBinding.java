package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;

public final class RemoteviewsNotificationBinding implements ViewBinding {
    public final RelativeLayout notice;
    private final RelativeLayout rootView;
    public final TextView tvGlucose;
    public final TextView tvTime;
    public final TextView tvUnit;

    private RemoteviewsNotificationBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3) {
        this.rootView = relativeLayout;
        this.notice = relativeLayout2;
        this.tvGlucose = textView;
        this.tvTime = textView2;
        this.tvUnit = textView3;
    }

    public RelativeLayout getRoot() {
        return this.rootView;
    }

    public static RemoteviewsNotificationBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static RemoteviewsNotificationBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.remoteviews_notification, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RemoteviewsNotificationBinding bind(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.tv_glucose;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.tv_time;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.tv_unit;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    return new RemoteviewsNotificationBinding(relativeLayout, relativeLayout, textView, textView2, textView3);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
