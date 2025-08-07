package io.objectbox.internal;

import io.objectbox.relation.ToOne;
import java.io.Serializable;

public interface ToOneGetter<SOURCE, TARGET> extends Serializable {
    ToOne<TARGET> getToOne(SOURCE source);
}
