class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maz=candies[0];
        for(int i=0;i<candies.length;i++){
            maz=Math.max(maz,candies[i]);
        }
        List<Boolean>ll=new ArrayList<>();
        for(int i=0;i<candies.length;i++){
            if(extraCandies+candies[i]>=maz){
                ll.add(true);
            }else{
                ll.add(false);
            }
        }
        return ll;
    }
}