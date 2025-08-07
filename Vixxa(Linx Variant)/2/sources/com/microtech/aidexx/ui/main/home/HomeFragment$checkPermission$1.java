package com.microtech.aidexx.ui.main.home;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$checkPermission$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Ref.BooleanRef $needRequestPermission;
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$checkPermission$1(HomeFragment homeFragment, Ref.BooleanRef booleanRef) {
        super(0);
        this.this$0 = homeFragment;
        this.$needRequestPermission = booleanRef;
    }

    public final void invoke() {
        Handler access$getMHandler$p = this.this$0.mHandler;
        Handler handler = null;
        if (access$getMHandler$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
            access$getMHandler$p = null;
        }
        access$getMHandler$p.removeMessages(2001);
        Handler access$getMHandler$p2 = this.this$0.mHandler;
        if (access$getMHandler$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandler");
        } else {
            handler = access$getMHandler$p2;
        }
        int unused = this.this$0.checkStep;
        handler.sendEmptyMessageDelayed(2001, 3000);
        this.$needRequestPermission.element = true;
    }
}
