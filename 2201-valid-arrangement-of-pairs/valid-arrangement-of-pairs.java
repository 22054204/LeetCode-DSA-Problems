class Solution {
    List<Integer> path = new ArrayList<>();
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, Integer> outdegree = new HashMap<>();
        for(int[] edge:pairs){
            int u = edge[0];
            int v = edge[1];

            if(!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }

            graph.get(u).add(v);
            outdegree.put(u, outdegree.getOrDefault(u, 0) + 1);
            indegree.put(v, indegree.getOrDefault(v, 0) + 1);
        }

        int sourceNode = pairs[0][0];
        for(int node:outdegree.keySet()){
            int out = outdegree.getOrDefault(node, 0);
            int in = indegree.getOrDefault(node, 0);
            if(out-in == 1){
                sourceNode = node;
                break;
            }
        }
        DFS(graph, sourceNode);

        Collections.reverse(path);

        int[][] ans = new int[pairs.length][2];
        for(int i = 0; i < pairs.length; i++) {
            ans[i][0] = path.get(i);
            ans[i][1] = path.get(i + 1);
        }
        return ans;
    }
    
    public void DFS(Map<Integer, List<Integer>> graph, int u) {
        List<Integer> neighbours = graph.get(u);
        while(neighbours != null && !neighbours.isEmpty()) {
            int v = neighbours.remove(neighbours.size() - 1);
            DFS(graph, v);
        }
        path.add(u);
    }
}