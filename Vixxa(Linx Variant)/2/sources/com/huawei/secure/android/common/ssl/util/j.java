package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import java.security.cert.X509Certificate;

public class j {
    private static final String b = "X509CertificateUtil";
    public static final String c = "hmsrootcas.bks";
    public static final String d = "";
    public static final String e = "bks";
    public static final String f = "052root";
    private static final String g = "hmsincas.bks";
    private static final String h = "huawei cbg application integration ca";
    private Context a;

    public j(Context context) {
        this.a = context;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.security.cert.X509Certificate} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.security.cert.X509Certificate a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            java.lang.String r0 = "loadBksCA: exception : "
            r1 = 0
            java.lang.String r2 = "bks"
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r2)     // Catch:{ KeyStoreException -> 0x0038, CertificateException -> 0x0036, IOException -> 0x0034, NoSuchAlgorithmException -> 0x0031, all -> 0x002f }
            android.content.Context r3 = r4.a     // Catch:{ KeyStoreException -> 0x0038, CertificateException -> 0x0036, IOException -> 0x0034, NoSuchAlgorithmException -> 0x0031, all -> 0x002f }
            android.content.res.AssetManager r3 = r3.getAssets()     // Catch:{ KeyStoreException -> 0x0038, CertificateException -> 0x0036, IOException -> 0x0034, NoSuchAlgorithmException -> 0x0031, all -> 0x002f }
            java.io.InputStream r5 = r3.open(r5)     // Catch:{ KeyStoreException -> 0x0038, CertificateException -> 0x0036, IOException -> 0x0034, NoSuchAlgorithmException -> 0x0031, all -> 0x002f }
            r5.reset()     // Catch:{ KeyStoreException -> 0x002d, CertificateException -> 0x002b, IOException -> 0x0029, NoSuchAlgorithmException -> 0x0027 }
            java.lang.String r3 = ""
            char[] r3 = r3.toCharArray()     // Catch:{ KeyStoreException -> 0x002d, CertificateException -> 0x002b, IOException -> 0x0029, NoSuchAlgorithmException -> 0x0027 }
            r2.load(r5, r3)     // Catch:{ KeyStoreException -> 0x002d, CertificateException -> 0x002b, IOException -> 0x0029, NoSuchAlgorithmException -> 0x0027 }
            java.security.cert.Certificate r6 = r2.getCertificate(r6)     // Catch:{ KeyStoreException -> 0x002d, CertificateException -> 0x002b, IOException -> 0x0029, NoSuchAlgorithmException -> 0x0027 }
            java.security.cert.X509Certificate r6 = (java.security.cert.X509Certificate) r6     // Catch:{ KeyStoreException -> 0x002d, CertificateException -> 0x002b, IOException -> 0x0029, NoSuchAlgorithmException -> 0x0027 }
            r1 = r6
            goto L_0x0050
        L_0x0027:
            r6 = move-exception
            goto L_0x003a
        L_0x0029:
            r6 = move-exception
            goto L_0x003a
        L_0x002b:
            r6 = move-exception
            goto L_0x003a
        L_0x002d:
            r6 = move-exception
            goto L_0x003a
        L_0x002f:
            r6 = move-exception
            goto L_0x0056
        L_0x0031:
            r6 = move-exception
        L_0x0032:
            r5 = r1
            goto L_0x003a
        L_0x0034:
            r6 = move-exception
            goto L_0x0032
        L_0x0036:
            r6 = move-exception
            goto L_0x0032
        L_0x0038:
            r6 = move-exception
            goto L_0x0032
        L_0x003a:
            java.lang.String r2 = "X509CertificateUtil"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0054 }
            r3.<init>(r0)     // Catch:{ all -> 0x0054 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0054 }
            java.lang.StringBuilder r6 = r3.append(r6)     // Catch:{ all -> 0x0054 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0054 }
            com.huawei.secure.android.common.ssl.util.g.b(r2, r6)     // Catch:{ all -> 0x0054 }
        L_0x0050:
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) r5)
            return r1
        L_0x0054:
            r6 = move-exception
            r1 = r5
        L_0x0056:
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) r1)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.util.j.a(java.lang.String, java.lang.String):java.security.cert.X509Certificate");
    }

    public X509Certificate b() {
        return a("hmsrootcas.bks", f);
    }

    public X509Certificate a() {
        return a(g, h);
    }
}
