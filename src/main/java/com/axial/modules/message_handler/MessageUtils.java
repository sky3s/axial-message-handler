package com.axial.modules.message_handler;

import com.axial.spring.modules.commons.utils.RequestUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.LocaleResolver;

import java.util.*;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MessageUtils {

    public static String getMessage(String messageKey, Object... args) {
        return getMessage(messageKey, MessageUtils.getLocale(), args);
    }

    public static String getMessage(String messageKey, Locale locale, Object... args) {
        return getLocalizedMessage(messageKey, locale, args);
    }

    public static Locale getLocale() {

        final LocaleResolver localeResolver = RequestUtils.getBean(LocaleResolver.class);
        final Locale locale = localeResolver.resolveLocale(RequestUtils.getCurrentRequest());
        return locale;
    }

    private static String getLocalizedMessage(String errorCode, Locale locale, Object... args) {

        if (StringUtils.isBlank(errorCode)) {
            return null;
        } else {
            Map<String, MessageSource> messageSources = RequestUtils.getBeansOfType(MessageSource.class);
            return messageSources.values().stream().map((messageSource) ->
                    getLocalizedMessageOrNull(messageSource, errorCode, args, locale)).filter(Objects::nonNull).findFirst().orElse(null);
        }
    }

    private static String getLocalizedMessageOrNull(MessageSource messageSource, String code, Object[] args, Locale locale) {

        try {
            return messageSource.getMessage(code, args, locale);
        } catch (NoSuchMessageException var5) {
            return null;
        }
    }

    public static String generateExternalMessage(String messageText, Object... args) {

        final List<Object> argList = Arrays.asList(args);

        if (CollectionUtils.isEmpty(argList)) {
            return messageText;
        }

        String resultText = messageText;

        for (int i = 0; i < args.length; i++) {
            resultText = resultText.replace("{" + i + "}", args[i].toString());
        }

        return resultText;
    }

}
