
public class MyIntegerBST implements A1Tree
{
    private BinaryNode root;
    private Integer minDifference, minDiffValue;

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

        // If k itself is present
        if (current.nodeValue == value) {
            minDiffValue = value;
            return;
        }
        // update min_diff and min_diff_key by checking
        // current node value
        if (minDifference > Math.abs((Integer) current.nodeValue - value)) {
            minDifference = Math.abs((Integer) current.nodeValue - value);
            minDiffValue = (Integer) current.nodeValue;
        }
        // if k is less than ptr.key then move in
        // left subtree else in right subtree
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
        minDiffValue = -1;
        findMinDifference(root, value);
        System.out.println("MostSimilarValue for " + value + " is " + minDiffValue);
        return minDiffValue;
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
