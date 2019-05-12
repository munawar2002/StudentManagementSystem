package com.myKidGoal.exception;

/**
 * Exception to throw when user provided file has some invalid data.
 */
public class PortfolioDataLoadException extends RuntimeException {

    public PortfolioDataLoadException(String s) {
        super(s);
    }

}
