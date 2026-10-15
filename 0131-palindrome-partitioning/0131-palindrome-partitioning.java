class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        helper(ans, new ArrayList<>(), s);
        return ans;
    }
    public void helper(List<List<String >>ans,List<String>ll,String s){
        if(s.length()==0){
            ans.add(new ArrayList<>(ll));
            return;
        }
        for(int i=0;i<s.length();i++){
            if(isPalind(s,i)){
                ll.add(s.substring(0,i+1));
                helper(ans,ll,s.substring(i+1));
                ll.remove(ll.size()-1);
            }
        }
    }
    public boolean isPalind(String s,int i){
        int start=0;
        int end=i;
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    
}