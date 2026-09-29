class Solution {
    Boolean[][][] dp;
    int m, n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if((m + n - 1) % 2 != 0) return false;

        dp = new Boolean[m][n][m + n];

        return solve(0, 0, 0, grid);
    }

    public boolean solve(int i, int j, int balance, char[][] grid) {
        if(grid[i][j] == '(') balance++;
        else balance--;

        if(balance < 0) return false;

        int remaining = (m - 1 - i) + (n - 1 - j);
        if(balance > remaining) return false;

        if(i == m - 1 && j == n - 1) {
            return balance == 0;
        }

        if(dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        boolean down = false;
        boolean right = false;

        if(i + 1 < m) {
            down = solve(i + 1, j, balance, grid);
        }

        if(j + 1 < n) {
            right = solve(i, j + 1, balance, grid);
        }

        return dp[i][j][balance] = down || right;
    }
}