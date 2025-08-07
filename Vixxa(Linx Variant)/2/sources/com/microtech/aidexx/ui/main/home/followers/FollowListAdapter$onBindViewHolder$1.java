package com.microtech.aidexx.ui.main.home.followers;

import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: FollowListAdapter.kt */
final class FollowListAdapter$onBindViewHolder$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ int $position;
    final /* synthetic */ FollowListAdapter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FollowListAdapter$onBindViewHolder$1(FollowListAdapter followListAdapter, int i) {
        super(0);
        this.this$0 = followListAdapter;
        this.$position = i;
    }

    public final void invoke() {
        Function2<Integer, ShareUserInfo, Unit> onSelectChange = this.this$0.getOnSelectChange();
        if (onSelectChange != null) {
            onSelectChange.invoke(Integer.valueOf(this.$position), this.this$0.followList.get(this.$position));
        }
        for (ShareUserInfo shareUserInfo : this.this$0.followList) {
            shareUserInfo.setLooking(Intrinsics.areEqual((Object) shareUserInfo, this.this$0.followList.get(this.$position)));
        }
        this.this$0.notifyDataSetChanged();
    }
}
