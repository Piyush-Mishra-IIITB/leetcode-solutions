class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>>ans=new ArrayList<>();
        List<String>var=new ArrayList<>();
        HashSet<String>hs=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            hs.add(wordDict.get(i));
        }
        helper(ans,var,s,0,hs);
        List<String>a=new ArrayList<>();
        for(int i=0;i<ans.size();i++){
           StringBuilder sb=new StringBuilder();
           for(int j=0;j<ans.get(i).size();j++){
              sb.append(ans.get(i).get(j));
              if(j!=ans.get(i).size()-1){
                sb.append(" ");
              }   
           }
           a.add(sb.toString());
        }
        return a;
    }
    public void helper(List<List<String>>ans,List<String>var,String s,int ind,HashSet<String>hs){
        if(ind==s.length()){
            ans.add(new ArrayList<>(var));
            return;
        }
        for(int i=ind;i<s.length();i++){
            if(hs.contains(s.substring(ind,i+1))){
                var.add(s.substring(ind,i+1));
                helper(ans,var,s,i+1,hs);
                var.remove(var.size()-1);
            }
        }
    }
}