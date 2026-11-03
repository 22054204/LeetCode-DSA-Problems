class Solution {
    public int[][] updateMatrix(int[][] grid) {
         int m = grid.length;
        int n = grid[0].length;
        int[][] result = new int[m][n];
        for(int[]mat:result) Arrays.fill(mat, -1);
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    queue.offer(new int[]{i, j});
                    result[i][j] = 0;
                }
            }
        }
        int[][] distance = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] arr = queue.remove();
                int x = arr[0];
                int y = arr[1];
                for(int[] dist:distance){
                    int i=x+dist[0];
                    int j=y+dist[1];
                    if(i>=0 && j>=0 && i<m && j<n && result[i][j]==-1){
                        result[i][j] = result[x][y] + 1;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }
        return result;
    }
}