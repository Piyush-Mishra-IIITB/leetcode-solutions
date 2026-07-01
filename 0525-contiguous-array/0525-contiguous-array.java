import java.util.*;

class Solution {
    public int findMaxLength(int[] arr) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        hm.put(0,-1);
        int ans=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                sum--;
            }else{
                sum++;
            }
             if(hm.containsKey(sum)){
                ans=Math.max(ans,i-hm.get(sum));
             }else{
                hm.put(sum,i);
             }
        }
        return ans;
    }
}