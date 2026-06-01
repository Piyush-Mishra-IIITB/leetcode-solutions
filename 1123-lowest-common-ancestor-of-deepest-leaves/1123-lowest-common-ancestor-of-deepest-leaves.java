/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */class Solution {

    int maxDepth = -1;
    List<TreeNode> deepestLeaves = new ArrayList<>();

    public TreeNode lcaDeepestLeaves(TreeNode root) {

        findMaxDepth(root, 0);

        collectLeaves(root, 0);

        TreeNode lca = deepestLeaves.get(0);

        for (int i = 1; i < deepestLeaves.size(); i++) {
            lca = findLCA(root, lca, deepestLeaves.get(i));
        }

        return lca;
    }

    private void findMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }

        findMaxDepth(root.left, depth + 1);
        findMaxDepth(root.right, depth + 1);
    }

    private void collectLeaves(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null && depth == maxDepth) {
            deepestLeaves.add(root);
        }

        collectLeaves(root.left, depth + 1);
        collectLeaves(root.right, depth + 1);
    }

    private TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}