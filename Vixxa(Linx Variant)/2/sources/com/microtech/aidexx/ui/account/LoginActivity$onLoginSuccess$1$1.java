package com.microtech.aidexx.ui.account;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.LoginActivity$onLoginSuccess$1$1", f = "LoginActivity.kt", i = {}, l = {160, 163}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LoginActivity.kt */
final class LoginActivity$onLoginSuccess$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $curLanguageTag;
    final /* synthetic */ String $it;
    final /* synthetic */ boolean $needToGuide;
    int label;
    final /* synthetic */ LoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LoginActivity$onLoginSuccess$1$1(String str, boolean z, LoginActivity loginActivity, String str2, Continuation<? super LoginActivity$onLoginSuccess$1$1> continuation) {
        super(2, continuation);
        this.$curLanguageTag = str;
        this.$needToGuide = z;
        this.this$0 = loginActivity;
        this.$it = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoginActivity$onLoginSuccess$1$1(this.$curLanguageTag, this.$needToGuide, this.this$0, this.$it, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoginActivity$onLoginSuccess$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001e
            if (r1 == r3) goto L_0x001a
            if (r1 != r2) goto L_0x0012
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0060
        L_0x0012:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x001a:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x002f
        L_0x001e:
            kotlin.ResultKt.throwOnFailure(r7)
            com.microtech.aidexx.data.resource.LanguageResourceManager r7 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE
            r1 = r6
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r6.label = r3
            java.lang.Object r7 = r7.getSupportLanguages(r1)
            if (r7 != r0) goto L_0x002f
            return r0
        L_0x002f:
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.String r1 = r6.$it
            java.util.Iterator r7 = r7.iterator()
        L_0x0037:
            boolean r3 = r7.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x0050
            java.lang.Object r3 = r7.next()
            r5 = r3
            com.microtech.aidexx.db.entity.LanguageConfEntity r5 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r5
            java.lang.String r5 = r5.getCode()
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r1)
            if (r5 == 0) goto L_0x0037
            goto L_0x0051
        L_0x0050:
            r3 = r4
        L_0x0051:
            com.microtech.aidexx.db.entity.LanguageConfEntity r3 = (com.microtech.aidexx.db.entity.LanguageConfEntity) r3
            if (r3 == 0) goto L_0x0062
            com.microtech.aidexx.data.resource.LanguageResourceManager r7 = com.microtech.aidexx.data.resource.LanguageResourceManager.INSTANCE
            r6.label = r2
            java.lang.Object r7 = r7.onLanguageChanged(r3, r6)
            if (r7 != r0) goto L_0x0060
            return r0
        L_0x0060:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
        L_0x0062:
            if (r4 != 0) goto L_0x006b
            com.microtech.aidexx.ui.setting.SettingsManager r7 = com.microtech.aidexx.ui.setting.SettingsManager.INSTANCE
            java.lang.String r0 = r6.$curLanguageTag
            r7.setLanguage(r0)
        L_0x006b:
            boolean r7 = r6.$needToGuide
            if (r7 == 0) goto L_0x0075
            com.microtech.aidexx.ui.account.LoginActivity r7 = r6.this$0
            r7.guide()
            goto L_0x007a
        L_0x0075:
            com.microtech.aidexx.ui.account.LoginActivity r7 = r6.this$0
            r7.toMain()
        L_0x007a:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.account.LoginActivity$onLoginSuccess$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
