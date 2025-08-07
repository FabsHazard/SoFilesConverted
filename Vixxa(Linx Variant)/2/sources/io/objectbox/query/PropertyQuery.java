package io.objectbox.query;

import com.github.mikephil.charting.utils.Utils;
import io.objectbox.Property;
import io.objectbox.query.QueryBuilder;

public class PropertyQuery {
    boolean distinct;
    boolean enableNull;
    boolean noCaseIfDistinct = true;
    double nullValueDouble;
    float nullValueFloat;
    long nullValueLong;
    String nullValueString;
    final Property<?> property;
    final int propertyId;
    final Query<?> query;
    final long queryHandle;
    boolean unique;

    /* access modifiers changed from: package-private */
    public native double nativeAvg(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native long nativeAvgLong(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native long nativeCount(long j, long j2, int i, boolean z);

    /* access modifiers changed from: package-private */
    public native byte[] nativeFindBytes(long j, long j2, int i, boolean z, boolean z2, byte b);

    /* access modifiers changed from: package-private */
    public native char[] nativeFindChars(long j, long j2, int i, boolean z, boolean z2, char c);

    /* access modifiers changed from: package-private */
    public native double[] nativeFindDoubles(long j, long j2, int i, boolean z, boolean z2, double d);

    /* access modifiers changed from: package-private */
    public native float[] nativeFindFloats(long j, long j2, int i, boolean z, boolean z2, float f);

    /* access modifiers changed from: package-private */
    public native int[] nativeFindInts(long j, long j2, int i, boolean z, boolean z2, int i2);

    /* access modifiers changed from: package-private */
    public native long[] nativeFindLongs(long j, long j2, int i, boolean z, boolean z2, long j3);

    /* access modifiers changed from: package-private */
    public native Object nativeFindNumber(long j, long j2, int i, boolean z, boolean z2, boolean z3, long j3, float f, double d);

    /* access modifiers changed from: package-private */
    public native short[] nativeFindShorts(long j, long j2, int i, boolean z, boolean z2, short s);

    /* access modifiers changed from: package-private */
    public native String nativeFindString(long j, long j2, int i, boolean z, boolean z2, boolean z3, boolean z4, String str);

    /* access modifiers changed from: package-private */
    public native String[] nativeFindStrings(long j, long j2, int i, boolean z, boolean z2, boolean z3, String str);

    /* access modifiers changed from: package-private */
    public native long nativeMax(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native double nativeMaxDouble(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native long nativeMin(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native double nativeMinDouble(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native long nativeSum(long j, long j2, int i);

    /* access modifiers changed from: package-private */
    public native double nativeSumDouble(long j, long j2, int i);

    PropertyQuery(Query<?> query2, Property<?> property2) {
        this.query = query2;
        this.queryHandle = query2.handle;
        this.property = property2;
        this.propertyId = property2.id;
    }

    public PropertyQuery reset() {
        this.distinct = false;
        this.noCaseIfDistinct = true;
        this.unique = false;
        this.enableNull = false;
        this.nullValueDouble = Utils.DOUBLE_EPSILON;
        this.nullValueFloat = 0.0f;
        this.nullValueString = null;
        this.nullValueLong = 0;
        return this;
    }

    public PropertyQuery distinct() {
        this.distinct = true;
        return this;
    }

    public PropertyQuery distinct(QueryBuilder.StringOrder stringOrder) {
        if (this.property.type == String.class) {
            boolean z = true;
            this.distinct = true;
            if (stringOrder != QueryBuilder.StringOrder.CASE_INSENSITIVE) {
                z = false;
            }
            this.noCaseIfDistinct = z;
            return this;
        }
        throw new RuntimeException("Reserved for string properties, but got " + this.property);
    }

    public PropertyQuery unique() {
        this.unique = true;
        return this;
    }

    public PropertyQuery nullValue(Object obj) {
        if (obj != null) {
            boolean z = obj instanceof String;
            boolean z2 = obj instanceof Number;
            if (z || z2) {
                this.enableNull = true;
                this.nullValueString = z ? (String) obj : null;
                boolean z3 = obj instanceof Float;
                this.nullValueFloat = z3 ? ((Float) obj).floatValue() : 0.0f;
                boolean z4 = obj instanceof Double;
                this.nullValueDouble = z4 ? ((Double) obj).doubleValue() : Utils.DOUBLE_EPSILON;
                this.nullValueLong = (!z2 || z3 || z4) ? 0 : ((Number) obj).longValue();
                return this;
            }
            throw new IllegalArgumentException("Unsupported value class: " + obj.getClass());
        }
        throw new IllegalArgumentException("Null values are not allowed");
    }

    public String[] findStrings() {
        return (String[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findStrings$0$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ String[] m315lambda$findStrings$0$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindStrings(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.distinct && this.noCaseIfDistinct, this.enableNull, this.nullValueString);
    }

    public long[] findLongs() {
        return (long[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findLongs$1$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ long[] m311lambda$findLongs$1$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindLongs(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, this.nullValueLong);
    }

    public int[] findInts() {
        return (int[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda16(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findInts$2$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ int[] m310lambda$findInts$2$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindInts(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (int) this.nullValueLong);
    }

    public short[] findShorts() {
        return (short[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda8(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findShorts$3$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ short[] m313lambda$findShorts$3$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindShorts(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (short) ((int) this.nullValueLong));
    }

    public char[] findChars() {
        return (char[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findChars$4$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ char[] m307lambda$findChars$4$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindChars(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (char) ((int) this.nullValueLong));
    }

    public byte[] findBytes() {
        return (byte[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda17(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findBytes$5$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ byte[] m306lambda$findBytes$5$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindBytes(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, (byte) ((int) this.nullValueLong));
    }

    public float[] findFloats() {
        return (float[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findFloats$6$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ float[] m309lambda$findFloats$6$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindFloats(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, this.nullValueFloat);
    }

    public double[] findDoubles() {
        return (double[]) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda10(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findDoubles$7$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ double[] m308lambda$findDoubles$7$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindDoubles(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct, this.enableNull, this.nullValueDouble);
    }

    public String findString() {
        return (String) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda7(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findString$8$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ String m314lambda$findString$8$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindString(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.unique, this.distinct, this.distinct && !this.noCaseIfDistinct, this.enableNull, this.nullValueString);
    }

    private Object findNumber() {
        return this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$findNumber$9$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Object m312lambda$findNumber$9$ioobjectboxqueryPropertyQuery() throws Exception {
        return nativeFindNumber(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.unique, this.distinct, this.enableNull, this.nullValueLong, this.nullValueFloat, this.nullValueDouble);
    }

    public Long findLong() {
        return (Long) findNumber();
    }

    public Integer findInt() {
        return (Integer) findNumber();
    }

    public Short findShort() {
        return (Short) findNumber();
    }

    public Character findChar() {
        return (Character) findNumber();
    }

    public Byte findByte() {
        return (Byte) findNumber();
    }

    public Boolean findBoolean() {
        return (Boolean) findNumber();
    }

    public Float findFloat() {
        return (Float) findNumber();
    }

    public Double findDouble() {
        return (Double) findNumber();
    }

    public long sum() {
        return ((Long) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda14(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$sum$10$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Long m320lambda$sum$10$ioobjectboxqueryPropertyQuery() throws Exception {
        return Long.valueOf(nativeSum(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double sumDouble() {
        return ((Double) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda15(this))).doubleValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$sumDouble$11$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Double m321lambda$sumDouble$11$ioobjectboxqueryPropertyQuery() throws Exception {
        return Double.valueOf(nativeSumDouble(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long max() {
        return ((Long) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda2(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$max$12$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Long m316lambda$max$12$ioobjectboxqueryPropertyQuery() throws Exception {
        return Long.valueOf(nativeMax(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double maxDouble() {
        return ((Double) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda1(this))).doubleValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$maxDouble$13$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Double m317lambda$maxDouble$13$ioobjectboxqueryPropertyQuery() throws Exception {
        return Double.valueOf(nativeMaxDouble(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long min() {
        return ((Long) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda3(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$min$14$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Long m318lambda$min$14$ioobjectboxqueryPropertyQuery() throws Exception {
        return Long.valueOf(nativeMin(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double minDouble() {
        return ((Double) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda18(this))).doubleValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$minDouble$15$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Double m319lambda$minDouble$15$ioobjectboxqueryPropertyQuery() throws Exception {
        return Double.valueOf(nativeMinDouble(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public double avg() {
        return ((Double) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda11(this))).doubleValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$avg$16$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Double m303lambda$avg$16$ioobjectboxqueryPropertyQuery() throws Exception {
        return Double.valueOf(nativeAvg(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long avgLong() {
        return ((Long) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda12(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$avgLong$17$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Long m304lambda$avgLong$17$ioobjectboxqueryPropertyQuery() throws Exception {
        return Long.valueOf(nativeAvgLong(this.queryHandle, this.query.cursorHandle(), this.propertyId));
    }

    public long count() {
        return ((Long) this.query.callInReadTx(new PropertyQuery$$ExternalSyntheticLambda13(this))).longValue();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$count$18$io-objectbox-query-PropertyQuery  reason: not valid java name */
    public /* synthetic */ Long m305lambda$count$18$ioobjectboxqueryPropertyQuery() throws Exception {
        return Long.valueOf(nativeCount(this.queryHandle, this.query.cursorHandle(), this.propertyId, this.distinct));
    }
}
