package com.microtech.aidexx.ui.main.trend;

import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.NetUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
final class TrendsFragment$onClick$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ TrendsFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TrendsFragment$onClick$2(TrendsFragment trendsFragment) {
        super(0);
        this.this$0 = trendsFragment;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.trend.TrendsFragment$onClick$2$1", f = "TrendsFragment.kt", i = {}, l = {534, 539, 540}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.trend.TrendsFragment$onClick$2$1  reason: invalid class name */
    /* compiled from: TrendsFragment.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(trendsFragment, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x008d A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 1
                r4 = 2
                if (r1 == 0) goto L_0x0026
                if (r1 == r3) goto L_0x0022
                if (r1 == r4) goto L_0x001e
                if (r1 != r2) goto L_0x0016
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x00a8
            L_0x0016:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001e:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0080
            L_0x0022:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L_0x0037
            L_0x0026:
                kotlin.ResultKt.throwOnFailure(r6)
                com.microtech.aidexx.common.net.repository.AccountRepository r6 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r3
                java.lang.Object r6 = r6.getUserInfo(r1)
                if (r6 != r0) goto L_0x0037
                return r0
            L_0x0037:
                com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
                boolean r1 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
                if (r1 == 0) goto L_0x0096
                com.microtech.aidexx.common.net.ApiResult$Success r6 = (com.microtech.aidexx.common.net.ApiResult.Success) r6
                java.lang.Object r1 = r6.getResult()
                com.microtech.aidexx.common.net.entity.BaseResponse r1 = (com.microtech.aidexx.common.net.entity.BaseResponse) r1
                java.lang.Object r1 = r1.getData()
                com.microtech.aidexx.db.entity.UserEntity r1 = (com.microtech.aidexx.db.entity.UserEntity) r1
                r3 = 0
                if (r1 == 0) goto L_0x0053
                java.lang.String r1 = r1.getUserId()
                goto L_0x0054
            L_0x0053:
                r1 = r3
            L_0x0054:
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                if (r1 == 0) goto L_0x008e
                int r1 = r1.length()
                if (r1 != 0) goto L_0x005f
                goto L_0x008e
            L_0x005f:
                com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                com.microtech.aidexx.common.user.UserInfoManager r1 = r1.instance()
                java.lang.Object r6 = r6.getResult()
                com.microtech.aidexx.common.net.entity.BaseResponse r6 = (com.microtech.aidexx.common.net.entity.BaseResponse) r6
                java.lang.Object r6 = r6.getData()
                kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
                com.microtech.aidexx.db.entity.UserEntity r6 = (com.microtech.aidexx.db.entity.UserEntity) r6
                r3 = r5
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r5.label = r4
                java.lang.Object r6 = r1.refreshUserInfo(r6, r3)
                if (r6 != r0) goto L_0x0080
                return r0
            L_0x0080:
                com.microtech.aidexx.ui.main.trend.TrendsFragment r6 = r2
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = r6.genAgp(r1)
                if (r6 != r0) goto L_0x00a8
                return r0
            L_0x008e:
                com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
                java.lang.String r0 = "刷新用户信息接口返回的userid为空"
                com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r6, r0, r3, r4, r3)
                goto L_0x00a8
            L_0x0096:
                com.microtech.aidexx.AidexxApp r6 = com.microtech.aidexx.common.ExtendsKt.getContext()
                int r0 = com.microtech.aidexx.R.string.com_network_failure
                java.lang.String r6 = r6.getString(r0)
                java.lang.String r0 = "getString(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
                com.microtech.aidexx.common.ExtendsKt.toast(r6)
            L_0x00a8:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.trend.TrendsFragment$onClick$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final void invoke() {
        if (NetUtil.isNetAvailable(this.this$0.getContext())) {
            final TrendsFragment trendsFragment = this.this$0;
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return;
        }
        String string = this.this$0.getResources().getString(R.string.com_network_unused);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        ExtendsKt.toastShort(string);
    }
}
