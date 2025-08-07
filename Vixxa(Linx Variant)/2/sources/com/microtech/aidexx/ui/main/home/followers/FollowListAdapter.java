package com.microtech.aidexx.ui.main.home.followers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.LayoutFollowListItemBinding;
import com.microtech.aidexx.ui.main.home.HomeBackGroundSelector;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.ui.setting.share.UserTrendInfo;
import com.microtech.aidexx.utils.UnitManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\rH\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0016\u0010\u001f\u001a\u00020\u00122\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\n0!H\u0007J\u0006\u0010\"\u001a\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000RL\u0010\u000b\u001a4\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/followers/FollowListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/microtech/aidexx/ui/main/home/followers/FollowListAdapter$FollowListViewHolder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "followList", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "onSelectChange", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "pos", "entity", "", "getOnSelectChange", "()Lkotlin/jvm/functions/Function2;", "setOnSelectChange", "(Lkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshData", "list", "", "unselectAll", "FollowListViewHolder", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FollowListAdapter.kt */
public final class FollowListAdapter extends RecyclerView.Adapter<FollowListViewHolder> {
    private final Context context;
    /* access modifiers changed from: private */
    public final List<ShareUserInfo> followList = new ArrayList();
    private Function2<? super Integer, ? super ShareUserInfo, Unit> onSelectChange;

    public final Context getContext() {
        return this.context;
    }

    public FollowListAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Function2<Integer, ShareUserInfo, Unit> getOnSelectChange() {
        return this.onSelectChange;
    }

    public final void setOnSelectChange(Function2<? super Integer, ? super ShareUserInfo, Unit> function2) {
        this.onSelectChange = function2;
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/followers/FollowListAdapter$FollowListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vb", "Lcom/microtech/aidexx/databinding/LayoutFollowListItemBinding;", "(Lcom/microtech/aidexx/databinding/LayoutFollowListItemBinding;)V", "bindData", "", "position", "", "user", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "changeToThisCallback", "Lkotlin/Function0;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: FollowListAdapter.kt */
    public static final class FollowListViewHolder extends RecyclerView.ViewHolder {
        private final LayoutFollowListItemBinding vb;

        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* compiled from: FollowListAdapter.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            static {
                /*
                    com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend[] r0 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.FAST_UP     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.UP     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.microtech.aidexx.ble.device.model.DeviceModel$GlucoseTrend r1 = com.microtech.aidexx.ble.device.model.DeviceModel.GlucoseTrend.SLOW_UP     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.followers.FollowListAdapter.FollowListViewHolder.WhenMappings.<clinit>():void");
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FollowListViewHolder(LayoutFollowListItemBinding layoutFollowListItemBinding) {
            super(layoutFollowListItemBinding.getRoot());
            Intrinsics.checkNotNullParameter(layoutFollowListItemBinding, "vb");
            this.vb = layoutFollowListItemBinding;
        }

        public final void bindData(int i, ShareUserInfo shareUserInfo, Function0<Unit> function0) {
            UserTrendInfo userTrend;
            Intrinsics.checkNotNullParameter(shareUserInfo, "user");
            Intrinsics.checkNotNullParameter(function0, "changeToThisCallback");
            LayoutFollowListItemBinding layoutFollowListItemBinding = this.vb;
            Context context = layoutFollowListItemBinding.getRoot().getContext();
            layoutFollowListItemBinding.userName.setText(shareUserInfo.getDisplayName());
            String dataProviderId = shareUserInfo.getDataProviderId();
            ShareUserInfo shareUserInfo2 = UserInfoManager.Companion.getShareUserInfo();
            DeviceModel.GlucoseLevel glucoseLevel = null;
            shareUserInfo.setLooking(Intrinsics.areEqual((Object) dataProviderId, (Object) shareUserInfo2 != null ? shareUserInfo2.getDataProviderId() : null));
            ImageView imageView = layoutFollowListItemBinding.ivSelected;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivSelected");
            boolean z = false;
            imageView.setVisibility(shareUserInfo.isLooking() ? 0 : 8);
            String sensorStatusDesc = shareUserInfo.getSensorStatusDesc();
            String latestValueTimeStr = shareUserInfo.getLatestValueTimeStr();
            if (!Intrinsics.areEqual((Object) latestValueTimeStr, (Object) ExtendsKt.getContext().getString(R.string.com_unknown)) && sensorStatusDesc == null) {
                z = true;
            }
            String glucoseValue = z ? shareUserInfo.getGlucoseValue() : null;
            layoutFollowListItemBinding.tvGlucoseValue.setText(glucoseValue != null ? glucoseValue : context.getString(R.string.com_unknown));
            TextView textView = layoutFollowListItemBinding.tvUnit;
            Intrinsics.checkNotNullExpressionValue(textView, "tvUnit");
            textView.setVisibility(8);
            TextView textView2 = layoutFollowListItemBinding.tvUnit;
            Intrinsics.checkNotNullExpressionValue(textView2, "tvUnit");
            if (textView2.getVisibility() == 0) {
                layoutFollowListItemBinding.tvUnit.setText(UnitManager.INSTANCE.getDisplayUnit());
            }
            layoutFollowListItemBinding.latestValueTime.setText(sensorStatusDesc != null ? sensorStatusDesc : latestValueTimeStr);
            layoutFollowListItemBinding.leftTime.setText(shareUserInfo.getSensorLeftTime());
            UserTrendInfo userTrend2 = shareUserInfo.getUserTrend();
            if (userTrend2 != null) {
                View view = layoutFollowListItemBinding.bgPanel;
                DeviceModel.GlucoseTrend glucoseTrend = userTrend2.getGlucoseTrend();
                int i2 = glucoseTrend == null ? -1 : WhenMappings.$EnumSwitchMapping$0[glucoseTrend.ordinal()];
                view.setRotation((i2 == 1 || i2 == 2) ? 180.0f : i2 != 3 ? 0.0f : -90.0f);
            }
            View view2 = layoutFollowListItemBinding.bgPanel;
            HomeBackGroundSelector instance = HomeBackGroundSelector.Companion.instance();
            DeviceModel.GlucoseTrend glucoseTrend2 = (!z || (userTrend = shareUserInfo.getUserTrend()) == null) ? null : userTrend.getGlucoseTrend();
            if (z) {
                glucoseLevel = shareUserInfo.getGlucoseLevel();
            }
            view2.setBackgroundResource(instance.getBgForTrend(glucoseTrend2, glucoseLevel));
            layoutFollowListItemBinding.listFollowRoot.setOnClickListener(new FollowListAdapter$FollowListViewHolder$$ExternalSyntheticLambda0(shareUserInfo, function0));
        }

        /* access modifiers changed from: private */
        public static final void bindData$lambda$2$lambda$1(ShareUserInfo shareUserInfo, Function0 function0, View view) {
            Intrinsics.checkNotNullParameter(shareUserInfo, "$user");
            Intrinsics.checkNotNullParameter(function0, "$changeToThisCallback");
            if (!shareUserInfo.isLooking()) {
                function0.invoke();
            }
        }
    }

    public FollowListViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        LayoutFollowListItemBinding inflate = LayoutFollowListItemBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new FollowListViewHolder(inflate);
    }

    public void onBindViewHolder(FollowListViewHolder followListViewHolder, int i) {
        Intrinsics.checkNotNullParameter(followListViewHolder, "holder");
        followListViewHolder.bindData(i, this.followList.get(i), new FollowListAdapter$onBindViewHolder$1(this, i));
    }

    public final void refreshData(List<ShareUserInfo> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.followList.clear();
        List<ShareUserInfo> list2 = this.followList;
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (!((ShareUserInfo) next).getHide()) {
                arrayList.add(next);
            }
        }
        list2.addAll((List) arrayList);
        notifyDataSetChanged();
    }

    public final void unselectAll() {
        int i = 0;
        for (ShareUserInfo looking : this.followList) {
            looking.setLooking(false);
            notifyItemChanged(i);
            i++;
        }
    }

    public int getItemCount() {
        return this.followList.size();
    }
}
