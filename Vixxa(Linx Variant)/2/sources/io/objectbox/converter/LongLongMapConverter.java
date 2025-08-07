package io.objectbox.converter;

import io.objectbox.flatbuffers.FlexBuffers;

public class LongLongMapConverter extends LongFlexMapConverter {
    /* access modifiers changed from: protected */
    public boolean shouldRestoreAsLong(FlexBuffers.Reference reference) {
        return true;
    }
}
