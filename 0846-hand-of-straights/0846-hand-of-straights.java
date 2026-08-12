class Solution {
    public boolean isNStraightHand(int[] hand, int gs) {
        Arrays.sort(hand);
        if(hand.length%gs!=0){
            return false;
        }
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<hand.length;i++){
            int curr=hand[i];
            if(hm.containsKey(curr)){
                hm.put(curr,hm.get(curr)+1);
            }else{
                hm.put(curr,1);
            }
        }
        int length=0;
        for(int i=0;i<hand.length;i++){
             int curr=hand[i];
             if(!hm.containsKey(curr)){
                continue;
             }
             for(int j=curr;j<curr+gs;j++){
                System.out.println(j);
                if(hm.containsKey(j)){
                    int val=hm.get(j);
                    hm.remove(j);
                    if(val>1){
                      hm.put(j,val-1);
                    }
                }else{
                    return false;
                }
            }

        }
        return true;
    }
}