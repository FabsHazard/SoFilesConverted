package com.microtech.aidexx.db.entity;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.db.entity.UserEntity_;
import io.objectbox.BoxStore;
import io.objectbox.Cursor;
import io.objectbox.Transaction;
import io.objectbox.internal.CursorFactory;

public final class UserEntityCursor extends Cursor<UserEntity> {
    private static final UserEntity_.UserEntityIdGetter ID_GETTER = UserEntity_.__ID_GETTER;
    private static final int __ID_avatar = UserEntity_.avatar.id;
    private static final int __ID_birthDate = UserEntity_.birthDate.id;
    private static final int __ID_bodyWeight = UserEntity_.bodyWeight.id;
    private static final int __ID_complications = UserEntity_.complications.id;
    private static final int __ID_complicationsDisplayName = UserEntity_.complicationsDisplayName.id;
    private static final int __ID_diabetesType = UserEntity_.diabetesType.id;
    private static final int __ID_diabetesTypeDisplayName = UserEntity_.diabetesTypeDisplayName.id;
    private static final int __ID_diabetesTypeValue = UserEntity_.diabetesTypeValue.id;
    private static final int __ID_diagnosisDate = UserEntity_.diagnosisDate.id;
    private static final int __ID_email = UserEntity_.email.id;
    private static final int __ID_fullName = UserEntity_.fullName.id;
    private static final int __ID_gender = UserEntity_.gender.id;
    private static final int __ID_height = UserEntity_.height.id;
    private static final int __ID_isGuide = UserEntity_.isGuide.id;
    private static final int __ID_isGuideStateChange = UserEntity_.isGuideStateChange.id;
    private static final int __ID_isSettedPassword = UserEntity_.isSettedPassword.id;
    private static final int __ID_isUnitGuide = UserEntity_.isUnitGuide.id;
    private static final int __ID_name = UserEntity_.name.id;
    private static final int __ID_otherDiseases = UserEntity_.otherDiseases.id;
    private static final int __ID_otherDiseasesDisplayName = UserEntity_.otherDiseasesDisplayName.id;
    private static final int __ID_phone = UserEntity_.phone.id;
    private static final int __ID_treatment = UserEntity_.treatment.id;
    private static final int __ID_treatmentDisplayName = UserEntity_.treatmentDisplayName.id;
    private static final int __ID_userId = UserEntity_.userId.id;
    private static final int __ID_userInformationId = UserEntity_.userInformationId.id;

    static final class Factory implements CursorFactory<UserEntity> {
        Factory() {
        }

        public Cursor<UserEntity> createCursor(Transaction transaction, long j, BoxStore boxStore) {
            return new UserEntityCursor(transaction, j, boxStore);
        }
    }

    public UserEntityCursor(Transaction transaction, long j, BoxStore boxStore) {
        super(transaction, j, UserEntity_.__INSTANCE, boxStore);
    }

    public long getId(UserEntity userEntity) {
        return ID_GETTER.getId(userEntity);
    }

    public long put(UserEntity userEntity) {
        int i;
        String userId = userEntity.getUserId();
        int i2 = 0;
        int i3 = userId != null ? __ID_userId : 0;
        String userInformationId = userEntity.getUserInformationId();
        int i4 = userInformationId != null ? __ID_userInformationId : 0;
        String email = userEntity.getEmail();
        int i5 = email != null ? __ID_email : 0;
        String phone = userEntity.getPhone();
        collect400000(this.cursor, 0, 1, i3, userId, i4, userInformationId, i5, email, phone != null ? __ID_phone : 0, phone);
        String avatar = userEntity.getAvatar();
        int i6 = avatar != null ? __ID_avatar : 0;
        String name = userEntity.getName();
        int i7 = name != null ? __ID_name : 0;
        String fullName = userEntity.getFullName();
        int i8 = fullName != null ? __ID_fullName : 0;
        String birthDate = userEntity.getBirthDate();
        collect400000(this.cursor, 0, 0, i6, avatar, i7, name, i8, fullName, birthDate != null ? __ID_birthDate : 0, birthDate);
        String diabetesTypeDisplayName = userEntity.getDiabetesTypeDisplayName();
        int i9 = diabetesTypeDisplayName != null ? __ID_diabetesTypeDisplayName : 0;
        String diagnosisDate = userEntity.getDiagnosisDate();
        int i10 = diagnosisDate != null ? __ID_diagnosisDate : 0;
        String complications = userEntity.getComplications();
        int i11 = complications != null ? __ID_complications : 0;
        String complicationsDisplayName = userEntity.getComplicationsDisplayName();
        collect400000(this.cursor, 0, 0, i9, diabetesTypeDisplayName, i10, diagnosisDate, i11, complications, complicationsDisplayName != null ? __ID_complicationsDisplayName : 0, complicationsDisplayName);
        String treatment = userEntity.getTreatment();
        int i12 = treatment != null ? __ID_treatment : 0;
        String treatmentDisplayName = userEntity.getTreatmentDisplayName();
        int i13 = treatmentDisplayName != null ? __ID_treatmentDisplayName : 0;
        String otherDiseases = userEntity.getOtherDiseases();
        int i14 = otherDiseases != null ? __ID_otherDiseases : 0;
        String otherDiseasesDisplayName = userEntity.getOtherDiseasesDisplayName();
        collect400000(this.cursor, 0, 0, i12, treatment, i13, treatmentDisplayName, i14, otherDiseases, otherDiseasesDisplayName != null ? __ID_otherDiseasesDisplayName : 0, otherDiseasesDisplayName);
        Integer gender = userEntity.getGender();
        int i15 = gender != null ? __ID_gender : 0;
        Integer height = userEntity.getHeight();
        int i16 = height != null ? __ID_height : 0;
        Integer bodyWeight = userEntity.getBodyWeight();
        int i17 = bodyWeight != null ? __ID_bodyWeight : 0;
        Integer diabetesType = userEntity.getDiabetesType();
        int i18 = diabetesType != null ? __ID_diabetesType : 0;
        long j = this.cursor;
        int i19 = __ID_isGuide;
        long isGuide = (long) userEntity.isGuide();
        int i20 = __ID_isUnitGuide;
        long isUnitGuide = (long) userEntity.isUnitGuide();
        long intValue = i15 != 0 ? (long) gender.intValue() : 0;
        int intValue2 = i16 != 0 ? height.intValue() : 0;
        if (i17 != 0) {
            i = bodyWeight.intValue();
        } else {
            i = 0;
        }
        collect313311(j, 0, 0, 0, (String) null, 0, (String) null, 0, (String) null, 0, (byte[]) null, i19, isGuide, i20, isUnitGuide, i15, intValue, i16, intValue2, i17, i, i18, i18 != 0 ? diabetesType.intValue() : 0, 0, 0.0f, 0, Utils.DOUBLE_EPSILON);
        Integer diabetesTypeValue = userEntity.getDiabetesTypeValue();
        if (diabetesTypeValue != null) {
            i2 = __ID_diabetesTypeValue;
        }
        int i21 = i2;
        long collect004000 = collect004000(this.cursor, userEntity.getIdx(), 2, i21, i21 != 0 ? (long) diabetesTypeValue.intValue() : 0, __ID_isSettedPassword, (long) userEntity.isSettedPassword(), __ID_isGuideStateChange, userEntity.isGuideStateChange() ? 1 : 0, 0, 0);
        userEntity.setIdx(collect004000);
        return collect004000;
    }
}
