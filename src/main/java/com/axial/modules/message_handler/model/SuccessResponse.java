package com.axial.modules.message_handler.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on December, 2022
 */
@Getter
@Setter
@NoArgsConstructor
public class SuccessResponse<T> {

    private Message message;

    private boolean success = true;

    private T result;

}
