package com.microtech.aidexx.ui.web;

import com.microtech.aidexx.views.webview.OnLoadingUrlListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class WebActivity$$ExternalSyntheticLambda1 implements OnLoadingUrlListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ WebActivity f$1;

    public /* synthetic */ WebActivity$$ExternalSyntheticLambda1(String str, WebActivity webActivity) {
        this.f$0 = str;
        this.f$1 = webActivity;
    }

    public final boolean onLoadingUrl(String str) {
        return WebActivity.onCreate$lambda$1(this.f$0, this.f$1, str);
    }
}
