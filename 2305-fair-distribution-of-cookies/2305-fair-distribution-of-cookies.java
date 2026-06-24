class Solution {
    int max=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int child[]=new int[k];
        helper(0,child,cookies);
        return max;
    }
    public void helper(int index,int child[],int cookies[]){
        if(index==cookies.length){
            int min=child[0];
           for(int i=0;i<child.length;i++){
            min=Math.max(min,child[i]);
           }
       max=Math.min(min,max);
       return;
        }
        for(int i=0;i<child.length;i++){
            child[i]+=cookies[index];
            helper(index+1,child,cookies);
            child[i]-=cookies[index];
        }
    }
}