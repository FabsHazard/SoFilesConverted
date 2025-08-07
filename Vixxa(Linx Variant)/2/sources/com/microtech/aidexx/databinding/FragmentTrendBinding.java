package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.main.trend.view.ExpandableGrid;
import com.microtech.aidexx.ui.main.trend.view.LbgiCursorView;
import com.microtech.aidexx.ui.main.trend.view.PieChartView;
import com.microtech.aidexx.ui.main.trend.view.TrendsChart;
import com.microtech.aidexx.views.chart.GlucoseChart;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

public final class FragmentTrendBinding implements ViewBinding {
    public final TrendsChart agpChart;
    public final LbgiCursorView cursorView;
    public final TextView descHigh;
    public final TextView descLow;
    public final TextView descNormal;
    public final TextView ehba1cValue;
    public final ExpandableGrid expandableGrid;
    public final Guideline guideLineEnd;
    public final Guideline guideLineOne;
    public final Guideline guideLineStart;
    public final Guideline guideLineTwo;
    public final TextView highPercent;
    public final ImageView ivEhba1cTrends;
    public final ImageView ivGenerationAgp;
    public final ImageView ivHighTrends;
    public final ImageView ivLowTrends;
    public final ImageView ivMbgTrends;
    public final ConstraintLayout layoutActionbar;
    public final LinearLayout llEhba1c;
    public final LinearLayout llHigh;
    public final LinearLayout llLow;
    public final LinearLayout llMbg;
    public final LinearLayout llMulti;
    public final LinearLayout llNormal;
    public final ConstraintLayout llPieChartDetail;
    public final LinearLayout llScroll;
    public final LinearLayout llTrends;
    public final TextView lowPercent;
    public final GlucoseChart multiDayChart;
    public final TextView normalPercent;
    public final PieChartView pieChart;
    public final LinearLayout rlDateSpace;
    public final RelativeLayout rlPieChart;
    private final LinearLayout rootView;
    public final TextView timeBegin;
    public final TextView timeEnd;
    public final TextView timeSeparate;
    public final SmartRefreshLayout trendRefreshLayout;
    public final NestedScrollView trendScroll;
    public final TextView tvAverage;
    public final TextView tvCoverTimePercent;
    public final TextView tvCoverTimeTitle;
    public final TextView tvCoverTimeValue;
    public final TextView tvMbgUnit;
    public final TextView tvMbgValue;
    public final TextView tvMonitorTimesTitle;
    public final TextView tvMonitorTimesValue;
    public final TextView tvTrendsTitle;
    public final TextView txtEmptyPies;
    public final TextView txtTitleAgp;
    public final TextView txtTitleGlucose;
    public final TextView txtTitleLBGI;
    public final TextView txtTitleMulti;
    public final TextView txtTitleTir;
    public final TextView txtUnitPercent;

    private FragmentTrendBinding(LinearLayout linearLayout, TrendsChart trendsChart, LbgiCursorView lbgiCursorView, TextView textView, TextView textView2, TextView textView3, TextView textView4, ExpandableGrid expandableGrid2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, TextView textView5, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, ConstraintLayout constraintLayout2, LinearLayout linearLayout8, LinearLayout linearLayout9, TextView textView6, GlucoseChart glucoseChart, TextView textView7, PieChartView pieChartView, LinearLayout linearLayout10, RelativeLayout relativeLayout, TextView textView8, TextView textView9, TextView textView10, SmartRefreshLayout smartRefreshLayout, NestedScrollView nestedScrollView, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26) {
        this.rootView = linearLayout;
        this.agpChart = trendsChart;
        this.cursorView = lbgiCursorView;
        this.descHigh = textView;
        this.descLow = textView2;
        this.descNormal = textView3;
        this.ehba1cValue = textView4;
        this.expandableGrid = expandableGrid2;
        this.guideLineEnd = guideline;
        this.guideLineOne = guideline2;
        this.guideLineStart = guideline3;
        this.guideLineTwo = guideline4;
        this.highPercent = textView5;
        this.ivEhba1cTrends = imageView;
        this.ivGenerationAgp = imageView2;
        this.ivHighTrends = imageView3;
        this.ivLowTrends = imageView4;
        this.ivMbgTrends = imageView5;
        this.layoutActionbar = constraintLayout;
        this.llEhba1c = linearLayout2;
        this.llHigh = linearLayout3;
        this.llLow = linearLayout4;
        this.llMbg = linearLayout5;
        this.llMulti = linearLayout6;
        this.llNormal = linearLayout7;
        this.llPieChartDetail = constraintLayout2;
        this.llScroll = linearLayout8;
        this.llTrends = linearLayout9;
        this.lowPercent = textView6;
        this.multiDayChart = glucoseChart;
        this.normalPercent = textView7;
        this.pieChart = pieChartView;
        this.rlDateSpace = linearLayout10;
        this.rlPieChart = relativeLayout;
        this.timeBegin = textView8;
        this.timeEnd = textView9;
        this.timeSeparate = textView10;
        this.trendRefreshLayout = smartRefreshLayout;
        this.trendScroll = nestedScrollView;
        this.tvAverage = textView11;
        this.tvCoverTimePercent = textView12;
        this.tvCoverTimeTitle = textView13;
        this.tvCoverTimeValue = textView14;
        this.tvMbgUnit = textView15;
        this.tvMbgValue = textView16;
        this.tvMonitorTimesTitle = textView17;
        this.tvMonitorTimesValue = textView18;
        this.tvTrendsTitle = textView19;
        this.txtEmptyPies = textView20;
        this.txtTitleAgp = textView21;
        this.txtTitleGlucose = textView22;
        this.txtTitleLBGI = textView23;
        this.txtTitleMulti = textView24;
        this.txtTitleTir = textView25;
        this.txtUnitPercent = textView26;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentTrendBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentTrendBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_trend, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentTrendBinding bind(View view) {
        View view2 = view;
        int i = R.id.agp_chart;
        TrendsChart trendsChart = (TrendsChart) ViewBindings.findChildViewById(view2, i);
        if (trendsChart != null) {
            i = R.id.cursor_view;
            LbgiCursorView lbgiCursorView = (LbgiCursorView) ViewBindings.findChildViewById(view2, i);
            if (lbgiCursorView != null) {
                i = R.id.desc_high;
                TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView != null) {
                    i = R.id.desc_low;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView2 != null) {
                        i = R.id.desc_normal;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView3 != null) {
                            i = R.id.ehba1c_value;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView4 != null) {
                                i = R.id.expandable_grid;
                                ExpandableGrid expandableGrid2 = (ExpandableGrid) ViewBindings.findChildViewById(view2, i);
                                if (expandableGrid2 != null) {
                                    i = R.id.guide_line_end;
                                    Guideline guideline = (Guideline) ViewBindings.findChildViewById(view2, i);
                                    if (guideline != null) {
                                        i = R.id.guide_line_one;
                                        Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                        if (guideline2 != null) {
                                            i = R.id.guide_line_start;
                                            Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                            if (guideline3 != null) {
                                                i = R.id.guide_line_two;
                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view2, i);
                                                if (guideline4 != null) {
                                                    i = R.id.high_percent;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView5 != null) {
                                                        i = R.id.iv_ehba1c_trends;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                        if (imageView != null) {
                                                            i = R.id.iv_generation_agp;
                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                            if (imageView2 != null) {
                                                                i = R.id.iv_high_trends;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.iv_low_trends;
                                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                    if (imageView4 != null) {
                                                                        i = R.id.iv_mbg_trends;
                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                        if (imageView5 != null) {
                                                                            i = R.id.layout_actionbar;
                                                                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                            if (constraintLayout != null) {
                                                                                i = R.id.ll_ehba1c;
                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                if (linearLayout != null) {
                                                                                    i = R.id.ll_high;
                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                    if (linearLayout2 != null) {
                                                                                        i = R.id.ll_low;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.ll_mbg;
                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                            if (linearLayout4 != null) {
                                                                                                i = R.id.ll_multi;
                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                if (linearLayout5 != null) {
                                                                                                    i = R.id.ll_normal;
                                                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                    if (linearLayout6 != null) {
                                                                                                        i = R.id.ll_pie_chart_detail;
                                                                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                        if (constraintLayout2 != null) {
                                                                                                            i = R.id.ll_scroll;
                                                                                                            LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                            if (linearLayout7 != null) {
                                                                                                                i = R.id.ll_trends;
                                                                                                                LinearLayout linearLayout8 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                if (linearLayout8 != null) {
                                                                                                                    i = R.id.low_percent;
                                                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                    if (textView6 != null) {
                                                                                                                        i = R.id.multiDayChart;
                                                                                                                        GlucoseChart glucoseChart = (GlucoseChart) ViewBindings.findChildViewById(view2, i);
                                                                                                                        if (glucoseChart != null) {
                                                                                                                            i = R.id.normal_percent;
                                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                            if (textView7 != null) {
                                                                                                                                i = R.id.pie_chart;
                                                                                                                                PieChartView pieChartView = (PieChartView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                if (pieChartView != null) {
                                                                                                                                    i = R.id.rl_date_space;
                                                                                                                                    LinearLayout linearLayout9 = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                                    if (linearLayout9 != null) {
                                                                                                                                        i = R.id.rl_pie_chart;
                                                                                                                                        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                                        if (relativeLayout != null) {
                                                                                                                                            i = R.id.time_begin;
                                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                            if (textView8 != null) {
                                                                                                                                                i = R.id.time_end;
                                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                if (textView9 != null) {
                                                                                                                                                    i = R.id.time_separate;
                                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                    if (textView10 != null) {
                                                                                                                                                        i = R.id.trend_refreshLayout;
                                                                                                                                                        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                        if (smartRefreshLayout != null) {
                                                                                                                                                            i = R.id.trend_scroll;
                                                                                                                                                            NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                            if (nestedScrollView != null) {
                                                                                                                                                                i = R.id.tv_average;
                                                                                                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                if (textView11 != null) {
                                                                                                                                                                    i = R.id.tv_cover_time_percent;
                                                                                                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                    if (textView12 != null) {
                                                                                                                                                                        i = R.id.tv_cover_time_title;
                                                                                                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                        if (textView13 != null) {
                                                                                                                                                                            i = R.id.tv_cover_time_value;
                                                                                                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                            if (textView14 != null) {
                                                                                                                                                                                i = R.id.tv_mbg_unit;
                                                                                                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                if (textView15 != null) {
                                                                                                                                                                                    i = R.id.tv_mbg_value;
                                                                                                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                    if (textView16 != null) {
                                                                                                                                                                                        i = R.id.tv_monitor_times_title;
                                                                                                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                        if (textView17 != null) {
                                                                                                                                                                                            i = R.id.tv_monitor_times_value;
                                                                                                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                            if (textView18 != null) {
                                                                                                                                                                                                i = R.id.tv_trends_title;
                                                                                                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                if (textView19 != null) {
                                                                                                                                                                                                    i = R.id.txt_empty_pies;
                                                                                                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                    if (textView20 != null) {
                                                                                                                                                                                                        i = R.id.txt_title_agp;
                                                                                                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                        if (textView21 != null) {
                                                                                                                                                                                                            i = R.id.txt_title_glucose;
                                                                                                                                                                                                            TextView textView22 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                            if (textView22 != null) {
                                                                                                                                                                                                                i = R.id.txt_title_LBGI;
                                                                                                                                                                                                                TextView textView23 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                if (textView23 != null) {
                                                                                                                                                                                                                    i = R.id.txt_title_multi;
                                                                                                                                                                                                                    TextView textView24 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                    if (textView24 != null) {
                                                                                                                                                                                                                        i = R.id.txt_title_tir;
                                                                                                                                                                                                                        TextView textView25 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                        if (textView25 != null) {
                                                                                                                                                                                                                            i = R.id.txt_unit_percent;
                                                                                                                                                                                                                            TextView textView26 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                            if (textView26 != null) {
                                                                                                                                                                                                                                return new FragmentTrendBinding((LinearLayout) view2, trendsChart, lbgiCursorView, textView, textView2, textView3, textView4, expandableGrid2, guideline, guideline2, guideline3, guideline4, textView5, imageView, imageView2, imageView3, imageView4, imageView5, constraintLayout, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, linearLayout6, constraintLayout2, linearLayout7, linearLayout8, textView6, glucoseChart, textView7, pieChartView, linearLayout9, relativeLayout, textView8, textView9, textView10, smartRefreshLayout, nestedScrollView, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26);
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
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
