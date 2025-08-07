package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.SettingItemWidget;

public final class ActivitySettingBinding implements ViewBinding {
    public final ConstraintLayout clSettingHeader;
    public final ConstraintLayout clUserBasicInfo;
    public final ImageView ivSettingAvatar;
    public final ImageView ivSettingBack;
    public final ImageView ivSettingScan;
    public final RelativeLayout rlActionbar;
    private final ConstraintLayout rootView;
    public final SettingItemWidget settingAbout;
    public final SettingItemWidget settingAccountSecurity;
    public final SettingItemWidget settingAlert;
    public final SettingItemWidget settingAppInfo;
    public final LinearLayout settingEditProfileLl;
    public final SettingItemWidget settingLanguage;
    public final SettingItemWidget settingPermission;
    public final SettingItemWidget settingTheme;
    public final SettingItemWidget settingTimezoneHistory;
    public final SettingItemWidget settingTrans;
    public final SettingItemWidget settingUnit;
    public final SettingItemWidget settingUploadLog;
    public final TextView tvHelp;
    public final TextView tvShare;
    public final TextView tvWelfare;
    public final TextView txtTrademark;
    public final TextView txtVersion;
    public final TextView userName;

    private ActivitySettingBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, ImageView imageView2, ImageView imageView3, RelativeLayout relativeLayout, SettingItemWidget settingItemWidget, SettingItemWidget settingItemWidget2, SettingItemWidget settingItemWidget3, SettingItemWidget settingItemWidget4, LinearLayout linearLayout, SettingItemWidget settingItemWidget5, SettingItemWidget settingItemWidget6, SettingItemWidget settingItemWidget7, SettingItemWidget settingItemWidget8, SettingItemWidget settingItemWidget9, SettingItemWidget settingItemWidget10, SettingItemWidget settingItemWidget11, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.clSettingHeader = constraintLayout2;
        this.clUserBasicInfo = constraintLayout3;
        this.ivSettingAvatar = imageView;
        this.ivSettingBack = imageView2;
        this.ivSettingScan = imageView3;
        this.rlActionbar = relativeLayout;
        this.settingAbout = settingItemWidget;
        this.settingAccountSecurity = settingItemWidget2;
        this.settingAlert = settingItemWidget3;
        this.settingAppInfo = settingItemWidget4;
        this.settingEditProfileLl = linearLayout;
        this.settingLanguage = settingItemWidget5;
        this.settingPermission = settingItemWidget6;
        this.settingTheme = settingItemWidget7;
        this.settingTimezoneHistory = settingItemWidget8;
        this.settingTrans = settingItemWidget9;
        this.settingUnit = settingItemWidget10;
        this.settingUploadLog = settingItemWidget11;
        this.tvHelp = textView;
        this.tvShare = textView2;
        this.tvWelfare = textView3;
        this.txtTrademark = textView4;
        this.txtVersion = textView5;
        this.userName = textView6;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivitySettingBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_setting, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivitySettingBinding bind(View view) {
        View view2 = view;
        int i = R.id.cl_setting_header;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
        if (constraintLayout != null) {
            i = R.id.cl_user_basic_info;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
            if (constraintLayout2 != null) {
                i = R.id.iv_setting_avatar;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView != null) {
                    i = R.id.iv_setting_back;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                    if (imageView2 != null) {
                        i = R.id.iv_setting_scan;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                        if (imageView3 != null) {
                            i = R.id.rl_actionbar;
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                            if (relativeLayout != null) {
                                i = R.id.setting_about;
                                SettingItemWidget settingItemWidget = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                if (settingItemWidget != null) {
                                    i = R.id.setting_account_security;
                                    SettingItemWidget settingItemWidget2 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                    if (settingItemWidget2 != null) {
                                        i = R.id.setting_alert;
                                        SettingItemWidget settingItemWidget3 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                        if (settingItemWidget3 != null) {
                                            i = R.id.setting_appInfo;
                                            SettingItemWidget settingItemWidget4 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                            if (settingItemWidget4 != null) {
                                                i = R.id.setting_edit_profile_ll;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                if (linearLayout != null) {
                                                    i = R.id.setting_language;
                                                    SettingItemWidget settingItemWidget5 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                    if (settingItemWidget5 != null) {
                                                        i = R.id.setting_permission;
                                                        SettingItemWidget settingItemWidget6 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                        if (settingItemWidget6 != null) {
                                                            i = R.id.setting_theme;
                                                            SettingItemWidget settingItemWidget7 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                            if (settingItemWidget7 != null) {
                                                                i = R.id.setting_timezone_history;
                                                                SettingItemWidget settingItemWidget8 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                if (settingItemWidget8 != null) {
                                                                    i = R.id.setting_trans;
                                                                    SettingItemWidget settingItemWidget9 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                    if (settingItemWidget9 != null) {
                                                                        i = R.id.setting_unit;
                                                                        SettingItemWidget settingItemWidget10 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                        if (settingItemWidget10 != null) {
                                                                            i = R.id.setting_upload_log;
                                                                            SettingItemWidget settingItemWidget11 = (SettingItemWidget) ViewBindings.findChildViewById(view2, i);
                                                                            if (settingItemWidget11 != null) {
                                                                                i = R.id.tv_help;
                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView != null) {
                                                                                    i = R.id.tv_share;
                                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (textView2 != null) {
                                                                                        i = R.id.tv_welfare;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                        if (textView3 != null) {
                                                                                            i = R.id.txt_trademark;
                                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                            if (textView4 != null) {
                                                                                                i = R.id.txt_version;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.userName;
                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                    if (textView6 != null) {
                                                                                                        return new ActivitySettingBinding((ConstraintLayout) view2, constraintLayout, constraintLayout2, imageView, imageView2, imageView3, relativeLayout, settingItemWidget, settingItemWidget2, settingItemWidget3, settingItemWidget4, linearLayout, settingItemWidget5, settingItemWidget6, settingItemWidget7, settingItemWidget8, settingItemWidget9, settingItemWidget10, settingItemWidget11, textView, textView2, textView3, textView4, textView5, textView6);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
