package com.microtech.aidexx.data;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.db.repository.EventDbRepository;
import com.microtech.aidexx.utils.LogUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u001a*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002J\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ'\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J-\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/data/EventPresetSync;", "T", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "", "()V", "limitController", "Lcom/microtech/aidexx/data/SyncFrequencyLimitController;", "tClazz", "Ljava/lang/Class;", "canSync", "", "xLogInfo", "", "getNeedUploadData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpload", "data", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateEventDataAfterUpload", "", "origin", "responseList", "(Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "upload", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventPresetSync.kt */
public abstract class EventPresetSync<T extends BasePresetEntity> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final EventPresetSync$Companion$dietPresetSync$1 dietPresetSync = new EventPresetSync$Companion$dietPresetSync$1();
    /* access modifiers changed from: private */
    public static final EventPresetSync$Companion$exercisePresetSync$1 exercisePresetSync = new EventPresetSync$Companion$exercisePresetSync$1();
    /* access modifiers changed from: private */
    public static final EventPresetSync$Companion$insulinPresetSync$1 insulinPresetSync = new EventPresetSync$Companion$insulinPresetSync$1();
    /* access modifiers changed from: private */
    public static boolean isSyncing;
    /* access modifiers changed from: private */
    public static final EventPresetSync$Companion$medicinePresetSync$1 medicinePresetSync = new EventPresetSync$Companion$medicinePresetSync$1();
    private final SyncFrequencyLimitController limitController = new SyncFrequencyLimitController();
    private final Class<T> tClazz;

    public abstract Object getNeedUploadData(Continuation<? super List<T>> continuation);

    public Object upload(Continuation<? super Unit> continuation) {
        return upload$suspendImpl(this, continuation);
    }

    public EventPresetSync() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<T of com.microtech.aidexx.data.EventPresetSync>");
        this.tClazz = (Class) type;
    }

    static /* synthetic */ boolean canSync$default(EventPresetSync eventPresetSync, String str, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                str = "";
            }
            return eventPresetSync.canSync(str);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: canSync");
    }

    private final boolean canSync(String str) {
        if (UserInfoManager.Companion.instance().isLogin()) {
            return true;
        }
        LogUtil.Companion.xLogE$default(LogUtil.Companion, str + " 未登录，" + this.tClazz.getSimpleName() + " 停止", (String) null, 2, (Object) null);
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object saveOrUpload(java.util.List<? extends T> r7, kotlin.coroutines.Continuation<? super java.util.List<T>> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.data.EventPresetSync$saveOrUpload$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.data.EventPresetSync$saveOrUpload$1 r0 = (com.microtech.aidexx.data.EventPresetSync$saveOrUpload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventPresetSync$saveOrUpload$1 r0 = new com.microtech.aidexx.data.EventPresetSync$saveOrUpload$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r7 = r0.L$0
            com.microtech.aidexx.data.EventPresetSync r7 = (com.microtech.aidexx.data.EventPresetSync) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0066
        L_0x002f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r8)
            com.microtech.aidexx.data.SyncFrequencyLimitController r8 = r6.limitController
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r5 = "上传-"
            r2.<init>(r5)
            java.lang.Class<T> r5 = r6.tClazz
            java.lang.String r5 = r5.getSimpleName()
            java.lang.StringBuilder r2 = r2.append(r5)
            java.lang.String r2 = r2.toString()
            boolean r8 = r8.canDo(r2)
            if (r8 != 0) goto L_0x0058
            return r3
        L_0x0058:
            com.microtech.aidexx.common.net.repository.EventRepository r8 = com.microtech.aidexx.common.net.repository.EventRepository.INSTANCE
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r8 = r8.saveOrUpdateRecords(r7, r0)
            if (r8 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r7 = r6
        L_0x0066:
            com.microtech.aidexx.common.net.ApiResult r8 = (com.microtech.aidexx.common.net.ApiResult) r8
            boolean r0 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Success
            if (r0 == 0) goto L_0x0087
            com.microtech.aidexx.data.SyncFrequencyLimitController r7 = r7.limitController
            r7.resetNextDoTime()
            com.microtech.aidexx.common.net.ApiResult$Success r8 = (com.microtech.aidexx.common.net.ApiResult.Success) r8
            java.lang.Object r7 = r8.getResult()
            com.microtech.aidexx.common.net.entity.BaseResponse r7 = (com.microtech.aidexx.common.net.entity.BaseResponse) r7
            java.lang.Object r7 = r7.getData()
            java.lang.String r8 = "null cannot be cast to non-null type kotlin.collections.MutableList<T of com.microtech.aidexx.data.EventPresetSync>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r8)
            java.util.List r3 = kotlin.jvm.internal.TypeIntrinsics.asMutableList(r7)
            goto L_0x008b
        L_0x0087:
            boolean r7 = r8 instanceof com.microtech.aidexx.common.net.ApiResult.Failure
            if (r7 == 0) goto L_0x008c
        L_0x008b:
            return r3
        L_0x008c:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventPresetSync.saveOrUpload(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ <T extends com.microtech.aidexx.db.entity.event.preset.BasePresetEntity> java.lang.Object upload$suspendImpl(com.microtech.aidexx.data.EventPresetSync<T> r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            boolean r0 = r9 instanceof com.microtech.aidexx.data.EventPresetSync$upload$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.microtech.aidexx.data.EventPresetSync$upload$1 r0 = (com.microtech.aidexx.data.EventPresetSync$upload$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.data.EventPresetSync$upload$1 r0 = new com.microtech.aidexx.data.EventPresetSync$upload$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x004e
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009a
        L_0x0032:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x003a:
            java.lang.Object r8 = r0.L$1
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.data.EventPresetSync r2 = (com.microtech.aidexx.data.EventPresetSync) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0089
        L_0x0046:
            java.lang.Object r8 = r0.L$0
            com.microtech.aidexx.data.EventPresetSync r8 = (com.microtech.aidexx.data.EventPresetSync) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0067
        L_0x004e:
            kotlin.ResultKt.throwOnFailure(r9)
            java.lang.String r9 = "上传数据"
            boolean r9 = r8.canSync(r9)
            if (r9 != 0) goto L_0x005c
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        L_0x005c:
            r0.L$0 = r8
            r0.label = r5
            java.lang.Object r9 = r8.getNeedUploadData(r0)
            if (r9 != r1) goto L_0x0067
            return r1
        L_0x0067:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x009a
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r2 = r9.isEmpty()
            if (r2 == 0) goto L_0x0074
            r9 = r6
        L_0x0074:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x009a
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r2 = r8.saveOrUpload(r9, r0)
            if (r2 != r1) goto L_0x0085
            return r1
        L_0x0085:
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x0089:
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x009a
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r8 = r2.updateEventDataAfterUpload(r8, r9, r0)
            if (r8 != r1) goto L_0x009a
            return r1
        L_0x009a:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.EventPresetSync.upload$suspendImpl(com.microtech.aidexx.data.EventPresetSync, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object updateEventDataAfterUpload(List<T> list, List<T> list2, Continuation<? super Unit> continuation) {
        Object obj;
        for (T t : list) {
            if (t.getServerPresetId() == null) {
                Iterator it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) t, (Object) (BasePresetEntity) obj)) {
                        break;
                    }
                }
                BasePresetEntity basePresetEntity = (BasePresetEntity) obj;
                if (basePresetEntity != null) {
                    t.setServerPresetId(basePresetEntity.getServerPresetId());
                    Boxing.boxBoolean(list2.remove(basePresetEntity));
                }
            }
        }
        Object insertPresetData = EventDbRepository.INSTANCE.insertPresetData((List<? extends BasePresetEntity>) list, continuation);
        return insertPresetData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? insertPresetData : Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0004\u0004\u0007\n\u000f\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u0010\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/microtech/aidexx/data/EventPresetSync$Companion;", "", "()V", "dietPresetSync", "com/microtech/aidexx/data/EventPresetSync$Companion$dietPresetSync$1", "Lcom/microtech/aidexx/data/EventPresetSync$Companion$dietPresetSync$1;", "exercisePresetSync", "com/microtech/aidexx/data/EventPresetSync$Companion$exercisePresetSync$1", "Lcom/microtech/aidexx/data/EventPresetSync$Companion$exercisePresetSync$1;", "insulinPresetSync", "com/microtech/aidexx/data/EventPresetSync$Companion$insulinPresetSync$1", "Lcom/microtech/aidexx/data/EventPresetSync$Companion$insulinPresetSync$1;", "isSyncing", "", "medicinePresetSync", "com/microtech/aidexx/data/EventPresetSync$Companion$medicinePresetSync$1", "Lcom/microtech/aidexx/data/EventPresetSync$Companion$medicinePresetSync$1;", "uploadPreset", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EventPresetSync.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object uploadPreset(Continuation<? super Unit> continuation) {
            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new EventPresetSync$Companion$uploadPreset$2((Continuation<? super EventPresetSync$Companion$uploadPreset$2>) null), continuation);
            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
        }
    }
}
