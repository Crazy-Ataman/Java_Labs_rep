package com.crazy_ataman.data;

public class City {
    private String name;
    private int year_of_found;
    private float area;
    private int count_men;
    private int count_women;
    private int count_foreigner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear_of_found() {
        return year_of_found;
    }

    public void setYear_of_found(int year_of_found) {
        this.year_of_found = year_of_found;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getCount_men() {
        return count_men;
    }

    public void setCount_men(int count_men) {
        this.count_men = count_men;
    }

    public int getCount_women() {
        return count_women;
    }

    public void setCount_women(int count_women) {
        this.count_women = count_women;
    }

    public int getCount_foreigner() {
        return count_foreigner;
    }

    public void setCount_foreigner(int count_foreigner) {
        this.count_foreigner = count_foreigner;
    }

    @Override
    public String toString() {
        return "Name of city: " + name
                + "\nYear of foundation: " + year_of_found
                + "\nArea: " + area + "sq. km."
                + "\nCount of men: " + count_men
                + "\nCount of women: " + count_women
                + "\nCount of foreigner: " + count_foreigner;
    }
}
