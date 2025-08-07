package io.objectbox;

import io.objectbox.reactive.DataObserver;
import io.objectbox.reactive.DataPublisher;
import io.objectbox.reactive.DataPublisherUtils;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;
import javax.annotation.Nullable;
import org.greenrobot.essentials.collections.MultimapSet;

class ObjectClassPublisher implements DataPublisher<Class>, Runnable {
    final BoxStore boxStore;
    volatile boolean changePublisherRunning;
    private final Deque<PublishRequest> changesQueue = new ArrayDeque();
    final MultimapSet<Integer, DataObserver<Class>> observersByEntityTypeId = MultimapSet.create(MultimapSet.SetType.THREAD_SAFE);

    private static class PublishRequest {
        /* access modifiers changed from: private */
        public final int[] entityTypeIds;
        /* access modifiers changed from: private */
        @Nullable
        public final DataObserver<Class> observer;

        PublishRequest(@Nullable DataObserver<Class> dataObserver, int[] iArr) {
            this.observer = dataObserver;
            this.entityTypeIds = iArr;
        }
    }

    ObjectClassPublisher(BoxStore boxStore2) {
        this.boxStore = boxStore2;
    }

    public void subscribe(DataObserver<Class> dataObserver, @Nullable Object obj) {
        if (obj == null) {
            for (int valueOf : this.boxStore.getAllEntityTypeIds()) {
                this.observersByEntityTypeId.putElement(Integer.valueOf(valueOf), dataObserver);
            }
            return;
        }
        this.observersByEntityTypeId.putElement(Integer.valueOf(this.boxStore.getEntityTypeIdOrThrow((Class) obj)), dataObserver);
    }

    public void unsubscribe(DataObserver<Class> dataObserver, @Nullable Object obj) {
        if (obj != null) {
            unsubscribe(dataObserver, this.boxStore.getEntityTypeIdOrThrow((Class) obj));
            return;
        }
        for (int unsubscribe : this.boxStore.getAllEntityTypeIds()) {
            unsubscribe(dataObserver, unsubscribe);
        }
    }

    private void unsubscribe(DataObserver<Class> dataObserver, int i) {
        DataPublisherUtils.removeObserverFromCopyOnWriteSet((Set) this.observersByEntityTypeId.get((Object) Integer.valueOf(i)), dataObserver);
    }

    public void publishSingle(DataObserver<Class> dataObserver, @Nullable Object obj) {
        queuePublishRequestAndScheduleRun(dataObserver, obj != null ? new int[]{this.boxStore.getEntityTypeIdOrThrow((Class) obj)} : this.boxStore.getAllEntityTypeIds());
    }

    /* access modifiers changed from: package-private */
    public void publish(int[] iArr) {
        queuePublishRequestAndScheduleRun((DataObserver<Class>) null, iArr);
    }

    private void queuePublishRequestAndScheduleRun(@Nullable DataObserver<Class> dataObserver, int[] iArr) {
        synchronized (this.changesQueue) {
            this.changesQueue.add(new PublishRequest(dataObserver, iArr));
            if (!this.changePublisherRunning) {
                this.changePublisherRunning = true;
                this.boxStore.internalScheduleThread(this);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r1 = io.objectbox.ObjectClassPublisher.PublishRequest.access$000(r2);
        r3 = r1.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001b, code lost:
        if (r4 >= r3) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
        r5 = r1[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0023, code lost:
        if (io.objectbox.ObjectClassPublisher.PublishRequest.access$100(r2) == null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0025, code lost:
        r6 = java.util.Collections.singletonList(io.objectbox.ObjectClassPublisher.PublishRequest.access$100(r2));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        r6 = r8.observersByEntityTypeId.get((java.lang.Object) java.lang.Integer.valueOf(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0038, code lost:
        if (r6 == null) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (r6.isEmpty() == false) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0041, code lost:
        r5 = r8.boxStore.getEntityClassOrThrow(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r6 = r6.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        if (r6.hasNext() == false) goto L_0x005e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0051, code lost:
        ((io.objectbox.reactive.DataObserver) r6.next()).onData(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        handleObserverException(r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x005b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
        L_0x0000:
            r0 = 0
            java.util.Deque<io.objectbox.ObjectClassPublisher$PublishRequest> r1 = r8.changesQueue     // Catch:{ all -> 0x0064 }
            monitor-enter(r1)     // Catch:{ all -> 0x0064 }
            java.util.Deque<io.objectbox.ObjectClassPublisher$PublishRequest> r2 = r8.changesQueue     // Catch:{ all -> 0x0061 }
            java.lang.Object r2 = r2.pollFirst()     // Catch:{ all -> 0x0061 }
            io.objectbox.ObjectClassPublisher$PublishRequest r2 = (io.objectbox.ObjectClassPublisher.PublishRequest) r2     // Catch:{ all -> 0x0061 }
            if (r2 != 0) goto L_0x0014
            r8.changePublisherRunning = r0     // Catch:{ all -> 0x0061 }
            monitor-exit(r1)     // Catch:{ all -> 0x0061 }
            r8.changePublisherRunning = r0
            return
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x0061 }
            int[] r1 = r2.entityTypeIds     // Catch:{ all -> 0x0064 }
            int r3 = r1.length     // Catch:{ all -> 0x0064 }
            r4 = r0
        L_0x001b:
            if (r4 >= r3) goto L_0x0000
            r5 = r1[r4]     // Catch:{ all -> 0x0064 }
            io.objectbox.reactive.DataObserver r6 = r2.observer     // Catch:{ all -> 0x0064 }
            if (r6 == 0) goto L_0x002e
            io.objectbox.reactive.DataObserver r6 = r2.observer     // Catch:{ all -> 0x0064 }
            java.util.List r6 = java.util.Collections.singletonList(r6)     // Catch:{ all -> 0x0064 }
            goto L_0x0038
        L_0x002e:
            org.greenrobot.essentials.collections.MultimapSet<java.lang.Integer, io.objectbox.reactive.DataObserver<java.lang.Class>> r6 = r8.observersByEntityTypeId     // Catch:{ all -> 0x0064 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0064 }
            java.util.Collection r6 = r6.get((java.lang.Object) r7)     // Catch:{ all -> 0x0064 }
        L_0x0038:
            if (r6 == 0) goto L_0x005e
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0064 }
            if (r7 == 0) goto L_0x0041
            goto L_0x005e
        L_0x0041:
            io.objectbox.BoxStore r7 = r8.boxStore     // Catch:{ all -> 0x0064 }
            java.lang.Class r5 = r7.getEntityClassOrThrow(r5)     // Catch:{ all -> 0x0064 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ RuntimeException -> 0x005b }
        L_0x004b:
            boolean r7 = r6.hasNext()     // Catch:{ RuntimeException -> 0x005b }
            if (r7 == 0) goto L_0x005e
            java.lang.Object r7 = r6.next()     // Catch:{ RuntimeException -> 0x005b }
            io.objectbox.reactive.DataObserver r7 = (io.objectbox.reactive.DataObserver) r7     // Catch:{ RuntimeException -> 0x005b }
            r7.onData(r5)     // Catch:{ RuntimeException -> 0x005b }
            goto L_0x004b
        L_0x005b:
            r8.handleObserverException(r5)     // Catch:{ all -> 0x0064 }
        L_0x005e:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0061:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0061 }
            throw r2     // Catch:{ all -> 0x0064 }
        L_0x0064:
            r1 = move-exception
            r8.changePublisherRunning = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.objectbox.ObjectClassPublisher.run():void");
    }

    private void handleObserverException(Class cls) {
        RuntimeException runtimeException = new RuntimeException("Observer failed while processing data for " + cls + ". Consider using an ErrorObserver");
        runtimeException.printStackTrace();
        throw runtimeException;
    }
}
