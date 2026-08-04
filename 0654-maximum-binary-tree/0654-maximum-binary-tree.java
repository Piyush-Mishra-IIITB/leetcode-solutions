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
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] arr) {
        List<Integer>main=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
         main.add(arr[i]);
        }
        return helper(main);
    }
    public TreeNode helper(List<Integer>ll){
        if(ll.size()==0){
            return null;
        }
         if(ll.size()==1){
            TreeNode root=new TreeNode(ll.get(0));
            return root;
         }
        int ind=0;
        int max=ll.get(0);
        for(int i=0;i<ll.size();i++){
            if(max<ll.get(i)){
                max=ll.get(i);
                ind=i;
            }
        }
        TreeNode root=new TreeNode(max);
        List<Integer>left=new ArrayList<>();
        for(int i=0;i<ind;i++){
            left.add(ll.get(i));
        }
        List<Integer>right=new ArrayList<>();
        for(int i=ind+1;i<ll.size();i++){
            right.add(ll.get(i));
        }
        root.left=helper(left);
        root.right=helper(right);

        return root;
    }
}