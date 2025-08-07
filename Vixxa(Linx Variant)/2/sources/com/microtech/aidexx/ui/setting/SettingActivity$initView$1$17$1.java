package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.databinding.ActivitySettingBinding;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.SettingActivity$initView$1$17$1", f = "SettingActivity.kt", i = {1, 1, 1}, l = {228, 239}, m = "invokeSuspend", n = {"supportLanguages", "selectIndex", "languageStrList"}, s = {"L$2", "L$3", "L$4"})
/* compiled from: SettingActivity.kt */
final class SettingActivity$initView$1$17$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivitySettingBinding $this_apply;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ SettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$initView$1$17$1(SettingActivity settingActivity, ActivitySettingBinding activitySettingBinding, Continuation<? super SettingActivity$initView$1$17$1> continuation) {
        super(2, continuation);
        this.this$0 = settingActivity;
        this.$this_apply = activitySettingBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingActivity$initView$1$17$1(this.this$0, this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingActivity$initView$1$17$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0033
            if (r1 == r3) goto L_0x002f
            if (r1 != r2) goto L_0x0027
            java.lang.Object r0 = r9.L$4
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r1 = r9.L$3
            kotlin.jvm.internal.Ref$IntRef r1 = (kotlin.jvm.internal.Ref.IntRef) r1
            java.lang.Object r2 = r9.L$2
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r3 = r9.L$1
            com.microtech.aidexx.databinding.ActivitySettingBinding r3 = (com.microtech.aidexx.databinding.ActivitySettingBinding) r3
            java.lang.Object r4 = r9.L$0
            com.microtech.aidexx.ui.setting.SettingActivity r4 = (com.microtech.aidexx.ui.setting.SettingActivity) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a4
        L_0x0027:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0050
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CoroutineDispatcher r10 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.coroutines.CoroutineContext r10 = (kotlin.coroutines.CoroutineContext) r10
            com.microtech.aidexx.ui.setting.SettingActivity$initView$1$17$1$1 r1 = new com.microtech.aidexx.ui.setting.SettingActivity$initView$1$17$1$1
            r4 = 0
            r1.<init>(r4)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r4 = r9
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r9.label = r3
            java.lang.Object r10 = kotlinx.coroutines.BuildersKt.withContext(r10, r1, r4)
            if (r10 != r0) goto L_0x0050
            return r0
        L_0x0050:
            com.microtech.aidexx.ui.setting.SettingActivity r4 = r9.this$0
            com.microtech.aidexx.databinding.ActivitySettingBinding r3 = r9.$this_apply
            java.util.List r10 = (java.util.List) r10
            r1 = r10
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.List r5 = (java.util.List) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x0064:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0086
            java.lang.Object r6 = r1.next()
            com.microtech.aidexx.db.entity.LanguageConfEntity r6 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r6
            java.lang.String r7 = r6.getCode()
            if (r7 == 0) goto L_0x0064
            java.lang.String r6 = r6.getName()
            if (r6 != 0) goto L_0x007d
            goto L_0x007e
        L_0x007d:
            r7 = r6
        L_0x007e:
            boolean r6 = r5.add(r7)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            goto L_0x0064
        L_0x0086:
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            com.microtech.aidexx.data.resource.LanguageResourceManager r6 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE
            r9.L$0 = r4
            r9.L$1 = r3
            r9.L$2 = r10
            r9.L$3 = r1
            r9.L$4 = r5
            r9.label = r2
            java.lang.Object r2 = r6.getCurLanguageConfEntity(r9)
            if (r2 != r0) goto L_0x00a0
            return r0
        L_0x00a0:
            r0 = r5
            r8 = r2
            r2 = r10
            r10 = r8
        L_0x00a4:
            com.microtech.aidexx.db.entity.LanguageConfEntity r10 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r10
            if (r10 == 0) goto L_0x00cb
            java.lang.String r5 = r10.getName()
            int r5 = kotlin.collections.CollectionsKt.indexOf(r0, r5)
            r1.element = r5
            int r5 = r1.element
            r6 = -1
            if (r5 != r6) goto L_0x00cb
            java.lang.String r5 = r10.getCode()
            int r5 = kotlin.collections.CollectionsKt.indexOf(r0, r5)
            if (r5 == r6) goto L_0x00cb
            java.lang.String r10 = r10.getCode()
            int r10 = kotlin.collections.CollectionsKt.indexOf(r0, r10)
            r1.element = r10
        L_0x00cb:
            com.microtech.aidexx.views.dialog.Dialogs$Picker r10 = new com.microtech.aidexx.views.dialog.Dialogs$Picker
            r5 = r4
            android.content.Context r5 = (android.content.Context) r5
            r10.<init>(r5)
            int r1 = r1.element
            com.microtech.aidexx.ui.setting.SettingActivity$initView$1$17$1$2$2 r5 = new com.microtech.aidexx.ui.setting.SettingActivity$initView$1$17$1$2$2
            r5.<init>(r2, r4, r3, r0)
            kotlin.jvm.functions.Function1 r5 = (kotlin.jvm.functions.Function1) r5
            r10.singlePick(r0, r1, r5)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.SettingActivity$initView$1$17$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
