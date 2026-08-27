class Solution {
    public int lengthOfLongestSubstring(String s) {
       
       int i=0;
       int ans=0;
       HashMap<Character,Integer>hm=new HashMap<>();
       for(int j=0;j<s.length();j++){
          if(hm.containsKey(s.charAt(j))){
            hm.put(s.charAt(j),hm.get(s.charAt(j))+1);
          }else{
             hm.put(s.charAt(j),+1);
          }
          while((j-i+1)>hm.size()){
              int val=hm.get(s.charAt(i));
              hm.remove(s.charAt(i));
              if(val>1){
                hm.put(s.charAt(i),1);
              }
              i++;
          }
        ans=Math.max(ans,j-i+1);
       }
       return ans;
    }
}
