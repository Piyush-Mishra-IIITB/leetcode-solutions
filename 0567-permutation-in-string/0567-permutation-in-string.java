class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int i=0;
        int j=s1.length();
        while(j<=s2.length()){
            if(helper(s1,s2.substring(i,j))){
                return true;
            }
            i++;
            j++;
        }
        return false;

    }
    public boolean helper(String s1,String s2){
       HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s1.length();i++){
            char c=s1.charAt(i);
             if(hm.containsKey(c)){
                hm.put(c,hm.get(c)+1);
             }else{
                hm.put(c,1);
             }
        }
        HashMap<Character,Integer>hm2=new HashMap<>();
        for(int i=0;i<s2.length();i++){
            char c=s2.charAt(i);
             if(hm2.containsKey(c)){
                hm2.put(c,hm2.get(c)+1);
             }else{
                hm2.put(c,1);
             }
        }
        return hm.equals(hm2);
    }
}