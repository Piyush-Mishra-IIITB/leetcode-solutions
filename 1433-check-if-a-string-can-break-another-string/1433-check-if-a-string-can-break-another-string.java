class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        List<Character>ll=new ArrayList<>();
        List<Character>ll2=new ArrayList<>();
        for(int i=0;i<s1.length();i++){
            ll.add(s1.charAt(i));
        }
        for(int i=0;i<s2.length();i++){
            ll2.add(s2.charAt(i));
        }
        Collections.sort(ll);
        Collections.sort(ll2);
        boolean ans=false;
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)>ll2.get(i)){
                ans=true;
            }
        }
        if(ans){
            for(int i=0;i<ll.size();i++){
            if(ll.get(i)<ll2.get(i)){
                return false;
            }
          }
        }else{
            for(int i=0;i<ll2.size();i++){
            if(ll.get(i)>ll2.get(i)){
                return false;
            }
         }
        }
        return true;
    }
}