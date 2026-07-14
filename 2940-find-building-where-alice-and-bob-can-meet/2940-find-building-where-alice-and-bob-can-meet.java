class Solution {
    int segment[];
    public int[] leftmostBuildingQueries(int[] arr, int[][] queries) {
        int n=arr.length;
        segment=new int[4*n];
        build(0,0,n-1,arr);
        int ans[]=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int a[]=queries[i];
            int u=a[0];
            int v=a[1];
            int start=v;
            if(u==v){
                ans[i]=u;
                continue;
            }
            if(u<v && arr[v]>arr[u]){
                ans[i]=v;
                continue;
            }
            if(u>v && arr[v]<arr[u]){
                ans[i]=u;
                continue;
            }
            if(v<u){
                start=u;
            }
            int end=n-1;
            ans[i]=-1;
            while(start<=end){
                int mid=start+(end-start)/2;
                int curr=querie(start,mid,0,0,n-1,arr);
                if(arr[curr]>arr[u] && arr[v]<arr[curr]){
                    ans[i]=curr;
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return ans;
        
    }
    public int querie(int start,int end,int ind,int left,int right,int arr[]){
        if(left>end || start>right){
            return -1;
        }
        if(left>=start && end>=right){
            return segment[ind];
        }
        int mid=left+(right-left)/2;
        int li=querie(start,end,2*ind+1,left,mid,arr);
        int ri=querie(start,end,2*ind+2,mid+1,right,arr);
        if(li==-1 && ri!=-1){
            return ri;
        }
        if(ri==-1 && li !=-1){
            return li;
        }
        if(ri==-1 && li ==-1){
            return -1;
        }
        
        if(arr[li]>arr[ri]){
            return li;
        }else{
            return ri;
        }
    }
    public void build(int ind,int left,int right,int arr[]){
        if(left==right){
            segment[ind]=left;
            return;
        }
        int mid=left+(right-left)/2;
        build(2*ind+1,left,mid,arr);
        build(2*ind+2,mid+1,right,arr);
        int li=segment[2*ind+1];
        int ri=segment[2*ind+2];
        if(arr[ri]>arr[li]){
            segment[ind]=ri;
        }else{
            segment[ind]=li;
        }
    }
}