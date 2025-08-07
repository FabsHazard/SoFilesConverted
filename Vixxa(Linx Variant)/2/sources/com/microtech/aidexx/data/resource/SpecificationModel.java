package com.microtech.aidexx.data.resource;

import com.github.mikephil.charting.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00072\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\tHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/data/resource/SpecificationModel;", "", "specification", "", "ratio", "", "isDefault", "", "code", "", "check", "(Ljava/lang/String;DZIZ)V", "getCheck", "()Z", "setCheck", "(Z)V", "getCode", "()I", "getRatio", "()D", "getSpecification", "()Ljava/lang/String;", "setSpecification", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventUnitManager.kt */
public final class SpecificationModel {
    private boolean check;
    private final int code;
    private final boolean isDefault;
    private final double ratio;
    private String specification;

    public SpecificationModel() {
        this((String) null, Utils.DOUBLE_EPSILON, false, 0, false, 31, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SpecificationModel copy$default(SpecificationModel specificationModel, String str, double d, boolean z, int i, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = specificationModel.specification;
        }
        if ((i2 & 2) != 0) {
            d = specificationModel.ratio;
        }
        double d2 = d;
        if ((i2 & 4) != 0) {
            z = specificationModel.isDefault;
        }
        boolean z3 = z;
        if ((i2 & 8) != 0) {
            i = specificationModel.code;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z2 = specificationModel.check;
        }
        return specificationModel.copy(str, d2, z3, i3, z2);
    }

    public final String component1() {
        return this.specification;
    }

    public final double component2() {
        return this.ratio;
    }

    public final boolean component3() {
        return this.isDefault;
    }

    public final int component4() {
        return this.code;
    }

    public final boolean component5() {
        return this.check;
    }

    public final SpecificationModel copy(String str, double d, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "specification");
        return new SpecificationModel(str, d, z, i, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SpecificationModel)) {
            return false;
        }
        SpecificationModel specificationModel = (SpecificationModel) obj;
        return Intrinsics.areEqual((Object) this.specification, (Object) specificationModel.specification) && Double.compare(this.ratio, specificationModel.ratio) == 0 && this.isDefault == specificationModel.isDefault && this.code == specificationModel.code && this.check == specificationModel.check;
    }

    public int hashCode() {
        int hashCode = ((this.specification.hashCode() * 31) + Double.hashCode(this.ratio)) * 31;
        boolean z = this.isDefault;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + Integer.hashCode(this.code)) * 31;
        boolean z3 = this.check;
        if (!z3) {
            z2 = z3;
        }
        return hashCode2 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "SpecificationModel(specification=" + this.specification + ", ratio=" + this.ratio + ", isDefault=" + this.isDefault + ", code=" + this.code + ", check=" + this.check + ')';
    }

    public SpecificationModel(String str, double d, boolean z, int i, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "specification");
        this.specification = str;
        this.ratio = d;
        this.isDefault = z;
        this.code = i;
        this.check = z2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SpecificationModel(java.lang.String r5, double r6, boolean r8, int r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.lang.String r5 = ""
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            r6 = 4607182418800017408(0x3ff0000000000000, double:1.0)
        L_0x000c:
            r0 = r6
            r6 = r11 & 4
            r7 = 0
            if (r6 == 0) goto L_0x0014
            r12 = r7
            goto L_0x0015
        L_0x0014:
            r12 = r8
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = r7
            goto L_0x001c
        L_0x001b:
            r2 = r9
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r3 = r7
            goto L_0x0023
        L_0x0022:
            r3 = r10
        L_0x0023:
            r6 = r4
            r7 = r5
            r8 = r0
            r10 = r12
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.data.resource.SpecificationModel.<init>(java.lang.String, double, boolean, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getSpecification() {
        return this.specification;
    }

    public final void setSpecification(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.specification = str;
    }

    public final double getRatio() {
        return this.ratio;
    }

    public final boolean isDefault() {
        return this.isDefault;
    }

    public final int getCode() {
        return this.code;
    }

    public final boolean getCheck() {
        return this.check;
    }

    public final void setCheck(boolean z) {
        this.check = z;
    }
}
