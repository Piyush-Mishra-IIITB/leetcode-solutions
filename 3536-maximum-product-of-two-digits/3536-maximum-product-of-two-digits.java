class Solution {
    public int maxProduct(int n) {
        List<Integer>ll=new ArrayList<>();
        while(n>0){
            ll.add(n%10);
            n=n/10;
        }
        Collections.sort(ll);
        return ll.get(ll.size()-1)*ll.get(ll.size()-2);
    }
}