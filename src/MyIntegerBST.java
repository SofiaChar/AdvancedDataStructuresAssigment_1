
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
        if (current == null) {
            return new BinaryNode(value);
        }
        int compareRes = value.compareTo((Integer) current.nodeValue);

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
        // update minDifference and minDifferenceValue by checking
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

    private Integer getHeight(BinaryNode current) {
        if(current == null) {
            return 0;
        } else {
            int leftHeight = getHeight(current.left);
            int rightHeight = getHeight(current.right);

            if(rightHeight > leftHeight) {
                return rightHeight + 1;
            } else {
                return leftHeight + 1;
            }
        }
    }

    private void printLevel(BinaryNode current , int level) {
        if (current == null)
            return;
        if (level == 1)
            System.out.print(current.nodeValue + " ");
        else if (level > 1)
        {
            printLevel(current.left, level-1);
            printLevel(current.right, level-1);
        }
    }

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
        findMinDifference(root, value);
        System.out.println("MostSimilarValue for " + value + " is " + minDifferenceValue);
        return minDifferenceValue;
    }

    @Override
    public void printByLevels() {
        int height = getHeight(root);
        int currLevel;
        for (currLevel = 0; currLevel < height; currLevel++) {
            System.out.print("\nDepth "+ currLevel + ": ");
            printLevel(root, currLevel+1);
        }
    }
}
