package com.microtech.aidexx.service;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.utils.LogUtil;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/microtech/aidexx/service/MainService$serviceHandler$1", "Landroid/os/Handler;", "handleMessage", "", "msg", "Landroid/os/Message;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MainService.kt */
public final class MainService$serviceHandler$1 extends Handler {
    final /* synthetic */ MainService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MainService$serviceHandler$1(MainService mainService, Looper looper) {
        super(looper);
        this.this$0 = mainService;
    }

    public void handleMessage(Message message) {
        Intrinsics.checkNotNullParameter(message, NotificationCompat.CATEGORY_MESSAGE);
        LogUtil.Companion.eAiDEX("main service start success");
        int i = message.what;
        if (i != 10011) {
            if (i == 10012) {
                this.this$0.scheduleTask();
                LocalNotificationManager.INSTANCE.cancelAllNotification(this.this$0);
                TransmitterManager.Companion.setOnTransmitterChangeListener(this.this$0.onTransmitterChangeListener);
            }
        } else if (UserInfoManager.Companion.instance().isLogin()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), (CoroutineContext) null, (CoroutineStart) null, new MainService$serviceHandler$1$handleMessage$1((Continuation<? super MainService$serviceHandler$1$handleMessage$1>) null), 3, (Object) null);
        }
    }
}
