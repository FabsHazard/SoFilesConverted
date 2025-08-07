package com.microtech.aidexx.ui.main.trend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/MultiDayBGManager;", "", "()V", "colorSet", "", "", "mutableListOf", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBgItem;", "getMutableListOf", "()Ljava/util/List;", "findDataByDays", "Lcom/microtech/aidexx/ui/main/trend/DataInfoForTrends;", "startDate", "Ljava/util/Date;", "endDate", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MultiDayBgManager.kt */
public final class MultiDayBGManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MultiDayBGManager instance = new MultiDayBGManager();
    /* access modifiers changed from: private */
    public final List<String> colorSet = CollectionsKt.mutableListOf("#0089ff", "#26c2d3", "#ffed00", "#0089ff", "#63ac19", "#00e7ff", "#0600ff", "#12cea5", "#ffcb00", "#6016b6", "#94ab0d", "#00ffc8", "#8b00ff", "#336f53", "#ffa400", "#2118bd", "#69720e", "#fb00ff", "#53cb41", "#ff7e00", "#aa17a8", "#d7b612", "#ff0085", "#aaff00", "#ff4800", "#80325b", "#c89659", "#ff0000", "#6570d9", "#769ac1", "#099514", "#9f340c");
    private final List<MultiDayBgItem> mutableListOf = new ArrayList();

    public final List<MultiDayBgItem> getMutableListOf() {
        return this.mutableListOf;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/MultiDayBGManager$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/ui/main/trend/MultiDayBGManager;", "getInstance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MultiDayBgManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MultiDayBGManager getInstance() {
            return MultiDayBGManager.instance;
        }
    }

    public final Object findDataByDays(Date date, Date date2, Continuation<? super DataInfoForTrends> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MultiDayBGManager$findDataByDays$2(this, date2, date, (Continuation<? super MultiDayBGManager$findDataByDays$2>) null), continuation);
    }
}
