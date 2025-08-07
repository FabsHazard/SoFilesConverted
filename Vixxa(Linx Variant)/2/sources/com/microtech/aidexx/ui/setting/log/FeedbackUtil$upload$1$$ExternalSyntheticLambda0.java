package com.microtech.aidexx.ui.setting.log;

import android.content.Context;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FeedbackUtil$upload$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ File f$1;

    public /* synthetic */ FeedbackUtil$upload$1$$ExternalSyntheticLambda0(Context context, File file) {
        this.f$0 = context;
        this.f$1 = file;
    }

    public final void run() {
        FeedbackUtil$upload$1.onResponse$lambda$0(this.f$0, this.f$1);
    }
}
