class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && solve(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    int count = 0;

    public boolean solve(int[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length)
            return false;

        if (grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean left = solve(grid, i, j - 1);
        boolean right = solve(grid, i, j + 1);
        boolean up = solve(grid, i - 1, j);
        boolean down = solve(grid, i + 1, j);

        return left && right && up && down;
    }
}