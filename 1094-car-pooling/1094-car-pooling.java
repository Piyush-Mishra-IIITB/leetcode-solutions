class Solution {
    public boolean carPooling(int[][] arr, int k) {
        Arrays.sort(arr,(a,b)->{
           if(a!=b){
            return a[0]-b[0];
           }
           return a[1]-b[1];
        });
        
        // for(int i=0;i<arr.length;i++){
        //    for(int j=0;j<3;j++){
        //     System.out.println(arr[i][j]);
        //    }
        // }
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<arr.length;i++){
               int a[]=arr[i];
               int u=a[0];
               int v=a[1];
               int x=a[2];
               for(int j=v;j<x;j++){
                  if(hm.containsKey(j)){
                    int curr=hm.get(j);
                    if(curr+u>k){
                        return false;
                    }
                    hm.put(j,curr+u);
                  }else{
                    if(u>k){
                        return false;
                    }
                    hm.put(j,u);
                  }
               }
        }
        return true;
    }
}