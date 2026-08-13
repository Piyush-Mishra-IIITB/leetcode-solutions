class Solution {
    int parent[];
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }
    public int maxEvents(int[][] arr) {
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1]){return a[1]-b[1];}
            return a[0]-b[0];
        });
        int maxDay = 0;
        for (int[] event : arr) {
            maxDay = Math.max(maxDay, event[1]);
        }
        parent = new int[maxDay + 2];
        for (int i = 1; i <= maxDay + 1; i++) {
            parent[i] = i;
        }
        int length=0;
        for(int i=0;i<arr.length;i++){
            int a[]=arr[i];
            int u=a[0];
            int v=a[1];
           
           int day = find(u);
           if(day<=v){
             length++;
             parent[day]=find(day+1);
           }
        }
        return length;
    }
}