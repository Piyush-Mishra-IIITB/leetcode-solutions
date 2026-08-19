class Solution {
    public int[] sortArrayByParityII(int[] arr) {
        int i=0;
        int j=1;
       
        while(j<arr.length && i<arr.length){
            System.out.println(i);
            System.out.println(j);
              while(j<arr.length && arr[j]%2!=0){
                    j=j+2;
              }
              while(i<arr.length && arr[i]%2==0){
                i=i+2;
              }
           if(j<arr.length && i<arr.length) {
                  int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;

           }
              
    }
    return arr;
}
}