package com.grocery.aop;

import com.grocery.domain.Message;
import com.grocery.exception.ErrorException;
import com.grocery.exception.StatusCode;
import com.grocery.utilities.PackingInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jason on 10/10/2017.
 */

//@ControllerAdvice
public class CatchException {

//    @ExceptionHandler(value = RuntimeException.class)
//    @ResponseBody
    public Message catchException(RuntimeException runtimeException) {

        if (runtimeException instanceof ErrorException) {
            return PackingInfo.changeException2Message((ErrorException) runtimeException);
        } else
            return PackingInfo.changeException2Message(new ErrorException(StatusCode.UNKNOWN));
    }

}
