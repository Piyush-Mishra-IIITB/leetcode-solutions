class Solution {
    public boolean canAliceWin(int n) {
        return helper(10,n,1);
    }
    public boolean helper(int turn,int no,int chance){
        if(no==0){
            if(chance==1){
                return false;
            }
            return true;
        }
        if(no<0){
            if(chance==1){
                return true;
            }
            return false;
        }
        if(chance==1){
            return helper(turn-1,no-turn,0);
        }else{
           return helper(turn-1,no-turn,1);
        }
    }
}