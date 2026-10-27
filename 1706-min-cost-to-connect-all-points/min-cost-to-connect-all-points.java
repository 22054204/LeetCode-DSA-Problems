class Solution {
    public int minCostConnectPoints(int[][] edges) {
        int V = edges.length;
        boolean[] visited = new boolean[V];
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }
        int node = 0;
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                int u = i; 
                int v = j;
                int w = Math.abs(edges[u][0] - edges[v][0]) + Math.abs(edges[u][1] - edges[v][1]);

                graph.get(u).add(new int[]{v, w});
                graph.get(v).add(new int[]{u, w});
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Arrays::compare);
        pq.offer(new int[]{0, 0});
        int sum = 0;
        while(!pq.isEmpty()){
            int[] arr = pq.remove();
            int w = arr[0];
            int u = arr[1];
            if(visited[u]) continue;
            visited[u] = true;
            sum+=w;
            for(int[]edge:graph.get(u)){
                int v_ = edge[0];
                int w_ = edge[1];
                if(visited[v_]) continue;
                pq.offer(new int[]{w_, v_});
            }
        }
        return sum;
    }
}