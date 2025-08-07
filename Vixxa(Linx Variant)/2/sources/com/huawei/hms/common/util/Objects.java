package com.huawei.hms.common.util;

import com.huawei.hms.common.Preconditions;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Objects {

    public static final class ToStringHelper {
        public final List<String> a;
        public final Object b;

        public ToStringHelper(Object obj) {
            this.b = Preconditions.checkNotNull(obj);
            this.a = new ArrayList();
        }

        public ToStringHelper add(String str, Object obj) {
            String valueOf = String.valueOf(obj);
            this.a.add(((String) Preconditions.checkNotNull(str)) + ContainerUtils.KEY_VALUE_DELIMITER + valueOf);
            return this;
        }

        public String toString() {
            StringBuilder append = new StringBuilder(100).append(this.b.getClass().getSimpleName()).append('{');
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                append.append(this.a.get(i));
                if (i < size - 1) {
                    append.append(", ");
                }
            }
            return append.append('}').toString();
        }
    }

    public Objects() {
        throw new AssertionError("illegal argument");
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static ToStringHelper toStringHelper(Object obj) {
        return new ToStringHelper(obj);
    }
}
