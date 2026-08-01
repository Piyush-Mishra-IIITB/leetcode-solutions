class Solution {
    public boolean predictTheWinner(int[] nums) {
         return helper(0,nums.length-1,1,0,0,nums);
    }
    public boolean helper(int i,int j,int turn,int player1,int player2,int arr[]){
        if(i>j){
            if(player1>=player2){
                return true;
            }
            return false;
        }
        boolean ans=false;
        if(turn==1){
            boolean fr=helper(i+1,j,0,player1+arr[i],player2,arr);
            boolean bk=helper(i,j-1,0,player1+arr[j],player2,arr);
            ans= fr || bk;
        }else{
            boolean fr=helper(i+1,j,1,player1,player2+arr[i],arr);
            boolean bk=helper(i,j-1,1,player1,player2+arr[j],arr);
            ans= fr && bk;
        }
        return ans;
    }
}