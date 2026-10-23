class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] direction = {{0,-1}, {0,1}, {-1,0}, {1,0}}; //left, right, up, down
        int m = heights.length;
        int n = heights[0].length;
        int[][] distance = new int[m][n];
        for(int[] mat:distance) Arrays.fill(mat, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        distance[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int val = arr[0];
            int x_ = arr[1];
            int y_ = arr[2];

            if (val > distance[x_][y_]) continue;
            if (x_ == m - 1 && y_ == n - 1) return val;

            for(int[] dir:direction){
                int x = x_ + dir[0];
                int y = y_ + dir[1];
                if(isSafe(heights, x, y, m, n)){
                    int effort = Math.max(val, Math.abs(heights[x_][y_] - heights[x][y]));
                    if (effort < distance[x][y]) {
                        distance[x][y] = effort;
                        pq.offer(new int[]{effort, x, y});
                    }
                }
            }
        }
        return 0;
    }
    public boolean isSafe(int[][] heights, int i, int j, int m, int n){
        return i>=0&&j>=0&&i<m&&j<n;
    }
}