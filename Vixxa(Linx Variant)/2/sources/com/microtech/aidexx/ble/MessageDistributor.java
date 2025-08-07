package com.microtech.aidexx.ble;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.StringUtils;
import com.microtechmd.blecomm.entity.BleMessage;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/ble/MessageDistributor;", "", "()V", "observerList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/microtech/aidexx/ble/MessageObserver;", "topObserver", "clear", "", "observer", "observerAndIntercept", "removeObserver", "send", "message", "Lcom/microtechmd/blecomm/entity/BleMessage;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MessageDistributor.kt */
public final class MessageDistributor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static MessageDistributor instance;
    private final CopyOnWriteArrayList<MessageObserver> observerList = new CopyOnWriteArrayList<>();
    private MessageObserver topObserver;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ble/MessageDistributor$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/ble/MessageDistributor;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MessageDistributor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final synchronized MessageDistributor instance() {
            MessageDistributor access$getInstance$cp;
            if (MessageDistributor.instance == null) {
                MessageDistributor.instance = new MessageDistributor();
            }
            access$getInstance$cp = MessageDistributor.instance;
            Intrinsics.checkNotNull(access$getInstance$cp);
            return access$getInstance$cp;
        }
    }

    public final void observerAndIntercept(MessageObserver messageObserver) {
        Intrinsics.checkNotNullParameter(messageObserver, "observer");
        this.topObserver = messageObserver;
    }

    public final void removeObserver() {
        this.topObserver = null;
    }

    public final void observer(MessageObserver messageObserver) {
        Intrinsics.checkNotNullParameter(messageObserver, "observer");
        if (!this.observerList.contains(messageObserver)) {
            this.observerList.add(messageObserver);
        }
    }

    public final void removeObserver(MessageObserver messageObserver) {
        Intrinsics.checkNotNullParameter(messageObserver, "observer");
        this.observerList.remove(messageObserver);
    }

    public final void send(BleMessage bleMessage) {
        Intrinsics.checkNotNullParameter(bleMessage, CrashHianalyticsData.MESSAGE);
        if (bleMessage.getOperation() != 1) {
            LogUtil.Companion.eAiDEX("Operation:" + Util.toHexString(bleMessage.getOperation()) + ", Success:" + bleMessage.isSuccess() + ", Data:" + StringUtils.INSTANCE.binaryToHexString(bleMessage.getData()));
        }
        MessageObserver messageObserver = this.topObserver;
        if (messageObserver == null) {
            Iterator<MessageObserver> it = this.observerList.iterator();
            while (it.hasNext()) {
                it.next().onMessage(bleMessage);
            }
        } else if (messageObserver != null) {
            messageObserver.onMessage(bleMessage);
        }
    }

    public final void clear() {
        this.observerList.clear();
    }
}
