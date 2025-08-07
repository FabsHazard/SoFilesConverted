package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0005HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/common/net/entity/TrendInfo;", "", "appTime", "", "trend", "", "trendValue", "trendId", "dstOffset", "userId", "appTimeZone", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppTime", "()Ljava/lang/String;", "getAppTimeZone", "getDstOffset", "getTrend", "()I", "getTrendId", "getTrendValue", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class TrendInfo {
    private final String appTime;
    private final String appTimeZone;
    private final String dstOffset;
    private final int trend;
    private final String trendId;
    private final int trendValue;
    private final String userId;

    public static /* synthetic */ TrendInfo copy$default(TrendInfo trendInfo, String str, int i, int i2, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = trendInfo.appTime;
        }
        if ((i3 & 2) != 0) {
            i = trendInfo.trend;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = trendInfo.trendValue;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            str2 = trendInfo.trendId;
        }
        String str6 = str2;
        if ((i3 & 16) != 0) {
            str3 = trendInfo.dstOffset;
        }
        String str7 = str3;
        if ((i3 & 32) != 0) {
            str4 = trendInfo.userId;
        }
        String str8 = str4;
        if ((i3 & 64) != 0) {
            str5 = trendInfo.appTimeZone;
        }
        return trendInfo.copy(str, i4, i5, str6, str7, str8, str5);
    }

    public final String component1() {
        return this.appTime;
    }

    public final int component2() {
        return this.trend;
    }

    public final int component3() {
        return this.trendValue;
    }

    public final String component4() {
        return this.trendId;
    }

    public final String component5() {
        return this.dstOffset;
    }

    public final String component6() {
        return this.userId;
    }

    public final String component7() {
        return this.appTimeZone;
    }

    public final TrendInfo copy(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "appTime");
        Intrinsics.checkNotNullParameter(str2, "trendId");
        Intrinsics.checkNotNullParameter(str3, "dstOffset");
        Intrinsics.checkNotNullParameter(str4, "userId");
        String str6 = str5;
        Intrinsics.checkNotNullParameter(str6, "appTimeZone");
        return new TrendInfo(str, i, i2, str2, str3, str4, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrendInfo)) {
            return false;
        }
        TrendInfo trendInfo = (TrendInfo) obj;
        return Intrinsics.areEqual((Object) this.appTime, (Object) trendInfo.appTime) && this.trend == trendInfo.trend && this.trendValue == trendInfo.trendValue && Intrinsics.areEqual((Object) this.trendId, (Object) trendInfo.trendId) && Intrinsics.areEqual((Object) this.dstOffset, (Object) trendInfo.dstOffset) && Intrinsics.areEqual((Object) this.userId, (Object) trendInfo.userId) && Intrinsics.areEqual((Object) this.appTimeZone, (Object) trendInfo.appTimeZone);
    }

    public int hashCode() {
        return (((((((((((this.appTime.hashCode() * 31) + Integer.hashCode(this.trend)) * 31) + Integer.hashCode(this.trendValue)) * 31) + this.trendId.hashCode()) * 31) + this.dstOffset.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.appTimeZone.hashCode();
    }

    public String toString() {
        return "TrendInfo(appTime=" + this.appTime + ", trend=" + this.trend + ", trendValue=" + this.trendValue + ", trendId=" + this.trendId + ", dstOffset=" + this.dstOffset + ", userId=" + this.userId + ", appTimeZone=" + this.appTimeZone + ')';
    }

    public TrendInfo(String str, int i, int i2, String str2, String str3, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "appTime");
        Intrinsics.checkNotNullParameter(str2, "trendId");
        Intrinsics.checkNotNullParameter(str3, "dstOffset");
        Intrinsics.checkNotNullParameter(str4, "userId");
        Intrinsics.checkNotNullParameter(str5, "appTimeZone");
        this.appTime = str;
        this.trend = i;
        this.trendValue = i2;
        this.trendId = str2;
        this.dstOffset = str3;
        this.userId = str4;
        this.appTimeZone = str5;
    }

    public final String getAppTime() {
        return this.appTime;
    }

    public final int getTrend() {
        return this.trend;
    }

    public final int getTrendValue() {
        return this.trendValue;
    }

    public final String getTrendId() {
        return this.trendId;
    }

    public final String getDstOffset() {
        return this.dstOffset;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getAppTimeZone() {
        return this.appTimeZone;
    }
}
