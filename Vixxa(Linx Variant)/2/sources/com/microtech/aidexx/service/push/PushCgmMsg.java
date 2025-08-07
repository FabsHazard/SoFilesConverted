package com.microtech.aidexx.service.push;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/service/push/PushCgmMsg;", "Lcom/microtech/aidexx/service/push/PushMessage;", "()V", "applyMsg", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PushMessage.kt */
public final class PushCgmMsg extends PushMessage {
    public Object applyMsg(Continuation<? super Boolean> continuation) {
        Integer msgType = getMsgType();
        if ((msgType == null || msgType.intValue() != 1) && ((msgType == null || msgType.intValue() != 2) && msgType != null)) {
            int intValue = msgType.intValue();
        }
        return Boxing.boxBoolean(false);
    }
}
