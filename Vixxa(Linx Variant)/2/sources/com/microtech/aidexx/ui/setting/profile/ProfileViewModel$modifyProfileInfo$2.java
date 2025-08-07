package com.microtech.aidexx.ui.setting.profile;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileViewModel$modifyProfileInfo$2", f = "ProfileViewModel.kt", i = {0, 1}, l = {64, 85, 103, 107, 108}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$modifyProfileInfo$2 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Integer, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $birthDate;
    final /* synthetic */ Integer $bodyWeight;
    final /* synthetic */ String $complications;
    final /* synthetic */ String $complicationsDisplayName;
    final /* synthetic */ Integer $diabetesType;
    final /* synthetic */ String $diabetesTypeDisplayName;
    final /* synthetic */ Integer $diabetesTypeValue;
    final /* synthetic */ String $diagnosisDate;
    final /* synthetic */ String $fullName;
    final /* synthetic */ Integer $gender;
    final /* synthetic */ Integer $height;
    final /* synthetic */ Integer $isGuide;
    final /* synthetic */ Integer $isSettedPassword;
    final /* synthetic */ Integer $isUnitGuide;
    final /* synthetic */ String $name;
    final /* synthetic */ String $otherDiseases;
    final /* synthetic */ String $otherDiseasesDisplayName;
    final /* synthetic */ String $treatment;
    final /* synthetic */ String $treatmentDisplayName;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileViewModel$modifyProfileInfo$2(String str, String str2, Integer num, String str3, Integer num2, Integer num3, Integer num4, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num5, Integer num6, Integer num7, Integer num8, Continuation<? super ProfileViewModel$modifyProfileInfo$2> continuation) {
        super(2, continuation);
        this.$name = str;
        this.$fullName = str2;
        this.$gender = num;
        this.$birthDate = str3;
        this.$height = num2;
        this.$bodyWeight = num3;
        this.$diabetesType = num4;
        this.$diabetesTypeDisplayName = str4;
        this.$diagnosisDate = str5;
        this.$complications = str6;
        this.$complicationsDisplayName = str7;
        this.$treatment = str8;
        this.$treatmentDisplayName = str9;
        this.$otherDiseases = str10;
        this.$otherDiseasesDisplayName = str11;
        this.$isGuide = num5;
        this.$isUnitGuide = num6;
        this.$isSettedPassword = num7;
        this.$diabetesTypeValue = num8;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ProfileViewModel$modifyProfileInfo$2 profileViewModel$modifyProfileInfo$2 = new ProfileViewModel$modifyProfileInfo$2(this.$name, this.$fullName, this.$gender, this.$birthDate, this.$height, this.$bodyWeight, this.$diabetesType, this.$diabetesTypeDisplayName, this.$diagnosisDate, this.$complications, this.$complicationsDisplayName, this.$treatment, this.$treatmentDisplayName, this.$otherDiseases, this.$otherDiseasesDisplayName, this.$isGuide, this.$isUnitGuide, this.$isSettedPassword, this.$diabetesTypeValue, continuation);
        profileViewModel$modifyProfileInfo$2.L$0 = obj;
        return profileViewModel$modifyProfileInfo$2;
    }

    public final Object invoke(FlowCollector<? super Pair<Integer, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$modifyProfileInfo$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0114 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r36) {
        /*
            r35 = this;
            r0 = r35
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 0
            r8 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 == r8) goto L_0x0031
            if (r2 == r6) goto L_0x0028
            if (r2 == r5) goto L_0x0023
            if (r2 == r4) goto L_0x0023
            if (r2 != r3) goto L_0x001b
            goto L_0x0023
        L_0x001b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0023:
            kotlin.ResultKt.throwOnFailure(r36)
            goto L_0x015b
        L_0x0028:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r36)
            goto L_0x00fc
        L_0x0031:
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r36)
            r9 = r36
            goto L_0x009f
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r36)
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            com.microtech.aidexx.common.net.repository.AccountRepository r9 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r11 = r0.$name
            java.lang.String r12 = r0.$fullName
            java.lang.Integer r10 = r0.$gender
            r16 = r10
            java.lang.String r10 = r0.$birthDate
            r17 = r10
            java.lang.Integer r10 = r0.$height
            r18 = r10
            java.lang.Integer r10 = r0.$bodyWeight
            r19 = r10
            java.lang.Integer r10 = r0.$diabetesType
            r20 = r10
            java.lang.String r10 = r0.$diabetesTypeDisplayName
            r21 = r10
            java.lang.String r10 = r0.$diagnosisDate
            r22 = r10
            java.lang.String r10 = r0.$complications
            r23 = r10
            java.lang.String r10 = r0.$complicationsDisplayName
            r24 = r10
            java.lang.String r10 = r0.$treatment
            r25 = r10
            java.lang.String r10 = r0.$treatmentDisplayName
            r26 = r10
            java.lang.String r10 = r0.$otherDiseases
            r27 = r10
            java.lang.String r10 = r0.$otherDiseasesDisplayName
            r28 = r10
            java.lang.Integer r10 = r0.$isGuide
            r29 = r10
            java.lang.Integer r10 = r0.$isUnitGuide
            r30 = r10
            java.lang.Integer r10 = r0.$isSettedPassword
            r31 = r10
            r32 = r0
            kotlin.coroutines.Continuation r32 = (kotlin.coroutines.Continuation) r32
            r0.L$0 = r2
            r0.label = r8
            r10 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r33 = 57
            r34 = 0
            java.lang.Object r9 = com.microtech.aidexx.common.net.repository.AccountRepository.updateUserInformation$default(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)
            if (r9 != r1) goto L_0x009f
            return r1
        L_0x009f:
            com.microtech.aidexx.common.net.ApiResult r9 = (com.microtech.aidexx.common.net.ApiResult) r9
            boolean r10 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r10 == 0) goto L_0x0115
            com.microtech.aidexx.common.user.UserInfoManager$Companion r3 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r8 = r3.instance()
            java.lang.String r9 = r0.$name
            java.lang.String r10 = r0.$fullName
            java.lang.Integer r11 = r0.$height
            java.lang.Integer r12 = r0.$bodyWeight
            java.lang.Integer r13 = r0.$gender
            java.lang.String r14 = r0.$birthDate
            java.lang.Integer r3 = r0.$diabetesType
            r16 = r3
            java.lang.Integer r3 = r0.$diabetesTypeValue
            r17 = r3
            java.lang.String r3 = r0.$diabetesTypeDisplayName
            r18 = r3
            java.lang.String r3 = r0.$diagnosisDate
            r19 = r3
            java.lang.String r3 = r0.$complications
            r20 = r3
            java.lang.String r3 = r0.$complicationsDisplayName
            r21 = r3
            java.lang.String r3 = r0.$treatment
            r22 = r3
            java.lang.String r3 = r0.$treatmentDisplayName
            r23 = r3
            java.lang.String r3 = r0.$otherDiseases
            r24 = r3
            java.lang.String r3 = r0.$otherDiseasesDisplayName
            r25 = r3
            r30 = r0
            kotlin.coroutines.Continuation r30 = (kotlin.coroutines.Continuation) r30
            r0.L$0 = r2
            r0.label = r6
            r15 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r31 = 1966144(0x1e0040, float:2.755155E-39)
            r32 = 0
            java.lang.Object r3 = com.microtech.aidexx.common.user.UserInfoManager.updateProfile$default(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            if (r3 != r1) goto L_0x00fc
            return r1
        L_0x00fc:
            r3 = 0
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            java.lang.String r4 = "0"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
            r4 = r0
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r0.L$0 = r7
            r0.label = r5
            java.lang.Object r2 = r2.emit(r3, r4)
            if (r2 != r1) goto L_0x015b
            return r1
        L_0x0115:
            boolean r5 = r9 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r5 == 0) goto L_0x015b
            com.microtech.aidexx.common.net.ApiResult$Failure r9 = (com.microtech.aidexx.common.net.ApiResult.Failure) r9
            boolean r5 = r9.isBizFail()
            if (r5 == 0) goto L_0x013b
            java.lang.Integer r3 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            java.lang.String r5 = r9.getMsg()
            kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r5)
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r7
            r0.label = r4
            java.lang.Object r2 = r2.emit(r3, r5)
            if (r2 != r1) goto L_0x015b
            return r1
        L_0x013b:
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            com.microtech.aidexx.AidexxApp r5 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r6 = com.microtech.aidexx.R.string.com_network_failure
            java.lang.String r5 = r5.getString(r6)
            kotlin.Pair r4 = kotlin.TuplesKt.to(r4, r5)
            r5 = r0
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r0.L$0 = r7
            r0.label = r3
            java.lang.Object r2 = r2.emit(r4, r5)
            if (r2 != r1) goto L_0x015b
            return r1
        L_0x015b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel$modifyProfileInfo$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
