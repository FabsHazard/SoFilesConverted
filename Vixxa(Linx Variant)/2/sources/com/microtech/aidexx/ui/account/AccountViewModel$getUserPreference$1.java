package com.microtech.aidexx.ui.account;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.ApiService;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel$getUserPreference$1", f = "AccountViewModel.kt", i = {}, l = {169}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AccountViewModel.kt */
final class AccountViewModel$getUserPreference$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Unit> $failure;
    final /* synthetic */ Function1<BaseResponse<List<UserPreferenceEntity>>, Unit> $success;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccountViewModel$getUserPreference$1(Function1<? super BaseResponse<List<UserPreferenceEntity>>, Unit> function1, Function0<Unit> function0, Continuation<? super AccountViewModel$getUserPreference$1> continuation) {
        super(2, continuation);
        this.$success = function1;
        this.$failure = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AccountViewModel$getUserPreference$1(this.$success, this.$failure, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AccountViewModel$getUserPreference$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.account.AccountViewModel$getUserPreference$1$1", f = "AccountViewModel.kt", i = {}, l = {170, 173, 180}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.account.AccountViewModel$getUserPreference$1$1  reason: invalid class name */
    /* compiled from: AccountViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(function1, function0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                obj = ApiService.Companion.getInstance().getUserPreference(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                Unit unit = (Unit) obj;
                return Unit.INSTANCE;
            } else if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ApiResult apiResult = (ApiResult) obj;
            if (apiResult instanceof ApiResult.Success) {
                Object result = ((ApiResult.Success) apiResult).getResult();
                this.label = 2;
                obj = BuildersKt.withContext(Dispatchers.getMain(), new AccountViewModel$getUserPreference$1$1$1$1(function1, (BaseResponse) result, (Continuation<? super AccountViewModel$getUserPreference$1$1$1$1>) null), this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                Unit unit2 = (Unit) obj;
                return Unit.INSTANCE;
            }
            if (apiResult instanceof ApiResult.Failure) {
                final Function0<Unit> function0 = function0;
                this.label = 3;
                if (BuildersKt.withContext(Dispatchers.getMain(), new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass2>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 

                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                final Function1<BaseResponse<List<UserPreferenceEntity>>, Unit> function1 = this.$success;
                                final Function0<Unit> function0 = this.$failure;
                                this.label = 1;
                                if (BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else if (i == 1) {
                                ResultKt.throwOnFailure(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
