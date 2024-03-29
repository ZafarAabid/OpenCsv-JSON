package com.openCSV.CSVReader;

import com.opencsv.CSVReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenCsvReader {
    private static final String  SAMPLE_CSV_FILE_PATH = "/home/user/workspace/Open Source CSV/src/main/java/com/openCSV/CSVReader/user-with-header.csv";
    public static void main(String[] args) throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVReader csvReader = new CSVReader(reader);
            ){
            String nextRecord[];
            while((nextRecord = csvReader.readNext()) != null)
            {
                System.out.println("Name:"+ nextRecord[0]);
                System.out.println("Email:"+ nextRecord[1]);
                System.out.println("Phone:"+ nextRecord[2]);
                System.out.println("Country:"+ nextRecord[3]);
                System.out.println("------------------------");
            }
        }
    }
}
