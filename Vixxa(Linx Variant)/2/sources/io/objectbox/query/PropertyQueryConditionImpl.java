package io.objectbox.query;

import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;
import java.util.Date;

public abstract class PropertyQueryConditionImpl<T> extends QueryConditionImpl<T> implements PropertyQueryCondition<T> {
    private String alias;
    public final Property<T> property;

    /* access modifiers changed from: package-private */
    public abstract void applyCondition(QueryBuilder<T> queryBuilder);

    public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
        return super.and(queryCondition);
    }

    public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
        return super.or(queryCondition);
    }

    PropertyQueryConditionImpl(Property<T> property2) {
        this.property = property2;
    }

    public QueryCondition<T> alias(String str) {
        this.alias = str;
        return this;
    }

    public void apply(QueryBuilder<T> queryBuilder) {
        applyCondition(queryBuilder);
        String str = this.alias;
        if (str != null && str.length() != 0) {
            queryBuilder.parameterAlias(this.alias);
        }
    }

    public static class NullCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;

        public enum Operation {
            IS_NULL,
            NOT_NULL
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public NullCondition(Property<T> property, Operation operation) {
            super(property);
            this.op = operation;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            int i = AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.isNull(this.property);
            } else if (i == 2) {
                queryBuilder.notNull(this.property);
            } else {
                throw new UnsupportedOperationException(this.op + " is not supported");
            }
        }
    }

    public static class IntArrayCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final int[] value;

        public enum Operation {
            IN,
            NOT_IN
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public IntArrayCondition(Property<T> property, Operation operation, int[] iArr) {
            super(property);
            this.op = operation;
            this.value = iArr;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            int i = AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.in((Property<T>) this.property, this.value);
            } else if (i == 2) {
                queryBuilder.notIn((Property<T>) this.property, this.value);
            } else {
                throw new UnsupportedOperationException(this.op + " is not supported for int[]");
            }
        }
    }

    public static class LongCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final long value;

        public enum Operation {
            EQUAL,
            NOT_EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public LongCondition(Property<T> property, Operation operation, long j) {
            super(property);
            this.op = operation;
            this.value = j;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public LongCondition(Property<T> property, Operation operation, boolean z) {
            this(property, operation, z ? 1 : 0);
        }

        public LongCondition(Property<T> property, Operation operation, Date date) {
            this(property, operation, date.getTime());
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            switch (AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation[this.op.ordinal()]) {
                case 1:
                    queryBuilder.equal((Property<T>) this.property, this.value);
                    return;
                case 2:
                    queryBuilder.notEqual((Property<T>) this.property, this.value);
                    return;
                case 3:
                    queryBuilder.greater((Property<T>) this.property, this.value);
                    return;
                case 4:
                    queryBuilder.greaterOrEqual((Property<T>) this.property, this.value);
                    return;
                case 5:
                    queryBuilder.less((Property<T>) this.property, this.value);
                    return;
                case 6:
                    queryBuilder.lessOrEqual((Property<T>) this.property, this.value);
                    return;
                default:
                    throw new UnsupportedOperationException(this.op + " is not supported for String");
            }
        }
    }

    public static class LongLongCondition<T> extends PropertyQueryConditionImpl<T> {
        private final long leftValue;
        private final Operation op;
        private final long rightValue;

        public enum Operation {
            BETWEEN
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public LongLongCondition(Property<T> property, Operation operation, long j, long j2) {
            super(property);
            this.op = operation;
            this.leftValue = j;
            this.rightValue = j2;
        }

        public LongLongCondition(Property<T> property, Operation operation, Date date, Date date2) {
            this(property, operation, date.getTime(), date2.getTime());
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            if (this.op == Operation.BETWEEN) {
                queryBuilder.between((Property<T>) this.property, this.leftValue, this.rightValue);
                return;
            }
            throw new UnsupportedOperationException(this.op + " is not supported with two long values");
        }
    }

    public static class LongArrayCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final long[] value;

        public enum Operation {
            IN,
            NOT_IN
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public LongArrayCondition(Property<T> property, Operation operation, long[] jArr) {
            super(property);
            this.op = operation;
            this.value = jArr;
        }

        public LongArrayCondition(Property<T> property, Operation operation, Date[] dateArr) {
            super(property);
            this.op = operation;
            this.value = new long[dateArr.length];
            for (int i = 0; i < dateArr.length; i++) {
                this.value[i] = dateArr[i].getTime();
            }
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            int i = AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.in((Property<T>) this.property, this.value);
            } else if (i == 2) {
                queryBuilder.notIn((Property<T>) this.property, this.value);
            } else {
                throw new UnsupportedOperationException(this.op + " is not supported for long[]");
            }
        }
    }

    public static class DoubleCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final double value;

        public enum Operation {
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public DoubleCondition(Property<T> property, Operation operation, double d) {
            super(property);
            this.op = operation;
            this.value = d;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            int i = AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.greater((Property<T>) this.property, this.value);
            } else if (i == 2) {
                queryBuilder.greaterOrEqual((Property<T>) this.property, this.value);
            } else if (i == 3) {
                queryBuilder.less((Property<T>) this.property, this.value);
            } else if (i == 4) {
                queryBuilder.lessOrEqual((Property<T>) this.property, this.value);
            } else {
                throw new UnsupportedOperationException(this.op + " is not supported for double");
            }
        }
    }

    public static class DoubleDoubleCondition<T> extends PropertyQueryConditionImpl<T> {
        private final double leftValue;
        private final Operation op;
        private final double rightValue;

        public enum Operation {
            BETWEEN
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public DoubleDoubleCondition(Property<T> property, Operation operation, double d, double d2) {
            super(property);
            this.op = operation;
            this.leftValue = d;
            this.rightValue = d2;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            if (this.op == Operation.BETWEEN) {
                queryBuilder.between((Property<T>) this.property, this.leftValue, this.rightValue);
                return;
            }
            throw new UnsupportedOperationException(this.op + " is not supported with two double values");
        }
    }

    public static class StringCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final QueryBuilder.StringOrder order;
        private final String value;

        public enum Operation {
            EQUAL,
            NOT_EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL,
            CONTAINS,
            CONTAINS_ELEMENT,
            STARTS_WITH,
            ENDS_WITH
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public StringCondition(Property<T> property, Operation operation, String str, QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.op = operation;
            this.value = str;
            this.order = stringOrder;
        }

        public StringCondition(Property<T> property, Operation operation, String str) {
            this(property, operation, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            switch (AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation[this.op.ordinal()]) {
                case 1:
                    queryBuilder.equal((Property<T>) this.property, this.value, this.order);
                    return;
                case 2:
                    queryBuilder.notEqual(this.property, this.value, this.order);
                    return;
                case 3:
                    queryBuilder.greater(this.property, this.value, this.order);
                    return;
                case 4:
                    queryBuilder.greaterOrEqual(this.property, this.value, this.order);
                    return;
                case 5:
                    queryBuilder.less(this.property, this.value, this.order);
                    return;
                case 6:
                    queryBuilder.lessOrEqual(this.property, this.value, this.order);
                    return;
                case 7:
                    queryBuilder.contains(this.property, this.value, this.order);
                    return;
                case 8:
                    queryBuilder.containsElement(this.property, this.value, this.order);
                    return;
                case 9:
                    queryBuilder.startsWith(this.property, this.value, this.order);
                    return;
                case 10:
                    queryBuilder.endsWith(this.property, this.value, this.order);
                    return;
                default:
                    throw new UnsupportedOperationException(this.op + " is not supported for String");
            }
        }
    }

    public static class StringStringCondition<T> extends PropertyQueryConditionImpl<T> {
        private final String leftValue;
        private final Operation op;
        private final QueryBuilder.StringOrder order;
        private final String rightValue;

        public enum Operation {
            CONTAINS_KEY_VALUE
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public StringStringCondition(Property<T> property, Operation operation, String str, String str2, QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.op = operation;
            this.leftValue = str;
            this.rightValue = str2;
            this.order = stringOrder;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            if (this.op == Operation.CONTAINS_KEY_VALUE) {
                queryBuilder.containsKeyValue(this.property, this.leftValue, this.rightValue, this.order);
                return;
            }
            throw new UnsupportedOperationException(this.op + " is not supported with two String values");
        }
    }

    public static class StringArrayCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final QueryBuilder.StringOrder order;
        private final String[] value;

        public enum Operation {
            IN
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public StringArrayCondition(Property<T> property, Operation operation, String[] strArr, QueryBuilder.StringOrder stringOrder) {
            super(property);
            this.op = operation;
            this.value = strArr;
            this.order = stringOrder;
        }

        public StringArrayCondition(Property<T> property, Operation operation, String[] strArr) {
            this(property, operation, strArr, QueryBuilder.StringOrder.CASE_SENSITIVE);
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            if (this.op == Operation.IN) {
                queryBuilder.in(this.property, this.value, this.order);
                return;
            }
            throw new UnsupportedOperationException(this.op + " is not supported for String[]");
        }
    }

    public static class ByteArrayCondition<T> extends PropertyQueryConditionImpl<T> {
        private final Operation op;
        private final byte[] value;

        public enum Operation {
            EQUAL,
            GREATER,
            GREATER_OR_EQUAL,
            LESS,
            LESS_OR_EQUAL
        }

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public ByteArrayCondition(Property<T> property, Operation operation, byte[] bArr) {
            super(property);
            this.op = operation;
            this.value = bArr;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            int i = AnonymousClass1.$SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation[this.op.ordinal()];
            if (i == 1) {
                queryBuilder.equal((Property<T>) this.property, this.value);
            } else if (i == 2) {
                queryBuilder.greater((Property<T>) this.property, this.value);
            } else if (i == 3) {
                queryBuilder.greaterOrEqual((Property<T>) this.property, this.value);
            } else if (i == 4) {
                queryBuilder.less((Property<T>) this.property, this.value);
            } else if (i == 5) {
                queryBuilder.lessOrEqual((Property<T>) this.property, this.value);
            } else {
                throw new UnsupportedOperationException(this.op + " is not supported for byte[]");
            }
        }
    }

    /* renamed from: io.objectbox.query.PropertyQueryConditionImpl$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation;
        static final /* synthetic */ int[] $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation;

        /* JADX WARNING: Can't wrap try/catch for region: R(64:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|(2:51|52)|53|55|56|(2:57|58)|59|61|62|63|64|65|66|67|68|69|70|(2:71|72)|73|75|76|(2:77|78)|79|81|82|(3:83|84|86)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(70:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|(2:29|30)|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|79|81|82|(3:83|84|86)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(71:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|79|81|82|(3:83|84|86)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|1|2|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|79|81|82|83|84|86) */
        /* JADX WARNING: Can't wrap try/catch for region: R(75:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|41|42|43|45|46|47|48|49|50|51|52|53|55|56|57|58|59|61|62|63|64|65|66|67|68|69|70|71|72|73|75|76|77|78|79|81|82|83|84|86) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x004f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0059 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0063 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0099 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00c2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00d6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00f1 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x010c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0116 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x012a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x0134 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:77:0x014f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:83:0x016a */
        static {
            /*
                io.objectbox.query.PropertyQueryConditionImpl$ByteArrayCondition$Operation[] r0 = io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation = r0
                r1 = 1
                io.objectbox.query.PropertyQueryConditionImpl$ByteArrayCondition$Operation r2 = io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.EQUAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation     // Catch:{ NoSuchFieldError -> 0x001d }
                io.objectbox.query.PropertyQueryConditionImpl$ByteArrayCondition$Operation r3 = io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0028 }
                io.objectbox.query.PropertyQueryConditionImpl$ByteArrayCondition$Operation r4 = io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.GREATER_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0033 }
                io.objectbox.query.PropertyQueryConditionImpl$ByteArrayCondition$Operation r5 = io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$ByteArrayCondition$Operation     // Catch:{ NoSuchFieldError -> 0x003e }
                io.objectbox.query.PropertyQueryConditionImpl$ByteArrayCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.ByteArrayCondition.Operation.LESS_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation[] r5 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation = r5
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.EQUAL     // Catch:{ NoSuchFieldError -> 0x004f }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x004f }
                r5[r6] = r1     // Catch:{ NoSuchFieldError -> 0x004f }
            L_0x004f:
                int[] r5 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0059 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.NOT_EQUAL     // Catch:{ NoSuchFieldError -> 0x0059 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0059 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0059 }
            L_0x0059:
                int[] r5 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0063 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r5[r6] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                int[] r5 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x006d }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.GREATER_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x006d }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r5[r6] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                int[] r5 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0077 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS     // Catch:{ NoSuchFieldError -> 0x0077 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0077 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0077 }
            L_0x0077:
                r5 = 6
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0082 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.LESS_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x008d }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS     // Catch:{ NoSuchFieldError -> 0x008d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x008d }
                r8 = 7
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x008d }
            L_0x008d:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0099 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.CONTAINS_ELEMENT     // Catch:{ NoSuchFieldError -> 0x0099 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0099 }
                r8 = 8
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x0099 }
            L_0x0099:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x00a5 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.STARTS_WITH     // Catch:{ NoSuchFieldError -> 0x00a5 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r8 = 9
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$StringCondition$Operation     // Catch:{ NoSuchFieldError -> 0x00b1 }
                io.objectbox.query.PropertyQueryConditionImpl$StringCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.StringCondition.Operation.ENDS_WITH     // Catch:{ NoSuchFieldError -> 0x00b1 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b1 }
                r8 = 10
                r6[r7] = r8     // Catch:{ NoSuchFieldError -> 0x00b1 }
            L_0x00b1:
                io.objectbox.query.PropertyQueryConditionImpl$DoubleCondition$Operation[] r6 = io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation = r6
                io.objectbox.query.PropertyQueryConditionImpl$DoubleCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation     // Catch:{ NoSuchFieldError -> 0x00cc }
                io.objectbox.query.PropertyQueryConditionImpl$DoubleCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.GREATER_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation     // Catch:{ NoSuchFieldError -> 0x00d6 }
                io.objectbox.query.PropertyQueryConditionImpl$DoubleCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.LESS     // Catch:{ NoSuchFieldError -> 0x00d6 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d6 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x00d6 }
            L_0x00d6:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$DoubleCondition$Operation     // Catch:{ NoSuchFieldError -> 0x00e0 }
                io.objectbox.query.PropertyQueryConditionImpl$DoubleCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.DoubleCondition.Operation.LESS_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x00e0 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e0 }
                r6[r7] = r3     // Catch:{ NoSuchFieldError -> 0x00e0 }
            L_0x00e0:
                io.objectbox.query.PropertyQueryConditionImpl$LongArrayCondition$Operation[] r6 = io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation = r6
                io.objectbox.query.PropertyQueryConditionImpl$LongArrayCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.IN     // Catch:{ NoSuchFieldError -> 0x00f1 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f1 }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x00f1 }
            L_0x00f1:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongArrayCondition$Operation     // Catch:{ NoSuchFieldError -> 0x00fb }
                io.objectbox.query.PropertyQueryConditionImpl$LongArrayCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.LongArrayCondition.Operation.NOT_IN     // Catch:{ NoSuchFieldError -> 0x00fb }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fb }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x00fb }
            L_0x00fb:
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation[] r6 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation = r6
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.EQUAL     // Catch:{ NoSuchFieldError -> 0x010c }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x010c }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x010c }
            L_0x010c:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0116 }
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.NOT_EQUAL     // Catch:{ NoSuchFieldError -> 0x0116 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0116 }
                r6[r7] = r0     // Catch:{ NoSuchFieldError -> 0x0116 }
            L_0x0116:
                int[] r6 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0120 }
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation r7 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r6[r7] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r2 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation     // Catch:{ NoSuchFieldError -> 0x012a }
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation r6 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.GREATER_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x012a }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x012a }
                r2[r6] = r3     // Catch:{ NoSuchFieldError -> 0x012a }
            L_0x012a:
                int[] r2 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0134 }
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation r3 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS     // Catch:{ NoSuchFieldError -> 0x0134 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0134 }
                r2[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0134 }
            L_0x0134:
                int[] r2 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$LongCondition$Operation     // Catch:{ NoSuchFieldError -> 0x013e }
                io.objectbox.query.PropertyQueryConditionImpl$LongCondition$Operation r3 = io.objectbox.query.PropertyQueryConditionImpl.LongCondition.Operation.LESS_OR_EQUAL     // Catch:{ NoSuchFieldError -> 0x013e }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x013e }
                r2[r3] = r5     // Catch:{ NoSuchFieldError -> 0x013e }
            L_0x013e:
                io.objectbox.query.PropertyQueryConditionImpl$IntArrayCondition$Operation[] r2 = io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation = r2
                io.objectbox.query.PropertyQueryConditionImpl$IntArrayCondition$Operation r3 = io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.IN     // Catch:{ NoSuchFieldError -> 0x014f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x014f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x014f }
            L_0x014f:
                int[] r2 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$IntArrayCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0159 }
                io.objectbox.query.PropertyQueryConditionImpl$IntArrayCondition$Operation r3 = io.objectbox.query.PropertyQueryConditionImpl.IntArrayCondition.Operation.NOT_IN     // Catch:{ NoSuchFieldError -> 0x0159 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0159 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0159 }
            L_0x0159:
                io.objectbox.query.PropertyQueryConditionImpl$NullCondition$Operation[] r2 = io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation = r2
                io.objectbox.query.PropertyQueryConditionImpl$NullCondition$Operation r3 = io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.IS_NULL     // Catch:{ NoSuchFieldError -> 0x016a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x016a }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x016a }
            L_0x016a:
                int[] r1 = $SwitchMap$io$objectbox$query$PropertyQueryConditionImpl$NullCondition$Operation     // Catch:{ NoSuchFieldError -> 0x0174 }
                io.objectbox.query.PropertyQueryConditionImpl$NullCondition$Operation r2 = io.objectbox.query.PropertyQueryConditionImpl.NullCondition.Operation.NOT_NULL     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.objectbox.query.PropertyQueryConditionImpl.AnonymousClass1.<clinit>():void");
        }
    }

    public static class NearestNeighborCondition<T> extends PropertyQueryConditionImpl<T> {
        private final int maxResultCount;
        private final float[] queryVector;

        public /* bridge */ /* synthetic */ QueryCondition and(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.and(queryCondition);
        }

        public /* bridge */ /* synthetic */ QueryCondition or(QueryCondition queryCondition) {
            return PropertyQueryConditionImpl.super.or(queryCondition);
        }

        public NearestNeighborCondition(Property<T> property, float[] fArr, int i) {
            super(property);
            this.queryVector = fArr;
            this.maxResultCount = i;
        }

        /* access modifiers changed from: package-private */
        public void applyCondition(QueryBuilder<T> queryBuilder) {
            queryBuilder.nearestNeighbors(this.property, this.queryVector, this.maxResultCount);
        }
    }
}
