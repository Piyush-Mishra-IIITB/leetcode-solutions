class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer>ll=new ArrayList<>();
        int carry=1;
        for(int i=digits.length-1;i>=0;i--){
             ll.add((digits[i]+carry)%10);
             carry=(digits[i]+carry)/10;
        }
        if(carry!=0){
            ll.add(carry);
        }
        int ans[]=new int[ll.size()];
        int j=0;
        for(int i=ll.size()-1;i>=0;i--){
           ans[j]=ll.get(i);
           j++;
        }
        return ans;
    }
}