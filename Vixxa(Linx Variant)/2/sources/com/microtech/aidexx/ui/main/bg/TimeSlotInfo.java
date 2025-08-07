package com.microtech.aidexx.ui.main.bg;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/TimeSlotInfo;", "", "name", "", "isChecked", "", "(Ljava/lang/String;Z)V", "()Z", "setChecked", "(Z)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimeSlotInfo.kt */
public final class TimeSlotInfo {
    private boolean isChecked;
    private String name;

    public TimeSlotInfo(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.isChecked = z;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    public final void setName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }
}
