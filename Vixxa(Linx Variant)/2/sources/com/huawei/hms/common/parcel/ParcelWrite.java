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
import java.util.List;

public class ParcelWrite {
    public static final int b = 65262;
    public Parcel a;

    public ParcelWrite(Parcel parcel) {
        this.a = parcel;
    }

    private int a(int i) {
        this.a.writeInt(i | SupportMenu.CATEGORY_MASK);
        this.a.writeInt(0);
        return this.a.dataPosition();
    }

    private void a(int i, int i2) {
        if (i2 >= 65535) {
            this.a.writeInt(i | SupportMenu.CATEGORY_MASK);
            this.a.writeInt(i2);
            return;
        }
        this.a.writeInt(i | (i2 << 16));
    }

    private <T extends Parcelable> void a(T t, int i) {
        int dataPosition = this.a.dataPosition();
        this.a.writeInt(1);
        int dataPosition2 = this.a.dataPosition();
        t.writeToParcel(this.a, i);
        int dataPosition3 = this.a.dataPosition();
        this.a.setDataPosition(dataPosition);
        this.a.writeInt(dataPosition3 - dataPosition2);
        this.a.setDataPosition(dataPosition3);
    }

    private void b(int i) {
        int dataPosition = this.a.dataPosition();
        this.a.setDataPosition(i - 4);
        this.a.writeInt(dataPosition - i);
        this.a.setDataPosition(dataPosition);
    }

    public int beginObjectHeader() {
        return a(65262);
    }

    public void finishObjectHeader(int i) {
        b(i);
    }

    public void writeBigDecimal(int i, BigDecimal bigDecimal, boolean z) {
        if (bigDecimal != null) {
            int a2 = a(i);
            this.a.writeByteArray(bigDecimal.unscaledValue().toByteArray());
            this.a.writeInt(bigDecimal.scale());
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBigDecimalArray(int i, BigDecimal[] bigDecimalArr, boolean z) {
        if (bigDecimalArr != null) {
            int a2 = a(i);
            int length = bigDecimalArr.length;
            this.a.writeInt(length);
            for (int i2 = 0; i2 < length; i2++) {
                this.a.writeByteArray(bigDecimalArr[i2].unscaledValue().toByteArray());
                this.a.writeInt(bigDecimalArr[i2].scale());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBigInteger(int i, BigInteger bigInteger, boolean z) {
        if (bigInteger != null) {
            int a2 = a(i);
            this.a.writeByteArray(bigInteger.toByteArray());
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBigIntegerArray(int i, BigInteger[] bigIntegerArr, boolean z) {
        if (bigIntegerArr != null) {
            int a2 = a(i);
            this.a.writeInt(r6);
            for (BigInteger byteArray : bigIntegerArr) {
                this.a.writeByteArray(byteArray.toByteArray());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBoolean(int i, boolean z) {
        a(i, 4);
        this.a.writeInt(z ? 1 : 0);
    }

    public void writeBooleanArray(int i, boolean[] zArr, boolean z) {
        if (zArr != null) {
            int a2 = a(i);
            this.a.writeBooleanArray(zArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBooleanList(int i, List<Boolean> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(list.get(i2).booleanValue() ? 1 : 0);
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBooleanObject(int i, Boolean bool) {
        writeBooleanObject(i, bool, false);
    }

    public void writeBooleanObject(int i, Boolean bool, boolean z) {
        if (bool != null) {
            a(i, 4);
            this.a.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeBundle(int i, Bundle bundle, boolean z) {
        if (bundle != null) {
            int a2 = a(i);
            this.a.writeBundle(bundle);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeByte(int i, byte b2) {
        a(i, 4);
        this.a.writeInt(b2);
    }

    public void writeByteArray(int i, byte[] bArr, boolean z) {
        if (bArr != null) {
            int a2 = a(i);
            this.a.writeByteArray(bArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeByteArrayArray(int i, byte[][] bArr, boolean z) {
        if (bArr != null) {
            int a2 = a(i);
            this.a.writeInt(r6);
            for (byte[] writeByteArray : bArr) {
                this.a.writeByteArray(writeByteArray);
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeByteArraySparseArray(int i, SparseArray<byte[]> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                this.a.writeByteArray(sparseArray.valueAt(i2));
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeChar(int i, char c) {
        a(i, 4);
        this.a.writeInt(c);
    }

    public void writeCharArray(int i, char[] cArr, boolean z) {
        if (cArr != null) {
            int a2 = a(i);
            this.a.writeCharArray(cArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeDouble(int i, double d) {
        a(i, 8);
        this.a.writeDouble(d);
    }

    public void writeDoubleArray(int i, double[] dArr, boolean z) {
        if (dArr != null) {
            int a2 = a(i);
            this.a.writeDoubleArray(dArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeDoubleList(int i, List<Double> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeDouble(list.get(i2).doubleValue());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeDoubleObject(int i, Double d, boolean z) {
        if (d != null) {
            a(i, 8);
            this.a.writeDouble(d.doubleValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeDoubleSparseArray(int i, SparseArray<Double> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                this.a.writeDouble(sparseArray.valueAt(i2).doubleValue());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeFloat(int i, float f) {
        a(i, 4);
        this.a.writeFloat(f);
    }

    public void writeFloatArray(int i, float[] fArr, boolean z) {
        if (fArr != null) {
            int a2 = a(i);
            this.a.writeFloatArray(fArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeFloatList(int i, List<Float> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeFloat(list.get(i2).floatValue());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeFloatObject(int i, Float f, boolean z) {
        if (f != null) {
            a(i, 4);
            this.a.writeFloat(f.floatValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeFloatSparseArray(int i, SparseArray<Float> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                this.a.writeFloat(sparseArray.valueAt(i2).floatValue());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeIBinder(int i, IBinder iBinder, boolean z) {
        if (iBinder != null) {
            int a2 = a(i);
            this.a.writeStrongBinder(iBinder);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeIBinderArray(int i, IBinder[] iBinderArr, boolean z) {
        if (iBinderArr != null) {
            int a2 = a(i);
            this.a.writeBinderArray(iBinderArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeIBinderList(int i, List<IBinder> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            this.a.writeBinderList(list);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeIBinderSparseArray(int i, SparseArray<IBinder> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                this.a.writeStrongBinder(sparseArray.valueAt(i2));
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeInt(int i, int i2) {
        a(i, 4);
        this.a.writeInt(i2);
    }

    public void writeIntArray(int i, int[] iArr, boolean z) {
        if (iArr != null) {
            int a2 = a(i);
            this.a.writeIntArray(iArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeIntegerList(int i, List<Integer> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(list.get(i2).intValue());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeIntegerObject(int i, Integer num, boolean z) {
        if (num != null) {
            a(i, 4);
            this.a.writeInt(num.intValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeList(int i, List list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            this.a.writeList(list);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeLong(int i, long j) {
        a(i, 8);
        this.a.writeLong(j);
    }

    public void writeLongArray(int i, long[] jArr, boolean z) {
        if (jArr != null) {
            int a2 = a(i);
            this.a.writeLongArray(jArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeLongList(int i, List<Long> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeLong(list.get(i2).longValue());
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeLongObject(int i, Long l, boolean z) {
        if (l != null) {
            a(i, 8);
            this.a.writeLong(l.longValue());
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeParcel(int i, Parcel parcel, boolean z) {
        if (parcel != null) {
            int a2 = a(i);
            this.a.appendFrom(parcel, 0, parcel.dataSize());
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeParcelArray(int i, Parcel[] parcelArr, boolean z) {
        if (parcelArr != null) {
            int a2 = a(i);
            this.a.writeInt(r8);
            for (Parcel parcel : parcelArr) {
                if (parcel != null) {
                    this.a.writeInt(parcel.dataSize());
                    this.a.appendFrom(parcel, 0, parcel.dataSize());
                } else {
                    this.a.writeInt(0);
                }
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeParcelList(int i, List<Parcel> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcel parcel = list.get(i2);
                if (parcel != null) {
                    this.a.writeInt(parcel.dataSize());
                    this.a.appendFrom(parcel, 0, parcel.dataSize());
                } else {
                    this.a.writeInt(0);
                }
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeParcelSparseArray(int i, SparseArray<Parcel> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                Parcel valueAt = sparseArray.valueAt(i2);
                if (valueAt != null) {
                    this.a.writeInt(valueAt.dataSize());
                    this.a.appendFrom(valueAt, 0, valueAt.dataSize());
                } else {
                    this.a.writeInt(0);
                }
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeParcelable(int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable != null) {
            int a2 = a(i);
            parcelable.writeToParcel(this.a, i2);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeShort(int i, short s) {
        a(i, 4);
        this.a.writeInt(s);
    }

    public void writeSparseBooleanArray(int i, SparseBooleanArray sparseBooleanArray, boolean z) {
        if (sparseBooleanArray != null) {
            int a2 = a(i);
            this.a.writeSparseBooleanArray(sparseBooleanArray);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeSparseIntArray(int i, SparseIntArray sparseIntArray, boolean z) {
        if (sparseIntArray != null) {
            int a2 = a(i);
            int size = sparseIntArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseIntArray.keyAt(i2));
                this.a.writeInt(sparseIntArray.valueAt(i2));
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeSparseLongArray(int i, SparseLongArray sparseLongArray, boolean z) {
        if (sparseLongArray != null) {
            int a2 = a(i);
            int size = sparseLongArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseLongArray.keyAt(i2));
                this.a.writeLong(sparseLongArray.valueAt(i2));
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeString(int i, String str, boolean z) {
        if (str != null) {
            int a2 = a(i);
            this.a.writeString(str);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeStringArray(int i, String[] strArr, boolean z) {
        if (strArr != null) {
            int a2 = a(i);
            this.a.writeStringArray(strArr);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeStringList(int i, List<String> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            this.a.writeStringList(list);
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public void writeStringSparseArray(int i, SparseArray<String> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                this.a.writeString(sparseArray.valueAt(i2));
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public <T extends Parcelable> void writeTypedArray(int i, T[] tArr, int i2, boolean z) {
        if (tArr != null) {
            int a2 = a(i);
            this.a.writeInt(r7);
            for (T t : tArr) {
                if (t == null) {
                    this.a.writeInt(0);
                } else {
                    a(t, i2);
                }
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public <T extends Parcelable> void writeTypedList(int i, List<T> list, boolean z) {
        if (list != null) {
            int a2 = a(i);
            int size = list.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                Parcelable parcelable = (Parcelable) list.get(i2);
                if (parcelable == null) {
                    this.a.writeInt(0);
                } else {
                    a(parcelable, 0);
                }
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }

    public <T extends Parcelable> void writeTypedSparseArray(int i, SparseArray<T> sparseArray, boolean z) {
        if (sparseArray != null) {
            int a2 = a(i);
            int size = sparseArray.size();
            this.a.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                this.a.writeInt(sparseArray.keyAt(i2));
                Parcelable parcelable = (Parcelable) sparseArray.valueAt(i2);
                if (parcelable == null) {
                    this.a.writeInt(0);
                } else {
                    a(parcelable, 0);
                }
            }
            b(a2);
        } else if (z) {
            a(i, 0);
        }
    }
}
