package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqPageInfo;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "pageNum", "", "pageSize", "userId", "", "(IILjava/lang/String;)V", "getPageNum", "()I", "setPageNum", "(I)V", "getPageSize", "setPageSize", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public class ReqPageInfo extends ReqEntity {
    private int pageNum;
    private int pageSize;
    private String userId;

    public ReqPageInfo() {
        this(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReqPageInfo(int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 1 : i, (i3 & 2) != 0 ? 500 : i2, (i3 & 4) != 0 ? null : str);
    }

    public final int getPageNum() {
        return this.pageNum;
    }

    public final void setPageNum(int i) {
        this.pageNum = i;
    }

    public final int getPageSize() {
        return this.pageSize;
    }

    public final void setPageSize(int i) {
        this.pageSize = i;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public ReqPageInfo(int i, int i2, String str) {
        this.pageNum = i;
        this.pageSize = i2;
        this.userId = str;
    }
}
