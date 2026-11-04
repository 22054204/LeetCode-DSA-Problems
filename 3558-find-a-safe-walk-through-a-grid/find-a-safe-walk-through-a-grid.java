class Solution {
    int[][] bestHealth;
    int m, n;
    int[][] directions = {{ 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        m = grid.size();
        n = grid.get(0).size();

        bestHealth = new int[m][n];
        for (int[] row : bestHealth) {
            Arrays.fill(row, -1);
        }

        return solve(grid, 0, 0, health);
    }

    public boolean solve(List<List<Integer>> grid, int i, int j, int health) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }
        if (grid.get(i).get(j) == 1) {
            health--;
        }
        if (health <= 0) {
            return false;
        }
        if (health <= bestHealth[i][j]) {
            return false;
        }

        bestHealth[i][j] = health;

        if (i == m - 1 && j == n - 1) {
            return true;
        }

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (solve(grid, ni, nj, health)) {
                return true;
            }
        }
        return false;
    }
}
