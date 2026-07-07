class Solution {
    public int longestArithSeqLength(int[] nums) {
        HashMap<Long,Long>hm[]=new HashMap[nums.length];
        for(int i=0;i<nums.length;i++){
            hm[i]=new HashMap<>();
        }
        long op=1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                long diff = (long) nums[i] - nums[j];
                long len = hm[j].getOrDefault(diff, 1L) + 1;
                hm[i].put(diff,Math.max(hm[i].getOrDefault(diff, 0L), len));
                op = Math.max(op, hm[i].get(diff));
            }
        }
        return (int)op;
    }
}