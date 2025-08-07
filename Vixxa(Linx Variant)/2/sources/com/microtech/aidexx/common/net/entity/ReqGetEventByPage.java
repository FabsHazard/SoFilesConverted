package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqGetEventByPage;", "Lcom/microtech/aidexx/common/net/entity/ReqPageInfo;", "startAutoIncrementColumn", "", "endAutoIncrementColumn", "orderStrategy", "", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;)V", "getEndAutoIncrementColumn", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOrderStrategy", "()Ljava/lang/String;", "getStartAutoIncrementColumn", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public class ReqGetEventByPage extends ReqPageInfo {
    private final Long endAutoIncrementColumn;
    private final String orderStrategy;
    private final Long startAutoIncrementColumn;

    public ReqGetEventByPage() {
        this((Long) null, (Long) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqGetEventByPage(Long l, Long l2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : str);
    }

    public final Long getStartAutoIncrementColumn() {
        return this.startAutoIncrementColumn;
    }

    public final Long getEndAutoIncrementColumn() {
        return this.endAutoIncrementColumn;
    }

    public final String getOrderStrategy() {
        return this.orderStrategy;
    }

    public ReqGetEventByPage(Long l, Long l2, String str) {
        super(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
        this.startAutoIncrementColumn = l;
        this.endAutoIncrementColumn = l2;
        this.orderStrategy = str;
    }
}
