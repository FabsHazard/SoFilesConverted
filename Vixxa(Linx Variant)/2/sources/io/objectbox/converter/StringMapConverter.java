package io.objectbox.converter;

import io.objectbox.flatbuffers.ArrayReadWriteBuf;
import io.objectbox.flatbuffers.FlexBuffers;
import io.objectbox.flatbuffers.FlexBuffersBuilder;
import io.objectbox.flatbuffers.ReadBuf;
import io.objectbox.flatbuffers.ReadWriteBuf;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class StringMapConverter implements PropertyConverter<Map<String, String>, byte[]> {
    private static final AtomicReference<FlexBuffersBuilder> cachedBuilder = new AtomicReference<>();

    public byte[] convertToDatabaseValue(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        FlexBuffersBuilder andSet = cachedBuilder.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new FlexBuffersBuilder((ReadWriteBuf) new ArrayReadWriteBuf(512), 3);
        }
        int startMap = andSet.startMap();
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() == null || next.getValue() == null) {
                throw new IllegalArgumentException("Map keys or values must not be null");
            }
            andSet.putString((String) next.getKey(), (String) next.getValue());
        }
        andSet.endMap((String) null, startMap);
        ByteBuffer finish = andSet.finish();
        byte[] bArr = new byte[finish.limit()];
        finish.get(bArr);
        if (finish.limit() <= 262144) {
            andSet.clear();
            cachedBuilder.getAndSet(andSet);
        }
        return bArr;
    }

    public Map<String, String> convertToEntityProperty(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        FlexBuffers.Map asMap = FlexBuffers.getRoot((ReadBuf) new ArrayReadWriteBuf(bArr, bArr.length)).asMap();
        int size = asMap.size();
        FlexBuffers.KeyVector keys = asMap.keys();
        FlexBuffers.Vector values = asMap.values();
        HashMap hashMap = new HashMap((int) ((((double) size) / 0.75d) + 1.0d));
        for (int i = 0; i < size; i++) {
            hashMap.put(keys.get(i).toString(), values.get(i).asString());
        }
        return hashMap;
    }
}
