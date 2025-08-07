package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;

public final class ActivityAppInfoBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final TextView appInfoCompanyAddress;
    public final TextView appInfoCompanyLink;
    public final TextView appInfoCompanyName;
    public final TextView appInfoGuideLink;
    public final TextView appInfoProxyInformation;
    public final TextView appInfoProxyName;
    private final LinearLayout rootView;
    public final TextView softwareCompleteVersion;
    public final TextView softwareModel;
    public final TextView softwareName;
    public final TextView softwareReleaseDate;
    public final TextView softwareReleaseVersion;
    public final TextView udiTv;

    private ActivityAppInfoBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.appInfoCompanyAddress = textView;
        this.appInfoCompanyLink = textView2;
        this.appInfoCompanyName = textView3;
        this.appInfoGuideLink = textView4;
        this.appInfoProxyInformation = textView5;
        this.appInfoProxyName = textView6;
        this.softwareCompleteVersion = textView7;
        this.softwareModel = textView8;
        this.softwareName = textView9;
        this.softwareReleaseDate = textView10;
        this.softwareReleaseVersion = textView11;
        this.udiTv = textView12;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAppInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAppInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_app_info, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAppInfoBinding bind(View view) {
        View view2 = view;
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view2, i);
        if (actionBarWidget != null) {
            i = R.id.appInfoCompanyAddress;
            TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
            if (textView != null) {
                i = R.id.appInfoCompanyLink;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView2 != null) {
                    i = R.id.appInfoCompanyName;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView3 != null) {
                        i = R.id.appInfoGuideLink;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView4 != null) {
                            i = R.id.appInfoProxyInformation;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView5 != null) {
                                i = R.id.appInfoProxyName;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView6 != null) {
                                    i = R.id.softwareCompleteVersion;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView7 != null) {
                                        i = R.id.softwareModel;
                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView8 != null) {
                                            i = R.id.softwareName;
                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView9 != null) {
                                                i = R.id.softwareReleaseDate;
                                                TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView10 != null) {
                                                    i = R.id.softwareReleaseVersion;
                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView11 != null) {
                                                        i = R.id.udiTv;
                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView12 != null) {
                                                            return new ActivityAppInfoBinding((LinearLayout) view2, actionBarWidget, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
                                                        }
                                                    }
                                                }
                                            }
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
