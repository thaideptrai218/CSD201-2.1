package BT3_1;

public class Main {
    public static void main(String[] args) {
        StudentList list = new StudentList();
        //F1
        System.out.println("Cau 1");
        list.f1();

        //F2
        System.out.println("Cau 2");
        list.add(new Student("LOL", 1));
        list.add(new Student("LOL", 2));
        list.add(new Student("LOL", 3));
        list.print();
        list.sortAscending();
        list.print();

        //F3
        System.out.println("Cau 3");
        list.print();
        list.addIndex2("ADDTOHEAD", 20);
        list.addIndex2("ADDTOTAIL", 60);
        list.print();

        //f4
        System.out.println("Cau 4");
        list.add(new Student("33", 1));
        list.addAt(5, new Student("33", 1));
        list.print();
        list.f4();
        list.print();

        //f5
        System.out.println("Cau 5");
        list.f5();
    }
}
