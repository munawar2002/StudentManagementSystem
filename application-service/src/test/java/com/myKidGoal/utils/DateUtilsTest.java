package com.myKidGoal.utils;

import com.myKidGoal.TestApplication;
import com.myKidGoal.util.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class DateUtilsTest {

    @Test
    public void getDateTest() throws ParseException {

        String strDate = "01.02.19";

        Date date = DateUtils.getDate(strDate, "dd.mm.yy");

        Assert.assertNotNull(date);
    }

    @Test
    public void getYearTest() throws ParseException {
        Date endDate = DateUtils.getDate("01.01.2025", "dd.mm.yy");
        Date startDate = new Date();

        int years = DateUtils.getYear(startDate, endDate);
        Assert.assertEquals(6, years);
    }

}