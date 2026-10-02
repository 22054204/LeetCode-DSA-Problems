class Solution {
    int[] indegree;
    ArrayList<Integer> result = new ArrayList<>();
    Queue<Integer> queue = new LinkedList<>();
    public boolean canFinish(int V, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<V;i++){
            map.put(i, new ArrayList<>());
        }

        indegree = new int[V];

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            map.get(u).add(v);
            indegree[v]++;
        }

        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            solve(map);
        }
        return result.size()==V;
    }
    public void solve(HashMap<Integer, List<Integer>> graph){
        int u = queue.poll();
        result.add(u);
        for(int v:graph.get(u)){
            indegree[v]--;
            if(indegree[v]==0) queue.offer(v);
        }
    }
}