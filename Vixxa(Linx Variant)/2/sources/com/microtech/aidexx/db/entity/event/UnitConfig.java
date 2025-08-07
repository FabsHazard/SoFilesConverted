package com.microtech.aidexx.db.entity.event;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/UnitConfig;", "", "version", "", "content", "", "Lcom/microtech/aidexx/db/entity/event/UnitConfigWithType;", "(Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/util/List;", "setContent", "(Ljava/util/List;)V", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UnitEntity.kt */
public final class UnitConfig {
    private List<UnitConfigWithType> content;
    private String version;

    public static /* synthetic */ UnitConfig copy$default(UnitConfig unitConfig, String str, List<UnitConfigWithType> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unitConfig.version;
        }
        if ((i & 2) != 0) {
            list = unitConfig.content;
        }
        return unitConfig.copy(str, list);
    }

    public final String component1() {
        return this.version;
    }

    public final List<UnitConfigWithType> component2() {
        return this.content;
    }

    public final UnitConfig copy(String str, List<UnitConfigWithType> list) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        Intrinsics.checkNotNullParameter(list, "content");
        return new UnitConfig(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnitConfig)) {
            return false;
        }
        UnitConfig unitConfig = (UnitConfig) obj;
        return Intrinsics.areEqual((Object) this.version, (Object) unitConfig.version) && Intrinsics.areEqual((Object) this.content, (Object) unitConfig.content);
    }

    public int hashCode() {
        return (this.version.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        return "UnitConfig(version=" + this.version + ", content=" + this.content + ')';
    }

    public UnitConfig(String str, List<UnitConfigWithType> list) {
        Intrinsics.checkNotNullParameter(str, WiseOpenHianalyticsData.UNION_VERSION);
        Intrinsics.checkNotNullParameter(list, "content");
        this.version = str;
        this.content = list;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.version = str;
    }

    public final List<UnitConfigWithType> getContent() {
        return this.content;
    }

    public final void setContent(List<UnitConfigWithType> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.content = list;
    }
}
