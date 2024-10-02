package avltree;



class Main {
    public static void main(String[] args) {
        AVLT<Integer> tree = new AVLT<>();

        for(int i=0; i < 20; i++) {
            tree.insert(i);
        }


        tree.remove(8);
        tree.remove(9);
        tree.remove(10);
        tree.remove(16);
        TreePrinter.print(tree.root);

    }
}