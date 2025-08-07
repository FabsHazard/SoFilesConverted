package io.objectbox.converter;

import javax.annotation.Nullable;

public class NullToEmptyStringConverter implements PropertyConverter<String, String> {
    public String convertToDatabaseValue(String str) {
        return str;
    }

    public String convertToEntityProperty(@Nullable String str) {
        return str == null ? "" : str;
    }
}
