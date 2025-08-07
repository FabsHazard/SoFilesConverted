package com.microtech.aidexx.ui.main.history;

import com.microtech.aidexx.db.entity.BaseEventEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b.\b\b\u0018\u00002\u00020\u0001Bg\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0002\u0010\u0011J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010&J\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010!J\t\u00105\u001a\u00020\fHÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u000f\u00107\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0003Jr\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fHÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020\f2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010<\u001a\u00020\tH\u0016J\t\u0010=\u001a\u00020\u0005HÖ\u0001R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\r\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001b\"\u0004\b\u001f\u0010\u001dR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u0010)\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010$\u001a\u0004\b*\u0010!\"\u0004\b+\u0010#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006>"}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "", "time", "", "title", "", "contentList", "", "resourceId", "", "idForRealEntity", "expand", "", "deletable", "clazz", "Ljava/lang/Class;", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;ZZLjava/lang/Class;)V", "getClazz", "()Ljava/lang/Class;", "setClazz", "(Ljava/lang/Class;)V", "getContentList", "()Ljava/util/List;", "setContentList", "(Ljava/util/List;)V", "getDeletable", "()Z", "setDeletable", "(Z)V", "getExpand", "setExpand", "getIdForRealEntity", "()Ljava/lang/Long;", "setIdForRealEntity", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getResourceId", "()Ljava/lang/Integer;", "setResourceId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getTime", "setTime", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Long;ZZLjava/lang/Class;)Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "equals", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryAdapter.kt */
public final class HistoryDetailModel {
    private Class<BaseEventEntity> clazz;
    private List<String> contentList;
    private boolean deletable;
    private boolean expand;
    private Long idForRealEntity;
    private Integer resourceId;
    private Long time;
    private String title;

    public static /* synthetic */ HistoryDetailModel copy$default(HistoryDetailModel historyDetailModel, Long l, String str, List list, Integer num, Long l2, boolean z, boolean z2, Class cls, int i, Object obj) {
        HistoryDetailModel historyDetailModel2 = historyDetailModel;
        int i2 = i;
        return historyDetailModel.copy((i2 & 1) != 0 ? historyDetailModel2.time : l, (i2 & 2) != 0 ? historyDetailModel2.title : str, (i2 & 4) != 0 ? historyDetailModel2.contentList : list, (i2 & 8) != 0 ? historyDetailModel2.resourceId : num, (i2 & 16) != 0 ? historyDetailModel2.idForRealEntity : l2, (i2 & 32) != 0 ? historyDetailModel2.expand : z, (i2 & 64) != 0 ? historyDetailModel2.deletable : z2, (i2 & 128) != 0 ? historyDetailModel2.clazz : cls);
    }

    public final Long component1() {
        return this.time;
    }

    public final String component2() {
        return this.title;
    }

    public final List<String> component3() {
        return this.contentList;
    }

    public final Integer component4() {
        return this.resourceId;
    }

    public final Long component5() {
        return this.idForRealEntity;
    }

    public final boolean component6() {
        return this.expand;
    }

    public final boolean component7() {
        return this.deletable;
    }

    public final Class<BaseEventEntity> component8() {
        return this.clazz;
    }

    public final HistoryDetailModel copy(Long l, String str, List<String> list, Integer num, Long l2, boolean z, boolean z2, Class<BaseEventEntity> cls) {
        Intrinsics.checkNotNullParameter(list, "contentList");
        Class<BaseEventEntity> cls2 = cls;
        Intrinsics.checkNotNullParameter(cls2, "clazz");
        return new HistoryDetailModel(l, str, list, num, l2, z, z2, cls2);
    }

    public String toString() {
        return "HistoryDetailModel(time=" + this.time + ", title=" + this.title + ", contentList=" + this.contentList + ", resourceId=" + this.resourceId + ", idForRealEntity=" + this.idForRealEntity + ", expand=" + this.expand + ", deletable=" + this.deletable + ", clazz=" + this.clazz + ')';
    }

    public HistoryDetailModel(Long l, String str, List<String> list, Integer num, Long l2, boolean z, boolean z2, Class<BaseEventEntity> cls) {
        Intrinsics.checkNotNullParameter(list, "contentList");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        this.time = l;
        this.title = str;
        this.contentList = list;
        this.resourceId = num;
        this.idForRealEntity = l2;
        this.expand = z;
        this.deletable = z2;
        this.clazz = cls;
    }

    public final Long getTime() {
        return this.time;
    }

    public final void setTime(Long l) {
        this.time = l;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HistoryDetailModel(Long l, String str, List list, Integer num, Long l2, boolean z, boolean z2, Class cls, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : str, (i & 4) != 0 ? new ArrayList() : list, (i & 8) != 0 ? null : num, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? false : z, (i & 64) != 0 ? true : z2, cls);
    }

    public final List<String> getContentList() {
        return this.contentList;
    }

    public final void setContentList(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.contentList = list;
    }

    public final Integer getResourceId() {
        return this.resourceId;
    }

    public final void setResourceId(Integer num) {
        this.resourceId = num;
    }

    public final Long getIdForRealEntity() {
        return this.idForRealEntity;
    }

    public final void setIdForRealEntity(Long l) {
        this.idForRealEntity = l;
    }

    public final boolean getExpand() {
        return this.expand;
    }

    public final void setExpand(boolean z) {
        this.expand = z;
    }

    public final boolean getDeletable() {
        return this.deletable;
    }

    public final void setDeletable(boolean z) {
        this.deletable = z;
    }

    public final Class<BaseEventEntity> getClazz() {
        return this.clazz;
    }

    public final void setClazz(Class<BaseEventEntity> cls) {
        Intrinsics.checkNotNullParameter(cls, "<set-?>");
        this.clazz = cls;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.microtech.aidexx.ui.main.history.HistoryDetailModel");
        HistoryDetailModel historyDetailModel = (HistoryDetailModel) obj;
        return Intrinsics.areEqual((Object) this.time, (Object) historyDetailModel.time) && Intrinsics.areEqual((Object) this.clazz, (Object) historyDetailModel.clazz) && Intrinsics.areEqual((Object) this.title, (Object) historyDetailModel.title) && Intrinsics.areEqual((Object) this.resourceId, (Object) historyDetailModel.resourceId) && Intrinsics.areEqual((Object) this.idForRealEntity, (Object) historyDetailModel.idForRealEntity);
    }

    public int hashCode() {
        Long l = this.time;
        int i = 0;
        int hashCode = (((l != null ? l.hashCode() : 0) * 31) + this.clazz.hashCode()) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Integer num = this.resourceId;
        int intValue = (hashCode2 + (num != null ? num.intValue() : 0)) * 31;
        Long l2 = this.idForRealEntity;
        if (l2 != null) {
            i = l2.hashCode();
        }
        return intValue + i;
    }
}
