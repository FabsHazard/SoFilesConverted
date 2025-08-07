package com.microtech.aidexx.data;

import com.microtech.aidexx.utils.LogUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0010H\u0002J\b\u0010\u0012\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/data/SyncFrequencyLimitController;", "", "()V", "curRateIndex", "", "nextDoTimestampSecond", "normalInterval", "tag", "", "kotlin.jvm.PlatformType", "uploadTaskIntervalRate", "", "canDo", "", "content", "resetNextDoTime", "", "setNextDoTime", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DataSyncController.kt */
public final class SyncFrequencyLimitController {
    private int curRateIndex;
    private int nextDoTimestampSecond;
    private final int normalInterval = 30;
    private final String tag = "SyncFrequencyLimitController";
    private final List<Integer> uploadTaskIntervalRate = CollectionsKt.listOf(1, 4, 4, 10, 10, 30, 60, 120);

    public static /* synthetic */ boolean canDo$default(SyncFrequencyLimitController syncFrequencyLimitController, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        return syncFrequencyLimitController.canDo(str);
    }

    public final boolean canDo(String str) {
        Intrinsics.checkNotNullParameter(str, "content");
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        if (currentTimeMillis < ((long) this.nextDoTimestampSecond)) {
            String str2 = this.tag;
            Intrinsics.checkNotNullExpressionValue(str2, "tag");
            LogUtil.Companion.xLogE(str + " 被降频 curRateIndex=" + this.curRateIndex + " rate=" + this.uploadTaskIntervalRate.get(this.curRateIndex).intValue() + " curTime=" + currentTimeMillis + " next=" + this.nextDoTimestampSecond + ' ' + this, str2);
            LogUtil.Companion companion = LogUtil.Companion;
            String str3 = str + " 被降频 curRateIndex=" + this.curRateIndex + " rate=" + this.uploadTaskIntervalRate.get(this.curRateIndex).intValue() + " curTime=" + currentTimeMillis + " next=" + this.nextDoTimestampSecond;
            String str4 = this.tag;
            Intrinsics.checkNotNullExpressionValue(str4, "tag");
            companion.d(str3, str4);
            return false;
        }
        LogUtil.Companion companion2 = LogUtil.Companion;
        String str5 = "idx=" + this.curRateIndex + " rate=" + this.uploadTaskIntervalRate.get(this.curRateIndex).intValue() + " cur=" + currentTimeMillis + " next=" + this.nextDoTimestampSecond + ' ' + str + " 开始执行";
        String str6 = this.tag;
        Intrinsics.checkNotNullExpressionValue(str6, "tag");
        companion2.d(str5, str6);
        setNextDoTime();
        return true;
    }

    private final void setNextDoTime() {
        int i = this.curRateIndex + 1;
        this.curRateIndex = i;
        if (i >= this.uploadTaskIntervalRate.size()) {
            this.curRateIndex = this.uploadTaskIntervalRate.size() - 1;
        }
        this.nextDoTimestampSecond = ((int) (System.currentTimeMillis() / ((long) 1000))) + (this.normalInterval * this.uploadTaskIntervalRate.get(this.curRateIndex).intValue());
    }

    public final void resetNextDoTime() {
        this.curRateIndex = 0;
        this.nextDoTimestampSecond = 0;
    }

    public String toString() {
        return "idx=" + this.curRateIndex + " rate=" + this.uploadTaskIntervalRate.get(this.curRateIndex).intValue() + " next=" + this.nextDoTimestampSecond;
    }
}
