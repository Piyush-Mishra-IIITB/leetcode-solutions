class WordDictionary {
    public class Node {
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
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node node =root;
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
        return helper(word,node,0);
    }
    public boolean helper(String word,Node node,int ind){
        if(ind==word.length()){
            return node.isEnd();
        }
        char curr=word.charAt(ind);
        if(curr!='.'){
            if(!node.containsKey(curr)){
                return false;
            }
            else{
                if(helper(word,node.get(curr),ind+1)){
                    return true;
                }
            }
        }else{
            for(int i=0;i<26;i++){
                Node newNode=node.get((char)(i+'a'));
                if(newNode!=null){
                    if(helper(word,newNode,ind+1)){
                        return true;
                    }
                }
            }
        }
     return false;

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */