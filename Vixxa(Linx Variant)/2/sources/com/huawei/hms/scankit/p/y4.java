package com.huawei.hms.scankit.p;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MsModel */
public class y4 {
    private static byte[] a;
    private static byte[] b;
    private static byte[] c;

    public static byte[] a() {
        return b;
    }

    public static byte[] b() {
        return c;
    }

    public static void c(Context context, String str) {
        o4.c("MsModel", "load model...." + str);
        if (a == null) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                o4.c("MsModel", "inputStream" + inputStream);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                inputStream.close();
                a = bArr;
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadModel inputStream.close() IOException");
                }
            } catch (IOException unused2) {
                o4.b("MsModel", "loadModel IOException");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception unused3) {
                o4.b("MsModel", "loadModel Exception");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                        o4.b("MsModel", "loadModel inputStream.close() IOException");
                    }
                }
                throw th;
            }
        }
    }

    public static void a(Context context, String str) {
        o4.c("MsModel", "load angle model...." + str);
        if (b == null) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                o4.c("MsModel", "3inputStream" + inputStream);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                inputStream.close();
                b = bArr;
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadAngleModel inputStream.close() IOException");
                }
            } catch (IOException unused2) {
                o4.b("MsModel", "loadAngleModel IOException");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception unused3) {
                o4.b("MsModel", "loadAngleModel Exception");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                        o4.b("MsModel", "loadAngleModel inputStream.close() IOException");
                    }
                }
                throw th;
            }
        }
    }

    public static void b(Context context, String str) {
        o4.c("MsModel", "load corner model...." + str);
        if (c == null) {
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(str);
                o4.c("MsModel", "4inputStream" + inputStream);
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                inputStream.close();
                c = bArr;
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    o4.b("MsModel", "loadConerModel inputStream.close() IOException");
                }
            } catch (IOException unused2) {
                o4.b("MsModel", "loadConerModel IOException");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Exception unused3) {
                o4.b("MsModel", "loadConerModel Exception");
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused4) {
                        o4.b("MsModel", "loadConerModel inputStream.close() IOException");
                    }
                }
                throw th;
            }
        }
    }

    public static byte[] c() {
        return a;
    }
}
