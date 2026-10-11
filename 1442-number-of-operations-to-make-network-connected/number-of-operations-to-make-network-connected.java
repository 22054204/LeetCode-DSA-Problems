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