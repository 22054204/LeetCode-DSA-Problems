class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int freshOranges = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[]{i, j});
                }else if(grid[i][j]==1){
                    freshOranges++;
                }
            }
        }
        int minute = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        if(freshOranges==0) return 0; // means all are rotten already
        if(queue.isEmpty()) return -1; // means there is no rotten orange present in grid, so there is no way to rotten fresh oranges.
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] arr = queue.remove();
                int x = arr[0];
                int y = arr[1];
                for(int[]dir:directions){
                    int i = x+dir[0];
                    int j = y+dir[1];
                    if(i>=0 && j>=0 && i<m && j<n && !visited[i][j] && grid[i][j]==1){
                        visited[i][j] = true;
                        queue.offer(new int[]{i, j});
                        freshOranges--;
                    }
                }
            }
            minute++;
        }
        return freshOranges==0?minute-1:-1;
    }
}