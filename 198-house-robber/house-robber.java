class Solution {
    int[] dp = new int[101];
    public int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return solve(nums, 0);
    }
    // Recursive + Memoization (Top Down Approach)
    public int solve(int[] nums, int i){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i]; 
        int take = nums[i]+solve(nums, i+2);
        int skip = solve(nums, i+1);
        return dp[i] = Math.max(take, skip);
    }
}