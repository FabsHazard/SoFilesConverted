package com.microtech.aidexx.db.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003JJ\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bR \u0010\b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000b\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/microtech/aidexx/db/entity/LanguageConfEntity;", "", "id", "", "name", "", "chineseName", "code", "version", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChineseName", "()Ljava/lang/String;", "getCode", "getId", "()Ljava/lang/Long;", "setId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getName", "getVersion", "setVersion", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/microtech/aidexx/db/entity/LanguageConfEntity;", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LanguageEntity.kt */
public final class LanguageConfEntity {
    private final String chineseName;
    private final String code;
    private Long id;
    private final String name;
    private String version;

    public LanguageConfEntity() {
        this((Long) null, (String) null, (String) null, (String) null, (String) null, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ LanguageConfEntity copy$default(LanguageConfEntity languageConfEntity, Long l, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            l = languageConfEntity.id;
        }
        if ((i & 2) != 0) {
            str = languageConfEntity.name;
        }
        String str5 = str;
        if ((i & 4) != 0) {
            str2 = languageConfEntity.chineseName;
        }
        String str6 = str2;
        if ((i & 8) != 0) {
            str3 = languageConfEntity.code;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            str4 = languageConfEntity.version;
        }
        return languageConfEntity.copy(l, str5, str6, str7, str4);
    }

    public final Long component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.chineseName;
    }

    public final String component4() {
        return this.code;
    }

    public final String component5() {
        return this.version;
    }

    public final LanguageConfEntity copy(Long l, String str, String str2, String str3, String str4) {
        return new LanguageConfEntity(l, str, str2, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LanguageConfEntity)) {
            return false;
        }
        LanguageConfEntity languageConfEntity = (LanguageConfEntity) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) languageConfEntity.id) && Intrinsics.areEqual((Object) this.name, (Object) languageConfEntity.name) && Intrinsics.areEqual((Object) this.chineseName, (Object) languageConfEntity.chineseName) && Intrinsics.areEqual((Object) this.code, (Object) languageConfEntity.code) && Intrinsics.areEqual((Object) this.version, (Object) languageConfEntity.version);
    }

    public int hashCode() {
        Long l = this.id;
        int i = 0;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.chineseName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.code;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.version;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "LanguageConfEntity(id=" + this.id + ", name=" + this.name + ", chineseName=" + this.chineseName + ", code=" + this.code + ", version=" + this.version + ')';
    }

    public LanguageConfEntity(Long l, String str, String str2, String str3, String str4) {
        this.id = l;
        this.name = str;
        this.chineseName = str2;
        this.code = str3;
        this.version = str4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LanguageConfEntity(java.lang.Long r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.LanguageConfEntity.<init>(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Long getId() {
        return this.id;
    }

    public final void setId(Long l) {
        this.id = l;
    }

    public final String getName() {
        return this.name;
    }

    public final String getChineseName() {
        return this.chineseName;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }
}
