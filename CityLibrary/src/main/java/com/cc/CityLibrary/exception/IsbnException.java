package com.cc.CityLibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class IsbnException extends RuntimeException{
    public IsbnException(){
        super("Book with same ISBN already exists.");
    }
}
