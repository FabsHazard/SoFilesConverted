package com.microtech.aidexx.db.entity.event;

import android.content.res.Resources;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\b\u0016¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u0019\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006!"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "Lcom/microtech/aidexx/db/entity/event/EventActions;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "value", "", "deleteFlag", "getDeleteFlag", "()Ljava/lang/Integer;", "setDeleteFlag", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "otherId", "getOtherId", "setOtherId", "equals", "", "other", "", "getEventDesc", "spliter", "getEventDescription", "res", "Landroid/content/res/Resources;", "getValueDescription", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OthersEntity.kt */
public final class OthersEntity extends BaseEventEntity implements EventActions {
    private String content = "";
    private Integer deleteFlag = 0;
    private String otherId;

    public final String getOtherId() {
        return this.otherId;
    }

    public final void setOtherId(String str) {
        this.otherId = str;
    }

    public final String getContent() {
        return this.content;
    }

    public final void setContent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.content = str;
    }

    public final Integer getDeleteFlag() {
        return this.deleteFlag;
    }

    public final void setDeleteFlag(Integer num) {
        this.deleteFlag = num;
        if (num != null && 1 == num.intValue()) {
            setDeleteStatus(2);
        }
    }

    public OthersEntity() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        this.otherId = StringsKt.replace$default(uuid, "-", "", false, 4, (Object) null);
        setLanguage(LanguageResourceManager.INSTANCE.getCurLanguageTag());
    }

    public String getEventDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        return "";
    }

    public String getValueDescription(Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "res");
        if (this.content.length() <= 35) {
            return this.content;
        }
        StringBuilder sb = new StringBuilder();
        String substring = this.content.substring(0, 35);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return sb.append(substring).append("...").toString();
    }

    public String getEventDesc(String str) {
        return StringsKt.replace$default(this.content, "\n", " ", false, 4, (Object) null);
    }

    public String toString() {
        return "OthersEntity[idx=" + getIdx() + ", state=" + getState() + ", id=" + getId() + ", recordIndex=" + getRecordIndex() + ", deleteStatus=" + getDeleteStatus() + ", otherId=" + this.otherId + ", appCreateTime=" + getAppCreateTime() + ", content=" + this.content + ", authorizationId=" + getUserId() + ']';
    }

    public int hashCode() {
        String str = this.otherId;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof OthersEntity) && Intrinsics.areEqual((Object) ((OthersEntity) obj).otherId, (Object) this.otherId);
    }
}
