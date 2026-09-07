class Solution {
    int m=0;
    int n=0;
    int[][] dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        m=triangle.size(); 
        n=triangle.get(m-1).size(); //max size
        if(m==1) return triangle.get(0).get(0);
        dp = new int[m][n];
        for(int[] row:dp){
            Arrays.fill(row, 10001);
        }
        return solve(triangle, 0, 0);
    }
    public int solve(List<List<Integer>> triangle, int i, int j){
        if(i==m-1) return triangle.get(i).get(j);
        if(dp[i][j]!=10001) return dp[i][j];
        int down = triangle.get(i).get(j) + solve(triangle, i+1, j);
        int downAndRight = triangle.get(i).get(j) + solve(triangle, i+1, j+1);
        return dp[i][j] = Math.min(down, downAndRight);
    }
}