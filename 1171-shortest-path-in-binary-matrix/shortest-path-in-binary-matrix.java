class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] direction = {{0,1}, {1,0}, {1,1}, {0,-1}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}};
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m-1][n-1] == 1) return -1;

        int[][] distance1 = new int[m][n];
        for(int[] mat:distance1){
            Arrays.fill(mat, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Arrays::compare);
        distance1[0][0] = 0;
        pq.offer(new int[]{0, 0, 0}); // [distance, x_coordinate, y_coordinate]

        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int distance2 = arr[0];
            int x_coordinate = arr[1];
            int y_coordinate = arr[2];
            if(distance2 > distance1[x_coordinate][y_coordinate]) continue;
            if (x_coordinate == m - 1 && y_coordinate == n - 1) return distance2+1;
            for(int[] dir:direction){
                int x = dir[0]+x_coordinate;
                int y = dir[1]+y_coordinate;
                if(isSafe(grid, x, y, m) && distance1[x][y]>distance2+1){
                    distance1[x][y] = distance2+1;
                    pq.offer(new int[]{distance1[x][y], x, y});
                    grid[x][y] = 1;
                }
            }
        }
        return -1;
    }
    public boolean isSafe(int[][] grid, int a, int b, int n){
        return a>=0 && b>=0 && a<n && b<n && grid[a][b]==0;
    }
}