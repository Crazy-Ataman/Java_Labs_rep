package by.belstu.it.dashchynski.basejava;

import java.util.Objects;

public class WrapperString {
    private String str;

    public WrapperString(String str) {
        this.str = str;
    }
    /**
     * get value's str function
     * @return string
     * */
    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WrapperString that = (WrapperString) o;
        return Objects.equals(str, that.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }

    /**
     * function toString convert information into string
     * @return string
     * */
    @Override
    public String toString() {
        return "WrapperString{" +
                "str='" + str + '\'' +
                '}';
    }

    /**
     * function replace oldchar with newchar
     * @param oldchar, newchar
     * */
    public void replace(char oldchar, char newchar) {
        System.out.printf("[original] Replace a character '%c' with '%c'\n", oldchar, newchar);
        str=str.replaceAll(String.valueOf(oldchar),String.valueOf(newchar));
    }
}
