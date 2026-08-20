class Solution {
    public int[] rearrangeArray(int[] arr) {
       int i=0;
       int j=0;
       int k=0;
       int ans[]=new int[arr.length];
       while(i<arr.length && j<arr.length && k<arr.length){
             
             while(i<arr.length && arr[i]<0){
                        i++;
             }
             while(j<arr.length && arr[j]>0){
                   j++;
             }
             
            if(i<arr.length && j<arr.length && k<arr.length){
             System.out.println(arr[i]);
             System.out.println(arr[j]);
             ans[k]=arr[i];
             i++;
             k++;
             ans[k]=arr[j];
             j++;
             k++;
            } 
       }
       return ans;
    }
}