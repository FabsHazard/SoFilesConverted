package com.huawei.hms.common.parcel;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import androidx.core.internal.view.SupportMenu;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParcelReader {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 65262;
    public HashMap<Integer, Integer[]> a = new HashMap<>();
    public Parcel b;

    public class ParseException extends RuntimeException {
        public ParseException(String str, Parcel parcel) {
            super(str);
        }
    }

    public ParcelReader(Parcel parcel) {
        this.b = parcel;
        a();
    }

    private int a(int i) {
        if (i < 0) {
            return 0;
        }
        if (i > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return i;
    }

    private void a() {
        int readInt = this.b.readInt();
        int i = readInt & 65535;
        int readInt2 = (readInt & SupportMenu.CATEGORY_MASK) != -65536 ? (readInt >> 16) & 65535 : this.b.readInt();
        if (i == 65262) {
            int dataPosition = this.b.dataPosition();
            int i2 = readInt2 + dataPosition;
            if (i2 < dataPosition || i2 > this.b.dataSize()) {
                throw new ParseException("invalid size, start=" + dataPosition + " end=" + i2, this.b);
            }
            while (this.b.dataPosition() < i2) {
                int readInt3 = this.b.readInt();
                int i3 = readInt3 & 65535;
                int readInt4 = (readInt3 & SupportMenu.CATEGORY_MASK) != -65536 ? (readInt3 >> 16) & 65535 : this.b.readInt();
                int dataPosition2 = this.b.dataPosition();
                this.a.put(Integer.valueOf(i3), new Integer[]{Integer.valueOf(dataPosition2), Integer.valueOf(readInt4)});
                this.b.setDataPosition(dataPosition2 + readInt4);
            }
            if (this.b.dataPosition() != i2) {
                throw new ParseException("the dataPosition is not" + i2, this.b);
            }
            return;
        }
        throw new ParseException("Parse header error, not 65262. Got 0x" + Integer.toHexString(i), this.b);
    }

    private void a(int i, int i2) {
        Integer[] numArr = this.a.get(Integer.valueOf(i));
        if (numArr != null) {
            int intValue = numArr[1].intValue();
            if (intValue != i2) {
                throw new ParseException("the field size is not " + i2 + " got " + intValue + " (0x" + Integer.toHexString(intValue) + ")", this.b);
            }
            return;
        }
        throw new ParseException("Field is null:" + numArr, this.b);
    }

    private int b(int i) {
        Integer[] numArr = this.a.get(Integer.valueOf(i));
        if (numArr != null) {
            this.b.setDataPosition(numArr[0].intValue());
            return numArr[1].intValue();
        }
        throw new ParseException("Field is null:" + numArr, this.b);
    }

    private int b(int i, int i2) {
        Integer[] numArr = this.a.get(Integer.valueOf(i));
        if (numArr != null) {
            this.b.setDataPosition(numArr[0].intValue());
            a(i, i2);
            return i2;
        }
        throw new ParseException("Field is null:" + numArr, this.b);
    }

    public BigDecimal createBigDecimal(int i, BigDecimal bigDecimal) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bigDecimal;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        byte[] createByteArray = this.b.createByteArray();
        int readInt = this.b.readInt();
        this.b.setDataPosition(dataPosition + b2);
        return new BigDecimal(new BigInteger(createByteArray), readInt);
    }

    public BigDecimal[] createBigDecimalArray(int i, BigDecimal[] bigDecimalArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bigDecimalArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        BigDecimal[] bigDecimalArr2 = new BigDecimal[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            byte[] createByteArray = this.b.createByteArray();
            bigDecimalArr2[i2] = new BigDecimal(new BigInteger(createByteArray), this.b.readInt());
        }
        this.b.setDataPosition(dataPosition + b2);
        return bigDecimalArr2;
    }

    public BigInteger createBigInteger(int i, BigInteger bigInteger) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bigInteger;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        byte[] createByteArray = this.b.createByteArray();
        this.b.setDataPosition(dataPosition + b2);
        return new BigInteger(createByteArray);
    }

    public BigInteger[] createBigIntegerArray(int i, BigInteger[] bigIntegerArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bigIntegerArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        BigInteger[] bigIntegerArr2 = new BigInteger[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            bigIntegerArr2[i2] = new BigInteger(this.b.createByteArray());
        }
        this.b.setDataPosition(dataPosition + b2);
        return bigIntegerArr2;
    }

    public boolean[] createBooleanArray(int i, boolean[] zArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return zArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        boolean[] createBooleanArray = this.b.createBooleanArray();
        this.b.setDataPosition(dataPosition + b2);
        return createBooleanArray;
    }

    public ArrayList<Boolean> createBooleanList(int i, ArrayList<Boolean> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<Boolean> arrayList2 = new ArrayList<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            arrayList2.add(Boolean.valueOf(this.b.readInt() != 0));
        }
        this.b.setDataPosition(dataPosition + b2);
        return arrayList2;
    }

    public byte[] createByteArray(int i, byte[] bArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        byte[] createByteArray = this.b.createByteArray();
        this.b.setDataPosition(dataPosition + b2);
        return createByteArray;
    }

    public byte[][] createByteArrayArray(int i, byte[][] bArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        byte[][] bArr2 = new byte[a2][];
        for (int i2 = 0; i2 < a2; i2++) {
            bArr2[i2] = this.b.createByteArray();
        }
        this.b.setDataPosition(dataPosition + b2);
        return bArr2;
    }

    public SparseArray<byte[]> createByteArraySparseArray(int i, SparseArray<byte[]> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        SparseArray<byte[]> sparseArray2 = new SparseArray<>(a2);
        for (int i2 = 0; i2 < a2; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.createByteArray());
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public char[] createCharArray(int i, char[] cArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return cArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        char[] createCharArray = this.b.createCharArray();
        this.b.setDataPosition(dataPosition + b2);
        return createCharArray;
    }

    public double[] createDoubleArray(int i, double[] dArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return dArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        double[] createDoubleArray = this.b.createDoubleArray();
        this.b.setDataPosition(dataPosition + b2);
        return createDoubleArray;
    }

    public ArrayList<Double> createDoubleList(int i, ArrayList<Double> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<Double> arrayList2 = new ArrayList<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            arrayList2.add(Double.valueOf(this.b.readDouble()));
        }
        this.b.setDataPosition(dataPosition + b2);
        return arrayList2;
    }

    public SparseArray<Double> createDoubleSparseArray(int i, SparseArray<Double> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        SparseArray<Double> sparseArray2 = new SparseArray<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            sparseArray2.append(this.b.readInt(), Double.valueOf(this.b.readDouble()));
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public float[] createFloatArray(int i, float[] fArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return fArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        float[] createFloatArray = this.b.createFloatArray();
        this.b.setDataPosition(dataPosition + b2);
        return createFloatArray;
    }

    public ArrayList<Float> createFloatList(int i, ArrayList<Float> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<Float> arrayList2 = new ArrayList<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            arrayList2.add(Float.valueOf(this.b.readFloat()));
        }
        this.b.setDataPosition(dataPosition + b2);
        return arrayList2;
    }

    public SparseArray<Float> createFloatSparseArray(int i, SparseArray<Float> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        SparseArray<Float> sparseArray2 = new SparseArray<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            sparseArray2.append(this.b.readInt(), Float.valueOf(this.b.readFloat()));
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public IBinder[] createIBinderArray(int i, IBinder[] iBinderArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return iBinderArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        IBinder[] createBinderArray = this.b.createBinderArray();
        this.b.setDataPosition(dataPosition + b2);
        return createBinderArray;
    }

    public ArrayList<IBinder> createIBinderList(int i, ArrayList<IBinder> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<IBinder> createBinderArrayList = this.b.createBinderArrayList();
        this.b.setDataPosition(dataPosition + b2);
        return createBinderArrayList;
    }

    public SparseArray<IBinder> createIBinderSparseArray(int i, SparseArray<IBinder> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        SparseArray<IBinder> sparseArray2 = new SparseArray<>(a2);
        for (int i2 = 0; i2 < a2; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.readStrongBinder());
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public int[] createIntArray(int i, int[] iArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return iArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int[] createIntArray = this.b.createIntArray();
        this.b.setDataPosition(dataPosition + b2);
        return createIntArray;
    }

    public ArrayList<Integer> createIntegerList(int i, ArrayList<Integer> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            arrayList2.add(Integer.valueOf(this.b.readInt()));
        }
        this.b.setDataPosition(dataPosition + b2);
        return arrayList2;
    }

    public long[] createLongArray(int i, long[] jArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return jArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        long[] createLongArray = this.b.createLongArray();
        this.b.setDataPosition(dataPosition + b2);
        return createLongArray;
    }

    public ArrayList<Long> createLongList(int i, ArrayList<Long> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<Long> arrayList2 = new ArrayList<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            arrayList2.add(Long.valueOf(this.b.readLong()));
        }
        this.b.setDataPosition(dataPosition + b2);
        return arrayList2;
    }

    public Parcel createParcel(int i, Parcel parcel) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return parcel;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        Parcel obtain = Parcel.obtain();
        obtain.appendFrom(this.b, dataPosition, b2);
        this.b.setDataPosition(dataPosition + b2);
        return obtain;
    }

    public Parcel[] createParcelArray(int i, Parcel[] parcelArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return parcelArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        Parcel[] parcelArr2 = new Parcel[a2];
        for (int i2 = 0; i2 < a2; i2++) {
            int readInt = this.b.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.b, dataPosition2, readInt);
                parcelArr2[i2] = obtain;
                this.b.setDataPosition(dataPosition2 + readInt);
            } else {
                parcelArr2[i2] = null;
            }
        }
        this.b.setDataPosition(dataPosition + b2);
        return parcelArr2;
    }

    public ArrayList<Parcel> createParcelList(int i, ArrayList<Parcel> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        ArrayList<Parcel> arrayList2 = new ArrayList<>();
        for (int i2 = 0; i2 < a2; i2++) {
            int readInt = this.b.readInt();
            if (readInt != 0) {
                int dataPosition2 = this.b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.b, dataPosition2, readInt);
                arrayList2.add(obtain);
                this.b.setDataPosition(dataPosition2 + readInt);
            } else {
                arrayList2.add((Object) null);
            }
        }
        this.b.setDataPosition(dataPosition + b2);
        return arrayList2;
    }

    public SparseArray<Parcel> createParcelSparseArray(int i, SparseArray<Parcel> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        SparseArray<Parcel> sparseArray2 = new SparseArray<>();
        for (int i2 = 0; i2 < a2; i2++) {
            int readInt = this.b.readInt();
            int readInt2 = this.b.readInt();
            if (readInt2 != 0) {
                int dataPosition2 = this.b.dataPosition();
                Parcel obtain = Parcel.obtain();
                obtain.appendFrom(this.b, dataPosition2, readInt2);
                sparseArray2.append(readInt, obtain);
                this.b.setDataPosition(dataPosition2 + readInt2);
            } else {
                sparseArray2.append(readInt, (Object) null);
            }
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public SparseBooleanArray createSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseBooleanArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        SparseBooleanArray readSparseBooleanArray = this.b.readSparseBooleanArray();
        this.b.setDataPosition(dataPosition + b2);
        return readSparseBooleanArray;
    }

    public SparseIntArray createSparseIntArray(int i, SparseIntArray sparseIntArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseIntArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            sparseIntArray2.append(this.b.readInt(), this.b.readInt());
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseIntArray2;
    }

    public SparseLongArray createSparseLongArray(int i, SparseLongArray sparseLongArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseLongArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        SparseLongArray sparseLongArray2 = new SparseLongArray();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            sparseLongArray2.append(this.b.readInt(), this.b.readLong());
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseLongArray2;
    }

    public String createString(int i, String str) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return str;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        String readString = this.b.readString();
        this.b.setDataPosition(dataPosition + b2);
        return readString;
    }

    public String[] createStringArray(int i, String[] strArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return strArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        String[] createStringArray = this.b.createStringArray();
        this.b.setDataPosition(dataPosition + b2);
        return createStringArray;
    }

    public ArrayList<String> createStringList(int i, ArrayList<String> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<String> createStringArrayList = this.b.createStringArrayList();
        this.b.setDataPosition(dataPosition + b2);
        return createStringArrayList;
    }

    public SparseArray<String> createStringSparseArray(int i, SparseArray<String> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        SparseArray<String> sparseArray2 = new SparseArray<>();
        int a2 = a(this.b.readInt());
        for (int i2 = 0; i2 < a2; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.readString());
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public <T> T[] createTypedArray(int i, Parcelable.Creator<T> creator, T[] tArr) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return tArr;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        T[] createTypedArray = this.b.createTypedArray(creator);
        this.b.setDataPosition(dataPosition + b2);
        return createTypedArray;
    }

    public <T> ArrayList<T> createTypedList(int i, Parcelable.Creator<T> creator, ArrayList<T> arrayList) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return arrayList;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        ArrayList<T> createTypedArrayList = this.b.createTypedArrayList(creator);
        this.b.setDataPosition(dataPosition + b2);
        return createTypedArrayList;
    }

    public <T> SparseArray<T> createTypedSparseArray(int i, Parcelable.Creator<T> creator, SparseArray<T> sparseArray) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return sparseArray;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        int a2 = a(this.b.readInt());
        SparseArray<T> sparseArray2 = new SparseArray<>();
        for (int i2 = 0; i2 < a2; i2++) {
            sparseArray2.append(this.b.readInt(), this.b.readInt() != 0 ? creator.createFromParcel(this.b) : null);
        }
        this.b.setDataPosition(dataPosition + b2);
        return sparseArray2;
    }

    public boolean readBoolean(int i, boolean z) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return z;
        }
        b(i, 4);
        return this.b.readInt() != 0;
    }

    public Boolean readBooleanObject(int i, Boolean bool) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bool;
        }
        if (b(i) == 0) {
            return null;
        }
        a(i, 4);
        int readInt = this.b.readInt();
        if (readInt == 0) {
            return Boolean.FALSE;
        }
        if (readInt != 1) {
            return null;
        }
        return Boolean.TRUE;
    }

    public Bundle readBundle(int i, Bundle bundle) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return bundle;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        Bundle readBundle = this.b.readBundle();
        this.b.setDataPosition(dataPosition + b2);
        return readBundle;
    }

    public byte readByte(int i, byte b2) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return b2;
        }
        b(i, 4);
        return (byte) this.b.readInt();
    }

    public char readChar(int i, char c2) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return c2;
        }
        b(i, 4);
        return (char) this.b.readInt();
    }

    public double readDouble(int i, double d2) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return d2;
        }
        b(i, 8);
        return this.b.readDouble();
    }

    public Double readDoubleObject(int i, Double d2) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return d2;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        a(b2, 8);
        return Double.valueOf(this.b.readDouble());
    }

    public float readFloat(int i, float f) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return f;
        }
        b(i, 4);
        return this.b.readFloat();
    }

    public Float readFloatObject(int i, Float f) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return f;
        }
        if (b(i) == 0) {
            return null;
        }
        a(i, 4);
        return Float.valueOf(this.b.readFloat());
    }

    public IBinder readIBinder(int i, IBinder iBinder) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return iBinder;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        IBinder readStrongBinder = this.b.readStrongBinder();
        this.b.setDataPosition(dataPosition + b2);
        return readStrongBinder;
    }

    public int readInt(int i, int i2) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return i2;
        }
        b(i, 4);
        return this.b.readInt();
    }

    public Integer readIntegerObject(int i, Integer num) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return num;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        a(b2, 4);
        return Integer.valueOf(this.b.readInt());
    }

    public void readList(int i, List list, ClassLoader classLoader) {
        if (this.a.containsKey(Integer.valueOf(i))) {
            int b2 = b(i);
            int dataPosition = this.b.dataPosition();
            if (b2 != 0) {
                this.b.readList(list, classLoader);
                this.b.setDataPosition(dataPosition + b2);
            }
        }
    }

    public long readLong(int i, long j) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return j;
        }
        b(i, 8);
        return this.b.readLong();
    }

    public Long readLongObject(int i, Long l) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return l;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        a(b2, 8);
        return Long.valueOf(this.b.readLong());
    }

    public <T extends Parcelable> T readParcelable(int i, Parcelable.Creator<T> creator, T t) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return t;
        }
        int b2 = b(i);
        if (b2 == 0) {
            return null;
        }
        int dataPosition = this.b.dataPosition();
        T t2 = (Parcelable) creator.createFromParcel(this.b);
        this.b.setDataPosition(dataPosition + b2);
        return t2;
    }

    public short readShort(int i, short s) {
        if (!this.a.containsKey(Integer.valueOf(i))) {
            return s;
        }
        b(i, 4);
        return (short) this.b.readInt();
    }
}
