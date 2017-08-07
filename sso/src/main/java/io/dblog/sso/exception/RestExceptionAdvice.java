package io.dblog.sso.exception;

import io.dblog.common.exception.BadRequestException;
import io.dblog.common.exception.ForbiddenException;
import io.dblog.common.exception.GoneException;
import io.dblog.common.exception.NotFoundException;
import io.dblog.common.exception.Result;
import io.dblog.common.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * {@code RestExceptionAdvice}
 *
 * @author Pelin_li(penglong95.li@gmail.com)
 */
@ControllerAdvice
public class RestExceptionAdvice {

    // 400
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleBadRequestException(BadRequestException e) {
        return Result.failed(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Result handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return Result.failed(400, e.getMessage());
    }

    // 401
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public Result handleNotFoundException(UnauthorizedException e) {
        return Result.failed(e.getCode(), e.getMessage());
    }

    // 403
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    @ResponseBody
    public Result handleForbiddenException(ForbiddenException e) {
        return Result.failed(e.getCode(), e.getMessage());
    }

    // 404
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public Result handleNotFoundException(NotFoundException e) {
        return Result.failed(e.getCode(), e.getMessage());
    }

    // 410
    @ExceptionHandler(GoneException.class)
    @ResponseStatus(value = HttpStatus.GONE)
    @ResponseBody
    public Result handleGoneException(GoneException e) {
        return Result.failed(e.getCode(), e.getMessage());
    }


}
