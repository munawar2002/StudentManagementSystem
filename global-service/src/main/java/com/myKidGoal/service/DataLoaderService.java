package com.myKidGoal.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

/*
    The data loader service interface. In order to create a data loader implementation, this class must be implemented.
 */
public interface DataLoaderService {

    /**
     *
     * @param inputStream
     *            The portfolio data file inputStream that needs to be updated.
     * @return Status: "Success" if data loads successfully.
     * @throws IOException
     * @throws ParseException
     */
    String loadData(InputStream inputStream) throws IOException, ParseException;

}
