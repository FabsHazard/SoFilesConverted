package com.microtech.aidexx.common.net.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/WelfareInfo;", "", "viewWelfareCenter", "", "viewIndexTag", "viewIndexBanner", "activityList", "", "Lcom/microtech/aidexx/common/net/entity/ActivityInfo;", "(ZZZLjava/util/List;)V", "getActivityList", "()Ljava/util/List;", "getViewIndexBanner", "()Z", "getViewIndexTag", "getViewWelfareCenter", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class WelfareInfo {
    private final List<ActivityInfo> activityList;
    private final boolean viewIndexBanner;
    private final boolean viewIndexTag;
    private final boolean viewWelfareCenter;

    public static /* synthetic */ WelfareInfo copy$default(WelfareInfo welfareInfo, boolean z, boolean z2, boolean z3, List<ActivityInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = welfareInfo.viewWelfareCenter;
        }
        if ((i & 2) != 0) {
            z2 = welfareInfo.viewIndexTag;
        }
        if ((i & 4) != 0) {
            z3 = welfareInfo.viewIndexBanner;
        }
        if ((i & 8) != 0) {
            list = welfareInfo.activityList;
        }
        return welfareInfo.copy(z, z2, z3, list);
    }

    public final boolean component1() {
        return this.viewWelfareCenter;
    }

    public final boolean component2() {
        return this.viewIndexTag;
    }

    public final boolean component3() {
        return this.viewIndexBanner;
    }

    public final List<ActivityInfo> component4() {
        return this.activityList;
    }

    public final WelfareInfo copy(boolean z, boolean z2, boolean z3, List<ActivityInfo> list) {
        Intrinsics.checkNotNullParameter(list, "activityList");
        return new WelfareInfo(z, z2, z3, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WelfareInfo)) {
            return false;
        }
        WelfareInfo welfareInfo = (WelfareInfo) obj;
        return this.viewWelfareCenter == welfareInfo.viewWelfareCenter && this.viewIndexTag == welfareInfo.viewIndexTag && this.viewIndexBanner == welfareInfo.viewIndexBanner && Intrinsics.areEqual((Object) this.activityList, (Object) welfareInfo.activityList);
    }

    public int hashCode() {
        boolean z = this.viewWelfareCenter;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.viewIndexTag;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.viewIndexBanner;
        if (!z4) {
            z2 = z4;
        }
        return ((i2 + (z2 ? 1 : 0)) * 31) + this.activityList.hashCode();
    }

    public String toString() {
        return "WelfareInfo(viewWelfareCenter=" + this.viewWelfareCenter + ", viewIndexTag=" + this.viewIndexTag + ", viewIndexBanner=" + this.viewIndexBanner + ", activityList=" + this.activityList + ')';
    }

    public WelfareInfo(boolean z, boolean z2, boolean z3, List<ActivityInfo> list) {
        Intrinsics.checkNotNullParameter(list, "activityList");
        this.viewWelfareCenter = z;
        this.viewIndexTag = z2;
        this.viewIndexBanner = z3;
        this.activityList = list;
    }

    public final boolean getViewWelfareCenter() {
        return this.viewWelfareCenter;
    }

    public final boolean getViewIndexTag() {
        return this.viewIndexTag;
    }

    public final boolean getViewIndexBanner() {
        return this.viewIndexBanner;
    }

    public final List<ActivityInfo> getActivityList() {
        return this.activityList;
    }
}
