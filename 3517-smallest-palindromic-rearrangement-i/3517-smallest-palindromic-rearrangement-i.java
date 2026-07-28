class Solution {
    String min;
    public String smallestPalindrome(String s) {
        int length=s.length();
        if(length%2!=0){
            char middle=s.charAt(length/2);
            char arr[]=new char[length/2];
            for(int i=0;i<length/2;i++){
                 arr[i]=s.charAt(i);
            }
            Arrays.sort(arr);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<length/2;i++){
                sb.append(arr[i]);
            }
            String firstHalf=sb.toString();
            String secondHalf=sb.reverse().toString();
            return firstHalf+middle+secondHalf;
        }else{
           char arr[]=new char[length/2];
            for(int i=0;i<length/2;i++){
                 arr[i]=s.charAt(i);
            }
            Arrays.sort(arr);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<length/2;i++){
                sb.append(arr[i]);
            }
            String firstHalf=sb.toString();
            String secondHalf=sb.reverse().toString();
            return firstHalf+secondHalf;
        }
    }
}