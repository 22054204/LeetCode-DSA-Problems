class Solution {
    int m = 0;
    int n = 0;
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        if(mat[m-1][n-1]==1) return 0; 
        dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return solve(mat, 0, 0);
    }
    private int solve(int[][] mat, int i, int j){
        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(mat[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = solve(mat, i+1, j);
        int right = solve(mat, i, j+1);
        return dp[i][j] = down+right;
    } 
}