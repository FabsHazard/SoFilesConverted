package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.flexbox.FlexboxLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.ActionBarWidget;
import com.microtech.aidexx.views.SettingItemWidget;

public final class ActivitySettingsProfileBinding implements ViewBinding {
    public final ActionBarWidget actionBar;
    public final FlexboxLayout flAge;
    public final FlexboxLayout flBmi;
    public final FlexboxLayout flComplications;
    public final FlexboxLayout flDiagnosis;
    public final FlexboxLayout flTreatment;
    public final LinearLayout llDiabetesDetail;
    private final LinearLayout rootView;
    public final SettingItemWidget siwBirth;
    public final SettingItemWidget siwDiabetes;
    public final SettingItemWidget siwFullName;
    public final SettingItemWidget siwGender;
    public final SettingItemWidget siwHeight;
    public final SettingItemWidget siwNickName;
    public final SettingItemWidget siwOtherDisease;
    public final SettingItemWidget siwPhone;
    public final SettingItemWidget siwWeight;
    public final TextView tvAge;
    public final TextView tvBmi;
    public final TextView tvComplications;
    public final TextView tvDiagnosis;
    public final TextView tvTreatment;

    private ActivitySettingsProfileBinding(LinearLayout linearLayout, ActionBarWidget actionBarWidget, FlexboxLayout flexboxLayout, FlexboxLayout flexboxLayout2, FlexboxLayout flexboxLayout3, FlexboxLayout flexboxLayout4, FlexboxLayout flexboxLayout5, LinearLayout linearLayout2, SettingItemWidget settingItemWidget, SettingItemWidget settingItemWidget2, SettingItemWidget settingItemWidget3, SettingItemWidget settingItemWidget4, SettingItemWidget settingItemWidget5, SettingItemWidget settingItemWidget6, SettingItemWidget settingItemWidget7, SettingItemWidget settingItemWidget8, SettingItemWidget settingItemWidget9, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        this.rootView = linearLayout;
        this.actionBar = actionBarWidget;
        this.flAge = flexboxLayout;
        this.flBmi = flexboxLayout2;
        this.flComplications = flexboxLayout3;
        this.flDiagnosis = flexboxLayout4;
        this.flTreatment = flexboxLayout5;
        this.llDiabetesDetail = linearLayout2;
        this.siwBirth = settingItemWidget;
        this.siwDiabetes = settingItemWidget2;
        this.siwFullName = settingItemWidget3;
        this.siwGender = settingItemWidget4;
        this.siwHeight = settingItemWidget5;
        this.siwNickName = settingItemWidget6;
        this.siwOtherDisease = settingItemWidget7;
        this.siwPhone = settingItemWidget8;
        this.siwWeight = settingItemWidget9;
        this.tvAge = textView;
        this.tvBmi = textView2;
        this.tvComplications = textView3;
        this.tvDiagnosis = textView4;
        this.tvTreatment = textView5;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingsProfileBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySettingsProfileBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_settings_profile, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySettingsProfileBinding bind(View view) {
        View view2 = view;
        int i = R.id.action_bar;
        ActionBarWidget actionBarWidget = (ActionBarWidget) ViewBindings.findChildViewById(view2, i);
        if (actionBarWidget != null) {
            i = R.id.flAge;
            FlexboxLayout flexboxLayout = (FlexboxLayout) ViewBindings.findChildViewById(view2, i);
            if (flexboxLayout != null) {
                i = R.id.fl_bmi;
                FlexboxLayout flexboxLayout2 = (FlexboxLayout) ViewBindings.findChildViewById(view2, i);
                if (flexboxLayout2 != null) {
                    i = R.id.flComplications;
                    FlexboxLayout flexboxLayout3 = (FlexboxLayout) ViewBindings.findChildViewById(view2, i);
                    if (flexboxLayout3 != null) {
                        i = R.id.flDiagnosis;
                        FlexboxLayout flexboxLayout4 = (FlexboxLayout) ViewBindings.findChildViewById(view2, i);
                        if (flexboxLayout4 != null) {
                            i = R.id.flTreatment;
                            FlexboxLayout flexboxLayout5 = (FlexboxLayout) ViewBindings.findChildViewById(view2, i);
                            if (flexboxLayout5 != null) {
                                i = R.id.llDiabetesDetail;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                if (linearLayout != null) {
                                    i = R.id.siw_birth;
                                    SettingItemWidget settingItemWidget = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                    if (settingItemWidget != null) {
                                        i = R.id.siw_diabetes;
                                        SettingItemWidget settingItemWidget2 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                        if (settingItemWidget2 != null) {
                                            i = R.id.siw_full_name;
                                            SettingItemWidget settingItemWidget3 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                            if (settingItemWidget3 != null) {
                                                i = R.id.siw_gender;
                                                SettingItemWidget settingItemWidget4 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                if (settingItemWidget4 != null) {
                                                    i = R.id.siw_height;
                                                    SettingItemWidget settingItemWidget5 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                    if (settingItemWidget5 != null) {
                                                        i = R.id.siw_nickName;
                                                        SettingItemWidget settingItemWidget6 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                        if (settingItemWidget6 != null) {
                                                            i = R.id.siwOtherDisease;
                                                            SettingItemWidget settingItemWidget7 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                            if (settingItemWidget7 != null) {
                                                                i = R.id.siw_phone;
                                                                SettingItemWidget settingItemWidget8 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                if (settingItemWidget8 != null) {
                                                                    i = R.id.siw_weight;
                                                                    SettingItemWidget settingItemWidget9 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                    if (settingItemWidget9 != null) {
                                                                        i = R.id.tvAge;
                                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView != null) {
                                                                            i = R.id.tvBmi;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView2 != null) {
                                                                                i = R.id.tvComplications;
                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView3 != null) {
                                                                                    i = R.id.tvDiagnosis;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.tvTreatment;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                        if (textView5 != null) {
                                                                                            return new ActivitySettingsProfileBinding((LinearLayout) view2, actionBarWidget, flexboxLayout, flexboxLayout2, flexboxLayout3, flexboxLayout4, flexboxLayout5, linearLayout, settingItemWidget, settingItemWidget2, settingItemWidget3, settingItemWidget4, settingItemWidget5, settingItemWidget6, settingItemWidget7, settingItemWidget8, settingItemWidget9, textView, textView2, textView3, textView4, textView5);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
