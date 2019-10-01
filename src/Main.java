public class Main {
    public void checkBTS() {
        MyIntegerBST OurTree = new MyIntegerBST();

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
    }

    public static void main(String[] args){
        SequenceWithMinimum OurSequence = new SequenceWithMinimum();
        OurSequence.insertLeft(5);
        OurSequence.insertLeft(4);
        OurSequence.insertRight(5);
        OurSequence.insertRight(4);
        OurSequence.printlist(OurSequence.head);
    }
}
