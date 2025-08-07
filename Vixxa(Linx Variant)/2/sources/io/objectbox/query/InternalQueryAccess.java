package io.objectbox.query;

public class InternalQueryAccess {
    public static <T> void nativeFindFirst(Query<T> query, long j) {
        query.nativeFindFirst(query.handle, j);
    }
}
