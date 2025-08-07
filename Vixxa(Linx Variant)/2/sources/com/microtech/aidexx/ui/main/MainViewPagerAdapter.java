package com.microtech.aidexx.ui.main;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.microtech.aidexx.ui.main.bg.BgFragment;
import com.microtech.aidexx.ui.main.event.EventFragment;
import com.microtech.aidexx.ui.main.history.HistoryFragment;
import com.microtech.aidexx.ui.main.home.HomeFragment;
import com.microtech.aidexx.ui.main.trend.TrendsFragment;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"J\b\u0010$\u001a\u00020\"H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001d¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/ui/main/MainViewPagerAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "bgFragment", "Lcom/microtech/aidexx/ui/main/bg/BgFragment;", "getBgFragment", "()Lcom/microtech/aidexx/ui/main/bg/BgFragment;", "bgFragment$delegate", "Lkotlin/Lazy;", "eventFragment", "Lcom/microtech/aidexx/ui/main/event/EventFragment;", "getEventFragment", "()Lcom/microtech/aidexx/ui/main/event/EventFragment;", "eventFragment$delegate", "historyFragment", "Lcom/microtech/aidexx/ui/main/history/HistoryFragment;", "getHistoryFragment", "()Lcom/microtech/aidexx/ui/main/history/HistoryFragment;", "historyFragment$delegate", "homeFragment", "Lcom/microtech/aidexx/ui/main/home/HomeFragment;", "getHomeFragment", "()Lcom/microtech/aidexx/ui/main/home/HomeFragment;", "homeFragment$delegate", "trendFragment", "Lcom/microtech/aidexx/ui/main/trend/TrendsFragment;", "getTrendFragment", "()Lcom/microtech/aidexx/ui/main/trend/TrendsFragment;", "trendFragment$delegate", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getItem", "getItemCount", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainViewPagerAdapter.kt */
public final class MainViewPagerAdapter extends FragmentStateAdapter {
    private final Lazy bgFragment$delegate = LazyKt.lazy(MainViewPagerAdapter$bgFragment$2.INSTANCE);
    private final Lazy eventFragment$delegate = LazyKt.lazy(MainViewPagerAdapter$eventFragment$2.INSTANCE);
    private final Lazy historyFragment$delegate = LazyKt.lazy(MainViewPagerAdapter$historyFragment$2.INSTANCE);
    private final Lazy homeFragment$delegate = LazyKt.lazy(MainViewPagerAdapter$homeFragment$2.INSTANCE);
    private final Lazy trendFragment$delegate = LazyKt.lazy(MainViewPagerAdapter$trendFragment$2.INSTANCE);

    public int getItemCount() {
        return 5;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
    }

    private final HistoryFragment getHistoryFragment() {
        return (HistoryFragment) this.historyFragment$delegate.getValue();
    }

    private final TrendsFragment getTrendFragment() {
        return (TrendsFragment) this.trendFragment$delegate.getValue();
    }

    private final HomeFragment getHomeFragment() {
        return (HomeFragment) this.homeFragment$delegate.getValue();
    }

    private final BgFragment getBgFragment() {
        return (BgFragment) this.bgFragment$delegate.getValue();
    }

    private final EventFragment getEventFragment() {
        return (EventFragment) this.eventFragment$delegate.getValue();
    }

    public Fragment createFragment(int i) {
        if (i == 0) {
            return getHistoryFragment();
        }
        if (i == 1) {
            return getTrendFragment();
        }
        if (i == 2) {
            return getHomeFragment();
        }
        if (i == 3) {
            return getBgFragment();
        }
        if (i != 4) {
            return getHomeFragment();
        }
        return getEventFragment();
    }

    public final Fragment getItem(int i) {
        if (i == 0) {
            return getHistoryFragment();
        }
        if (i == 1) {
            return getTrendFragment();
        }
        if (i == 2) {
            return getHomeFragment();
        }
        if (i == 3) {
            return getBgFragment();
        }
        if (i != 4) {
            return null;
        }
        return getEventFragment();
    }
}
