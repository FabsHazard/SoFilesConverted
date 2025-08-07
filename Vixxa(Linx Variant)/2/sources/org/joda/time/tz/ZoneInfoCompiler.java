package org.joda.time.tz;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import net.lingala.zip4j.util.InternalZipConstants;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.MutableDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class ZoneInfoCompiler {
    static Chronology cLenientISO;
    static DateTimeOfYear cStartOfYear;
    private List<String> iBackLinks = new ArrayList();
    private List<String> iGoodLinks = new ArrayList();
    private Map<String, RuleSet> iRuleSets = new HashMap();
    private List<Zone> iZones = new ArrayList();

    static char parseZoneChar(char c) {
        if (c != 'G') {
            if (c != 'S') {
                if (!(c == 'U' || c == 'Z' || c == 'g')) {
                    if (c != 's') {
                        return (c == 'u' || c == 'z') ? 'u' : 'w';
                    }
                }
            }
            return 's';
        }
    }

    public static void main(String[] strArr) throws Exception {
        File file;
        if (strArr.length == 0) {
            printUsage();
            return;
        }
        File file2 = null;
        int i = 0;
        File file3 = null;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= strArr.length) {
                break;
            }
            try {
                if ("-src".equals(strArr[i2])) {
                    i2++;
                    file2 = new File(strArr[i2]);
                } else if ("-dst".equals(strArr[i2])) {
                    i2++;
                    file3 = new File(strArr[i2]);
                } else if ("-verbose".equals(strArr[i2])) {
                    z = true;
                } else if ("-?".equals(strArr[i2])) {
                    printUsage();
                    return;
                }
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                printUsage();
                return;
            }
        }
        if (i2 >= strArr.length) {
            printUsage();
            return;
        }
        File[] fileArr = new File[(strArr.length - i2)];
        while (i2 < strArr.length) {
            if (file2 == null) {
                String str = strArr[i2];
            } else {
                file = new File(file2, strArr[i2]);
            }
            fileArr[i] = file;
            i2++;
            i++;
        }
        ZoneInfoLogger.set(z);
        new ZoneInfoCompiler().compile(file3, fileArr);
    }

    private static void printUsage() {
        System.out.println("Usage: java org.joda.time.tz.ZoneInfoCompiler <options> <source files>");
        System.out.println("where possible options include:");
        System.out.println("  -src <directory>    Specify where to read source files");
        System.out.println("  -dst <directory>    Specify where to write generated files");
        System.out.println("  -verbose            Output verbosely (default false)");
    }

    static DateTimeOfYear getStartOfYear() {
        if (cStartOfYear == null) {
            cStartOfYear = new DateTimeOfYear();
        }
        return cStartOfYear;
    }

    static Chronology getLenientISOChronology() {
        if (cLenientISO == null) {
            cLenientISO = LenientChronology.getInstance(ISOChronology.getInstanceUTC());
        }
        return cLenientISO;
    }

    static void writeZoneInfoMap(DataOutputStream dataOutputStream, Map<String, DateTimeZone> map) throws IOException {
        if (dataOutputStream != null) {
            HashMap hashMap = new HashMap(map.size());
            TreeMap treeMap = new TreeMap();
            short s = 0;
            for (Map.Entry next : map.entrySet()) {
                String str = (String) next.getKey();
                if (!hashMap.containsKey(str)) {
                    Short valueOf = Short.valueOf(s);
                    hashMap.put(str, valueOf);
                    treeMap.put(valueOf, str);
                    s = (short) (s + 1);
                    if (s == 0) {
                        throw new InternalError("Too many time zone ids");
                    }
                }
                String id = ((DateTimeZone) next.getValue()).getID();
                if (!hashMap.containsKey(id)) {
                    Short valueOf2 = Short.valueOf(s);
                    hashMap.put(id, valueOf2);
                    treeMap.put(valueOf2, id);
                    s = (short) (s + 1);
                    if (s == 0) {
                        throw new InternalError("Too many time zone ids");
                    }
                }
            }
            dataOutputStream.writeShort(treeMap.size());
            for (String writeUTF : treeMap.values()) {
                dataOutputStream.writeUTF(writeUTF);
            }
            dataOutputStream.writeShort(map.size());
            for (Map.Entry next2 : map.entrySet()) {
                dataOutputStream.writeShort(((Short) hashMap.get((String) next2.getKey())).shortValue());
                dataOutputStream.writeShort(((Short) hashMap.get(((DateTimeZone) next2.getValue()).getID())).shortValue());
            }
            return;
        }
        throw new IllegalArgumentException("DataOutputStream must not be null.");
    }

    static int parseYear(String str, int i) {
        String lowerCase = str.toLowerCase(Locale.ENGLISH);
        if (lowerCase.equals("minimum") || lowerCase.equals("min")) {
            return Integer.MIN_VALUE;
        }
        if (lowerCase.equals("maximum") || lowerCase.equals("max")) {
            return Integer.MAX_VALUE;
        }
        if (lowerCase.equals("only")) {
            return i;
        }
        return Integer.parseInt(lowerCase);
    }

    static int parseMonth(String str) {
        DateTimeField monthOfYear = ISOChronology.getInstanceUTC().monthOfYear();
        return monthOfYear.get(monthOfYear.set(0, str, Locale.ENGLISH));
    }

    static int parseDayOfWeek(String str) {
        DateTimeField dayOfWeek = ISOChronology.getInstanceUTC().dayOfWeek();
        return dayOfWeek.get(dayOfWeek.set(0, str, Locale.ENGLISH));
    }

    static String parseOptional(String str) {
        if (str.equals("-")) {
            return null;
        }
        return str;
    }

    static int parseTime(String str) {
        DateTimeFormatter hourMinuteSecondFraction = ISODateTimeFormat.hourMinuteSecondFraction();
        MutableDateTime mutableDateTime = new MutableDateTime(0, getLenientISOChronology());
        boolean startsWith = str.startsWith("-");
        if (hourMinuteSecondFraction.parseInto(mutableDateTime, str, startsWith ? 1 : 0) != (!startsWith)) {
            int millis = (int) mutableDateTime.getMillis();
            return startsWith ? -millis : millis;
        }
        throw new IllegalArgumentException(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0106, code lost:
        r1 = r1 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0108, code lost:
        if (r1 < 0) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x010a, code lost:
        r8 = r0.previousTransition(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0110, code lost:
        if (r8 == r5) goto L_0x0167;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0114, code lost:
        if (r8 >= r3) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0117, code lost:
        r5 = ((java.lang.Long) r13.get(r1)).longValue() - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0126, code lost:
        if (r5 == r8) goto L_0x0165;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0128, code lost:
        java.lang.System.out.println("*r* Error in " + r17.getID() + " " + new org.joda.time.DateTime(r8, (org.joda.time.Chronology) org.joda.time.chrono.ISOChronology.getInstanceUTC()) + " != " + new org.joda.time.DateTime(r5, (org.joda.time.Chronology) org.joda.time.chrono.ISOChronology.getInstanceUTC()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0164, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0165, code lost:
        r5 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean test(java.lang.String r16, org.joda.time.DateTimeZone r17) {
        /*
            r0 = r17
            java.lang.String r1 = r17.getID()
            r2 = r16
            boolean r1 = r2.equals(r1)
            r2 = 1
            if (r1 != 0) goto L_0x0010
            return r2
        L_0x0010:
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r1 = r1.year()
            r3 = 0
            r5 = 1850(0x73a, float:2.592E-42)
            long r6 = r1.set((long) r3, (int) r5)
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r1 = r1.year()
            r8 = 2050(0x802, float:2.873E-42)
            long r9 = r1.set((long) r3, (int) r8)
            int r1 = r0.getOffset((long) r6)
            int r11 = r0.getStandardOffset(r6)
            java.lang.String r12 = r0.getNameKey(r6)
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
        L_0x003f:
            long r14 = r0.nextTransition(r6)
            int r6 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            r7 = 0
            java.lang.String r2 = " "
            if (r6 == 0) goto L_0x00e6
            int r6 = (r14 > r9 ? 1 : (r14 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x0050
            goto L_0x00e6
        L_0x0050:
            int r6 = r0.getOffset((long) r14)
            int r5 = r0.getStandardOffset(r14)
            java.lang.String r3 = r0.getNameKey(r14)
            if (r1 != r6) goto L_0x0090
            if (r11 != r5) goto L_0x0090
            boolean r1 = r12.equals(r3)
            if (r1 == 0) goto L_0x0090
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "*d* Error in "
            r3.<init>(r4)
            java.lang.String r0 = r17.getID()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            org.joda.time.DateTime r2 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r3 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r2.<init>((long) r14, (org.joda.time.Chronology) r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.println(r0)
            return r7
        L_0x0090:
            if (r3 == 0) goto L_0x00b2
            int r1 = r3.length()
            r4 = 3
            if (r1 >= r4) goto L_0x00a2
            java.lang.String r1 = "??"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x00a2
            goto L_0x00b2
        L_0x00a2:
            java.lang.Long r1 = java.lang.Long.valueOf(r14)
            r13.add(r1)
            r12 = r3
            r1 = r6
            r6 = r14
            r2 = 1
            r3 = 0
            r5 = 1850(0x73a, float:2.592E-42)
            goto L_0x003f
        L_0x00b2:
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "*s* Error in "
            r4.<init>(r5)
            java.lang.String r0 = r17.getID()
            java.lang.StringBuilder r0 = r4.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            org.joda.time.DateTime r2 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r4 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r2.<init>((long) r14, (org.joda.time.Chronology) r4)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = ", nameKey="
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.StringBuilder r0 = r0.append(r3)
            java.lang.String r0 = r0.toString()
            r1.println(r0)
            return r7
        L_0x00e6:
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r1 = r1.year()
            r3 = 0
            long r5 = r1.set((long) r3, (int) r8)
            org.joda.time.chrono.ISOChronology r1 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            org.joda.time.DateTimeField r1 = r1.year()
            r8 = 1850(0x73a, float:2.592E-42)
            long r3 = r1.set((long) r3, (int) r8)
            int r1 = r13.size()
        L_0x0106:
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x0167
            long r8 = r0.previousTransition(r5)
            int r5 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0167
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x0117
            goto L_0x0167
        L_0x0117:
            java.lang.Object r5 = r13.get(r1)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            r10 = 1
            long r5 = r5 - r10
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0165
            java.io.PrintStream r1 = java.lang.System.out
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "*r* Error in "
            r3.<init>(r4)
            java.lang.String r0 = r17.getID()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            org.joda.time.DateTime r2 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r3 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r2.<init>((long) r8, (org.joda.time.Chronology) r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r2 = " != "
            java.lang.StringBuilder r0 = r0.append(r2)
            org.joda.time.DateTime r2 = new org.joda.time.DateTime
            org.joda.time.chrono.ISOChronology r3 = org.joda.time.chrono.ISOChronology.getInstanceUTC()
            r2.<init>((long) r5, (org.joda.time.Chronology) r3)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r1.println(r0)
            return r7
        L_0x0165:
            r5 = r8
            goto L_0x0106
        L_0x0167:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.ZoneInfoCompiler.test(java.lang.String, org.joda.time.DateTimeZone):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.String, org.joda.time.DateTimeZone> compile(java.io.File r12, java.io.File[] r13) throws java.io.IOException {
        /*
            r11 = this;
            r0 = 0
            if (r13 == 0) goto L_0x0033
            r1 = r0
        L_0x0004:
            int r2 = r13.length
            if (r1 >= r2) goto L_0x0033
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ all -> 0x002c }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ all -> 0x002c }
            r5 = r13[r1]     // Catch:{ all -> 0x002c }
            r4.<init>(r5)     // Catch:{ all -> 0x002c }
            r3.<init>(r4)     // Catch:{ all -> 0x002c }
            java.lang.String r2 = "backward"
            r4 = r13[r1]     // Catch:{ all -> 0x0029 }
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x0029 }
            r11.parseDataFile(r3, r2)     // Catch:{ all -> 0x0029 }
            r3.close()
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0029:
            r12 = move-exception
            r2 = r3
            goto L_0x002d
        L_0x002c:
            r12 = move-exception
        L_0x002d:
            if (r2 == 0) goto L_0x0032
            r2.close()
        L_0x0032:
            throw r12
        L_0x0033:
            if (r12 == 0) goto L_0x0073
            boolean r13 = r12.exists()
            if (r13 != 0) goto L_0x0057
            boolean r13 = r12.mkdirs()
            if (r13 == 0) goto L_0x0042
            goto L_0x0057
        L_0x0042:
            java.io.IOException r13 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Destination directory doesn't exist and cannot be created: "
            r0.<init>(r1)
            java.lang.StringBuilder r12 = r0.append(r12)
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        L_0x0057:
            boolean r13 = r12.isDirectory()
            if (r13 == 0) goto L_0x005e
            goto L_0x0073
        L_0x005e:
            java.io.IOException r13 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Destination is not a directory: "
            r0.<init>(r1)
            java.lang.StringBuilder r12 = r0.append(r12)
            java.lang.String r12 = r12.toString()
            r13.<init>(r12)
            throw r13
        L_0x0073:
            java.util.TreeMap r13 = new java.util.TreeMap
            r13.<init>()
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
            java.io.PrintStream r2 = java.lang.System.out
            java.lang.String r3 = "Writing zoneinfo files"
            r2.println(r3)
            r2 = r0
        L_0x0085:
            java.util.List<org.joda.time.tz.ZoneInfoCompiler$Zone> r3 = r11.iZones
            int r3 = r3.size()
            r4 = 1
            if (r2 >= r3) goto L_0x00c6
            java.util.List<org.joda.time.tz.ZoneInfoCompiler$Zone> r3 = r11.iZones
            java.lang.Object r3 = r3.get(r2)
            org.joda.time.tz.ZoneInfoCompiler$Zone r3 = (org.joda.time.tz.ZoneInfoCompiler.Zone) r3
            org.joda.time.tz.DateTimeZoneBuilder r5 = new org.joda.time.tz.DateTimeZoneBuilder
            r5.<init>()
            java.util.Map<java.lang.String, org.joda.time.tz.ZoneInfoCompiler$RuleSet> r6 = r11.iRuleSets
            r3.addToBuilder(r5, r6)
            java.lang.String r6 = r3.iName
            org.joda.time.DateTimeZone r4 = r5.toDateTimeZone(r6, r4)
            java.lang.String r6 = r4.getID()
            boolean r6 = test(r6, r4)
            if (r6 == 0) goto L_0x00c3
            java.lang.String r6 = r4.getID()
            r13.put(r6, r4)
            java.lang.String r6 = r4.getID()
            r1.put(r6, r3)
            if (r12 == 0) goto L_0x00c3
            r11.writeZone(r12, r5, r4)
        L_0x00c3:
            int r2 = r2 + 1
            goto L_0x0085
        L_0x00c6:
            r2 = r0
        L_0x00c7:
            java.util.List<java.lang.String> r3 = r11.iGoodLinks
            int r3 = r3.size()
            java.lang.String r5 = " -> "
            java.lang.String r6 = "' to"
            java.lang.String r7 = "' to link alias '"
            if (r2 >= r3) goto L_0x0167
            java.util.List<java.lang.String> r3 = r11.iGoodLinks
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            java.util.List<java.lang.String> r8 = r11.iGoodLinks
            int r9 = r2 + 1
            java.lang.Object r8 = r8.get(r9)
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r1.get(r3)
            org.joda.time.tz.ZoneInfoCompiler$Zone r9 = (org.joda.time.tz.ZoneInfoCompiler.Zone) r9
            if (r9 != 0) goto L_0x0110
            java.io.PrintStream r5 = java.lang.System.out
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Cannot find source zone '"
            r9.<init>(r10)
            java.lang.StringBuilder r3 = r9.append(r3)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r3 = r3.toString()
            r5.println(r3)
            goto L_0x0163
        L_0x0110:
            org.joda.time.tz.DateTimeZoneBuilder r6 = new org.joda.time.tz.DateTimeZoneBuilder
            r6.<init>()
            java.util.Map<java.lang.String, org.joda.time.tz.ZoneInfoCompiler$RuleSet> r7 = r11.iRuleSets
            r9.addToBuilder(r6, r7)
            org.joda.time.DateTimeZone r7 = r6.toDateTimeZone(r8, r4)
            java.lang.String r9 = r7.getID()
            boolean r9 = test(r9, r7)
            if (r9 == 0) goto L_0x0134
            java.lang.String r9 = r7.getID()
            r13.put(r9, r7)
            if (r12 == 0) goto L_0x0134
            r11.writeZone(r12, r6, r7)
        L_0x0134:
            java.lang.String r6 = r7.getID()
            r13.put(r6, r7)
            boolean r6 = org.joda.time.tz.ZoneInfoLogger.verbose()
            if (r6 == 0) goto L_0x0163
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "Good link: "
            r7.<init>(r9)
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r5 = r7.append(r5)
            java.lang.StringBuilder r3 = r5.append(r3)
            java.lang.String r5 = " revived"
            java.lang.StringBuilder r3 = r3.append(r5)
            java.lang.String r3 = r3.toString()
            r6.println(r3)
        L_0x0163:
            int r2 = r2 + 2
            goto L_0x00c7
        L_0x0167:
            r1 = r0
        L_0x0168:
            r2 = 2
            if (r1 >= r2) goto L_0x01e0
            r2 = r0
        L_0x016c:
            java.util.List<java.lang.String> r3 = r11.iBackLinks
            int r3 = r3.size()
            if (r2 >= r3) goto L_0x01dd
            java.util.List<java.lang.String> r3 = r11.iBackLinks
            java.lang.Object r3 = r3.get(r2)
            java.lang.String r3 = (java.lang.String) r3
            java.util.List<java.lang.String> r4 = r11.iBackLinks
            int r8 = r2 + 1
            java.lang.Object r4 = r4.get(r8)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r13.get(r3)
            org.joda.time.DateTimeZone r8 = (org.joda.time.DateTimeZone) r8
            if (r8 != 0) goto L_0x01b1
            if (r1 <= 0) goto L_0x01da
            java.io.PrintStream r8 = java.lang.System.out
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Cannot find time zone '"
            r9.<init>(r10)
            java.lang.StringBuilder r3 = r9.append(r3)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r6)
            java.lang.String r3 = r3.toString()
            r8.println(r3)
            goto L_0x01da
        L_0x01b1:
            r13.put(r4, r8)
            boolean r3 = org.joda.time.tz.ZoneInfoLogger.verbose()
            if (r3 == 0) goto L_0x01da
            java.io.PrintStream r3 = java.lang.System.out
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Back link: "
            r9.<init>(r10)
            java.lang.StringBuilder r4 = r9.append(r4)
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r8 = r8.getID()
            java.lang.StringBuilder r4 = r4.append(r8)
            java.lang.String r4 = r4.toString()
            r3.println(r4)
        L_0x01da:
            int r2 = r2 + 2
            goto L_0x016c
        L_0x01dd:
            int r1 = r1 + 1
            goto L_0x0168
        L_0x01e0:
            if (r12 == 0) goto L_0x0221
            java.io.PrintStream r0 = java.lang.System.out
            java.lang.String r1 = "Writing ZoneInfoMap"
            r0.println(r1)
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "ZoneInfoMap"
            r0.<init>(r12, r1)
            java.io.File r12 = r0.getParentFile()
            boolean r12 = r12.exists()
            if (r12 != 0) goto L_0x0201
            java.io.File r12 = r0.getParentFile()
            r12.mkdirs()
        L_0x0201:
            java.io.FileOutputStream r12 = new java.io.FileOutputStream
            r12.<init>(r0)
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            r0.<init>(r12)
            java.util.TreeMap r12 = new java.util.TreeMap     // Catch:{ all -> 0x021c }
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER     // Catch:{ all -> 0x021c }
            r12.<init>(r1)     // Catch:{ all -> 0x021c }
            r12.putAll(r13)     // Catch:{ all -> 0x021c }
            writeZoneInfoMap(r0, r12)     // Catch:{ all -> 0x021c }
            r0.close()
            goto L_0x0221
        L_0x021c:
            r12 = move-exception
            r0.close()
            throw r12
        L_0x0221:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.ZoneInfoCompiler.compile(java.io.File, java.io.File[]):java.util.Map");
    }

    /* JADX INFO: finally extract failed */
    private void writeZone(File file, DateTimeZoneBuilder dateTimeZoneBuilder, DateTimeZone dateTimeZone) throws IOException {
        if (ZoneInfoLogger.verbose()) {
            System.out.println("Writing " + dateTimeZone.getID());
        }
        File file2 = new File(file, dateTimeZone.getID());
        if (!file2.getParentFile().exists()) {
            file2.getParentFile().mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            dateTimeZoneBuilder.writeTo(dateTimeZone.getID(), (OutputStream) fileOutputStream);
            fileOutputStream.close();
            FileInputStream fileInputStream = new FileInputStream(file2);
            DateTimeZone readFrom = DateTimeZoneBuilder.readFrom((InputStream) fileInputStream, dateTimeZone.getID());
            fileInputStream.close();
            if (!dateTimeZone.equals(readFrom)) {
                System.out.println("*e* Error in " + dateTimeZone.getID() + ": Didn't read properly from file");
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public void parseDataFile(BufferedReader bufferedReader, boolean z) throws IOException {
        while (true) {
            Zone zone = null;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    String trim = readLine.trim();
                    if (!(trim.length() == 0 || trim.charAt(0) == '#')) {
                        int indexOf = readLine.indexOf(35);
                        if (indexOf >= 0) {
                            readLine = readLine.substring(0, indexOf);
                        }
                        StringTokenizer stringTokenizer = new StringTokenizer(readLine, " \t");
                        if (!Character.isWhitespace(readLine.charAt(0)) || !stringTokenizer.hasMoreTokens()) {
                            if (zone != null) {
                                this.iZones.add(zone);
                            }
                            if (!stringTokenizer.hasMoreTokens()) {
                                break;
                            }
                            String nextToken = stringTokenizer.nextToken();
                            if (nextToken.equalsIgnoreCase("Rule")) {
                                Rule rule = new Rule(stringTokenizer);
                                RuleSet ruleSet = this.iRuleSets.get(rule.iName);
                                if (ruleSet == null) {
                                    this.iRuleSets.put(rule.iName, new RuleSet(rule));
                                } else {
                                    ruleSet.addRule(rule);
                                }
                            } else if (nextToken.equalsIgnoreCase("Zone")) {
                                if (stringTokenizer.countTokens() >= 4) {
                                    zone = new Zone(stringTokenizer);
                                } else {
                                    throw new IllegalArgumentException("Attempting to create a Zone from an incomplete tokenizer");
                                }
                            } else if (nextToken.equalsIgnoreCase("Link")) {
                                String nextToken2 = stringTokenizer.nextToken();
                                String nextToken3 = stringTokenizer.nextToken();
                                if (z || nextToken3.equals("US/Pacific-New") || nextToken3.startsWith("Etc/") || nextToken3.equals("GMT")) {
                                    this.iBackLinks.add(nextToken2);
                                    this.iBackLinks.add(nextToken3);
                                } else {
                                    this.iGoodLinks.add(nextToken2);
                                    this.iGoodLinks.add(nextToken3);
                                }
                            } else {
                                System.out.println("Unknown line: " + readLine);
                            }
                        } else if (zone != null) {
                            zone.chain(stringTokenizer);
                        }
                    }
                } else if (zone != null) {
                    this.iZones.add(zone);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    static class DateTimeOfYear {
        public final boolean iAdvanceDayOfWeek;
        public final int iDayOfMonth;
        public final int iDayOfWeek;
        public final int iMillisOfDay;
        public final int iMonthOfYear;
        public final char iZoneChar;

        DateTimeOfYear() {
            this.iMonthOfYear = 1;
            this.iDayOfMonth = 1;
            this.iDayOfWeek = 0;
            this.iAdvanceDayOfWeek = false;
            this.iMillisOfDay = 0;
            this.iZoneChar = 'w';
        }

        DateTimeOfYear(StringTokenizer stringTokenizer) {
            int i;
            boolean z;
            int i2;
            int i3;
            LocalDate localDate;
            int i4 = 1;
            int i5 = 0;
            char c = 'w';
            if (stringTokenizer.hasMoreTokens()) {
                int parseMonth = ZoneInfoCompiler.parseMonth(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (nextToken.startsWith("last")) {
                        z = false;
                        i3 = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(4));
                        i2 = -1;
                    } else {
                        try {
                            i2 = Integer.parseInt(nextToken);
                            i3 = 0;
                            z = false;
                        } catch (NumberFormatException unused) {
                            int indexOf = nextToken.indexOf(">=");
                            if (indexOf > 0) {
                                int parseInt = Integer.parseInt(nextToken.substring(indexOf + 2));
                                i3 = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(0, indexOf));
                                i2 = parseInt;
                                z = true;
                            } else {
                                int indexOf2 = nextToken.indexOf("<=");
                                if (indexOf2 > 0) {
                                    int parseInt2 = Integer.parseInt(nextToken.substring(indexOf2 + 2));
                                    i3 = ZoneInfoCompiler.parseDayOfWeek(nextToken.substring(0, indexOf2));
                                    i2 = parseInt2;
                                    z = false;
                                } else {
                                    throw new IllegalArgumentException(nextToken);
                                }
                            }
                        }
                    }
                    if (stringTokenizer.hasMoreTokens()) {
                        String nextToken2 = stringTokenizer.nextToken();
                        c = ZoneInfoCompiler.parseZoneChar(nextToken2.charAt(nextToken2.length() - 1));
                        if (!nextToken2.equals("24:00")) {
                            i5 = ZoneInfoCompiler.parseTime(nextToken2);
                        } else if (parseMonth == 12 && i2 == 31) {
                            i5 = ZoneInfoCompiler.parseTime("23:59:59.999");
                        } else {
                            if (i2 == -1) {
                                localDate = new LocalDate(2001, parseMonth, 1).plusMonths(1);
                            } else {
                                localDate = new LocalDate(2001, parseMonth, i2).plusDays(1);
                            }
                            boolean z2 = (i2 == -1 || i3 == 0) ? false : true;
                            int monthOfYear = localDate.getMonthOfYear();
                            int dayOfMonth = localDate.getDayOfMonth();
                            i3 = i3 != 0 ? (i3 % 7) + 1 : i3;
                            z = z2;
                            i4 = monthOfYear;
                            i2 = dayOfMonth;
                            i = i5;
                            i5 = i3;
                        }
                    }
                    i4 = parseMonth;
                    i = i5;
                    i5 = i3;
                } else {
                    i2 = 1;
                    i = 0;
                    z = false;
                    i4 = parseMonth;
                }
            } else {
                i2 = 1;
                i = 0;
                z = false;
            }
            this.iMonthOfYear = i4;
            this.iDayOfMonth = i2;
            this.iDayOfWeek = i5;
            this.iAdvanceDayOfWeek = z;
            this.iMillisOfDay = i;
            this.iZoneChar = c;
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, String str, int i, int i2, int i3) {
            dateTimeZoneBuilder.addRecurringSavings(str, i, i2, i3, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public void addCutover(DateTimeZoneBuilder dateTimeZoneBuilder, int i) {
            dateTimeZoneBuilder.addCutover(i, this.iZoneChar, this.iMonthOfYear, this.iDayOfMonth, this.iDayOfWeek, this.iAdvanceDayOfWeek, this.iMillisOfDay);
        }

        public String toString() {
            return "MonthOfYear: " + this.iMonthOfYear + "\nDayOfMonth: " + this.iDayOfMonth + "\nDayOfWeek: " + this.iDayOfWeek + "\nAdvanceDayOfWeek: " + this.iAdvanceDayOfWeek + "\nMillisOfDay: " + this.iMillisOfDay + "\nZoneChar: " + this.iZoneChar + "\n";
        }
    }

    private static class Rule {
        public final DateTimeOfYear iDateTimeOfYear;
        public final int iFromYear;
        public final String iLetterS;
        public final String iName;
        public final int iSaveMillis;
        public final int iToYear;
        public final String iType;

        Rule(StringTokenizer stringTokenizer) {
            if (stringTokenizer.countTokens() >= 6) {
                this.iName = stringTokenizer.nextToken().intern();
                int parseYear = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), 0);
                this.iFromYear = parseYear;
                int parseYear2 = ZoneInfoCompiler.parseYear(stringTokenizer.nextToken(), parseYear);
                this.iToYear = parseYear2;
                if (parseYear2 >= parseYear) {
                    this.iType = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
                    this.iDateTimeOfYear = new DateTimeOfYear(stringTokenizer);
                    this.iSaveMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
                    this.iLetterS = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
                    return;
                }
                throw new IllegalArgumentException();
            }
            throw new IllegalArgumentException("Attempting to create a Rule from an incomplete tokenizer");
        }

        Rule(Rule rule) {
            this.iName = rule.iName;
            this.iFromYear = 1800;
            this.iToYear = rule.iFromYear;
            this.iType = null;
            this.iDateTimeOfYear = rule.iDateTimeOfYear;
            this.iSaveMillis = 0;
            this.iLetterS = rule.iLetterS;
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, int i, String str) {
            int i2 = this.iSaveMillis + (-i);
            DateTimeZoneBuilder dateTimeZoneBuilder2 = dateTimeZoneBuilder;
            this.iDateTimeOfYear.addRecurring(dateTimeZoneBuilder2, formatName(str, i2, this.iLetterS), i2, this.iFromYear, this.iToYear);
        }

        private static String formatName(String str, int i, String str2) {
            String str3;
            int indexOf = str.indexOf(47);
            if (indexOf <= 0) {
                int indexOf2 = str.indexOf("%s");
                if (indexOf2 < 0) {
                    return str;
                }
                String substring = str.substring(0, indexOf2);
                String substring2 = str.substring(indexOf2 + 2);
                if (str2 == null) {
                    str3 = substring.concat(substring2);
                } else {
                    str3 = substring + str2 + substring2;
                }
                return str3.intern();
            } else if (i == 0) {
                return str.substring(0, indexOf).intern();
            } else {
                return str.substring(indexOf + 1).intern();
            }
        }

        public String toString() {
            return "[Rule]\nName: " + this.iName + "\nFromYear: " + this.iFromYear + "\nToYear: " + this.iToYear + "\nType: " + this.iType + "\n" + this.iDateTimeOfYear + "SaveMillis: " + this.iSaveMillis + "\nLetterS: " + this.iLetterS + "\n";
        }
    }

    private static class RuleSet {
        private List<Rule> iRules;

        RuleSet(Rule rule) {
            ArrayList arrayList = new ArrayList();
            this.iRules = arrayList;
            arrayList.add(rule);
        }

        /* access modifiers changed from: package-private */
        public void addRule(Rule rule) {
            if (rule.iName.equals(this.iRules.get(0).iName)) {
                this.iRules.add(rule);
                return;
            }
            throw new IllegalArgumentException("Rule name mismatch");
        }

        public void addRecurring(DateTimeZoneBuilder dateTimeZoneBuilder, int i, String str) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.iRules.size(); i3++) {
                Rule rule = this.iRules.get(i3);
                if (rule.iSaveMillis < 0) {
                    i2 = Math.min(i2, rule.iSaveMillis);
                }
            }
            if (i2 < 0) {
                System.out.println("Fixed negative save values for rule '" + this.iRules.get(0).iName + "'");
                i += i2;
                int indexOf = str.indexOf(InternalZipConstants.ZIP_FILE_SEPARATOR);
                if (indexOf > 0) {
                    str = str.substring(indexOf + 1) + InternalZipConstants.ZIP_FILE_SEPARATOR + str.substring(0, indexOf);
                }
            }
            dateTimeZoneBuilder.setStandardOffset(i);
            if (i2 < 0) {
                new Rule(this.iRules.get(0)).addRecurring(dateTimeZoneBuilder, i2, str);
            }
            for (int i4 = 0; i4 < this.iRules.size(); i4++) {
                this.iRules.get(i4).addRecurring(dateTimeZoneBuilder, i2, str);
            }
        }
    }

    private static class Zone {
        public final String iFormat;
        public final String iName;
        private Zone iNext;
        public final int iOffsetMillis;
        public final String iRules;
        public final DateTimeOfYear iUntilDateTimeOfYear;
        public final int iUntilYear;

        Zone(StringTokenizer stringTokenizer) {
            this(stringTokenizer.nextToken(), stringTokenizer);
        }

        private Zone(String str, StringTokenizer stringTokenizer) {
            int i;
            this.iName = str.intern();
            this.iOffsetMillis = ZoneInfoCompiler.parseTime(stringTokenizer.nextToken());
            this.iRules = ZoneInfoCompiler.parseOptional(stringTokenizer.nextToken());
            this.iFormat = stringTokenizer.nextToken().intern();
            DateTimeOfYear startOfYear = ZoneInfoCompiler.getStartOfYear();
            if (stringTokenizer.hasMoreTokens()) {
                i = Integer.parseInt(stringTokenizer.nextToken());
                if (stringTokenizer.hasMoreTokens()) {
                    startOfYear = new DateTimeOfYear(stringTokenizer);
                }
            } else {
                i = Integer.MAX_VALUE;
            }
            this.iUntilYear = i;
            this.iUntilDateTimeOfYear = startOfYear;
        }

        /* access modifiers changed from: package-private */
        public void chain(StringTokenizer stringTokenizer) {
            Zone zone = this.iNext;
            if (zone != null) {
                zone.chain(stringTokenizer);
            } else {
                this.iNext = new Zone(this.iName, stringTokenizer);
            }
        }

        public void addToBuilder(DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            addToBuilder(this, dateTimeZoneBuilder, map);
        }

        private static void addToBuilder(Zone zone, DateTimeZoneBuilder dateTimeZoneBuilder, Map<String, RuleSet> map) {
            while (zone != null) {
                String str = zone.iRules;
                if (str == null) {
                    dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                    dateTimeZoneBuilder.setFixedSavings(zone.iFormat, 0);
                } else {
                    try {
                        int parseTime = ZoneInfoCompiler.parseTime(str);
                        dateTimeZoneBuilder.setStandardOffset(zone.iOffsetMillis);
                        dateTimeZoneBuilder.setFixedSavings(zone.iFormat, parseTime);
                    } catch (Exception unused) {
                        RuleSet ruleSet = map.get(zone.iRules);
                        if (ruleSet != null) {
                            ruleSet.addRecurring(dateTimeZoneBuilder, zone.iOffsetMillis, zone.iFormat);
                        } else {
                            throw new IllegalArgumentException("Rules not found: " + zone.iRules);
                        }
                    }
                }
                int i = zone.iUntilYear;
                if (i != Integer.MAX_VALUE) {
                    zone.iUntilDateTimeOfYear.addCutover(dateTimeZoneBuilder, i);
                    zone = zone.iNext;
                } else {
                    return;
                }
            }
        }

        public String toString() {
            String str = "[Zone]\nName: " + this.iName + "\nOffsetMillis: " + this.iOffsetMillis + "\nRules: " + this.iRules + "\nFormat: " + this.iFormat + "\nUntilYear: " + this.iUntilYear + "\n" + this.iUntilDateTimeOfYear;
            if (this.iNext == null) {
                return str;
            }
            return str + "...\n" + this.iNext.toString();
        }
    }
}
