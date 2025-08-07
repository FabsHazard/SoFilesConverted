package com.microtech.aidexx.db;

import io.objectbox.TxCallback;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ObjectBox$$ExternalSyntheticLambda0 implements TxCallback {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ ObjectBox$$ExternalSyntheticLambda0(Function0 function0, Function1 function1) {
        this.f$0 = function0;
        this.f$1 = function1;
    }

    public final void txFinished(Object obj, Throwable th) {
        ObjectBox.runAsync$lambda$0(this.f$0, this.f$1, (Void) obj, th);
    }
}
