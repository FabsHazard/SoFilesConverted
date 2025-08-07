package com.microtech.aidexx.ui.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.SettingsManager", f = "SettingsManager.kt", i = {}, l = {125}, m = "downloadSettings", n = {}, s = {})
/* compiled from: SettingsManager.kt */
final class SettingsManager$downloadSettings$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsManager$downloadSettings$1(SettingsManager settingsManager, Continuation<? super SettingsManager$downloadSettings$1> continuation) {
        super(continuation);
        this.this$0 = settingsManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadSettings((String) null, this);
    }
}
