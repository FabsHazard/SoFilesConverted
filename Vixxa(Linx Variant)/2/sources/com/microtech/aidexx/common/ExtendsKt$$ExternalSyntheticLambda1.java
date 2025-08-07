package com.microtech.aidexx.common;

import android.view.View;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExtendsKt$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Ref.LongRef f$0;
    public final /* synthetic */ long f$1;
    public final /* synthetic */ View.OnClickListener f$2;

    public /* synthetic */ ExtendsKt$$ExternalSyntheticLambda1(Ref.LongRef longRef, long j, View.OnClickListener onClickListener) {
        this.f$0 = longRef;
        this.f$1 = j;
        this.f$2 = onClickListener;
    }

    public final void onClick(View view) {
        ExtendsKt.setDebounceClickListener$lambda$3(this.f$0, this.f$1, this.f$2, view);
    }
}
