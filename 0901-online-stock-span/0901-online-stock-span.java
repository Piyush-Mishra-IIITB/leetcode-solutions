class StockSpanner {
    public class pair{
        int first;
        int second;
        public pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    Stack<pair>ss=new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
       int  span=1;
        while(!ss.isEmpty() && ss.peek().first<=price){
            span=ss.peek().second+span;
            ss.pop();
        }
        ss.push(new pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */