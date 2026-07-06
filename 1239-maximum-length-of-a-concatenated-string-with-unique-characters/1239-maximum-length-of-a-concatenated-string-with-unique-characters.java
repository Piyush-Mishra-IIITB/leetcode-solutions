class Solution {
    int ans=0;
    public int maxLength(List<String> arr) {
        StringBuilder sb=new StringBuilder();
        helper(0,arr,sb);
        return ans;
    }
    public void helper(int ind,List<String> arr,StringBuilder sb){
    
          ans=Math.max(ans,sb.length());

        for(int i=ind;i<arr.size();i++){
            if(helper2(sb,arr.get(i))){
                sb.append(arr.get(i));
                helper(i+1,arr,sb);
                sb.setLength(sb.length() - arr.get(i).length());
            }
        }
    }
    public boolean helper2(StringBuilder sb,String ss){
        String c=sb.toString()+ss;
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<c.length();i++){
            if(hm.containsKey(c.charAt(i))){
                hm.put(c.charAt(i),hm.get(c.charAt(i))+1);
            }else{
                hm.put(c.charAt(i),1);
            }
        }
        return hm.size()==c.length();
    }
}