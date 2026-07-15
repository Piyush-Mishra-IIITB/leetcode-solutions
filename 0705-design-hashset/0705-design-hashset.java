class MyHashSet {
    List<Integer> ll;
    public MyHashSet() {
        ll=new ArrayList<>();
    }
    
    public void add(int key) {
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)==key){
                return ;
            }
        }
        ll.add(key);
    }
    
    public void remove(int key) {
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)==key){
                ll.remove(i);
            }
        }
    }
    
    public boolean contains(int key) {
        for(int i=0;i<ll.size();i++){
            if(ll.get(i)==key){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */