package com.myKidGoal.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class DeltasoftDataLoaderService implements DataLoaderService {

    private Logger logger = LoggerFactory.getLogger(DeltasoftDataLoaderService.class);

    @Autowired
    private DataSource dataSource;

    private final List<String> ignoreTableColumnsGeneration = new ArrayList<>(
            Arrays.asList("DS_CRT_PROVISIONAL", "DS_DATA", "DS_FEEPERIOD", "DS_SESSIONINFO"));

    @Override
    public boolean loadData(String folderPath) {

        try {
            File dataDirectory = new File(folderPath);

            if (!dataDirectory.exists()) {
                throw new RuntimeException("Directory doesn't exist " + dataDirectory.getAbsolutePath());
            }

            if (Objects.requireNonNull(dataDirectory.listFiles()).length < 1) {
                throw new RuntimeException("No csv files found at " + dataDirectory.getAbsolutePath());
            }

            JdbcTemplate template = new JdbcTemplate(dataSource);

            for (File file : Objects.requireNonNull(dataDirectory.listFiles())) {

                if (file.isFile() && file.getName().endsWith(".csv")) {

                    // removing .csv extension from fileName. In Account.csv, Account is our table name.
                    String tableName = "DS_" + file.getName().substring(0, file.getName().length() - 4).toUpperCase();

                    String filePath = file.getAbsolutePath().replace('\\', '/');

                    String columnNames = "";

                    if (!ignoreTableColumnsGeneration.contains(tableName)) {
                        columnNames = "(" + getColumnNames(file) + ")";
                    }

                    String query = "LOAD DATA LOCAL INFILE '" + filePath + "' INTO TABLE " + tableName
                            + " FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n' IGNORE 1 LINES "
                            + columnNames;

                    logger.info(query);

                    template.execute(query);

                } else if (file.isFile() && file.getName().endsWith(".sql")) {
                    String filePath = file.getAbsolutePath().replace('\\', '/');
                    ScriptUtils.executeSqlScript(dataSource.getConnection(), new FileSystemResource(filePath));
                }
            }

            // executing post script
            String postScriptPath = this.getClass().getClassLoader().getResource("ddl/postDataload.sql").getPath();

            ScriptUtils.executeSqlScript(dataSource.getConnection(), new FileSystemResource(postScriptPath));

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Data loading process failed with message [" + e.getMessage() + "]");
        }

        return true;
    }

    /**
     * First line in CSV is the column names
     * 
     * @param file
     * @return
     * @throws IOException
     */
    private String getColumnNames(File file) throws IOException {
        BufferedReader brTest = new BufferedReader(new FileReader(file));
        return brTest.readLine();
    }
}
