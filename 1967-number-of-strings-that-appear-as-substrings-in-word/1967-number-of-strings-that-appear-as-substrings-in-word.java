class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count=0;
        for(int i=0;i<patterns.length;i++){
            String a=patterns[i];
            if(helper(a,word)){
                count++;
            }
        }
        return count;
    }
    public boolean helper(String a,String big){
        int length=a.length();
        int i=0;
        int j=length;
        while(j<=big.length()){
            if(big.substring(i,j).equals(a)){
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}