package com.microtech.aidexx.ui.account;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/Pair;", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel$login$1", f = "AccountViewModel.kt", i = {0, 1, 2, 3, 5, 6, 6, 7, 7, 10}, l = {66, 67, 68, 69, 83, 87, 89, 90, 93, 95, 100, 101, 104, 109, 112}, m = "invokeSuspend", n = {"$this$flow", "$this$flow", "$this$flow", "$this$flow", "$this$flow", "$this$flow", "userInfo", "$this$flow", "userInfo", "$this$flow"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0", "L$0", "L$1", "L$0", "L$1", "L$0"})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$login$1 extends SuspendLambda implements Function2<FlowCollector<? super Pair<? extends Integer, ? extends String>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $password;
    final /* synthetic */ int $type;
    final /* synthetic */ String $verCode;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AccountViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$login$1(int i, String str, String str2, String str3, AccountViewModel accountViewModel, Continuation<? super AccountViewModel$login$1> continuation) {
        super(2, continuation);
        this.$type = i;
        this.$name = str;
        this.$verCode = str2;
        this.$password = str3;
        this.this$0 = accountViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AccountViewModel$login$1 accountViewModel$login$1 = new AccountViewModel$login$1(this.$type, this.$name, this.$verCode, this.$password, this.this$0, continuation);
        accountViewModel$login$1.L$0 = obj;
        return accountViewModel$login$1;
    }

    public final Object invoke(FlowCollector<? super Pair<Integer, String>> flowCollector, Continuation<? super Unit> continuation) {
        return ((AccountViewModel$login$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v55, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0099, code lost:
        r12 = (com.microtech.aidexx.common.net.ApiResult) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b0, code lost:
        r12 = (com.microtech.aidexx.common.net.ApiResult) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c7, code lost:
        r12 = (com.microtech.aidexx.common.net.ApiResult) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00de, code lost:
        r12 = (com.microtech.aidexx.common.net.ApiResult) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e2, code lost:
        if ((r12 instanceof com.microtech.aidexx.common.net.ApiResult.Success) == false) goto L_0x0229;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e4, code lost:
        r12 = (com.microtech.aidexx.common.net.entity.ResLogin) ((com.microtech.aidexx.common.net.entity.BaseResponse) ((com.microtech.aidexx.common.net.ApiResult.Success) r12).getResult()).getData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f2, code lost:
        if (r12 == null) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f4, code lost:
        com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE.saveToken(r12.getToken());
        com.microtech.aidexx.common.user.UserInfoManager.Companion.instance().saveUserId(r12.getUserId());
        r12 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010d, code lost:
        r12 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x010e, code lost:
        if (r12 != null) goto L_0x0129;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0110, code lost:
        r12 = kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(-1), "token为空 登录失败");
        r11.L$0 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0123, code lost:
        if (r1.emit(r12, r11) != r0) goto L_0x0126;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0125, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0128, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0129, code lost:
        r11.L$0 = r1;
        r11.label = 6;
        r12 = r11.this$0.getUserInfo(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0137, code lost:
        if (r12 != r0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0139, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x013a, code lost:
        r12 = (kotlin.Pair) r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0146, code lost:
        if (((java.lang.CharSequence) r12.getFirst()).length() <= 0) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0148, code lost:
        r11.L$0 = r7;
        r11.L$1 = r12;
        r11.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0160, code lost:
        if (r7.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(1), "开始下载数据"), r11) != r0) goto L_0x0163;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0162, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0163, code lost:
        r1 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0164, code lost:
        r11.L$0 = r7;
        r11.L$1 = r1;
        r11.label = 8;
        r12 = r11.this$0.downloadData((java.lang.String) r1.getFirst(), r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x017b, code lost:
        if (r12 != r0) goto L_0x017e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x017d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0184, code lost:
        if (((java.lang.Boolean) r12).booleanValue() == false) goto L_0x01d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0186, code lost:
        com.microtech.aidexx.common.user.UserInfoManager.Companion.instance().updateLoginFlag(true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0199, code lost:
        if (((java.lang.Number) r1.getSecond()).intValue() == 1) goto L_0x01b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01b4, code lost:
        if (r7.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(3), "引导"), r11) != r0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b7, code lost:
        r11.L$0 = null;
        r11.L$1 = null;
        r11.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01d0, code lost:
        if (r7.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(2), "登录成功"), r11) != r0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01d2, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01d3, code lost:
        com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE.saveToken("");
        r11.L$0 = r7;
        r11.L$1 = null;
        r11.label = 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01f1, code lost:
        if (com.microtech.aidexx.db.repository.AccountDbRepository.INSTANCE.removeUserByUId((java.lang.String) r1.getFirst(), r11) != r0) goto L_0x01f4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01f3, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01f4, code lost:
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01f5, code lost:
        r11.L$0 = null;
        r11.label = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x020c, code lost:
        if (r1.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(-1), "数据下载失败"), r11) != r0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x020e, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x020f, code lost:
        r11.L$0 = null;
        r11.label = 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0226, code lost:
        if (r7.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(-1), "登录成功，用户信息拉取失败"), r11) != r0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0228, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x022b, code lost:
        if ((r12 instanceof com.microtech.aidexx.common.net.ApiResult.Failure) == false) goto L_0x024c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x022d, code lost:
        r11.L$0 = null;
        r11.label = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0249, code lost:
        if (r1.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(-2), ((com.microtech.aidexx.common.net.ApiResult.Failure) r12).getMsg()), r11) != r0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x024b, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x024c, code lost:
        r11.L$0 = null;
        r11.label = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0263, code lost:
        if (r1.emit(kotlin.TuplesKt.to(kotlin.coroutines.jvm.internal.Boxing.boxInt(-1), "暂不支持该方式登录"), r11) != r0) goto L_0x0266;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0265, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0268, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0045, code lost:
        r7 = r1;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 3
            r3 = 2
            r4 = -1
            r5 = 1
            r6 = 0
            switch(r1) {
                case 0: goto L_0x006e;
                case 1: goto L_0x0065;
                case 2: goto L_0x005d;
                case 3: goto L_0x0055;
                case 4: goto L_0x004d;
                case 5: goto L_0x0048;
                case 6: goto L_0x003e;
                case 7: goto L_0x0031;
                case 8: goto L_0x0024;
                case 9: goto L_0x001f;
                case 10: goto L_0x001f;
                case 11: goto L_0x0016;
                case 12: goto L_0x001f;
                case 13: goto L_0x001f;
                case 14: goto L_0x001f;
                case 15: goto L_0x001f;
                default: goto L_0x000e;
            }
        L_0x000e:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0016:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x01f5
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0266
        L_0x0024:
            java.lang.Object r1 = r11.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x017e
        L_0x0031:
            java.lang.Object r1 = r11.L$1
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r7 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r7 = (kotlinx.coroutines.flow.FlowCollector) r7
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0164
        L_0x003e:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
        L_0x0045:
            r7 = r1
            goto L_0x013a
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0126
        L_0x004d:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00b0
        L_0x0055:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0099
        L_0x005d:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00c7
        L_0x0065:
            java.lang.Object r1 = r11.L$0
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00de
        L_0x006e:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.Object r12 = r11.L$0
            r1 = r12
            kotlinx.coroutines.flow.FlowCollector r1 = (kotlinx.coroutines.flow.FlowCollector) r1
            int r12 = r11.$type
            if (r12 == r5) goto L_0x00ca
            if (r12 == r3) goto L_0x00b3
            r7 = 4
            if (r12 == r2) goto L_0x009c
            if (r12 == r7) goto L_0x0083
            r12 = r6
            goto L_0x00e0
        L_0x0083:
            com.microtech.aidexx.common.net.repository.AccountRepository r12 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r7 = r11.$name
            java.lang.String r8 = r11.$verCode
            java.lang.String r9 = r11.$password
            r10 = r11
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11.L$0 = r1
            r11.label = r2
            java.lang.Object r12 = r12.registerByVerificationCodeWithEmail(r7, r8, r9, r10)
            if (r12 != r0) goto L_0x0099
            return r0
        L_0x0099:
            com.microtech.aidexx.common.net.ApiResult r12 = (com.microtech.aidexx.common.net.ApiResult) r12
            goto L_0x00e0
        L_0x009c:
            com.microtech.aidexx.common.net.repository.AccountRepository r12 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r8 = r11.$name
            java.lang.String r9 = r11.$password
            r10 = r11
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11.L$0 = r1
            r11.label = r7
            java.lang.Object r12 = r12.gyLogin(r8, r9, r10)
            if (r12 != r0) goto L_0x00b0
            return r0
        L_0x00b0:
            com.microtech.aidexx.common.net.ApiResult r12 = (com.microtech.aidexx.common.net.ApiResult) r12
            goto L_0x00e0
        L_0x00b3:
            com.microtech.aidexx.common.net.repository.AccountRepository r12 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r7 = r11.$name
            java.lang.String r8 = r11.$password
            r9 = r11
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r11.L$0 = r1
            r11.label = r3
            java.lang.Object r12 = r12.loginByPassword(r7, r8, r9)
            if (r12 != r0) goto L_0x00c7
            return r0
        L_0x00c7:
            com.microtech.aidexx.common.net.ApiResult r12 = (com.microtech.aidexx.common.net.ApiResult) r12
            goto L_0x00e0
        L_0x00ca:
            com.microtech.aidexx.common.net.repository.AccountRepository r12 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            java.lang.String r7 = r11.$name
            java.lang.String r8 = r11.$verCode
            r9 = r11
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r11.L$0 = r1
            r11.label = r5
            java.lang.Object r12 = r12.loginOrRegisterByVerificationCodeWithPhone(r7, r8, r9)
            if (r12 != r0) goto L_0x00de
            return r0
        L_0x00de:
            com.microtech.aidexx.common.net.ApiResult r12 = (com.microtech.aidexx.common.net.ApiResult) r12
        L_0x00e0:
            boolean r7 = r12 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r7 == 0) goto L_0x0229
            com.microtech.aidexx.common.net.ApiResult$Success r12 = (com.microtech.aidexx.common.net.ApiResult.Success) r12
            java.lang.Object r12 = r12.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r12 = (com.microtech.aidexx.common.net.entity.BaseResponse) r12
            java.lang.Object r12 = r12.getData()
            com.microtech.aidexx.common.net.entity.ResLogin r12 = (com.microtech.aidexx.common.net.entity.ResLogin) r12
            if (r12 == 0) goto L_0x010d
            java.lang.String r7 = r12.getToken()
            com.microtech.aidexx.utils.mmkv.MmkvManager r8 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r8.saveToken(r7)
            java.lang.String r12 = r12.getUserId()
            com.microtech.aidexx.common.user.UserInfoManager$Companion r7 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r7 = r7.instance()
            r7.saveUserId(r12)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            goto L_0x010e
        L_0x010d:
            r12 = r6
        L_0x010e:
            if (r12 != 0) goto L_0x0129
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r2 = "token为空 登录失败"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r2)
            r11.L$0 = r6
            r2 = 5
            r11.label = r2
            java.lang.Object r12 = r1.emit(r12, r11)
            if (r12 != r0) goto L_0x0126
            return r0
        L_0x0126:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0129:
            com.microtech.aidexx.ui.account.AccountViewModel r12 = r11.this$0
            r7 = r11
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r11.L$0 = r1
            r8 = 6
            r11.label = r8
            java.lang.Object r12 = r12.getUserInfo(r7)
            if (r12 != r0) goto L_0x0045
            return r0
        L_0x013a:
            kotlin.Pair r12 = (kotlin.Pair) r12
            java.lang.Object r1 = r12.getFirst()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x020f
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            java.lang.String r8 = "开始下载数据"
            kotlin.Pair r1 = kotlin.TuplesKt.to(r1, r8)
            r8 = r11
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            r11.L$0 = r7
            r11.L$1 = r12
            r9 = 7
            r11.label = r9
            java.lang.Object r1 = r7.emit(r1, r8)
            if (r1 != r0) goto L_0x0163
            return r0
        L_0x0163:
            r1 = r12
        L_0x0164:
            com.microtech.aidexx.ui.account.AccountViewModel r12 = r11.this$0
            java.lang.Object r8 = r1.getFirst()
            java.lang.String r8 = (java.lang.String) r8
            r9 = r11
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r11.L$0 = r7
            r11.L$1 = r1
            r10 = 8
            r11.label = r10
            java.lang.Object r12 = r12.downloadData(r8, r9)
            if (r12 != r0) goto L_0x017e
            return r0
        L_0x017e:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x01d3
            com.microtech.aidexx.common.user.UserInfoManager$Companion r12 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r12 = r12.instance()
            r12.updateLoginFlag(r5)
            java.lang.Object r12 = r1.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            if (r12 == r5) goto L_0x01b7
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            java.lang.String r1 = "引导"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r1)
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.L$0 = r6
            r11.L$1 = r6
            r2 = 9
            r11.label = r2
            java.lang.Object r12 = r7.emit(r12, r1)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x01b7:
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            java.lang.String r1 = "登录成功"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r1)
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.L$0 = r6
            r11.L$1 = r6
            r2 = 10
            r11.label = r2
            java.lang.Object r12 = r7.emit(r12, r1)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x01d3:
            com.microtech.aidexx.utils.mmkv.MmkvManager r12 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r2 = ""
            r12.saveToken(r2)
            com.microtech.aidexx.db.repository.AccountDbRepository r12 = com.microtech.aidexx.db.repository.AccountDbRepository.INSTANCE
            java.lang.Object r1 = r1.getFirst()
            java.lang.String r1 = (java.lang.String) r1
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.L$0 = r7
            r11.L$1 = r6
            r3 = 11
            r11.label = r3
            java.lang.Object r12 = r12.removeUserByUId(r1, r2)
            if (r12 != r0) goto L_0x01f4
            return r0
        L_0x01f4:
            r1 = r7
        L_0x01f5:
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r2 = "数据下载失败"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r2)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.L$0 = r6
            r3 = 12
            r11.label = r3
            java.lang.Object r12 = r1.emit(r12, r2)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x020f:
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r1 = "登录成功，用户信息拉取失败"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r1)
            r1 = r11
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r11.L$0 = r6
            r2 = 13
            r11.label = r2
            java.lang.Object r12 = r7.emit(r12, r1)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x0229:
            boolean r2 = r12 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r2 == 0) goto L_0x024c
            r2 = -2
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r2)
            com.microtech.aidexx.common.net.ApiResult$Failure r12 = (com.microtech.aidexx.common.net.ApiResult.Failure) r12
            java.lang.String r12 = r12.getMsg()
            kotlin.Pair r12 = kotlin.TuplesKt.to(r2, r12)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.L$0 = r6
            r3 = 14
            r11.label = r3
            java.lang.Object r12 = r1.emit(r12, r2)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x024c:
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
            java.lang.String r2 = "暂不支持该方式登录"
            kotlin.Pair r12 = kotlin.TuplesKt.to(r12, r2)
            r2 = r11
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r11.L$0 = r6
            r3 = 15
            r11.label = r3
            java.lang.Object r12 = r1.emit(r12, r2)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x0266:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.AccountViewModel$login$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
