package com.microtech.aidexx.ui.main.home.chart;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.ViewModelKt;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/ui/main/home/chart/ChartViewModel$timerHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewModel.kt */
public final class ChartViewModel$timerHandler$1 extends Handler {
    final /* synthetic */ ChartViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChartViewModel$timerHandler$1(ChartViewModel chartViewModel, Looper looper) {
        super(looper);
        this.this$0 = chartViewModel;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        if (1 == message.what) {
            LogUtil.Companion.d("未接收到数据 定时刷新", "ChartViewModel");
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$timerHandler$1$handleMessage$1(this.this$0, (Continuation<? super ChartViewModel$timerHandler$1$handleMessage$1>) null), 3, (Object) null);
        }
    }
}
