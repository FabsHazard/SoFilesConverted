package com.microtech.aidexx.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.microtech.aidexx.utils.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 h2\u00020\u0001:\u0001hB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010`\u001a\u00020\u0010H\u0016J\u0006\u0010a\u001a\u00020\u0007J\b\u0010b\u001a\u0004\u0018\u00010\u0007J\b\u0010c\u001a\u0004\u0018\u00010\u0007J\b\u0010d\u001a\u00020\u0007H\u0016J\u0018\u0010e\u001a\u00020f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010g\u001a\u00020\u0010H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\t\"\u0004\b!\u0010\u000bR\u001e\u0010\"\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b#\u0010\u0012\"\u0004\b$\u0010\u0014R\u001c\u0010%\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010\u000bR\u001c\u0010(\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u000bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR\u001e\u0010.\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b/\u0010\u0012\"\u0004\b0\u0010\u0014R\u001e\u00101\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b2\u0010\u0012\"\u0004\b3\u0010\u0014R\u001e\u00104\u001a\u0002058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010;\u001a\u00020\u00102\u0006\u0010:\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010A\"\u0004\bB\u0010CR\u001a\u0010D\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010<\"\u0004\bE\u0010>R\u001a\u0010F\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010<\"\u0004\bG\u0010>R\u001c\u0010H\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR\u001c\u0010K\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\t\"\u0004\bM\u0010\u000bR\u001c\u0010N\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\t\"\u0004\bP\u0010\u000bR\u001c\u0010Q\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\t\"\u0004\bS\u0010\u000bR\u001c\u0010T\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\t\"\u0004\bV\u0010\u000bR\u001c\u0010W\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\t\"\u0004\bY\u0010\u000bR \u0010Z\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\t\"\u0004\b\\\u0010\u000bR\u001c\u0010]\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\t\"\u0004\b_\u0010\u000b¨\u0006i"}, d2 = {"Lcom/microtech/aidexx/db/entity/UserEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "avatar", "", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "birthDate", "getBirthDate", "setBirthDate", "bodyWeight", "", "getBodyWeight", "()Ljava/lang/Integer;", "setBodyWeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "complications", "getComplications", "setComplications", "complicationsDisplayName", "getComplicationsDisplayName", "setComplicationsDisplayName", "diabetesType", "getDiabetesType", "setDiabetesType", "diabetesTypeDisplayName", "getDiabetesTypeDisplayName", "setDiabetesTypeDisplayName", "diabetesTypeValue", "getDiabetesTypeValue", "setDiabetesTypeValue", "diagnosisDate", "getDiagnosisDate", "setDiagnosisDate", "email", "getEmail", "setEmail", "fullName", "getFullName", "setFullName", "gender", "getGender", "setGender", "height", "getHeight", "setHeight", "idx", "", "getIdx", "()J", "setIdx", "(J)V", "value", "isGuide", "()I", "setGuide", "(I)V", "isGuideStateChange", "", "()Z", "setGuideStateChange", "(Z)V", "isSettedPassword", "setSettedPassword", "isUnitGuide", "setUnitGuide", "name", "getName", "setName", "otherDiseases", "getOtherDiseases", "setOtherDiseases", "otherDiseasesDisplayName", "getOtherDiseasesDisplayName", "setOtherDiseasesDisplayName", "phone", "getPhone", "setPhone", "treatment", "getTreatment", "setTreatment", "treatmentDisplayName", "getTreatmentDisplayName", "setTreatmentDisplayName", "userId", "getUserId", "setUserId", "userInformationId", "getUserInformationId", "setUserInformationId", "describeContents", "getDisplayName", "getMaskedEmail", "getMaskedPhone", "toString", "writeToParcel", "", "flags", "CREATOR", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserEntity.kt */
public final class UserEntity implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR((DefaultConstructorMarker) null);
    private String avatar;
    private String birthDate;
    private Integer bodyWeight;
    private String complications;
    private String complicationsDisplayName;
    private Integer diabetesType;
    private String diabetesTypeDisplayName;
    private Integer diabetesTypeValue;
    private String diagnosisDate;
    private String email;
    private String fullName;
    private Integer gender;
    private Integer height;
    private long idx;
    private int isGuide;
    private boolean isGuideStateChange;
    private int isSettedPassword;
    private int isUnitGuide;
    private String name;
    private String otherDiseases;
    private String otherDiseasesDisplayName;
    private String phone;
    private String treatment;
    private String treatmentDisplayName;
    private String userId;
    private String userInformationId;

    public int describeContents() {
        return 0;
    }

    public UserEntity() {
    }

    public final long getIdx() {
        return this.idx;
    }

    public final void setIdx(long j) {
        this.idx = j;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final boolean isGuideStateChange() {
        return this.isGuideStateChange;
    }

    public final void setGuideStateChange(boolean z) {
        this.isGuideStateChange = z;
    }

    public final int isGuide() {
        return this.isGuide;
    }

    public final void setGuide(int i) {
        this.isGuide = i;
        this.isGuideStateChange = true;
    }

    public final int isUnitGuide() {
        return this.isUnitGuide;
    }

    public final void setUnitGuide(int i) {
        this.isUnitGuide = i;
    }

    public final String getUserInformationId() {
        return this.userInformationId;
    }

    public final void setUserInformationId(String str) {
        this.userInformationId = str;
    }

    public final String getEmail() {
        return this.email;
    }

    public final void setEmail(String str) {
        this.email = str;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final void setPhone(String str) {
        this.phone = str;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getFullName() {
        return this.fullName;
    }

    public final void setFullName(String str) {
        this.fullName = str;
    }

    public final Integer getGender() {
        return this.gender;
    }

    public final void setGender(Integer num) {
        this.gender = num;
    }

    public final String getBirthDate() {
        return this.birthDate;
    }

    public final void setBirthDate(String str) {
        this.birthDate = str;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final void setHeight(Integer num) {
        this.height = num;
    }

    public final Integer getBodyWeight() {
        return this.bodyWeight;
    }

    public final void setBodyWeight(Integer num) {
        this.bodyWeight = num;
    }

    public final Integer getDiabetesType() {
        return this.diabetesType;
    }

    public final void setDiabetesType(Integer num) {
        this.diabetesType = num;
    }

    public final Integer getDiabetesTypeValue() {
        return this.diabetesTypeValue;
    }

    public final void setDiabetesTypeValue(Integer num) {
        this.diabetesTypeValue = num;
    }

    public final String getDiabetesTypeDisplayName() {
        return this.diabetesTypeDisplayName;
    }

    public final void setDiabetesTypeDisplayName(String str) {
        this.diabetesTypeDisplayName = str;
    }

    public final String getDiagnosisDate() {
        return this.diagnosisDate;
    }

    public final void setDiagnosisDate(String str) {
        this.diagnosisDate = str;
    }

    public final String getComplications() {
        return this.complications;
    }

    public final void setComplications(String str) {
        this.complications = str;
    }

    public final String getComplicationsDisplayName() {
        return this.complicationsDisplayName;
    }

    public final void setComplicationsDisplayName(String str) {
        this.complicationsDisplayName = str;
    }

    public final String getTreatment() {
        return this.treatment;
    }

    public final void setTreatment(String str) {
        this.treatment = str;
    }

    public final String getTreatmentDisplayName() {
        return this.treatmentDisplayName;
    }

    public final void setTreatmentDisplayName(String str) {
        this.treatmentDisplayName = str;
    }

    public final String getOtherDiseases() {
        return this.otherDiseases;
    }

    public final void setOtherDiseases(String str) {
        this.otherDiseases = str;
    }

    public final String getOtherDiseasesDisplayName() {
        return this.otherDiseasesDisplayName;
    }

    public final void setOtherDiseasesDisplayName(String str) {
        this.otherDiseasesDisplayName = str;
    }

    public final int isSettedPassword() {
        return this.isSettedPassword;
    }

    public final void setSettedPassword(int i) {
        this.isSettedPassword = i;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.CharSequence} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getDisplayName() {
        /*
            r3 = this;
            java.lang.String r0 = r3.name
            r1 = 0
            if (r0 == 0) goto L_0x0012
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r2 = r0.length()
            if (r2 != 0) goto L_0x000e
            r0 = r1
        L_0x000e:
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0034
        L_0x0012:
            java.lang.String r0 = r3.fullName
            if (r0 == 0) goto L_0x0022
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r2 = r0.length()
            if (r2 != 0) goto L_0x001f
            goto L_0x0020
        L_0x001f:
            r1 = r0
        L_0x0020:
            java.lang.String r1 = (java.lang.String) r1
        L_0x0022:
            if (r1 != 0) goto L_0x0033
            java.lang.String r0 = r3.getMaskedPhone()
            if (r0 != 0) goto L_0x0034
            java.lang.String r0 = r3.getMaskedEmail()
            if (r0 != 0) goto L_0x0034
            java.lang.String r0 = ""
            goto L_0x0034
        L_0x0033:
            r0 = r1
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.UserEntity.getDisplayName():java.lang.String");
    }

    public final String getMaskedPhone() {
        return StringUtils.INSTANCE.getMaskedPhone(this.phone);
    }

    public final String getMaskedEmail() {
        return StringUtils.INSTANCE.getMaskedEmail(this.email);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UserEntity[");
        sb.append("idx=" + this.idx + ',');
        sb.append("userId=" + this.userId + ',');
        sb.append("userInformationId=" + this.userInformationId + ',');
        sb.append("email=" + this.email + ',');
        sb.append("phone=" + this.phone + ',');
        sb.append("avatar=" + this.avatar + ',');
        sb.append("name=" + this.name + ',');
        sb.append("fullName=" + this.fullName + ',');
        sb.append("gender=" + this.gender + ',');
        sb.append("birthDate=" + this.birthDate + ',');
        sb.append("height=" + this.height + ',');
        sb.append("bodyWeight=" + this.bodyWeight + ',');
        sb.append("diabetesType=" + this.diabetesType + ',');
        sb.append("diabetesTypeDisplayName=" + this.diabetesTypeDisplayName + ',');
        sb.append("diagnosisDate=" + this.diagnosisDate + ',');
        sb.append("complications=" + this.complications + ',');
        sb.append("complicationsDisplayName=" + this.complicationsDisplayName + ',');
        sb.append("treatment=" + this.treatment + ',');
        sb.append("treatmentDisplayName=" + this.treatmentDisplayName + ',');
        sb.append("otherDiseases=" + this.otherDiseases + ',');
        sb.append("otherDiseasesDisplayName=" + this.otherDiseasesDisplayName + ']');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Integer} */
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UserEntity(android.os.Parcel r4) {
        /*
            r3 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r3.<init>()
            long r0 = r4.readLong()
            r3.idx = r0
            java.lang.String r0 = r4.readString()
            r3.userId = r0
            java.lang.String r0 = r4.readString()
            r3.userInformationId = r0
            java.lang.String r0 = r4.readString()
            r3.email = r0
            java.lang.String r0 = r4.readString()
            r3.phone = r0
            java.lang.String r0 = r4.readString()
            r3.avatar = r0
            java.lang.String r0 = r4.readString()
            r3.name = r0
            java.lang.String r0 = r4.readString()
            r3.fullName = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r4.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            r2 = 0
            if (r1 == 0) goto L_0x004a
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x004b
        L_0x004a:
            r0 = r2
        L_0x004b:
            r3.gender = r0
            java.lang.String r0 = r4.readString()
            r3.birthDate = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r4.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0064
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0065
        L_0x0064:
            r0 = r2
        L_0x0065:
            r3.height = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r4.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x0078
            java.lang.Integer r0 = (java.lang.Integer) r0
            goto L_0x0079
        L_0x0078:
            r0 = r2
        L_0x0079:
            r3.bodyWeight = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            java.lang.ClassLoader r0 = r0.getClassLoader()
            java.lang.Object r0 = r4.readValue(r0)
            boolean r1 = r0 instanceof java.lang.Integer
            if (r1 == 0) goto L_0x008c
            r2 = r0
            java.lang.Integer r2 = (java.lang.Integer) r2
        L_0x008c:
            r3.diabetesType = r2
            java.lang.String r0 = r4.readString()
            r3.diabetesTypeDisplayName = r0
            java.lang.String r0 = r4.readString()
            r3.diagnosisDate = r0
            java.lang.String r0 = r4.readString()
            r3.complications = r0
            java.lang.String r0 = r4.readString()
            r3.complicationsDisplayName = r0
            java.lang.String r0 = r4.readString()
            r3.treatment = r0
            java.lang.String r0 = r4.readString()
            r3.treatmentDisplayName = r0
            java.lang.String r0 = r4.readString()
            r3.otherDiseases = r0
            java.lang.String r4 = r4.readString()
            r3.otherDiseasesDisplayName = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.UserEntity.<init>(android.os.Parcel):void");
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.idx);
        parcel.writeString(this.userId);
        parcel.writeString(this.userInformationId);
        parcel.writeString(this.email);
        parcel.writeString(this.phone);
        parcel.writeString(this.avatar);
        parcel.writeString(this.name);
        parcel.writeString(this.fullName);
        parcel.writeValue(this.gender);
        parcel.writeString(this.birthDate);
        parcel.writeValue(this.height);
        parcel.writeValue(this.bodyWeight);
        parcel.writeValue(this.diabetesType);
        parcel.writeString(this.diabetesTypeDisplayName);
        parcel.writeString(this.diagnosisDate);
        parcel.writeString(this.complications);
        parcel.writeString(this.complicationsDisplayName);
        parcel.writeString(this.treatment);
        parcel.writeString(this.treatmentDisplayName);
        parcel.writeString(this.otherDiseases);
        parcel.writeString(this.otherDiseasesDisplayName);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/db/entity/UserEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/microtech/aidexx/db/entity/UserEntity;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/microtech/aidexx/db/entity/UserEntity;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserEntity.kt */
    public static final class CREATOR implements Parcelable.Creator<UserEntity> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public UserEntity createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UserEntity(parcel);
        }

        public UserEntity[] newArray(int i) {
            return new UserEntity[i];
        }
    }
}
