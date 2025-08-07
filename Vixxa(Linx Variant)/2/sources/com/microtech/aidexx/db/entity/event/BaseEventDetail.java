package com.microtech.aidexx.db.entity.event;

import com.google.gson.GsonBuilder;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.entity.event.EventActions;
import io.objectbox.converter.PropertyConverter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u0016\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0005¢\u0006\u0002\u0010\u0005J\u0018\u0010 \u001a\u00020\u00042\u000e\u0010!\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u0003H\u0016J\u001a\u0010\"\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00000\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010$\u001a\u00020%H&J\b\u0010&\u001a\u00020\u0004H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016¨\u0006'"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "Lcom/microtech/aidexx/db/entity/event/EventActions;", "Lio/objectbox/converter/PropertyConverter;", "", "", "()V", "createTime", "Ljava/util/Date;", "getCreateTime", "()Ljava/util/Date;", "setCreateTime", "(Ljava/util/Date;)V", "id", "", "getId", "()J", "setId", "(J)V", "name", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "presetType", "", "getPresetType", "()I", "setPresetType", "(I)V", "unitStr", "getUnitStr", "setUnitStr", "convertToDatabaseValue", "entityProperty", "convertToEntityProperty", "databaseValue", "getCurrClassMutableListType", "Ljava/lang/reflect/Type;", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseEventDetail.kt */
public abstract class BaseEventDetail implements EventActions, PropertyConverter<List<? super BaseEventDetail>, String> {
    private Date createTime = new Date();
    private long id;
    private String name = "";
    private int presetType;
    private String unitStr = "";

    public abstract Type getCurrClassMutableListType();

    public String getEventDesc(String str) {
        return EventActions.DefaultImpls.getEventDesc(this, str);
    }

    public final long getId() {
        return this.id;
    }

    public final void setId(long j) {
        this.id = j;
    }

    public final int getPresetType() {
        return this.presetType;
    }

    public final void setPresetType(int i) {
        this.presetType = i;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final String getUnitStr() {
        return this.unitStr;
    }

    public final void setUnitStr(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.unitStr = str;
    }

    public final Date getCreateTime() {
        return this.createTime;
    }

    public final void setCreateTime(Date date) {
        this.createTime = date;
    }

    public String toString() {
        return "id=" + this.id + ", type=" + this.presetType + ", name='" + this.name + "' createTime=" + this.createTime;
    }

    public List<? super BaseEventDetail> convertToEntityProperty(String str) {
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            return new ArrayList<>();
        }
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new BaseEventDetail$convertToEntityProperty$gson$1$1());
        Object fromJson = gsonBuilder.create().fromJson(str, getCurrClassMutableListType());
        Intrinsics.checkNotNull(fromJson);
        return (List) fromJson;
    }

    public String convertToDatabaseValue(List<? super BaseEventDetail> list) {
        Intrinsics.checkNotNullParameter(list, "entityProperty");
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat(ExtendsKt.DATE_FORMAT_YMDHMSZ);
        String json = gsonBuilder.create().toJson((Object) list);
        return json == null ? "" : json;
    }
}
