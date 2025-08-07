package com.microtech.aidexx.ui.setting.profile;

import com.google.gson.Gson;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aBE\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\bJ\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003JI\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/DiabetesEnum;", "", "compsType", "", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "diabetesType", "treatmentsType", "otherDiabetesType", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getCompsType", "()Ljava/util/List;", "getDiabetesType", "getOtherDiabetesType", "getTreatmentsType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ProfileViewModel.kt */
public final class DiabetesEnum {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<MenuEntity> compsType;
    private final List<MenuEntity> diabetesType;
    private final List<MenuEntity> otherDiabetesType;
    private final List<MenuEntity> treatmentsType;

    public DiabetesEnum() {
        this((List) null, (List) null, (List) null, (List) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DiabetesEnum copy$default(DiabetesEnum diabetesEnum, List<MenuEntity> list, List<MenuEntity> list2, List<MenuEntity> list3, List<MenuEntity> list4, int i, Object obj) {
        if ((i & 1) != 0) {
            list = diabetesEnum.compsType;
        }
        if ((i & 2) != 0) {
            list2 = diabetesEnum.diabetesType;
        }
        if ((i & 4) != 0) {
            list3 = diabetesEnum.treatmentsType;
        }
        if ((i & 8) != 0) {
            list4 = diabetesEnum.otherDiabetesType;
        }
        return diabetesEnum.copy(list, list2, list3, list4);
    }

    public final List<MenuEntity> component1() {
        return this.compsType;
    }

    public final List<MenuEntity> component2() {
        return this.diabetesType;
    }

    public final List<MenuEntity> component3() {
        return this.treatmentsType;
    }

    public final List<MenuEntity> component4() {
        return this.otherDiabetesType;
    }

    public final DiabetesEnum copy(List<MenuEntity> list, List<MenuEntity> list2, List<MenuEntity> list3, List<MenuEntity> list4) {
        Intrinsics.checkNotNullParameter(list, "compsType");
        Intrinsics.checkNotNullParameter(list2, "diabetesType");
        Intrinsics.checkNotNullParameter(list3, "treatmentsType");
        Intrinsics.checkNotNullParameter(list4, "otherDiabetesType");
        return new DiabetesEnum(list, list2, list3, list4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DiabetesEnum)) {
            return false;
        }
        DiabetesEnum diabetesEnum = (DiabetesEnum) obj;
        return Intrinsics.areEqual((Object) this.compsType, (Object) diabetesEnum.compsType) && Intrinsics.areEqual((Object) this.diabetesType, (Object) diabetesEnum.diabetesType) && Intrinsics.areEqual((Object) this.treatmentsType, (Object) diabetesEnum.treatmentsType) && Intrinsics.areEqual((Object) this.otherDiabetesType, (Object) diabetesEnum.otherDiabetesType);
    }

    public int hashCode() {
        return (((((this.compsType.hashCode() * 31) + this.diabetesType.hashCode()) * 31) + this.treatmentsType.hashCode()) * 31) + this.otherDiabetesType.hashCode();
    }

    public String toString() {
        return "DiabetesEnum(compsType=" + this.compsType + ", diabetesType=" + this.diabetesType + ", treatmentsType=" + this.treatmentsType + ", otherDiabetesType=" + this.otherDiabetesType + ')';
    }

    public DiabetesEnum(List<MenuEntity> list, List<MenuEntity> list2, List<MenuEntity> list3, List<MenuEntity> list4) {
        Intrinsics.checkNotNullParameter(list, "compsType");
        Intrinsics.checkNotNullParameter(list2, "diabetesType");
        Intrinsics.checkNotNullParameter(list3, "treatmentsType");
        Intrinsics.checkNotNullParameter(list4, "otherDiabetesType");
        this.compsType = list;
        this.diabetesType = list2;
        this.treatmentsType = list3;
        this.otherDiabetesType = list4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DiabetesEnum(List list, List list2, List list3, List list4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : list, (i & 2) != 0 ? new ArrayList() : list2, (i & 4) != 0 ? new ArrayList() : list3, (i & 8) != 0 ? new ArrayList() : list4);
    }

    public final List<MenuEntity> getCompsType() {
        return this.compsType;
    }

    public final List<MenuEntity> getDiabetesType() {
        return this.diabetesType;
    }

    public final List<MenuEntity> getTreatmentsType() {
        return this.treatmentsType;
    }

    public final List<MenuEntity> getOtherDiabetesType() {
        return this.otherDiabetesType;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/DiabetesEnum$Companion;", "", "()V", "getDiabetesEnum", "Lcom/microtech/aidexx/ui/setting/profile/DiabetesEnum;", "saveDiabetesEnum", "", "diabetesEnum", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ProfileViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void saveDiabetesEnum(DiabetesEnum diabetesEnum) {
            Intrinsics.checkNotNullParameter(diabetesEnum, "diabetesEnum");
            MMKV.defaultMMKV().encode("DiabetesEnum_" + LanguageResourceManager.INSTANCE.getCurLanguageTag(), new Gson().toJson((Object) diabetesEnum));
        }

        public final DiabetesEnum getDiabetesEnum() {
            Object obj;
            String decodeString = MMKV.defaultMMKV().decodeString("DiabetesEnum_" + LanguageResourceManager.INSTANCE.getCurLanguageTag(), "");
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m343constructorimpl((DiabetesEnum) new Gson().fromJson(decodeString, DiabetesEnum.class));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m343constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m349isFailureimpl(obj)) {
                obj = null;
            }
            return (DiabetesEnum) obj;
        }
    }
}
