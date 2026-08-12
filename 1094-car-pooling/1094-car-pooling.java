class Solution {
    public class pair{
        int no;
        int val;
        public pair(int no,int val){
            this.no=no;
            this.val=val;
        }
    }
    public boolean carPooling(int[][] trips, int capacity) {
        List<pair>ll=new ArrayList<>();
        for(int i=0;i<trips.length;i++){
            int a[]=trips[i];
            int u=a[0];
            int v=a[1];
            int x=a[2];
            ll.add(new pair(v,u));
            ll.add(new pair(x,-u));
        }
        Collections.sort(ll,(a,b)->{
            if(a.no!=b.no){
                return a.no-b.no;
            }
            return a.val-b.val;
        });
        int sum=0;
        for(int i=0;i<ll.size();i++){
            pair p=ll.get(i);
            System.out.println("a"+ p.no + "b" +p.val);
        }
        for(int i=0;i<ll.size();i++){
            pair p=ll.get(i);
            sum+=p.val;
            if(sum>capacity){
                return false;
            }
        }
        return true;
    }
}