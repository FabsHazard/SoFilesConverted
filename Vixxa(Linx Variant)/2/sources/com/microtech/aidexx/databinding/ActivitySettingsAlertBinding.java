package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.SettingItemWidget;

public final class ActivitySettingsAlertBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final SettingItemWidget hyperAlertSwitch;
    public final SettingItemWidget hyperThreshold;
    public final SettingItemWidget hypoAlertSwitch;
    public final SettingItemWidget hypoThreshold;
    public final SettingItemWidget lowUrgentValue;
    public final SettingItemWidget noticeFrequency;
    public final SettingItemWidget noticeFrequencySignal;
    public final SettingItemWidget noticeFrequencyUrgent;
    public final SettingItemWidget noticeMethod;
    public final SettingItemWidget noticeMethodSignalLoss;
    public final SettingItemWidget noticeMethodUrgent;
    private final LinearLayout rootView;
    public final SettingItemWidget switchFallAlert;
    public final SettingItemWidget switchRaiseAlert;
    public final SettingItemWidget switchSignalLoss;
    public final SettingItemWidget switchUrgentAlert;

    private ActivitySettingsAlertBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, SettingItemWidget settingItemWidget, SettingItemWidget settingItemWidget2, SettingItemWidget settingItemWidget3, SettingItemWidget settingItemWidget4, SettingItemWidget settingItemWidget5, SettingItemWidget settingItemWidget6, SettingItemWidget settingItemWidget7, SettingItemWidget settingItemWidget8, SettingItemWidget settingItemWidget9, SettingItemWidget settingItemWidget10, SettingItemWidget settingItemWidget11, SettingItemWidget settingItemWidget12, SettingItemWidget settingItemWidget13, SettingItemWidget settingItemWidget14, SettingItemWidget settingItemWidget15) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.hyperAlertSwitch = settingItemWidget;
        this.hyperThreshold = settingItemWidget2;
        this.hypoAlertSwitch = settingItemWidget3;
        this.hypoThreshold = settingItemWidget4;
        this.lowUrgentValue = settingItemWidget5;
        this.noticeFrequency = settingItemWidget6;
        this.noticeFrequencySignal = settingItemWidget7;
        this.noticeFrequencyUrgent = settingItemWidget8;
        this.noticeMethod = settingItemWidget9;
        this.noticeMethodSignalLoss = settingItemWidget10;
        this.noticeMethodUrgent = settingItemWidget11;
        this.switchFallAlert = settingItemWidget12;
        this.switchRaiseAlert = settingItemWidget13;
        this.switchSignalLoss = settingItemWidget14;
        this.switchUrgentAlert = settingItemWidget15;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingsAlertBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySettingsAlertBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_settings_alert, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySettingsAlertBinding bind(View view) {
        View view2 = view;
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view2, i);
        if (actionBarWidget != null) {
            i = R.id.hyper_alert_switch;
            SettingItemWidget settingItemWidget = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
            if (settingItemWidget != null) {
                i = R.id.hyper_threshold;
                SettingItemWidget settingItemWidget2 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                if (settingItemWidget2 != null) {
                    i = R.id.hypo_alert_switch;
                    SettingItemWidget settingItemWidget3 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                    if (settingItemWidget3 != null) {
                        i = R.id.hypo_threshold;
                        SettingItemWidget settingItemWidget4 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                        if (settingItemWidget4 != null) {
                            i = R.id.low_urgent_value;
                            SettingItemWidget settingItemWidget5 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                            if (settingItemWidget5 != null) {
                                i = R.id.notice_frequency;
                                SettingItemWidget settingItemWidget6 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                if (settingItemWidget6 != null) {
                                    i = R.id.notice_frequency_signal;
                                    SettingItemWidget settingItemWidget7 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                    if (settingItemWidget7 != null) {
                                        i = R.id.notice_frequency_urgent;
                                        SettingItemWidget settingItemWidget8 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                        if (settingItemWidget8 != null) {
                                            i = R.id.notice_method;
                                            SettingItemWidget settingItemWidget9 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                            if (settingItemWidget9 != null) {
                                                i = R.id.notice_method_signal_loss;
                                                SettingItemWidget settingItemWidget10 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                if (settingItemWidget10 != null) {
                                                    i = R.id.notice_method_urgent;
                                                    SettingItemWidget settingItemWidget11 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                    if (settingItemWidget11 != null) {
                                                        i = R.id.switch_fall_alert;
                                                        SettingItemWidget settingItemWidget12 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                        if (settingItemWidget12 != null) {
                                                            i = R.id.switch_raise_alert;
                                                            SettingItemWidget settingItemWidget13 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                            if (settingItemWidget13 != null) {
                                                                i = R.id.switch_signal_loss;
                                                                SettingItemWidget settingItemWidget14 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                if (settingItemWidget14 != null) {
                                                                    i = R.id.switch_urgent_alert;
                                                                    SettingItemWidget settingItemWidget15 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                    if (settingItemWidget15 != null) {
                                                                        return new ActivitySettingsAlertBinding((LinearLayout) view2, actionBarWidget, settingItemWidget, settingItemWidget2, settingItemWidget3, settingItemWidget4, settingItemWidget5, settingItemWidget6, settingItemWidget7, settingItemWidget8, settingItemWidget9, settingItemWidget10, settingItemWidget11, settingItemWidget12, settingItemWidget13, settingItemWidget14, settingItemWidget15);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
