package io.objectbox.query;

public class QueryThreadLocal<T> extends ThreadLocal<Query<T>> {
    private final Query<T> original;

    public QueryThreadLocal(Query<T> query) {
        this.original = query;
    }

    /* access modifiers changed from: protected */
    public Query<T> initialValue() {
        return this.original.copy();
    }
}
