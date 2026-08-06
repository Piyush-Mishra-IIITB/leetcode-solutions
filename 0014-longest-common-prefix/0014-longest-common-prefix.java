class Solution {
    public String longestCommonPrefix(String[] s) {
     if(s.length==0){
        return "";
     }
     int min=s[0].length();
     for(int i=0;i<s.length;i++){
         min=Math.min(min,s[i].length());
     }
     String first=s[0];
     int j=0;
     StringBuilder sb=new StringBuilder();
     while(j<min){
        char curr=first.charAt(j);
        for(int i=1;i<s.length;i++){
            if(s[i].charAt(j)!=curr){
                return sb.toString();
            }
        }
        sb.append(curr);
        j++;
     }
     return sb.toString();
       
    }
}
