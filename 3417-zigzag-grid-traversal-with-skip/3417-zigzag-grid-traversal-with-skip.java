class Solution {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer>ans=new ArrayList<>();
        boolean t=true;
        for(int i=0;i<grid.length;i++){
            int a[]=grid[i];
            int size=a.length;
            if(size%2==0){
                if(t){
                for(int j=0;j<a.length;j+=2){
                    ans.add(a[j]);
                }
            }else{
                for(int j=a.length-1;j>=0;j-=2){
                    ans.add(a[j]);
                }
            }
            t=!t;
            }else{
                if(t){
                for(int j=0;j<a.length;j+=2){
                    ans.add(a[j]);
                }
            }else{
                for(int j=a.length-2;j>=0;j-=2){
                    ans.add(a[j]);
                }
            }
            t=!t;
            }
            
        }
        return ans;
    }
}