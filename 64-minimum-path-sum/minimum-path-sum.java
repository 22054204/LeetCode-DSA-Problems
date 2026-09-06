class Solution {
    int[][] dp;
    int m = 0;
    int n = 0;
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return solve(grid, 0, 0);
    }
    private int solve(int[][] grid, int i, int j){

        if(i==m-1 && j==n-1){
            return grid[i][j];
        }

        if(dp[i][j]!=-1) return dp[i][j];

        if(j==n-1){ // in this case, we only move down
            return dp[i][j] = grid[i][j] + solve(grid, i+1, j);
        }
        else if(i==m-1){ // in this case, we only move right
            return dp[i][j] = grid[i][j] + solve(grid, i, j+1);
        }
        return dp[i][j] = grid[i][j] + Math.min(solve(grid, i+1, j), solve(grid, i, j+1));
    }
}