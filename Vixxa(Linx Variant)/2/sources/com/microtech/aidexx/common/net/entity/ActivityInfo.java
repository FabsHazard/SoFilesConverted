package com.microtech.aidexx.common.net.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003JE\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/common/net/entity/ActivityInfo;", "", "title", "", "content", "activityId", "", "url", "description", "isLook", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;I)V", "getActivityId", "()I", "getContent", "()Ljava/lang/String;", "getDescription", "getTitle", "getUrl", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseResponse.kt */
public final class ActivityInfo {
    private final int activityId;
    private final String content;
    private final String description;
    private final int isLook;
    private final String title;
    private final String url;

    public static /* synthetic */ ActivityInfo copy$default(ActivityInfo activityInfo, String str, String str2, int i, String str3, String str4, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = activityInfo.title;
        }
        if ((i3 & 2) != 0) {
            str2 = activityInfo.content;
        }
        String str5 = str2;
        if ((i3 & 4) != 0) {
            i = activityInfo.activityId;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            str3 = activityInfo.url;
        }
        String str6 = str3;
        if ((i3 & 16) != 0) {
            str4 = activityInfo.description;
        }
        String str7 = str4;
        if ((i3 & 32) != 0) {
            i2 = activityInfo.isLook;
        }
        return activityInfo.copy(str, str5, i4, str6, str7, i2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.content;
    }

    public final int component3() {
        return this.activityId;
    }

    public final String component4() {
        return this.url;
    }

    public final String component5() {
        return this.description;
    }

    public final int component6() {
        return this.isLook;
    }

    public final ActivityInfo copy(String str, String str2, int i, String str3, String str4, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, "description");
        return new ActivityInfo(str, str2, i, str3, str4, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityInfo)) {
            return false;
        }
        ActivityInfo activityInfo = (ActivityInfo) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) activityInfo.title) && Intrinsics.areEqual((Object) this.content, (Object) activityInfo.content) && this.activityId == activityInfo.activityId && Intrinsics.areEqual((Object) this.url, (Object) activityInfo.url) && Intrinsics.areEqual((Object) this.description, (Object) activityInfo.description) && this.isLook == activityInfo.isLook;
    }

    public int hashCode() {
        return (((((((((this.title.hashCode() * 31) + this.content.hashCode()) * 31) + Integer.hashCode(this.activityId)) * 31) + this.url.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.isLook);
    }

    public String toString() {
        return "ActivityInfo(title=" + this.title + ", content=" + this.content + ", activityId=" + this.activityId + ", url=" + this.url + ", description=" + this.description + ", isLook=" + this.isLook + ')';
    }

    public ActivityInfo(String str, String str2, int i, String str3, String str4, int i2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "content");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(str4, "description");
        this.title = str;
        this.content = str2;
        this.activityId = i;
        this.url = str3;
        this.description = str4;
        this.isLook = i2;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getContent() {
        return this.content;
    }

    public final int getActivityId() {
        return this.activityId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int isLook() {
        return this.isLook;
    }
}
