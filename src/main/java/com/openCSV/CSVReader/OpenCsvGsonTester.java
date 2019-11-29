package com.openCSV.CSVReader;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OpenCsvGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/user/workspace/Open Source CSV/src/main/java/com/openCSV/CSVReader/user-with-header.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "/home/user/workspace/Open Source CSV/src/main/java/com/openCSV/CSVReader/users.json";

    public static void main(String[] args) throws IOException {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
            csvToBeanBuilder.withType(CSVUser.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] userObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(userObj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}