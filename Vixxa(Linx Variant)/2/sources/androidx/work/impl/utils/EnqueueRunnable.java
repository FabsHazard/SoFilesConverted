package androidx.work.impl.utils;

import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.Operation;
import androidx.work.impl.OperationImpl;
import androidx.work.impl.Schedulers;
import androidx.work.impl.WorkContinuationImpl;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.List;

public class EnqueueRunnable implements Runnable {
    private static final String TAG = Logger.tagWithPrefix("EnqueueRunnable");
    private final OperationImpl mOperation;
    private final WorkContinuationImpl mWorkContinuation;

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl) {
        this(workContinuationImpl, new OperationImpl());
    }

    public EnqueueRunnable(WorkContinuationImpl workContinuationImpl, OperationImpl operationImpl) {
        this.mWorkContinuation = workContinuationImpl;
        this.mOperation = operationImpl;
    }

    public void run() {
        try {
            if (!this.mWorkContinuation.hasCycles()) {
                if (addToDatabase()) {
                    PackageManagerHelper.setComponentEnabled(this.mWorkContinuation.getWorkManagerImpl().getApplicationContext(), RescheduleReceiver.class, true);
                    scheduleWorkInBackground();
                }
                this.mOperation.markState(Operation.SUCCESS);
                return;
            }
            throw new IllegalStateException("WorkContinuation has cycles (" + this.mWorkContinuation + ")");
        } catch (Throwable th) {
            this.mOperation.markState(new Operation.State.FAILURE(th));
        }
    }

    public Operation getOperation() {
        return this.mOperation;
    }

    public boolean addToDatabase() {
        WorkDatabase workDatabase = this.mWorkContinuation.getWorkManagerImpl().getWorkDatabase();
        workDatabase.beginTransaction();
        try {
            boolean processContinuation = processContinuation(this.mWorkContinuation);
            workDatabase.setTransactionSuccessful();
            return processContinuation;
        } finally {
            workDatabase.endTransaction();
        }
    }

    public void scheduleWorkInBackground() {
        WorkManagerImpl workManagerImpl = this.mWorkContinuation.getWorkManagerImpl();
        Schedulers.schedule(workManagerImpl.getConfiguration(), workManagerImpl.getWorkDatabase(), workManagerImpl.getSchedulers());
    }

    private static boolean processContinuation(WorkContinuationImpl workContinuationImpl) {
        List<WorkContinuationImpl> parents = workContinuationImpl.getParents();
        boolean z = false;
        if (parents != null) {
            for (WorkContinuationImpl next : parents) {
                if (!next.isEnqueued()) {
                    z |= processContinuation(next);
                } else {
                    Logger.get().warning(TAG, "Already enqueued work ids (" + TextUtils.join(", ", next.getIds()) + ")");
                }
            }
        }
        return enqueueContinuation(workContinuationImpl) | z;
    }

    private static boolean enqueueContinuation(WorkContinuationImpl workContinuationImpl) {
        boolean enqueueWorkWithPrerequisites = enqueueWorkWithPrerequisites(workContinuationImpl.getWorkManagerImpl(), workContinuationImpl.getWork(), (String[]) WorkContinuationImpl.prerequisitesFor(workContinuationImpl).toArray(new String[0]), workContinuationImpl.getName(), workContinuationImpl.getExistingWorkPolicy());
        workContinuationImpl.markEnqueued();
        return enqueueWorkWithPrerequisites;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0155  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl r16, java.util.List<? extends androidx.work.WorkRequest> r17, java.lang.String[] r18, java.lang.String r19, androidx.work.ExistingWorkPolicy r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = r20
            long r3 = java.lang.System.currentTimeMillis()
            androidx.work.impl.WorkDatabase r5 = r16.getWorkDatabase()
            r7 = 0
            if (r0 == 0) goto L_0x0016
            int r8 = r0.length
            if (r8 <= 0) goto L_0x0016
            r8 = 1
            goto L_0x0017
        L_0x0016:
            r8 = r7
        L_0x0017:
            if (r8 == 0) goto L_0x0063
            int r9 = r0.length
            r10 = r7
            r12 = r10
            r13 = r12
            r11 = 1
        L_0x001e:
            if (r10 >= r9) goto L_0x0066
            r14 = r0[r10]
            androidx.work.impl.model.WorkSpecDao r15 = r5.workSpecDao()
            androidx.work.impl.model.WorkSpec r15 = r15.getWorkSpec(r14)
            if (r15 != 0) goto L_0x004b
            androidx.work.Logger r0 = androidx.work.Logger.get()
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Prerequisite "
            r2.<init>(r3)
            java.lang.StringBuilder r2 = r2.append(r14)
            java.lang.String r3 = " doesn't exist; not enqueuing"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.error(r1, r2)
            return r7
        L_0x004b:
            androidx.work.WorkInfo$State r14 = r15.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r14 != r15) goto L_0x0053
            r15 = 1
            goto L_0x0054
        L_0x0053:
            r15 = r7
        L_0x0054:
            r11 = r11 & r15
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.FAILED
            if (r14 != r15) goto L_0x005b
            r13 = 1
            goto L_0x0060
        L_0x005b:
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.CANCELLED
            if (r14 != r15) goto L_0x0060
            r12 = 1
        L_0x0060:
            int r10 = r10 + 1
            goto L_0x001e
        L_0x0063:
            r12 = r7
            r13 = r12
            r11 = 1
        L_0x0066:
            boolean r9 = android.text.TextUtils.isEmpty(r19)
            if (r9 != 0) goto L_0x014a
            if (r8 != 0) goto L_0x014a
            androidx.work.impl.model.WorkSpecDao r10 = r5.workSpecDao()
            java.util.List r10 = r10.getWorkSpecIdAndStatesForName(r1)
            boolean r14 = r10.isEmpty()
            if (r14 != 0) goto L_0x014a
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND
            if (r2 == r14) goto L_0x00cc
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r14) goto L_0x0085
            goto L_0x00cc
        L_0x0085:
            androidx.work.ExistingWorkPolicy r14 = androidx.work.ExistingWorkPolicy.KEEP
            if (r2 != r14) goto L_0x00a6
            java.util.Iterator r2 = r10.iterator()
        L_0x008d:
            boolean r14 = r2.hasNext()
            if (r14 == 0) goto L_0x00a6
            java.lang.Object r14 = r2.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            androidx.work.WorkInfo$State r15 = r14.state
            androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.ENQUEUED
            if (r15 == r6) goto L_0x00a5
            androidx.work.WorkInfo$State r6 = r14.state
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.RUNNING
            if (r6 != r14) goto L_0x008d
        L_0x00a5:
            return r7
        L_0x00a6:
            r6 = r16
            androidx.work.impl.utils.CancelWorkRunnable r2 = androidx.work.impl.utils.CancelWorkRunnable.forName(r1, r6, r7)
            r2.run()
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.Iterator r10 = r10.iterator()
        L_0x00b7:
            boolean r14 = r10.hasNext()
            if (r14 == 0) goto L_0x00c9
            java.lang.Object r14 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r14 = (androidx.work.impl.model.WorkSpec.IdAndState) r14
            java.lang.String r14 = r14.id
            r2.delete(r14)
            goto L_0x00b7
        L_0x00c9:
            r2 = 1
            goto L_0x014b
        L_0x00cc:
            r6 = r16
            androidx.work.impl.model.DependencyDao r8 = r5.dependencyDao()
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x00db:
            boolean r15 = r10.hasNext()
            if (r15 == 0) goto L_0x0112
            java.lang.Object r15 = r10.next()
            androidx.work.impl.model.WorkSpec$IdAndState r15 = (androidx.work.impl.model.WorkSpec.IdAndState) r15
            java.lang.String r7 = r15.id
            boolean r7 = r8.hasDependents(r7)
            if (r7 != 0) goto L_0x010e
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r6 = androidx.work.WorkInfo.State.SUCCEEDED
            if (r7 != r6) goto L_0x00f7
            r6 = 1
            goto L_0x00f8
        L_0x00f7:
            r6 = 0
        L_0x00f8:
            r6 = r6 & r11
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.FAILED
            if (r7 != r11) goto L_0x0101
            r13 = 1
            goto L_0x0108
        L_0x0101:
            androidx.work.WorkInfo$State r7 = r15.state
            androidx.work.WorkInfo$State r11 = androidx.work.WorkInfo.State.CANCELLED
            if (r7 != r11) goto L_0x0108
            r12 = 1
        L_0x0108:
            java.lang.String r7 = r15.id
            r14.add(r7)
            r11 = r6
        L_0x010e:
            r6 = r16
            r7 = 0
            goto L_0x00db
        L_0x0112:
            androidx.work.ExistingWorkPolicy r6 = androidx.work.ExistingWorkPolicy.APPEND_OR_REPLACE
            if (r2 != r6) goto L_0x013e
            if (r12 != 0) goto L_0x011a
            if (r13 == 0) goto L_0x013e
        L_0x011a:
            androidx.work.impl.model.WorkSpecDao r2 = r5.workSpecDao()
            java.util.List r6 = r2.getWorkSpecIdAndStatesForName(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x0126:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0138
            java.lang.Object r7 = r6.next()
            androidx.work.impl.model.WorkSpec$IdAndState r7 = (androidx.work.impl.model.WorkSpec.IdAndState) r7
            java.lang.String r7 = r7.id
            r2.delete(r7)
            goto L_0x0126
        L_0x0138:
            java.util.List r14 = java.util.Collections.emptyList()
            r12 = 0
            r13 = 0
        L_0x013e:
            java.lang.Object[] r0 = r14.toArray(r0)
            java.lang.String[] r0 = (java.lang.String[]) r0
            int r2 = r0.length
            if (r2 <= 0) goto L_0x0149
            r8 = 1
            goto L_0x014a
        L_0x0149:
            r8 = 0
        L_0x014a:
            r2 = 0
        L_0x014b:
            java.util.Iterator r6 = r17.iterator()
        L_0x014f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x01dc
            java.lang.Object r7 = r6.next()
            androidx.work.WorkRequest r7 = (androidx.work.WorkRequest) r7
            androidx.work.impl.model.WorkSpec r10 = r7.getWorkSpec()
            if (r8 == 0) goto L_0x0176
            if (r11 != 0) goto L_0x0176
            if (r13 == 0) goto L_0x016a
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.FAILED
            r10.state = r14
            goto L_0x0178
        L_0x016a:
            if (r12 == 0) goto L_0x0171
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.CANCELLED
            r10.state = r14
            goto L_0x0178
        L_0x0171:
            androidx.work.WorkInfo$State r14 = androidx.work.WorkInfo.State.BLOCKED
            r10.state = r14
            goto L_0x0178
        L_0x0176:
            r10.lastEnqueueTime = r3
        L_0x0178:
            androidx.work.WorkInfo$State r14 = r10.state
            androidx.work.WorkInfo$State r15 = androidx.work.WorkInfo.State.ENQUEUED
            if (r14 != r15) goto L_0x017f
            r2 = 1
        L_0x017f:
            androidx.work.impl.model.WorkSpecDao r14 = r5.workSpecDao()
            java.util.List r15 = r16.getSchedulers()
            androidx.work.impl.model.WorkSpec r10 = androidx.work.impl.utils.EnqueueUtilsKt.wrapInConstraintTrackingWorkerIfNeeded(r15, r10)
            r14.insertWorkSpec(r10)
            if (r8 == 0) goto L_0x01b1
            int r10 = r0.length
            r14 = 0
        L_0x0192:
            if (r14 >= r10) goto L_0x01b1
            r15 = r0[r14]
            r18 = r0
            androidx.work.impl.model.Dependency r0 = new androidx.work.impl.model.Dependency
            r17 = r2
            java.lang.String r2 = r7.getStringId()
            r0.<init>(r2, r15)
            androidx.work.impl.model.DependencyDao r2 = r5.dependencyDao()
            r2.insertDependency(r0)
            int r14 = r14 + 1
            r2 = r17
            r0 = r18
            goto L_0x0192
        L_0x01b1:
            r18 = r0
            r17 = r2
            androidx.work.impl.model.WorkTagDao r0 = r5.workTagDao()
            java.lang.String r2 = r7.getStringId()
            java.util.Set r10 = r7.getTags()
            r0.insertTags(r2, r10)
            if (r9 != 0) goto L_0x01d6
            androidx.work.impl.model.WorkNameDao r0 = r5.workNameDao()
            androidx.work.impl.model.WorkName r2 = new androidx.work.impl.model.WorkName
            java.lang.String r7 = r7.getStringId()
            r2.<init>(r1, r7)
            r0.insert(r2)
        L_0x01d6:
            r2 = r17
            r0 = r18
            goto L_0x014f
        L_0x01dc:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.utils.EnqueueRunnable.enqueueWorkWithPrerequisites(androidx.work.impl.WorkManagerImpl, java.util.List, java.lang.String[], java.lang.String, androidx.work.ExistingWorkPolicy):boolean");
    }
}
