package com.microtech.aidexx.db.entity.event;

import android.content.res.Resources;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.event.EventActions;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u001f\b\u0016\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\u00020\r2\u0006\u0010+\u001a\u00020,J\u000e\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020,J\u0010\u0010/\u001a\u00020\r2\u0006\u0010+\u001a\u00020,H\u0016J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\rH\u0016R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001a\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001d\"\u0004\b\u001e\u0010\u001fR&\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!8\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u00063"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "()V", "intensity", "", "duration", "(Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDuration", "()Ljava/lang/Integer;", "setDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "exerciseId", "", "getExerciseId", "()Ljava/lang/String;", "setExerciseId", "(Ljava/lang/String;)V", "expandList", "", "Lcom/microtech/aidexx/db/entity/event/ExerciseDetail;", "getExpandList", "()Ljava/util/List;", "setExpandList", "(Ljava/util/List;)V", "getIntensity", "setIntensity", "isPreset", "", "()Z", "setPreset", "(Z)V", "value", "Ljava/util/Date;", "startTime", "getStartTime", "()Ljava/util/Date;", "setStartTime", "(Ljava/util/Date;)V", "equals", "other", "", "getEventDescription", "res", "Landroid/content/res/Resources;", "getEventDescription2", "getEventValue", "getValueDescription", "hashCode", "toString", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExerciseEntity.kt */
public final class ExerciseEntity extends BaseEventEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Integer duration;
    private String exerciseId;
    private List<ExerciseDetail> expandList;
    private Integer intensity;
    private boolean isPreset;
    private Date startTime;

    public final String getExerciseId() {
        return this.exerciseId;
    }

    public final void setExerciseId(String str) {
        this.exerciseId = str;
    }

    public final Date getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "value");
        this.startTime = date;
        setAppTime(ExtendsKt.formatWithoutZone(date));
        setAppTimeZone(TimeZone.getDefault().getID());
        setDstOffset(String.valueOf(calDstOffset()));
    }

    public final Integer getDuration() {
        return this.duration;
    }

    public final void setDuration(Integer num) {
        this.duration = num;
    }

    public final Integer getIntensity() {
        return this.intensity;
    }

    public final void setIntensity(Integer num) {
        this.intensity = num;
    }

    public final boolean isPreset() {
        return this.isPreset;
    }

    public final void setPreset(boolean z) {
        this.isPreset = z;
    }

    public final List<ExerciseDetail> getExpandList() {
        return this.expandList;
    }

    public final void setExpandList(List<ExerciseDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.expandList = list;
    }

    public ExerciseEntity() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.exerciseId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        this.startTime = new Date();
        this.expandList = new ArrayList();
        setLanguage(LanguageResourceManager.INSTANCE.getCurLanguageTag());
    }

    public ExerciseEntity(Integer num, Integer num2) {
        this();
        this.intensity = num;
        this.duration = num2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExerciseEntity(Integer num, Integer num2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2);
    }

    public String getEventDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        if (this.expandList.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Map<Integer, String> exerciseMap = Companion.getExerciseMap();
            Integer num = this.intensity;
            return sb.append(exerciseMap.get(Integer.valueOf(RangesKt.coerceIn(num != null ? num.intValue() : 1, 1, 3)))).append('(').append(ExtendsKt.getNumberFormatWithLocale().format(this.duration)).append(ExtendsKt.getContext().getString(R.string.com_time_minute)).append(')').toString();
        }
        List arrayList = new ArrayList();
        List<ExerciseDetail> list = this.expandList;
        if (list != null) {
            for (ExerciseDetail eventDesc$default : list) {
                arrayList.add(EventActions.DefaultImpls.getEventDesc$default(eventDesc$default, (String) null, 1, (Object) null));
            }
        }
        return CollectionsKt.joinToString$default(arrayList, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
    }

    public final String getEventDescription2(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public final String getEventValue(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return String.valueOf(this.duration);
    }

    public int hashCode() {
        String str = this.exerciseId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof ExerciseEntity) && Intrinsics.areEqual((Object) ((ExerciseEntity) obj).exerciseId, (Object) this.exerciseId);
    }

    public String toString() {
        return "ExerciseEntity(idx=" + getIdx() + ", state=" + getState() + ", id=" + getId() + ", recordIndex=" + getRecordIndex() + ", appCreateTime=" + getAppCreateTime() + ", deleteStatus=" + getDeleteStatus() + ", isPreset=" + this.isPreset + ", authorizationId=" + getUserId() + ", relList=" + CollectionsKt.joinToString$default(this.expandList, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + ", timestamp=" + getTimestamp() + ')';
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¨\u0006\u0007"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/ExerciseEntity$Companion;", "", "()V", "getExerciseMap", "", "", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ExerciseEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Map<Integer, String> getExerciseMap() {
            Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
            String[] stringArray = ExtendsKt.getContext().getResources().getStringArray(R.array.exerciseLevel);
            Intrinsics.checkNotNullExpressionValue(stringArray, "getStringArray(...)");
            int i = 0;
            for (Object next : ArraysKt.asList((T[]) (Object[]) stringArray)) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String str = (String) next;
                Integer valueOf = Integer.valueOf(i2);
                Intrinsics.checkNotNull(str);
                linkedHashMap.put(valueOf, str);
                i = i2;
            }
            return linkedHashMap;
        }
    }
}
