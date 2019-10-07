public class Main {
    public static void main(String[] args){
        MyIntegerBST OurTree = new MyIntegerBST();
        System.out.println("\n---------Exersice 1---------\n");
        OurTree.insert(52);
        OurTree.insert(40);
        OurTree.insert(35);
        OurTree.insert(18);
        OurTree.insert(36);
        OurTree.insert(7);
        OurTree.insert(42);
        OurTree.insert(41);
        OurTree.insert(49);
        OurTree.insert(55);
        OurTree.insert(53);
        OurTree.insert(68);
        OurTree.insert(59);

        OurTree.mostSimilarValue(30);

        OurTree.printByLevels();

        System.out.println("\n\n---------Exersice 3---------\n");

        SequenceWithMinimum OurSequence = new SequenceWithMinimum();
        OurSequence.insertLeft(5);
        OurSequence.insertLeft(20);
        OurSequence.insertRight(6);
        OurSequence.insertRight(7);
        OurSequence.insertRight(7);
        OurSequence.insertRight(10);

        OurSequence.printSequence(OurSequence.head);

        Integer remRight = OurSequence.removeRight();
        System.out.println("\n\nRemoved right element: " + remRight);
        OurSequence.printSequence(OurSequence.head);

        Integer remLeft = OurSequence.removeLeft();
        System.out.println("\n\nRemoved left element: " + remLeft);
        OurSequence.printSequence(OurSequence.head);

        Integer min = OurSequence.findMinimum();
        System.out.println("\n\nThe minimum of the sequence is " + min);

    }
}
