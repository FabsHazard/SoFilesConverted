package com.microtech.aidexx.common.net.repository;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0004H@"}, d2 = {"<anonymous>", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.common.net.repository.AccountRepository$updateUserInformation$2", f = "AccountRepository.kt", i = {}, l = {151}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountRepository.kt */
final class AccountRepository$updateUserInformation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiResult<? extends BaseResponse<String>>>, Object> {
    final /* synthetic */ String $avatar;
    final /* synthetic */ String $birthDate;
    final /* synthetic */ Integer $bodyWeight;
    final /* synthetic */ String $complications;
    final /* synthetic */ String $complicationsDisplayName;
    final /* synthetic */ Integer $diabetesType;
    final /* synthetic */ String $diabetesTypeDisplayName;
    final /* synthetic */ String $diagnosisDate;
    final /* synthetic */ String $fullName;
    final /* synthetic */ Integer $gender;
    final /* synthetic */ String $givenName;
    final /* synthetic */ Integer $height;
    final /* synthetic */ Integer $isGuide;
    final /* synthetic */ Integer $isSettedPassword;
    final /* synthetic */ Integer $isUnitGuide;
    final /* synthetic */ String $middleName;
    final /* synthetic */ String $name;
    final /* synthetic */ String $otherDiseases;
    final /* synthetic */ String $otherDiseasesDisplayName;
    final /* synthetic */ String $surname;
    final /* synthetic */ String $treatment;
    final /* synthetic */ String $treatmentDisplayName;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountRepository$updateUserInformation$2(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Integer num5, Integer num6, Integer num7, Continuation<? super AccountRepository$updateUserInformation$2> continuation) {
        super(2, continuation);
        this.$avatar = str;
        this.$name = str2;
        this.$fullName = str3;
        this.$surname = str4;
        this.$middleName = str5;
        this.$givenName = str6;
        this.$gender = num;
        this.$birthDate = str7;
        this.$height = num2;
        this.$bodyWeight = num3;
        this.$diabetesType = num4;
        this.$diabetesTypeDisplayName = str8;
        this.$diagnosisDate = str9;
        this.$complications = str10;
        this.$complicationsDisplayName = str11;
        this.$treatment = str12;
        this.$treatmentDisplayName = str13;
        this.$otherDiseases = str14;
        this.$otherDiseasesDisplayName = str15;
        this.$isGuide = num5;
        this.$isUnitGuide = num6;
        this.$isSettedPassword = num7;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountRepository$updateUserInformation$2(this.$avatar, this.$name, this.$fullName, this.$surname, this.$middleName, this.$givenName, this.$gender, this.$birthDate, this.$height, this.$bodyWeight, this.$diabetesType, this.$diabetesTypeDisplayName, this.$diagnosisDate, this.$complications, this.$complicationsDisplayName, this.$treatment, this.$treatmentDisplayName, this.$otherDiseases, this.$otherDiseasesDisplayName, this.$isGuide, this.$isUnitGuide, this.$isSettedPassword, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return ((AccountRepository$updateUserInformation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HashMap hashMap = new HashMap();
            String str = this.$avatar;
            if (str != null) {
                hashMap.put("avatar", str);
            }
            String str2 = this.$name;
            if (str2 != null) {
                hashMap.put("name", str2);
            }
            String str3 = this.$fullName;
            if (str3 != null) {
                hashMap.put("fullName", str3);
            }
            String str4 = this.$surname;
            if (str4 != null) {
                hashMap.put("surname", str4);
            }
            String str5 = this.$middleName;
            if (str5 != null) {
                hashMap.put("middleName", str5);
            }
            String str6 = this.$givenName;
            if (str6 != null) {
                hashMap.put("givenName", str6);
            }
            Integer num = this.$gender;
            if (num != null) {
                hashMap.put("gender", Boxing.boxInt(num.intValue()));
            }
            String str7 = this.$birthDate;
            if (str7 != null) {
                hashMap.put("birthDate", str7);
            }
            Integer num2 = this.$height;
            if (num2 != null) {
                hashMap.put("height", Boxing.boxInt(num2.intValue()));
            }
            Integer num3 = this.$bodyWeight;
            if (num3 != null) {
                hashMap.put("bodyWeight", Boxing.boxInt(num3.intValue()));
            }
            Integer num4 = this.$diabetesType;
            if (num4 != null) {
                hashMap.put("diabetesType", Boxing.boxInt(num4.intValue()));
            }
            String str8 = this.$diabetesTypeDisplayName;
            if (str8 != null) {
                hashMap.put("diabetesTypeDisplayName", str8);
            }
            String str9 = this.$diagnosisDate;
            if (str9 != null) {
                hashMap.put("diagnosisDate", str9);
            }
            String str10 = this.$complications;
            if (str10 != null) {
                hashMap.put("complications", str10);
            }
            String str11 = this.$complicationsDisplayName;
            if (str11 != null) {
                hashMap.put("complicationsDisplayName", str11);
            }
            String str12 = this.$treatment;
            if (str12 != null) {
                hashMap.put("treatment", str12);
            }
            String str13 = this.$treatmentDisplayName;
            if (str13 != null) {
                hashMap.put("treatmentDisplayName", str13);
            }
            String str14 = this.$otherDiseases;
            if (str14 != null) {
                hashMap.put("otherDiseases", str14);
            }
            String str15 = this.$otherDiseasesDisplayName;
            if (str15 != null) {
                hashMap.put("otherDiseasesDisplayName", str15);
            }
            Integer num5 = this.$isGuide;
            if (num5 != null) {
                hashMap.put("isGuide", Boxing.boxInt(num5.intValue()));
            }
            Integer num6 = this.$isUnitGuide;
            if (num6 != null) {
                hashMap.put("isUnitGuide", Boxing.boxInt(num6.intValue()));
            }
            Integer num7 = this.$isSettedPassword;
            if (num7 != null) {
                hashMap.put("isSettedPassword", Boxing.boxInt(num7.intValue()));
            }
            this.label = 1;
            obj = ApiService.Companion.getInstance().updateUserInformation(hashMap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
