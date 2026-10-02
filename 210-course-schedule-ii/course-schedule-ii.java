class Solution {
    ArrayList<Integer> result = new ArrayList<>();
    boolean[] visited;
    boolean[] inRecursion;
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int V, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0;i<V;i++){
            graph.put(i, new ArrayList<>());
        }
        visited = new boolean[V];
        inRecursion = new boolean[V];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][1];
            int v = edges[i][0];
            graph.get(u).add(v);
        }
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(!solve(graph, i)) return new int[]{};
            }
        }
        while(!stack.isEmpty()){
            result.add(stack.pop());
        }
        int[] res = new int[result.size()];
        for(int i=0;i<res.length;i++){
            res[i] = result.get(i);
        }
        return res;
    }
    public boolean solve(Map<Integer, List<Integer>> graph, int u){
        visited[u] = true;
        inRecursion[u] = true;
        for(int v:graph.get(u)){
            if(inRecursion[v]) return false;
            if(!visited[v]){
                if(!solve(graph, v)) return false;
            }
        }
        inRecursion[u] = false;
        stack.push(u);
        return true;
    }
}