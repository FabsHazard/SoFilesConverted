package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.SettingItemWidget;

public final class ActivityOtherSettingBinding implements ViewBinding {
    public final ActionBarWidget actionBarOtherSetting;
    private final ConstraintLayout rootView;
    public final SettingItemWidget settingCancelAccount;
    public final SettingItemWidget settingLogout;
    public final SettingItemWidget settingResetPwd;

    private ActivityOtherSettingBinding(ConstraintLayout constraintLayout, ActionBarWidget actionBarWidget, SettingItemWidget settingItemWidget, SettingItemWidget settingItemWidget2, SettingItemWidget settingItemWidget3) {
        this.rootView = constraintLayout;
        this.actionBarOtherSetting = actionBarWidget;
        this.settingCancelAccount = settingItemWidget;
        this.settingLogout = settingItemWidget2;
        this.settingResetPwd = settingItemWidget3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityOtherSettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityOtherSettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_other_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivityOtherSettingBinding bind(View view) {
        int i = R.id.action_bar_other_setting;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view, i);
        if (actionBarWidget != null) {
            i = R.id.setting_cancel_account;
            SettingItemWidget settingItemWidget = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
            if (settingItemWidget != null) {
                i = R.id.setting_logout;
                SettingItemWidget settingItemWidget2 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                if (settingItemWidget2 != null) {
                    i = R.id.setting_reset_pwd;
                    SettingItemWidget settingItemWidget3 = (SettingItemWidget) ViewBindings.findChildViewById(view, i);
                    if (settingItemWidget3 != null) {
                        return new ActivityOtherSettingBinding((ConstraintLayout) view, actionBarWidget, settingItemWidget, settingItemWidget2, settingItemWidget3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
