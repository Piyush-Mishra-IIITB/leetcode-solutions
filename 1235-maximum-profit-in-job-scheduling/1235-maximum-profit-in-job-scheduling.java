class Solution {
    Integer[] dp;
    int[][] jobs;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        dp = new Integer[n];
        return helper(0);
    }

    public int helper(int ind) {
        if (ind >= jobs.length)
            return 0;
        if (dp[ind] != null)
            return dp[ind];
        int skip = helper(ind + 1);
        int next = binarySearch(jobs[ind][1]);
        int take = jobs[ind][2] + helper(next);
        return dp[ind] = Math.max(skip, take);
    }
    public int binarySearch(int endTime) {
        int low = 0;
        int high = jobs.length - 1;
        int ans=jobs.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(jobs[mid][0]>=endTime){
                 ans=mid;
                 high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}