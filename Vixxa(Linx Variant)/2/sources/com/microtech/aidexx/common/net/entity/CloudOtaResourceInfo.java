package com.microtech.aidexx.common.net.entity;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003Jc\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\bHÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006("}, d2 = {"Lcom/microtech/aidexx/common/net/entity/CloudOtaResourceInfo;", "", "sha256", "", "ossFileUrl", "settingType", "version", "fileType", "", "md5", "aidexVersion", "settingVersion", "settingContent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAidexVersion", "()Ljava/lang/String;", "getFileType", "()I", "getMd5", "getOssFileUrl", "getSettingContent", "getSettingType", "getSettingVersion", "getSha256", "getVersion", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class CloudOtaResourceInfo {
    private final String aidexVersion;
    private final int fileType;
    private final String md5;
    private final String ossFileUrl;
    private final String settingContent;
    private final String settingType;
    private final String settingVersion;
    private final String sha256;
    private final String version;

    public static /* synthetic */ CloudOtaResourceInfo copy$default(CloudOtaResourceInfo cloudOtaResourceInfo, String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8, int i2, Object obj) {
        CloudOtaResourceInfo cloudOtaResourceInfo2 = cloudOtaResourceInfo;
        int i3 = i2;
        return cloudOtaResourceInfo.copy((i3 & 1) != 0 ? cloudOtaResourceInfo2.sha256 : str, (i3 & 2) != 0 ? cloudOtaResourceInfo2.ossFileUrl : str2, (i3 & 4) != 0 ? cloudOtaResourceInfo2.settingType : str3, (i3 & 8) != 0 ? cloudOtaResourceInfo2.version : str4, (i3 & 16) != 0 ? cloudOtaResourceInfo2.fileType : i, (i3 & 32) != 0 ? cloudOtaResourceInfo2.md5 : str5, (i3 & 64) != 0 ? cloudOtaResourceInfo2.aidexVersion : str6, (i3 & 128) != 0 ? cloudOtaResourceInfo2.settingVersion : str7, (i3 & 256) != 0 ? cloudOtaResourceInfo2.settingContent : str8);
    }

    public final String component1() {
        return this.sha256;
    }

    public final String component2() {
        return this.ossFileUrl;
    }

    public final String component3() {
        return this.settingType;
    }

    public final String component4() {
        return this.version;
    }

    public final int component5() {
        return this.fileType;
    }

    public final String component6() {
        return this.md5;
    }

    public final String component7() {
        return this.aidexVersion;
    }

    public final String component8() {
        return this.settingVersion;
    }

    public final String component9() {
        return this.settingContent;
    }

    public final CloudOtaResourceInfo copy(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "sha256");
        Intrinsics.checkNotNullParameter(str2, "ossFileUrl");
        Intrinsics.checkNotNullParameter(str3, "settingType");
        Intrinsics.checkNotNullParameter(str4, WiseOpenHianalyticsData.UNION_VERSION);
        String str9 = str5;
        Intrinsics.checkNotNullParameter(str9, "md5");
        String str10 = str6;
        Intrinsics.checkNotNullParameter(str10, "aidexVersion");
        String str11 = str7;
        Intrinsics.checkNotNullParameter(str11, "settingVersion");
        String str12 = str8;
        Intrinsics.checkNotNullParameter(str12, "settingContent");
        return new CloudOtaResourceInfo(str, str2, str3, str4, i, str9, str10, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CloudOtaResourceInfo)) {
            return false;
        }
        CloudOtaResourceInfo cloudOtaResourceInfo = (CloudOtaResourceInfo) obj;
        return Intrinsics.areEqual((Object) this.sha256, (Object) cloudOtaResourceInfo.sha256) && Intrinsics.areEqual((Object) this.ossFileUrl, (Object) cloudOtaResourceInfo.ossFileUrl) && Intrinsics.areEqual((Object) this.settingType, (Object) cloudOtaResourceInfo.settingType) && Intrinsics.areEqual((Object) this.version, (Object) cloudOtaResourceInfo.version) && this.fileType == cloudOtaResourceInfo.fileType && Intrinsics.areEqual((Object) this.md5, (Object) cloudOtaResourceInfo.md5) && Intrinsics.areEqual((Object) this.aidexVersion, (Object) cloudOtaResourceInfo.aidexVersion) && Intrinsics.areEqual((Object) this.settingVersion, (Object) cloudOtaResourceInfo.settingVersion) && Intrinsics.areEqual((Object) this.settingContent, (Object) cloudOtaResourceInfo.settingContent);
    }

    public int hashCode() {
        return (((((((((((((((this.sha256.hashCode() * 31) + this.ossFileUrl.hashCode()) * 31) + this.settingType.hashCode()) * 31) + this.version.hashCode()) * 31) + Integer.hashCode(this.fileType)) * 31) + this.md5.hashCode()) * 31) + this.aidexVersion.hashCode()) * 31) + this.settingVersion.hashCode()) * 31) + this.settingContent.hashCode();
    }

    public String toString() {
        return "CloudOtaResourceInfo(sha256=" + this.sha256 + ", ossFileUrl=" + this.ossFileUrl + ", settingType=" + this.settingType + ", version=" + this.version + ", fileType=" + this.fileType + ", md5=" + this.md5 + ", aidexVersion=" + this.aidexVersion + ", settingVersion=" + this.settingVersion + ", settingContent=" + this.settingContent + ')';
    }

    public CloudOtaResourceInfo(String str, String str2, String str3, String str4, int i, String str5, String str6, String str7, String str8) {
        Intrinsics.checkNotNullParameter(str, "sha256");
        Intrinsics.checkNotNullParameter(str2, "ossFileUrl");
        Intrinsics.checkNotNullParameter(str3, "settingType");
        Intrinsics.checkNotNullParameter(str4, WiseOpenHianalyticsData.UNION_VERSION);
        Intrinsics.checkNotNullParameter(str5, "md5");
        Intrinsics.checkNotNullParameter(str6, "aidexVersion");
        Intrinsics.checkNotNullParameter(str7, "settingVersion");
        Intrinsics.checkNotNullParameter(str8, "settingContent");
        this.sha256 = str;
        this.ossFileUrl = str2;
        this.settingType = str3;
        this.version = str4;
        this.fileType = i;
        this.md5 = str5;
        this.aidexVersion = str6;
        this.settingVersion = str7;
        this.settingContent = str8;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final String getOssFileUrl() {
        return this.ossFileUrl;
    }

    public final String getSettingType() {
        return this.settingType;
    }

    public final String getVersion() {
        return this.version;
    }

    public final int getFileType() {
        return this.fileType;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final String getAidexVersion() {
        return this.aidexVersion;
    }

    public final String getSettingVersion() {
        return this.settingVersion;
    }

    public final String getSettingContent() {
        return this.settingContent;
    }
}
