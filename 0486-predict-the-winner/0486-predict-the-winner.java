class Solution {
    public boolean predictTheWinner(int[] nums) {
          return helper(nums,0,nums.length-1,1,0,0);
    }
    public boolean helper(int arr[],int i,int j,int play,int playera,int playerb){
      if(i>j){
          if(playera>=playerb){
            return true;
          }
          return false;
      }
      boolean a;
      if(play==1){
          boolean front=helper(arr,i+1,j,0,playera+arr[i],playerb);
          boolean back=helper(arr,i,j-1,0,playera+arr[j],playerb);
          a=front || back;
      }else{
          boolean front=helper(arr,i+1,j,1,playera,playerb+arr[i]);
          boolean back=helper(arr,i,j-1,1,playera,playerb+arr[j]);
          a=front && back;
      }
      return a;
    }
}