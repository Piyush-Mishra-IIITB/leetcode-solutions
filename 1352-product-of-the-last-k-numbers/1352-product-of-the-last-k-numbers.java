class ProductOfNumbers {
    List<Integer>pr;
    public ProductOfNumbers() {
        pr=new ArrayList<>();
        pr.add(1);
    }
    
    public void add(int num) {
        int val=num*pr.get(pr.size()-1);
        if(val==0){
             pr.clear();
             pr.add(1);
        }else{
            pr.add(val);
        }
        
    }
    
    public int getProduct(int k) {
        if(k>=pr.size()){
            return 0;
        }
        int size=pr.size();
        int val=pr.get(size-1-k);
        if(val==0){
            return pr.get(size-1);
        }
        return pr.get(size-1)/val;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */