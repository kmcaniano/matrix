package com.linearalgebra;

public class IllegalMatrixOperation extends RuntimeException
{
    private String message; 

    IllegalMatrixOperation(String message)
    {
        super();
        this.message = message;
    }

    public String getMessage()
    {
        return message;
    }
}
