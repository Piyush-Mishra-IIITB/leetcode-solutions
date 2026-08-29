class Solution {
    
    static final long MOD = 1000000007;
    
    public int countGoodNumbers(long n) {
        long first = n / 2;          
        long second = n - first;     
        
        long ans = (pow(5, second) * pow(4, first)) % MOD;
        
        return (int) ans;
    }
    
    public long pow(long base, long exp) {
        
        long ans = 1;
        
        while (exp > 0) {
            
            if (exp % 2 == 1) {
                ans = (ans * base) % MOD;
            }
            
            base = (base * base) % MOD;
            exp = exp / 2;
        }
        return ans;
    }
}