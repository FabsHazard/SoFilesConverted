package com.microtech.aidexx.db.entity.event;

import android.content.res.Resources;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.EventActions;
import com.microtech.aidexx.ui.main.event.EventTimeSlotManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,J\b\u0010.\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0004H\u0016R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R$\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00063"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "medicineName", "", "medicineDosage", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "expandList", "", "Lcom/microtech/aidexx/db/entity/event/MedicationDetail;", "getExpandList", "()Ljava/util/List;", "setExpandList", "(Ljava/util/List;)V", "isPreset", "", "()Z", "setPreset", "(Z)V", "medicationId", "getMedicationId", "()Ljava/lang/String;", "setMedicationId", "(Ljava/lang/String;)V", "getMedicineDosage", "()Ljava/lang/Float;", "setMedicineDosage", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getMedicineName", "setMedicineName", "value", "Ljava/util/Date;", "takenTime", "getTakenTime", "()Ljava/util/Date;", "setTakenTime", "(Ljava/util/Date;)V", "equals", "other", "", "getEventDescription", "res", "Landroid/content/res/Resources;", "getEventValue", "getTypeText", "getValueDescription", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MedicationEntity.kt */
public final class MedicationEntity extends BaseEventEntity {
    private List<MedicationDetail> expandList;
    private boolean isPreset;
    private String medicationId;
    private Float medicineDosage;
    private String medicineName;
    private Date takenTime;

    public final String getMedicationId() {
        return this.medicationId;
    }

    public final void setMedicationId(String str) {
        this.medicationId = str;
    }

    public final Date getTakenTime() {
        return this.takenTime;
    }

    public final void setTakenTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        this.takenTime = date;
        setAppTime(ExtendsKt.formatWithoutZone(date));
        setAppTimeZone(TimeZone.getDefault().getID());
        setDstOffset(String.valueOf(calDstOffset()));
    }

    public final String getMedicineName() {
        return this.medicineName;
    }

    public final void setMedicineName(String str) {
        this.medicineName = str;
    }

    public final Float getMedicineDosage() {
        return this.medicineDosage;
    }

    public final void setMedicineDosage(Float f) {
        this.medicineDosage = f;
    }

    public final boolean isPreset() {
        return this.isPreset;
    }

    public final void setPreset(boolean z) {
        this.isPreset = z;
    }

    public final List<MedicationDetail> getExpandList() {
        return this.expandList;
    }

    public final void setExpandList(List<MedicationDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.expandList = list;
    }

    public MedicationEntity() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.medicationId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        this.takenTime = new Date();
        this.expandList = new ArrayList();
        setLanguage(LanguageResourceManager.INSTANCE.getCurLanguageTag());
    }

    public MedicationEntity(String str, Float f) {
        this();
        this.medicineName = str;
        this.medicineDosage = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MedicationEntity(String str, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : f);
    }

    public String getEventDescription(Resources resources) {
        String str;
        Intrinsics.checkNotNullParameter(resources, "res");
        String str2 = null;
        if (this.expandList.isEmpty()) {
            StringBuilder append = new StringBuilder().append(this.medicineName).append('(');
            Float f = this.medicineDosage;
            if (f != null) {
                str2 = ExtendsKt.stripTrailingZeros(f, 3);
            }
            return append.append(str2).append("mg)").toString();
        }
        List arrayList = new ArrayList();
        String typeText = getTypeText();
        CharSequence charSequence = typeText;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        } else {
            str = typeText + 65306;
        }
        List<MedicationDetail> list = this.expandList;
        if (list != null) {
            for (MedicationDetail eventDesc$default : list) {
                arrayList.add(EventActions.DefaultImpls.getEventDesc$default(eventDesc$default, (String) null, 1, (Object) null));
            }
        }
        return str + CollectionsKt.joinToString$default(arrayList, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public final String getEventValue(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    private final String getTypeText() {
        return EventTimeSlotManager.Companion.instance().getEventSlotByIndex(2, getMoment() - 1);
    }

    public int hashCode() {
        String str = this.medicationId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof MedicationEntity) && Intrinsics.areEqual((Object) ((MedicationEntity) obj).medicationId, (Object) this.medicationId);
    }

    public String toString() {
        return "InsulinEntity(idx=" + getIdx() + ", state=" + getState() + ", id=" + getId() + ", recordIndex=" + getRecordIndex() + ", appCreateTime=" + getAppCreateTime() + ", deleteStatus=" + getDeleteStatus() + ", isPreset=" + this.isPreset + ", authorizationId=" + getUserId() + ", relList=" + CollectionsKt.joinToString$default(this.expandList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ", timestamp=" + getTimestamp() + ')';
    }
}
