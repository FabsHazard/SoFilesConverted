package com.microtech.aidexx.ui.main.event;

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
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005*\u00020\u0006H@"}, d2 = {"<anonymous>", "", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1", f = "BaseEventFragment.kt", i = {}, l = {256, 256}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: BaseEventFragment.kt */
final class BaseEventFragment$onSaveClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $cb;
    final /* synthetic */ boolean $ignoreDetailList;
    int label;
    final /* synthetic */ BaseEventFragment<VM, VB> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseEventFragment$onSaveClick$1(BaseEventFragment<VM, VB> baseEventFragment, boolean z, Function1<? super Boolean, Unit> function1, Continuation<? super BaseEventFragment$onSaveClick$1> continuation) {
        super(2, continuation);
        this.this$0 = baseEventFragment;
        this.$ignoreDetailList = z;
        this.$cb = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new BaseEventFragment$onSaveClick$1(this.this$0, this.$ignoreDetailList, this.$cb, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BaseEventFragment$onSaveClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getViewModel().save(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        final BaseEventFragment<VM, VB> baseEventFragment = this.this$0;
        final boolean z = this.$ignoreDetailList;
        final Function1<Boolean, Unit> function1 = this.$cb;
        this.label = 2;
        if (((Flow) obj).collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x008d  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(kotlin.Pair<java.lang.Boolean, ? extends com.microtech.aidexx.db.entity.BaseEventEntity> r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1$emit$1
                    if (r0 == 0) goto L_0x0014
                    r0 = r7
                    com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1$emit$1 r0 = (com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1$emit$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r7 = r0.label
                    int r7 = r7 - r2
                    r0.label = r7
                    goto L_0x0019
                L_0x0014:
                    com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1$emit$1 r0 = new com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1$emit$1
                    r0.<init>(r5, r7)
                L_0x0019:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0036
                    if (r2 != r3) goto L_0x002e
                    java.lang.Object r6 = r0.L$0
                    com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1$1 r6 = (com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1.AnonymousClass1) r6
                    kotlin.ResultKt.throwOnFailure(r7)
                    goto L_0x0089
                L_0x002e:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0036:
                    kotlin.ResultKt.throwOnFailure(r7)
                    java.lang.Object r7 = r6.getFirst()
                    java.lang.Boolean r7 = (java.lang.Boolean) r7
                    boolean r7 = r7.booleanValue()
                    if (r7 == 0) goto L_0x0095
                    com.microtech.aidexx.ui.main.event.BaseEventFragment<VM, VB> r6 = r3
                    int r7 = com.microtech.aidexx.R.string.com_actionState_success
                    com.microtech.aidexx.ui.main.event.BaseEventFragment<VM, VB> r2 = r3
                    int r4 = com.microtech.aidexx.R.string.com_action_save
                    java.lang.String r2 = r2.getString(r4)
                    java.lang.Object[] r2 = new java.lang.Object[]{r2}
                    java.lang.String r6 = r6.getString(r7, r2)
                    java.lang.String r7 = "getString(...)"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
                    com.microtech.aidexx.common.ExtendsKt.toast(r6)
                    boolean r6 = r4
                    if (r6 != 0) goto L_0x007b
                    com.microtech.aidexx.ui.main.event.BaseEventFragment<VM, VB> r6 = r3
                    com.microtech.aidexx.ui.main.event.adapter.EventInputAdapter r6 = r6.getToSaveDetailAdapter()
                    java.util.List r6 = r6.getData()
                    r6.clear()
                    com.microtech.aidexx.ui.main.event.BaseEventFragment<VM, VB> r6 = r3
                    com.microtech.aidexx.ui.main.event.adapter.EventInputAdapter r6 = r6.getToSaveDetailAdapter()
                    r6.notifyDataSetChanged()
                L_0x007b:
                    com.microtech.aidexx.ui.main.event.BaseEventFragment<VM, VB> r6 = r3
                    r0.L$0 = r5
                    r0.label = r3
                    java.lang.Object r6 = r6.updateHistoryUi(r0)
                    if (r6 != r1) goto L_0x0088
                    return r1
                L_0x0088:
                    r6 = r5
                L_0x0089:
                    kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r6 = r5
                    if (r6 == 0) goto L_0x00b9
                    java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
                    r6.invoke(r7)
                    goto L_0x00b9
                L_0x0095:
                    com.microtech.aidexx.utils.LogUtil$Companion r7 = com.microtech.aidexx.utils.LogUtil.Companion
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "事件保存失败 "
                    r0.<init>(r1)
                    java.lang.Object r6 = r6.getSecond()
                    java.lang.StringBuilder r6 = r0.append(r6)
                    java.lang.String r6 = r6.toString()
                    r7.eAiDEX(r6)
                    kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r6 = r5
                    if (r6 == 0) goto L_0x00b9
                    r7 = 0
                    java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
                    r6.invoke(r7)
                L_0x00b9:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.event.BaseEventFragment$onSaveClick$1.AnonymousClass1.emit(kotlin.Pair, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
