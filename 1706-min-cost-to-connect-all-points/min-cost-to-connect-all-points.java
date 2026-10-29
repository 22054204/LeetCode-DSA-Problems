class Solution {
    static int[] parent;
    static int[] rank;
    
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);  // path compression
    }

    public static void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if (x_parent != y_parent) {
            if (rank[x_parent] < rank[y_parent]) {
                parent[x_parent] = y_parent;
            } else if (rank[x_parent] > rank[y_parent]) {
                parent[y_parent] = x_parent;
            } else {
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        parent = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }
        rank = new int[V];

        List<int[]> edges = new ArrayList<>();

        int k = 0;
        for (int i=0;i<V;i++){
            for (int j=i+1;j<V;j++){
                int u = i;
                int v = j;
                int w = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);

                edges.add(new int[]{u, v, w});
            }
        }

        Collections.sort(edges, (a, b)->Integer.compare(a[2], b[2]));
        return kruskal(edges);
    }
    public int kruskal(List<int[]> edges){
        int sum = 0;
        
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            int parent_u = find(u);
            int parent_v = find(v);
            
            if(parent_u!=parent_v){
                sum+=w;
                union(u, v);
            }
        }
        return sum;
    }
}