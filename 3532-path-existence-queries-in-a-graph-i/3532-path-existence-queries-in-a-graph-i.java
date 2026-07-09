public class Ds{
    List<Integer>parent=new ArrayList<>();
    List<Integer>rank=new ArrayList<>();
    public Ds(int n){
        for(int i=0;i<n;i++){
            rank.add(0);
            parent.add(i);
        }
    }
    public int findUpar(int node){
        if(node==parent.get(node)){
            return node;
        }
        parent.set(node,findUpar(parent.get(node)));
        return parent.get(node);
    }
    public void union(int a,int b){
        int uA=findUpar(a);
        int uB=findUpar(b);
        if(uA==uB){
            return;
        }
        else if(rank.get(uA)>rank.get(uB)){
            parent.set(uB,uA);
        }
        else if(rank.get(uA)<rank.get(uB)){
            parent.set(uA,uB);
        }
        else{
            int currRank=rank.get(uA);
            parent.set(uB,uA);
            rank.set(uA,currRank+1);
        }
    }
}
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        Ds ds=new Ds(n);
        for(int i=1;i<nums.length;i++){
             if(nums[i] - nums[i-1] <= maxDiff){
                  ds.union(i, i-1);
            }
        }
        
        boolean ans[]=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
            int u=a[0];
            int v=a[1];
            if(ds.findUpar(u)==ds.findUpar(v)){
                ans[i]=true;
            }else{
                ans[i]=false;
            }
        }
       return ans;
    }
    public int bs(int arr[],int ind,int target){
        int start=ind;
        int end=arr.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return start;
    }
}