package io.objectbox.query;

public class ObjectWithScore<T> {
    private final T object;
    private final double score;

    public ObjectWithScore(T t, double d) {
        this.object = t;
        this.score = d;
    }

    public T get() {
        return this.object;
    }

    public double getScore() {
        return this.score;
    }
}
