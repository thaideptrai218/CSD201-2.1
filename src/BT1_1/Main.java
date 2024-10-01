package BT1_1;

public class Main {
    public static void main(String[] args) {
        CarList list = new CarList();


        //Cau 1 addLast(name, price):

        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 18);
        list.addLast("D", 15);
        list.addLast("E", 25);
        list.print();

        //Cau 2 Addlndex
        System.out.println("Cau 2");
        list.addIndex2("F", 30, 16);
        list.print();

        //Cau 3 DeleteIndex() Xoá bỏ phần tử (Car) đầu tiên trong list mà có giá là số nguyên tố
        System.out.println("Cau 3");
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 13);
        list.addLast("F", 23);
        list.addLast("E", 25);
        list.print();
        list.deleteIndex();
        list.print();

        //Cau 4 DeleteIndexLast() xoá bỏ phần tử (Car) cuối cùng trong list mà có giá là số nguyên tố.
        System.out.println("Cau 4");
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 13);
        list.addLast("F", 23);
        list.addLast("E", 25);
        list.print();
        list.deleteIndexLast();
        list.print();

        //Cau 5 tìm phần tử có giá trị lớn nhất rồi cho về head or tail.
        System.out.println("Cau 5");
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 30);
        list.addLast("F", 23);
        list.addLast("E", 25);
        list.print();
        list.f3toHead();
        list.print();
        list.f3toTail();
        list.print();

        //Cau 6 f41() sort tất cả các phần tử (Car) của list theo thứ tự tăng dần của price.
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 30);
        list.addLast("F", 23);
        list.addLast("E", 25);
        System.out.println("Cau 6");
        list.print();
        list.f41();
        list.print();

        //Cau 7 f42() reverse tất cả các phần tử trong list đã cho.
        System.out.println("Cau 7");
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 30);
        list.addLast("F", 23);
        list.addLast("E", 25);
        list.print();
        list.f51();
        list.print();

        //Cau 8 Đổi chỗ  2 phan tu (car) dung truoc va dung sau phan tu co gia lon nhat trong list
        System.out.println("Cau 8");
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 30);
        list.addLast("F", 23);
        list.addLast("E", 25);
        list.print();
        list.swapNearMax();
        list.print();
        //Cau 9 Giả sử kích thước của list có ít nhất 4 phần tử
        //Sort các phần tử của list ở vị trí chẵn tăng dần theo giá,
        System.out.println("Cau 9");
        list.clear();
        list.addLast("A", 20);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 19);
        list.addLast("D", 30);
        list.addLast("F", 23);
        list.addLast("E", 25);
        list.print();
        list.bubbleSortEVEN();
        list.bubbleSortODD();
        list.print();

        //Cau 10 sort các phần tử có giá trị chẵn (A,5), B(D,8), (C,3), (B,12)
        System.out.println("Cau 10");
        list.clear();
        list.addLast("A", 5);
        list.addLast("B", 20);
        list.addLast("Z", 101);
        list.addLast("C", 12);
        list.addLast("D", 3);
        list.addLast("F", 8);
        list.print();
        list.bubbleSortEVENVALUE();
        list.print();
    }
}
