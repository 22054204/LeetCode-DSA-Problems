class Solution {
    Boolean[][][] dp;
    int m = 0;
    int n = 0;
    // possible ways to move - left, right, up and dowm;
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();
        dp = new Boolean[m][n][health+1]; 
        return solve(grid, 0, 0, health);
    }
    public boolean solve(List<List<Integer>> grid, int i, int j, int health){
        if(i<0 || j<0 || i>=m || j>=n || health<=0) return false;
        if(grid.get(i).get(j) == -1) return false;
        if(grid.get(i).get(j) == 1) health--;
        if(health <= 0) return false;
        if(i==m-1 && j==n-1 && health>0) return true;

        if(dp[i][j][health] != null) return dp[i][j][health];

        int curr = grid.get(i).get(j);
        grid.get(i).set(j, -1);

        for(int[] dir:directions){
            int new_i = i+dir[0];
            int new_j = j+dir[1];
            if(solve(grid, new_i, new_j, health)){
                grid.get(i).set(j, curr);
                return dp[i][j][health] = true;
            }
        }
        grid.get(i).set(j, curr);
        return dp[i][j][health] = false;
    }
}