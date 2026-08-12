class Solution {
    public class pair{
        int a;
        int b;
        public pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0]){return b[0]-a[0];}
            return a[1]-b[1];
        });
        List<pair>ll=new ArrayList<>();
        ll.add(new pair(people[0][0],people[0][1]));
        for(int i=1;i<people.length;i++){
            helper(ll,people[i]);
        }
        int ans[][]=new int[ll.size()][2];
        for(int i=0;i<ll.size();i++){
            pair p=ll.get(i);
            ans[i][0]=p.a;
            ans[i][1]=p.b;
        }
        return ans;
    }
    public void helper(List<pair>ll,int arr[]){
        List<pair>newOne=new ArrayList<>();
        int val=arr[0];
        int people=arr[1];
        if(people==0){
            newOne.add(new pair(val,people));
        }
        int count=0;
        for(int i=0;i<ll.size();i++){
           pair p=ll.get(i);
           newOne.add(p);
           int a=p.a;
           if(a>=val){
            count++;
           }
           if(count==people){
            newOne.add(new pair(val,people));
           }
        }
        ll.clear();
        ll.addAll(newOne);
    }
}