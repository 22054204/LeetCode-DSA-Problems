class Solution {
    int[][] directions = {{ 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 }};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder(Arrays::compare));
        boolean[][] visited = new boolean[m][n];

        health -= grid.get(0).get(0);
        if(health <= 0) return false;
        pq.offer(new int[]{health, 0, 0});

        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int h = arr[0];
            int i = arr[1];
            int j = arr[2];

            if(visited[i][j]) continue;
            visited[i][j] = true;

            if(i==m-1&&j==n-1&&h>0) return true;

            for(int[] dir:directions){
                int new_i = i+dir[0];
                int new_j = j+dir[1]; 

                if(new_i < 0 || new_j < 0 || new_i >= m || new_j >= n) continue;

                int new_h = h-grid.get(new_i).get(new_j);
                if(new_h<=0) continue;

                if(!visited[new_i][new_j]) pq.offer(new int[]{new_h, new_i, new_j});
            }
        }
        return false;
    }
}