class BrowserHistory {
    public class Node{
        String s;
        Node prev;
        Node next;
        public Node(String s){
            this.s=s;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer,Node>hm;
    int currPointer=1;
    int current;
    public BrowserHistory(String homepage) {
        current=1;
        hm=new HashMap<>();
        head=new Node("");
        tail=new Node("");
        
        Node newNode=new Node(homepage);
        head.next=newNode;
        newNode.prev=head;
        newNode.next=tail;
        tail.prev=newNode;
        hm.put(currPointer,newNode);
    }
    
    public void visit(String url) {
        Node newNode=new Node(url);
        Node last=hm.get(currPointer);
        List<Integer> remove = new ArrayList<>();

       for(Integer key : hm.keySet()){
         if(key > currPointer){
           remove.add(key);
            }
        }
        for(Integer key : remove){
            hm.remove(key);
        }
        last.next=newNode;
        newNode.prev=last;
        newNode.next=tail;
        tail.prev=newNode;
        currPointer++;
        hm.put(currPointer,newNode);
        current=currPointer;
    }
    
    public String back(int steps) {
        currPointer-=steps;
        if(currPointer<1){
            currPointer=1;
        }
        return hm.get(currPointer).s;
    }
    
    public String forward(int steps) {
        currPointer+=steps;
        if(currPointer>current){
            currPointer=current;
        }
        return hm.get(currPointer).s;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */