class Solution {
    ArrayList<ArrayList<Integer>> adj;
    int[] resultSize;
    int[] last;
    
    public void dfs(int currNode, String s, int[] parent) {

        int c = s.charAt(currNode) - 'a';
        int nearestAncestor = last[c];
        last[c] = currNode;

        for (int child : adj.get(currNode)) {
            dfs(child, s, parent);
        }

        //back to currNode
        last[c] = nearestAncestor;

        //if currNode is root, it has no ancestor
        if (currNode != 0) {
            int newParent = parent[currNode]; //old parent
            if (nearestAncestor != -1) {
                newParent = nearestAncestor;
            }
            parent[currNode] = newParent;
        }
    }

    public void dfsSize(int currNode) {
        resultSize[currNode] = 1;
        for (int child : adj.get(currNode)) {
            dfsSize(child);
            resultSize[currNode] += resultSize[child];
        }
    }

    public int[] findSubtreeSizes(int[] parent, String s) {

        int n = parent.length;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        //parent[i] = node
        //node is the parent of ith node
        //node ---> i

        for (int i = 1; i < n; i++) {
            int u = parent[i]; //u is the parent
            int v = i;

            adj.get(u).add(v); //u ---> v
        }

        resultSize = new int[n];

        last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, s, parent);

        //rebuild adjacency according to updated parent
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 1; i < n; i++) {
            int u = parent[i];
            int v = i;

            adj.get(u).add(v);
        }
        dfsSize(0);
        return resultSize;
    }
}