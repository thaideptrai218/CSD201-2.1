package BT2_1;

import BT1_1.CarList;
import sun.reflect.generics.tree.Tree;

public class Main {
    public static void main(String[] args) {
        CarBST tree = new CarBST();
        tree.insert("A", 5);
        tree.insert("C", 2);
        tree.insert("E", 4);
        tree.insert("G", 3);
        tree.insert("D", 6);
        tree.insert("F", 7);

        //Bai 1
        TreePrinter.print(tree.root);
        tree.traverseInOrder();

        //bai 2
        System.out.println();
        tree.clear();
        tree.insert("C", 6);
        tree.insert("D", 2);
        tree.insert("F", 4);
        tree.insert("H", 3);
        tree.insert("I", 5);
        tree.insert("E", 8);
        tree.insert("G", 7);
        TreePrinter.print(tree.root);
        tree.traversePreOrder2();

        //bai 3
        System.out.println();
        tree.clear();
        tree.insert("C", 8);
        tree.insert("D", 6);
        tree.insert("E", 9);
        tree.insert("F", 2);
        tree.insert("G", 7);
        tree.insert("H", 1);
        tree.insert("I", 3);
        tree.insert("J", 5);
        tree.insert("K", 4);
        TreePrinter.print(tree.root);
        tree.f3();
        TreePrinter.print(tree.root);
        tree.breadthFirstSearch();

        //bai 4
        System.out.println();
        tree.clear();
        tree.insert("C", 8);
        tree.insert("D", 6);
        tree.insert("E", 9);
        tree.insert("F", 2);
        tree.insert("G", 7);
        tree.insert("H", 1);
        tree.insert("I", 3);
        tree.insert("J", 5);
        tree.insert("K", 4);
        tree.f4();
        TreePrinter.print(tree.root);
        tree.breadthFirstSearch();
    }
}
