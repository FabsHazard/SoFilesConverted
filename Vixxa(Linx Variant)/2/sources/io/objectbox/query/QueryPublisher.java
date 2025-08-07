package io.objectbox.query;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.reactive.DataObserver;
import io.objectbox.reactive.DataPublisher;
import io.objectbox.reactive.DataPublisherUtils;
import io.objectbox.reactive.DataSubscription;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

class QueryPublisher<T> implements DataPublisher<List<T>>, Runnable {
    private final SubscribedObservers<T> SUBSCRIBED_OBSERVERS = new SubscribedObservers<>();
    private final Box<T> box;
    private DataObserver<Class<T>> objectClassObserver;
    private DataSubscription objectClassSubscription;
    private final Set<DataObserver<List<T>>> observers = new CopyOnWriteArraySet();
    private final Deque<DataObserver<List<T>>> publishQueue = new ArrayDeque();
    private volatile boolean publisherRunning = false;
    private final Query<T> query;

    private static class SubscribedObservers<T> implements DataObserver<List<T>> {
        public void onData(List<T> list) {
        }

        private SubscribedObservers() {
        }
    }

    QueryPublisher(Query<T> query2, Box<T> box2) {
        this.query = query2;
        this.box = box2;
    }

    public synchronized void subscribe(DataObserver<List<T>> dataObserver, @Nullable Object obj) {
        BoxStore store = this.box.getStore();
        if (this.objectClassObserver == null) {
            this.objectClassObserver = new QueryPublisher$$ExternalSyntheticLambda0(this);
        }
        if (this.observers.isEmpty()) {
            if (this.objectClassSubscription == null) {
                this.objectClassSubscription = store.subscribe(this.box.getEntityClass()).weak().onlyChanges().observer(this.objectClassObserver);
            } else {
                throw new IllegalStateException("Existing subscription found");
            }
        }
        this.observers.add(dataObserver);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$subscribe$0$io-objectbox-query-QueryPublisher  reason: not valid java name */
    public /* synthetic */ void m334lambda$subscribe$0$ioobjectboxqueryQueryPublisher(Class cls) {
        publish();
    }

    public void publishSingle(DataObserver<List<T>> dataObserver, @Nullable Object obj) {
        queueObserverAndScheduleRun(dataObserver);
    }

    /* access modifiers changed from: package-private */
    public void publish() {
        queueObserverAndScheduleRun(this.SUBSCRIBED_OBSERVERS);
    }

    private void queueObserverAndScheduleRun(DataObserver<List<T>> dataObserver) {
        synchronized (this.publishQueue) {
            this.publishQueue.add(dataObserver);
            if (!this.publisherRunning) {
                this.publisherRunning = true;
                this.box.getStore().internalScheduleThread(this);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (r3 != false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r1.isEmpty() == false) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r6.publisherRunning = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002d, code lost:
        r6.publisherRunning = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r2 = r6.query.find();
        r1 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        if (r1.hasNext() == false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0041, code lost:
        ((io.objectbox.reactive.DataObserver) r1.next()).onData(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r3 == false) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004d, code lost:
        r1 = r6.observers.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0057, code lost:
        if (r1.hasNext() == false) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0059, code lost:
        r1.next().onData(r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r6 = this;
        L_0x0000:
            r0 = 0
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0066 }
            r1.<init>()     // Catch:{ all -> 0x0066 }
            java.util.Deque<io.objectbox.reactive.DataObserver<java.util.List<T>>> r2 = r6.publishQueue     // Catch:{ all -> 0x0066 }
            monitor-enter(r2)     // Catch:{ all -> 0x0066 }
            r3 = r0
        L_0x000a:
            java.util.Deque<io.objectbox.reactive.DataObserver<java.util.List<T>>> r4 = r6.publishQueue     // Catch:{ all -> 0x0063 }
            java.lang.Object r4 = r4.poll()     // Catch:{ all -> 0x0063 }
            io.objectbox.reactive.DataObserver r4 = (io.objectbox.reactive.DataObserver) r4     // Catch:{ all -> 0x0063 }
            if (r4 == 0) goto L_0x0022
            io.objectbox.query.QueryPublisher$SubscribedObservers<T> r5 = r6.SUBSCRIBED_OBSERVERS     // Catch:{ all -> 0x0063 }
            boolean r5 = r5.equals(r4)     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x001e
            r3 = 1
            goto L_0x000a
        L_0x001e:
            r1.add(r4)     // Catch:{ all -> 0x0063 }
            goto L_0x000a
        L_0x0022:
            if (r3 != 0) goto L_0x0030
            boolean r4 = r1.isEmpty()     // Catch:{ all -> 0x0063 }
            if (r4 == 0) goto L_0x0030
            r6.publisherRunning = r0     // Catch:{ all -> 0x0063 }
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            r6.publisherRunning = r0
            return
        L_0x0030:
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            io.objectbox.query.Query<T> r2 = r6.query     // Catch:{ all -> 0x0066 }
            java.util.List r2 = r2.find()     // Catch:{ all -> 0x0066 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0066 }
        L_0x003b:
            boolean r4 = r1.hasNext()     // Catch:{ all -> 0x0066 }
            if (r4 == 0) goto L_0x004b
            java.lang.Object r4 = r1.next()     // Catch:{ all -> 0x0066 }
            io.objectbox.reactive.DataObserver r4 = (io.objectbox.reactive.DataObserver) r4     // Catch:{ all -> 0x0066 }
            r4.onData(r2)     // Catch:{ all -> 0x0066 }
            goto L_0x003b
        L_0x004b:
            if (r3 == 0) goto L_0x0000
            java.util.Set<io.objectbox.reactive.DataObserver<java.util.List<T>>> r1 = r6.observers     // Catch:{ all -> 0x0066 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0066 }
        L_0x0053:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x0066 }
            if (r3 == 0) goto L_0x0000
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x0066 }
            io.objectbox.reactive.DataObserver r3 = (io.objectbox.reactive.DataObserver) r3     // Catch:{ all -> 0x0066 }
            r3.onData(r2)     // Catch:{ all -> 0x0066 }
            goto L_0x0053
        L_0x0063:
            r1 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0063 }
            throw r1     // Catch:{ all -> 0x0066 }
        L_0x0066:
            r1 = move-exception
            r6.publisherRunning = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.query.QueryPublisher.run():void");
    }

    public synchronized void unsubscribe(DataObserver<List<T>> dataObserver, @Nullable Object obj) {
        DataPublisherUtils.removeObserverFromCopyOnWriteSet(this.observers, dataObserver);
        if (this.observers.isEmpty()) {
            this.objectClassSubscription.cancel();
            this.objectClassSubscription = null;
        }
    }
}
