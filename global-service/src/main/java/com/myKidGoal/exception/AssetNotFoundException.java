package com.myKidGoal.exception;

/**
 * Exception to throw when asset not found in database.
 */
public class AssetNotFoundException extends RuntimeException {

    public AssetNotFoundException(String s) {
        super(s);
    }

}
