package com.microtech.aidexx.utils.eventbus;

import androidx.lifecycle.Observer;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class EventBusManager$$ExternalSyntheticLambda0 implements Observer {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ EventBusManager$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onChanged(Object obj) {
        EventBusManager.onReceive$lambda$1(this.f$0, obj);
    }
}
