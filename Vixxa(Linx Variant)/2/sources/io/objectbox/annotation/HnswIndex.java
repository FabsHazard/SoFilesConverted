package io.objectbox.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
public @interface HnswIndex {
    long dimensions();

    VectorDistanceType distanceType() default VectorDistanceType.DEFAULT;

    HnswFlags flags() default @HnswFlags;

    long indexingSearchCount() default 0;

    long neighborsPerNode() default 0;

    float reparationBacklinkProbability() default 1.0f;

    long vectorCacheHintSizeKB() default 0;
}
