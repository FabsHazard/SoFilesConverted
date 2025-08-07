package io.objectbox.kotlin;

import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\u0010\n\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0002\b\u0004\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\b\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\b\u001a?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\b\u001a?\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\b\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\b\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\b\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\b\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\b\u001a7\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\b\u001a7\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\b\u001aJ\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\b¢\u0006\u0002\u0010\u0015\u001a7\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0016H\b\u001a7\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0017H\b\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\b\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\b\u001a7\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\b\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0006H\b\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\b\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\b\u001a7\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\bH\b\u001a7\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\b¨\u0006\u001b"}, d2 = {"between", "Lio/objectbox/query/QueryBuilder;", "T", "property", "Lio/objectbox/Property;", "value1", "", "value2", "", "", "equal", "value", "tolerance", "greater", "greaterOrEqual", "inValues", "values", "", "", "stringOrder", "Lio/objectbox/query/QueryBuilder$StringOrder;", "(Lio/objectbox/query/QueryBuilder;Lio/objectbox/Property;[Ljava/lang/String;Lio/objectbox/query/QueryBuilder$StringOrder;)Lio/objectbox/query/QueryBuilder;", "", "", "less", "lessOrEqual", "notEqual", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: QueryBuilder.kt */
public final class QueryBuilderKt {
    public static final /* synthetic */ <T> QueryBuilder<T> inValues(QueryBuilder<T> queryBuilder, Property<T> property, long[] jArr) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(jArr, "values");
        QueryBuilder<T> in = queryBuilder.in(property, jArr);
        Intrinsics.checkNotNullExpressionValue(in, "`in`(property, values)");
        return in;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> inValues(QueryBuilder<T> queryBuilder, Property<T> property, int[] iArr) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(iArr, "values");
        QueryBuilder<T> in = queryBuilder.in(property, iArr);
        Intrinsics.checkNotNullExpressionValue(in, "`in`(property, values)");
        return in;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> inValues(QueryBuilder<T> queryBuilder, Property<T> property, String[] strArr, QueryBuilder.StringOrder stringOrder) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(strArr, "values");
        Intrinsics.checkNotNullParameter(stringOrder, "stringOrder");
        QueryBuilder<T> in = queryBuilder.in(property, strArr, stringOrder);
        Intrinsics.checkNotNullExpressionValue(in, "`in`(property, values, stringOrder)");
        return in;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> equal(QueryBuilder<T> queryBuilder, Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> equal = queryBuilder.equal(property, (long) s);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(property, value.toLong())");
        return equal;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> notEqual(QueryBuilder<T> queryBuilder, Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> notEqual = queryBuilder.notEqual(property, (long) s);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(property, value.toLong())");
        return notEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> less(QueryBuilder<T> queryBuilder, Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> less = queryBuilder.less(property, (long) s);
        Intrinsics.checkNotNullExpressionValue(less, "less(property, value.toLong())");
        return less;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> lessOrEqual(QueryBuilder<T> queryBuilder, Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> lessOrEqual = queryBuilder.lessOrEqual(property, (long) s);
        Intrinsics.checkNotNullExpressionValue(lessOrEqual, "lessOrEqual(property, value.toLong())");
        return lessOrEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> greater(QueryBuilder<T> queryBuilder, Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> greater = queryBuilder.greater(property, (long) s);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(property, value.toLong())");
        return greater;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> greaterOrEqual(QueryBuilder<T> queryBuilder, Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> greaterOrEqual = queryBuilder.greaterOrEqual(property, (long) s);
        Intrinsics.checkNotNullExpressionValue(greaterOrEqual, "greaterOrEqual(property, value.toLong())");
        return greaterOrEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> between(QueryBuilder<T> queryBuilder, Property<T> property, short s, short s2) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> between = queryBuilder.between(property, (long) s, (long) s2);
        Intrinsics.checkNotNullExpressionValue(between, "between(property, value1…oLong(), value2.toLong())");
        return between;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> equal(QueryBuilder<T> queryBuilder, Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> equal = queryBuilder.equal(property, (long) i);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(property, value.toLong())");
        return equal;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> notEqual(QueryBuilder<T> queryBuilder, Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> notEqual = queryBuilder.notEqual(property, (long) i);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(property, value.toLong())");
        return notEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> less(QueryBuilder<T> queryBuilder, Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> less = queryBuilder.less(property, (long) i);
        Intrinsics.checkNotNullExpressionValue(less, "less(property, value.toLong())");
        return less;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> lessOrEqual(QueryBuilder<T> queryBuilder, Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> lessOrEqual = queryBuilder.lessOrEqual(property, (long) i);
        Intrinsics.checkNotNullExpressionValue(lessOrEqual, "lessOrEqual(property, value.toLong())");
        return lessOrEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> greater(QueryBuilder<T> queryBuilder, Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> greater = queryBuilder.greater(property, (long) i);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(property, value.toLong())");
        return greater;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> greaterOrEqual(QueryBuilder<T> queryBuilder, Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> greaterOrEqual = queryBuilder.greaterOrEqual(property, (long) i);
        Intrinsics.checkNotNullExpressionValue(greaterOrEqual, "greaterOrEqual(property, value.toLong())");
        return greaterOrEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> between(QueryBuilder<T> queryBuilder, Property<T> property, int i, int i2) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> between = queryBuilder.between(property, (long) i, (long) i2);
        Intrinsics.checkNotNullExpressionValue(between, "between(property, value1…oLong(), value2.toLong())");
        return between;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> equal(QueryBuilder<T> queryBuilder, Property<T> property, float f, float f2) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> equal = queryBuilder.equal(property, (double) f, (double) f2);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(property, value.to…(), tolerance.toDouble())");
        return equal;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> less(QueryBuilder<T> queryBuilder, Property<T> property, float f) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> less = queryBuilder.less(property, (double) f);
        Intrinsics.checkNotNullExpressionValue(less, "less(property, value.toDouble())");
        return less;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> lessOrEqual(QueryBuilder<T> queryBuilder, Property<T> property, float f) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> lessOrEqual = queryBuilder.lessOrEqual(property, (double) f);
        Intrinsics.checkNotNullExpressionValue(lessOrEqual, "lessOrEqual(property, value.toDouble())");
        return lessOrEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> greater(QueryBuilder<T> queryBuilder, Property<T> property, float f) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> greater = queryBuilder.greater(property, (double) f);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(property, value.toDouble())");
        return greater;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> greaterOrEqual(QueryBuilder<T> queryBuilder, Property<T> property, float f) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> greaterOrEqual = queryBuilder.greaterOrEqual(property, (double) f);
        Intrinsics.checkNotNullExpressionValue(greaterOrEqual, "greaterOrEqual(property, value.toDouble())");
        return greaterOrEqual;
    }

    public static final /* synthetic */ <T> QueryBuilder<T> between(QueryBuilder<T> queryBuilder, Property<T> property, float f, float f2) {
        Intrinsics.checkNotNullParameter(queryBuilder, "<this>");
        Intrinsics.checkNotNullParameter(property, "property");
        QueryBuilder<T> between = queryBuilder.between(property, (double) f, (double) f2);
        Intrinsics.checkNotNullExpressionValue(between, "between(property, value1…ble(), value2.toDouble())");
        return between;
    }
}
