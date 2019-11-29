package com.openCSV.CSVReader;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class openCSVReaderAndParseToBean {
    private static final String  SAMPLE_CSV_FILE_PATH = "/home/user/workspace/Open Source CSV/src/main/java/com/openCSV/CSVReader/user_with_header.csv";

    public static void main(String[] args) throws IOException {

        try(
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        )   {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();

            while(csvUserIterator.hasNext())
            {
                CSVUser csvUser = csvUserIterator.next();
                System.out.println("Name:"+ csvUser.getName());
                System.out.println("Email:"+ csvUser.getEmail());
                System.out.println("Phone:"+ csvUser.getPhoneNumber());
                System.out.println("Country:"+ csvUser.getCountry());
                System.out.println("================================");
            }


        }
    }
}

