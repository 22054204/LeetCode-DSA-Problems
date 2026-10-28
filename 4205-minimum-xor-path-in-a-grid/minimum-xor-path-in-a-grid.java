class Solution {
    int m = 0;
    int n = 0;
    int[][][] dp;

    public int minCost(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][1024];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(grid, 0, 0, 0);
    }

    private int solve(int[][] grid, int i, int j, int xor) {
        xor ^= grid[i][j];

        if (i == m - 1 && j == n - 1) {
            return xor;
        }

        if (dp[i][j][xor] != -1) {
            return dp[i][j][xor];
        }

        int right = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;

        if (j + 1 < n) {
            right = solve(grid, i, j + 1, xor);
        }

        if (i + 1 < m) {
            down = solve(grid, i + 1, j, xor);
        }

        return dp[i][j][xor] = Math.min(right, down);
    }
}