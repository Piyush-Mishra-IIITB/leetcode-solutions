class Solution {

    class Pair{
        int node;
        int cost;
        int stops;

        Pair(int node,int cost,int stops){
            this.node=node;
            this.cost=cost;
            this.stops=stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        int[][] dist = new int[n][k + 2];

        for(int i=0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b)->a.cost-b.cost);

        pq.add(new Pair(src,0,0));
        dist[src][0]=0;

        while(!pq.isEmpty()){

            Pair curr=pq.poll();

            int node=curr.node;
            int cost=curr.cost;
            int stops=curr.stops;

            if(node==dst){
                return cost;
            }

            if(stops==k+1){
                continue;
            }

            if(cost>dist[node][stops]){
                continue;
            }

            for(int[] flight:flights){

                if(flight[0]==node){

                    int next=flight[1];
                    int wt=flight[2];

                    int newCost=cost+wt;

                    if(newCost<dist[next][stops+1]){

                        dist[next][stops+1]=newCost;

                        pq.add(
                            new Pair(
                                next,
                                newCost,
                                stops+1
                            )
                        );
                    }
                }
            }
        }

        return -1;
    }
}