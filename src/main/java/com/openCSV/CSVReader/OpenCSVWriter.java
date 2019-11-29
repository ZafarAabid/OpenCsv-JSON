package com.openCSV.CSVReader;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {
    private static final String STRING_ARRAY_SAMPLE = "/home/user/workspace/Open Source CSV/src/main/java/com/openCSV/CSVReader/object-list-sample.csv";

    public static void main(String[] args) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException, IOException {
        try(
                Writer writer= Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));
        ){
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            List<CSVUser> CSVUser = new ArrayList();
            CSVUser.add(new CSVUser("Xfr Aabid","josam3295@gmail.com","908087241183"));
            CSVUser.add(new CSVUser("Xfr Aabid","zafaraabid3295@gmail.com","919273033358"));

            beanToCsv.write(CSVUser);
        }

    }
}
