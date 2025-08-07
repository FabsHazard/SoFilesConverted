package com.microtech.aidexx.ui.setting.share;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ShareFollowListAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ ShareFollowListAdapter f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ ShareFollowListAdapter$$ExternalSyntheticLambda0(Function1 function1, ShareFollowListAdapter shareFollowListAdapter, int i) {
        this.f$0 = function1;
        this.f$1 = shareFollowListAdapter;
        this.f$2 = i;
    }

    public final void onClick(View view) {
        ShareFollowListAdapter.onBindViewHolder$lambda$3$lambda$2$lambda$1(this.f$0, this.f$1, this.f$2, view);
    }
}
