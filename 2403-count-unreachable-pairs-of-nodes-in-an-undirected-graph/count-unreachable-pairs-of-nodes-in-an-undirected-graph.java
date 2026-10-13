class Solution {
    int[] parent;
    int[] rank;
    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            union(u, v);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int parent = find(i);
            map.put(parent, map.getOrDefault(parent, 0)+1);
        }
        long ans = 0;
        long remaining = n;
        for(Integer size:map.values()){
            remaining -= size;
            ans += size * remaining;
        }
        return ans;
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