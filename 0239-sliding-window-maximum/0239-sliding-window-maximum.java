class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
    int start=0;
    int end=k-1;
    TreeMap<Integer,Integer>hm=new TreeMap<>();
    for(int i=0;i<k;i++){
        if(hm.containsKey(arr[i])){
            hm.put(arr[i],hm.get(arr[i])+1);
        }else{
            hm.put(arr[i],1);
        }
    }
    List<Integer>ll=new ArrayList<>();
    ll.add(hm.lastKey());
    while(end<arr.length){
        int left=hm.get(arr[start]);
        hm.remove(arr[start]);
        if(left>1){
            hm.put(arr[start],left-1);
        }
        start++;
        end++;
        if(end==arr.length){
            break;
        }
        if(hm.containsKey(arr[end])){
            hm.put(arr[end],hm.get(arr[end])+1);
        }else{
            hm.put(arr[end],1);
        }
        ll.add(hm.lastKey());
    }
    int op[]=new int[ll.size()];
    for(int i=0;i<ll.size();i++){
        op[i]=ll.get(i);
    }
    return op;
}
}