package com.axial.modules.message_handler;

import com.axial.modules.message_handler.model.Severity;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created on December, 2022
 */
@Getter
@AllArgsConstructor
public enum CoreMessages {

    ONLY_ENUM_CLASSES_ALLOWED(Severity.ERROR, "exception.module.reflection.only_enum_classes_allowed", "Only enum classes allowed!"),
    ENUM_CODE_TYPE_INCOMPATIBLE(Severity.ERROR, "exception.module.reflection.enum_code_type_incompatible", "Enum code type and requested text type are incompatible."),
    ENUM_CODE_VALUE_INVALID(Severity.ERROR, "exception.module.reflection.enum_code_value_invalid", "Invalid enum code: {0}. Valid enum codes: {1}"),

    FIELD_VALUE_TYPE_INCOMPATIBLE(Severity.ERROR, "exception.module.reflection.field_value_type_incompatible", "Field value type and requested text type are incompatible."),
    CLASS_FIELD_NOT_EXIST(Severity.ERROR, "exception.module.reflection.class_field_not_exist", "No field found with this name: {0}"),
    CLASS_METHOD_NOT_EXIST(Severity.ERROR, "exception.module.reflection.class_method_not_exist", "No method found with this name: {0}"),

    METHOD_INVOCATION_FAILED(Severity.ERROR, "exception.module.reflection.method_invocation_failed", "Method invocation failed! Method name: {0} - Param class: {1} - Param Value: {2}"),


    PAGINATION_PAGE_NUMBER_OR_SIZE_SMALLER_THEN_ONE(Severity.ERROR, "exception.module.pagination.page_number_or_size_smaller_than_one", "Requested pagination page number or size smaller than 1."),
    PAGINATION_PAGE_NUMBER_TOO_LARGE(Severity.ERROR, "exception.module.pagination.page_number_too_large", "Requested pagination page number too large. Max page: {0}")


    ;


    private Severity severity;

    private String code;

    private String message;

}
