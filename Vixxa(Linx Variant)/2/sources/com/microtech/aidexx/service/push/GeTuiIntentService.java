package com.microtech.aidexx.service.push;

import android.content.Context;
import com.google.gson.Gson;
import com.igexin.sdk.GTIntentService;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.message.GTCmdMessage;
import com.igexin.sdk.message.GTNotificationMessage;
import com.igexin.sdk.message.GTTransmitMessage;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u001c\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/service/push/GeTuiIntentService;", "Lcom/igexin/sdk/GTIntentService;", "()V", "onNotificationMessageArrived", "", "context", "Landroid/content/Context;", "msg", "Lcom/igexin/sdk/message/GTNotificationMessage;", "onNotificationMessageClicked", "onReceiveClientId", "clientid", "", "onReceiveCommandResult", "cmdMessage", "Lcom/igexin/sdk/message/GTCmdMessage;", "onReceiveMessageData", "Lcom/igexin/sdk/message/GTTransmitMessage;", "onReceiveOnlineState", "online", "", "onReceiveServicePid", "pid", "", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GeTuiIntentService.kt */
public final class GeTuiIntentService extends GTIntentService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String tag = "GeTuiIntentService";

    public void onNotificationMessageArrived(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onNotificationMessageClicked(Context context, GTNotificationMessage gTNotificationMessage) {
    }

    public void onReceiveCommandResult(Context context, GTCmdMessage gTCmdMessage) {
    }

    public void onReceiveServicePid(Context context, int i) {
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/service/push/GeTuiIntentService$Companion;", "", "()V", "tag", "", "kotlin.jvm.PlatformType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: GeTuiIntentService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void onReceiveMessageData(Context context, GTTransmitMessage gTTransmitMessage) {
        PushMessage pushMessage;
        Object obj;
        byte[] payload = gTTransmitMessage != null ? gTTransmitMessage.getPayload() : null;
        if (payload != null) {
            String str = new String(payload, Charsets.UTF_8);
            LogUtil.Companion companion = LogUtil.Companion;
            String str2 = tag;
            Intrinsics.checkNotNullExpressionValue(str2, "tag");
            companion.d(str, str2);
            try {
                Object fromJson = new Gson().fromJson(str, PushMessage.class);
                PushMessage pushMessage2 = (PushMessage) fromJson;
                pushMessage2.setMessageId(gTTransmitMessage.getMessageId());
                pushMessage2.setTaskId(gTTransmitMessage.getTaskId());
                pushMessage = (PushMessage) fromJson;
            } catch (Exception e) {
                String str3 = tag;
                Intrinsics.checkNotNullExpressionValue(str3, "tag");
                LogUtil.Companion.xLogE("推送消息异常：" + e, str3);
                pushMessage = null;
            }
            if (pushMessage != null) {
                PushMessage realMsgByType = pushMessage.getRealMsgByType();
                if (realMsgByType == null || (obj = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new GeTuiIntentService$onReceiveMessageData$1$2$1$1(realMsgByType, (Continuation<? super GeTuiIntentService$onReceiveMessageData$1$2$1$1>) null), 3, (Object) null)) == null) {
                    GeTuiIntentService geTuiIntentService = this;
                    LogUtil.Companion companion2 = LogUtil.Companion;
                    String str4 = "推送消息获取实体失败 " + pushMessage.getMsgType() + "--" + pushMessage.getDetail();
                    String str5 = tag;
                    Intrinsics.checkNotNullExpressionValue(str5, "tag");
                    companion2.xLogE(str4, str5);
                    obj = Unit.INSTANCE;
                }
                if (obj != null) {
                    return;
                }
            }
            GeTuiIntentService geTuiIntentService2 = this;
            LogUtil.Companion companion3 = LogUtil.Companion;
            String str6 = tag;
            Intrinsics.checkNotNullExpressionValue(str6, "tag");
            companion3.xLogE("推送消息异常-1", str6);
            return;
        }
        GeTuiIntentService geTuiIntentService3 = this;
        LogUtil.Companion companion4 = LogUtil.Companion;
        String str7 = tag;
        Intrinsics.checkNotNullExpressionValue(str7, "tag");
        companion4.xLogE("推送消息接收异常", str7);
    }

    public void onReceiveClientId(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, PushConsts.KEY_CLIENT_ID);
        String str2 = tag;
        Intrinsics.checkNotNullExpressionValue(str2, "tag");
        LogUtil.Companion.xLogI("CLIENTID=" + str, str2);
        if (MmkvManager.INSTANCE.isLogin()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new GeTuiIntentService$onReceiveClientId$1(str, (Continuation<? super GeTuiIntentService$onReceiveClientId$1>) null), 3, (Object) null);
        }
    }

    public void onReceiveOnlineState(Context context, boolean z) {
        String str = tag;
        Intrinsics.checkNotNullExpressionValue(str, "tag");
        LogUtil.Companion.xLogI("o=" + z, str);
    }
}
