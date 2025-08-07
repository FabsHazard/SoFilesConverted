package com.scwang.smart.refresh.layout.util;

import android.content.res.Resources;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.ScrollView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.ScrollingView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.scwang.smart.refresh.layout.api.RefreshComponent;
import com.scwang.smart.refresh.layout.kernel.R;

public class SmartUtil implements Interpolator {
    public static int INTERPOLATOR_DECELERATE = 1;
    public static int INTERPOLATOR_VISCOUS_FLUID = 0;
    private static final float VISCOUS_FLUID_NORMALIZE;
    private static final float VISCOUS_FLUID_OFFSET;
    private static final float VISCOUS_FLUID_SCALE = 8.0f;
    private static float density = Resources.getSystem().getDisplayMetrics().density;
    private int type;

    public SmartUtil(int i) {
        this.type = i;
    }

    public static int measureViewHeight(View view) {
        int i;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, 0, layoutParams.width);
        if (layoutParams.height > 0) {
            i = View.MeasureSpec.makeMeasureSpec(layoutParams.height, BasicMeasure.EXACTLY);
        } else {
            i = View.MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, i);
        return view.getMeasuredHeight();
    }

    public static void scrollListBy(AbsListView absListView, int i) {
        absListView.scrollListBy(i);
    }

    public static boolean isScrollableView(View view) {
        if (view instanceof RefreshComponent) {
            return false;
        }
        if ((view instanceof AbsListView) || (view instanceof ScrollView) || (view instanceof ScrollingView) || (view instanceof WebView) || (view instanceof NestedScrollingChild)) {
            return true;
        }
        return false;
    }

    public static boolean isContentView(View view) {
        if (view instanceof RefreshComponent) {
            return false;
        }
        if (isScrollableView(view) || (view instanceof ViewPager) || (view instanceof NestedScrollingParent)) {
            return true;
        }
        return false;
    }

    public static void fling(View view, int i) {
        if (view instanceof ScrollView) {
            ((ScrollView) view).fling(i);
        } else if (view instanceof AbsListView) {
            ((AbsListView) view).fling(i);
        } else if (view instanceof WebView) {
            ((WebView) view).flingScroll(0, i);
        } else if (view instanceof NestedScrollView) {
            ((NestedScrollView) view).fling(i);
        } else if (view instanceof RecyclerView) {
            ((RecyclerView) view).fling(0, i);
        }
    }

    public static boolean canRefresh(View view, PointF pointF) {
        if (view.canScrollVertically(-1) && view.getVisibility() == 0) {
            return false;
        }
        if (!(view instanceof ViewGroup) || pointF == null) {
            return true;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        PointF pointF2 = new PointF();
        for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount - 1);
            if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                Object tag = childAt.getTag(R.id.srl_tag);
                if ("fixed".equals(tag) || "fixed-bottom".equals(tag)) {
                    return false;
                }
                pointF.offset(pointF2.x, pointF2.y);
                boolean canRefresh = canRefresh(childAt, pointF);
                pointF.offset(-pointF2.x, -pointF2.y);
                return canRefresh;
            }
        }
        return true;
    }

    public static boolean canLoadMore(View view, PointF pointF, boolean z) {
        if (view.canScrollVertically(1) && view.getVisibility() == 0) {
            return false;
        }
        if ((view instanceof ViewGroup) && pointF != null && !isScrollableView(view)) {
            ViewGroup viewGroup = (ViewGroup) view;
            PointF pointF2 = new PointF();
            for (int childCount = viewGroup.getChildCount(); childCount > 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount - 1);
                if (isTransformedTouchPointInView(viewGroup, childAt, pointF.x, pointF.y, pointF2)) {
                    Object tag = childAt.getTag(R.id.srl_tag);
                    if ("fixed".equals(tag) || "fixed-top".equals(tag)) {
                        return false;
                    }
                    pointF.offset(pointF2.x, pointF2.y);
                    boolean canLoadMore = canLoadMore(childAt, pointF, z);
                    pointF.offset(-pointF2.x, -pointF2.y);
                    return canLoadMore;
                }
            }
        }
        if (z || view.canScrollVertically(-1)) {
            return true;
        }
        return false;
    }

    public static boolean isTransformedTouchPointInView(View view, View view2, float f, float f2, PointF pointF) {
        if (view2.getVisibility() != 0) {
            return false;
        }
        float[] fArr = {f, f2};
        fArr[0] = ((float) (view.getScrollX() - view2.getLeft())) + f;
        float scrollY = fArr[1] + ((float) (view.getScrollY() - view2.getTop()));
        fArr[1] = scrollY;
        float f3 = fArr[0];
        boolean z = f3 >= 0.0f && scrollY >= 0.0f && f3 < ((float) view2.getWidth()) && fArr[1] < ((float) view2.getHeight());
        if (z && pointF != null) {
            pointF.set(fArr[0] - f, fArr[1] - f2);
        }
        return z;
    }

    static {
        float viscousFluid = 1.0f / viscousFluid(1.0f);
        VISCOUS_FLUID_NORMALIZE = viscousFluid;
        VISCOUS_FLUID_OFFSET = 1.0f - (viscousFluid * viscousFluid(1.0f));
    }

    public static int dp2px(float f) {
        return (int) ((f * density) + 0.5f);
    }

    public static float px2dp(int i) {
        return ((float) i) / density;
    }

    private static float viscousFluid(float f) {
        float f2 = f * VISCOUS_FLUID_SCALE;
        if (f2 < 1.0f) {
            return f2 - (1.0f - ((float) Math.exp((double) (-f2))));
        }
        return 0.36787945f + ((1.0f - ((float) Math.exp((double) (1.0f - f2)))) * 0.63212055f);
    }

    public float getInterpolation(float f) {
        if (this.type == INTERPOLATOR_DECELERATE) {
            float f2 = 1.0f - f;
            return 1.0f - (f2 * f2);
        }
        float viscousFluid = VISCOUS_FLUID_NORMALIZE * viscousFluid(f);
        return viscousFluid > 0.0f ? viscousFluid + VISCOUS_FLUID_OFFSET : viscousFluid;
    }
}
