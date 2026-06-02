class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int x : to_delete){
            hm.put(x,1);
        }
        List<TreeNode> ans = new ArrayList<>();
        root = helper(ans, hm, root);
        if(root != null){
            ans.add(root);
        }
        return ans;
    }
    public TreeNode helper(List<TreeNode> ans,HashMap<Integer,Integer> hm,TreeNode root){
        if(root == null){
            return null;
        }
        root.left = helper(ans, hm, root.left);
        root.right = helper(ans, hm, root.right);
        if(hm.containsKey(root.val)){

            if(root.left != null){
                ans.add(root.left);
            }
            if(root.right != null){
                ans.add(root.right);
            }
            return null;
        }
        return root;
    }
}