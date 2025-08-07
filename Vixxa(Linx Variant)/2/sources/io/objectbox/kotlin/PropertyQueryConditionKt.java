package io.objectbox.kotlin;

import io.objectbox.query.PropertyQueryCondition;
import io.objectbox.query.QueryCondition;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a'\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004¨\u0006\u0006"}, d2 = {"alias", "Lio/objectbox/query/QueryCondition;", "T", "Lio/objectbox/query/PropertyQueryCondition;", "name", "", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: PropertyQueryCondition.kt */
public final class PropertyQueryConditionKt {
    public static final <T> QueryCondition<T> alias(PropertyQueryCondition<T> propertyQueryCondition, String str) {
        Intrinsics.checkNotNullParameter(propertyQueryCondition, "<this>");
        Intrinsics.checkNotNullParameter(str, "name");
        QueryCondition<T> alias = propertyQueryCondition.alias(str);
        Intrinsics.checkNotNullExpressionValue(alias, "alias(name)");
        return alias;
    }
}
