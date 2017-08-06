package io.dblog.common.exception;

/**
 * {@code GoneException} resource had been deleted or hidden
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class GoneException extends BaseException{

    public GoneException() {
        super(410);
    }

    public GoneException(String message) {
        super(410, message);
    }
}
