class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer>ss=new Stack<>();
        HashMap<Integer,Integer>hm=new HashMap<>();
        for(int i=0;i<target.length;i++){
            hm.put(target[i],1);
        }
        List<String>ll=new ArrayList<>();
        for(int i=1;i<=n;i++){
            ss.push(i);
            ll.add("Push");
            if(!hm.containsKey(ss.peek())){
                ss.pop();
                ll.add("Pop");
            }
            if(ss.size()==target.length){
                break;
            }
        }
        return ll;
    }
}