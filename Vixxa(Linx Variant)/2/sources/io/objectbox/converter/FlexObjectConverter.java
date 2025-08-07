package io.objectbox.converter;

import io.objectbox.flatbuffers.ArrayReadWriteBuf;
import io.objectbox.flatbuffers.FlexBuffers;
import io.objectbox.flatbuffers.FlexBuffersBuilder;
import io.objectbox.flatbuffers.ReadBuf;
import io.objectbox.flatbuffers.ReadWriteBuf;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class FlexObjectConverter implements PropertyConverter<Object, byte[]> {
    private static final AtomicReference<FlexBuffersBuilder> cachedBuilder = new AtomicReference<>();

    /* access modifiers changed from: package-private */
    public Object convertToKey(String str) {
        return str;
    }

    public byte[] convertToDatabaseValue(Object obj) {
        if (obj == null) {
            return null;
        }
        AtomicReference<FlexBuffersBuilder> atomicReference = cachedBuilder;
        FlexBuffersBuilder andSet = atomicReference.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new FlexBuffersBuilder((ReadWriteBuf) new ArrayReadWriteBuf(512), 3);
        }
        addValue(andSet, obj);
        ByteBuffer finish = andSet.finish();
        byte[] bArr = new byte[finish.limit()];
        finish.get(bArr);
        if (finish.limit() <= 262144) {
            andSet.clear();
            atomicReference.getAndSet(andSet);
        }
        return bArr;
    }

    private void addValue(FlexBuffersBuilder flexBuffersBuilder, Object obj) {
        if (obj instanceof Map) {
            addMap(flexBuffersBuilder, (String) null, (Map) obj);
        } else if (obj instanceof List) {
            addVector(flexBuffersBuilder, (String) null, (List) obj);
        } else if (obj instanceof String) {
            flexBuffersBuilder.putString((String) obj);
        } else if (obj instanceof Boolean) {
            flexBuffersBuilder.putBoolean(((Boolean) obj).booleanValue());
        } else if (obj instanceof Byte) {
            flexBuffersBuilder.putInt(((Byte) obj).intValue());
        } else if (obj instanceof Short) {
            flexBuffersBuilder.putInt(((Short) obj).intValue());
        } else if (obj instanceof Integer) {
            flexBuffersBuilder.putInt(((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            flexBuffersBuilder.putInt(((Long) obj).longValue());
        } else if (obj instanceof Float) {
            flexBuffersBuilder.putFloat(((Float) obj).floatValue());
        } else if (obj instanceof Double) {
            flexBuffersBuilder.putFloat(((Double) obj).doubleValue());
        } else if (obj instanceof byte[]) {
            flexBuffersBuilder.putBlob((byte[]) obj);
        } else {
            throw new IllegalArgumentException("Values of this type are not supported: " + obj.getClass().getSimpleName());
        }
    }

    /* access modifiers changed from: protected */
    public void checkMapKeyType(Object obj) {
        if (!(obj instanceof String)) {
            throw new IllegalArgumentException("Map keys must be String");
        }
    }

    private void addMap(FlexBuffersBuilder flexBuffersBuilder, String str, Map<Object, Object> map) {
        int startMap = flexBuffersBuilder.startMap();
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (key == null || value == null) {
                throw new IllegalArgumentException("Map keys or values must not be null");
            }
            checkMapKeyType(key);
            String obj = key.toString();
            if (value instanceof Map) {
                addMap(flexBuffersBuilder, obj, (Map) value);
            } else if (value instanceof List) {
                addVector(flexBuffersBuilder, obj, (List) value);
            } else if (value instanceof String) {
                flexBuffersBuilder.putString(obj, (String) value);
            } else if (value instanceof Boolean) {
                flexBuffersBuilder.putBoolean(obj, ((Boolean) value).booleanValue());
            } else if (value instanceof Byte) {
                flexBuffersBuilder.putInt(obj, ((Byte) value).intValue());
            } else if (value instanceof Short) {
                flexBuffersBuilder.putInt(obj, ((Short) value).intValue());
            } else if (value instanceof Integer) {
                flexBuffersBuilder.putInt(obj, ((Integer) value).intValue());
            } else if (value instanceof Long) {
                flexBuffersBuilder.putInt(obj, ((Long) value).longValue());
            } else if (value instanceof Float) {
                flexBuffersBuilder.putFloat(obj, ((Float) value).floatValue());
            } else if (value instanceof Double) {
                flexBuffersBuilder.putFloat(obj, ((Double) value).doubleValue());
            } else if (value instanceof byte[]) {
                flexBuffersBuilder.putBlob(obj, (byte[]) value);
            } else {
                throw new IllegalArgumentException("Map values of this type are not supported: " + value.getClass().getSimpleName());
            }
        }
        flexBuffersBuilder.endMap(str, startMap);
    }

    private void addVector(FlexBuffersBuilder flexBuffersBuilder, String str, List<Object> list) {
        int startVector = flexBuffersBuilder.startVector();
        for (Object next : list) {
            if (next == null) {
                throw new IllegalArgumentException("List elements must not be null");
            } else if (next instanceof Map) {
                addMap(flexBuffersBuilder, (String) null, (Map) next);
            } else if (next instanceof List) {
                addVector(flexBuffersBuilder, (String) null, (List) next);
            } else if (next instanceof String) {
                flexBuffersBuilder.putString((String) next);
            } else if (next instanceof Boolean) {
                flexBuffersBuilder.putBoolean(((Boolean) next).booleanValue());
            } else if (next instanceof Byte) {
                flexBuffersBuilder.putInt(((Byte) next).intValue());
            } else if (next instanceof Short) {
                flexBuffersBuilder.putInt(((Short) next).intValue());
            } else if (next instanceof Integer) {
                flexBuffersBuilder.putInt(((Integer) next).intValue());
            } else if (next instanceof Long) {
                flexBuffersBuilder.putInt(((Long) next).longValue());
            } else if (next instanceof Float) {
                flexBuffersBuilder.putFloat(((Float) next).floatValue());
            } else if (next instanceof Double) {
                flexBuffersBuilder.putFloat(((Double) next).doubleValue());
            } else if (next instanceof byte[]) {
                flexBuffersBuilder.putBlob((byte[]) next);
            } else {
                throw new IllegalArgumentException("List values of this type are not supported: " + next.getClass().getSimpleName());
            }
        }
        flexBuffersBuilder.endVector(str, startVector, false, false);
    }

    public Object convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        FlexBuffers.Reference root = FlexBuffers.getRoot((ReadBuf) new ArrayReadWriteBuf(bArr, bArr.length));
        if (root.isMap()) {
            return buildMap(root.asMap());
        }
        if (root.isVector()) {
            return buildList(root.asVector());
        }
        if (root.isString()) {
            return root.asString();
        }
        if (root.isBoolean()) {
            return Boolean.valueOf(root.asBoolean());
        }
        if (root.isInt()) {
            if (shouldRestoreAsLong(root)) {
                return Long.valueOf(root.asLong());
            }
            return Integer.valueOf(root.asInt());
        } else if (root.isFloat()) {
            return Double.valueOf(root.asFloat());
        } else {
            if (root.isBlob()) {
                return root.asBlob().getBytes();
            }
            throw new IllegalArgumentException("FlexBuffers type is not supported: " + root.getType());
        }
    }

    /* access modifiers changed from: protected */
    public boolean shouldRestoreAsLong(FlexBuffers.Reference reference) {
        try {
            Field declaredField = reference.getClass().getDeclaredField("parentWidth");
            declaredField.setAccessible(true);
            if (((Integer) declaredField.get(reference)).intValue() == 8) {
                return true;
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("FlexMapConverter could not determine FlexBuffers integer bit width.", e);
        }
    }

    private Map<Object, Object> buildMap(FlexBuffers.Map map) {
        int size = map.size();
        FlexBuffers.KeyVector keys = map.keys();
        FlexBuffers.Vector values = map.values();
        HashMap hashMap = new HashMap((int) ((((double) size) / 0.75d) + 1.0d));
        for (int i = 0; i < size; i++) {
            Object convertToKey = convertToKey(keys.get(i).toString());
            FlexBuffers.Reference reference = values.get(i);
            if (reference.isMap()) {
                hashMap.put(convertToKey, buildMap(reference.asMap()));
            } else if (reference.isVector()) {
                hashMap.put(convertToKey, buildList(reference.asVector()));
            } else if (reference.isString()) {
                hashMap.put(convertToKey, reference.asString());
            } else if (reference.isBoolean()) {
                hashMap.put(convertToKey, Boolean.valueOf(reference.asBoolean()));
            } else if (reference.isInt()) {
                if (shouldRestoreAsLong(reference)) {
                    hashMap.put(convertToKey, Long.valueOf(reference.asLong()));
                } else {
                    hashMap.put(convertToKey, Integer.valueOf(reference.asInt()));
                }
            } else if (reference.isFloat()) {
                hashMap.put(convertToKey, Double.valueOf(reference.asFloat()));
            } else if (reference.isBlob()) {
                hashMap.put(convertToKey, reference.asBlob().getBytes());
            } else {
                throw new IllegalArgumentException("Map values of this type are not supported: " + reference.getClass().getSimpleName());
            }
        }
        return hashMap;
    }

    private List<Object> buildList(FlexBuffers.Vector vector) {
        int size = vector.size();
        ArrayList arrayList = new ArrayList(size);
        Boolean bool = null;
        for (int i = 0; i < size; i++) {
            FlexBuffers.Reference reference = vector.get(i);
            if (reference.isMap()) {
                arrayList.add(buildMap(reference.asMap()));
            } else if (reference.isVector()) {
                arrayList.add(buildList(reference.asVector()));
            } else if (reference.isString()) {
                arrayList.add(reference.asString());
            } else if (reference.isBoolean()) {
                arrayList.add(Boolean.valueOf(reference.asBoolean()));
            } else if (reference.isInt()) {
                if (bool == null) {
                    bool = Boolean.valueOf(shouldRestoreAsLong(reference));
                }
                if (bool.booleanValue()) {
                    arrayList.add(Long.valueOf(reference.asLong()));
                } else {
                    arrayList.add(Integer.valueOf(reference.asInt()));
                }
            } else if (reference.isFloat()) {
                arrayList.add(Double.valueOf(reference.asFloat()));
            } else if (reference.isBlob()) {
                arrayList.add(reference.asBlob().getBytes());
            } else {
                throw new IllegalArgumentException("List values of this type are not supported: " + reference.getClass().getSimpleName());
            }
        }
        return arrayList;
    }
}
