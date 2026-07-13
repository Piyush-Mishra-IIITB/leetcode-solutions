class NumArray {
    int segment[];
    int length;
    public NumArray(int[] nums) {
        length=nums.length;
        segment=new int[4*nums.length];
        builder(0,0,nums.length-1,nums);
    }
    public void builder(int ind,int left,int right,int nums[]){
        if(left==right){
            segment[ind]=nums[left];
            return;
        }
        int mid=(left+right)/2;
        builder(2*ind+1,left,mid,nums);
        builder(2*ind+2,mid+1,right,nums);
        segment[ind]=segment[2*ind+1]+segment[2*ind+2];
    }
    public void update(int index, int val) {
        int n=length;
        updat(index,val,0,0,n-1);
    }
    public void updat(int index,int val,int ind,int left,int right){
        if(left==right){
            segment[ind]=val;
            return;
        }
        int mid=(left+right)/2;
        if(index<=mid){
            updat(index,val,2*ind+1,left,mid);
        }else{
            updat(index,val,2*ind+2,mid+1,right);
        }
        segment[ind]=segment[2*ind+1]+segment[2*ind+2];
    }
    
    public int sumRange(int left, int right) {
        int n=length;
        return sum(left,right,0,0,n-1);
    }
    public int sum(int start,int end,int ind,int left,int right){
        if(left>end || right<start){
            return 0;
        }
        else if(left>=start && end>=right){
            return segment[ind];
        }else{
            int mid=(left+right)/2;
            return sum(start,end,2*ind+1,left,mid)+sum(start,end,2*ind+2,mid+1,right);
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */