package com.myKidGoal.utils;

import com.myKidGoal.TestApplication;
import com.myKidGoal.dto.PortfolioDTO;
import com.myKidGoal.util.CsvUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplication.class)
public class CSVUtilsTest {

    @Test
    public void whenRead_completeSuccessfully() throws IOException {

        String fileName = getClass().getClassLoader().getResource("portfolio_data.csv").getPath();

        InputStream inputStream = new FileInputStream(fileName);

        List<PortfolioDTO> portfolioDTOList = CsvUtils.read(PortfolioDTO.class, inputStream);
        Assert.assertEquals(27, portfolioDTOList.size());
    }

}
