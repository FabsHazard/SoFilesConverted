package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ReqGetuiLogin;", "Lcom/microtech/aidexx/common/net/entity/ReqEntity;", "getuiCid", "", "cidOrigin", "(Ljava/lang/String;Ljava/lang/String;)V", "getCidOrigin", "()Ljava/lang/String;", "getGetuiCid", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RequestEntity.kt */
public final class ReqGetuiLogin extends ReqEntity {
    private final String cidOrigin;
    private final String getuiCid;

    public static /* synthetic */ ReqGetuiLogin copy$default(ReqGetuiLogin reqGetuiLogin, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = reqGetuiLogin.getuiCid;
        }
        if ((i & 2) != 0) {
            str2 = reqGetuiLogin.cidOrigin;
        }
        return reqGetuiLogin.copy(str, str2);
    }

    public final String component1() {
        return this.getuiCid;
    }

    public final String component2() {
        return this.cidOrigin;
    }

    public final ReqGetuiLogin copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "getuiCid");
        Intrinsics.checkNotNullParameter(str2, "cidOrigin");
        return new ReqGetuiLogin(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReqGetuiLogin)) {
            return false;
        }
        ReqGetuiLogin reqGetuiLogin = (ReqGetuiLogin) obj;
        return Intrinsics.areEqual((Object) this.getuiCid, (Object) reqGetuiLogin.getuiCid) && Intrinsics.areEqual((Object) this.cidOrigin, (Object) reqGetuiLogin.cidOrigin);
    }

    public int hashCode() {
        return (this.getuiCid.hashCode() * 31) + this.cidOrigin.hashCode();
    }

    public String toString() {
        return "ReqGetuiLogin(getuiCid=" + this.getuiCid + ", cidOrigin=" + this.cidOrigin + ')';
    }

    public final String getGetuiCid() {
        return this.getuiCid;
    }

    public final String getCidOrigin() {
        return this.cidOrigin;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ReqGetuiLogin(java.lang.String r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x003e
            java.lang.String r2 = "gpGrxMmol"
            int r3 = r2.hashCode()
            switch(r3) {
                case -1892754207: goto L_0x0032;
                case 700679200: goto L_0x0026;
                case 1096750016: goto L_0x001a;
                case 1709787171: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x003c
        L_0x000e:
            java.lang.String r3 = "gpAidexMmol"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0017
            goto L_0x003c
        L_0x0017:
            java.lang.String r2 = "3"
            goto L_0x003e
        L_0x001a:
            java.lang.String r3 = "gpAidexMg"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x0023
            goto L_0x003c
        L_0x0023:
            java.lang.String r2 = "2"
            goto L_0x003e
        L_0x0026:
            java.lang.String r3 = "cnAidexMgmo"
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x002f
            goto L_0x003c
        L_0x002f:
            java.lang.String r2 = "1"
            goto L_0x003e
        L_0x0032:
            boolean r2 = r2.equals(r2)
            if (r2 != 0) goto L_0x0039
            goto L_0x003c
        L_0x0039:
            java.lang.String r2 = "9"
            goto L_0x003e
        L_0x003c:
            java.lang.String r2 = "0"
        L_0x003e:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.entity.ReqGetuiLogin.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public ReqGetuiLogin(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "getuiCid");
        Intrinsics.checkNotNullParameter(str2, "cidOrigin");
        this.getuiCid = str;
        this.cidOrigin = str2;
    }
}
