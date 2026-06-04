class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
       int initialColour= image[sr][sc];
       if(initialColour==color){
        return image;
       }
       helper(sr,sc,initialColour,color,image);
       return image;
    }
    public void helper(int r,int c,int inC,int colour,int image[][]){
        if(r<0 || r>=image.length || c<0 || c>=image[0].length || image[r][c]!=inC){
            return;
        }
        image[r][c]=colour;
        helper(r+1,c,inC,colour,image);
        helper(r-1,c,inC,colour,image);
        helper(r,c+1,inC,colour,image);
        helper(r,c-1,inC,colour,image);
    }
}