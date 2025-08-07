package io.objectbox.kotlin;

import io.objectbox.Property;
import io.objectbox.query.PropertyQueryCondition;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a'\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004\u001a'\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0004\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0004\u001a'\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000fH\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0004\u001a'\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\bH\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\tH\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u000bH\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\fH\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\rH\u0004\u001a'\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H\u0004\u001a'\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0014H\u0004\u001a2\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u0004¢\u0006\u0002\u0010\u0017\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0013H\u0004\u001a'\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0014H\u0004\u001a'\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0004¨\u0006\u0019"}, d2 = {"contains", "Lio/objectbox/query/PropertyQueryCondition;", "T", "Lio/objectbox/Property;", "value", "", "endsWith", "equal", "Ljava/util/Date;", "", "", "", "", "", "greater", "", "less", "notEqual", "notOneOf", "", "", "oneOf", "", "(Lio/objectbox/Property;[Ljava/lang/String;)Lio/objectbox/query/PropertyQueryCondition;", "startsWith", "objectbox-kotlin"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* compiled from: Property.kt */
public final class PropertyKt {
    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, boolean z) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> equal = property.equal(z);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> notEqual(Property<T> property, boolean z) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> notEqual = property.notEqual(z);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(value)");
        return notEqual;
    }

    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> equal = property.equal(s);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> notEqual(Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> notEqual = property.notEqual(s);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(value)");
        return notEqual;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> greater = property.greater(s);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, short s) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> less = property.less(s);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }

    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> equal = property.equal(i);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> notEqual(Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> notEqual = property.notEqual(i);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(value)");
        return notEqual;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> greater = property.greater(i);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, int i) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> less = property.less(i);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }

    public static final <T> PropertyQueryCondition<T> oneOf(Property<T> property, int[] iArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "value");
        PropertyQueryCondition<T> oneOf = property.oneOf(iArr);
        Intrinsics.checkNotNullExpressionValue(oneOf, "oneOf(value)");
        return oneOf;
    }

    public static final <T> PropertyQueryCondition<T> notOneOf(Property<T> property, int[] iArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "value");
        PropertyQueryCondition<T> notOneOf = property.notOneOf(iArr);
        Intrinsics.checkNotNullExpressionValue(notOneOf, "notOneOf(value)");
        return notOneOf;
    }

    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, long j) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> equal = property.equal(j);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> notEqual(Property<T> property, long j) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> notEqual = property.notEqual(j);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(value)");
        return notEqual;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, long j) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> greater = property.greater(j);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, long j) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> less = property.less(j);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }

    public static final <T> PropertyQueryCondition<T> oneOf(Property<T> property, long[] jArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "value");
        PropertyQueryCondition<T> oneOf = property.oneOf(jArr);
        Intrinsics.checkNotNullExpressionValue(oneOf, "oneOf(value)");
        return oneOf;
    }

    public static final <T> PropertyQueryCondition<T> notOneOf(Property<T> property, long[] jArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(jArr, "value");
        PropertyQueryCondition<T> notOneOf = property.notOneOf(jArr);
        Intrinsics.checkNotNullExpressionValue(notOneOf, "notOneOf(value)");
        return notOneOf;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, double d) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> greater = property.greater(d);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, double d) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        PropertyQueryCondition<T> less = property.less(d);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }

    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, Date date) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(date, "value");
        PropertyQueryCondition<T> equal = property.equal(date);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> notEqual(Property<T> property, Date date) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(date, "value");
        PropertyQueryCondition<T> notEqual = property.notEqual(date);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(value)");
        return notEqual;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, Date date) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(date, "value");
        PropertyQueryCondition<T> greater = property.greater(date);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, Date date) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(date, "value");
        PropertyQueryCondition<T> less = property.less(date);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }

    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> equal = property.equal(str);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> notEqual(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> notEqual = property.notEqual(str);
        Intrinsics.checkNotNullExpressionValue(notEqual, "notEqual(value)");
        return notEqual;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> greater = property.greater(str);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> less = property.less(str);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }

    public static final <T> PropertyQueryCondition<T> contains(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> contains = property.contains(str);
        Intrinsics.checkNotNullExpressionValue(contains, "contains(value)");
        return contains;
    }

    public static final <T> PropertyQueryCondition<T> startsWith(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> startsWith = property.startsWith(str);
        Intrinsics.checkNotNullExpressionValue(startsWith, "startsWith(value)");
        return startsWith;
    }

    public static final <T> PropertyQueryCondition<T> endsWith(Property<T> property, String str) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(str, "value");
        PropertyQueryCondition<T> endsWith = property.endsWith(str);
        Intrinsics.checkNotNullExpressionValue(endsWith, "endsWith(value)");
        return endsWith;
    }

    public static final <T> PropertyQueryCondition<T> oneOf(Property<T> property, String[] strArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(strArr, "value");
        PropertyQueryCondition<T> oneOf = property.oneOf(strArr);
        Intrinsics.checkNotNullExpressionValue(oneOf, "oneOf(value)");
        return oneOf;
    }

    public static final <T> PropertyQueryCondition<T> equal(Property<T> property, byte[] bArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "value");
        PropertyQueryCondition<T> equal = property.equal(bArr);
        Intrinsics.checkNotNullExpressionValue(equal, "equal(value)");
        return equal;
    }

    public static final <T> PropertyQueryCondition<T> greater(Property<T> property, byte[] bArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "value");
        PropertyQueryCondition<T> greater = property.greater(bArr);
        Intrinsics.checkNotNullExpressionValue(greater, "greater(value)");
        return greater;
    }

    public static final <T> PropertyQueryCondition<T> less(Property<T> property, byte[] bArr) {
        Intrinsics.checkNotNullParameter(property, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "value");
        PropertyQueryCondition<T> less = property.less(bArr);
        Intrinsics.checkNotNullExpressionValue(less, "less(value)");
        return less;
    }
}
