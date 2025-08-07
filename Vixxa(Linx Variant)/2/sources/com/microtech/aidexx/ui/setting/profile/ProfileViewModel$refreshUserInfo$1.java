package com.microtech.aidexx.ui.setting.profile;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.profile.ProfileViewModel", f = "ProfileViewModel.kt", i = {}, l = {231, 236}, m = "refreshUserInfo", n = {}, s = {})
/* compiled from: ProfileViewModel.kt */
final class ProfileViewModel$refreshUserInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProfileViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileViewModel$refreshUserInfo$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$refreshUserInfo$1> continuation) {
        super(continuation);
        this.this$0 = profileViewModel;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.refreshUserInfo(this);
    }
}
