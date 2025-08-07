package com.microtech.aidexx.ui.setting;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.SettingsManager", f = "SettingsManager.kt", i = {0}, l = {104}, m = "uploadSettings", n = {"it"}, s = {"L$0"})
/* compiled from: SettingsManager.kt */
final class SettingsManager$uploadSettings$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SettingsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingsManager$uploadSettings$1(SettingsManager settingsManager, Continuation<? super SettingsManager$uploadSettings$1> continuation) {
        super(continuation);
        this.this$0 = settingsManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadSettings(this);
    }
}
