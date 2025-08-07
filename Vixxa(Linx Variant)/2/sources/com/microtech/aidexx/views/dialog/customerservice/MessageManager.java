package com.microtech.aidexx.views.dialog.customerservice;

import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000  2\u00020\u0001:\u0001 B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\u0006J\u0006\u0010\u0014\u001a\u00020\u0006J\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0016\u0010\u001d\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010\u001e\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010\u001f\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005R\u001f\u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006!"}, d2 = {"Lcom/microtech/aidexx/views/dialog/customerservice/MessageManager;", "", "()V", "addListenerList", "", "Lkotlin/Function0;", "", "getAddListenerList", "()Ljava/util/List;", "clearListenerList", "getClearListenerList", "onMessageAdded", "getOnMessageAdded", "()Lkotlin/jvm/functions/Function0;", "setOnMessageAdded", "(Lkotlin/jvm/functions/Function0;)V", "onMessageClear", "getOnMessageClear", "setOnMessageClear", "addMessage", "clearMessage", "getMessageCount", "", "getMessageCountStr", "", "removeAddMessageListener", "listener", "removeAllAddMessageListener", "removeAllClearMessageListener", "removeClearMessageListener", "setAddMessageListener", "setClearMessageListener", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MessageManager.kt */
public final class MessageManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MessageManager INSTANCE = new MessageManager();
    private final List<Function0<Unit>> addListenerList = new ArrayList();
    private final List<Function0<Unit>> clearListenerList = new ArrayList();
    private Function0<Unit> onMessageAdded;
    private Function0<Unit> onMessageClear;

    private MessageManager() {
    }

    public final List<Function0<Unit>> getAddListenerList() {
        return this.addListenerList;
    }

    public final List<Function0<Unit>> getClearListenerList() {
        return this.clearListenerList;
    }

    public final Function0<Unit> getOnMessageAdded() {
        return this.onMessageAdded;
    }

    public final void setOnMessageAdded(Function0<Unit> function0) {
        this.onMessageAdded = function0;
    }

    public final Function0<Unit> getOnMessageClear() {
        return this.onMessageClear;
    }

    public final void setOnMessageClear(Function0<Unit> function0) {
        this.onMessageClear = function0;
    }

    public final void setAddMessageListener(Function0<Unit> function0) {
        this.addListenerList.add(function0);
    }

    public final void setClearMessageListener(Function0<Unit> function0) {
        this.clearListenerList.add(function0);
    }

    public final void removeAllAddMessageListener() {
        this.addListenerList.clear();
    }

    public final void removeAllClearMessageListener() {
        this.clearListenerList.clear();
    }

    public final void removeAddMessageListener(Function0<Unit> function0) {
        this.addListenerList.remove(function0);
    }

    public final void removeClearMessageListener(Function0<Unit> function0) {
        this.clearListenerList.remove(function0);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/views/dialog/customerservice/MessageManager$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/views/dialog/customerservice/MessageManager;", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MessageManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageManager instance() {
            return MessageManager.INSTANCE;
        }
    }

    public final int getMessageCount() {
        return MmkvManager.INSTANCE.getOnlineServiceMsgCount();
    }

    public final String getMessageCountStr() {
        int messageCount = getMessageCount();
        if (messageCount > 99) {
            return "99+";
        }
        if (messageCount == 0) {
            return "";
        }
        return String.valueOf(messageCount);
    }

    public final void addMessage() {
        MmkvManager.INSTANCE.setOnlineServiceMsgCount(getMessageCount() + 1);
        for (Function0 next : this.addListenerList) {
            if (next != null) {
                next.invoke();
            }
        }
    }

    public final void clearMessage() {
        MmkvManager.INSTANCE.setOnlineServiceMsgCount(0);
        for (Function0 next : this.clearListenerList) {
            if (next != null) {
                next.invoke();
            }
        }
    }
}
