package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.al;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    public static class a {
        public long a;
        public String b;
        public long c;
        public Map<String, String[]> d;
    }

    /* compiled from: BUGLY */
    public interface b {
        boolean a(long j);

        boolean a(long j, long j2, String str);

        boolean a(String str, int i, String str2, String str3);
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (!(str == null || str2 == null)) {
            final a aVar = new a();
            readTraceFile(str2, new b() {
                public final boolean a(String str, int i, String str2, String str3) {
                    al.c("new thread %s", str);
                    if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
                        if (aVar.d == null) {
                            aVar.d = new HashMap();
                        }
                        aVar.d.put(str, new String[]{str2, str3, String.valueOf(i)});
                    }
                    return true;
                }

                public final boolean a(long j, long j2, String str) {
                    al.c("new process %s", str);
                    if (!str.equals(str)) {
                        return true;
                    }
                    aVar.a = j;
                    aVar.b = str;
                    aVar.c = j2;
                    if (!z) {
                        return false;
                    }
                    return true;
                }

                public final boolean a(long j) {
                    al.c("process end %d", Long.valueOf(j));
                    return aVar.a <= 0 || aVar.c <= 0 || aVar.b == null;
                }
            });
            if (aVar.a <= 0 || aVar.c <= 0 || aVar.b == null) {
                return null;
            }
            return aVar;
        }
        return null;
    }

    public static a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() {
            public final boolean a(String str, int i, String str2, String str3) {
                al.c("new thread %s", str);
                if (aVar.d == null) {
                    aVar.d = new HashMap();
                }
                aVar.d.put(str, new String[]{str2, str3, String.valueOf(i)});
                return true;
            }

            public final boolean a(long j, long j2, String str) {
                al.c("new process %s", str);
                aVar.a = j;
                aVar.b = str;
                aVar.c = j2;
                return z;
            }

            public final boolean a(long j) {
                al.c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (aVar.a > 0 && aVar.c > 0 && aVar.b != null) {
            return aVar;
        }
        al.e("first dump error %s", aVar.a + " " + aVar.c + " " + aVar.b);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x018a A[Catch:{ all -> 0x0180 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01b1 A[SYNTHETIC, Splitter:B:69:0x01b1] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01c3 A[SYNTHETIC, Splitter:B:77:0x01c3] */
    /* JADX WARNING: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void readTraceFile(java.lang.String r17, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b r18) {
        /*
            r0 = r17
            r6 = r18
            java.lang.String r7 = "\\s"
            if (r0 == 0) goto L_0x01d3
            if (r6 != 0) goto L_0x000c
            goto L_0x01d3
        L_0x000c:
            java.io.File r1 = new java.io.File
            r1.<init>(r0)
            boolean r0 = r1.exists()
            if (r0 != 0) goto L_0x0018
            return
        L_0x0018:
            r1.lastModified()
            r1.length()
            r2 = 0
            java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0183 }
            java.io.FileReader r0 = new java.io.FileReader     // Catch:{ Exception -> 0x0183 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0183 }
            r8.<init>(r0)     // Catch:{ Exception -> 0x0183 }
            java.lang.String r0 = "-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}"
            java.util.regex.Pattern r9 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = "-{5}\\send\\s\\d+\\s-{5}"
            java.util.regex.Pattern r10 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = "Cmd\\sline:\\s(\\S+)"
            java.util.regex.Pattern r11 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = "\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*"
            java.util.regex.Pattern r12 = java.util.regex.Pattern.compile(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.text.SimpleDateFormat r13 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r1 = java.util.Locale.US     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r13.<init>(r0, r1)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
        L_0x004a:
            r14 = 1
            java.util.regex.Pattern[] r0 = new java.util.regex.Pattern[r14]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r15 = 0
            r0[r15] = r9     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.Object[] r0 = a(r8, r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            if (r0 == 0) goto L_0x0169
            java.util.regex.Pattern[] r1 = new java.util.regex.Pattern[r14]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r1[r15] = r11     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.Object[] r1 = a(r8, r1)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            if (r1 != 0) goto L_0x0077
            java.lang.String r0 = "Failed to find process name."
            java.lang.Object[] r1 = new java.lang.Object[r15]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            com.tencent.bugly.proguard.al.d(r0, r1)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r8.close()     // Catch:{ IOException -> 0x006b }
            return
        L_0x006b:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x0076
            r1.printStackTrace()
        L_0x0076:
            return
        L_0x0077:
            r0 = r0[r14]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String[] r0 = r0.split(r7)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r5 = 2
            r2 = r0[r5]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            long r2 = java.lang.Long.parseLong(r2)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r4.<init>()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r16 = 4
            r5 = r0[r16]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r5 = " "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r5 = 5
            r0 = r0[r5]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.util.Date r0 = r13.parse(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            long r4 = r0.getTime()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0 = r1[r14]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.util.regex.Matcher r0 = r11.matcher(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0.find()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0.group(r14)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r16 = r0.group(r14)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0 = r18
            r1 = r2
            r3 = r4
            r14 = 2
            r5 = r16
            boolean r0 = r0.a(r1, r3, r5)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            if (r0 != 0) goto L_0x00df
            r8.close()     // Catch:{ IOException -> 0x00d3 }
            return
        L_0x00d3:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x00de
            r1.printStackTrace()
        L_0x00de:
            return
        L_0x00df:
            java.util.regex.Pattern[] r0 = new java.util.regex.Pattern[r14]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0[r15] = r12     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r1 = 1
            r0[r1] = r10     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.Object[] r0 = a(r8, r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            if (r0 == 0) goto L_0x004a
            r2 = r0[r15]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            if (r2 != r12) goto L_0x0143
            r0 = r0[r1]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r1 = "\".+\""
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.util.regex.Matcher r1 = r1.matcher(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r1.find()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r1 = r1.group()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            int r2 = r1.length()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r3 = 1
            int r2 = r2 - r3
            java.lang.String r1 = r1.substring(r3, r2)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r2 = "NATIVE"
            r0.contains(r2)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r2 = "tid=\\d+"
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.util.regex.Matcher r0 = r2.matcher(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0.find()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = r0.group()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r2 = "="
            int r2 = r0.indexOf(r2)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r0 = r0.substring(r2)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r2 = a(r8)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r3 = b(r8)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r6.a(r1, r0, r2, r3)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            goto L_0x00df
        L_0x0143:
            r0 = r0[r1]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            java.lang.String[] r0 = r0.split(r7)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            r0 = r0[r14]     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            long r0 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            boolean r0 = r6.a(r0)     // Catch:{ Exception -> 0x017d, all -> 0x0179 }
            if (r0 != 0) goto L_0x004a
            r8.close()     // Catch:{ IOException -> 0x015d }
            return
        L_0x015d:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x0168
            r1.printStackTrace()
        L_0x0168:
            return
        L_0x0169:
            r8.close()     // Catch:{ IOException -> 0x016d }
            return
        L_0x016d:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x0178
            r1.printStackTrace()
        L_0x0178:
            return
        L_0x0179:
            r0 = move-exception
            r1 = r0
            r2 = r8
            goto L_0x01c1
        L_0x017d:
            r0 = move-exception
            r2 = r8
            goto L_0x0184
        L_0x0180:
            r0 = move-exception
            r1 = r0
            goto L_0x01c1
        L_0x0183:
            r0 = move-exception
        L_0x0184:
            boolean r1 = com.tencent.bugly.proguard.al.a(r0)     // Catch:{ all -> 0x0180 }
            if (r1 != 0) goto L_0x018d
            r0.printStackTrace()     // Catch:{ all -> 0x0180 }
        L_0x018d:
            java.lang.String r1 = "trace open fail:%s : %s"
            java.lang.Class r3 = r0.getClass()     // Catch:{ all -> 0x0180 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x0180 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
            r4.<init>()     // Catch:{ all -> 0x0180 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0180 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x0180 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0180 }
            java.lang.Object[] r0 = new java.lang.Object[]{r3, r0}     // Catch:{ all -> 0x0180 }
            com.tencent.bugly.proguard.al.d(r1, r0)     // Catch:{ all -> 0x0180 }
            if (r2 == 0) goto L_0x01c0
            r2.close()     // Catch:{ IOException -> 0x01b5 }
            return
        L_0x01b5:
            r0 = move-exception
            r1 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r1)
            if (r0 != 0) goto L_0x01c0
            r1.printStackTrace()
        L_0x01c0:
            return
        L_0x01c1:
            if (r2 == 0) goto L_0x01d2
            r2.close()     // Catch:{ IOException -> 0x01c7 }
            goto L_0x01d2
        L_0x01c7:
            r0 = move-exception
            r2 = r0
            boolean r0 = com.tencent.bugly.proguard.al.a(r2)
            if (r0 != 0) goto L_0x01d2
            r2.printStackTrace()
        L_0x01d2:
            throw r1
        L_0x01d3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.readTraceFile(java.lang.String, com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b):void");
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            int length = patternArr.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Pattern pattern = patternArr[i];
                    if (pattern.matcher(readLine).matches()) {
                        return new Object[]{pattern, readLine};
                    }
                    i++;
                }
            }
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null && readLine.trim().length() > 0) {
                stringBuffer.append(readLine + "\n");
            }
        }
        return stringBuffer.toString();
    }
}
