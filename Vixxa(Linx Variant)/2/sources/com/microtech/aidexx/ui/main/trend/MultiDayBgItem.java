package com.microtech.aidexx.ui.main.trend;

import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R,\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "", "dateDesc", "Ljava/util/Date;", "checked", "", "histories", "", "", "", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "color", "", "(Ljava/util/Date;ZLjava/util/Map;I)V", "getChecked", "()Z", "setChecked", "(Z)V", "getColor", "()I", "setColor", "(I)V", "getDateDesc", "()Ljava/util/Date;", "setDateDesc", "(Ljava/util/Date;)V", "getHistories", "()Ljava/util/Map;", "setHistories", "(Ljava/util/Map;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MultiDayBgItem.kt */
public final class MultiDayBgItem {
    private boolean checked;
    private int color;
    private Date dateDesc;
    private Map<String, List<RealCgmHistoryEntity>> histories;

    public MultiDayBgItem(Date date, boolean z, Map<String, List<RealCgmHistoryEntity>> map, int i) {
        Intrinsics.checkNotNullParameter(date, "dateDesc");
        Intrinsics.checkNotNullParameter(map, "histories");
        this.dateDesc = date;
        this.checked = z;
        this.histories = map;
        this.color = i;
    }

    public final Date getDateDesc() {
        return this.dateDesc;
    }

    public final void setDateDesc(Date date) {
        Intrinsics.checkNotNullParameter(date, "<set-?>");
        this.dateDesc = date;
    }

    public final boolean getChecked() {
        return this.checked;
    }

    public final void setChecked(boolean z) {
        this.checked = z;
    }

    public final Map<String, List<RealCgmHistoryEntity>> getHistories() {
        return this.histories;
    }

    public final void setHistories(Map<String, List<RealCgmHistoryEntity>> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.histories = map;
    }

    public final int getColor() {
        return this.color;
    }

    public final void setColor(int i) {
        this.color = i;
    }
}
