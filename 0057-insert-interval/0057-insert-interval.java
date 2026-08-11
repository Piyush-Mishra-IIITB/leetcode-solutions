class Solution {
    public class pair{
        int a;
        int b;
        public pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<pair>ll=new ArrayList<>();
        int newInterVals[][]=new int[intervals.length+1][2];
        for(int i=0;i<intervals.length;i++){
            newInterVals[i][0]=intervals[i][0];
            newInterVals[i][1]=intervals[i][1];
        }
        newInterVals[newInterVals.length-1][0]=newInterval[0];
        newInterVals[newInterVals.length-1][1]=newInterval[1];
        Arrays.sort(newInterVals,(a,b)->a[0]-b[0]);
        Stack<pair>ss=new Stack<>();
        ss.push(new pair(newInterVals[0][0],newInterVals[0][1]));
        for(int i=1;i<newInterVals.length;i++){
               int fir=newInterVals[i][0];
               int sec=newInterVals[i][1];
               if(ss.peek().b>=fir){
                     pair curr=ss.pop();
                     int f=curr.a;
                     int s=curr.b>sec?curr.b :sec;
                     ss.push(new pair(f,s));
               }else{
                   if(!ss.isEmpty()){
                    ll.add(ss.pop());
                   }
                   ss.push(new pair(fir,sec));
               }
               }
        
        if(!ss.isEmpty()){
            ll.add(ss.pop());
        }
        int ans[][]=new int[ll.size()][2];
      for(int i=0;i<ll.size();i++){
        pair curr=ll.get(i);
        ans[i][0]=ll.get(i).a;
        ans[i][1]=ll.get(i).b;
      }
      return ans;
    }
}
