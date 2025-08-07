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

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010'\u001a\u00020\u001a2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,J\b\u0010.\u001a\u00020\u0004H\u0002J\u0010\u0010/\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H\u0016J\b\u00100\u001a\u00020\u0006H\u0016J\b\u00101\u001a\u00020\u0004H\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R&\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00062"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/DietEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "mealRemark", "", "carbohydrate", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getCarbohydrate", "()Ljava/lang/Integer;", "setCarbohydrate", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "expandList", "", "Lcom/microtech/aidexx/db/entity/event/DietDetail;", "getExpandList", "()Ljava/util/List;", "setExpandList", "(Ljava/util/List;)V", "foodId", "getFoodId", "()Ljava/lang/String;", "setFoodId", "(Ljava/lang/String;)V", "isPreset", "", "()Z", "setPreset", "(Z)V", "getMealRemark", "setMealRemark", "value", "Ljava/util/Date;", "mealTime", "getMealTime", "()Ljava/util/Date;", "setMealTime", "(Ljava/util/Date;)V", "equals", "other", "", "getEventDescription", "res", "Landroid/content/res/Resources;", "getEventValue", "getTypeText", "getValueDescription", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DietEntity.kt */
public final class DietEntity extends BaseEventEntity {
    private Integer carbohydrate;
    private List<DietDetail> expandList;
    private String foodId;
    private boolean isPreset;
    private String mealRemark;
    private Date mealTime;

    public final Date getMealTime() {
        return this.mealTime;
    }

    public final void setMealTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        this.mealTime = date;
        setAppTime(ExtendsKt.formatWithoutZone(date));
        setAppTimeZone(TimeZone.getDefault().getID());
        setDstOffset(String.valueOf(calDstOffset()));
    }

    public final String getFoodId() {
        return this.foodId;
    }

    public final void setFoodId(String str) {
        this.foodId = str;
    }

    public final String getMealRemark() {
        return this.mealRemark;
    }

    public final void setMealRemark(String str) {
        this.mealRemark = str;
    }

    public final Integer getCarbohydrate() {
        return this.carbohydrate;
    }

    public final void setCarbohydrate(Integer num) {
        this.carbohydrate = num;
    }

    public final boolean isPreset() {
        return this.isPreset;
    }

    public final void setPreset(boolean z) {
        this.isPreset = z;
    }

    public final List<DietDetail> getExpandList() {
        return this.expandList;
    }

    public final void setExpandList(List<DietDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.expandList = list;
    }

    public DietEntity() {
        this.mealTime = new Date();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.foodId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        this.expandList = new ArrayList();
        setLanguage(LanguageResourceManager.INSTANCE.getCurLanguageTag());
    }

    public DietEntity(String str, Integer num) {
        this();
        this.mealRemark = str;
        this.carbohydrate = num;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DietEntity(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : num);
    }

    public String getEventDescription(Resources resources) {
        String str;
        Intrinsics.checkNotNullParameter(resources, "res");
        Collection collection = this.expandList;
        if (collection == null || collection.isEmpty()) {
            return this.mealRemark + '(' + this.carbohydrate + "克)";
        }
        String typeText = getTypeText();
        CharSequence charSequence = typeText;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        } else {
            str = typeText + 65306;
        }
        List arrayList = new ArrayList();
        for (DietDetail dietDetail : this.expandList) {
            dietDetail.getFat();
            dietDetail.getProtein();
            dietDetail.getCarbohydrate();
            arrayList.add(EventActions.DefaultImpls.getEventDesc$default(dietDetail, (String) null, 1, (Object) null));
        }
        return str + CollectionsKt.joinToString$default(arrayList, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public final String getEventValue(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        if (this.expandList.isEmpty()) {
            return String.valueOf(this.carbohydrate);
        }
        return "";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DietEntity(idx=");
        sb.append(getIdx()).append(", state=").append(getState()).append(", id=").append(getId()).append(", recordIndex=").append(getRecordIndex()).append(", appCreateTime=").append(getAppCreateTime()).append(",moment=").append(getMoment()).append(", deleteStatus=").append(getDeleteStatus()).append(", mealTime=").append(this.mealTime).append(", foodId=").append(this.foodId).append(", mealRemark=").append(this.mealRemark).append(", carbohydrate=").append(this.carbohydrate).append(", isPreset=");
        sb.append(this.isPreset).append(", relList=").append(CollectionsKt.joinToString$default(this.expandList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)).append(", authorizationId=").append(getUserId()).append(", timestamp=").append(getTimestamp()).append(')');
        return sb.toString();
    }

    private final String getTypeText() {
        return EventTimeSlotManager.Companion.instance().getEventSlotByIndex(1, getMoment() - 1);
    }

    public int hashCode() {
        String str = this.foodId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof DietEntity) && Intrinsics.areEqual((Object) ((DietEntity) obj).foodId, (Object) this.foodId);
    }
}
