// BFS
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] direction = {{0,1}, {1,0}, {1,1}, {0,-1}, {-1,0}, {-1,-1}, {1,-1}, {-1,1}};
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        
        int length = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        length++;
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] arr = queue.poll();
                int r = arr[0]; //r -> row
                int c = arr[1]; //c -> col
                if(r==m-1 && c==n-1) return length;
                
                // Visit all 8 neighbouring cells
                for(int k=0;k<8;k++){
                    int nr = r + direction[k][0]; // nr -> new row
                    int nc = c + direction[k][1]; // nc -> new col

                    if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==0){
                        queue.offer(new int[]{nr, nc});
                        grid[nr][nc] = 1;
                    }
                }
            }
            length++;
        }
        return -1;
    }
}