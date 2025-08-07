package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.ui.account.entity.UserPreferenceEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel$getUserPreference$1$1$1$1", f = "AccountViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$getUserPreference$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BaseResponse<List<UserPreferenceEntity>> $result;
    final /* synthetic */ Function1<BaseResponse<List<UserPreferenceEntity>>, Unit> $success;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$getUserPreference$1$1$1$1(Function1<? super BaseResponse<List<UserPreferenceEntity>>, Unit> function1, BaseResponse<List<UserPreferenceEntity>> baseResponse, Continuation<? super AccountViewModel$getUserPreference$1$1$1$1> continuation) {
        super(2, continuation);
        this.$success = function1;
        this.$result = baseResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountViewModel$getUserPreference$1$1$1$1(this.$success, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountViewModel$getUserPreference$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<BaseResponse<List<UserPreferenceEntity>>, Unit> function1 = this.$success;
            if (function1 == null) {
                return null;
            }
            function1.invoke(this.$result);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
