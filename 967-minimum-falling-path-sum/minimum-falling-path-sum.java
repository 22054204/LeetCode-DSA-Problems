class Solution {
    int n = 0;
    int[][] dp;
    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;

        dp = new int[n][n];
        for(int[] row:dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int ans = Integer.MAX_VALUE;
        for(int col=0; col<n; col++){
            ans = Math.min(ans, solve(matrix, 0, col));
        }
        return ans;
    }
    public int solve(int[][] matrix, int row, int col){
        if(row==n-1) return matrix[row][col];

        if(dp[row][col]!=Integer.MAX_VALUE) return dp[row][col];
        
        int a = Integer.MAX_VALUE;
        if(col!=0){
            a = matrix[row][col] + solve(matrix, row+1, col-1);
        }

        int b = Integer.MAX_VALUE;
        b = matrix[row][col] + solve(matrix, row+1, col);

        int c = Integer.MAX_VALUE;
        if(col != n-1){
            c = matrix[row][col] + solve(matrix, row+1, col+1);
        }
        return dp[row][col] = Math.min(a, Math.min(b, c));
    }
}