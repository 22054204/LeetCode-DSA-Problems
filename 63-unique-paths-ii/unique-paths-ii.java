class Solution {
    int[][] dp = new int[101][101];
    public int uniquePathsWithObstacles(int[][] mat) {
        for(int[] row:dp){
            Arrays.fill(row, -1);
        }
        return solve(mat, 0, 0);
    }
    private int solve(int[][] mat, int i, int j){
        if(i==mat.length-1 && j==mat[0].length){
            return 1;
        }
        if(i>=mat.length || j>=mat[0].length){
            return 0;
        }
        if(mat[i][j]==1) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int down = solve(mat, i+1, j);
        int right = solve(mat, i, j+1);
        return dp[i][j] = down+right;
    } 
}