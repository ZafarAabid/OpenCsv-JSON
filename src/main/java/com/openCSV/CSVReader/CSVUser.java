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

    public CSVUser(){}
    public CSVUser(String name, String email, String phoneNumber) {
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
    public CSVUser(String name, String email, String phoneNumber, String country) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCountry(String country) {
        this.country = country;
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

