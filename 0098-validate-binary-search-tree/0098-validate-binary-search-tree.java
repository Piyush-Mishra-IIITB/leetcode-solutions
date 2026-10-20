class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        long a = left(root.left);
        long b = right(root.right);

        if (a >= root.val || b <= root.val) {
            return false;
        }

        return isValidBST(root.left) && isValidBST(root.right);
    }

    public long left(TreeNode root) {
        if (root == null) return Long.MIN_VALUE;

        return Math.max(
            root.val,
            Math.max(left(root.left), left(root.right))
        );
    }

    public long right(TreeNode root) {
        if (root == null) return Long.MAX_VALUE;

        return Math.min(
            root.val,
            Math.min(right(root.left), right(root.right))
        );
    }
}