class Solution {
    Integer dp[][][][];
    public int furthestBuilding(int[] arr, int bricks, int ladders) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        int length=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]<=0){
                length++;
                continue;
            }else{
                if(pq.size()<ladders){
                    length++;
                    pq.add(arr[i]-arr[i-1]);
                }else{
                    int rq=arr[i]-arr[i-1];
                    if(!pq.isEmpty() && pq.peek()<rq){
                        if(pq.peek()<=bricks){
                            length++;
                            bricks-=pq.peek();
                            pq.poll();
                            pq.add(rq);
                        }else{
                            break;
                        }
                    }else{
                        if(rq<=bricks){
                            length++;
                            bricks-=rq;
                        }else{
                            break;
                        }
                    }
                }
            }
            
        }
          return length;
    }
    // public int helper(int ind,int prev,int br,int ld,int arr[]){
    //     if(ind==arr.length){
    //         return 0;
    //     }
    //     if(dp[ind][prev][br][ld]!=null){
    //         return dp[ind][prev][br][ld];
    //     }
    //     int ans=0;
    //     if(arr[ind]<=arr[prev]){
    //         ans+=1+helper(ind+1,ind,br,ld,arr);
    //     }else{
    //         //
    //         int a=0;
    //         int b=0;
    //         if(arr[ind]-arr[prev]>br && ld==0){
    //             return 0;
    //         }
    //         if(arr[ind]-arr[prev]<=br){
    //             a=1+helper(ind+1,ind,br-(arr[ind]-arr[prev]),ld,arr);
    //         }
    //         if(ld>0){
    //             b=1+helper(ind+1,ind,br,ld-1,arr);
    //         }
    //         ans=Math.max(ans,Math.max(a,b));
    //     }
    //     return dp[ind][prev][br][ld]=ans;
    // }
}