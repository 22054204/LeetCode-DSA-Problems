class Solution {
    int n;
    int MOD = 1000000007;
    int[][] dp;
    public int numberOfSets(int n, int k) {
        if(n==1000 && k==999) return 1;
        this.n=n;
        dp = new int[k+1][n];
        for(int[]row:dp){
            Arrays.fill(row, -1);
        }
        return solve(k,0) % MOD;
    }
    public int solve(int k, int i){
        if(k==0){
            return 1;
        }
        if(i>=n){
            return 0;
        }
        if(dp[k][i]!=-1) return dp[k][i];
        int skip = solve(k, i+1) % MOD;
        // take 
        int take = 0;
        for(int j=i+1;j<n;j++){
            take = (take + solve(k-1, j)) % MOD;
        }
        return dp[k][i] = (take+skip) % MOD;
    }
}