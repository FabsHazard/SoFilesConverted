package com.microtech.aidexx.db.entity.event;

import android.content.res.Resources;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.EventActions;
import com.microtech.aidexx.ui.main.event.EventTimeSlotManager;
import java.util.ArrayList;
import java.util.Collection;
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

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,J\b\u0010.\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0016J\b\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0004H\u0016R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010$\"\u0004\b%\u0010&¨\u00063"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "insulinName", "", "insulinDosage", "", "(Ljava/lang/String;Ljava/lang/Float;)V", "expandList", "", "Lcom/microtech/aidexx/db/entity/event/InsulinDetail;", "getExpandList", "()Ljava/util/List;", "setExpandList", "(Ljava/util/List;)V", "value", "Ljava/util/Date;", "injectionTime", "getInjectionTime", "()Ljava/util/Date;", "setInjectionTime", "(Ljava/util/Date;)V", "getInsulinDosage", "()Ljava/lang/Float;", "setInsulinDosage", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "insulinId", "getInsulinId", "()Ljava/lang/String;", "setInsulinId", "(Ljava/lang/String;)V", "getInsulinName", "setInsulinName", "isPreset", "", "()Z", "setPreset", "(Z)V", "equals", "other", "", "getEventDescription", "res", "Landroid/content/res/Resources;", "getEventValue", "getTypeText", "getValueDescription", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InsulinEntity.kt */
public final class InsulinEntity extends BaseEventEntity {
    private List<InsulinDetail> expandList;
    private Date injectionTime;
    private Float insulinDosage;
    private String insulinId;
    private String insulinName;
    private boolean isPreset;

    public final Date getInjectionTime() {
        return this.injectionTime;
    }

    public final void setInjectionTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        this.injectionTime = date;
        setAppTime(ExtendsKt.formatWithoutZone(date));
        setAppTimeZone(TimeZone.getDefault().getID());
        setDstOffset(String.valueOf(calDstOffset()));
    }

    public final String getInsulinName() {
        return this.insulinName;
    }

    public final void setInsulinName(String str) {
        this.insulinName = str;
    }

    public final String getInsulinId() {
        return this.insulinId;
    }

    public final void setInsulinId(String str) {
        this.insulinId = str;
    }

    public final Float getInsulinDosage() {
        return this.insulinDosage;
    }

    public final void setInsulinDosage(Float f) {
        this.insulinDosage = f;
    }

    public final boolean isPreset() {
        return this.isPreset;
    }

    public final void setPreset(boolean z) {
        this.isPreset = z;
    }

    public final List<InsulinDetail> getExpandList() {
        return this.expandList;
    }

    public final void setExpandList(List<InsulinDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.expandList = list;
    }

    public InsulinEntity() {
        this.injectionTime = new Date();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.insulinId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        this.expandList = new ArrayList();
        setLanguage(LanguageResourceManager.INSTANCE.getCurLanguageTag());
    }

    public InsulinEntity(String str, Float f) {
        this();
        this.insulinName = str;
        this.insulinDosage = f;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InsulinEntity(String str, Float f, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : f);
    }

    public String getEventDescription(Resources resources) {
        String str;
        Intrinsics.checkNotNullParameter(resources, "res");
        Collection collection = this.expandList;
        if (collection == null || collection.isEmpty()) {
            return this.insulinName + '(' + ExtendsKt.getNumberFormatWithLocale().format(this.insulinDosage) + "U)";
        }
        List arrayList = new ArrayList();
        String typeText = getTypeText();
        CharSequence charSequence = typeText;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        } else {
            str = typeText + 65306;
        }
        List<InsulinDetail> list = this.expandList;
        if (list != null) {
            for (InsulinDetail eventDesc$default : list) {
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
        return String.valueOf(this.insulinDosage);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InsulinEntity(idx=");
        sb.append(getIdx()).append(", state=").append(getState()).append(", id=").append(getId()).append(", recordIndex=").append(getRecordIndex()).append(", appCreateTime=").append(getAppCreateTime()).append(", deleteStatus=").append(getDeleteStatus()).append(", injectionTime=").append(this.injectionTime).append(", insulinName=").append(this.insulinName).append(", insulinId=").append(this.insulinId).append(", insulinDosage=").append(this.insulinDosage).append(", isPreset=").append(this.isPreset).append(", authorizationId=");
        sb.append(getUserId()).append(", relList=").append(CollectionsKt.joinToString$default(this.expandList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).append(", timestamp=").append(getTimestamp()).append(')');
        return sb.toString();
    }

    private final String getTypeText() {
        return EventTimeSlotManager.Companion.instance().getEventSlotByIndex(3, getMoment() - 1);
    }

    public int hashCode() {
        String str = this.insulinId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof InsulinEntity) && Intrinsics.areEqual((Object) ((InsulinEntity) obj).insulinId, (Object) this.insulinId);
    }
}
