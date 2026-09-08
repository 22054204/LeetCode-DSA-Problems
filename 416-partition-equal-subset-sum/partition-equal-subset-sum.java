class Solution {
    int n = 0;
    Boolean[][] dp;
    public int sum(int[] nums){
        int sum = 0;
        for(int num:nums){
            sum+=num;
        }
        return sum;
    }
    public boolean canPartition(int[] nums) {
        n=nums.length;
        int sum = sum(nums);
        if(sum%2!=0){ // if sum is odd, then we did not make sum1 and sum2 equal in any way.
            return false;
        }
        int target = sum/2;
        dp = new Boolean[n+1][target+1];
        return solve(nums, 0, 0, target);
    }
    public boolean solve(int[] nums, int i, int sum1, int target){
        if(sum1==target){
            return true;
        }
        if(i==n || sum1>target){
            return false;
        }
        if(dp[i][sum1]!=null) return dp[i][sum1];
        boolean take = solve(nums, i+1, sum1+nums[i], target);
        boolean skip = solve(nums, i+1, sum1, target);
        return dp[i][sum1] = (take || skip);
    }
}