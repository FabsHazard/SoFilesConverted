package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.hostname.StrictHostnameVerifier;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class WebViewSSLCheckThread extends Thread {
    /* access modifiers changed from: private */
    public static final String i = "WebViewSSLCheckThread";
    private SSLSocketFactory a;
    private HostnameVerifier b;
    private org.apache.http.conn.ssl.SSLSocketFactory c;
    private X509HostnameVerifier d;
    private SslErrorHandler e;
    private String f;
    private Callback g;
    private Context h;

    public interface Callback {
        void onCancel(Context context, String str);

        void onProceed(Context context, String str);
    }

    static class a implements okhttp3.Callback {
        final /* synthetic */ Callback a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ SslErrorHandler d;

        a(Callback callback, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.a = callback;
            this.b = context;
            this.c = str;
            this.d = sslErrorHandler;
        }

        public void onFailure(Call call, IOException iOException) {
            g.b(WebViewSSLCheckThread.i, "onFailure , IO Exception : " + iOException.getMessage());
            Callback callback = this.a;
            if (callback != null) {
                callback.onCancel(this.b, this.c);
            } else {
                this.d.cancel();
            }
        }

        public void onResponse(Call call, Response response) throws IOException {
            g.b(WebViewSSLCheckThread.i, "onResponse . proceed");
            Callback callback = this.a;
            if (callback != null) {
                callback.onProceed(this.b, this.c);
            } else {
                this.d.proceed();
            }
        }
    }

    public WebViewSSLCheckThread() {
    }

    private void b() {
        String str = i;
        g.c(str, "callbackCancel: ");
        Callback callback = this.g;
        if (callback != null) {
            callback.onCancel(this.h, this.f);
        } else if (this.e != null) {
            g.c(str, "callbackCancel 2: ");
            this.e.cancel();
        }
    }

    private void c() {
        g.c(i, "callbackProceed: ");
        Callback callback = this.g;
        if (callback != null) {
            callback.onProceed(this.h, this.f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context) {
        checkServerCertificateWithOK(sslErrorHandler, str, context, (Callback) null);
    }

    public X509HostnameVerifier getApacheHostnameVerifier() {
        return this.d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory getApacheSSLSocketFactory() {
        return this.c;
    }

    public Callback getCallback() {
        return this.g;
    }

    public Context getContext() {
        return this.h;
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.b;
    }

    public SslErrorHandler getSslErrorHandler() {
        return this.e;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.a;
    }

    public String getUrl() {
        return this.f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r9 = this;
            java.lang.String r0 = "status code is : "
            java.lang.String r1 = "run: exception : "
            java.lang.String r2 = "exception : "
            super.run()
            org.apache.http.conn.ssl.SSLSocketFactory r3 = r9.c
            r4 = 0
            if (r3 == 0) goto L_0x00d1
            org.apache.http.conn.ssl.X509HostnameVerifier r3 = r9.d
            if (r3 == 0) goto L_0x00d1
            android.webkit.SslErrorHandler r2 = r9.e
            if (r2 == 0) goto L_0x00c6
            java.lang.String r2 = r9.f
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0020
            goto L_0x00c6
        L_0x0020:
            org.apache.http.conn.ssl.SSLSocketFactory r2 = r9.c     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.ssl.X509HostnameVerifier r3 = r9.d     // Catch:{ Exception -> 0x00a4 }
            r2.setHostnameVerifier(r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.ssl.SSLSocketFactory r2 = r9.c     // Catch:{ Exception -> 0x00a4 }
            boolean r3 = r2 instanceof com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory     // Catch:{ Exception -> 0x00a4 }
            if (r3 == 0) goto L_0x0034
            com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory r2 = (com.huawei.secure.android.common.ssl.SecureApacheSSLSocketFactory) r2     // Catch:{ Exception -> 0x00a4 }
            android.content.Context r3 = r9.h     // Catch:{ Exception -> 0x00a4 }
            r2.setContext(r3)     // Catch:{ Exception -> 0x00a4 }
        L_0x0034:
            org.apache.http.params.BasicHttpParams r2 = new org.apache.http.params.BasicHttpParams     // Catch:{ Exception -> 0x00a4 }
            r2.<init>()     // Catch:{ Exception -> 0x00a4 }
            r3 = 30000(0x7530, float:4.2039E-41)
            org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r2, r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.params.HttpConnectionParams.setSoTimeout(r2, r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.scheme.SchemeRegistry r3 = new org.apache.http.conn.scheme.SchemeRegistry     // Catch:{ Exception -> 0x00a4 }
            r3.<init>()     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.scheme.Scheme r5 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r6 = "https"
            org.apache.http.conn.ssl.SSLSocketFactory r7 = r9.c     // Catch:{ Exception -> 0x00a4 }
            r8 = 443(0x1bb, float:6.21E-43)
            r5.<init>(r6, r7, r8)     // Catch:{ Exception -> 0x00a4 }
            r3.register(r5)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.conn.scheme.Scheme r5 = new org.apache.http.conn.scheme.Scheme     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r6 = "http"
            org.apache.http.conn.scheme.PlainSocketFactory r7 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory()     // Catch:{ Exception -> 0x00a4 }
            r8 = 80
            r5.<init>(r6, r7, r8)     // Catch:{ Exception -> 0x00a4 }
            r3.register(r5)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager r5 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager     // Catch:{ Exception -> 0x00a4 }
            r5.<init>(r2, r3)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.impl.client.DefaultHttpClient r3 = new org.apache.http.impl.client.DefaultHttpClient     // Catch:{ Exception -> 0x00a4 }
            r3.<init>(r5, r2)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.client.methods.HttpGet r2 = new org.apache.http.client.methods.HttpGet     // Catch:{ Exception -> 0x00a4 }
            r2.<init>()     // Catch:{ Exception -> 0x00a4 }
            java.net.URI r5 = new java.net.URI     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r6 = r9.f     // Catch:{ Exception -> 0x00a4 }
            r5.<init>(r6)     // Catch:{ Exception -> 0x00a4 }
            r2.setURI(r5)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.HttpResponse r2 = r3.execute(r2)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r3 = i     // Catch:{ Exception -> 0x00a4 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            r5.<init>(r0)     // Catch:{ Exception -> 0x00a4 }
            org.apache.http.StatusLine r0 = r2.getStatusLine()     // Catch:{ Exception -> 0x00a4 }
            int r0 = r0.getStatusCode()     // Catch:{ Exception -> 0x00a4 }
            java.lang.StringBuilder r0 = r5.append(r0)     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00a4 }
            com.huawei.secure.android.common.ssl.util.g.c(r3, r0)     // Catch:{ Exception -> 0x00a4 }
            com.huawei.secure.android.common.ssl.util.f.a((java.io.Reader) r4)
            r9.c()
            return
        L_0x00a2:
            r0 = move-exception
            goto L_0x00c2
        L_0x00a4:
            r0 = move-exception
            java.lang.String r2 = i     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a2 }
            r3.<init>(r1)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00a2 }
            java.lang.StringBuilder r0 = r3.append(r0)     // Catch:{ all -> 0x00a2 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.g.b(r2, r0)     // Catch:{ all -> 0x00a2 }
            r9.b()     // Catch:{ all -> 0x00a2 }
            com.huawei.secure.android.common.ssl.util.f.a((java.io.Reader) r4)
            return
        L_0x00c2:
            com.huawei.secure.android.common.ssl.util.f.a((java.io.Reader) r4)
            throw r0
        L_0x00c6:
            java.lang.String r0 = i
            java.lang.String r1 = "sslErrorHandler or url is null"
            com.huawei.secure.android.common.ssl.util.g.b(r0, r1)
            r9.b()
            return
        L_0x00d1:
            javax.net.ssl.SSLSocketFactory r0 = r9.a
            if (r0 == 0) goto L_0x013f
            javax.net.ssl.HostnameVerifier r0 = r9.b
            if (r0 == 0) goto L_0x013f
            java.net.URL r0 = new java.net.URL     // Catch:{ Exception -> 0x0119 }
            java.lang.String r1 = r9.f     // Catch:{ Exception -> 0x0119 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0119 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ Exception -> 0x0119 }
            boolean r1 = r0 instanceof javax.net.ssl.HttpsURLConnection     // Catch:{ Exception -> 0x0119 }
            if (r1 == 0) goto L_0x010e
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch:{ Exception -> 0x0119 }
            javax.net.ssl.SSLSocketFactory r1 = r9.a     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r0.setSSLSocketFactory(r1)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            javax.net.ssl.HostnameVerifier r1 = r9.b     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r0.setHostnameVerifier(r1)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setConnectTimeout(r1)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r0.setReadTimeout(r1)     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r0.connect()     // Catch:{ Exception -> 0x010b, all -> 0x0108 }
            r4 = r0
            goto L_0x010e
        L_0x0108:
            r1 = move-exception
            r4 = r0
            goto L_0x0139
        L_0x010b:
            r1 = move-exception
            r4 = r0
            goto L_0x011a
        L_0x010e:
            if (r4 == 0) goto L_0x0113
            r4.disconnect()
        L_0x0113:
            r9.c()
            return
        L_0x0117:
            r1 = move-exception
            goto L_0x0139
        L_0x0119:
            r1 = move-exception
        L_0x011a:
            java.lang.String r0 = i     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0117 }
            r3.<init>(r2)     // Catch:{ all -> 0x0117 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0117 }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ all -> 0x0117 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0117 }
            com.huawei.secure.android.common.ssl.util.g.b(r0, r1)     // Catch:{ all -> 0x0117 }
            r9.b()     // Catch:{ all -> 0x0117 }
            if (r4 == 0) goto L_0x0138
            r4.disconnect()
        L_0x0138:
            return
        L_0x0139:
            if (r4 == 0) goto L_0x013e
            r4.disconnect()
        L_0x013e:
            throw r1
        L_0x013f:
            r9.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.run():void");
    }

    public void setApacheHostnameVerifier(X509HostnameVerifier x509HostnameVerifier) {
        this.d = x509HostnameVerifier;
    }

    public void setApacheSSLSocketFactory(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.c = sSLSocketFactory;
    }

    public void setCallback(Callback callback) {
        this.g = callback;
    }

    public void setContext(Context context) {
        this.h = context;
    }

    public void setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.b = hostnameVerifier;
    }

    public void setSslErrorHandler(SslErrorHandler sslErrorHandler) {
        this.e = sslErrorHandler;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    public void setUrl(String str) {
        this.f = str;
    }

    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setContext(context);
        setSslSocketFactory(new SecureSSLSocketFactoryNew((X509TrustManager) new c(context)));
        setHostnameVerifier(new StrictHostnameVerifier());
        try {
            setApacheSSLSocketFactory(new SecureApacheSSLSocketFactory((KeyStore) null, (X509TrustManager) new c(context)));
        } catch (UnrecoverableKeyException e2) {
            g.b(i, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e2.getMessage());
        }
        setApacheHostnameVerifier(SecureApacheSSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    }

    public static void checkServerCertificateWithOK(SslErrorHandler sslErrorHandler, String str, Context context, Callback callback) {
        if (sslErrorHandler == null || TextUtils.isEmpty(str) || context == null) {
            g.b(i, "checkServerCertificateWithOK: handler or url or context is null");
            return;
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        try {
            SecureSSLSocketFactoryNew secureSSLSocketFactoryNew = new SecureSSLSocketFactoryNew((X509TrustManager) new c(context));
            secureSSLSocketFactoryNew.setContext(context);
            builder.sslSocketFactory(secureSSLSocketFactoryNew, new c(context));
            builder.hostnameVerifier(new StrictHostnameVerifier());
            builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new a(callback, context, str, sslErrorHandler));
        } catch (Exception e2) {
            g.b(i, "checkServerCertificateWithOK: exception : " + e2.getMessage());
            sslErrorHandler.cancel();
        }
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setSslSocketFactory(sSLSocketFactory);
        setHostnameVerifier(hostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        setSslErrorHandler(sslErrorHandler);
        setUrl(str);
        setApacheSSLSocketFactory(sSLSocketFactory);
        setApacheHostnameVerifier(x509HostnameVerifier);
    }

    @Deprecated
    public WebViewSSLCheckThread(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, Callback callback, Context context) {
        this.e = sslErrorHandler;
        this.f = str;
        this.c = sSLSocketFactory;
        this.d = x509HostnameVerifier;
        this.g = callback;
        this.h = context;
    }
}
