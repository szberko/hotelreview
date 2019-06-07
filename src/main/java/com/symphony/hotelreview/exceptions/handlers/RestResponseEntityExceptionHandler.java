package com.symphony.hotelreview.exceptions.handlers;

import com.symphony.hotelreview.exceptions.HotelNotFoundException;
import com.symphony.hotelreview.exceptions.UserAlreadyExistsException;
import com.symphony.hotelreview.exceptions.dto.StatusResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        logger.error(ex.getMessage(), ex);

        StatusResponse statusResponse = new StatusResponse(HttpStatus.BAD_REQUEST);
        statusResponse.addFieldErrors(ex.getBindingResult().getFieldErrors());
        statusResponse.addGlobalErrors(ex.getBindingResult().getGlobalErrors());

        return new ResponseEntity<>(statusResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<StatusResponse> handleHotelNotFoundException(Exception ex){
        logger.error(ex.getMessage(), ex);

        return new ResponseEntity<>(
                new StatusResponse(HttpStatus.NOT_FOUND, "Hotel not found", ex), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<StatusResponse> handleUserAlreadyExistsException(Exception ex){
        logger.error(ex.getMessage(), ex);
        return new ResponseEntity<>(
                new StatusResponse(HttpStatus.INTERNAL_SERVER_ERROR, "User already exists. Please use another email.", ex),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
