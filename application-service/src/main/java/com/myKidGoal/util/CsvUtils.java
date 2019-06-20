package com.myKidGoal.util;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
    This util class to any read csv.
 */
public class CsvUtils {

    /**
     * This method will read any csv and load data into class if the class has same variable names and the csv headers.
     * 
     * @param clazz
     *            The class in which you want to load data
     * @param stream
     *            The file input stream
     * @param <T>
     *            The class in which you want to load data
     * @return The list of class
     * @throws IOException
     */
    public static <T> List<T> read(Class<T> clazz, InputStream stream) throws IOException {
        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(clazz).withHeader().withColumnReordering(true).withColumnSeparator(';');
        ObjectReader reader = mapper.readerFor(clazz).with(schema);
        return reader.<T> readValues(stream).readAll();
    }
}
