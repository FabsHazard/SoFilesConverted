package com.huawei.hms.framework.common;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorsEnhance {
    public static ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory) {
        ThreadPoolExcutorEnhance threadPoolExcutorEnhance = new ThreadPoolExcutorEnhance(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        threadPoolExcutorEnhance.allowCoreThreadTimeOut(true);
        return new FinalizableDelegatedExecutorService(threadPoolExcutorEnhance);
    }

    private static class FinalizableDelegatedExecutorService extends DelegatedExecutorService {
        FinalizableDelegatedExecutorService(ExecutorService executorService) {
            super(executorService);
        }

        /* access modifiers changed from: protected */
        public void finalize() {
            super.shutdown();
        }
    }

    private static class DelegatedExecutorService extends AbstractExecutorService {
        private final ExecutorService executorService;

        DelegatedExecutorService(ExecutorService executorService2) {
            this.executorService = executorService2;
        }

        public void execute(Runnable runnable) {
            this.executorService.execute(runnable);
        }

        public void shutdown() {
            this.executorService.shutdown();
        }

        public List<Runnable> shutdownNow() {
            return this.executorService.shutdownNow();
        }

        public boolean isShutdown() {
            return this.executorService.isShutdown();
        }

        public boolean isTerminated() {
            return this.executorService.isTerminated();
        }

        public <T> Future<T> submit(Runnable runnable, T t) {
            return this.executorService.submit(runnable, t);
        }

        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.executorService.awaitTermination(j, timeUnit);
        }

        public <T> Future<T> submit(Callable<T> callable) {
            return this.executorService.submit(callable);
        }

        public Future<?> submit(Runnable runnable) {
            return this.executorService.submit(runnable);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
            return this.executorService.invokeAll(collection, j, timeUnit);
        }

        public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
            return this.executorService.invokeAll(collection);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return this.executorService.invokeAny(collection, j, timeUnit);
        }

        public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
            return this.executorService.invokeAny(collection);
        }
    }
}
