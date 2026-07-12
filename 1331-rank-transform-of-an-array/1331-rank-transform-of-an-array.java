class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n=arr.length;
        int arr2[]=new int[arr.length];
        for(int i=0;i<n;i++){
            arr2[i]=arr[i];
        }
        Arrays.sort(arr2);
        HashMap<Integer,Integer>hm=new HashMap<>();
        int rank=1;
        for(int i=0;i<n;i++){
            int curr=arr2[i];
            if(hm.containsKey(curr)==false){
                hm.put(curr,rank);
                rank++;
            }
        }
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=hm.get(arr[i]);
        }
        return ans;
    }
}