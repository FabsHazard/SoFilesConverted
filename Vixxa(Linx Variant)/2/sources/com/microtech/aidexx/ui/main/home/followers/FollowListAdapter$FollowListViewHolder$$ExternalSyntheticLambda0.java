package com.microtech.aidexx.ui.main.home.followers;

import android.view.View;
import com.microtech.aidexx.ui.main.home.followers.FollowListAdapter;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FollowListAdapter$FollowListViewHolder$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ ShareUserInfo f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ FollowListAdapter$FollowListViewHolder$$ExternalSyntheticLambda0(ShareUserInfo shareUserInfo, Function0 function0) {
        this.f$0 = shareUserInfo;
        this.f$1 = function0;
    }

    public final void onClick(View view) {
        FollowListAdapter.FollowListViewHolder.bindData$lambda$2$lambda$1(this.f$0, this.f$1, view);
    }
}
