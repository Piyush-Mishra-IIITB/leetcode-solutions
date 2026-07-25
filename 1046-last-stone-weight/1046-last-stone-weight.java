class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer>ll=new ArrayList<>();
        for(int i=0;i<stones.length;i++){
            ll.add(stones[i]);
        }
        while(ll.size()>1){
            Collections.sort(ll);
            if(ll.size()>=2){
            int a=ll.get(ll.size()-1);
            ll.remove(ll.size()-1);
            int b=ll.get(ll.size()-1);
            ll.remove(ll.size()-1);
            if(a>b){
                ll.add(a-b);
            }
            }
            
        }
        if(ll.size()==1){
            return ll.get(0);
        }else{
            return 0;
        }
    }
}