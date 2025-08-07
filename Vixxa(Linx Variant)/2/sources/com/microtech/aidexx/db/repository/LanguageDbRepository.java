package com.microtech.aidexx.db.repository;

import com.microtech.aidexx.db.dao.LanguageDao;
import com.microtech.aidexx.db.entity.LanguageConfEntity;
import com.microtech.aidexx.db.entity.LanguageEntity;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u000f\u001a\u0004\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00100\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ7\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0018\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001c\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0013\u0010\u001d\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u001b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001b\u0010!\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/db/repository/LanguageDbRepository;", "", "()V", "dao", "Lcom/microtech/aidexx/db/dao/LanguageDao;", "getDao", "()Lcom/microtech/aidexx/db/dao/LanguageDao;", "dao$delegate", "Lkotlin/Lazy;", "insert", "", "list", "", "Lcom/microtech/aidexx/db/entity/LanguageEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertConf", "Lcom/microtech/aidexx/db/entity/LanguageConfEntity;", "query", "language", "", "module", "version", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryConfById", "languageId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySupportLanguages", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeAll", "removeAllConf", "removeLanguageConfOfOtherVersion", "", "exceptVersion", "removeLanguageOfOtherVersion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageDbRepository.kt */
public final class LanguageDbRepository {
    private final Lazy dao$delegate = LazyKt.lazy(LanguageDbRepository$dao$2.INSTANCE);

    private final LanguageDao getDao() {
        return (LanguageDao) this.dao$delegate.getValue();
    }

    public final Object insert(List<LanguageEntity> list, Continuation<? super Unit> continuation) {
        return getDao().insert(list, continuation);
    }

    public static /* synthetic */ Object query$default(LanguageDbRepository languageDbRepository, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = MmkvManager.INSTANCE.getLanguageVersion();
        }
        return languageDbRepository.query(str, str2, str3, continuation);
    }

    public final Object query(String str, String str2, String str3, Continuation<? super List<LanguageEntity>> continuation) {
        return getDao().query(str, str2, str3, continuation);
    }

    public final Object removeLanguageOfOtherVersion(String str, Continuation<? super Long> continuation) {
        return getDao().removeLanguageOfOtherVersion(str, continuation);
    }

    public final Object removeAll(Continuation<? super Unit> continuation) {
        return getDao().removeAll(continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object querySupportLanguages(kotlin.coroutines.Continuation<? super java.util.List<com.microtech.aidexx.db.entity.LanguageConfEntity>> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.db.repository.LanguageDbRepository$querySupportLanguages$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.db.repository.LanguageDbRepository$querySupportLanguages$1 r0 = (com.microtech.aidexx.db.repository.LanguageDbRepository$querySupportLanguages$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.db.repository.LanguageDbRepository$querySupportLanguages$1 r0 = new com.microtech.aidexx.db.repository.LanguageDbRepository$querySupportLanguages$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0064
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.db.repository.LanguageDbRepository r2 = (com.microtech.aidexx.db.repository.LanguageDbRepository) r2
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.db.dao.LanguageDao r6 = r5.getDao()
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.querySupportLanguages(r0)
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r2 = r5
        L_0x0050:
            java.lang.String[] r6 = (java.lang.String[]) r6
            r4 = 0
            if (r6 == 0) goto L_0x0067
            com.microtech.aidexx.db.dao.LanguageDao r2 = r2.getDao()
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r2.queryConfs(r6, r0)
            if (r6 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r4 = r6
            java.util.List r4 = (java.util.List) r4
        L_0x0067:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.repository.LanguageDbRepository.querySupportLanguages(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object queryConfById(String str, Continuation<? super LanguageConfEntity> continuation) {
        return getDao().queryConf(str, continuation);
    }

    public final Object removeAllConf(Continuation<? super Unit> continuation) {
        return getDao().removeAllConf(continuation);
    }

    public final Object insertConf(List<LanguageConfEntity> list, Continuation<? super Unit> continuation) {
        return getDao().insertConf(list, continuation);
    }

    public final Object removeLanguageConfOfOtherVersion(String str, Continuation<? super Long> continuation) {
        return getDao().removeLanguageConfOfOtherVersion(str, continuation);
    }
}
