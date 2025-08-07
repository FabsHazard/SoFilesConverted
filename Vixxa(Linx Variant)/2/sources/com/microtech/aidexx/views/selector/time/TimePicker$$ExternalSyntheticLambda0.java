package com.microtech.aidexx.views.selector.time;

import android.view.View;
import com.microtech.aidexx.views.selector.base.OnTimeSelectListener;
import java.util.Date;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TimePicker$$ExternalSyntheticLambda0 implements OnTimeSelectListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ TimePicker$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onTimeSelect(Date date, View view) {
        TimePicker.pick$lambda$2(this.f$0, date, view);
    }
}
