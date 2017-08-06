package io.dblog.common.exception;

/**
 * {@code NotFoundException} resource is not found
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class NotFoundException extends BaseException{
    public NotFoundException() {
        super(404);
    }

    public NotFoundException(String message) {
        super(404, message);
    }
}
