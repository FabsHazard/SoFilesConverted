package com.microtech.aidexx.db.entity.event;

import com.microtech.aidexx.ui.pair.TransmitterActivityKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/UnitConfigWithType;", "", "type", "", "languageList", "", "Lcom/microtech/aidexx/db/entity/event/UnitWithLangInfo;", "(Ljava/lang/String;Ljava/util/List;)V", "getLanguageList", "()Ljava/util/List;", "setLanguageList", "(Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UnitEntity.kt */
public final class UnitConfigWithType {
    private List<UnitWithLangInfo> languageList;
    private String type;

    public static /* synthetic */ UnitConfigWithType copy$default(UnitConfigWithType unitConfigWithType, String str, List<UnitWithLangInfo> list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = unitConfigWithType.type;
        }
        if ((i & 2) != 0) {
            list = unitConfigWithType.languageList;
        }
        return unitConfigWithType.copy(str, list);
    }

    public final String component1() {
        return this.type;
    }

    public final List<UnitWithLangInfo> component2() {
        return this.languageList;
    }

    public final UnitConfigWithType copy(String str, List<UnitWithLangInfo> list) {
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.OPERATION_TYPE);
        Intrinsics.checkNotNullParameter(list, "languageList");
        return new UnitConfigWithType(str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnitConfigWithType)) {
            return false;
        }
        UnitConfigWithType unitConfigWithType = (UnitConfigWithType) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) unitConfigWithType.type) && Intrinsics.areEqual((Object) this.languageList, (Object) unitConfigWithType.languageList);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.languageList.hashCode();
    }

    public String toString() {
        return "UnitConfigWithType(type=" + this.type + ", languageList=" + this.languageList + ')';
    }

    public UnitConfigWithType(String str, List<UnitWithLangInfo> list) {
        Intrinsics.checkNotNullParameter(str, TransmitterActivityKt.OPERATION_TYPE);
        Intrinsics.checkNotNullParameter(list, "languageList");
        this.type = str;
        this.languageList = list;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }

    public final List<UnitWithLangInfo> getLanguageList() {
        return this.languageList;
    }

    public final void setLanguageList(List<UnitWithLangInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.languageList = list;
    }
}
