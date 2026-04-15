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
}
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer>ll=new ArrayList<>();
        helper(root,ll);
        return ll;
    }
    public void helper(Node root,List<Integer>ll){
        if(root==null){
            return;
        }
        int size=root.children.size();
        int i=0;
        while(size>0){
            helper(root.children.get(i),ll);
            size--;
            i++;
        }
        ll.add(root.val);
    }
}