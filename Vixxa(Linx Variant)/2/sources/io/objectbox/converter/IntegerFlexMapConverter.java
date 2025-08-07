package io.objectbox.converter;

public class IntegerFlexMapConverter extends FlexObjectConverter {
    /* access modifiers changed from: protected */
    public void checkMapKeyType(Object obj) {
        if (!(obj instanceof Integer)) {
            throw new IllegalArgumentException("Map keys must be Integer");
        }
    }

    /* access modifiers changed from: package-private */
    public Integer convertToKey(String str) {
        return Integer.valueOf(str);
    }
}
