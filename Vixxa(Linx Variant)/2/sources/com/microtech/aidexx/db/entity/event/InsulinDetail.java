package com.microtech.aidexx.db.entity.event;

import com.github.mikephil.charting.utils.Utils;
import com.microtech.aidexx.common.ExtendsKt;
import java.lang.reflect.Type;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0011J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00101\u001a\u00020\u000fHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\u000bHÆ\u0003J\t\u00109\u001a\u00020\u000bHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010<\u001a\u00020=2\b\u0010>\u001a\u0004\u0018\u00010?HÖ\u0003J\b\u0010@\u001a\u00020AH\u0016J\u0012\u0010B\u001a\u00020\u00032\b\u0010C\u001a\u0004\u0018\u00010\u0003H\u0016J\t\u0010D\u001a\u00020\u000bHÖ\u0001J\b\u0010E\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0013\"\u0004\b\u001f\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0013\"\u0004\b)\u0010\u0015R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006F"}, d2 = {"Lcom/microtech/aidexx/db/entity/event/InsulinDetail;", "Lcom/microtech/aidexx/db/entity/event/BaseEventDetail;", "relUuid", "", "categoryName", "tradeName", "comment", "manufacturer", "quantity", "", "unit", "", "delete_flag", "insulinPresetId", "updateTime", "Ljava/util/Date;", "insulinId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DIILjava/lang/String;Ljava/util/Date;Ljava/lang/String;)V", "getCategoryName", "()Ljava/lang/String;", "setCategoryName", "(Ljava/lang/String;)V", "getComment", "setComment", "getDelete_flag", "()I", "setDelete_flag", "(I)V", "getInsulinId", "setInsulinId", "getInsulinPresetId", "setInsulinPresetId", "getManufacturer", "setManufacturer", "getQuantity", "()D", "setQuantity", "(D)V", "getRelUuid", "setRelUuid", "getTradeName", "setTradeName", "getUnit", "setUnit", "getUpdateTime", "()Ljava/util/Date;", "setUpdateTime", "(Ljava/util/Date;)V", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "getCurrClassMutableListType", "Ljava/lang/reflect/Type;", "getEventDesc", "splitter", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: InsulinEntity.kt */
public final class InsulinDetail extends BaseEventDetail {
    private String categoryName;
    private String comment;
    private int delete_flag;
    private String insulinId;
    private String insulinPresetId;
    private String manufacturer;
    private double quantity;
    private String relUuid;
    private String tradeName;
    private int unit;
    private transient Date updateTime;

    public InsulinDetail() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, Utils.DOUBLE_EPSILON, 0, 0, (String) null, (Date) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ InsulinDetail copy$default(InsulinDetail insulinDetail, String str, String str2, String str3, String str4, String str5, double d, int i, int i2, String str6, Date date, String str7, int i3, Object obj) {
        InsulinDetail insulinDetail2 = insulinDetail;
        int i4 = i3;
        return insulinDetail.copy((i4 & 1) != 0 ? insulinDetail2.relUuid : str, (i4 & 2) != 0 ? insulinDetail2.categoryName : str2, (i4 & 4) != 0 ? insulinDetail2.tradeName : str3, (i4 & 8) != 0 ? insulinDetail2.comment : str4, (i4 & 16) != 0 ? insulinDetail2.manufacturer : str5, (i4 & 32) != 0 ? insulinDetail2.quantity : d, (i4 & 64) != 0 ? insulinDetail2.unit : i, (i4 & 128) != 0 ? insulinDetail2.delete_flag : i2, (i4 & 256) != 0 ? insulinDetail2.insulinPresetId : str6, (i4 & 512) != 0 ? insulinDetail2.updateTime : date, (i4 & 1024) != 0 ? insulinDetail2.insulinId : str7);
    }

    public final String component1() {
        return this.relUuid;
    }

    public final Date component10() {
        return this.updateTime;
    }

    public final String component11() {
        return this.insulinId;
    }

    public final String component2() {
        return this.categoryName;
    }

    public final String component3() {
        return this.tradeName;
    }

    public final String component4() {
        return this.comment;
    }

    public final String component5() {
        return this.manufacturer;
    }

    public final double component6() {
        return this.quantity;
    }

    public final int component7() {
        return this.unit;
    }

    public final int component8() {
        return this.delete_flag;
    }

    public final String component9() {
        return this.insulinPresetId;
    }

    public final InsulinDetail copy(String str, String str2, String str3, String str4, String str5, double d, int i, int i2, String str6, Date date, String str7) {
        Date date2 = date;
        Intrinsics.checkNotNullParameter(date2, "updateTime");
        return new InsulinDetail(str, str2, str3, str4, str5, d, i, i2, str6, date2, str7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InsulinDetail)) {
            return false;
        }
        InsulinDetail insulinDetail = (InsulinDetail) obj;
        return Intrinsics.areEqual((Object) this.relUuid, (Object) insulinDetail.relUuid) && Intrinsics.areEqual((Object) this.categoryName, (Object) insulinDetail.categoryName) && Intrinsics.areEqual((Object) this.tradeName, (Object) insulinDetail.tradeName) && Intrinsics.areEqual((Object) this.comment, (Object) insulinDetail.comment) && Intrinsics.areEqual((Object) this.manufacturer, (Object) insulinDetail.manufacturer) && Double.compare(this.quantity, insulinDetail.quantity) == 0 && this.unit == insulinDetail.unit && this.delete_flag == insulinDetail.delete_flag && Intrinsics.areEqual((Object) this.insulinPresetId, (Object) insulinDetail.insulinPresetId) && Intrinsics.areEqual((Object) this.updateTime, (Object) insulinDetail.updateTime) && Intrinsics.areEqual((Object) this.insulinId, (Object) insulinDetail.insulinId);
    }

    public int hashCode() {
        String str = this.relUuid;
        int i = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.categoryName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.tradeName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.comment;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.manufacturer;
        int hashCode5 = (((((((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + Double.hashCode(this.quantity)) * 31) + Integer.hashCode(this.unit)) * 31) + Integer.hashCode(this.delete_flag)) * 31;
        String str6 = this.insulinPresetId;
        int hashCode6 = (((hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.updateTime.hashCode()) * 31;
        String str7 = this.insulinId;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode6 + i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InsulinDetail(java.lang.String r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, double r19, int r21, int r22, java.lang.String r23, java.util.Date r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0012
            r3 = r4
            goto L_0x0013
        L_0x0012:
            r3 = r15
        L_0x0013:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0019
            r5 = r4
            goto L_0x001b
        L_0x0019:
            r5 = r16
        L_0x001b:
            r6 = r0 & 8
            if (r6 == 0) goto L_0x0021
            r6 = r4
            goto L_0x0023
        L_0x0021:
            r6 = r17
        L_0x0023:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0029
            r7 = r4
            goto L_0x002b
        L_0x0029:
            r7 = r18
        L_0x002b:
            r8 = r0 & 32
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r19
        L_0x0034:
            r10 = r0 & 64
            r11 = 0
            if (r10 == 0) goto L_0x003b
            r10 = r11
            goto L_0x003d
        L_0x003b:
            r10 = r21
        L_0x003d:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r11 = r22
        L_0x0044:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r2 = r23
        L_0x004b:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0055
            java.util.Date r12 = new java.util.Date
            r12.<init>()
            goto L_0x0057
        L_0x0055:
            r12 = r24
        L_0x0057:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r4 = r25
        L_0x005e:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r5
            r18 = r6
            r19 = r7
            r20 = r8
            r22 = r10
            r23 = r11
            r24 = r2
            r25 = r12
            r26 = r4
            r14.<init>(r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.db.entity.event.InsulinDetail.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, double, int, int, java.lang.String, java.util.Date, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getRelUuid() {
        return this.relUuid;
    }

    public final void setRelUuid(String str) {
        this.relUuid = str;
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final void setCategoryName(String str) {
        this.categoryName = str;
    }

    public final String getTradeName() {
        return this.tradeName;
    }

    public final void setTradeName(String str) {
        this.tradeName = str;
    }

    public final String getComment() {
        return this.comment;
    }

    public final void setComment(String str) {
        this.comment = str;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public final double getQuantity() {
        return this.quantity;
    }

    public final void setQuantity(double d) {
        this.quantity = d;
    }

    public final int getUnit() {
        return this.unit;
    }

    public final void setUnit(int i) {
        this.unit = i;
    }

    public final int getDelete_flag() {
        return this.delete_flag;
    }

    public final void setDelete_flag(int i) {
        this.delete_flag = i;
    }

    public final String getInsulinPresetId() {
        return this.insulinPresetId;
    }

    public final void setInsulinPresetId(String str) {
        this.insulinPresetId = str;
    }

    public final Date getUpdateTime() {
        return this.updateTime;
    }

    public final void setUpdateTime(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.updateTime = date;
    }

    public final String getInsulinId() {
        return this.insulinId;
    }

    public final void setInsulinId(String str) {
        this.insulinId = str;
    }

    public InsulinDetail(String str, String str2, String str3, String str4, String str5, double d, int i, int i2, String str6, Date date, String str7) {
        Intrinsics.checkNotNullParameter(date, "updateTime");
        this.relUuid = str;
        this.categoryName = str2;
        this.tradeName = str3;
        this.comment = str4;
        this.manufacturer = str5;
        this.quantity = d;
        this.unit = i;
        this.delete_flag = i2;
        this.insulinPresetId = str6;
        this.updateTime = date;
        this.insulinId = str7;
    }

    public String getEventDesc(String str) {
        String str2;
        String str3;
        if (str != null && (str3 = getName() + str + ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null) + 'U') != null) {
            return str3;
        }
        InsulinDetail insulinDetail = this;
        CharSequence charSequence = this.tradeName;
        String str4 = "";
        if (charSequence != null) {
            CharSequence charSequence2 = charSequence;
            if (charSequence2.length() == 0) {
                String str5 = this.manufacturer;
                if (str5 != null) {
                    CharSequence charSequence3 = str5;
                    if (charSequence3.length() == 0) {
                        charSequence3 = str4;
                    }
                    charSequence2 = (String) charSequence3;
                } else {
                    charSequence2 = null;
                }
            }
            str2 = (String) charSequence2;
        } else {
            str2 = null;
        }
        StringBuilder append = new StringBuilder().append(getName());
        if (str2 != null && str2.length() > 0) {
            str4 = "(" + str2 + ')';
        }
        return append.append(str4).append('(').append(ExtendsKt.stripTrailingZeros$default(Double.valueOf(this.quantity), (Integer) null, 1, (Object) null)).append("U)").toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InsulinDetailEntity(insulinPresetId=");
        sb.append(this.insulinPresetId).append(", relUuid=").append(this.relUuid).append(", categoryName='").append(this.categoryName).append("', tradeName='").append(this.tradeName).append("', comment='").append(this.comment).append("', manufacturer='").append(this.manufacturer).append("', quantity=").append(this.quantity).append(", unit=").append(this.unit).append(", delete_flag=").append(this.delete_flag).append(", createTime=").append(getCreateTime()).append(", updateTime=").append(this.updateTime).append(')');
        return sb.toString();
    }

    public Type getCurrClassMutableListType() {
        Type type = new InsulinDetail$getCurrClassMutableListType$$inlined$getMutableListType$1().getType();
        Intrinsics.checkNotNullExpressionValue(type, "getMutableListType(...)");
        return type;
    }
}
