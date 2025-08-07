package com.microtech.aidexx.common.net.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001&BC\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u0011JR\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010$\u001a\u00020\fHÖ\u0001J\t\u0010%\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/BasePageList;", "T", "", "pageInfo", "Lcom/microtech/aidexx/common/net/entity/BasePageList$PageInfo;", "records", "", "deviceSn", "", "startUp", "", "et", "", "(Lcom/microtech/aidexx/common/net/entity/BasePageList$PageInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)V", "getDeviceSn", "()Ljava/lang/String;", "getEt", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageInfo", "()Lcom/microtech/aidexx/common/net/entity/BasePageList$PageInfo;", "getRecords", "()Ljava/util/List;", "getStartUp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/microtech/aidexx/common/net/entity/BasePageList$PageInfo;Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;)Lcom/microtech/aidexx/common/net/entity/BasePageList;", "equals", "", "other", "hashCode", "toString", "PageInfo", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BasePageList.kt */
public final class BasePageList<T> {
    private final String deviceSn;
    private final Integer et;
    private final PageInfo pageInfo;
    private final List<T> records;
    private final Long startUp;

    public BasePageList() {
        this((PageInfo) null, (List) null, (String) null, (Long) null, (Integer) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BasePageList copy$default(BasePageList basePageList, PageInfo pageInfo2, List<T> list, String str, Long l, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            pageInfo2 = basePageList.pageInfo;
        }
        if ((i & 2) != 0) {
            list = basePageList.records;
        }
        List<T> list2 = list;
        if ((i & 4) != 0) {
            str = basePageList.deviceSn;
        }
        String str2 = str;
        if ((i & 8) != 0) {
            l = basePageList.startUp;
        }
        Long l2 = l;
        if ((i & 16) != 0) {
            num = basePageList.et;
        }
        return basePageList.copy(pageInfo2, list2, str2, l2, num);
    }

    public final PageInfo component1() {
        return this.pageInfo;
    }

    public final List<T> component2() {
        return this.records;
    }

    public final String component3() {
        return this.deviceSn;
    }

    public final Long component4() {
        return this.startUp;
    }

    public final Integer component5() {
        return this.et;
    }

    public final BasePageList<T> copy(PageInfo pageInfo2, List<T> list, String str, Long l, Integer num) {
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        Intrinsics.checkNotNullParameter(list, "records");
        return new BasePageList(pageInfo2, list, str, l, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasePageList)) {
            return false;
        }
        BasePageList basePageList = (BasePageList) obj;
        return Intrinsics.areEqual((Object) this.pageInfo, (Object) basePageList.pageInfo) && Intrinsics.areEqual((Object) this.records, (Object) basePageList.records) && Intrinsics.areEqual((Object) this.deviceSn, (Object) basePageList.deviceSn) && Intrinsics.areEqual((Object) this.startUp, (Object) basePageList.startUp) && Intrinsics.areEqual((Object) this.et, (Object) basePageList.et);
    }

    public int hashCode() {
        int hashCode = ((this.pageInfo.hashCode() * 31) + this.records.hashCode()) * 31;
        String str = this.deviceSn;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l = this.startUp;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num = this.et;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "BasePageList(pageInfo=" + this.pageInfo + ", records=" + this.records + ", deviceSn=" + this.deviceSn + ", startUp=" + this.startUp + ", et=" + this.et + ')';
    }

    public BasePageList(PageInfo pageInfo2, List<T> list, String str, Long l, Integer num) {
        Intrinsics.checkNotNullParameter(pageInfo2, "pageInfo");
        Intrinsics.checkNotNullParameter(list, "records");
        this.pageInfo = pageInfo2;
        this.records = list;
        this.deviceSn = str;
        this.startUp = l;
        this.et = num;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BasePageList(com.microtech.aidexx.common.net.entity.BasePageList.PageInfo r8, java.util.List r9, java.lang.String r10, java.lang.Long r11, java.lang.Integer r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x0011
            com.microtech.aidexx.common.net.entity.BasePageList$PageInfo r8 = new com.microtech.aidexx.common.net.entity.BasePageList$PageInfo
            r5 = 15
            r6 = 0
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6)
        L_0x0011:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x001c
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            java.util.List r9 = (java.util.List) r9
        L_0x001c:
            r14 = r9
            r9 = r13 & 4
            r0 = 0
            if (r9 == 0) goto L_0x0024
            r1 = r0
            goto L_0x0025
        L_0x0024:
            r1 = r10
        L_0x0025:
            r9 = r13 & 8
            if (r9 == 0) goto L_0x002b
            r2 = r0
            goto L_0x002c
        L_0x002b:
            r2 = r11
        L_0x002c:
            r9 = r13 & 16
            if (r9 == 0) goto L_0x0031
            goto L_0x0032
        L_0x0031:
            r0 = r12
        L_0x0032:
            r9 = r7
            r10 = r8
            r11 = r14
            r12 = r1
            r13 = r2
            r14 = r0
            r9.<init>(r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.entity.BasePageList.<init>(com.microtech.aidexx.common.net.entity.BasePageList$PageInfo, java.util.List, java.lang.String, java.lang.Long, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final PageInfo getPageInfo() {
        return this.pageInfo;
    }

    public final List<T> getRecords() {
        return this.records;
    }

    public final String getDeviceSn() {
        return this.deviceSn;
    }

    public final Long getStartUp() {
        return this.startUp;
    }

    public final Integer getEt() {
        return this.et;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/BasePageList$PageInfo;", "", "currentPage", "", "pageSize", "sortOrder", "", "totalCount", "(IILjava/lang/String;I)V", "getCurrentPage", "()I", "getPageSize", "getSortOrder", "()Ljava/lang/String;", "getTotalCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BasePageList.kt */
    public static final class PageInfo {
        private final int currentPage;
        private final int pageSize;
        private final String sortOrder;
        private final int totalCount;

        public PageInfo() {
            this(0, 0, (String) null, 0, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PageInfo copy$default(PageInfo pageInfo, int i, int i2, String str, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = pageInfo.currentPage;
            }
            if ((i4 & 2) != 0) {
                i2 = pageInfo.pageSize;
            }
            if ((i4 & 4) != 0) {
                str = pageInfo.sortOrder;
            }
            if ((i4 & 8) != 0) {
                i3 = pageInfo.totalCount;
            }
            return pageInfo.copy(i, i2, str, i3);
        }

        public final int component1() {
            return this.currentPage;
        }

        public final int component2() {
            return this.pageSize;
        }

        public final String component3() {
            return this.sortOrder;
        }

        public final int component4() {
            return this.totalCount;
        }

        public final PageInfo copy(int i, int i2, String str, int i3) {
            Intrinsics.checkNotNullParameter(str, "sortOrder");
            return new PageInfo(i, i2, str, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageInfo)) {
                return false;
            }
            PageInfo pageInfo = (PageInfo) obj;
            return this.currentPage == pageInfo.currentPage && this.pageSize == pageInfo.pageSize && Intrinsics.areEqual((Object) this.sortOrder, (Object) pageInfo.sortOrder) && this.totalCount == pageInfo.totalCount;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.currentPage) * 31) + Integer.hashCode(this.pageSize)) * 31) + this.sortOrder.hashCode()) * 31) + Integer.hashCode(this.totalCount);
        }

        public String toString() {
            return "PageInfo(currentPage=" + this.currentPage + ", pageSize=" + this.pageSize + ", sortOrder=" + this.sortOrder + ", totalCount=" + this.totalCount + ')';
        }

        public PageInfo(int i, int i2, String str, int i3) {
            Intrinsics.checkNotNullParameter(str, "sortOrder");
            this.currentPage = i;
            this.pageSize = i2;
            this.sortOrder = str;
            this.totalCount = i3;
        }

        public final int getCurrentPage() {
            return this.currentPage;
        }

        public final int getPageSize() {
            return this.pageSize;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PageInfo(int i, int i2, String str, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? 0 : i3);
        }

        public final String getSortOrder() {
            return this.sortOrder;
        }

        public final int getTotalCount() {
            return this.totalCount;
        }
    }
}
