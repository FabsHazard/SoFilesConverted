package com.microtech.aidexx.ui.welcome.guide;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.microtech.aidexx.ui.welcome.guide.fragment.AttentionAlertFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.BgIntroFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.DoNotDisturbFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.GuideBaseFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.HighThresholdSetFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.InsertionFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.LowThresholdSetFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.PermissionCheckFragment;
import com.microtech.aidexx.ui.welcome.guide.fragment.TrendIntroFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0016J\u0018\u00102\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u0001032\u0006\u00100\u001a\u000201J\b\u00104\u001a\u000201H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u001b\u0010$\u001a\u00020%8BX\u0002¢\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b&\u0010'R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\n\u001a\u0004\b+\u0010,¨\u00065"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/GuideViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "attentionAlertFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/AttentionAlertFragment;", "getAttentionAlertFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/AttentionAlertFragment;", "attentionAlertFragment$delegate", "Lkotlin/Lazy;", "bgIntroFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/BgIntroFragment;", "getBgIntroFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/BgIntroFragment;", "bgIntroFragment$delegate", "doNotDisturbFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/DoNotDisturbFragment;", "getDoNotDisturbFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/DoNotDisturbFragment;", "doNotDisturbFragment$delegate", "highThresholdSetFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/HighThresholdSetFragment;", "getHighThresholdSetFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/HighThresholdSetFragment;", "highThresholdSetFragment$delegate", "insertionFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/InsertionFragment;", "getInsertionFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/InsertionFragment;", "insertionFragment$delegate", "lowThresholdSetFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/LowThresholdSetFragment;", "getLowThresholdSetFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/LowThresholdSetFragment;", "lowThresholdSetFragment$delegate", "permissionCheckFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/PermissionCheckFragment;", "getPermissionCheckFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/PermissionCheckFragment;", "permissionCheckFragment$delegate", "trendIntroFragment", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/TrendIntroFragment;", "getTrendIntroFragment", "()Lcom/microtech/aidexx/ui/welcome/guide/fragment/TrendIntroFragment;", "trendIntroFragment$delegate", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItem", "Lcom/microtech/aidexx/ui/welcome/guide/fragment/GuideBaseFragment;", "getItemCount", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GuideViewPagerAdapter.kt */
public final class GuideViewPagerAdapter extends FragmentStateAdapter {
    private final Lazy attentionAlertFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$attentionAlertFragment$2.INSTANCE);
    private final Lazy bgIntroFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$bgIntroFragment$2.INSTANCE);
    private final Lazy doNotDisturbFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$doNotDisturbFragment$2.INSTANCE);
    private final Lazy highThresholdSetFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$highThresholdSetFragment$2.INSTANCE);
    private final Lazy insertionFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$insertionFragment$2.INSTANCE);
    private final Lazy lowThresholdSetFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$lowThresholdSetFragment$2.INSTANCE);
    private final Lazy permissionCheckFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$permissionCheckFragment$2.INSTANCE);
    private final Lazy trendIntroFragment$delegate = LazyKt.lazy(GuideViewPagerAdapter$trendIntroFragment$2.INSTANCE);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GuideViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
    }

    private final PermissionCheckFragment getPermissionCheckFragment() {
        return (PermissionCheckFragment) this.permissionCheckFragment$delegate.getValue();
    }

    private final DoNotDisturbFragment getDoNotDisturbFragment() {
        return (DoNotDisturbFragment) this.doNotDisturbFragment$delegate.getValue();
    }

    private final AttentionAlertFragment getAttentionAlertFragment() {
        return (AttentionAlertFragment) this.attentionAlertFragment$delegate.getValue();
    }

    private final LowThresholdSetFragment getLowThresholdSetFragment() {
        return (LowThresholdSetFragment) this.lowThresholdSetFragment$delegate.getValue();
    }

    private final HighThresholdSetFragment getHighThresholdSetFragment() {
        return (HighThresholdSetFragment) this.highThresholdSetFragment$delegate.getValue();
    }

    private final TrendIntroFragment getTrendIntroFragment() {
        return (TrendIntroFragment) this.trendIntroFragment$delegate.getValue();
    }

    private final BgIntroFragment getBgIntroFragment() {
        return (BgIntroFragment) this.bgIntroFragment$delegate.getValue();
    }

    private final InsertionFragment getInsertionFragment() {
        return (InsertionFragment) this.insertionFragment$delegate.getValue();
    }

    public int getItemCount() {
        return GuidePages.getEntries().size();
    }

    public Fragment createFragment(int i) {
        if (i == GuidePages.PERMISSION_CHECK.ordinal()) {
            return getPermissionCheckFragment();
        }
        if (i == GuidePages.DO_NOT_DISTURB.ordinal()) {
            return getDoNotDisturbFragment();
        }
        if (i == GuidePages.ATTENTION_ALERT.ordinal()) {
            return getAttentionAlertFragment();
        }
        if (i == GuidePages.LOW_THRESHOLD_SET.ordinal()) {
            return getLowThresholdSetFragment();
        }
        if (i == GuidePages.HIGH_THRESHOLD_SET.ordinal()) {
            return getHighThresholdSetFragment();
        }
        if (i == GuidePages.TREND_INTRODUCE.ordinal()) {
            return getTrendIntroFragment();
        }
        if (i == GuidePages.BG_INTRODUCE.ordinal()) {
            return getBgIntroFragment();
        }
        if (i == GuidePages.SENSOR_INSERT.ordinal()) {
            return getInsertionFragment();
        }
        return getPermissionCheckFragment();
    }

    public final GuideBaseFragment<?, ?> getItem(int i) {
        if (i == GuidePages.PERMISSION_CHECK.ordinal()) {
            return getPermissionCheckFragment();
        }
        if (i == GuidePages.DO_NOT_DISTURB.ordinal()) {
            return getDoNotDisturbFragment();
        }
        if (i == GuidePages.ATTENTION_ALERT.ordinal()) {
            return getAttentionAlertFragment();
        }
        if (i == GuidePages.LOW_THRESHOLD_SET.ordinal()) {
            return getLowThresholdSetFragment();
        }
        if (i == GuidePages.HIGH_THRESHOLD_SET.ordinal()) {
            return getHighThresholdSetFragment();
        }
        if (i == GuidePages.TREND_INTRODUCE.ordinal()) {
            return getTrendIntroFragment();
        }
        if (i == GuidePages.BG_INTRODUCE.ordinal()) {
            return getBgIntroFragment();
        }
        if (i == GuidePages.SENSOR_INSERT.ordinal()) {
            return getInsertionFragment();
        }
        return null;
    }
}
