class Solution {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i] = i;
        }
        for(int i=0;i<equations.length;i++){
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(1);
            char c = equations[i].charAt(2);
            char d = equations[i].charAt(3);
            if(b=='='){
                union(a-'a', d-'a');
            }
        }
        for(int i=0;i<equations.length;i++){
            char a = equations[i].charAt(0);
            char b = equations[i].charAt(1);
            char c = equations[i].charAt(2);
            char d = equations[i].charAt(3);
            if(b=='!'){
                int parent_a = find(a-'a');
                int parent_d = find(d-'a');
                if(parent_a==parent_d){
                    return false;
                }
            }
        }
        return true;
        
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