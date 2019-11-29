package com.openCSV.CSVReader;

import com.opencsv.bean.CsvBindByName;

public class CSVUser {

    @CsvBindByName
    private String name;

    @CsvBindByName(column = "email", required = true)
    private String email;

    @CsvBindByName(column = "phone")
    private String phoneNumber;

    @CsvBindByName
    private String country;

    public CSVUser(String name, String email, String phoneNumber) {
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString(){
        return "CSVUser{"+
                        " name="+name+'\''+""+
                " email="+email+'\''+""+
                " phoneNumber="+phoneNumber+'\''+""+
                " country="+country+'\''+""+
        "}";
    }
}

