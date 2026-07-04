class Solution {
    public int distributeCandies(int[] arr) {
        HashMap<Integer,Integer>hm=new HashMap<>();
       for(int i=0;i<arr.length;i++){
        if(hm.containsKey(arr[i])){
            hm.put(arr[i],hm.get(arr[i])+1);
        }else{
             hm.put(arr[i],1);
        }
       }
       if(hm.size()<arr.length/2){
        return hm.size();
       }else{
        return arr.length/2;
       }
    }
}