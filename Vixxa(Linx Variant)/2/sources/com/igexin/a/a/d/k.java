package com.igexin.a.a.d;

final class k extends Thread {
    volatile boolean a = true;
    h b;
    final /* synthetic */ f c;

    public k(f fVar) {
        this.c = fVar;
        setName("TS-processor");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r11.b != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r11.b = new com.igexin.a.a.d.h(r11.c);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        if (r4.o == false) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0086, code lost:
        r4.z = 0;
        r0.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d0, code lost:
        if (r4.o == false) goto L_0x0086;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r11 = this;
            r0 = -2
            android.os.Process.setThreadPriority(r0)
            com.igexin.a.a.d.f r0 = r11.c
            com.igexin.a.a.d.d<com.igexin.a.a.d.e> r0 = r0.k
            r1 = 0
            r2 = 1
        L_0x000a:
            r4 = r1
        L_0x000b:
            r3 = r2
        L_0x000c:
            boolean r5 = r11.a
            if (r5 == 0) goto L_0x0124
            r5 = -1
            r6 = 0
            if (r3 == r5) goto L_0x001c
            if (r3 == 0) goto L_0x0069
            if (r3 == r2) goto L_0x00d3
            r5 = 2
            if (r3 == r5) goto L_0x00e8
            goto L_0x000c
        L_0x001c:
            r4.d()     // Catch:{ Exception -> 0x0109 }
            boolean r3 = r4.q()     // Catch:{ Exception -> 0x0109 }
            if (r3 == 0) goto L_0x0038
            com.igexin.a.a.d.h r3 = r11.b     // Catch:{ Exception -> 0x0109 }
            if (r3 != 0) goto L_0x0032
            com.igexin.a.a.d.h r3 = new com.igexin.a.a.d.h     // Catch:{ Exception -> 0x0109 }
            com.igexin.a.a.d.f r5 = r11.c     // Catch:{ Exception -> 0x0109 }
            r3.<init>(r5)     // Catch:{ Exception -> 0x0109 }
            r11.b = r3     // Catch:{ Exception -> 0x0109 }
        L_0x0032:
            com.igexin.a.a.d.h r3 = r11.b     // Catch:{ Exception -> 0x0109 }
            r3.a((com.igexin.a.a.d.e) r4)     // Catch:{ Exception -> 0x0109 }
            goto L_0x000a
        L_0x0038:
            boolean r3 = r4.n     // Catch:{ Exception -> 0x0109 }
            if (r3 == 0) goto L_0x0069
            long r7 = r4.t     // Catch:{ Exception -> 0x0109 }
            r9 = 0
            int r3 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r3 != 0) goto L_0x0069
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0109 }
            r3.<init>()     // Catch:{ Exception -> 0x0109 }
            java.lang.String r5 = "TaskService|"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Exception -> 0x0109 }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r5 = "|isBlock = false|cycyle = true|doTime = 0, "
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r5 = "invalid ###########"
            java.lang.StringBuilder r3 = r3.append(r5)     // Catch:{ Exception -> 0x0109 }
            java.lang.String r3 = r3.toString()     // Catch:{ Exception -> 0x0109 }
            java.lang.Object[] r5 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0109 }
            com.igexin.a.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r5)     // Catch:{ Exception -> 0x0109 }
            goto L_0x000b
        L_0x0069:
            r4.b()     // Catch:{ Exception -> 0x0090 }
            r4.g()     // Catch:{ Exception -> 0x0090 }
            r4.e_()     // Catch:{ Exception -> 0x0090 }
            com.igexin.a.a.d.f r3 = r11.c
            r3.g()
            boolean r3 = r4.s
            if (r3 != 0) goto L_0x007e
            r4.c()
        L_0x007e:
            boolean r3 = r4.j
            if (r3 != 0) goto L_0x008b
            boolean r3 = r4.o
            if (r3 != 0) goto L_0x008b
        L_0x0086:
            r4.z = r6
            r0.a(r4)
        L_0x008b:
            r4 = r1
            r3 = r2
            goto L_0x00d3
        L_0x008e:
            r1 = move-exception
            goto L_0x00ef
        L_0x0090:
            r3 = move-exception
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
            r7.<init>()     // Catch:{ all -> 0x008e }
            java.lang.String r8 = "TaskService|SERVICE_PROCESSING|error|"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x008e }
            java.lang.String r8 = r3.toString()     // Catch:{ all -> 0x008e }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x008e }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008e }
            java.lang.Object[] r8 = new java.lang.Object[r6]     // Catch:{ all -> 0x008e }
            com.igexin.a.a.c.b.a((java.lang.String) r7, (java.lang.Object[]) r8)     // Catch:{ all -> 0x008e }
            r4.s = r2     // Catch:{ all -> 0x008e }
            r4.A = r3     // Catch:{ all -> 0x008e }
            r4.t()     // Catch:{ all -> 0x008e }
            r4.p()     // Catch:{ all -> 0x008e }
            com.igexin.a.a.d.f r3 = r11.c     // Catch:{ all -> 0x008e }
            com.igexin.a.a.d.c r3 = r3.j     // Catch:{ all -> 0x008e }
            r3.a(r4)     // Catch:{ all -> 0x008e }
            com.igexin.a.a.d.f r3 = r11.c
            r3.g()
            boolean r3 = r4.s
            if (r3 != 0) goto L_0x00ca
            r4.c()
        L_0x00ca:
            boolean r3 = r4.j
            if (r3 != 0) goto L_0x008b
            boolean r3 = r4.o
            if (r3 != 0) goto L_0x008b
            goto L_0x0086
        L_0x00d3:
            com.igexin.a.a.d.e r4 = r0.c()     // Catch:{ InterruptedException -> 0x00d7 }
        L_0x00d7:
            if (r4 == 0) goto L_0x00e8
            boolean r6 = r4.j
            if (r6 != 0) goto L_0x00e5
            boolean r6 = r4.k
            if (r6 == 0) goto L_0x00e2
            goto L_0x00e5
        L_0x00e2:
            r3 = r5
            goto L_0x000c
        L_0x00e5:
            r4 = r1
            goto L_0x000c
        L_0x00e8:
            com.igexin.a.a.d.f r3 = r11.c
            r3.g()
            goto L_0x000b
        L_0x00ef:
            com.igexin.a.a.d.f r2 = r11.c
            r2.g()
            boolean r2 = r4.s
            if (r2 != 0) goto L_0x00fb
            r4.c()
        L_0x00fb:
            boolean r2 = r4.j
            if (r2 != 0) goto L_0x0108
            boolean r2 = r4.o
            if (r2 != 0) goto L_0x0108
            r4.z = r6
            r0.a(r4)
        L_0x0108:
            throw r1
        L_0x0109:
            r3 = move-exception
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r7 = "TaskService|TASK_INIT|error|"
            r5.<init>(r7)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r3 = r5.append(r3)
            java.lang.String r3 = r3.toString()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            com.igexin.a.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r5)
            goto L_0x000b
        L_0x0124:
            r0.d()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.a.a.d.k.run():void");
    }
}
