class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int length=nums1.length+nums2.length;
         System.out.println(length);
         if(length%2==0){
            int first=length/2;
            int sec=(length-1)/2;
            int f=helper(nums1,nums2,first+1);
            // System.out.println(f);
            int s=helper(nums1,nums2,sec+1);
            // System.out.println(s);
            // System.out.println(f+s);
            return (double)(f+s)/2;
         }else{
            int first=length/2;
            int f=helper(nums1,nums2,first+1);
            // System.out.println(f);
            return (double)f;
         }
 
    }
        public int helper(int nums1[],int nums2[],int toFind){
            int i=0;
            int j=0;
            int count=0;
            while(i<nums1.length && j<nums2.length){
                 if(count==toFind-1){
                    if(nums1[i]>nums2[j]){
                        return nums2[j];
                    }
                    return nums1[i];
                 }
                 if(nums1[i]>=nums2[j]){
                    j++;
                 }else{
                    i++;
                 }
               count++;
            }
            while(i<nums1.length){
                if(count==toFind-1){
                    return nums1[i];
                 }
                 i++;
                 count++;
            }
                while(j<nums2.length){
                     if(count==toFind-1){
                         return nums2[j];
                     }
                    j++;
                 count++;
         }
         return -1;
    }
}