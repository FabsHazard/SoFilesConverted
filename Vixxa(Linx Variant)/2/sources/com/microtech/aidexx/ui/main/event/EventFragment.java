package com.microtech.aidexx.ui.main.event;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.base.PageActions;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.EventUnitManager;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.databinding.FragmentEventBinding;
import com.microtech.aidexx.ui.main.event.viewmodels.BaseEventViewModel;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.tab.ScrollTab;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u001b\u001cB\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0004\u0018\u0001`\u000bH\u0016J\u0014\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentEventBinding;", "()V", "mTitles", "", "", "canLeave", "Lkotlin/Function0;", "", "Lcom/microtech/aidexx/base/AfterLeaveCallback;", "needConfirmLeave", "", "confirmCallback", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "EventPageAdapter", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventFragment.kt */
public final class EventFragment extends BaseFragment<BaseViewModel, FragmentEventBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "EventFragment";
    private List<String> mTitles;

    @JvmStatic
    public static final EventFragment newInstance() {
        return Companion.newInstance();
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        String string = getString(R.string.event_type_food);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.event_type_exercise);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.event_type_medicine);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = getString(R.string.event_type_insulin);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.event_type_other);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        this.mTitles = CollectionsKt.listOf(string, string2, string3, string4, string5);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseEventViewModel.Companion.setPeriodMgr(EventTimeSlotManager.Companion.instance());
        FragmentEventBinding inflate = FragmentEventBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ((FragmentEventBinding) getBinding()).layoutActionbar.setPadding(0, ExtendsKt.getStatusBarHeight() + ExtendsKt.dp2px((Number) 10), 0, 0);
        FragmentEventBinding fragmentEventBinding = (FragmentEventBinding) getBinding();
        ScrollTab scrollTab = fragmentEventBinding.stIndicator;
        List<String> list = this.mTitles;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitles");
            list = null;
        }
        scrollTab.setTitles(list);
        if ("ar".equals(LanguageResourceManager.INSTANCE.getCurLanguageTag())) {
            fragmentEventBinding.stIndicator.setPubStabAvag(true);
        }
        fragmentEventBinding.stIndicator.setOnTabListener(new EventFragment$onCreateView$1$1(this, fragmentEventBinding));
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity(...)");
        fragmentEventBinding.vpEventContent.setAdapter(new EventPageAdapter(requireActivity));
        fragmentEventBinding.vpEventContent.setUserInputEnabled(false);
        LinearLayout root = ((FragmentEventBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onResume() {
        BaseEventFragment<?, ?> fragmentByPosition;
        super.onResume();
        EventUnitManager.update$default(EventUnitManager.INSTANCE, (CoroutineScope) null, 1, (Object) null);
        ViewPager2 viewPager2 = ((FragmentEventBinding) getBinding()).vpEventContent;
        EventPageAdapter eventPageAdapter = (EventPageAdapter) viewPager2.getAdapter();
        if (eventPageAdapter != null && (fragmentByPosition = eventPageAdapter.getFragmentByPosition(viewPager2.getCurrentItem())) != null) {
            fragmentByPosition.onRealResume(false);
        }
    }

    public final boolean needConfirmLeave(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "confirmCallback");
        Function0<Unit> canLeave = canLeave();
        if (canLeave != null) {
            Dialogs dialogs = Dialogs.INSTANCE;
            FragmentActivity activity = getActivity();
            Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
            Dialogs.showWhether$default(dialogs, (AppCompatActivity) activity, (String) null, getString(R.string.event_unsaved), new EventFragment$needConfirmLeave$1$1(canLeave, function0), (Function0) null, (String) null, (String) null, (String) null, 0, 498, (Object) null);
            return true;
        }
        EventFragment eventFragment = this;
        return false;
    }

    public Function0<Unit> canLeave() {
        try {
            if (!isBindingInit()) {
                return null;
            }
            ViewPager2 viewPager2 = ((FragmentEventBinding) getBinding()).vpEventContent;
            EventPageAdapter eventPageAdapter = (EventPageAdapter) viewPager2.getAdapter();
            PageActions fragmentByPosition = eventPageAdapter != null ? eventPageAdapter.getFragmentByPosition(viewPager2.getCurrentItem()) : null;
            if (fragmentByPosition != null) {
                return fragmentByPosition.canLeave();
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u000bH\u0016R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventFragment$EventPageAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragmentActivity", "Landroidx/fragment/app/FragmentActivity;", "(Landroidx/fragment/app/FragmentActivity;)V", "mFragments", "", "Lcom/microtech/aidexx/ui/main/event/BaseEventFragment;", "createFragment", "Landroidx/fragment/app/Fragment;", "position", "", "getFragmentByPosition", "getItemCount", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventFragment.kt */
    public static final class EventPageAdapter extends FragmentStateAdapter {
        private final List<BaseEventFragment<?, ?>> mFragments = CollectionsKt.listOf(new EventDietFragment(), new EventSportFragment(), new EventMedicineFragment(), new EventInsulinFragment(), new EventOthersFragment());

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EventPageAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
            Intrinsics.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        }

        public int getItemCount() {
            return this.mFragments.size();
        }

        public Fragment createFragment(int i) {
            return this.mFragments.get(i);
        }

        public final BaseEventFragment<?, ?> getFragmentByPosition(int i) {
            if (i < 0 || i >= this.mFragments.size()) {
                return null;
            }
            return this.mFragments.get(i);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/ui/main/event/EventFragment$Companion;", "", "()V", "TAG", "", "newInstance", "Lcom/microtech/aidexx/ui/main/event/EventFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final EventFragment newInstance() {
            return new EventFragment();
        }
    }
}
