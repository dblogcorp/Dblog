package io.dblog.common.exception;

/**
 * {@code BadRequestException} Request exception, param vertification error
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class BadRequestException extends BaseException {

    public BadRequestException() {
        super(400);
    }

    public BadRequestException(String message) {
        super(400, message);
    }
}
