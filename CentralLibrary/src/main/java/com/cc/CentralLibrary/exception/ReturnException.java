package com.cc.CentralLibrary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ReturnException extends RuntimeException{
    public ReturnException(){
        super("This user has 0 rented books.");
    }
}
