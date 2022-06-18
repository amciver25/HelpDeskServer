package com.anthony.helpdeskserver.domain.helprequest.exceptions;

public class RequestNotFoundException extends Exception {
    public RequestNotFoundException(String message){
        super(message);
    }

}
