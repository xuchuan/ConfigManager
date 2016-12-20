package net.xuchuan.common.gaiaconfig;

public class NoSuchPropertyException extends RuntimeException {
    public NoSuchPropertyException() {
    }

    public NoSuchPropertyException(String message) {
        super(message);
    }

    public NoSuchPropertyException(String message, Throwable cause) {
        super(message, cause);
    }
}
