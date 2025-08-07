package io.objectbox.converter;

public class LongFlexMapConverter extends FlexObjectConverter {
    /* access modifiers changed from: protected */
    public void checkMapKeyType(Object obj) {
        if (!(obj instanceof Long)) {
            throw new IllegalArgumentException("Map keys must be Long");
        }
    }

    /* access modifiers changed from: package-private */
    public Object convertToKey(String str) {
        return Long.valueOf(str);
    }
}
