package io.objectbox.reactive;

public interface DataTransformer<FROM, TO> {
    TO transform(FROM from) throws Exception;
}
