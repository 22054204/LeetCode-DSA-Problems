// DSU
class Solution {
    int[] parent;
    int[] rank;
    public int makeConnected(int n, int[][] connections) {
        if(n-1>connections.length) return -1;
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        int count = n;
        for(int i=0;i<connections.length;i++){
            int u = connections[i][0];
            int v = connections[i][1];

            int u_parent = find(u);
            int v_parent = find(v);
            if(u_parent!=v_parent){
                union(u, v);
                count--;
            }
        }
        return count-1;
    }
    public int find(int x) {
        return parent[x]==x?x:(parent[x]=find(parent[x]));
    }
    public void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent==y_parent) return;
        else{
            if(rank[x_parent]>rank[y_parent]){
                parent[y_parent] = x_parent;
            }else if(rank[x_parent]<rank[y_parent]){
                parent[x_parent] = y_parent;
            }else if(rank[x_parent]==rank[y_parent]){
                parent[y_parent] = x_parent;
                rank[x_parent]++;
            }
        }
    }
}

/*
// DFS
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
*/

/*
// BFS
class Solution {
    boolean[] visited;
    Queue<Integer> queue = new LinkedList<>();
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
    public void solve(Map<Integer, List<Integer>> graph, int k){
        visited[k] = true;
        queue.offer(k);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v:graph.get(u)){
                if(!visited[v]){
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
}
*/