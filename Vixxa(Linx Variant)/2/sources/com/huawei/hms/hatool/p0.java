package com.huawei.hms.hatool;

import java.util.Calendar;
import java.util.UUID;

public class p0 {
    /* access modifiers changed from: private */
    public long a = 1800000;
    /* access modifiers changed from: private */
    public volatile boolean b = false;
    private a c = null;

    private class a {
        String a = UUID.randomUUID().toString().replace("-", "");
        boolean b;
        private long c;

        a(long j) {
            this.a += "_" + j;
            this.c = j;
            this.b = true;
            boolean unused = p0.this.b = false;
        }

        private boolean a(long j, long j2) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(j2);
            return (instance.get(1) == instance2.get(1) && instance.get(6) == instance2.get(6)) ? false : true;
        }

        private void b(long j) {
            v.c("hmsSdk", "getNewSession() session is flush!");
            String uuid = UUID.randomUUID().toString();
            this.a = uuid;
            this.a = uuid.replace("-", "");
            this.a += "_" + j;
            this.c = j;
            this.b = true;
        }

        private boolean b(long j, long j2) {
            return j2 - j >= p0.this.a;
        }

        /* access modifiers changed from: package-private */
        public void a(long j) {
            if (p0.this.b) {
                boolean unused = p0.this.b = false;
                b(j);
            } else if (b(this.c, j) || a(this.c, j)) {
                b(j);
            } else {
                this.c = j;
                this.b = false;
            }
        }
    }

    public String a() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.a;
        }
        v.f("hmsSdk", "getSessionName(): session not prepared. onEvent() must be called first.");
        return "";
    }

    /* access modifiers changed from: package-private */
    public void a(long j) {
        a aVar = this.c;
        if (aVar == null) {
            v.c("hmsSdk", "Session is first flush");
            this.c = new a(j);
            return;
        }
        aVar.a(j);
    }

    public boolean b() {
        a aVar = this.c;
        if (aVar != null) {
            return aVar.b;
        }
        v.f("hmsSdk", "isFirstEvent(): session not prepared. onEvent() must be called first.");
        return false;
    }
}
