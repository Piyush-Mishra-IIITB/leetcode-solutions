class Solution {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        HashMap<Character,Integer>hm=new HashMap<>();
        HashMap<Character,Integer>hm2=new HashMap<>();
        for(int i=0;i<word1.length();i++){
            char curr=word1.charAt(i);
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        for(int i=0;i<word2.length();i++){
            char curr=word2.charAt(i);
            if(hm2.containsKey(curr)){
                hm2.put(curr,hm2.get(curr)+1);
            }else{
                hm2.put(curr,1);
            }
        }
        for(Character ch:hm.keySet()){
            int val1=hm.get(ch);
            if(hm2.containsKey(ch)){
                int val2=hm2.get(ch);
                if(Math.abs(val1-val2)>3){
                    return false;
                }
            }else{
                if(val1>3){
                    return false;
                }
            }
        }
        for(Character ch:hm2.keySet()){
            int val1=hm2.get(ch);
            if(hm.containsKey(ch)){
                int val2=hm.get(ch);
                if(Math.abs(val1-val2)>3){
                    return false;
                }
            }else{
                if(val1>3){
                    return false;
                }
            }
        }
        return true;
    }
}