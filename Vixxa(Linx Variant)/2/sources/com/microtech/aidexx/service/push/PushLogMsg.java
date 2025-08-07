package com.microtech.aidexx.service.push;

import androidx.core.content.ContextCompat;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.permission.PermissionGroups;
import com.tencent.mars.xlog.Log;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/service/push/PushLogMsg;", "Lcom/microtech/aidexx/service/push/PushMessage;", "()V", "applyMsg", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PushMessage.kt */
public final class PushLogMsg extends PushMessage {
    public Object applyMsg(Continuation<? super Boolean> continuation) {
        String[] storage = PermissionGroups.INSTANCE.getStorage();
        int length = storage.length;
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = true;
                break;
            }
            if (ContextCompat.checkSelfPermission(ExtendsKt.getContext(), storage[i]) == -1) {
                LogUtil.Companion companion = LogUtil.Companion;
                String tag = getTAG();
                Intrinsics.checkNotNullExpressionValue(tag, "<get-TAG>(...)");
                companion.xLogE("用户未授权文件读写权限", tag);
                break;
            }
            i++;
        }
        if (z) {
            Log.appenderFlushSync(true);
            LogUtil.Companion.uploadLog$default(LogUtil.Companion, (CoroutineScope) null, true, 1, (Object) null);
        }
        return Boxing.boxBoolean(z);
    }
}
