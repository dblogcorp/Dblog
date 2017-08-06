package io.dblog.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code BaseException} super exception class
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseException extends RuntimeException {

    private int code;

    BaseException(int code) {
        this.code = code;
    }

    BaseException(int code, String msg) {
        super(msg);
        this.code = code;
    }
}
