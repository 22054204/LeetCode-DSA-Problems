class Solution {
    boolean[] visited;
    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length) return -1;
        visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] rows:connections){
            int u = rows[0];
            int v = rows[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int count = n;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                solve(graph, i);
                count--;
            }
        }
        return n-count-1;
    }
    public void solve(Map<Integer, List<Integer>> graph, int u){
        visited[u] = true;
        for(int v:graph.get(u)){
            if(visited[v]) continue;
            if(!visited[v]) solve(graph, v);
        }
    }
}