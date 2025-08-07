package com.huawei.secure.android.common.ssl.util;

public final class CertificateUtil {
    private static final String a = "CertificateUtil";

    private CertificateUtil() {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.security.cert.X509Certificate} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.security.cert.X509Certificate getHwCbgRootCA(android.content.Context r5) {
        /*
            java.lang.String r0 = "loadBksCA: exception : "
            r1 = 0
            java.lang.String r2 = "bks"
            java.security.KeyStore r2 = java.security.KeyStore.getInstance(r2)     // Catch:{ KeyStoreException -> 0x003e, CertificateException -> 0x003c, IOException -> 0x003a, NoSuchAlgorithmException -> 0x0038, RuntimeException -> 0x0035, all -> 0x0033 }
            android.content.res.AssetManager r5 = r5.getAssets()     // Catch:{ KeyStoreException -> 0x003e, CertificateException -> 0x003c, IOException -> 0x003a, NoSuchAlgorithmException -> 0x0038, RuntimeException -> 0x0035, all -> 0x0033 }
            java.lang.String r3 = "hmsrootcas.bks"
            java.io.InputStream r5 = r5.open(r3)     // Catch:{ KeyStoreException -> 0x003e, CertificateException -> 0x003c, IOException -> 0x003a, NoSuchAlgorithmException -> 0x0038, RuntimeException -> 0x0035, all -> 0x0033 }
            r5.reset()     // Catch:{ KeyStoreException -> 0x0031, CertificateException -> 0x002f, IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, RuntimeException -> 0x0029 }
            java.lang.String r3 = ""
            char[] r3 = r3.toCharArray()     // Catch:{ KeyStoreException -> 0x0031, CertificateException -> 0x002f, IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, RuntimeException -> 0x0029 }
            r2.load(r5, r3)     // Catch:{ KeyStoreException -> 0x0031, CertificateException -> 0x002f, IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, RuntimeException -> 0x0029 }
            java.lang.String r3 = "052root"
            java.security.cert.Certificate r2 = r2.getCertificate(r3)     // Catch:{ KeyStoreException -> 0x0031, CertificateException -> 0x002f, IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, RuntimeException -> 0x0029 }
            java.security.cert.X509Certificate r2 = (java.security.cert.X509Certificate) r2     // Catch:{ KeyStoreException -> 0x0031, CertificateException -> 0x002f, IOException -> 0x002d, NoSuchAlgorithmException -> 0x002b, RuntimeException -> 0x0029 }
            r1 = r2
            goto L_0x0056
        L_0x0029:
            r2 = move-exception
            goto L_0x0040
        L_0x002b:
            r2 = move-exception
            goto L_0x0040
        L_0x002d:
            r2 = move-exception
            goto L_0x0040
        L_0x002f:
            r2 = move-exception
            goto L_0x0040
        L_0x0031:
            r2 = move-exception
            goto L_0x0040
        L_0x0033:
            r0 = move-exception
            goto L_0x005c
        L_0x0035:
            r2 = move-exception
        L_0x0036:
            r5 = r1
            goto L_0x0040
        L_0x0038:
            r2 = move-exception
            goto L_0x0036
        L_0x003a:
            r2 = move-exception
            goto L_0x0036
        L_0x003c:
            r2 = move-exception
            goto L_0x0036
        L_0x003e:
            r2 = move-exception
            goto L_0x0036
        L_0x0040:
            java.lang.String r3 = "CertificateUtil"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x005a }
            r4.<init>(r0)     // Catch:{ all -> 0x005a }
            java.lang.String r0 = r2.getMessage()     // Catch:{ all -> 0x005a }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x005a }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x005a }
            com.huawei.secure.android.common.ssl.util.g.b(r3, r0)     // Catch:{ all -> 0x005a }
        L_0x0056:
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) r5)
            return r1
        L_0x005a:
            r0 = move-exception
            r1 = r5
        L_0x005c:
            com.huawei.secure.android.common.ssl.util.f.a((java.io.InputStream) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.secure.android.common.ssl.util.CertificateUtil.getHwCbgRootCA(android.content.Context):java.security.cert.X509Certificate");
    }
}
