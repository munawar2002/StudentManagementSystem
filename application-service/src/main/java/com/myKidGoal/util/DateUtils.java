package com.myKidGoal.util;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    The date util class. All date manipulation or creation method will come here.
 */
public class DateUtils {

    /**
     * Convert the string to date
     * 
     * @param stringDate
     *            The string date
     * @param format
     *            The format in which string date is given
     * @return
     */
    public static Date getDate(String stringDate, String format) throws ParseException {

        if (StringUtils.isEmpty(stringDate)) {
            return null;
        }

        return new SimpleDateFormat(format).parse(stringDate);
    }

    /**
     * This method will find years in between two dates (end date year - start date year)
     * 
     * @param date1
     *            start date
     * @param date2
     *            end date
     * @return <int>year</int>
     */
    public static int getYear(Date date1, Date date2) {
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("yyyy");
        return Integer.parseInt(simpleDateformat.format(date2)) - Integer.parseInt(simpleDateformat.format(date1));
    }

}
