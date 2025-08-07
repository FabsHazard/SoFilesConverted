package com.microtech.aidexx.db.entity;

import com.microtech.aidexx.ota.OtaManagerKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b%\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\b\u00105\u001a\u00020\u0004H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001c\u0010 \u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001c\u0010#\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0006\"\u0004\b%\u0010\bR \u0010&\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\u001c\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0006\"\u0004\b+\u0010\bR\u001c\u0010,\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001c\u0010/\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00066"}, d2 = {"Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "", "()V", "aidexVersion", "", "getAidexVersion", "()Ljava/lang/String;", "setAidexVersion", "(Ljava/lang/String;)V", "fileType", "", "getFileType", "()Ljava/lang/Integer;", "setFileType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "idx", "", "getIdx", "()Ljava/lang/Long;", "setIdx", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "localFilePath", "getLocalFilePath", "setLocalFilePath", "md5", "getMd5", "setMd5", "ossFileUrl", "getOssFileUrl", "setOssFileUrl", "settingContent", "getSettingContent", "setSettingContent", "settingType", "getSettingType", "setSettingType", "settingTypeVersionKey", "getSettingTypeVersionKey", "setSettingTypeVersionKey", "settingVersion", "getSettingVersion", "setSettingVersion", "sha256", "getSha256", "setSha256", "version", "getVersion", "setVersion", "genDownloadFileName", "genEntityKey", "genTypeKey", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtaResourceEntity.kt */
public final class OtaResourceEntity {
    private String aidexVersion;
    private Integer fileType;
    private Long idx;
    private String localFilePath;
    private String md5;
    private String ossFileUrl;
    private String settingContent;
    private String settingType;
    private String settingTypeVersionKey;
    private String settingVersion;
    private String sha256;
    private String version;

    public final Long getIdx() {
        return this.idx;
    }

    public final void setIdx(Long l) {
        this.idx = l;
    }

    public final String getSettingTypeVersionKey() {
        return this.settingTypeVersionKey;
    }

    public final void setSettingTypeVersionKey(String str) {
        this.settingTypeVersionKey = str;
    }

    public final String getSettingVersion() {
        return this.settingVersion;
    }

    public final void setSettingVersion(String str) {
        this.settingVersion = str;
    }

    public final String getLocalFilePath() {
        return this.localFilePath;
    }

    public final void setLocalFilePath(String str) {
        this.localFilePath = str;
    }

    public final String getSettingContent() {
        return this.settingContent;
    }

    public final void setSettingContent(String str) {
        this.settingContent = str;
    }

    public final String getSha256() {
        return this.sha256;
    }

    public final void setSha256(String str) {
        this.sha256 = str;
    }

    public final String getOssFileUrl() {
        return this.ossFileUrl;
    }

    public final void setOssFileUrl(String str) {
        this.ossFileUrl = str;
    }

    public final String getSettingType() {
        return this.settingType;
    }

    public final void setSettingType(String str) {
        this.settingType = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final Integer getFileType() {
        return this.fileType;
    }

    public final void setFileType(Integer num) {
        this.fileType = num;
    }

    public final String getMd5() {
        return this.md5;
    }

    public final void setMd5(String str) {
        this.md5 = str;
    }

    public final String getAidexVersion() {
        return this.aidexVersion;
    }

    public final void setAidexVersion(String str) {
        this.aidexVersion = str;
    }

    public final String genEntityKey() {
        return this.settingType + Soundex.SILENT_MARKER + this.aidexVersion + Soundex.SILENT_MARKER + this.version;
    }

    public final String genTypeKey() {
        return this.settingType + Soundex.SILENT_MARKER + this.aidexVersion;
    }

    public final String genDownloadFileName() {
        Integer num = this.fileType;
        if (num == null || num.intValue() != 1) {
            return "";
        }
        String str = this.aidexVersion;
        if (Intrinsics.areEqual((Object) str, (Object) OtaManagerKt.AIDEX_VERSION)) {
            return genEntityKey() + ".gbl";
        }
        if (Intrinsics.areEqual((Object) str, (Object) "G7")) {
            return genEntityKey() + ".zip";
        }
        return "";
    }

    public String toString() {
        return "OtaResource(settingType=" + this.settingType + ",aidexVersion=" + this.aidexVersion + ",version=" + this.version + ",fileType=" + this.fileType + ",ossFileUrl=" + this.ossFileUrl + ",sha256=" + this.sha256 + ",localFilePath=" + this.localFilePath + ",settingVersion=" + this.settingVersion + ",settingContent=" + this.settingContent + ')';
    }
}
