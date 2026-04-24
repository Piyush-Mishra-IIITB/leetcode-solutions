class Solution {
    public int furthestDistanceFromOrigin(String s) {
        int l=0;
        int r=0;
        for(int i=0;i<s.length();i++){
                  if(s.charAt(i)=='L'){
                   l++;
                  }
                  if(s.charAt(i)=='R'){
                   r++;
                  }
        }
        if(l>r){
            for(int i=0;i<s.length();i++){
                  if(s.charAt(i)=='_'){
                   l++;
                  }
        }}
        if(l<=r){
            for(int i=0;i<s.length();i++){
                  if(s.charAt(i)=='_'){
                   r++;
                  }
        }
        }
        return Math.abs(l-r);
    }
}