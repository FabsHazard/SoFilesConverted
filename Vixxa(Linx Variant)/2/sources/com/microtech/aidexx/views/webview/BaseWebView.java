package com.microtech.aidexx.views.webview;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.web.WebActivity;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;

public class BaseWebView extends LinearLayout {
    private static final int FILE_CHOOSER_RESULT_CODE = 10000;
    private static final String TAG = "BaseWebView";
    /* access modifiers changed from: private */
    public boolean isSet = true;
    /* access modifiers changed from: private */
    public WebActivity mContext;
    public FrameLayout mFullscreenContainer;
    ProgressBar mProgressBar;
    /* access modifiers changed from: private */
    public TextView mToolbarTitle;
    public WebView mWebView;
    /* access modifiers changed from: private */
    public OnLoadingUrlListener onLoadingUrlListener;
    OnPageListener onPageListener;
    public OnReceivedError onReceivedError;
    int progress = 0;
    int timeProgress = 0;
    Timer timer;
    public ValueCallback<Uri[]> uploadMessageAboveL;

    public interface OnPageListener {
        void onPageFinished(WebView webView, String str);

        void onPageStarted(WebView webView, String str);
    }

    public interface OnReceivedError {
        void onReceivedError();
    }

    public FrameLayout getmFullscreenContainer() {
        return this.mFullscreenContainer;
    }

    public void setFullscreenContainer(FrameLayout frameLayout) {
        this.mFullscreenContainer = frameLayout;
        this.mWebView.setWebChromeClient(new VideoEnabledWebChromeClient(frameLayout));
    }

    public void setSet(boolean z) {
        this.isSet = z;
    }

    public void setmToolbarTitle(TextView textView) {
        this.mToolbarTitle = textView;
    }

    public BaseWebView(Context context) {
        super(context);
        init();
    }

    public void setOnLoadingUrlListener(OnLoadingUrlListener onLoadingUrlListener2) {
        this.onLoadingUrlListener = onLoadingUrlListener2;
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public BaseWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        WebActivity webActivity = (WebActivity) getContext();
        this.mContext = webActivity;
        View.inflate(webActivity, R.layout.view_web_progress, this);
        this.mWebView = (WebView) findViewById(R.id.web_view);
        this.mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        WebSettings settings = this.mWebView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setSavePassword(false);
        settings.setCacheMode(2);
        settings.setUserAgentString(settings.getUserAgentString() + " X-CGMS/1.7.1");
        if (this.mFullscreenContainer != null) {
            this.mWebView.setWebChromeClient(new VideoEnabledWebChromeClient(this.mFullscreenContainer));
        } else {
            this.mWebView.setWebChromeClient(new MyWebChromeClient());
        }
        this.mWebView.addJavascriptInterface(new MJavascriptInterface(this.mContext), "imagelistener");
        this.mWebView.setWebViewClient(new WebViewClient() {
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                super.onPageStarted(webView, str, bitmap);
                if (BaseWebView.this.onPageListener != null) {
                    BaseWebView.this.onPageListener.onPageStarted(webView, str);
                }
            }

            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (BaseWebView.this.onLoadingUrlListener != null) {
                    return BaseWebView.this.onLoadingUrlListener.onLoadingUrl(str);
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            public void onPageFinished(WebView webView, String str) {
                if (BaseWebView.this.onPageListener != null) {
                    BaseWebView.this.onPageListener.onPageFinished(webView, str);
                }
                super.onPageFinished(webView, str);
            }

            public void onReceivedError(WebView webView, int i, String str, String str2) {
                super.onReceivedError(webView, i, str, str2);
                if (BaseWebView.this.onReceivedError != null) {
                    BaseWebView.this.onReceivedError.onReceivedError();
                }
            }

            public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                String str;
                AlertDialog.Builder builder = new AlertDialog.Builder(BaseWebView.this.mContext);
                int primaryError = sslError.getPrimaryError();
                if (primaryError == 0) {
                    str = "The certificate is not yet valid.";
                } else if (primaryError == 1) {
                    str = "The certificate has expired.";
                } else if (primaryError == 2) {
                    str = "The certificate Hostname mismatch.";
                } else if (primaryError != 3) {
                    str = "SSL Certificate error.";
                } else {
                    str = "The certificate authority is not trusted.";
                }
                String concat = str.concat(" Do you want to continue anyway?");
                builder.setTitle((CharSequence) "SSL Certificate Error");
                builder.setMessage((CharSequence) concat);
                builder.setPositiveButton((CharSequence) "continue", (DialogInterface.OnClickListener) new BaseWebView$1$$ExternalSyntheticLambda0(sslErrorHandler));
                builder.setNegativeButton((CharSequence) "cancel", (DialogInterface.OnClickListener) new BaseWebView$1$$ExternalSyntheticLambda1(sslErrorHandler));
                builder.create().show();
            }
        });
    }

    public void setOnReceivedError(OnReceivedError onReceivedError2) {
        this.onReceivedError = onReceivedError2;
    }

    private boolean isURl(String str) {
        return Pattern.compile("(https?|ftp|file)://[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]").matcher(str).matches();
    }

    /* access modifiers changed from: private */
    public void openImageChooserActivity() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        this.mContext.startActivityForResult(Intent.createChooser(intent, "Image Chooser"), FILE_CHOOSER_RESULT_CODE);
    }

    /* access modifiers changed from: private */
    public void openFileChooserActivity() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("file/*");
        this.mContext.startActivityForResult(Intent.createChooser(intent, "File Chooser"), FILE_CHOOSER_RESULT_CODE);
    }

    public void stopTimer() {
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }

    public void loading() {
        this.mProgressBar.setVisibility(0);
        this.timeProgress = 0;
        stopTimer();
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.schedule(new TimerTask() {
            public void run() {
                BaseWebView.this.post(new Runnable() {
                    public void run() {
                        if (BaseWebView.this.timeProgress >= 80) {
                            BaseWebView.this.stopTimer();
                            return;
                        }
                        BaseWebView.this.timeProgress += 5;
                        BaseWebView.this.setProgressBar();
                    }
                });
            }
        }, 0, 50);
    }

    /* access modifiers changed from: private */
    public void setProgressBar() {
        int i = this.timeProgress;
        int i2 = this.progress;
        if (i2 >= i) {
            stopTimer();
            i = i2;
        }
        this.mProgressBar.setProgress(i);
    }

    private void onTel(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse(str));
        this.mContext.startActivity(intent);
    }

    public void loadData(String str, String str2, String str3) {
        new HashMap().put("os", "android");
        this.mWebView.loadData(str, str2, str3);
    }

    public void loadUrl(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("os", "android");
        this.mWebView.loadUrl(str, hashMap);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mWebView.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public void setOnPageListener(OnPageListener onPageListener2) {
        this.onPageListener = onPageListener2;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopTimer();
    }

    static class MJavascriptInterface {
        private final Context context;
        private String[] imageUrls;
        private String[] img;

        @JavascriptInterface
        public void openImage(String str) {
        }

        public MJavascriptInterface(Context context2) {
            this.context = context2;
        }

        @JavascriptInterface
        public void getArray(String[] strArr) {
            this.imageUrls = strArr;
        }
    }

    private class MyWebChromeClient extends WebChromeClient {
        private MyWebChromeClient() {
        }

        public void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            if (BaseWebView.this.mToolbarTitle != null && BaseWebView.this.isSet) {
                BaseWebView.this.mToolbarTitle.setText(str);
            }
        }

        public void onProgressChanged(WebView webView, int i) {
            BaseWebView.this.progress = i;
            BaseWebView.this.setProgressBar();
            if (i == 100) {
                BaseWebView.this.mProgressBar.setVisibility(4);
                AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    public void onAnimationRepeat(Animation animation) {
                    }

                    public void onAnimationStart(Animation animation) {
                    }

                    public void onAnimationEnd(Animation animation) {
                        BaseWebView.this.mProgressBar.setVisibility(4);
                    }
                });
                BaseWebView.this.mProgressBar.startAnimation(alphaAnimation);
                return;
            }
            BaseWebView.this.mProgressBar.setVisibility(0);
        }

        public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            BaseWebView.this.uploadMessageAboveL = valueCallback;
            if (fileChooserParams != null && fileChooserParams.getAcceptTypes().length > 0) {
                if (1 != fileChooserParams.getAcceptTypes().length || !"image/*".equals(fileChooserParams.getAcceptTypes()[0])) {
                    BaseWebView.this.openFileChooserActivity();
                } else {
                    BaseWebView.this.openImageChooserActivity();
                }
            }
            return true;
        }
    }

    public class VideoEnabledWebChromeClient extends MyWebChromeClient {
        private View mCustomView;
        private WebChromeClient.CustomViewCallback mCustomViewCallback;
        private final FrameLayout mFullscreenContainer;

        public /* bridge */ /* synthetic */ void onProgressChanged(WebView webView, int i) {
            super.onProgressChanged(webView, i);
        }

        public /* bridge */ /* synthetic */ void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
        }

        public /* bridge */ /* synthetic */ boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
            return super.onShowFileChooser(webView, valueCallback, fileChooserParams);
        }

        public VideoEnabledWebChromeClient(FrameLayout frameLayout) {
            super();
            this.mFullscreenContainer = frameLayout;
        }

        public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
            if (BaseWebView.this.mContext != null) {
                BaseWebView.this.mContext.setRequestedOrientation(0);
                BaseWebView.this.mContext.fitWebOrientation(0);
            }
            BaseWebView.this.mWebView.setVisibility(8);
            if (this.mCustomView != null) {
                customViewCallback.onCustomViewHidden();
                return;
            }
            this.mFullscreenContainer.addView(view);
            this.mCustomView = view;
            this.mCustomViewCallback = customViewCallback;
            this.mFullscreenContainer.setVisibility(0);
        }

        public void onHideCustomView() {
            if (this.mCustomView != null) {
                if (BaseWebView.this.mContext != null) {
                    BaseWebView.this.mContext.setRequestedOrientation(1);
                    BaseWebView.this.mContext.fitWebOrientation(1);
                }
                this.mCustomView.setVisibility(8);
                this.mFullscreenContainer.removeView(this.mCustomView);
                this.mCustomView = null;
                this.mFullscreenContainer.setVisibility(8);
                this.mCustomViewCallback.onCustomViewHidden();
                BaseWebView.this.mWebView.setVisibility(0);
            }
        }
    }
}
