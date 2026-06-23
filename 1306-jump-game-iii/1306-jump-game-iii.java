class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer>qq=new LinkedList<>();
        qq.add(start);
        int n=arr.length;
        boolean vis[]=new boolean[arr.length];
        vis[start]=true;
        while(!qq.isEmpty()){
            int curr=qq.poll();
            if(arr[curr]==0){
                return true;
            }
            if(curr+arr[curr]<n && vis[curr+arr[curr]]==false){
                qq.add(curr+arr[curr]);
                vis[curr+arr[curr]]=true;
            }
            if(curr-arr[curr]>=0 && vis[curr-arr[curr]]==false){
                qq.add(curr-arr[curr]);
                vis[curr-arr[curr]]=true;
            }
        }
        return false;
    }
}