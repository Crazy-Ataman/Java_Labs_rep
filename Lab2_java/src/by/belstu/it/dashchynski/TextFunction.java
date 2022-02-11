package by.belstu.it.dashchynski;

public class TextFunction {
    public TextFunction() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "TextFunction{" +
                "count=" + count +
                '}';
    }

    public int count;

    public String getvalue()
    {
        System.out.println("XD");
        return "Hello from First project";
    }
}
