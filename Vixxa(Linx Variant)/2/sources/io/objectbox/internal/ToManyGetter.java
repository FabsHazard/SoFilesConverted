package io.objectbox.internal;

import java.io.Serializable;
import java.util.List;

public interface ToManyGetter<SOURCE, TARGET> extends Serializable {
    List<TARGET> getToMany(SOURCE source);
}
