class Solution {
    public class pair{
        int a;
        int b;
        public pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<pair>pq=new PriorityQueue<>((c,d)->c.a-d.a);
        int length=costs.length;
        for(int i=0;i<costs.length;i++){
            int a[]=costs[i];
            System.out.println(a[0]-a[1]);
            pq.add(new pair(a[0]-a[1],i));
        }
        int i=0;
        int j=0;
        int ans=0;
        while(i<length){
            if(j<length/2){
                pair p=pq.poll();
                int ind=p.b;
               ans+=costs[ind][0];
            }else{
                pair p=pq.poll();
                int ind=p.b;
               ans+=costs[ind][1];
            }
            i++;
            j++;
        }
        return ans;
         
    }
}