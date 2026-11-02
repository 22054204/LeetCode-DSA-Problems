class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = solve(edges1);
        int d2 = solve(edges2);

        int mergedDiameter = (d1 + 1) / 2 + (d2 + 1) / 2 + 1;

        return Math.max(Math.max(d1, d2), mergedDiameter);
    }

    int V = 0;
    int farthestNode = 0;
    int maxDist = -1;
    boolean[] visited;

    public int solve(int[][] edges){
        V = edges.length+1;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        maxDist = -1;
        visited = new boolean[V];
        DFS(graph, 0, 0);

        int start = farthestNode;
        visited = new boolean[V];
        maxDist = -1;
        DFS(graph, start, 0);

        return maxDist;
    }
    public void DFS(HashMap<Integer, List<Integer>> graph, int u, int count){
        visited[u] = true;

        if(count>maxDist){
            maxDist = count;
            farthestNode = u;
        }

        for(int v:graph.get(u)){
            if(!visited[v]){
                DFS(graph, v, count+1);
            }
        }
    }
}