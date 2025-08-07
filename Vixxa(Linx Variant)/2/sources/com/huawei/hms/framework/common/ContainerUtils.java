package com.huawei.hms.framework.common;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ContainerUtils {
    public static final String FIELD_DELIMITER = "&";
    public static final String KEY_VALUE_DELIMITER = "=";

    public static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map == null || map2 == null || map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry next : map.entrySet()) {
            if (map2.get(next.getKey()) != next.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static <K, V> int hashCode(Map<K, V> map) {
        return toString(map).hashCode();
    }

    public static <K, V> String toString(Map<K, V> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(FIELD_DELIMITER);
            }
            sb.append(next.getKey().toString()).append(KEY_VALUE_DELIMITER).append(next.getValue().toString());
            i = i2;
        }
        return sb.toString();
    }

    public static <K> String toString(Set<K> set) {
        if (set == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (K next : set) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(FIELD_DELIMITER);
            }
            sb.append(next.toString());
            i = i2;
        }
        return sb.toString();
    }

    public static <K> String toString(List<K> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (K next : list) {
            int i2 = i + 1;
            if (i > 0) {
                sb.append(FIELD_DELIMITER);
            }
            sb.append(next.toString());
            i = i2;
        }
        return sb.toString();
    }
}
