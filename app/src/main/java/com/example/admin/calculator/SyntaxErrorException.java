package com.example.admin.calculator;

/**
 * Created by Admin on 9/28/2017.
 */

public class SyntaxErrorException extends RuntimeException {

    /**
     * Construct a SyntaxErrorException with the specified
     * message.
     * @param message the error message.
     */

    public SyntaxErrorException(String message) {
        super(message);
    }
}
