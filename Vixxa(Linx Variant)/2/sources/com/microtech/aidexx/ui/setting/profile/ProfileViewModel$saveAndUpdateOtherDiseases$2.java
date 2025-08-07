package com.microtech.aidexx.ui.setting.profile;

import com.microtech.aidexx.common.net.entity.MenuEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2", f = "ProfileViewModel.kt", i = {0, 0, 1, 2}, l = {122, 141, 144, 148}, m = "invokeSuspend", n = {"$this$callbackFlow", "isSaveSucc", "$this$callbackFlow", "$this$callbackFlow"}, s = {"L$0", "L$1", "L$0", "L$0"})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$saveAndUpdateOtherDiseases$2 extends SuspendLambda implements Function2<ProducerScope<? super Pair<? extends Integer, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<MenuEntity> $checkedList;
    final /* synthetic */ List<MenuEntity> $newPresetList;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileViewModel$saveAndUpdateOtherDiseases$2(List<MenuEntity> list, ProfileViewModel profileViewModel, List<MenuEntity> list2, Continuation<? super ProfileViewModel$saveAndUpdateOtherDiseases$2> continuation) {
        super(2, continuation);
        this.$newPresetList = list;
        this.this$0 = profileViewModel;
        this.$checkedList = list2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$saveAndUpdateOtherDiseases$2 profileViewModel$saveAndUpdateOtherDiseases$2 = new ProfileViewModel$saveAndUpdateOtherDiseases$2(this.$newPresetList, this.this$0, this.$checkedList, continuation);
        profileViewModel$saveAndUpdateOtherDiseases$2.L$0 = obj;
        return profileViewModel$saveAndUpdateOtherDiseases$2;
    }

    public final Object invoke(ProducerScope<? super Pair<Integer, String>> producerScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$saveAndUpdateOtherDiseases$2) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: kotlinx.coroutines.channels.ProducerScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01d9 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r33) {
        /*
            r32 = this;
            r0 = r32
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L_0x0047
            if (r2 == r7) goto L_0x0039
            if (r2 == r5) goto L_0x002d
            if (r2 == r4) goto L_0x0024
            if (r2 != r3) goto L_0x001c
            kotlin.ResultKt.throwOnFailure(r33)
            goto L_0x01da
        L_0x001c:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0024:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r33)
            goto L_0x01c9
        L_0x002d:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r2 = (kotlinx.coroutines.channels.ProducerScope) r2
            kotlin.ResultKt.throwOnFailure(r33)
            r8 = r2
            r2 = r33
            goto L_0x01b1
        L_0x0039:
            java.lang.Object r2 = r0.L$1
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.ResultKt.throwOnFailure(r33)
            r9 = r33
            goto L_0x00a0
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r33)
            java.lang.Object r2 = r0.L$0
            r8 = r2
            kotlinx.coroutines.channels.ProducerScope r8 = (kotlinx.coroutines.channels.ProducerScope) r8
            kotlin.jvm.internal.Ref$BooleanRef r2 = new kotlin.jvm.internal.Ref$BooleanRef
            r2.<init>()
            r2.element = r7
            java.util.List<com.microtech.aidexx.common.net.entity.MenuEntity> r9 = r0.$newPresetList
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x0149
            r9 = 0
            r2.element = r9
            java.util.List<com.microtech.aidexx.common.net.entity.MenuEntity> r9 = r0.$newPresetList
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r10 = new java.util.ArrayList
            r11 = 10
            int r11 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r11)
            r10.<init>(r11)
            java.util.Collection r10 = (java.util.Collection) r10
            java.util.Iterator r9 = r9.iterator()
        L_0x0078:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x008c
            java.lang.Object r11 = r9.next()
            com.microtech.aidexx.common.net.entity.MenuEntity r11 = (com.microtech.aidexx.common.net.entity.MenuEntity) r11
            java.lang.String r11 = r11.getItemName()
            r10.add(r11)
            goto L_0x0078
        L_0x008c:
            java.util.List r10 = (java.util.List) r10
            com.microtech.aidexx.common.net.repository.AccountRepository r9 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r11 = r0
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
            r0.L$0 = r8
            r0.L$1 = r2
            r0.label = r7
            java.lang.Object r9 = r9.saveOrUpdateOtherDiseasesUsrPreset(r10, r11)
            if (r9 != r1) goto L_0x00a0
            return r1
        L_0x00a0:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
            boolean r10 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r10 == 0) goto L_0x0118
            com.microtech.aidexx.common.net.ApiResult$Success r9 = (com.microtech.aidexx.common.net.ApiResult.Success) r9
            java.lang.Object r9 = r9.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r9 = (com.microtech.aidexx.common.net.entity.BaseResponse) r9
            java.lang.Object r9 = r9.getData()
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x00fe
            java.util.List<com.microtech.aidexx.common.net.entity.MenuEntity> r10 = r0.$checkedList
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x00be:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x00fb
            java.lang.Object r11 = r9.next()
            com.microtech.aidexx.common.net.entity.OtherDiseasesEntity r11 = (com.microtech.aidexx.common.net.entity.OtherDiseasesEntity) r11
            r12 = r10
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            java.util.Iterator r12 = r12.iterator()
        L_0x00d1:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x00ed
            java.lang.Object r13 = r12.next()
            r14 = r13
            com.microtech.aidexx.common.net.entity.MenuEntity r14 = (com.microtech.aidexx.common.net.entity.MenuEntity) r14
            java.lang.String r15 = r11.getName()
            java.lang.String r14 = r14.getDisplayName()
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r14)
            if (r14 == 0) goto L_0x00d1
            goto L_0x00ee
        L_0x00ed:
            r13 = r6
        L_0x00ee:
            com.microtech.aidexx.common.net.entity.MenuEntity r13 = (com.microtech.aidexx.common.net.entity.MenuEntity) r13
            if (r13 != 0) goto L_0x00f3
            goto L_0x00be
        L_0x00f3:
            java.lang.String r11 = r11.getOtherDiseasesId()
            r13.setDictionaryId(r11)
            goto L_0x00be
        L_0x00fb:
            r2.element = r7
            goto L_0x0149
        L_0x00fe:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            com.microtech.aidexx.AidexxApp r10 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r11 = com.microtech.aidexx.R.string.com_network_failure
            java.lang.String r10 = r10.getString(r11)
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            java.lang.Object r9 = r8.m1894trySendJP2dKIU(r9)
            kotlinx.coroutines.channels.ChannelResult.m1870boximpl(r9)
            goto L_0x0149
        L_0x0118:
            boolean r10 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r10 == 0) goto L_0x0149
            com.microtech.aidexx.common.net.ApiResult$Failure r9 = (com.microtech.aidexx.common.net.ApiResult.Failure) r9
            boolean r10 = r9.isBizFail()
            if (r10 == 0) goto L_0x0134
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.String r9 = r9.getMsg()
            kotlin.Pair r9 = kotlin.TuplesKt.to(r10, r9)
            r8.m1894trySendJP2dKIU(r9)
            goto L_0x0149
        L_0x0134:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            com.microtech.aidexx.AidexxApp r10 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r11 = com.microtech.aidexx.R.string.com_network_failure
            java.lang.String r10 = r10.getString(r11)
            kotlin.Pair r9 = kotlin.TuplesKt.to(r9, r10)
            r8.m1894trySendJP2dKIU(r9)
        L_0x0149:
            boolean r2 = r2.element
            if (r2 == 0) goto L_0x01ca
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel r9 = r0.this$0
            java.util.List<com.microtech.aidexx.common.net.entity.MenuEntity> r2 = r0.$checkedList
            r10 = r2
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.lang.String r2 = ","
            r11 = r2
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2$2 r12 = com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2.AnonymousClass2.INSTANCE
            r16 = r12
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            r17 = 30
            r18 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            java.lang.String r24 = kotlin.collections.CollectionsKt.joinToString$default(r10, r11, r12, r13, r14, r15, r16, r17, r18)
            java.util.List<com.microtech.aidexx.common.net.entity.MenuEntity> r10 = r0.$checkedList
            r11 = r10
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            r12 = r2
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2$3 r2 = com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2.AnonymousClass3.INSTANCE
            r17 = r2
            kotlin.jvm.functions.Function1 r17 = (kotlin.jvm.functions.Function1) r17
            r18 = 30
            r19 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            java.lang.String r25 = kotlin.collections.CollectionsKt.joinToString$default(r11, r12, r13, r14, r15, r16, r17, r18, r19)
            r29 = r0
            kotlin.coroutines.Continuation r29 = (kotlin.coroutines.Continuation) r29
            r0.L$0 = r8
            r0.L$1 = r6
            r0.label = r5
            r10 = 0
            r11 = 0
            r12 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 475135(0x73fff, float:6.65806E-40)
            r31 = 0
            java.lang.Object r2 = com.microtech.aidexx.ui.setting.profile.ProfileViewModel.modifyProfileInfo$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31)
            if (r2 != r1) goto L_0x01b1
            return r1
        L_0x01b1:
            kotlinx.coroutines.flow.Flow r2 = (kotlinx.coroutines.flow.Flow) r2
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2$4 r5 = new com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2$4
            r5.<init>(r8, r6)
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r9 = r0
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r0.L$0 = r8
            r0.label = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.collectLatest(r2, r5, r9)
            if (r2 != r1) goto L_0x01c8
            return r1
        L_0x01c8:
            r2 = r8
        L_0x01c9:
            r8 = r2
        L_0x01ca:
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r2 = kotlinx.coroutines.channels.ProduceKt.awaitClose$default(r8, r6, r2, r7, r6)
            if (r2 != r1) goto L_0x01da
            return r1
        L_0x01da:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel$saveAndUpdateOtherDiseases$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
