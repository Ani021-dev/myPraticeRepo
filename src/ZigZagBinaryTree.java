package src;

import java.util.*;

public class ZigZagBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] ar) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(printZigZag(root));
    }

    public static List<List<Integer>> printZigZag(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                temp.add(node.val);
                if (node.left != null)
                    q.add(node.left);

                if (node.right != null)
                    q.add(node.right);
            }
            res.add(temp);
        }
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
    }
}
