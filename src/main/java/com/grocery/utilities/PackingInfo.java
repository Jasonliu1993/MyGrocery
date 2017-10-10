package com.grocery.utilities;

import com.grocery.domain.Message;
import com.grocery.exception.ErrorException;
import com.grocery.exception.StatusCode;

/**
 * Created by Jason on 10/10/2017.
 */
public class PackingInfo {

    public static Message changeException2Message (ErrorException errorException) {
        Message message = new Message();

        message.setCode(errorException.getCode());
        message.setMessage(errorException.getMessage());

        return message;
    }

    public static Message changeData2Message(Object object) {

        Message message = new Message();

        message.setCode(StatusCode.SUCCESSFUL.getCode());
        message.setMessage(StatusCode.SUCCESSFUL.getErrorMessage());
        message.setData(object);

        return message;
    }

}
