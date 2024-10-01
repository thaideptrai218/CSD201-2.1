package avltree;



class Main {
    public static void main(String[] args) {
        AVLT tree = new AVLT();

        for(int i=0; i < 10; i++) {
            tree.insert(i);
        }

        TreePrinter.print(tree.root);

        tree.remove(8);
//        tree.remove(9);
        TreePrinter.print(tree.root);

    }
}