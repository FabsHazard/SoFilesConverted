package com.microtech.aidexx.ui.setting.profile;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/microtech/aidexx/ui/setting/profile/DiabetesEnum;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2", f = "ProfileViewModel.kt", i = {1}, l = {153, 156, 173, 177}, m = "invokeSuspend", n = {"$this$flow"}, s = {"L$0"})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$fetchAndSaveAllDiabetes$2 extends SuspendLambda implements Function2<FlowCollector<? super DiabetesEnum>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    ProfileViewModel$fetchAndSaveAllDiabetes$2(Continuation<? super ProfileViewModel$fetchAndSaveAllDiabetes$2> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$fetchAndSaveAllDiabetes$2 profileViewModel$fetchAndSaveAllDiabetes$2 = new ProfileViewModel$fetchAndSaveAllDiabetes$2(continuation);
        profileViewModel$fetchAndSaveAllDiabetes$2.L$0 = obj;
        return profileViewModel$fetchAndSaveAllDiabetes$2;
    }

    public final Object invoke(FlowCollector<? super DiabetesEnum> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$fetchAndSaveAllDiabetes$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0130  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 == r7) goto L_0x002f
            if (r2 == r5) goto L_0x0025
            if (r2 == r4) goto L_0x0020
            if (r2 != r3) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x0142
        L_0x0025:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r18)
            r8 = r18
            goto L_0x0067
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r18)
            goto L_0x0052
        L_0x0033:
            kotlin.ResultKt.throwOnFailure(r18)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            com.microtech.aidexx.AidexxApp r8 = com.microtech.aidexx.common.ExtendsKt.getContext()
            android.content.Context r8 = (android.content.Context) r8
            boolean r8 = com.microtech.aidexx.utils.NetUtil.isNetAvailable(r8)
            if (r8 != 0) goto L_0x0055
            r3 = r0
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r0.label = r7
            java.lang.Object r2 = r2.emit(r6, r3)
            if (r2 != r1) goto L_0x0052
            return r1
        L_0x0052:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0055:
            com.microtech.aidexx.common.net.repository.AccountRepository r8 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r2
            r0.label = r5
            java.lang.String r10 = ""
            java.lang.Object r8 = r8.findAllDictionaryList(r10, r9)
            if (r8 != r1) goto L_0x0067
            return r1
        L_0x0067:
            com.microtech.aidexx.common.net.ApiResult r8 = (com.microtech.aidexx.common.net.ApiResult) r8
            boolean r9 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r9 == 0) goto L_0x0130
            com.microtech.aidexx.common.net.ApiResult$Success r8 = (com.microtech.aidexx.common.net.ApiResult.Success) r8
            java.lang.Object r8 = r8.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r8 = (com.microtech.aidexx.common.net.entity.BaseResponse) r8
            java.lang.Object r8 = r8.getData()
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x0142
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            com.microtech.aidexx.ui.setting.profile.DiabetesEnum r15 = new com.microtech.aidexx.ui.setting.profile.DiabetesEnum
            r14 = 15
            r16 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r9 = r15
            r18 = r15
            r15 = r16
            r9.<init>(r10, r11, r12, r13, r14, r15)
            java.util.Iterator r8 = r8.iterator()
        L_0x0095:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00ce
            java.lang.Object r9 = r8.next()
            com.microtech.aidexx.common.net.entity.MenuEntity r9 = (com.microtech.aidexx.common.net.entity.MenuEntity) r9
            int r10 = r9.getType()
            if (r10 == r7) goto L_0x00c6
            if (r10 == r5) goto L_0x00be
            if (r10 == r4) goto L_0x00b6
            if (r10 == r3) goto L_0x00ae
            goto L_0x0095
        L_0x00ae:
            java.util.List r10 = r18.getOtherDiabetesType()
            r10.add(r9)
            goto L_0x0095
        L_0x00b6:
            java.util.List r10 = r18.getCompsType()
            r10.add(r9)
            goto L_0x0095
        L_0x00be:
            java.util.List r10 = r18.getTreatmentsType()
            r10.add(r9)
            goto L_0x0095
        L_0x00c6:
            java.util.List r10 = r18.getDiabetesType()
            r10.add(r9)
            goto L_0x0095
        L_0x00ce:
            java.util.List r3 = r18.getDiabetesType()
            int r5 = r3.size()
            if (r5 <= r7) goto L_0x00e2
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$1 r5 = new com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$1
            r5.<init>()
            java.util.Comparator r5 = (java.util.Comparator) r5
            kotlin.collections.CollectionsKt.sortWith(r3, r5)
        L_0x00e2:
            java.util.List r3 = r18.getTreatmentsType()
            int r5 = r3.size()
            if (r5 <= r7) goto L_0x00f6
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$2 r5 = new com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$2
            r5.<init>()
            java.util.Comparator r5 = (java.util.Comparator) r5
            kotlin.collections.CollectionsKt.sortWith(r3, r5)
        L_0x00f6:
            java.util.List r3 = r18.getCompsType()
            int r5 = r3.size()
            if (r5 <= r7) goto L_0x010a
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$3 r5 = new com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$3
            r5.<init>()
            java.util.Comparator r5 = (java.util.Comparator) r5
            kotlin.collections.CollectionsKt.sortWith(r3, r5)
        L_0x010a:
            java.util.List r3 = r18.getOtherDiabetesType()
            int r5 = r3.size()
            if (r5 <= r7) goto L_0x011e
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$4 r5 = new com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2$invokeSuspend$lambda$5$$inlined$sortBy$4
            r5.<init>()
            java.util.Comparator r5 = (java.util.Comparator) r5
            kotlin.collections.CollectionsKt.sortWith(r3, r5)
        L_0x011e:
            com.microtech.aidexx.ui.setting.profile.DiabetesEnum$Companion r3 = com.microtech.aidexx.ui.setting.profile.DiabetesEnum.Companion
            r5 = r18
            r3.saveDiabetesEnum(r5)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r2 = r2.emit(r5, r0)
            if (r2 != r1) goto L_0x0142
            return r1
        L_0x0130:
            boolean r4 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r4 == 0) goto L_0x0142
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r0.L$0 = r6
            r0.label = r3
            java.lang.Object r2 = r2.emit(r6, r4)
            if (r2 != r1) goto L_0x0142
            return r1
        L_0x0142:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel$fetchAndSaveAllDiabetes$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
