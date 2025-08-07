package io.objectbox.exception;

/* compiled from: DbExceptionListener */
class DbExceptionListenerJni {
    static native void nativeCancelCurrentException();

    static native void nativeThrowException(long j, int i);

    DbExceptionListenerJni() {
    }
}
