package io.objectbox.sync;

public interface ObjectsMessageBuilder {
    ObjectsMessageBuilder addBytes(long j, byte[] bArr, boolean z);

    ObjectsMessageBuilder addString(long j, String str);

    boolean send();
}
