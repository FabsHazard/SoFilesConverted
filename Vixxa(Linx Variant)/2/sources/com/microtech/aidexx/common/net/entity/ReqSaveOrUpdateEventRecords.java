package com.microtech.aidexx.common.net.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqSaveOrUpdateEventRecords;", "T", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "records", "", "(Ljava/util/List;)V", "getRecords", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqSaveOrUpdateEventRecords<T> extends ReqEntity {
    private final List<T> records;

    public static /* synthetic */ ReqSaveOrUpdateEventRecords copy$default(ReqSaveOrUpdateEventRecords reqSaveOrUpdateEventRecords, List<T> list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = reqSaveOrUpdateEventRecords.records;
        }
        return reqSaveOrUpdateEventRecords.copy(list);
    }

    public final List<T> component1() {
        return this.records;
    }

    public final ReqSaveOrUpdateEventRecords<T> copy(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        return new ReqSaveOrUpdateEventRecords<>(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReqSaveOrUpdateEventRecords) && Intrinsics.areEqual((Object) this.records, (Object) ((ReqSaveOrUpdateEventRecords) obj).records);
    }

    public int hashCode() {
        return this.records.hashCode();
    }

    public String toString() {
        return "ReqSaveOrUpdateEventRecords(records=" + this.records + ')';
    }

    public final List<T> getRecords() {
        return this.records;
    }

    public ReqSaveOrUpdateEventRecords(List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "records");
        this.records = list;
    }
}
