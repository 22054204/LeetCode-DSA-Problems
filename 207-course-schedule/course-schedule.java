class Solution {
    boolean[] visited;
    boolean[] inRecursion;
    public boolean canFinish(int V, int[][] edges) {
        visited = new boolean[V];
        inRecursion = new boolean[V];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            //graph.get(v).add(u);
        }

        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(solve(graph, i)) return false;
            }
        }
        return true;
    }
    public boolean solve(Map<Integer, List<Integer>> graph, int u){
        visited[u] = true;
        inRecursion[u] = true;
        for(int v : graph.get(u)){
            if(visited[v] && inRecursion[v]) return true;
            if(!visited[v]){
                if(solve(graph, v)) return true;
            }
        }
        inRecursion[u] = false;
        return false;
    }
}