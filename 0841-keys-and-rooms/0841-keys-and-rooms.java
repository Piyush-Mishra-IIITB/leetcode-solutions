class Solution {
    public class pair{
        int room;
        List<Integer>key;
        public pair(int room,List<Integer>key){
            this.room=room;
            this.key=key;
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean vis[]=new boolean[rooms.size()];
        vis[0]=true;
        Queue<pair>qq=new LinkedList<>();
        qq.add(new pair(0,rooms.get(0)));
        while(!qq.isEmpty()){
            pair p=qq.poll();
            List<Integer>ll=p.key;
            for(int i=0;i<ll.size();i++){
                if(vis[ll.get(i)]==false){
                    qq.add(new pair(ll.get(i),rooms.get(ll.get(i))));
                    vis[ll.get(i)]=true;
                }
            }
        }
        for(int i=0;i<vis.length;i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}