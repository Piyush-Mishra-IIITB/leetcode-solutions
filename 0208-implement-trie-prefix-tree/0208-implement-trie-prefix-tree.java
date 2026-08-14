class Trie {
    public class Node{
        Node links[]=new Node[26];
        boolean flag=false;

        boolean containsKey(char curr){
            return links[curr-'a']!=null;
        }
        void put(char curr,Node node){
            links[curr-'a']=node;
        }
        Node get(char curr){
            return links[curr-'a'];
        }
        void setEnd(){
            flag=true;
        }
        boolean isEnd(){
            return flag;
        }
    }
    public Node root;
    public Trie() {
       root=new Node();
    }
    
    public void insert(String word) {
       Node node=root;
       for(int i=0;i<word.length();i++){
        char ch=word.charAt(i);
           if(!node.containsKey(ch)){
              node.put(ch,new Node());
           }
           node=node.get(ch);
       }
       node.setEnd();

    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                return false;
            }
            node = node.get(curr);
        }
        return node.isEnd();
    }
    
    public boolean startsWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                return false;
            }
             node = node.get(curr);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */