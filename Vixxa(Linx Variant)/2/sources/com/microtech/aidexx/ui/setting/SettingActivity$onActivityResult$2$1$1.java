package com.microtech.aidexx.ui.setting;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.SettingActivity$onActivityResult$2$1$1", f = "SettingActivity.kt", i = {1}, l = {342, 346, 350, 351, 352}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
/* compiled from: SettingActivity.kt */
final class SettingActivity$onActivityResult$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $resultUri;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$onActivityResult$2$1$1(Uri uri, SettingActivity settingActivity, Continuation<? super SettingActivity$onActivityResult$2$1$1> continuation) {
        super(2, continuation);
        this.$resultUri = uri;
        this.this$0 = settingActivity;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingActivity$onActivityResult$2$1$1(this.$resultUri, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingActivity$onActivityResult$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x012f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0149 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r33) {
        /*
            r32 = this;
            r1 = r32
            java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.label
            r14 = 5
            r13 = 4
            r12 = 3
            r2 = 2
            r3 = 1
            java.lang.String r11 = "getString(...)"
            r10 = 0
            if (r0 == 0) goto L_0x0061
            if (r0 == r3) goto L_0x005b
            if (r0 == r2) goto L_0x0046
            if (r0 == r12) goto L_0x0039
            if (r0 == r13) goto L_0x002c
            if (r0 != r14) goto L_0x0024
            kotlin.ResultKt.throwOnFailure(r33)
            r2 = r1
            r28 = r11
            goto L_0x014a
        L_0x0024:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x002c:
            java.lang.Object r0 = r1.L$0
            com.microtech.aidexx.ui.setting.SettingActivity r0 = (com.microtech.aidexx.ui.setting.SettingActivity) r0
            kotlin.ResultKt.throwOnFailure(r33)
            r2 = r1
            r28 = r11
            r1 = r15
            goto L_0x0130
        L_0x0039:
            java.lang.Object r0 = r1.L$0
            com.microtech.aidexx.ui.setting.SettingActivity r0 = (com.microtech.aidexx.ui.setting.SettingActivity) r0
            kotlin.ResultKt.throwOnFailure(r33)
            r2 = r1
            r28 = r11
            r1 = r15
            goto L_0x0122
        L_0x0046:
            java.lang.Object r0 = r1.L$1
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r2 = r1.L$0
            com.microtech.aidexx.ui.setting.SettingActivity r2 = (com.microtech.aidexx.ui.setting.SettingActivity) r2
            kotlin.ResultKt.throwOnFailure(r33)
            r27 = r0
            r28 = r11
            r7 = r15
            r0 = r33
            r15 = r2
            goto L_0x00d5
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r33)
            r0 = r33
            goto L_0x0074
        L_0x0061:
            kotlin.ResultKt.throwOnFailure(r33)
            com.microtech.aidexx.common.net.repository.AccountRepository r0 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            android.net.Uri r4 = r1.$resultUri
            r5 = r1
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r1.label = r3
            java.lang.Object r0 = r0.userUploadAvatar(r4, r5)
            if (r0 != r15) goto L_0x0074
            return r15
        L_0x0074:
            com.microtech.aidexx.common.net.ApiResult r0 = (com.microtech.aidexx.common.net.ApiResult) r0
            boolean r3 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r3 == 0) goto L_0x0199
            com.microtech.aidexx.common.net.ApiResult$Success r0 = (com.microtech.aidexx.common.net.ApiResult.Success) r0
            java.lang.Object r0 = r0.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r0 = (com.microtech.aidexx.common.net.entity.BaseResponse) r0
            java.lang.Object r0 = r0.getData()
            r9 = r0
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L_0x0185
            com.microtech.aidexx.ui.setting.SettingActivity r8 = r1.this$0
            com.microtech.aidexx.common.net.repository.AccountRepository r0 = com.microtech.aidexx.common.net.repository.AccountRepository.INSTANCE
            r1.L$0 = r8
            r1.L$1 = r9
            r1.label = r2
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r16 = 0
            r26 = r8
            r8 = r16
            r27 = r9
            r9 = r16
            r10 = r16
            r28 = r11
            r11 = r16
            r12 = r16
            r13 = r16
            r14 = r16
            r29 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r24 = 4194302(0x3ffffe, float:5.877469E-39)
            r25 = 0
            r1 = r27
            r23 = r32
            java.lang.Object r0 = com.microtech.aidexx.common.net.repository.AccountRepository.updateUserInformation$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            r7 = r29
            if (r0 != r7) goto L_0x00d3
            return r7
        L_0x00d3:
            r15 = r26
        L_0x00d5:
            com.microtech.aidexx.common.net.ApiResult r0 = (com.microtech.aidexx.common.net.ApiResult) r0
            boolean r1 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r1 == 0) goto L_0x014d
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            r14 = r32
            r14.L$0 = r15
            r13 = 0
            r14.L$1 = r13
            r1 = 3
            r14.label = r1
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r16 = 0
            r13 = r16
            r14 = r16
            r30 = r15
            r15 = r16
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 2097087(0x1fffbf, float:2.938645E-39)
            r24 = 0
            r31 = r7
            r7 = r27
            r22 = r32
            java.lang.Object r0 = com.microtech.aidexx.common.user.UserInfoManager.updateProfile$default(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r1 = r31
            if (r0 != r1) goto L_0x011e
            return r1
        L_0x011e:
            r2 = r32
            r0 = r30
        L_0x0122:
            r2.L$0 = r0
            r3 = 4
            r2.label = r3
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r3, r2)
            if (r3 != r1) goto L_0x0130
            return r1
        L_0x0130:
            kotlinx.coroutines.MainCoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r3 = (kotlin.coroutines.CoroutineContext) r3
            com.microtech.aidexx.ui.setting.SettingActivity$onActivityResult$2$1$1$1$1 r4 = new com.microtech.aidexx.ui.setting.SettingActivity$onActivityResult$2$1$1$1$1
            r5 = 0
            r4.<init>(r0, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.L$0 = r5
            r0 = 5
            r2.label = r0
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r3, r4, r2)
            if (r0 != r1) goto L_0x014a
            return r1
        L_0x014a:
            r1 = r28
            goto L_0x0182
        L_0x014d:
            r5 = 0
            r2 = r32
            r30 = r15
            boolean r1 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r1 == 0) goto L_0x014a
            com.microtech.aidexx.views.dialog.Dialogs r1 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r1.dismissWait()
            com.microtech.aidexx.common.net.ApiResult$Failure r0 = (com.microtech.aidexx.common.net.ApiResult.Failure) r0
            java.lang.String r0 = r0.getMsg()
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r0 = r10.length()
            if (r0 != 0) goto L_0x016b
            r10 = r5
        L_0x016b:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x017d
            int r0 = com.microtech.aidexx.R.string.com_state_failure
            r1 = r30
            java.lang.String r10 = r1.getString(r0)
            r1 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
            goto L_0x017f
        L_0x017d:
            r1 = r28
        L_0x017f:
            com.microtech.aidexx.common.ExtendsKt.toast(r10)
        L_0x0182:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            goto L_0x0188
        L_0x0185:
            r2 = r1
            r5 = r10
            r1 = r11
        L_0x0188:
            if (r10 != 0) goto L_0x01c7
            com.microtech.aidexx.ui.setting.SettingActivity r0 = r2.this$0
            int r3 = com.microtech.aidexx.R.string.com_state_failure
            java.lang.String r0 = r0.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.microtech.aidexx.common.ExtendsKt.toast(r0)
            goto L_0x01c7
        L_0x0199:
            r2 = r1
            r5 = r10
            r1 = r11
            boolean r3 = r0 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r3 == 0) goto L_0x01c7
            com.microtech.aidexx.views.dialog.Dialogs r3 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            r3.dismissWait()
            com.microtech.aidexx.common.net.ApiResult$Failure r0 = (com.microtech.aidexx.common.net.ApiResult.Failure) r0
            java.lang.String r0 = r0.getMsg()
            r10 = r0
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            int r0 = r10.length()
            if (r0 != 0) goto L_0x01b5
            r10 = r5
        L_0x01b5:
            java.lang.String r10 = (java.lang.String) r10
            if (r10 != 0) goto L_0x01c4
            com.microtech.aidexx.ui.setting.SettingActivity r0 = r2.this$0
            int r3 = com.microtech.aidexx.R.string.com_state_failure
            java.lang.String r10 = r0.getString(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r1)
        L_0x01c4:
            com.microtech.aidexx.common.ExtendsKt.toast(r10)
        L_0x01c7:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.SettingActivity$onActivityResult$2$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
