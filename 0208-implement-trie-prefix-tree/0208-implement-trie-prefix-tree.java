class Trie {
    public class Node{
        Node links[]=new Node[26];
        boolean flag=false;


       boolean containsKey(char c){
           return links[c-'a']!=null;
       }
       Node get(char ch) {
            return links[ch - 'a'];
        }

       void put(char ch,Node node){
        links[ch-'a']=node;
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
            char curr=word.charAt(i);
            if(!node.containsKey(curr)){
                node.put(curr,new Node());
            }
            node=node.get(curr);
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
            node=node.get(curr);
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
            node=node.get(curr);
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