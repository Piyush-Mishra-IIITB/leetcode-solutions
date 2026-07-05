import java.util.*;
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans=new ArrayList<>();
        List<String>ll=new ArrayList<>();
        helper(ans,ll,s,0);
        return ans;
    }
    public void helper(List<List<String>>ans,List<String>ll,String s,int ind){
       if(ind==s.length()){
        ans.add(new ArrayList<>(ll));
       }
        for(int i=ind;i<s.length();i++){
            if(palind(s,ind,i)){
                ll.add(s.substring(ind,i+1));
                helper(ans,ll,s,i+1);
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