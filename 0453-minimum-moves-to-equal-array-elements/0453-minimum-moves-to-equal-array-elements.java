class Solution {
    public int minMoves(int[] arr) {
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            min=Math.min(arr[i],min);
        }
        int steps=0;
        for(int i=0;i<arr.length;i++){
             steps+=arr[i]-min;
        }
        return steps;
    }
    public int helper(int steps,int arr[]){
        if(help(arr)){
            return steps;
        } 
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i]+1;
        }
       return helper(steps+1,arr);
    }
    public boolean help(int arr[]){
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            hm.put(arr[i],1);
        }
        return hm.size()==1;
    }
}