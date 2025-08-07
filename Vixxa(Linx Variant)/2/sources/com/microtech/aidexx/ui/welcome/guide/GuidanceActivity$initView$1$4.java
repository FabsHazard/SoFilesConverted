package com.microtech.aidexx.ui.welcome.guide;

import android.view.ViewTreeObserver;
import com.microtech.aidexx.databinding.ActivityGuidanceBinding;
import com.microtech.aidexx.ui.welcome.guide.fragment.GuideBaseFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/microtech/aidexx/ui/welcome/guide/GuidanceActivity$initView$1$4", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GuidanceActivity.kt */
public final class GuidanceActivity$initView$1$4 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ ActivityGuidanceBinding $this_apply;
    final /* synthetic */ GuideViewPagerAdapter $viewPagerAdapter;
    final /* synthetic */ GuidanceActivity this$0;

    GuidanceActivity$initView$1$4(GuideViewPagerAdapter guideViewPagerAdapter, ActivityGuidanceBinding activityGuidanceBinding, GuidanceActivity guidanceActivity) {
        this.$viewPagerAdapter = guideViewPagerAdapter;
        this.$this_apply = activityGuidanceBinding;
        this.this$0 = guidanceActivity;
    }

    public void onGlobalLayout() {
        GuideBaseFragment<?, ?> item = this.$viewPagerAdapter.getItem(this.$this_apply.viewpagerGuide.getCurrentItem());
        this.this$0.currentPosition = this.$this_apply.viewpagerGuide.getCurrentItem();
        this.$this_apply.actionbarGuide.setTitle(item != null ? item.getPageName() : null);
        this.$this_apply.viewpagerGuide.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
}
