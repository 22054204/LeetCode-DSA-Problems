class Solution {
    int m = 0;
    int n = 0;
    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && solve(grid, i, j)%k==0){
                    count++;
                }
            }
        }
        return count;
    }
    public long solve(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0) return 0;

        long sum = grid[i][j];
        grid[i][j] = 0; 

        sum += solve(grid, i, j-1);
        sum += solve(grid, i, j+1);
        sum += solve(grid, i-1, j);
        sum += solve(grid, i+1, j);

        return sum;
    }
}