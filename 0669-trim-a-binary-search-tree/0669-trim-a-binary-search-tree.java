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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        List<Integer>ll=new ArrayList<>();
        inorder(root,ll);
        List<Integer>newone=new ArrayList<>();
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)>=low && ll.get(i)<=high){
                newone.add(ll.get(i));
            }
        }
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<newone.size();i++){
            hs.add(newone.get(i));
        }
        List<Integer>tobeDeleted=new ArrayList<>();
        for(int i=0;i<ll.size();i++){
            int curr=ll.get(i);
            if(!hs.contains(curr)){
                tobeDeleted.add(curr);
            }
        }
        TreeNode start=root;
        for(int i=0;i<tobeDeleted.size();i++){
            int key=tobeDeleted.get(i);
            start=helper(start,key);
        }
        return start;
        
    }
    public TreeNode helper(TreeNode root,int key){
        if(root==null){
            return null;
        }
        else if(root.val>key){
            root.left=helper(root.left,key);
        }
        else if(root.val<key){
            root.right=helper(root.right,key);
        }
        else{
            if(root.left ==null && root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }
            TreeNode nextOne=root.right;
            while(nextOne.left!=null){
                nextOne=nextOne.left;
            }
            root.val=nextOne.val;
            root.right=helper(root.right,nextOne.val);
        }
        return root;
    }
    // public TreeNode build(List<Integer>ll){
    //     if(ll.size()==0){
    //         return null;
    //     }
    //     int mid=ll.size()/2;
    //     TreeNode root=new TreeNode(ll.get(mid));
    //     List<Integer>l=new ArrayList<>();
    //     for(int i=0;i<mid;i++){
    //         l.add(ll.get(i));
    //     }
    //     root.left=build(l);
    //     List<Integer>r=new ArrayList<>();
    //     for(int i=mid+1;i<ll.size();i++){
    //         r.add(ll.get(i));
    //     }
    //     root.right=build(r);
    //     return root;
    // }
    public void inorder(TreeNode root,List<Integer>ll){
        if(root==null){
            return ;
        }

        inorder(root.left,ll);
        ll.add(root.val);
        inorder(root.right,ll);
    }
}