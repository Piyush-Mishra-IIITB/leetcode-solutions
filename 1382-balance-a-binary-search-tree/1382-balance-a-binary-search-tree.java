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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer>ll=new ArrayList<>();
        inorder(root,ll);
        return build(ll);
    }
    public TreeNode build(List<Integer>ll){
        if(ll.size()==0){
            return null;
        }
        int mid=ll.size()/2;
        TreeNode root=new TreeNode(ll.get(mid));
        List<Integer>l=new ArrayList<>();
        for(int i=0;i<mid;i++){
            l.add(ll.get(i));
        }
        root.left=build(l);
        List<Integer>r=new ArrayList<>();
        for(int i=mid+1;i<ll.size();i++){
            r.add(ll.get(i));
        }
        root.right=build(r);
        return root;
    }
    public void inorder(TreeNode root,List<Integer>ll){
        if(root==null){
            return;
        }
        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
}