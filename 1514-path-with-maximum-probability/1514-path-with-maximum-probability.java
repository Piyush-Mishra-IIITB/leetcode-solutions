class Solution {

    class pair{
        double p;
        int node;

        public pair(double p,int node){
            this.p=p;
            this.node=node;
        }
    }

    public double maxProbability(int n,int[][] edges,double[] succProb,int start_node,int end_node){

        List<List<double[]>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){

            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(new double[]{v,succProb[i]});
            adj.get(v).add(new double[]{u,succProb[i]});
        }

        PriorityQueue<pair> pq=
            new PriorityQueue<>((a,b)->Double.compare(b.p,a.p));

        double prob[]=new double[n];

        prob[start_node]=1.0;

        pq.add(new pair(1.0,start_node));

        while(!pq.isEmpty()){

            pair cur=pq.poll();

            double p=cur.p;
            int node=cur.node;

            if(node==end_node){
                return p;
            }

            for(double it[]:adj.get(node)){

                int v=(int)it[0];
                double edgeProb=it[1];

                double newProb=p*edgeProb;

                if(newProb>prob[v]){

                    prob[v]=newProb;

                    pq.add(new pair(newProb,v));
                }
            }
        }

        return 0.0;
    }
}