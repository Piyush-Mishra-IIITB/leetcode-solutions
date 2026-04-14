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
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        Queue<Node>qq=new LinkedList<>();
        qq.add(root);
        List<List<Integer>>ans=new ArrayList<>();
        while(!qq.isEmpty()){
            List<Integer>ll=new ArrayList<>();
            int size=qq.size();
            for(int i=0;i<size;i++){
                Node curr=qq.poll();
                ll.add(curr.val);
                if(curr.children.size()!=0){
                    List<Node>a=curr.children;
                    for(int j=0;j<a.size();j++){
                        qq.add(a.get(j));
                    }
                }
            }
            ans.add(new ArrayList<>( ll));
        }
        return ans.size();
    }
}