package io.objectbox.reactive;

import javax.annotation.Nullable;

public class SubscriptionBuilder<T> {
    private DataSubscriptionList dataSubscriptionList;
    /* access modifiers changed from: private */
    public ErrorObserver errorObserver;
    /* access modifiers changed from: private */
    public DataObserver<T> observer;
    private boolean onlyChanges;
    private final DataPublisher<T> publisher;
    private final Object publisherParam;
    /* access modifiers changed from: private */
    public Scheduler scheduler;
    private boolean single;
    /* access modifiers changed from: private */
    public DataTransformer<T, Object> transformer;
    private boolean weak;

    public SubscriptionBuilder(DataPublisher<T> dataPublisher, @Nullable Object obj) {
        this.publisher = dataPublisher;
        this.publisherParam = obj;
    }

    public SubscriptionBuilder<T> weak() {
        this.weak = true;
        return this;
    }

    public SubscriptionBuilder<T> single() {
        this.single = true;
        return this;
    }

    public SubscriptionBuilder<T> onlyChanges() {
        this.onlyChanges = true;
        return this;
    }

    public <TO> SubscriptionBuilder<TO> transform(DataTransformer<T, TO> dataTransformer) {
        if (this.transformer == null) {
            this.transformer = dataTransformer;
            return this;
        }
        throw new IllegalStateException("Only one transformer allowed");
    }

    public SubscriptionBuilder<T> onError(ErrorObserver errorObserver2) {
        if (this.errorObserver == null) {
            this.errorObserver = errorObserver2;
            return this;
        }
        throw new IllegalStateException("Only one errorObserver allowed");
    }

    public SubscriptionBuilder<T> on(Scheduler scheduler2) {
        if (this.scheduler == null) {
            this.scheduler = scheduler2;
            return this;
        }
        throw new IllegalStateException("Only one scheduler allowed");
    }

    public DataSubscription observer(DataObserver<T> dataObserver) {
        WeakDataObserver weakDataObserver;
        if (this.weak) {
            weakDataObserver = new WeakDataObserver(dataObserver);
            dataObserver = weakDataObserver;
        } else {
            weakDataObserver = null;
        }
        this.observer = dataObserver;
        DataSubscriptionImpl dataSubscriptionImpl = new DataSubscriptionImpl(this.publisher, this.publisherParam, dataObserver);
        if (weakDataObserver != null) {
            weakDataObserver.setSubscription(dataSubscriptionImpl);
        }
        DataSubscriptionList dataSubscriptionList2 = this.dataSubscriptionList;
        if (dataSubscriptionList2 != null) {
            dataSubscriptionList2.add(dataSubscriptionImpl);
        }
        if (!(this.transformer == null && this.scheduler == null && this.errorObserver == null)) {
            dataObserver = new ActionObserver(dataSubscriptionImpl);
        }
        if (!this.single) {
            this.publisher.subscribe(dataObserver, this.publisherParam);
            if (!this.onlyChanges) {
                this.publisher.publishSingle(dataObserver, this.publisherParam);
            }
        } else if (!this.onlyChanges) {
            this.publisher.publishSingle(dataObserver, this.publisherParam);
        } else {
            throw new IllegalStateException("Illegal combination of single() and onlyChanges()");
        }
        return dataSubscriptionImpl;
    }

    public SubscriptionBuilder<T> dataSubscriptionList(DataSubscriptionList dataSubscriptionList2) {
        this.dataSubscriptionList = dataSubscriptionList2;
        return this;
    }

    class ActionObserver implements DataObserver<T>, DelegatingObserver<T> {
        private SubscriptionBuilder<T>.ActionObserver.SchedulerRunOnChange schedulerRunOnData;
        private SubscriptionBuilder<T>.ActionObserver.SchedulerRunOnError schedulerRunOnError;
        /* access modifiers changed from: private */
        public final DataSubscriptionImpl subscription;

        public ActionObserver(DataSubscriptionImpl dataSubscriptionImpl) {
            this.subscription = dataSubscriptionImpl;
            if (SubscriptionBuilder.this.scheduler != null) {
                this.schedulerRunOnData = new SchedulerRunOnChange();
                if (SubscriptionBuilder.this.errorObserver != null) {
                    this.schedulerRunOnError = new SchedulerRunOnError();
                }
            }
        }

        public void onData(T t) {
            if (SubscriptionBuilder.this.transformer != null) {
                transformAndContinue(t);
            } else {
                callOnData(t);
            }
        }

        private void transformAndContinue(T t) {
            if (!this.subscription.isCanceled()) {
                try {
                    callOnData(SubscriptionBuilder.this.transformer.transform(t));
                } catch (Throwable th) {
                    callOnError(th, "Transformer failed without an ErrorObserver set");
                }
            }
        }

        /* access modifiers changed from: private */
        public void callOnError(Throwable th, String str) {
            if (SubscriptionBuilder.this.errorObserver == null) {
                RuntimeException runtimeException = new RuntimeException(str, th);
                runtimeException.printStackTrace();
                throw runtimeException;
            } else if (this.subscription.isCanceled()) {
            } else {
                if (SubscriptionBuilder.this.scheduler != null) {
                    SubscriptionBuilder.this.scheduler.run(this.schedulerRunOnError, th);
                } else {
                    SubscriptionBuilder.this.errorObserver.onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void callOnData(T t) {
            if (this.subscription.isCanceled()) {
                return;
            }
            if (SubscriptionBuilder.this.scheduler != null) {
                SubscriptionBuilder.this.scheduler.run(this.schedulerRunOnData, t);
                return;
            }
            try {
                SubscriptionBuilder.this.observer.onData(t);
            } catch (Error | RuntimeException e) {
                callOnError(e, "Observer failed without an ErrorObserver set");
            }
        }

        public DataObserver<T> getObserverDelegate() {
            return SubscriptionBuilder.this.observer;
        }

        class SchedulerRunOnChange implements RunWithParam<T> {
            SchedulerRunOnChange() {
            }

            public void run(T t) {
                if (!ActionObserver.this.subscription.isCanceled()) {
                    try {
                        SubscriptionBuilder.this.observer.onData(t);
                    } catch (Error | RuntimeException e) {
                        ActionObserver.this.callOnError(e, "Observer failed without an ErrorObserver set");
                    }
                }
            }
        }

        class SchedulerRunOnError implements RunWithParam<Throwable> {
            SchedulerRunOnError() {
            }

            public void run(Throwable th) {
                if (!ActionObserver.this.subscription.isCanceled()) {
                    SubscriptionBuilder.this.errorObserver.onError(th);
                }
            }
        }
    }
}
