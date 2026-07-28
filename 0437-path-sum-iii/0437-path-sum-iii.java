class Solution {
    public int pathSum(TreeNode root, int target) {
        if (root == null) {
            return 0;
        }

        return helper(root, (long) target)
             + pathSum(root.left, target)
             + pathSum(root.right, target);
    }

    public int helper(TreeNode root, long target) {
        if (root == null) {
            return 0;
        }

        int ans = 0;

        if (target == root.val) {
            ans++;
        }

        ans += helper(root.left, target - root.val);
        ans += helper(root.right, target - root.val);

        return ans;
    }
}