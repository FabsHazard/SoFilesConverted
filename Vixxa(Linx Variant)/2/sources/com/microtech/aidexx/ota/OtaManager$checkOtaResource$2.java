package com.microtech.aidexx.ota;

import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.repository.ApiRepository;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.utils.LogUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager$checkOtaResource$2", f = "OtaManager.kt", i = {0}, l = {239, 315}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
/* compiled from: OtaManager.kt */
final class OtaManager$checkOtaResource$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ OtaManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OtaManager$checkOtaResource$2(OtaManager otaManager, Continuation<? super OtaManager$checkOtaResource$2> continuation) {
        super(2, continuation);
        this.this$0 = otaManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        OtaManager$checkOtaResource$2 otaManager$checkOtaResource$2 = new OtaManager$checkOtaResource$2(this.this$0, continuation);
        otaManager$checkOtaResource$2.L$0 = obj;
        return otaManager$checkOtaResource$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtaManager$checkOtaResource$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        Object obj3;
        CoroutineScope coroutineScope;
        String str;
        OtaResourceEntity otaResourceEntity;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            coroutineScope = (CoroutineScope) this.L$0;
            this.L$0 = coroutineScope;
            this.label = 1;
            obj3 = ApiRepository.INSTANCE.checkOtaResource(this);
            if (obj3 == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj3 = obj;
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            obj2 = obj;
            List list = (List) obj2;
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj3;
        if (apiResult instanceof ApiResult.Success) {
            Object result = ((ApiResult.Success) apiResult).getResult();
            OtaManager otaManager = this.this$0;
            List list2 = (List) ((BaseResponse) result).getData();
            if (list2 != null) {
                File file = new File(OtaManager.Companion.getOtaRootPath());
                if (!file.exists()) {
                    file.mkdirs();
                }
                Iterable<OtaResourceEntity> iterable = list2;
                Map linkedHashMap = new LinkedHashMap();
                for (Object next : iterable) {
                    String genTypeKey = ((OtaResourceEntity) next).genTypeKey();
                    Object obj4 = linkedHashMap.get(genTypeKey);
                    if (obj4 == null) {
                        obj4 = new ArrayList();
                        linkedHashMap.put(genTypeKey, obj4);
                    }
                    ((List) obj4).add(next);
                }
                Collection arrayList = new ArrayList(linkedHashMap.size());
                Iterator it = linkedHashMap.entrySet().iterator();
                while (true) {
                    List list3 = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Collection sortedWith = CollectionsKt.sortedWith((Iterable) ((Map.Entry) it.next()).getValue(), new OtaManager$checkOtaResource$2$$ExternalSyntheticLambda0(OtaManager$checkOtaResource$2$1$1$latestVersionInfo$2$1.INSTANCE));
                    if (!sortedWith.isEmpty()) {
                        list3 = sortedWith;
                    }
                    List list4 = list3;
                    if (list4 == null || (otaResourceEntity = (OtaResourceEntity) CollectionsKt.last(list4)) == null || (str = otaResourceEntity.genEntityKey()) == null) {
                        str = "";
                    }
                    arrayList.add(str);
                }
                List list5 = (List) arrayList;
                String tag = OtaManager.Companion.getTAG();
                Intrinsics.checkNotNullExpressionValue(tag, "<get-TAG>(...)");
                LogUtil.Companion.xLogI("最大版本项=" + CollectionsKt.joinToString$default(list5, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null), tag);
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (OtaResourceEntity otaManager$checkOtaResource$2$1$1$1$1 : iterable) {
                    arrayList2.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new OtaManager$checkOtaResource$2$1$1$1$1(otaManager$checkOtaResource$2$1$1$1$1, list5, otaManager, (Continuation<? super OtaManager$checkOtaResource$2$1$1$1$1>) null), 3, (Object) null));
                }
                this.L$0 = null;
                this.label = 2;
                obj2 = AwaitKt.awaitAll((List) arrayList2, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                List list6 = (List) obj2;
            }
        } else if (apiResult instanceof ApiResult.Failure) {
            String tag2 = OtaManager.Companion.getTAG();
            Intrinsics.checkNotNullExpressionValue(tag2, "<get-TAG>(...)");
            LogUtil.Companion.xLogE("check OTA resource fail : " + ((ApiResult.Failure) apiResult).getMsg(), tag2);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final int invokeSuspend$lambda$6$lambda$5$lambda$3$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }
}
