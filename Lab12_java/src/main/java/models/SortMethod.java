package models;

public class SortMethod {
    private String name;
    private String discipline;

    public SortMethod(String name, String discipline) {
        this.name = name;
        this.discipline = discipline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }
}
