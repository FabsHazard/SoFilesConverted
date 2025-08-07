package io.objectbox.exception;

public class PagesCorruptException extends FileCorruptException {
    public PagesCorruptException(String str) {
        super(str);
    }

    public PagesCorruptException(String str, int i) {
        super(str, i);
    }
}
