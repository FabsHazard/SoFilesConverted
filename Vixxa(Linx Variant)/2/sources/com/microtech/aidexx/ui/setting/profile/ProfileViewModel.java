package com.microtech.aidexx.ui.setting.profile;

import androidx.lifecycle.ViewModel;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"\u0000W\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\r\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0019\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u0014J\u0019\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\"\u0010\u001d\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00050\u00172\u0006\u0010\u001e\u001a\u00020\u0014J\u0002\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u00050\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0002\u00102J\u0011\u00103\u001a\u000204H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J?\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00140\u00050\u00172\f\u00106\u001a\b\u0012\u0004\u0012\u000208072\f\u00109\u001a\b\u0012\u0004\u0012\u00020807H@ø\u0001\u0000¢\u0006\u0002\u0010:J*\u0010;\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00050\u00172\u0006\u0010\u001e\u001a\u00020\u00142\u0006\u0010<\u001a\u00020\u0014R/\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0004\n\u0002\u0010\u000eR%\u0010\u000f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00050\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006="}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_timeLeft", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "", "", "get_timeLeft", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "_timeLeft$delegate", "Lkotlin/Lazy;", "countDownTimer", "com/microtech/aidexx/ui/setting/profile/ProfileViewModel$countDownTimer$1", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel$countDownTimer$1;", "sendCodeTimeLeft", "Lkotlinx/coroutines/flow/StateFlow;", "getSendCodeTimeLeft", "()Lkotlinx/coroutines/flow/StateFlow;", "calDiagnosisDate", "", "diagnosisDate", "fetchAndSaveAllDiabetes", "Lkotlinx/coroutines/flow/Flow;", "Lcom/microtech/aidexx/ui/setting/profile/DiabetesEnum;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatOtherDiabetesStr", "content", "getAllOtherDiabetes", "getChangeAccountVerifyCode", "account", "modifyProfileInfo", "name", "fullName", "height", "bodyWeight", "gender", "birthDate", "diabetesType", "diabetesTypeValue", "diabetesTypeDisplayName", "complications", "complicationsDisplayName", "treatment", "treatmentDisplayName", "otherDiseases", "otherDiseasesDisplayName", "isUnitGuide", "isGuide", "isSettedPassword", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshUserInfo", "", "saveAndUpdateOtherDiseases", "newPresetList", "", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "checkedList", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePhoneOrEmail", "code", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ProfileViewModel.kt */
public final class ProfileViewModel extends ViewModel {
    private final Lazy _timeLeft$delegate = LazyKt.lazy(ProfileViewModel$_timeLeft$2.INSTANCE);
    /* access modifiers changed from: private */
    public final ProfileViewModel$countDownTimer$1 countDownTimer = new ProfileViewModel$countDownTimer$1(this);
    private final StateFlow<Pair<Boolean, Integer>> sendCodeTimeLeft = FlowKt.asStateFlow(get_timeLeft());

    /* access modifiers changed from: private */
    public final MutableStateFlow<Pair<Boolean, Integer>> get_timeLeft() {
        return (MutableStateFlow) this._timeLeft$delegate.getValue();
    }

    public final StateFlow<Pair<Boolean, Integer>> getSendCodeTimeLeft() {
        return this.sendCodeTimeLeft;
    }

    public static /* synthetic */ Object modifyProfileInfo$default(ProfileViewModel profileViewModel, String str, String str2, Integer num, Integer num2, Integer num3, String str3, Integer num4, Integer num5, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num6, Integer num7, Integer num8, Continuation continuation, int i, Object obj) {
        int i2 = i;
        return profileViewModel.modifyProfileInfo((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : num4, (i2 & 128) != 0 ? null : num5, (i2 & 256) != 0 ? null : str4, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : str6, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : str9, (i2 & 16384) != 0 ? null : str10, (32768 & i2) != 0 ? null : str11, (65536 & i2) != 0 ? null : num6, (131072 & i2) != 0 ? null : num7, (i2 & 262144) != 0 ? null : num8, continuation);
    }

    public final Object modifyProfileInfo(String str, String str2, Integer num, Integer num2, Integer num3, String str3, Integer num4, Integer num5, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, Integer num6, Integer num7, Integer num8, Continuation<? super Flow<Pair<Integer, String>>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ProfileViewModel$modifyProfileInfo$2(str, str2, num3, str3, num, num2, num4, str4, str5, str6, str7, str8, str9, str10, str11, num7, num6, num8, num5, (Continuation<? super ProfileViewModel$modifyProfileInfo$2>) null)), Dispatchers.getIO());
    }

    public final Object saveAndUpdateOtherDiseases(List<MenuEntity> list, List<MenuEntity> list2, Continuation<? super Flow<Pair<Integer, String>>> continuation) {
        return FlowKt.flowOn(FlowKt.callbackFlow(new ProfileViewModel$saveAndUpdateOtherDiseases$2(list, this, list2, (Continuation<? super ProfileViewModel$saveAndUpdateOtherDiseases$2>) null)), Dispatchers.getIO());
    }

    public final Object fetchAndSaveAllDiabetes(Continuation<? super Flow<DiabetesEnum>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ProfileViewModel$fetchAndSaveAllDiabetes$2((Continuation<? super ProfileViewModel$fetchAndSaveAllDiabetes$2>) null)), Dispatchers.getIO());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008d, code lost:
        if (r5 == null) goto L_0x008f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String calDiagnosisDate(java.lang.String r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0099
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            int r1 = r5.length()
            if (r1 != 0) goto L_0x000c
            r5 = r0
        L_0x000c:
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0099
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd"
            java.util.Locale r3 = java.util.Locale.getDefault()
            r1.<init>(r2, r3)
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0026 }
            java.util.Date r5 = r1.parse(r5)     // Catch:{ all -> 0x0026 }
            java.lang.Object r5 = kotlin.Result.m343constructorimpl(r5)     // Catch:{ all -> 0x0026 }
            goto L_0x0031
        L_0x0026:
            r5 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r5 = kotlin.ResultKt.createFailure(r5)
            java.lang.Object r5 = kotlin.Result.m343constructorimpl(r5)
        L_0x0031:
            boolean r1 = kotlin.Result.m349isFailureimpl(r5)
            if (r1 == 0) goto L_0x0038
            r5 = r0
        L_0x0038:
            java.util.Date r5 = (java.util.Date) r5
            if (r5 == 0) goto L_0x008f
            java.util.Calendar r1 = java.util.Calendar.getInstance()
            r1.setTime(r5)
            java.util.Calendar r5 = java.util.Calendar.getInstance()
            r2 = 1
            int r3 = r5.get(r2)
            int r2 = r1.get(r2)
            int r3 = r3 - r2
            int r3 = r3 * 12
            r2 = 2
            int r5 = r5.get(r2)
            int r3 = r3 + r5
            int r5 = r1.get(r2)
            int r3 = r3 - r5
            int r5 = r3 / 12
            int r3 = r3 % 12
            if (r5 <= 0) goto L_0x007b
            com.microtech.aidexx.AidexxApp r1 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r2 = com.microtech.aidexx.R.string.com_time_distance_YM
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r3}
            java.lang.String r5 = r1.getString(r2, r5)
            goto L_0x008d
        L_0x007b:
            com.microtech.aidexx.AidexxApp r5 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r1 = com.microtech.aidexx.R.string.com_time_distance_M
            java.lang.String r2 = java.lang.String.valueOf(r3)
            java.lang.Object[] r2 = new java.lang.Object[]{r2}
            java.lang.String r5 = r5.getString(r1, r2)
        L_0x008d:
            if (r5 != 0) goto L_0x0094
        L_0x008f:
            r5 = r4
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel r5 = (com.microtech.aidexx.ui.setting.profile.ProfileViewModel) r5
            java.lang.String r5 = ""
        L_0x0094:
            if (r5 != 0) goto L_0x0097
            goto L_0x0099
        L_0x0097:
            r0 = r5
            goto L_0x009c
        L_0x0099:
            r5 = r4
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel r5 = (com.microtech.aidexx.ui.setting.profile.ProfileViewModel) r5
        L_0x009c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel.calDiagnosisDate(java.lang.String):java.lang.String");
    }

    public final String formatOtherDiabetesStr(String str) {
        if (str == null) {
            return null;
        }
        CharSequence charSequence = str;
        if (charSequence.length() == 0) {
            charSequence = null;
        }
        String str2 = (String) charSequence;
        if (str2 == null) {
            return null;
        }
        if (str2.length() > 10) {
            StringBuilder sb = new StringBuilder();
            String substring = str2.substring(0, 10);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
            sb.append("...");
            str2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(str2, "toString(...)");
        }
        return str2;
    }

    public final Object getAllOtherDiabetes(Continuation<? super Flow<DiabetesEnum>> continuation) {
        return FlowKt.flowOn(FlowKt.flow(new ProfileViewModel$getAllOtherDiabetes$2((Continuation<? super ProfileViewModel$getAllOtherDiabetes$2>) null)), Dispatchers.getIO());
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object refreshUserInfo(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.ui.setting.profile.ProfileViewModel$refreshUserInfo$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$refreshUserInfo$1 r0 = (com.microtech.aidexx.ui.setting.profile.ProfileViewModel$refreshUserInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.ui.setting.profile.ProfileViewModel$refreshUserInfo$1 r0 = new com.microtech.aidexx.ui.setting.profile.ProfileViewModel$refreshUserInfo$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x0039
            if (r2 == r3) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x008d
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0047
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.common.net.repository.AccountRepository r6 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r0.label = r3
            java.lang.Object r6 = r6.getUserInfo(r0)
            if (r6 != r1) goto L_0x0047
            return r1
        L_0x0047:
            com.microtech.aidexx.common.net.ApiResult r6 = (com.microtech.aidexx.common.net.ApiResult) r6
            boolean r2 = r6 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r2 == 0) goto L_0x0098
            com.microtech.aidexx.common.net.ApiResult$Success r6 = (com.microtech.aidexx.common.net.ApiResult.Success) r6
            java.lang.Object r2 = r6.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r2 = (com.microtech.aidexx.common.net.entity.BaseResponse) r2
            java.lang.Object r2 = r2.getData()
            com.microtech.aidexx.db.entity.UserEntity r2 = (com.microtech.aidexx.db.entity.UserEntity) r2
            r3 = 0
            if (r2 == 0) goto L_0x0063
            java.lang.String r2 = r2.getUserId()
            goto L_0x0064
        L_0x0063:
            r2 = r3
        L_0x0064:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0090
            int r2 = r2.length()
            if (r2 != 0) goto L_0x006f
            goto L_0x0090
        L_0x006f:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r2 = r2.instance()
            java.lang.Object r6 = r6.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r6 = (com.microtech.aidexx.common.net.entity.BaseResponse) r6
            java.lang.Object r6 = r6.getData()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            com.microtech.aidexx.db.entity.UserEntity r6 = (com.microtech.aidexx.db.entity.UserEntity) r6
            r0.label = r4
            java.lang.Object r6 = r2.refreshUserInfo(r6, r0)
            if (r6 != r1) goto L_0x008d
            return r1
        L_0x008d:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0090:
            com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r0 = "刷新用户信息接口返回的userid为空"
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r6, r0, r3, r4, r3)
            goto L_0x00aa
        L_0x0098:
            com.microtech.aidexx.AidexxApp r6 = com.microtech.aidexx.common.ExtendsKt.getContext()
            int r0 = com.microtech.aidexx.R.string.com_network_failure
            java.lang.String r6 = r6.getString(r0)
            java.lang.String r0 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            com.microtech.aidexx.common.ExtendsKt.toast(r6)
        L_0x00aa:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileViewModel.refreshUserInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Flow<Pair<Boolean, String>> getChangeAccountVerifyCode(String str) {
        Intrinsics.checkNotNullParameter(str, "account");
        return FlowKt.flowOn(FlowKt.flow(new ProfileViewModel$getChangeAccountVerifyCode$1(str, this, (Continuation<? super ProfileViewModel$getChangeAccountVerifyCode$1>) null)), Dispatchers.getIO());
    }

    public final Flow<Pair<Boolean, String>> updatePhoneOrEmail(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "account");
        Intrinsics.checkNotNullParameter(str2, "code");
        return FlowKt.flowOn(FlowKt.flow(new ProfileViewModel$updatePhoneOrEmail$1(str, str2, (Continuation<? super ProfileViewModel$updatePhoneOrEmail$1>) null)), Dispatchers.getIO());
    }
}
