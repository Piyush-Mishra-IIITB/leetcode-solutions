class LRUCache {
     public class Node{
        int key;
        int val;
        Node next;
        Node prev;
        public Node(int key,int val){
            this.key=key;
            this.val=val;
        }  
     }
        Node head;
        Node tail;
        int capacit;
        HashMap<Integer,Node>hm;
    public LRUCache(int capacity) {
        capacit=capacity;
        hm=new HashMap<>();
        head =new Node(-1,-1);
        tail=new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(hm.containsKey(key)){
            Node curr=hm.get(key);
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
            Node last=tail.prev;
            last.next=curr;
            curr.prev=last;
            curr.next=tail;
            tail.prev=curr;
            return curr.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)){
            Node curr=hm.get(key);
            curr.prev.next=curr.next;
            curr.next.prev=curr.prev;
            curr.val=value;
            Node last=tail.prev;
            last.next=curr;
            curr.prev=last;
            curr.next=tail;
            tail.prev=curr;
            hm.remove(curr.key);
            hm.put(key,curr);
            return;
            }
        if(hm.size()==capacit){
            Node toremoved=head.next;
            toremoved.prev.next=toremoved.next;
            toremoved.next.prev=toremoved.prev;
            hm.remove(toremoved.key);
            Node curr=new Node(key,value);
            Node last=tail.prev;
            last.next=curr;
            curr.prev=last;
            curr.next=tail;
            tail.prev=curr;
            hm.put(key,curr);
        }
        else{
            Node curr=new Node(key,value);
            Node last=tail.prev;
            last.next=curr;
            curr.prev=last;
            curr.next=tail;
            tail.prev=curr;
            hm.put(key,curr);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */