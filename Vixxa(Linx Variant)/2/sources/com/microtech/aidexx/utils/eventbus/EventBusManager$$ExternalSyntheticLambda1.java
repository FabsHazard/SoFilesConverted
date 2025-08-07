package com.microtech.aidexx.utils.eventbus;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventBusManager$$ExternalSyntheticLambda1 implements Observer {
    public final /* synthetic */ Function2 f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ EventBusManager$$ExternalSyntheticLambda1(Function2 function2, String str) {
        this.f$0 = function2;
        this.f$1 = str;
    }

    public final void onChanged(Object obj) {
        EventBusManager.onReceive$lambda$0(this.f$0, this.f$1, obj);
    }
}
