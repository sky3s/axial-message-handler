package com.axial.modules.message_handler.exception;

import com.axial.modules.message_handler.CoreMessages;
import com.axial.modules.message_handler.MessageUtils;
import com.axial.modules.message_handler.exception.type.*;
import com.axial.modules.message_handler.model.Message;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Locale;


@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExceptionHelper {


    public static AuthException newAuthException(String code, Object... args) {

        return newException(AuthException.class, code, args);
    }

    public static ValidationException newValidationException(String code, Object... args) {

        return newException(ValidationException.class, code, args);
    }

    public static ExternalServiceException newExternalServiceException(String code, Object... args) {

        return newException(ExternalServiceException.class, code, args);
    }

    public static DataNotFoundException newDataNotFoundException(String code, Object... args) {

        return newException(DataNotFoundException.class, code, args);
    }

    public static DataAlreadyExistException newDataAlreadyExistException(String code, Object... args) {

        return newException(DataAlreadyExistException.class, code, args);
    }



    public static AuthException newAuthException(String code, Locale locale, Object... args) {

        return newException(AuthException.class, code, locale, args);
    }

    public static ValidationException newValidationException(String code, Locale locale, Object... args) {

        return newException(ValidationException.class, code, locale, args);
    }

    public static ExternalServiceException newExternalServiceException(String code, Locale locale, Object... args) {

        return newException(ExternalServiceException.class, code, locale, args);
    }

    public static DataNotFoundException newDataNotFoundException(String code, Locale locale, Object... args) {

        return newException(DataNotFoundException.class, code, locale, args);
    }

    public static DataAlreadyExistException newDataAlreadyExistException(String code, Locale locale, Object... args) {

        return newException(DataAlreadyExistException.class, code, locale, args);
    }



    public static AuthException newAuthException(CoreMessages message, Object... args) {

        return newException(AuthException.class, message, args);
    }

    public static ValidationException newValidationException(CoreMessages message, Object... args) {

        return newException(ValidationException.class, message, args);
    }

    public static ExternalServiceException newExternalServiceException(CoreMessages message, Object... args) {

        return newException(ExternalServiceException.class, message, args);
    }

    public static DataNotFoundException newDataNotFoundException(CoreMessages message, Object... args) {

        return newException(DataNotFoundException.class, message, args);
    }

    public static DataAlreadyExistException newDataAlreadyExistException(CoreMessages message, Object... args) {

        return newException(DataAlreadyExistException.class, message, args);
    }



    private static <T extends BaseException> T newException(Class<T> exceptionType, String code, Object... args) {

        return newException(exceptionType, code, MessageUtils.getLocale(), args);
    }

    private static <T extends BaseException> T newException(Class<T> exceptionType, String code, Locale locale, Object... args) {

        final String message = MessageUtils.getMessage(code, locale, args);
        return newException(exceptionType, code, message);
    }

    private static <T extends BaseException> T newException(Class<T> exceptionType, CoreMessages message, Object... args) {

        return newException(exceptionType, message, null, args);
    }

    private static <T extends BaseException> T newException(Class<T> exceptionType, CoreMessages message, Locale locale, Object... args) {

        final String messageCode = message.getCode();
        final String messageText = MessageUtils.generateExternalMessage(message.getMessage(), args);
        return newException(exceptionType, messageCode, messageText);
    }



    private static <T extends BaseException> T newException(Class<T> exceptionType, String code, String message) {

        if (AuthException.class.equals(exceptionType)) {
            return (T) new AuthException(code, message, new Message[0]);
        }

        if (ValidationException.class.equals(exceptionType)) {
            return (T) new ValidationException(code, message, new Message[0]);
        }

        if (ExternalServiceException.class.equals(exceptionType)) {
            return (T) new ExternalServiceException(code, message, new Message[0]);
        }

        if (DataNotFoundException.class.equals(exceptionType)) {
            return (T) new DataNotFoundException(code, message, new Message[0]);
        }

        if (DataAlreadyExistException.class.equals(exceptionType)) {
            return (T) new DataAlreadyExistException(code, message, new Message[0]);
        }

        throw new UnsupportedOperationException(RestExceptionMessageCode.UNKNOWN_EXCEPTION_TYPE.getMessage());
    }

}
