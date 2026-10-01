class Solution {
    boolean[] visited;
    Queue<Integer> queue = new LinkedList<>();
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        visited = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                solve(isConnected, i);
            }
        }
        return count;
    }
    public void solve(int[][] graph, int k){
        visited[k] = true;
        queue.offer(k);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v=0;v<graph.length;v++){
                if(graph[u][v]==1 && !visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
}