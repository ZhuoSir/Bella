package com.creheart.platform.exception;

/**
 *
 * Created by sunny-chen on 2017/6/4.
 */
public class PlatformException extends Exception {


    public PlatformException() {
    }

    public PlatformException(String message) {
        super("PlatformException: " + message);
    }

    public PlatformException(String message, Throwable cause) {
        super("PlatformException: " + message, cause);
    }
}
