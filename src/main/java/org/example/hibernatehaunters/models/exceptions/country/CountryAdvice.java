package org.example.hibernatehaunters.models.exceptions.country;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CountryAdvice {

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<CountryErrorResponse> handleCountryNotFoundException(CountryNotFoundException e, HttpServletRequest request) {
        CountryErrorResponse response = new CountryErrorResponse(e.getMessage(), request.getRequestURL().toString(),  400);
        return ResponseEntity.badRequest().body(response);
    }

}
