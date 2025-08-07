package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b-\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010,\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010-\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÎ\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\rHÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001f\u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b!\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0016¨\u0006?"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ResUserInfo;", "", "userInformationId", "", "email", "phone", "avatar", "userId", "name", "surname", "middleName", "givenName", "gender", "", "birthDate", "height", "bodyWeight", "diabetesType", "diagnosisDate", "complications", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAvatar", "()Ljava/lang/String;", "getBirthDate", "getBodyWeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getComplications", "getDiabetesType", "getDiagnosisDate", "getEmail", "getGender", "getGivenName", "getHeight", "getMiddleName", "getName", "getPhone", "getSurname", "getUserId", "getUserInformationId", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/microtech/aidexx/common/net/entity/ResUserInfo;", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class ResUserInfo {
    private final String avatar;
    private final String birthDate;
    private final Integer bodyWeight;
    private final String complications;
    private final Integer diabetesType;
    private final String diagnosisDate;
    private final String email;
    private final Integer gender;
    private final String givenName;
    private final Integer height;
    private final String middleName;
    private final String name;
    private final String phone;
    private final String surname;
    private final String userId;
    private final String userInformationId;

    public static /* synthetic */ ResUserInfo copy$default(ResUserInfo resUserInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, Integer num2, Integer num3, Integer num4, String str11, String str12, int i, Object obj) {
        ResUserInfo resUserInfo2 = resUserInfo;
        int i2 = i;
        return resUserInfo.copy((i2 & 1) != 0 ? resUserInfo2.userInformationId : str, (i2 & 2) != 0 ? resUserInfo2.email : str2, (i2 & 4) != 0 ? resUserInfo2.phone : str3, (i2 & 8) != 0 ? resUserInfo2.avatar : str4, (i2 & 16) != 0 ? resUserInfo2.userId : str5, (i2 & 32) != 0 ? resUserInfo2.name : str6, (i2 & 64) != 0 ? resUserInfo2.surname : str7, (i2 & 128) != 0 ? resUserInfo2.middleName : str8, (i2 & 256) != 0 ? resUserInfo2.givenName : str9, (i2 & 512) != 0 ? resUserInfo2.gender : num, (i2 & 1024) != 0 ? resUserInfo2.birthDate : str10, (i2 & 2048) != 0 ? resUserInfo2.height : num2, (i2 & 4096) != 0 ? resUserInfo2.bodyWeight : num3, (i2 & 8192) != 0 ? resUserInfo2.diabetesType : num4, (i2 & 16384) != 0 ? resUserInfo2.diagnosisDate : str11, (i2 & 32768) != 0 ? resUserInfo2.complications : str12);
    }

    public final String component1() {
        return this.userInformationId;
    }

    public final Integer component10() {
        return this.gender;
    }

    public final String component11() {
        return this.birthDate;
    }

    public final Integer component12() {
        return this.height;
    }

    public final Integer component13() {
        return this.bodyWeight;
    }

    public final Integer component14() {
        return this.diabetesType;
    }

    public final String component15() {
        return this.diagnosisDate;
    }

    public final String component16() {
        return this.complications;
    }

    public final String component2() {
        return this.email;
    }

    public final String component3() {
        return this.phone;
    }

    public final String component4() {
        return this.avatar;
    }

    public final String component5() {
        return this.userId;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.surname;
    }

    public final String component8() {
        return this.middleName;
    }

    public final String component9() {
        return this.givenName;
    }

    public final ResUserInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, Integer num2, Integer num3, Integer num4, String str11, String str12) {
        return new ResUserInfo(str, str2, str3, str4, str5, str6, str7, str8, str9, num, str10, num2, num3, num4, str11, str12);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResUserInfo)) {
            return false;
        }
        ResUserInfo resUserInfo = (ResUserInfo) obj;
        return Intrinsics.areEqual((Object) this.userInformationId, (Object) resUserInfo.userInformationId) && Intrinsics.areEqual((Object) this.email, (Object) resUserInfo.email) && Intrinsics.areEqual((Object) this.phone, (Object) resUserInfo.phone) && Intrinsics.areEqual((Object) this.avatar, (Object) resUserInfo.avatar) && Intrinsics.areEqual((Object) this.userId, (Object) resUserInfo.userId) && Intrinsics.areEqual((Object) this.name, (Object) resUserInfo.name) && Intrinsics.areEqual((Object) this.surname, (Object) resUserInfo.surname) && Intrinsics.areEqual((Object) this.middleName, (Object) resUserInfo.middleName) && Intrinsics.areEqual((Object) this.givenName, (Object) resUserInfo.givenName) && Intrinsics.areEqual((Object) this.gender, (Object) resUserInfo.gender) && Intrinsics.areEqual((Object) this.birthDate, (Object) resUserInfo.birthDate) && Intrinsics.areEqual((Object) this.height, (Object) resUserInfo.height) && Intrinsics.areEqual((Object) this.bodyWeight, (Object) resUserInfo.bodyWeight) && Intrinsics.areEqual((Object) this.diabetesType, (Object) resUserInfo.diabetesType) && Intrinsics.areEqual((Object) this.diagnosisDate, (Object) resUserInfo.diagnosisDate) && Intrinsics.areEqual((Object) this.complications, (Object) resUserInfo.complications);
    }

    public int hashCode() {
        String str = this.userInformationId;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.email;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.phone;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.avatar;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.userId;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.name;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.surname;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.middleName;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.givenName;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Integer num = this.gender;
        int hashCode10 = (hashCode9 + (num == null ? 0 : num.hashCode())) * 31;
        String str10 = this.birthDate;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        Integer num2 = this.height;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.bodyWeight;
        int hashCode13 = (hashCode12 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.diabetesType;
        int hashCode14 = (hashCode13 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str11 = this.diagnosisDate;
        int hashCode15 = (hashCode14 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.complications;
        if (str12 != null) {
            i = str12.hashCode();
        }
        return hashCode15 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ResUserInfo(userInformationId=");
        sb.append(this.userInformationId).append(", email=").append(this.email).append(", phone=").append(this.phone).append(", avatar=").append(this.avatar).append(", userId=").append(this.userId).append(", name=").append(this.name).append(", surname=").append(this.surname).append(", middleName=").append(this.middleName).append(", givenName=").append(this.givenName).append(", gender=").append(this.gender).append(", birthDate=").append(this.birthDate).append(", height=");
        sb.append(this.height).append(", bodyWeight=").append(this.bodyWeight).append(", diabetesType=").append(this.diabetesType).append(", diagnosisDate=").append(this.diagnosisDate).append(", complications=").append(this.complications).append(')');
        return sb.toString();
    }

    public ResUserInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, Integer num, String str10, Integer num2, Integer num3, Integer num4, String str11, String str12) {
        this.userInformationId = str;
        this.email = str2;
        this.phone = str3;
        this.avatar = str4;
        this.userId = str5;
        this.name = str6;
        this.surname = str7;
        this.middleName = str8;
        this.givenName = str9;
        this.gender = num;
        this.birthDate = str10;
        this.height = num2;
        this.bodyWeight = num3;
        this.diabetesType = num4;
        this.diagnosisDate = str11;
        this.complications = str12;
    }

    public final String getUserInformationId() {
        return this.userInformationId;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSurname() {
        return this.surname;
    }

    public final String getMiddleName() {
        return this.middleName;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final String getBirthDate() {
        return this.birthDate;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Integer getBodyWeight() {
        return this.bodyWeight;
    }

    public final Integer getDiabetesType() {
        return this.diabetesType;
    }

    public final String getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public final String getComplications() {
        return this.complications;
    }
}
