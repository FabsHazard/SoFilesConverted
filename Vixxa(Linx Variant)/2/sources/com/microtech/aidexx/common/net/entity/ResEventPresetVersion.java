package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ResEventPresetVersion;", "", "sysVersion", "", "userVersion", "(Ljava/lang/String;Ljava/lang/String;)V", "getSysVersion", "()Ljava/lang/String;", "getUserVersion", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class ResEventPresetVersion {
    private final String sysVersion;
    private final String userVersion;

    public static /* synthetic */ ResEventPresetVersion copy$default(ResEventPresetVersion resEventPresetVersion, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = resEventPresetVersion.sysVersion;
        }
        if ((i & 2) != 0) {
            str2 = resEventPresetVersion.userVersion;
        }
        return resEventPresetVersion.copy(str, str2);
    }

    public final String component1() {
        return this.sysVersion;
    }

    public final String component2() {
        return this.userVersion;
    }

    public final ResEventPresetVersion copy(String str, String str2) {
        return new ResEventPresetVersion(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResEventPresetVersion)) {
            return false;
        }
        ResEventPresetVersion resEventPresetVersion = (ResEventPresetVersion) obj;
        return Intrinsics.areEqual((Object) this.sysVersion, (Object) resEventPresetVersion.sysVersion) && Intrinsics.areEqual((Object) this.userVersion, (Object) resEventPresetVersion.userVersion);
    }

    public int hashCode() {
        String str = this.sysVersion;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.userVersion;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "ResEventPresetVersion(sysVersion=" + this.sysVersion + ", userVersion=" + this.userVersion + ')';
    }

    public ResEventPresetVersion(String str, String str2) {
        this.sysVersion = str;
        this.userVersion = str2;
    }

    public final String getSysVersion() {
        return this.sysVersion;
    }

    public final String getUserVersion() {
        return this.userVersion;
    }
}
