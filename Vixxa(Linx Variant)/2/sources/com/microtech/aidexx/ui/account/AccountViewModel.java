package com.microtech.aidexx.ui.account;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.LoginType;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.data.CloudHistorySync;
import com.microtech.aidexx.ui.account.entity.UserPreferenceEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0004\u0018\u0000 72\u00020\u0001:\u00017B\u0005¢\u0006\u0002\u0010\u0002J2\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00110\b0\u00102\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011J\u0019\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\"\u0010\u0018\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00110\b0\u00102\u0006\u0010\u0019\u001a\u00020\u0011J\u001d\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJK\u0010\u001c\u001a\u00020\u001d21\b\u0002\u0010\u001e\u001a+\u0012\u001f\u0012\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0!0 ¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001f2\u0010\b\u0002\u0010&\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010'J>\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00110\b0\u00102\u0006\u0010$\u001a\u00020\u00112\b\b\u0002\u0010)\u001a\u00020\u00112\b\b\u0002\u0010*\u001a\u00020\u00112\b\b\u0001\u0010+\u001a\u00020\nJ\b\u0010,\u001a\u00020\u001dH\u0014J'\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00110\b2\u0006\u0010.\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J'\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00110\b2\u0006\u0010.\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J-\u00100\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00110\b0\u00102\u0006\u0010\u0013\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0006\u00101\u001a\u00020\u001dJ)\u00102\u001a\b\u0012\u0004\u0012\u000204032\u0006\u0010\u0016\u001a\u00020\u00112\b\b\u0002\u00105\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u00106R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R-\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u00078FX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcom/microtech/aidexx/ui/account/AccountViewModel;", "Lcom/microtech/aidexx/base/BaseViewModel;", "()V", "countDownTimer", "com/microtech/aidexx/ui/account/AccountViewModel$countDownTimer$1", "Lcom/microtech/aidexx/ui/account/AccountViewModel$countDownTimer$1;", "timeLeft", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "getTimeLeft", "()Landroidx/lifecycle/MutableLiveData;", "timeLeft$delegate", "Lkotlin/Lazy;", "changePWD", "Lkotlinx/coroutines/flow/Flow;", "", "phoneNumber", "pwd", "verifyCode", "downloadData", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getChangePWDVerifyCode", "account", "getUserInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserPreference", "", "success", "Lkotlin/Function1;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "Lcom/microtech/aidexx/ui/account/entity/UserPreferenceEntity;", "Lkotlin/ParameterName;", "name", "info", "failure", "Lkotlin/Function0;", "login", "password", "verCode", "type", "onCleared", "sendRegisterEmailVerificationCode", "phone", "sendRegisterPhoneVerificationCode", "setPwd", "startCountDown", "testData", "", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "c", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccountViewModel.kt */
public final class AccountViewModel extends BaseViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "AccountViewModel";
    private final AccountViewModel$countDownTimer$1 countDownTimer = new AccountViewModel$countDownTimer$1(this);
    private final Lazy timeLeft$delegate = LazyKt.lazy(AccountViewModel$timeLeft$2.INSTANCE);

    public final MutableLiveData<Pair<Boolean, Integer>> getTimeLeft() {
        return (MutableLiveData) this.timeLeft$delegate.getValue();
    }

    public static /* synthetic */ Flow login$default(AccountViewModel accountViewModel, String str, String str2, String str3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "";
        }
        if ((i2 & 4) != 0) {
            str3 = "";
        }
        return accountViewModel.login(str, str2, str3, i);
    }

    public final Flow<Pair<Integer, String>> login(String str, String str2, String str3, @LoginType int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "password");
        Intrinsics.checkNotNullParameter(str3, "verCode");
        return FlowKt.flowOn(FlowKt.flow(new AccountViewModel$login$1(i, str, str3, str2, this, (Continuation<? super AccountViewModel$login$1>) null)), Dispatchers.getIO());
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUserInfo(kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, java.lang.Integer>> r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.ui.account.AccountViewModel$getUserInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.ui.account.AccountViewModel$getUserInfo$1 r0 = (com.microtech.aidexx.ui.account.AccountViewModel$getUserInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.account.AccountViewModel$getUserInfo$1 r0 = new com.microtech.aidexx.ui.account.AccountViewModel$getUserInfo$1
            r0.<init>(r7, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            com.microtech.aidexx.common.net.ApiResult r0 = (com.microtech.aidexx.common.net.ApiResult) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0097
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x004b
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r8)
            com.microtech.aidexx.common.net.repository.AccountRepository r8 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r0.label = r4
            java.lang.Object r8 = r8.getUserInfo(r0)
            if (r8 != r1) goto L_0x004b
            return r1
        L_0x004b:
            com.microtech.aidexx.common.net.ApiResult r8 = (com.microtech.aidexx.common.net.ApiResult) r8
            boolean r2 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r4 = 0
            java.lang.String r5 = ""
            if (r2 == 0) goto L_0x00dd
            r2 = r8
            com.microtech.aidexx.common.net.ApiResult$Success r2 = (com.microtech.aidexx.common.net.ApiResult.Success) r2
            java.lang.Object r6 = r2.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r6 = (com.microtech.aidexx.common.net.entity.BaseResponse) r6
            java.lang.Object r6 = r6.getData()
            com.microtech.aidexx.db.entity.UserEntity r6 = (com.microtech.aidexx.db.entity.UserEntity) r6
            if (r6 == 0) goto L_0x006a
            java.lang.String r6 = r6.getUserId()
            goto L_0x006b
        L_0x006a:
            r6 = 0
        L_0x006b:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            if (r6 == 0) goto L_0x00cb
            int r6 = r6.length()
            if (r6 != 0) goto L_0x0076
            goto L_0x00cb
        L_0x0076:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r4 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r4 = r4.instance()
            java.lang.Object r2 = r2.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r2 = (com.microtech.aidexx.common.net.entity.BaseResponse) r2
            java.lang.Object r2 = r2.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            com.microtech.aidexx.db.entity.UserEntity r2 = (com.microtech.aidexx.db.entity.UserEntity) r2
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r0 = r4.onUserLogin(r2, r0)
            if (r0 != r1) goto L_0x0096
            return r1
        L_0x0096:
            r0 = r8
        L_0x0097:
            com.microtech.aidexx.common.net.ApiResult$Success r0 = (com.microtech.aidexx.common.net.ApiResult.Success) r0
            java.lang.Object r8 = r0.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r8 = (com.microtech.aidexx.common.net.entity.BaseResponse) r8
            java.lang.Object r8 = r8.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            com.microtech.aidexx.db.entity.UserEntity r8 = (com.microtech.aidexx.db.entity.UserEntity) r8
            java.lang.String r8 = r8.getUserId()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            java.lang.Object r0 = r0.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r0 = (com.microtech.aidexx.common.net.entity.BaseResponse) r0
            java.lang.Object r0 = r0.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.microtech.aidexx.db.entity.UserEntity r0 = (com.microtech.aidexx.db.entity.UserEntity) r0
            int r0 = r0.isGuide()
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r8, r0)
            goto L_0x00e5
        L_0x00cb:
            com.microtech.aidexx.utils.LogUtil$Companion r8 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r0 = "拉用户信息接口返回的userid为空"
            java.lang.String r1 = "AccountViewModel"
            r8.xLogE(r0, r1)
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r5, r8)
            goto L_0x00e5
        L_0x00dd:
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            kotlin.Pair r8 = kotlin.TuplesKt.to(r5, r8)
        L_0x00e5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel.getUserInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object downloadData(String str, Continuation<? super Boolean> continuation) {
        return CloudHistorySync.Companion.downloadRecentData(str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendRegisterPhoneVerificationCode(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterPhoneVerificationCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterPhoneVerificationCode$1 r0 = (com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterPhoneVerificationCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterPhoneVerificationCode$1 r0 = new com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterPhoneVerificationCode$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.net.repository.AccountRepository r6 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r0.label = r3
            java.lang.Object r6 = r6.sendRegisterPhoneVerificationCode(r5, r0)
            if (r6 != r1) goto L_0x0040
            return r1
        L_0x0040:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r0 = 0
            if (r5 == 0) goto L_0x0050
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r0)
            goto L_0x0069
        L_0x0050:
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r5 == 0) goto L_0x006a
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            com.microtech.aidexx.common.net.ApiResult$Failure r6 = (com.microtech.aidexx.common.net.ApiResult.Failure) r6
            boolean r1 = r6.isBizFail()
            if (r1 == 0) goto L_0x0065
            java.lang.String r0 = r6.getMsg()
        L_0x0065:
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r0)
        L_0x0069:
            return r5
        L_0x006a:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel.sendRegisterPhoneVerificationCode(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow<Pair<Boolean, String>> getChangePWDVerifyCode(String str) {
        Intrinsics.checkNotNullParameter(str, "account");
        return FlowKt.flowOn(FlowKt.flow(new AccountViewModel$getChangePWDVerifyCode$1(str, (Continuation<? super AccountViewModel$getChangePWDVerifyCode$1>) null)), Dispatchers.getIO());
    }

    public final Flow<Pair<Boolean, String>> changePWD(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "phoneNumber");
        Intrinsics.checkNotNullParameter(str2, "pwd");
        Intrinsics.checkNotNullParameter(str3, "verifyCode");
        return FlowKt.flowOn(FlowKt.flow(new AccountViewModel$changePWD$1(str2, str, str3, (Continuation<? super AccountViewModel$changePWD$1>) null)), Dispatchers.getIO());
    }

    public static /* synthetic */ void getUserPreference$default(AccountViewModel accountViewModel, Function1 function1, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = null;
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        accountViewModel.getUserPreference(function1, function0);
    }

    public final void getUserPreference(Function1<? super BaseResponse<List<UserPreferenceEntity>>, Unit> function1, Function0<Unit> function0) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AccountViewModel$getUserPreference$1(function1, function0, (Continuation<? super AccountViewModel$getUserPreference$1>) null), 3, (Object) null);
    }

    public final void startCountDown() {
        this.countDownTimer.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object sendRegisterEmailVerificationCode(java.lang.String r5, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.Boolean, java.lang.String>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterEmailVerificationCode$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterEmailVerificationCode$1 r0 = (com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterEmailVerificationCode$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterEmailVerificationCode$1 r0 = new com.microtech.aidexx.ui.account.AccountViewModel$sendRegisterEmailVerificationCode$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.microtech.aidexx.ui.account.AccountViewModel r5 = (com.microtech.aidexx.ui.account.AccountViewModel) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.net.repository.AccountRepository r6 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.sendRegisterEmailVerificationCode(r5, r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            r5 = r4
        L_0x0047:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r0 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            r1 = 0
            if (r0 == 0) goto L_0x005c
            com.microtech.aidexx.ui.account.AccountViewModel$countDownTimer$1 r5 = r5.countDownTimer
            r5.start()
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r1)
            goto L_0x0075
        L_0x005c:
            boolean r5 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r5 == 0) goto L_0x0076
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            com.microtech.aidexx.common.net.ApiResult$Failure r6 = (com.microtech.aidexx.common.net.ApiResult.Failure) r6
            boolean r0 = r6.isBizFail()
            if (r0 == 0) goto L_0x0071
            java.lang.String r1 = r6.getMsg()
        L_0x0071:
            kotlin.Pair r5 = kotlin.TuplesKt.to(r5, r1)
        L_0x0075:
            return r5
        L_0x0076:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel.sendRegisterEmailVerificationCode(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        this.countDownTimer.cancel();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object testData(java.lang.String r18, int r19, kotlin.coroutines.Continuation<? super java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>> r20) {
        /*
            r17 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r2 instanceof com.microtech.aidexx.ui.account.AccountViewModel$testData$1
            if (r3 == 0) goto L_0x001c
            r3 = r2
            com.microtech.aidexx.ui.account.AccountViewModel$testData$1 r3 = (com.microtech.aidexx.ui.account.AccountViewModel$testData$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001c
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            r4 = r17
            goto L_0x0023
        L_0x001c:
            com.microtech.aidexx.ui.account.AccountViewModel$testData$1 r3 = new com.microtech.aidexx.ui.account.AccountViewModel$testData$1
            r4 = r17
            r3.<init>(r4, r2)
        L_0x0023:
            java.lang.Object r2 = r3.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r3.label
            r7 = 1
            if (r6 == 0) goto L_0x0041
            if (r6 != r7) goto L_0x0039
            java.lang.Object r0 = r3.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0189
        L_0x0039:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r2)
            java.util.Date r2 = new java.util.Date
            r2.<init>()
            long r8 = r2.getTime()
            r2 = 1000(0x3e8, float:1.401E-42)
            long r10 = (long) r2
            long r8 = r8 / r10
            com.microtech.aidexx.utils.LogUtil$Companion r2 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r12 = "开始生成插入 "
            r6.<init>(r12)
            java.util.Date r12 = new java.util.Date
            r12.<init>()
            long r12 = r12.getTime()
            java.lang.StringBuilder r6 = r6.append(r12)
            java.lang.String r6 = r6.toString()
            java.lang.String r12 = "AccountViewModel"
            r2.d(r6, r12)
            r2 = 0
            kotlin.ranges.IntRange r6 = kotlin.ranges.RangesKt.until((int) r2, (int) r1)
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.Collection r12 = (java.util.Collection) r12
            java.util.Iterator r6 = r6.iterator()
        L_0x0082:
            boolean r13 = r6.hasNext()
            if (r13 == 0) goto L_0x0175
            r13 = r6
            kotlin.collections.IntIterator r13 = (kotlin.collections.IntIterator) r13
            int r13 = r13.nextInt()
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r14 = new com.microtech.aidexx.db.entity.RealCgmHistoryEntity
            r14.<init>()
            java.util.Date r15 = new java.util.Date
            int r2 = r13 * 60
            r16 = r5
            long r4 = (long) r2
            long r4 = r8 - r4
            long r4 = r4 * r10
            r15.<init>(r4)
            r14.setDeviceTime(r15)
            r14.setGlucoseIsValid(r7)
            r2 = 0
            r14.setStatus(r2)
            int r4 = r13 % 200
            int r4 = r4 + 100
            float r4 = (float) r4
            java.lang.Float r4 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r4)
            r14.setGlucose(r4)
            r4 = 7
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            r14.setEventType(r4)
            java.util.Date r4 = r14.getDeviceTime()
            r14.setAppCreateTime(r4)
            r14.setUserId(r0)
            r4 = 2
            r14.setDataStatus(r4)
            r14.setType(r7)
            java.lang.String r5 = "WT0226-ID"
            r14.setDeviceId(r5)
            java.lang.String r5 = "WT0226"
            r14.setDeviceSn(r5)
            r5 = 1036831949(0x3dcccccd, float:0.1)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData1(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData2(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData3(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData4(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData5(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData6(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData7(r15)
            java.lang.Float r15 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData8(r15)
            java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
            r14.setRawData9(r5)
            java.lang.String r5 = "WT0226-sen"
            r14.setSensorId(r5)
            r14.setEventIndex(r13)
            java.lang.String r5 = r14.getRecordId()
            r14.setId(r5)
            r14.setBriefUploadState(r7)
            r14.setUserId(r0)
            int r5 = r1 - r13
            r14.setTimeOffset(r5)
            java.lang.String r5 = r14.updateRecordUUID()
            r14.setFrontRecordId(r5)
            java.lang.Float r5 = r14.getGlucose()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            float r5 = r5.floatValue()
            r13 = 1132068864(0x437a0000, float:250.0)
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 <= 0) goto L_0x0150
            r4 = r7
            goto L_0x0163
        L_0x0150:
            java.lang.Float r5 = r14.getGlucose()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            float r5 = r5.floatValue()
            r13 = 1125515264(0x43160000, float:150.0)
            int r5 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0162
            goto L_0x0163
        L_0x0162:
            r4 = r2
        L_0x0163:
            r14.setEventWarning(r4)
            java.util.List r4 = kotlin.collections.CollectionsKt.listOf(r14)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            kotlin.collections.CollectionsKt.addAll(r12, r4)
            r4 = r17
            r5 = r16
            goto L_0x0082
        L_0x0175:
            r16 = r5
            r0 = r12
            java.util.List r0 = (java.util.List) r0
            com.microtech.aidexx.db.repository.CgmCalibBgRepository r1 = com.microtech.aidexx.db.repository.CgmCalibBgRepository.INSTANCE
            r3.L$0 = r0
            r3.label = r7
            java.lang.Object r1 = r1.insertCgm(r0, r3)
            r2 = r16
            if (r1 != r2) goto L_0x0189
            return r2
        L_0x0189:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel.testData(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object testData$default(AccountViewModel accountViewModel, String str, int i, Continuation continuation, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8640;
        }
        return accountViewModel.testData(str, i, continuation);
    }

    public final Object setPwd(String str, Continuation<? super Flow<Pair<Boolean, String>>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new AccountViewModel$setPwd$2(str, (Continuation<? super AccountViewModel$setPwd$2>) null)), Dispatchers.getIO());
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/account/AccountViewModel$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: AccountViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
