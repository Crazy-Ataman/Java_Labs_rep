package com.crazy_ataman.data;

public class Citizen {
    private String city;
    private String nationality;
    private String language;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Citizen's city: " + city
                + "\nNationality: " + nationality
                + "\nLanguage: " + language;
    }
}
