package com.blog.common.exception;

import com.blog.common.lang.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionhandler {


  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler(value = ShiroException.class)
  public Result handler(ShiroException e){
    log.error("运行时异常-------------{}", e);
    return Result.fail(401, e.getMessage(), null);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(value = RuntimeException.class)
  public Result handler(RuntimeException e){
    log.error("运行时异常-------------{}", e);
    return Result.fail(e.getMessage());
  }

}
