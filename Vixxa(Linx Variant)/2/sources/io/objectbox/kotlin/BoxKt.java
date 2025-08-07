package io.objectbox.kotlin;

import io.objectbox.Box;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001d\u0010\u0004\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\b\bH\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\t"}, d2 = {"query", "Lio/objectbox/query/Query;", "T", "Lio/objectbox/Box;", "block", "Lkotlin/Function1;", "Lio/objectbox/query/QueryBuilder;", "", "Lkotlin/ExtensionFunctionType;", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Box.kt */
public final class BoxKt {
    public static final <T> Query<T> query(Box<T> box, Function1<? super QueryBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(box, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        QueryBuilder<T> query = box.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        function1.invoke(query);
        Query<T> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }
}
