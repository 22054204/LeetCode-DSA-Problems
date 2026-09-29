class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = -1, startCol = -1;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) Arrays.fill(row, -1);

        int litterCount = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = classroom[i].charAt(j);
                if (ch == 'S') {
                    startRow = i;
                    startCol = j;
                } else if (ch == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }

        if (litterCount == 0) return 0;

        int[] weight = new int[litterCount];
        weight[0] = 1;
        for (int i = 1; i < litterCount; i++) {
            weight[i] = weight[i - 1] * 2;
        }

        int totalSubsets = weight[litterCount - 1] * 2;
        int allCollected = totalSubsets - 1;

        boolean[][][][] visited = new boolean[m][n][energy + 1][totalSubsets];
        visited[startRow][startCol][energy][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol, energy, 0});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            moves++;

            while (size-- > 0) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1], e = curr[2], collected = curr[3];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;

                    char cell = classroom[nr].charAt(nc);
                    if (cell == 'X' || e < 1) continue;

                    int newEnergy = e - 1;
                    int newCollected = collected;

                    if (cell == 'R') newEnergy = energy;

                    if (cell == 'L') {
                        int id = litterId[nr][nc];
                        if ((collected / weight[id]) % 2 == 0) {
                            newCollected = collected + weight[id];
                        }
                    }

                    if (newCollected == allCollected) return moves;
                    if (newEnergy == 0) continue;

                    if (!visited[nr][nc][newEnergy][newCollected]) {
                        visited[nr][nc][newEnergy][newCollected] = true;
                        queue.offer(new int[]{nr, nc, newEnergy, newCollected});
                    }
                }
            }
        }

        return -1;
    }
}