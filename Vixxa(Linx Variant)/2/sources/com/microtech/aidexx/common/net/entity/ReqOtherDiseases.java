package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqOtherDiseases;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqOtherDiseases extends ReqEntity {
    private final String name;

    public static /* synthetic */ ReqOtherDiseases copy$default(ReqOtherDiseases reqOtherDiseases, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqOtherDiseases.name;
        }
        return reqOtherDiseases.copy(str);
    }

    public final String component1() {
        return this.name;
    }

    public final ReqOtherDiseases copy(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        return new ReqOtherDiseases(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReqOtherDiseases) && Intrinsics.areEqual((Object) this.name, (Object) ((ReqOtherDiseases) obj).name);
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "ReqOtherDiseases(name=" + this.name + ')';
    }

    public final String getName() {
        return this.name;
    }

    public ReqOtherDiseases(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }
}
