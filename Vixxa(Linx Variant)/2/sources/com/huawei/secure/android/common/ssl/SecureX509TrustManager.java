package com.huawei.secure.android.common.ssl;

import android.content.Context;
import com.huawei.secure.android.common.ssl.util.c;
import com.huawei.secure.android.common.ssl.util.f;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class SecureX509TrustManager implements X509TrustManager {
    private static final String c = "SecureX509TrustManager";
    public static final String d = "hmsrootcas.bks";
    private static final String e = "";
    private static final String f = "X509";
    private static final String g = "bks";
    private static final String h = "AndroidCAStore";
    protected List<X509TrustManager> a;
    private X509Certificate[] b;

    public SecureX509TrustManager(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    private void a() {
        g.c(c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore instance = KeyStore.getInstance(h);
            instance.load((InputStream) null, (char[]) null);
            TrustManagerFactory instance2 = TrustManagerFactory.getInstance(f);
            instance2.init(instance);
            TrustManager[] trustManagers = instance2.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            g.b(c, "loadSystemCA: exception : " + e2.getMessage());
        }
        g.a(c, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g.c(c, "checkClientTrusted: ");
        for (X509TrustManager checkServerTrusted : this.a) {
            try {
                checkServerTrusted.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e2) {
                g.b(c, "checkServerTrusted CertificateException" + e2.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        setChain(x509CertificateArr);
        g.c(c, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        long currentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            String str2 = c;
            g.a(str2, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            g.a(str2, "IssuerDN :" + x509Certificate.getIssuerDN());
            g.a(str2, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.a.size();
        int i = 0;
        while (i < size) {
            try {
                String str3 = c;
                g.c(str3, "check server i : " + i);
                X509TrustManager x509TrustManager = this.a.get(i);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    g.c(str3, "client root ca size is : " + acceptedIssuers.length);
                    for (int i2 = 0; i2 < acceptedIssuers.length; i2++) {
                        g.a(c, "client root ca getIssuerDN :" + acceptedIssuers[i2].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                g.c(c, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e2) {
                String str4 = c;
                g.b(str4, "checkServerTrusted error :" + e2.getMessage() + " , time : " + i);
                if (i == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        g.b(str4, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e2;
                }
                i++;
            }
        }
        g.a(c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager acceptedIssuers : this.a) {
                arrayList.addAll(Arrays.asList(acceptedIssuers.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            g.b(c, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }

    public X509Certificate[] getChain() {
        return this.b;
    }

    public List<X509TrustManager> getX509TrustManagers() {
        return this.a;
    }

    public void setChain(X509Certificate[] x509CertificateArr) {
        this.b = x509CertificateArr;
    }

    public void setX509TrustManagers(List<X509TrustManager> list) {
        this.a = list;
    }

    public SecureX509TrustManager(Context context, boolean z) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.a = new ArrayList();
        if (context != null) {
            c.a(context);
            if (z) {
                a();
            }
            a(context);
            if (this.a.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003a, code lost:
        if (r3 == null) goto L_0x003c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r7) throws java.security.cert.CertificateException, java.security.NoSuchAlgorithmException, java.security.KeyStoreException, java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = c
            java.lang.String r1 = "loadBksCA"
            com.huawei.secure.android.common.ssl.util.g.c(r0, r1)
            long r1 = java.lang.System.currentTimeMillis()
            java.io.InputStream r3 = com.huawei.secure.android.common.ssl.util.BksUtil.getFilesBksIS(r7)
            if (r3 == 0) goto L_0x003a
            java.lang.String r4 = "get bks not from assets"
            com.huawei.secure.android.common.ssl.util.g.c(r0, r4)     // Catch:{ NoSuchAlgorithmException -> 0x0020, KeyStoreException -> 0x001e, CertificateException -> 0x001c, IOException -> 0x001a }
            r6.a((java.io.InputStream) r3)     // Catch:{ NoSuchAlgorithmException -> 0x0020, KeyStoreException -> 0x001e, CertificateException -> 0x001c, IOException -> 0x001a }
            goto L_0x003a
        L_0x001a:
            r0 = move-exception
            goto L_0x0021
        L_0x001c:
            r0 = move-exception
            goto L_0x0021
        L_0x001e:
            r0 = move-exception
            goto L_0x0021
        L_0x0020:
            r0 = move-exception
        L_0x0021:
            java.lang.String r3 = c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "loadBksCA: exception : "
            r4.<init>(r5)
            java.lang.String r0 = r0.getMessage()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.String r0 = r0.toString()
            com.huawei.secure.android.common.ssl.util.g.b(r3, r0)
            goto L_0x003c
        L_0x003a:
            if (r3 != 0) goto L_0x0050
        L_0x003c:
            java.lang.String r0 = c
            java.lang.String r3 = " get bks from assets "
            com.huawei.secure.android.common.ssl.util.g.c(r0, r3)
            android.content.res.AssetManager r7 = r7.getAssets()
            java.lang.String r0 = "hmsrootcas.bks"
            java.io.InputStream r7 = r7.open(r0)
            r6.a((java.io.InputStream) r7)
        L_0x0050:
            java.lang.String r7 = c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "loadBksCA: cost : "
            r0.<init>(r3)
            long r3 = java.lang.System.currentTimeMillis()
            long r3 = r3 - r1
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r1 = " ms"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.huawei.secure.android.common.ssl.util.g.a(r7, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.SecureX509TrustManager.a(android.content.Context):void");
    }

    private void a(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(f);
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, "".toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.a.add((X509TrustManager) trustManager);
                }
            }
        } finally {
            f.a(inputStream);
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str) throws IllegalArgumentException {
        this.a = new ArrayList();
        a(inputStream, str);
    }

    private void a(InputStream inputStream, String str) {
        if (inputStream == null || str == null) {
            throw new IllegalArgumentException("inputstream or trustPwd is null");
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(f);
            KeyStore instance2 = KeyStore.getInstance("bks");
            instance2.load(inputStream, str.toCharArray());
            instance.init(instance2);
            TrustManager[] trustManagers = instance.getTrustManagers();
            for (TrustManager trustManager : trustManagers) {
                if (trustManager instanceof X509TrustManager) {
                    this.a.add((X509TrustManager) trustManager);
                }
            }
        } catch (IOException | NegativeArraySizeException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            g.b(c, "loadInputStream: exception : " + e2.getMessage());
        } finally {
            f.a(inputStream);
        }
        g.a(c, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public SecureX509TrustManager(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public SecureX509TrustManager(String str, boolean z) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
            try {
                a(fileInputStream, "");
                f.a((InputStream) fileInputStream);
                if (z) {
                    a();
                }
            } catch (Throwable th) {
                th = th;
                f.a((InputStream) fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            f.a((InputStream) fileInputStream);
            throw th;
        }
    }

    public SecureX509TrustManager(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.a = new ArrayList();
        if (z) {
            a();
        }
        a(inputStream, str);
    }
}
