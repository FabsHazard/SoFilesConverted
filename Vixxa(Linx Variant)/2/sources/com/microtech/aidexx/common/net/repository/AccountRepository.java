package com.microtech.aidexx.common.net.repository;

import android.net.Uri;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.common.net.entity.OtherDiseasesEntity;
import com.microtech.aidexx.common.net.entity.ResLogin;
import com.microtech.aidexx.db.entity.UserEntity;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ-\u0010\r\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00070\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J'\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J-\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00062\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ-\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00062\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ-\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00062\u0006\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001f\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J5\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00070\u00062\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010$J5\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010$J1\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020+0*0\u00070\u00062\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010-J'\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00070\u00062\u0006\u0010/\u001a\u000200H@ø\u0001\u0000¢\u0006\u0002\u00101J%\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010&\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J%\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\"\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J%\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u001d\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J%\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010&\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J%\u00106\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010\"\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J%\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010'\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J-\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ¥\u0002\u00109\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010@\u001a\u0004\u0018\u0001002\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010B\u001a\u0004\u0018\u0001002\n\b\u0002\u0010C\u001a\u0004\u0018\u0001002\n\b\u0002\u0010D\u001a\u0004\u0018\u0001002\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010F\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010H\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010M\u001a\u0004\u0018\u0001002\n\b\u0002\u0010N\u001a\u0004\u0018\u0001002\n\b\u0002\u0010O\u001a\u0004\u0018\u000100H@ø\u0001\u0000¢\u0006\u0002\u0010PJ%\u0010Q\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\u00062\u0006\u0010R\u001a\u00020SH@ø\u0001\u0000¢\u0006\u0002\u0010TR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006U"}, d2 = {"Lcom/microtech/aidexx/common/net/repository/AccountRepository;", "", "()V", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "cancelAccount", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "map", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAllDictionaryList", "", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "type", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserInfo", "Lcom/microtech/aidexx/db/entity/UserEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getuiLogin", "clientId", "gyLogin", "Lcom/microtech/aidexx/common/net/entity/ResLogin;", "gyuid", "token", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByPassword", "phone", "code", "loginOrRegisterByVerificationCodeWithPhone", "logout", "registerByVerificationCodeWithEmail", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPasswordByVerificationCode", "phoneNumber", "pwdEncrypted", "verifyCode", "saveOrUpdateOtherDiseasesUsrPreset", "", "Lcom/microtech/aidexx/common/net/entity/OtherDiseasesEntity;", "names", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanWatchQr", "watchId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendChangePhoneVerificationCode", "sendRegisterEmailVerificationCode", "sendRegisterPhoneVerificationCode", "sendResetPasswordPhoneVerificationCode", "sendUpdatePasswordEmailVerificationCode", "setPassword", "updatePhoneOrEmail", "updateUserInformation", "avatar", "name", "fullName", "surname", "middleName", "givenName", "gender", "birthDate", "height", "bodyWeight", "diabetesType", "diabetesTypeDisplayName", "diagnosisDate", "complications", "complicationsDisplayName", "treatment", "treatmentDisplayName", "otherDiseases", "otherDiseasesDisplayName", "isGuide", "isUnitGuide", "isSettedPassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "userUploadAvatar", "fileUri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccountRepository.kt */
public final class AccountRepository {
    public static final AccountRepository INSTANCE = new AccountRepository();
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO();

    private AccountRepository() {
    }

    public final Object sendRegisterEmailVerificationCode(String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$sendRegisterEmailVerificationCode$2(str, (Continuation<? super AccountRepository$sendRegisterEmailVerificationCode$2>) null), continuation);
    }

    public final Object registerByVerificationCodeWithEmail(String str, String str2, String str3, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$registerByVerificationCodeWithEmail$2(str, str3, str2, (Continuation<? super AccountRepository$registerByVerificationCodeWithEmail$2>) null), continuation);
    }

    public final Object sendRegisterPhoneVerificationCode(String str, Continuation<? super ApiResult<BaseResponse>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$sendRegisterPhoneVerificationCode$2(str, (Continuation<? super AccountRepository$sendRegisterPhoneVerificationCode$2>) null), continuation);
    }

    public final Object loginOrRegisterByVerificationCodeWithPhone(String str, String str2, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$loginOrRegisterByVerificationCodeWithPhone$2(str, str2, (Continuation<? super AccountRepository$loginOrRegisterByVerificationCodeWithPhone$2>) null), continuation);
    }

    public final Object loginByPassword(String str, String str2, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$loginByPassword$2(str, str2, (Continuation<? super AccountRepository$loginByPassword$2>) null), continuation);
    }

    public final Object gyLogin(String str, String str2, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$gyLogin$2(str, str2, (Continuation<? super AccountRepository$gyLogin$2>) null), continuation);
    }

    public final Object scanWatchQr(int i, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$scanWatchQr$2(i, (Continuation<? super AccountRepository$scanWatchQr$2>) null), continuation);
    }

    public final Object getUserInfo(Continuation<? super ApiResult<BaseResponse<UserEntity>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$getUserInfo$2((Continuation<? super AccountRepository$getUserInfo$2>) null), continuation);
    }

    public final Object sendResetPasswordPhoneVerificationCode(String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$sendResetPasswordPhoneVerificationCode$2(str, (Continuation<? super AccountRepository$sendResetPasswordPhoneVerificationCode$2>) null), continuation);
    }

    public final Object sendChangePhoneVerificationCode(String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$sendChangePhoneVerificationCode$2(str, (Continuation<? super AccountRepository$sendChangePhoneVerificationCode$2>) null), continuation);
    }

    public final Object updatePhoneOrEmail(String str, String str2, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$updatePhoneOrEmail$2(str, str2, (Continuation<? super AccountRepository$updatePhoneOrEmail$2>) null), continuation);
    }

    public final Object sendUpdatePasswordEmailVerificationCode(String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$sendUpdatePasswordEmailVerificationCode$2(str, (Continuation<? super AccountRepository$sendUpdatePasswordEmailVerificationCode$2>) null), continuation);
    }

    public final Object resetPasswordByVerificationCode(String str, String str2, String str3, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$resetPasswordByVerificationCode$2(str, str2, str3, (Continuation<? super AccountRepository$resetPasswordByVerificationCode$2>) null), continuation);
    }

    public final Object logout(Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$logout$2((Continuation<? super AccountRepository$logout$2>) null), continuation);
    }

    public final Object cancelAccount(Map<String, String> map, Continuation<? super ApiResult<BaseResponse>> continuation) {
        return ApiService.Companion.getInstance().cancelAccount(map, continuation);
    }

    public final Object getuiLogin(String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$getuiLogin$2(str, (Continuation<? super AccountRepository$getuiLogin$2>) null), continuation);
    }

    public final Object userUploadAvatar(Uri uri, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$userUploadAvatar$2(uri, (Continuation<? super AccountRepository$userUploadAvatar$2>) null), continuation);
    }

    public static /* synthetic */ Object updateUserInformation$default(AccountRepository accountRepository, String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Integer num5, Integer num6, Integer num7, Continuation continuation, int i, Object obj) {
        int i2 = i;
        return accountRepository.updateUserInformation((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : num, (i2 & 128) != 0 ? null : str7, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : num3, (i2 & 1024) != 0 ? null : num4, (i2 & 2048) != 0 ? null : str8, (i2 & 4096) != 0 ? null : str9, (i2 & 8192) != 0 ? null : str10, (i2 & 16384) != 0 ? null : str11, (32768 & i2) != 0 ? null : str12, (65536 & i2) != 0 ? null : str13, (131072 & i2) != 0 ? null : str14, (262144 & i2) != 0 ? null : str15, (524288 & i2) != 0 ? null : num5, (1048576 & i2) != 0 ? null : num6, (i2 & 2097152) != 0 ? null : num7, continuation);
    }

    public final Object updateUserInformation(String str, String str2, String str3, String str4, String str5, String str6, Integer num, String str7, Integer num2, Integer num3, Integer num4, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, Integer num5, Integer num6, Integer num7, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$updateUserInformation$2(str, str2, str3, str4, str5, str6, num, str7, num2, num3, num4, str8, str9, str10, str11, str12, str13, str14, str15, num5, num6, num7, (Continuation<? super AccountRepository$updateUserInformation$2>) null), continuation);
    }

    public final Object findAllDictionaryList(String str, Continuation<? super ApiResult<BaseResponse<List<MenuEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$findAllDictionaryList$2(str, (Continuation<? super AccountRepository$findAllDictionaryList$2>) null), continuation);
    }

    public final Object saveOrUpdateOtherDiseasesUsrPreset(List<String> list, Continuation<? super ApiResult<BaseResponse<List<OtherDiseasesEntity>>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$saveOrUpdateOtherDiseasesUsrPreset$2(list, (Continuation<? super AccountRepository$saveOrUpdateOtherDiseasesUsrPreset$2>) null), continuation);
    }

    public final Object setPassword(String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation) {
        return BuildersKt.withContext(dispatcher, new AccountRepository$setPassword$2(str, (Continuation<? super AccountRepository$setPassword$2>) null), continuation);
    }
}
