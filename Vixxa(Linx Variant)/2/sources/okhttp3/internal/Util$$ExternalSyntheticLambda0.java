package okhttp3.internal;

import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Util$$ExternalSyntheticLambda0 implements EventListener.Factory {
    public final /* synthetic */ EventListener f$0;

    public /* synthetic */ Util$$ExternalSyntheticLambda0(EventListener eventListener) {
        this.f$0 = eventListener;
    }

    public final EventListener create(Call call) {
        return Util.m2066asFactory$lambda8(this.f$0, call);
    }
}
