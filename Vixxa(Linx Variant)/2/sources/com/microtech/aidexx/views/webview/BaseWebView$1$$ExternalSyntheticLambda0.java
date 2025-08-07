package com.microtech.aidexx.views.webview;

import android.content.DialogInterface;
import android.webkit.SslErrorHandler;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BaseWebView$1$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ SslErrorHandler f$0;

    public /* synthetic */ BaseWebView$1$$ExternalSyntheticLambda0(SslErrorHandler sslErrorHandler) {
        this.f$0 = sslErrorHandler;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f$0.proceed();
    }
}
