package com.microtech.aidexx.ui.main.home;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "state", "Lkotlin/Pair;", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$initView$2 extends Lambda implements Function1<Pair<? extends Integer, ? extends Integer>, Unit> {
    final /* synthetic */ HomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$initView$2(HomeFragment homeFragment) {
        super(1);
        this.this$0 = homeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Pair<Integer, Integer>) (Pair) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Pair<Integer, Integer> pair) {
        Intrinsics.checkNotNullParameter(pair, "state");
        this.this$0.showConnectState(pair);
    }
}
