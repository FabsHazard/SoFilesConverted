package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.SettingItemWidget;

public final class ActivityAboutBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final ImageView launcher;
    private final LinearLayout rootView;
    public final SettingItemWidget settingCheckVersion;
    public final SettingItemWidget settingName;
    public final SettingItemWidget settingOpenVersion;
    public final SettingItemWidget settingProtocal;
    public final SettingItemWidget settingService;
    public final SettingItemWidget settingSoftVersion;
    public final SettingItemWidget settingType;

    private ActivityAboutBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, ImageView imageView, SettingItemWidget settingItemWidget, SettingItemWidget settingItemWidget2, SettingItemWidget settingItemWidget3, SettingItemWidget settingItemWidget4, SettingItemWidget settingItemWidget5, SettingItemWidget settingItemWidget6, SettingItemWidget settingItemWidget7) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.launcher = imageView;
        this.settingCheckVersion = settingItemWidget;
        this.settingName = settingItemWidget2;
        this.settingOpenVersion = settingItemWidget3;
        this.settingProtocal = settingItemWidget4;
        this.settingService = settingItemWidget5;
        this.settingSoftVersion = settingItemWidget6;
        this.settingType = settingItemWidget7;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAboutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_about, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityAboutBinding bind(View view) {
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.launcher;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.setting_checkVersion;
                SettingItemWidget settingItemWidget = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                if (settingItemWidget != null) {
                    i = R.id.setting_name;
                    SettingItemWidget settingItemWidget2 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                    if (settingItemWidget2 != null) {
                        i = R.id.setting_openVersion;
                        SettingItemWidget settingItemWidget3 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                        if (settingItemWidget3 != null) {
                            i = R.id.setting_protocal;
                            SettingItemWidget settingItemWidget4 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                            if (settingItemWidget4 != null) {
                                i = R.id.setting_service;
                                SettingItemWidget settingItemWidget5 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                                if (settingItemWidget5 != null) {
                                    i = R.id.setting_softVersion;
                                    SettingItemWidget settingItemWidget6 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                                    if (settingItemWidget6 != null) {
                                        i = R.id.setting_type;
                                        SettingItemWidget settingItemWidget7 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                                        if (settingItemWidget7 != null) {
                                            return new ActivityAboutBinding((LinearLayout) view, actionBarWidget, imageView, settingItemWidget, settingItemWidget2, settingItemWidget3, settingItemWidget4, settingItemWidget5, settingItemWidget6, settingItemWidget7);
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
