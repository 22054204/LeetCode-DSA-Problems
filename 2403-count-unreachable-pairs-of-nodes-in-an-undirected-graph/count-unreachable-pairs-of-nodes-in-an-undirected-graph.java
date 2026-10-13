class Solution {
    Queue<Integer> queue = new LinkedList<>();
    long a = 1;
    List<Long> list = new ArrayList<>();
    boolean[] visited;
    long count = 0;
    public long countPairs(int n, int[][] edges) {
        visited = new boolean[n];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                solve(graph, i);
                list.add(a);
                a = 1;
            }
        }
        long ans = 0;
        long remaining = n;
        for(long size : list){
            remaining -= size;
            ans += size * remaining;
        }
        return ans;
    }
    public void solve(Map<Integer, List<Integer>> graph, int k){
        visited[k] = true;
        queue.offer(k);
        while(!queue.isEmpty()){
            int u = queue.poll();
            for(int v:graph.get(u)){
                if(!visited[v]){
                    a++;
                    visited[v] = true;
                    queue.offer(v);
                }
            }
        }
    }
}