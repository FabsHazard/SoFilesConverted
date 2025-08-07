package com.microtech.aidexx.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.microtech.aidexx.R;
import com.microtech.aidexx.views.HollowPieChartView;
import com.microtech.aidexx.views.chart.GlucoseChart;

public final class FragmentHistoryEventBinding implements ViewBinding {
    public final GlucoseChart chart;
    public final FrameLayout flCollapse;
    public final ImageView ivCollapse;
    public final LinearLayout llPercentDetail;
    public final HollowPieChartView pvHigh;
    public final HollowPieChartView pvLow;
    public final HollowPieChartView pvNormal;
    private final LinearLayout rootView;
    public final RecyclerView rvHistoryDetail;
    public final TextView tvCarbohydrateWeight;
    public final TextView tvExerciseTime;
    public final TextView tvFatWeight;
    public final TextView tvGlucoseUnit;
    public final TextView tvHighGlucoseTime;
    public final TextView tvHighPercent;
    public final TextView tvHighRange;
    public final TextView tvInsulinDose;
    public final TextView tvLowGlucoseTime;
    public final TextView tvLowPercent;
    public final TextView tvLowRange;
    public final TextView tvMax;
    public final TextView tvMaxText;
    public final TextView tvMaxWave;
    public final TextView tvMedicationTimes;
    public final TextView tvMin;
    public final TextView tvMinText;
    public final TextView tvNormalGlucoseTime;
    public final TextView tvNormalPercent;
    public final TextView tvNormalRange;
    public final TextView tvProteinWeight;

    private FragmentHistoryEventBinding(LinearLayout linearLayout, GlucoseChart glucoseChart, FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout2, HollowPieChartView hollowPieChartView, HollowPieChartView hollowPieChartView2, HollowPieChartView hollowPieChartView3, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21) {
        this.rootView = linearLayout;
        this.chart = glucoseChart;
        this.flCollapse = frameLayout;
        this.ivCollapse = imageView;
        this.llPercentDetail = linearLayout2;
        this.pvHigh = hollowPieChartView;
        this.pvLow = hollowPieChartView2;
        this.pvNormal = hollowPieChartView3;
        this.rvHistoryDetail = recyclerView;
        this.tvCarbohydrateWeight = textView;
        this.tvExerciseTime = textView2;
        this.tvFatWeight = textView3;
        this.tvGlucoseUnit = textView4;
        this.tvHighGlucoseTime = textView5;
        this.tvHighPercent = textView6;
        this.tvHighRange = textView7;
        this.tvInsulinDose = textView8;
        this.tvLowGlucoseTime = textView9;
        this.tvLowPercent = textView10;
        this.tvLowRange = textView11;
        this.tvMax = textView12;
        this.tvMaxText = textView13;
        this.tvMaxWave = textView14;
        this.tvMedicationTimes = textView15;
        this.tvMin = textView16;
        this.tvMinText = textView17;
        this.tvNormalGlucoseTime = textView18;
        this.tvNormalPercent = textView19;
        this.tvNormalRange = textView20;
        this.tvProteinWeight = textView21;
    }

    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentHistoryEventBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static FragmentHistoryEventBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.fragment_history_event, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentHistoryEventBinding bind(View view) {
        View view2 = view;
        int i = R.id.chart;
        GlucoseChart glucoseChart = (GlucoseChart) ViewBindings.findChildViewById(view2, i);
        if (glucoseChart != null) {
            i = R.id.flCollapse;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view2, i);
            if (frameLayout != null) {
                i = R.id.ivCollapse;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                if (imageView != null) {
                    i = R.id.llPercentDetail;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view2, i);
                    if (linearLayout != null) {
                        i = R.id.pvHigh;
                        HollowPieChartView hollowPieChartView = (HollowPieChartView) ViewBindings.findChildViewById(view2, i);
                        if (hollowPieChartView != null) {
                            i = R.id.pvLow;
                            HollowPieChartView hollowPieChartView2 = (HollowPieChartView) ViewBindings.findChildViewById(view2, i);
                            if (hollowPieChartView2 != null) {
                                i = R.id.pvNormal;
                                HollowPieChartView hollowPieChartView3 = (HollowPieChartView) ViewBindings.findChildViewById(view2, i);
                                if (hollowPieChartView3 != null) {
                                    i = R.id.rvHistoryDetail;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view2, i);
                                    if (recyclerView != null) {
                                        i = R.id.tvCarbohydrateWeight;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView != null) {
                                            i = R.id.tvExerciseTime;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView2 != null) {
                                                i = R.id.tvFatWeight;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                if (textView3 != null) {
                                                    i = R.id.tvGlucoseUnit;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tvHighGlucoseTime;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tvHighPercent;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                            if (textView6 != null) {
                                                                i = R.id.tvHighRange;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.tvInsulinDose;
                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView8 != null) {
                                                                        i = R.id.tvLowGlucoseTime;
                                                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView9 != null) {
                                                                            i = R.id.tvLowPercent;
                                                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView10 != null) {
                                                                                i = R.id.tvLowRange;
                                                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView11 != null) {
                                                                                    i = R.id.tvMax;
                                                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                    if (textView12 != null) {
                                                                                        i = R.id.tvMaxText;
                                                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                        if (textView13 != null) {
                                                                                            i = R.id.tvMaxWave;
                                                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                            if (textView14 != null) {
                                                                                                i = R.id.tvMedicationTimes;
                                                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                if (textView15 != null) {
                                                                                                    i = R.id.tvMin;
                                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                    if (textView16 != null) {
                                                                                                        i = R.id.tvMinText;
                                                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                        if (textView17 != null) {
                                                                                                            i = R.id.tvNormalGlucoseTime;
                                                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                            if (textView18 != null) {
                                                                                                                i = R.id.tvNormalPercent;
                                                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                if (textView19 != null) {
                                                                                                                    i = R.id.tvNormalRange;
                                                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                    if (textView20 != null) {
                                                                                                                        i = R.id.tvProteinWeight;
                                                                                                                        TextView textView21 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                        if (textView21 != null) {
                                                                                                                            return new FragmentHistoryEventBinding((LinearLayout) view2, glucoseChart, frameLayout, imageView, linearLayout, hollowPieChartView, hollowPieChartView2, hollowPieChartView3, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20, textView21);
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
