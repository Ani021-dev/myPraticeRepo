package src;

public class ValidBST {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        System.out.println(isValidBST(root, null, null));
    }

    public static boolean isValidBST(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) {
            return true;
        }

        return (maxVal == null || root.val <= maxVal) && (minVal == null || root.val >= minVal) &&
                (root.val != Integer.MIN_VALUE ? isValidBST(root.left, minVal, root.val - 1) : root.left == null) &&
                (root.val != Integer.MAX_VALUE ? isValidBST(root.right, root.val + 1, maxVal) : root.right == null);
    }
}
