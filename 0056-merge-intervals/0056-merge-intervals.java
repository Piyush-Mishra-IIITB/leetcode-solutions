class Solution {
    public class pair{
        int a;
        int b;
        public pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int[][] merge(int[][] arr) {
     List<pair>ll=new ArrayList<>();
     Stack<pair>ss=new Stack<>();
     Arrays.sort(arr,(a,b)->a[0]-b[0]);
     ss.push(new pair(arr[0][0],arr[0][1]));
     for(int i=1;i<arr.length;i++){
        int a[]=arr[i];
        int u=a[0];
        int v=a[1];
        if(ss.peek().b>=u){
            pair curr=ss.pop();
            int fir=curr.a;
            int sec=curr.b>v?curr.b :v;
            ss.push(new pair(fir,sec));
        }else{
            if(!ss.isEmpty()){
               ll.add(ss.pop());
            }
            ss.push(new pair(u,v));
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
