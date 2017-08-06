package io.dblog.common.exception;

/**
 * {@code FobiddenException} User get authorithention, but this request is forbidden
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class ForbiddenException extends BaseException{

    public ForbiddenException() {
        super(403);
    }

    public ForbiddenException(String message) {
        super(403, message);
    }

}
