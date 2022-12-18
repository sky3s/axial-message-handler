package com.axial.modules.message_handler.exception.type;

import com.axial.modules.message_handler.model.Message;

import java.io.Serializable;


public class DataNotFoundException extends BaseException implements Serializable {

    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String code, String message, Message... messages) {
        super(code, message, messages);
    }
}
