import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>ll=new ArrayList<>();
    
        helper(0,ll,ans,s);
        return ans;
    }
    public void helper(int index,List<String>ll,List<List<String>>ans,String s){
       if(index==s.length()){
            ans.add(new ArrayList<>(ll));
            return;
       }
       for(int i=index;i<s.length();i++){
           if(palind(s,index,i)){
            ll.add(s.substring(index,i+1));
            helper(i+1,ll,ans,s);
            ll.remove(ll.size()-1);
           }
       }
    }
    public boolean palind(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
}