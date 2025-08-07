package io.objectbox.exception;

public interface DbExceptionListener {
    void onDbException(Exception exc);

    static void cancelCurrentException() {
        DbExceptionListenerJni.nativeCancelCurrentException();
    }
}
