
 class Solution {

    int maxDepth = -1;
    List<TreeNode> deepest = new ArrayList<>();

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        findDepth(root, 0);

        collectDeepest(root, 0);

        TreeNode ans = deepest.get(0);

        for (int i = 1; i < deepest.size(); i++) {
            ans = lca(root, ans, deepest.get(i));
        }

        return ans;
    }

    private void findDepth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            maxDepth = Math.max(maxDepth, depth);
        }

        findDepth(root.left, depth + 1);
        findDepth(root.right, depth + 1);
    }

    private void collectDeepest(TreeNode root, int depth) {
        if (root == null) {
            return;
        }

        if (root.left == null &&
            root.right == null &&
            depth == maxDepth) {

            deepest.add(root);
        }

        collectDeepest(root.left, depth + 1);
        collectDeepest(root.right, depth + 1);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}