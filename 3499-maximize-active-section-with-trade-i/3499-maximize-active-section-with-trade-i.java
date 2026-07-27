class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        
        List<Integer>ll=new ArrayList<>();
        int counter=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                counter++;
            }
            else{
                if(counter!=0){
                    ll.add(counter);
                }
                counter=0;
            }
        }
        if(counter!=0){
          ll.add(counter);
        }
        for(int i=0;i<ll.size();i++){
            System.out.println(ll.get(i));
        }
        int initOnes=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                initOnes++;
            }
        }
        if(ll.size()==1 || ll.size()==0){
            return initOnes;
        }
        int max=ll.get(1)+ll.get(0);
        for(int i=2;i<ll.size();i++){
            max=Math.max(ll.get(i)+ll.get(i-1),max);
        }
        System.out.println(max);
        System.out.println(initOnes);
        return max+initOnes;
    }
}