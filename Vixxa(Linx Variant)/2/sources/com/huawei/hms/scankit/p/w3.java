package com.huawei.hms.scankit.p;

import android.os.Bundle;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import com.huawei.hms.hmsscankit.DetailRect;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HaLog60001 */
public final class w3 extends u3 {
    private volatile String h;
    private volatile String i;
    private boolean j = false;
    private volatile long k;
    public d l = new d();

    /* compiled from: HaLog60001 */
    class a extends SimpleDateFormat {
        a(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* compiled from: HaLog60001 */
    class b extends SimpleDateFormat {
        b(String str) {
            super(str);
            setTimeZone(TimeZone.getTimeZone("UTC"));
        }
    }

    /* compiled from: HaLog60001 */
    public static class c {
        /* access modifiers changed from: private */
        public int a;
        /* access modifiers changed from: private */
        public String b;
        /* access modifiers changed from: private */
        public String c;
        /* access modifiers changed from: private */
        public long d;
        /* access modifiers changed from: private */
        public long e;
        /* access modifiers changed from: private */
        public String f;
        /* access modifiers changed from: private */
        public String g;
        /* access modifiers changed from: private */
        public boolean h;
        /* access modifiers changed from: private */
        public int i;
        /* access modifiers changed from: private */
        public boolean j;

        /* synthetic */ c(long j2, String str, String str2, boolean z, int i2, int i3, a aVar) {
            this(j2, str, str2, z, i2, i3);
        }

        private c(long j2, String str, String str2, boolean z, int i2, int i3) {
            this.d = j2;
            this.b = str;
            this.c = str2;
            this.h = z;
            this.i = i2;
            this.a = i3;
        }

        /* access modifiers changed from: private */
        public c b(String str) {
            this.g = str;
            return this;
        }

        public c a(int i2) {
            this.a = i2;
            return this;
        }

        /* access modifiers changed from: private */
        public c a(long j2) {
            this.e = j2;
            return this;
        }

        /* access modifiers changed from: private */
        public c a(boolean z) {
            this.j = z;
            return this;
        }

        /* access modifiers changed from: private */
        public c a(String str) {
            this.f = str;
            return this;
        }
    }

    /* compiled from: HaLog60001 */
    public class d {
        /* access modifiers changed from: private */
        public String a = d.class.getSimpleName();
        public Timer b = new Timer();
        /* access modifiers changed from: private */
        public volatile boolean c = true;
        private List<c> d = new ArrayList(10);
        private List<c> e = new ArrayList(10);

        /* compiled from: HaLog60001 */
        class a extends TimerTask {
            a() {
            }

            public void run() {
                try {
                    boolean unused = d.this.c = true;
                    d.this.a();
                } catch (Exception unused2) {
                    o4.b(d.this.a, "onLog Exception");
                }
            }
        }

        public d() {
        }

        /* compiled from: HaLog60001 */
        private class b {
            private StringBuilder a;
            private AtomicInteger[] b;
            private String[] c;
            private long[] d;

            private b() {
                this.a = new StringBuilder(100);
                this.b = new AtomicInteger[]{new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger(), new AtomicInteger()};
                this.c = new String[]{"lt10K:", "lt100K:", "lt1M:", "lt3M:", "lt10M:", "lt40M:", "gt40M:"};
                this.d = new long[]{10240, 102400, PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED, 3145728, 10485760, 41943040, Long.MAX_VALUE};
            }

            /* access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                this.a.append("{");
                for (int i = 0; i < this.b.length; i++) {
                    this.a.append(this.c[i]);
                    this.a.append(this.b[i]);
                    this.a.append(",");
                }
                StringBuilder sb2 = this.a;
                sb2.replace(sb2.length() - 1, this.a.length(), "}");
                return this.a.toString();
            }

            /* access modifiers changed from: private */
            public void a(int i) {
                int i2 = 0;
                while (true) {
                    AtomicInteger[] atomicIntegerArr = this.b;
                    if (i2 >= atomicIntegerArr.length) {
                        return;
                    }
                    if (((long) i) <= this.d[i2]) {
                        atomicIntegerArr[i2].addAndGet(1);
                        return;
                    }
                    i2++;
                }
            }

            /* synthetic */ b(d dVar, a aVar) {
                this();
            }
        }

        /* compiled from: HaLog60001 */
        private class c {
            private StringBuilder a;
            private SparseArray<AtomicInteger> b;

            /* compiled from: HaLog60001 */
            class a extends SparseArray<AtomicInteger> {
                a() {
                    put(0, new AtomicInteger());
                }
            }

            /* compiled from: HaLog60001 */
            class b extends AtomicInteger {
                b() {
                    addAndGet(1);
                }
            }

            private c() {
                this.a = new StringBuilder(60);
                this.b = new a();
            }

            /* access modifiers changed from: private */
            public void a(int i) {
                if (this.b.get(i) == null) {
                    this.b.put(i, new b());
                } else {
                    this.b.get(i).addAndGet(1);
                }
            }

            /* synthetic */ c(d dVar, a aVar) {
                this();
            }

            /* access modifiers changed from: private */
            public String a() {
                StringBuilder sb = this.a;
                sb.delete(0, sb.length());
                this.a.append("{");
                for (int i = 0; i < this.b.size(); i++) {
                    this.a.append(this.b.keyAt(i));
                    this.a.append(":");
                    this.a.append(this.b.valueAt(i));
                    this.a.append(",");
                }
                StringBuilder sb2 = this.a;
                sb2.replace(sb2.length() - 1, this.a.length(), "}");
                return this.a.toString();
            }
        }

        public void b() {
            Timer timer = this.b;
            if (timer != null) {
                timer.cancel();
            }
        }

        /* access modifiers changed from: private */
        public void a(c cVar) {
            if (this.d.size() <= 100) {
                synchronized (this) {
                    this.d.add(cVar);
                    if (this.c) {
                        this.c = false;
                        this.b.schedule(new a(), 1000);
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public void a() {
            if (this.d.size() > 0) {
                synchronized (this) {
                    List<c> list = this.d;
                    List<c> list2 = this.e;
                    this.d = list2;
                    this.e = list;
                    list2.clear();
                }
                a(this.e);
            }
        }

        private void a(List<c> list) {
            HashSet<String> hashSet = new HashSet<>();
            for (c a2 : list) {
                hashSet.add(a2.c);
            }
            for (String str : hashSet) {
                Boolean bool = null;
                c cVar = new c(this, (a) null);
                b bVar = new b(this, (a) null);
                String str2 = "";
                long j = Long.MIN_VALUE;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = Long.MAX_VALUE;
                String str3 = str2;
                String str4 = str3;
                for (c next : list) {
                    str2 = next.b;
                    str3 = next.f;
                    str4 = next.g;
                    Boolean valueOf = Boolean.valueOf(next.h);
                    j3 += next.e - next.d;
                    cVar.a(next.a);
                    bVar.a(next.i);
                    j2++;
                    if (next.j) {
                        j5++;
                    }
                    if (next.a != 0) {
                        j4++;
                    }
                    if (next.e - next.d < j6) {
                        j6 = next.e - next.d;
                    }
                    if (next.e - next.d > j) {
                        j = next.e - next.d;
                    }
                    bool = valueOf;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                w3.this.g();
                linkedHashMap.putAll(w3.this.b);
                linkedHashMap.put(WiseOpenHianalyticsData.UNION_RESULT, cVar.a());
                linkedHashMap.put("imgSizeHistogram", bVar.a());
                linkedHashMap.put(WiseOpenHianalyticsData.UNION_CALLTIME, str2);
                linkedHashMap.put("transId", str);
                if (j2 != 0) {
                    j3 /= j2;
                }
                linkedHashMap.put(WiseOpenHianalyticsData.UNION_COSTTIME, String.valueOf(j3));
                linkedHashMap.put("allCnt", String.valueOf(j2));
                linkedHashMap.put("failCnt", String.valueOf(j4));
                linkedHashMap.put("codeCnt", String.valueOf(j5));
                linkedHashMap.put("scanType", str3);
                linkedHashMap.put("sceneType", str4);
                linkedHashMap.put("min", String.valueOf(j6));
                linkedHashMap.put("max", String.valueOf(j));
                linkedHashMap.put("algPhotoMode", String.valueOf(bool));
                a4.b().b("60001", linkedHashMap);
            }
        }
    }

    public w3(Bundle bundle, String str) {
        super(bundle, DynamicModuleInitializer.getContext().getApplicationContext());
        this.b.put(WiseOpenHianalyticsData.UNION_API_NAME, str);
        if (DetailRect.PHOTO_MODE.equals(str)) {
            this.j = true;
        }
    }

    public void a(String str) {
        this.b.put("algapi", str);
    }

    public c a(boolean z, int i2) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            if (this.j) {
                return new c(currentTimeMillis, new a("yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis)), UUID.randomUUID().toString(), z, i2, 0, (a) null);
            }
            if (currentTimeMillis - this.k > 1500) {
                String format = new b("yyyyMMddHHmmss.SSS").format(Long.valueOf(currentTimeMillis));
                String uuid = UUID.randomUUID().toString();
                if (currentTimeMillis - this.k > 1500) {
                    this.h = format;
                    this.i = uuid;
                    this.k = currentTimeMillis;
                }
            }
            return new c(currentTimeMillis, this.h, this.i, z, i2, 0, (a) null);
        } catch (Exception unused) {
            o4.b("HaLog6001", "exception happens");
            return new c(currentTimeMillis, this.h, this.i, z, i2, 0, (a) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r3v1 */
    /* JADX WARNING: type inference failed for: r3v4, types: [int] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.huawei.hms.ml.scan.HmsScan[] r8, com.huawei.hms.scankit.p.w3.c r9) {
        /*
            r7 = this;
            java.lang.String r0 = "HaLog60001"
            java.lang.String r1 = com.huawei.hms.scankit.p.u3.d     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            java.lang.String r2 = com.huawei.hms.scankit.p.u3.e     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            boolean r3 = r7.a()     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            if (r3 == 0) goto L_0x0055
            r3 = 0
            if (r8 == 0) goto L_0x002a
            int r4 = r8.length     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            if (r4 <= 0) goto L_0x002a
            int r4 = r8.length     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
        L_0x0013:
            if (r3 >= r4) goto L_0x0029
            r1 = r8[r3]     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            int r2 = r1.scanType     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            java.lang.String r2 = com.huawei.hms.scankit.p.u3.a((int) r2)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            int r1 = r1.scanTypeForm     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            java.lang.String r1 = com.huawei.hms.scankit.p.u3.b((int) r1)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            int r3 = r3 + 1
            r6 = r2
            r2 = r1
            r1 = r6
            goto L_0x0013
        L_0x0029:
            r3 = 1
        L_0x002a:
            com.huawei.hms.scankit.p.w3$d r8 = r7.l     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            com.huawei.hms.scankit.p.w3$c r4 = r9.a((long) r4)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            com.huawei.hms.scankit.p.w3$c r3 = r4.a((boolean) r3)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            com.huawei.hms.scankit.p.w3$c r1 = r3.a((java.lang.String) r1)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            com.huawei.hms.scankit.p.w3$c r1 = r1.b((java.lang.String) r2)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            r8.a((com.huawei.hms.scankit.p.w3.c) r1)     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            long r8 = r9.e     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            r7.k = r8     // Catch:{ NullPointerException -> 0x0050, Exception -> 0x004a }
            goto L_0x0055
        L_0x004a:
            java.lang.String r8 = "logEnd Exception"
            com.huawei.hms.scankit.p.o4.b(r0, r8)
            goto L_0x0055
        L_0x0050:
            java.lang.String r8 = "nullPoint"
            com.huawei.hms.scankit.p.o4.b(r0, r8)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.w3.a(com.huawei.hms.ml.scan.HmsScan[], com.huawei.hms.scankit.p.w3$c):void");
    }
}
