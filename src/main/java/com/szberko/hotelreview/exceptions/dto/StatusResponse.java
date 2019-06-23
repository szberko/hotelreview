package com.szberko.hotelreview.exceptions.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class StatusResponse {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> fieldErrors;
    private List<ApiSubError> globalErrors;

    private StatusResponse(){
        this.timestamp = LocalDateTime.now();
    }

    public StatusResponse(HttpStatus status) {
        this();
        this.status = status;
    }

    public StatusResponse(HttpStatus status, Throwable ex){
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    public StatusResponse(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public void addFieldErrors(List<FieldError> errors){
        fieldErrors.addAll(errors.stream().map(this::convertFieldErrorToValidationError).collect(Collectors.toList()));
    }

    private ApiValidationError convertFieldErrorToValidationError(FieldError error) {
        return new ApiValidationError(
                error.getObjectName(),
                error.getField(),
                error.getRejectedValue(),
                error.getDefaultMessage()
        );
    }

    public void addGlobalErrors(List<ObjectError> errors){
        globalErrors.addAll(errors.stream().map(this::convertGlobalErrorToValidationError).collect(Collectors.toList()));
    }

    private ApiValidationError convertGlobalErrorToValidationError(ObjectError error){
        return new ApiValidationError(
                error.getObjectName(),
                error.getDefaultMessage()
        );
    }

    abstract class ApiSubError {
    }

    class ApiValidationError extends ApiSubError {
        private String object;
        private String field;
        private Object rejectedValue;
        private String message;

        public ApiValidationError(String object, String field, Object rejectedValue, String message) {
            this.object = object;
            this.field = field;
            this.rejectedValue = rejectedValue;
            this.message = message;
        }

        public ApiValidationError(String object, String message) {
            this.object = object;
            this.message = message;
        }
    }
}
