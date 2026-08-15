class Solution {
    public class Node{
        Node links[]=new Node[26];
        boolean flag=false;
       
       void put(char c,Node node){
           links[c-'a']=node;
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
       boolean containsKey(char curr){
            return links[curr-'a']!=null;
       }
    }
    public Node root;
    public Solution(){
        root=new Node();
    }
    public void put(String s){
       Node node=root;
       for(int i=0;i<s.length();i++){
          char curr=s.charAt(i);
          if(!node.containsKey(curr)){
              node.put(curr,new Node());
          }
          node=node.get(curr);
       }
       node.setEnd();
    }
    public String search(String s){
        Node node=root;
        StringBuilder ans=new StringBuilder();
        for(int i=0;i<s.length();i++){
           char curr=s.charAt(i);
           if(!node.containsKey(curr)){
               return s;
           }else{
            ans.append(curr);
            node=node.get(curr);
            if(node.isEnd()){
                return ans.toString();
            }
           }
           
        }
        if(node.isEnd()){
            return ans.toString();
        }
        else{
            return s;}
    }
    public String replaceWords(List<String> dict, String sentence) {
           for(int i=0;i<dict.size();i++){
              String s=dict.get(i);
              put(s);
           }
           StringBuilder ans=new StringBuilder();
           String arr[]=sentence.split(" ");

           for(int i=0;i<arr.length;i++){
               String curr=arr[i];
               ans.append(search(curr));
               if(i!=arr.length-1){
                 ans.append(" ");
               } 
           }
           return ans.toString();
           
    }
}