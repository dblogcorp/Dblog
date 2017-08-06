package io.dblog.common.exception;

/**
 * {@code UnAurhorizedException} user not get authorization
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
public class UnauthorizedException extends BaseException{
    public UnauthorizedException() {
        super(401);
    }

    public UnauthorizedException(String message) {
        super(401, message);
    }
}