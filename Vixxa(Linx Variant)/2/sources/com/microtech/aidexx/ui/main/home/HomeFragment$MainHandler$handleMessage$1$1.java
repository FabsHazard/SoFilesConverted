package com.microtech.aidexx.ui.main.home;

import com.microtech.aidexx.ui.main.MainActivity;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.microtech.aidexx.utils.permission.PermissionsUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: HomeFragment.kt */
final class HomeFragment$MainHandler$handleMessage$1$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ MainActivity $it;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HomeFragment$MainHandler$handleMessage$1$1(MainActivity mainActivity) {
        super(0);
        this.$it = mainActivity;
    }

    public final void invoke() {
        PermissionsUtil permissionsUtil = PermissionsUtil.INSTANCE;
        MainActivity mainActivity = this.$it;
        Intrinsics.checkNotNullExpressionValue(mainActivity, "$it");
        PermissionsUtil.requestPermissions$default(permissionsUtil, mainActivity, PermissionGroups.INSTANCE.getStorage(), (Function0) null, 4, (Object) null);
    }
}
