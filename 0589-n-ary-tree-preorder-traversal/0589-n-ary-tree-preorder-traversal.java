/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer>ll=new ArrayList<>();
        helper(ll,root);
        return ll;
    }
    public void helper(List<Integer>ll,Node root){
        if(root==null){
            return;
        }
        ll.add(root.val);
        List<Node>child=root.children;
        for(int i=0;i<child.size();i++){
            helper(ll,child.get(i));
        }
    }
}