class Solution {
    public int minSubarray(int[] nums, int p) {

        HashMap<Integer,Integer> hm = new HashMap<>();

        long total = 0;
        for(int x : nums)
            total += x;

        int target = (int)(total % p);

        if(target == 0)
            return 0;

        hm.put(0,-1);

        long prefix = 0;
        int ans = nums.length;

        for(int i = 0; i < nums.length; i++) {

            prefix += nums[i];

            int rem = (int)(prefix % p);

            int find = (rem - target + p) % p;

            if(hm.containsKey(find)) {
                ans = Math.min(ans, i - hm.get(find));
            }

            hm.put(rem, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}