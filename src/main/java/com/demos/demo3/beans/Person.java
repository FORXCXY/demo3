package com.demos.demo3.beans;

public class Person {
    private String name;
    private String email;
    private String phoneNumber;
    private Boolean callFrequency;
    private Boolean socialFrequency;

    public String getWork() {
        return work;
    }

    public String getPassport() {
        return passport;
    }

    public String getCountry() {
        return country;
    }

    private String work;
    private String passport;
    private String country;

    private String org;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getCallFrequency() {
        return callFrequency;
    }

    public Boolean getSocialFrequency() {
        return socialFrequency;
    }

    public String getOrg() {
        return org;
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

    public void setOrg(String org) {
        this.org = org;
    }

    public void setWork(String work) {
        this.work = work;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
