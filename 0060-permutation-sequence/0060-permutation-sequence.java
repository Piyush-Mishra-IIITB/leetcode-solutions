class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        HashSet<Integer>hs=new HashSet<>();
        for(int i=0;i<n;i++){
           for(int j=1;j<=n;j++){
             if(hs.contains(j)){
                continue;
             }
             int w=ways(n-(i+1));
             if(k>w){
                k-=w;
             }else{
                sb.append(j);
                hs.add(j);
                break;
             }
           }
        }
        return sb.toString();
    }
    public int ways(int n){
          return fact(n);
    }
    public int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*fact(n-1);
    }
}