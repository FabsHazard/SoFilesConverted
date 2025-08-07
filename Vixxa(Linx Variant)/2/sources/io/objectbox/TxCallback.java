package io.objectbox;

import javax.annotation.Nullable;

public interface TxCallback<T> {
    void txFinished(@Nullable T t, @Nullable Throwable th);
}
