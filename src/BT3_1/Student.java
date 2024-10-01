package BT3_1;

public class Student {
    private String name;
    private double mark;

    public Student(String name, double mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + mark + ")";
    }
}
