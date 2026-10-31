class Solution {
    int m = 0;
    int n = 0;
    int mod = 1000000007;
    int[][][] dp;
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][2];
        for(int[][] mat:dp){
            for(int[] arr:mat){
                Arrays.fill(arr, -1);
            }
        }
        return solve(grid, 0, 0, 0) % mod;
    }
    public int solve(int[][] grid, int i, int j, int prev){  // prev => {-1=not_find_yet, 0=down, 1 = right}
        if(i==m-1 && j==n-1) return 1;
        if(i>=m || j>=n) return 0;
        if(dp[i][j][prev] != -1) return dp[i][j][prev];
        if(grid[i][j]==0){
            int down = solve(grid, i+1, j, 0) % mod;
            int right = solve(grid, i, j+1, 1) % mod;
            return dp[i][j][prev] = ( (down % mod)+(right % mod) ) % mod;
        }
        if(grid[i][j]==1){
            if(prev == 1){
                int down = solve(grid, i+1, j, 0) % mod;
                return dp[i][j][prev] = down % mod;
            }else if(prev == 0){
                int right = solve(grid, i, j+1, 1) % mod;
                return dp[i][j][prev] = right % mod;
            }
        }
        return -1;
    }
}