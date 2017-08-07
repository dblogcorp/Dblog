package io.dblog.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * {@code Result}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Result {

    private int code;

    private String msg;

    private Object data;

    public void setData(Object ...objects) {
        this.data = objects;
    }

    public Result() {}

    public Result(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result succeed(Object ...objects) {
        return null;
    }

    public static Result failed(int code, String msg) {
        return new Result(code, msg);
    }
}
