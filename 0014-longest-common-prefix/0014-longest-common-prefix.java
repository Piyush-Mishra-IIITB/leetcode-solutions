class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=strs[0].length();
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min){
                  min=Math.min(strs[i].length(),min);
            }
        }
        String ans=strs[0].substring(0,min);
        for(int i=1;i<strs.length;i++){
            String curr=strs[i];
            int p=0;
            StringBuilder sb=new StringBuilder();
            while(p<ans.length()){
                if(ans.charAt(p)==curr.charAt(p)){
                    sb.append(ans.charAt(p));
                }
                else{
                    ans=sb.toString();
                    break;
                }
                p++;
            }
        }
        return ans;
        
    }
}