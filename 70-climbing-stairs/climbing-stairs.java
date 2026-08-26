class Solution {
    int[] dp = new int[45+1];
    
    public int climbStairs(int n) {
        Arrays.fill(dp, -1);
        return memo(n);
    }
    int memo(int n){ //Memoization
        if(n<0) return 0;
        if(n==0){
            return 1; 
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        int one_step = memo(n-1);
        int two_step = memo(n-2);

        return dp[n] = one_step + two_step;
    }
    int helper(int n){ //recursive approach (TLE)
        if(n<0) return 0;
        if(n==0){
            return 1; 
        }
        int one_step = helper(n-1);
        int two_step = helper(n-2);

        return one_step + two_step;
    }
}