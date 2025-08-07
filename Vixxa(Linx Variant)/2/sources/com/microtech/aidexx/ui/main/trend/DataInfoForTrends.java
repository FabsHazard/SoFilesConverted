package com.microtech.aidexx.ui.main.trend;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B3\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR$\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/DataInfoForTrends;", "", "multiDayBgItemList", "", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "glucoseArray", "", "", "historyCount", "", "totalHistory", "(Ljava/util/List;[[DII)V", "getGlucoseArray", "()[[D", "setGlucoseArray", "([[D)V", "[[D", "getHistoryCount", "()I", "setHistoryCount", "(I)V", "getMultiDayBgItemList", "()Ljava/util/List;", "setMultiDayBgItemList", "(Ljava/util/List;)V", "getTotalHistory", "setTotalHistory", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataInfoForTrends.kt */
public final class DataInfoForTrends {
    private double[][] glucoseArray;
    private int historyCount;
    private List<MultiDayBgItem> multiDayBgItemList;
    private int totalHistory;

    public DataInfoForTrends(List<MultiDayBgItem> list, double[][] dArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(list, "multiDayBgItemList");
        this.multiDayBgItemList = list;
        this.glucoseArray = dArr;
        this.historyCount = i;
        this.totalHistory = i2;
    }

    public final List<MultiDayBgItem> getMultiDayBgItemList() {
        return this.multiDayBgItemList;
    }

    public final void setMultiDayBgItemList(List<MultiDayBgItem> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.multiDayBgItemList = list;
    }

    public final double[][] getGlucoseArray() {
        return this.glucoseArray;
    }

    public final void setGlucoseArray(double[][] dArr) {
        this.glucoseArray = dArr;
    }

    public final int getHistoryCount() {
        return this.historyCount;
    }

    public final void setHistoryCount(int i) {
        this.historyCount = i;
    }

    public final int getTotalHistory() {
        return this.totalHistory;
    }

    public final void setTotalHistory(int i) {
        this.totalHistory = i;
    }
}
