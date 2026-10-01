class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();
        int n = isConnected.length;
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(i, new ArrayList<>());
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    graph.get(i).add(j);
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                solve(graph, i);
            }
        }
        return count;
    }
    public void solve(List<List<Integer>> graph, int u){
        visited[u] = true;
        for(int v:graph.get(u)){
            if(!visited[v]) solve(graph, v);
        }
    }
}