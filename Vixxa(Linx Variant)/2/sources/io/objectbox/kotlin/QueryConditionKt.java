package io.objectbox.kotlin;

import io.objectbox.query.QueryCondition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0004\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0004¨\u0006\u0005"}, d2 = {"and", "Lio/objectbox/query/QueryCondition;", "T", "queryCondition", "or", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: QueryCondition.kt */
public final class QueryConditionKt {
    public static final <T> QueryCondition<T> and(QueryCondition<T> queryCondition, QueryCondition<T> queryCondition2) {
        Intrinsics.checkNotNullParameter(queryCondition, "<this>");
        Intrinsics.checkNotNullParameter(queryCondition2, "queryCondition");
        QueryCondition<T> and = queryCondition.and(queryCondition2);
        Intrinsics.checkNotNullExpressionValue(and, "and(queryCondition)");
        return and;
    }

    public static final <T> QueryCondition<T> or(QueryCondition<T> queryCondition, QueryCondition<T> queryCondition2) {
        Intrinsics.checkNotNullParameter(queryCondition, "<this>");
        Intrinsics.checkNotNullParameter(queryCondition2, "queryCondition");
        QueryCondition<T> or = queryCondition.or(queryCondition2);
        Intrinsics.checkNotNullExpressionValue(or, "or(queryCondition)");
        return or;
    }
}
