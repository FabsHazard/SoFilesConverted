package com.microtech.aidexx.common.net;

import com.huawei.hms.feature.dynamic.f.e;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class HttpsUtil {

    public static class SSLParams {
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;
    }

    public static SSLParams getSslSocketFactory() {
        return getSslSocketFactory((InputStream[]) null, (InputStream) null, (String) null);
    }

    public static SSLParams getSslSocketFactory(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        X509TrustManager x509TrustManager;
        SSLParams sSLParams = new SSLParams();
        try {
            TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            SSLContext instance = SSLContext.getInstance("TLS");
            if (prepareTrustManager != null) {
                x509TrustManager = new MyTrustManager(chooseTrustManager(prepareTrustManager));
            } else {
                x509TrustManager = new UnSafeTrustManager();
            }
            instance.init(prepareKeyManager, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            sSLParams.sSLSocketFactory = instance.getSocketFactory();
            sSLParams.trustManager = x509TrustManager;
            return sSLParams;
        } catch (KeyManagementException | KeyStoreException | NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    private static class UnSafeTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        private UnSafeTrustManager() {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory instance = CertificateFactory.getInstance(e.b);
                KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
                instance2.load((KeyStore.LoadStoreParameter) null);
                int length = inputStreamArr.length;
                int i = 0;
                int i2 = 0;
                while (i < length) {
                    InputStream inputStream = inputStreamArr[i];
                    int i3 = i2 + 1;
                    instance2.setCertificateEntry(Integer.toString(i2), instance.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    i++;
                    i2 = i3;
                }
                TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                instance3.init(instance2);
                return instance3.getTrustManagers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
        if (!(inputStream == null || str == null)) {
            try {
                KeyStore instance = KeyStore.getInstance("BKS");
                instance.load(inputStream, str.toCharArray());
                KeyManagerFactory instance2 = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                instance2.init(instance, str.toCharArray());
                return instance2.getKeyManagers();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (X509TrustManager x509TrustManager : trustManagerArr) {
            if (x509TrustManager instanceof X509TrustManager) {
                return x509TrustManager;
            }
        }
        return null;
    }

    private static class MyTrustManager implements X509TrustManager {
        private final X509TrustManager defaultTrustManager;
        private final X509TrustManager localTrustManager;

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        public MyTrustManager(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            KeyStore keyStore = null;
            instance.init((KeyStore) null);
            this.defaultTrustManager = HttpsUtil.chooseTrustManager(instance.getTrustManagers());
            this.localTrustManager = x509TrustManager;
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.localTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
