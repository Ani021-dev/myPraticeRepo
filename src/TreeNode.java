package src;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class InorderTreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        printInorderTraversal(root);
        System.out.println();
        printPreOrderTraversal(root);
        System.out.println();
        printPostOrderTraversal(root);
    }

    public static void printInorderTraversal(TreeNode root) {
        if(root == null)
            return;

        printInorderTraversal(root.left);
        System.out.print(root.data + " ");
        printInorderTraversal(root.right);
    }

    public static void printPreOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        System.out.print(root.data + " ");
        printPreOrderTraversal(root.left);
        printPreOrderTraversal(root.right);
    }

    public static void printPostOrderTraversal(TreeNode root) {
        if(root == null)
            return;

        printPostOrderTraversal(root.left);
        printPostOrderTraversal(root.right);
        System.out.print(root.data + " ");

    }
}
