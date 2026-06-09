class Solution {
    public class pair{
        String s;
        int val;
        public pair(String s,int val){
            this.s=s;
            this.val=val;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<pair>qq=new LinkedList<>();
        HashSet<String>hm=new HashSet<>();
        for(int i=0;i<bank.length;i++){
            hm.add(bank[i]);
        }
        if(hm.contains(endGene)==false){
            return -1;
        }
        HashMap<String,Boolean>hm2=new HashMap<>();
        qq.add(new pair(startGene,0));
        hm2.put(startGene,true);
        int ans=0;
        while(!qq.isEmpty()){

            pair p=qq.poll();
            String ss=p.s;
            int value=p.val;
            if(ss.equals(endGene)){
                return value;
            }
            for(int i=0;i<bank.length;i++){
                if(helper(ss,bank[i]) && hm2.containsKey(bank[i])==false ){
                    qq.add(new pair(bank[i],value+1));
                    hm2.put(bank[i],true);
                }
            }
        }
        return -1;
    }
    public boolean helper(String a,String b){
        int i=0;
        int dif=0;
        while(i<a.length() && i<b.length()){
            if(a.charAt(i)!=b.charAt(i)){
                dif++;
            }
            i++;
        }
        while(i<a.length()){
            i++;
            dif++;
        }
        while(i<b.length()){
            i++;
            dif++;
        }

        return dif==1;
    }
}