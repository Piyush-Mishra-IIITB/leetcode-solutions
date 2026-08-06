class Solution {
    public String reverseWords(String s) {
        String arr[]=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String curr=arr[i];
            for(int j=curr.length()-1;j>=0;j--){
                sb.append(curr.charAt(j));
            }
            if(i!=arr.length-1){
                sb.append(" ");}
        }
        return sb.toString();
        
    }
}