
public class MyIntegerBST implements A1Tree
{
    private BinaryNode root;
    private Integer minDifference;
    private  Integer minDifferenceValue;

    public class BinaryNode <Integer>  {
        public Integer nodeValue;

        public BinaryNode left;
        public BinaryNode right;

        BinaryNode(Integer value) {
            this.nodeValue = value;
            left = null;
            right = null;
        }
    }

    private BinaryNode addRecursive(BinaryNode current, Integer value) {
        //if tree does not exist we create new tree
        if (current == null) {
            return new BinaryNode(value);
        }
        //create variable of difference value we insert and root of current subtree
        int compareRes = value.compareTo((Integer) current.nodeValue);
        //depending on compareRes add element to suitable side
        if (compareRes < 0) {
            current.left = addRecursive(current.left, value);
        } else if (compareRes > 0) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    private void findMinDifference(BinaryNode current, Integer value) {
        if (current == null)
            return;

        if (current.nodeValue == value) {
            minDifferenceValue = value;
            return;
        }
        // update minDifference and minDifferenceValue by checking absolute difference
        if (minDifference > Math.abs((Integer) current.nodeValue - value)) {
            minDifference = Math.abs((Integer) current.nodeValue - value);
            minDifferenceValue = (Integer) current.nodeValue;
        }
        //  move in left subtree else in right subtree
        if (value.compareTo((Integer) current.nodeValue) < 0) {
            findMinDifference(current.left, value);
        } else{
            findMinDifference(current.right, value);
        }
    }

//    private Integer getHeight(BinaryNode current) {
//        //if the tree does not exist, the height is 0
//        if(current == null) {
//            return 0;
//        } else {
//            //recursively find height of each subtree
//            int leftHeight = getHeight(current.left);
//            int rightHeight = getHeight(current.right);
//
//            //return the biggest height
//            if(rightHeight > leftHeight) {
//                return rightHeight + 1;
//            } else {
//                return leftHeight + 1;
//            }
//        }
//    }

    private boolean printLevel(BinaryNode current , int level) {

        if (current == null)
            return false;

        // print root of the tree
        if (level == 0) {
            System.out.print(current.nodeValue + " ");
            if (current.left == null && current.right == null)
                return false;
            return true;
        }
        //print children of current element by calling this function recursively
        boolean left = printLevel(current.left, level-1);
        boolean right = printLevel(current.right, level-1);

        return right || left;
    }

    //constructor of the class
    public MyIntegerBST() {
        root = null ;
    }

    @Override
    public void insert(Integer value) {
        root = addRecursive(root, value);
        System.out.println("Added " + value);
    }

    @Override
    public Integer mostSimilarValue(Integer value) {
        minDifference = 999999999;
        minDifferenceValue = -1;
        //finding values of 'minDifference' and 'minDifferenceValue' by calling method findMinDifference()
        findMinDifference(root, value);
        System.out.println("\nMostSimilarValue for " + value + " is " + minDifferenceValue);
        return minDifferenceValue;
    }

    @Override
    public void printByLevels() {
        int currLevel = 0;
        boolean flag;

        while(true){
            System.out.print("\nDepth "+ (currLevel) + ": ");
            flag = printLevel(root, currLevel);
            if (!flag)
                break;
            currLevel++;
        }
    }
}
