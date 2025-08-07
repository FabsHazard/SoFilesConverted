package io.objectbox.reactive;

public interface Scheduler {
    <T> void run(RunWithParam<T> runWithParam, T t);
}
