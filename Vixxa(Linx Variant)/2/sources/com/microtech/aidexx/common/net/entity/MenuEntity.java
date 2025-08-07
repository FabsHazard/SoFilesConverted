package com.microtech.aidexx.common.net.entity;

import com.microtech.aidexx.ui.setting.profile.health.MenuCheckItem;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0019J\t\u0010!\u001a\u00020\tHÆ\u0003JF\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010#J\u0013\u0010$\u001a\u00020\t2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010'\u001a\u00020\u0003H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\t\u0010)\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u00020\t8VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "Lcom/microtech/aidexx/ui/setting/profile/health/MenuCheckItem;", "displayName", "", "type", "", "dictionaryId", "value", "check", "", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Z)V", "getCheck", "()Z", "setCheck", "(Z)V", "getDictionaryId", "()Ljava/lang/String;", "setDictionaryId", "(Ljava/lang/String;)V", "getDisplayName", "isExclusive", "setExclusive", "getType", "()I", "getValue", "()Ljava/lang/Integer;", "setValue", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Z)Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "equals", "other", "", "getItemName", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class MenuEntity implements MenuCheckItem {
    private boolean check;
    private String dictionaryId;
    private final String displayName;
    private boolean isExclusive;
    private final int type;
    private Integer value;

    public static /* synthetic */ MenuEntity copy$default(MenuEntity menuEntity, String str, int i, String str2, Integer num, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = menuEntity.displayName;
        }
        if ((i2 & 2) != 0) {
            i = menuEntity.type;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str2 = menuEntity.dictionaryId;
        }
        String str3 = str2;
        if ((i2 & 8) != 0) {
            num = menuEntity.value;
        }
        Integer num2 = num;
        if ((i2 & 16) != 0) {
            z = menuEntity.check;
        }
        return menuEntity.copy(str, i3, str3, num2, z);
    }

    public final String component1() {
        return this.displayName;
    }

    public final int component2() {
        return this.type;
    }

    public final String component3() {
        return this.dictionaryId;
    }

    public final Integer component4() {
        return this.value;
    }

    public final boolean component5() {
        return this.check;
    }

    public final MenuEntity copy(String str, int i, String str2, Integer num, boolean z) {
        return new MenuEntity(str, i, str2, num, z);
    }

    public String toString() {
        return "MenuEntity(displayName=" + this.displayName + ", type=" + this.type + ", dictionaryId=" + this.dictionaryId + ", value=" + this.value + ", check=" + this.check + ')';
    }

    public MenuEntity(String str, int i, String str2, Integer num, boolean z) {
        this.displayName = str;
        this.type = i;
        this.dictionaryId = str2;
        this.value = num;
        this.check = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MenuEntity(String str, int i, String str2, Integer num, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, i, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num, (i2 & 16) != 0 ? false : z);
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final int getType() {
        return this.type;
    }

    public final String getDictionaryId() {
        return this.dictionaryId;
    }

    public final void setDictionaryId(String str) {
        this.dictionaryId = str;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final void setValue(Integer num) {
        this.value = num;
    }

    public boolean getCheck() {
        return this.check;
    }

    public void setCheck(boolean z) {
        this.check = z;
    }

    public void setExclusive(boolean z) {
        this.isExclusive = z;
    }

    public boolean isExclusive() {
        Integer num = this.value;
        return num != null && num.intValue() == 0;
    }

    public String getItemName() {
        String str = this.displayName;
        return str == null ? "" : str;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof MenuEntity)) {
            return false;
        }
        MenuEntity menuEntity = (MenuEntity) obj;
        if (!Intrinsics.areEqual((Object) menuEntity.dictionaryId, (Object) this.dictionaryId) || !Intrinsics.areEqual((Object) menuEntity.displayName, (Object) this.displayName) || menuEntity.type != this.type) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.displayName;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.type) * 31;
        String str2 = this.dictionaryId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }
}
