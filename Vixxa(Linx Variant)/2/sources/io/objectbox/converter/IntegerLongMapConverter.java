package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;

public class IntegerLongMapConverter extends IntegerFlexMapConverter {
    /* access modifiers changed from: protected */
    public boolean shouldRestoreAsLong(FlexBuffers.Reference reference) {
        return true;
    }
}
