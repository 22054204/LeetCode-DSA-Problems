class Solution {
    int n;
    List<Integer>[] adj;
    int[] tin, tout, depth;
    int[] eulerTour;
    int time;
    int[][] ancestorTable;
    int cols;
    int[] segmentTree;

    void dfs(int node, int parent, int d, String s) {
        depth[node] = d;
        ancestorTable[node][0] = parent;

        tin[node] = time;
        eulerTour[time++] = 1 << (s.charAt(node) - 'a');

        for (int child : adj[node]) {
            if (child == parent) continue;
            dfs(child, node, d + 1, s);
        }

        tout[node] = time;
        eulerTour[time++] = 1 << (s.charAt(node) - 'a');
    }

    void buildAncestorTable() {
        for (int j = 1; j < cols; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestorTable[node][j - 1] != -1) {
                    ancestorTable[node][j] =
                        ancestorTable[ancestorTable[node][j - 1]][j - 1];
                }
            }
        }
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int j = 0; j < cols; j++) {
            if ((diff & (1 << j)) != 0) {
                u = ancestorTable[u][j];
            }
        }

        if (u == v) return u;

        for (int j = cols - 1; j >= 0; j--) {
            if (ancestorTable[u][j] != ancestorTable[v][j]) {
                u = ancestorTable[u][j];
                v = ancestorTable[v][j];
            }
        }

        return ancestorTable[u][0];
    }

    void buildSegmentTree(int i, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;
        buildSegmentTree(2 * i + 1, l, mid, nums);
        buildSegmentTree(2 * i + 2, mid + 1, r, nums);
        segmentTree[i] = segmentTree[2 * i + 1] ^ segmentTree[2 * i + 2];
    }

    void updateSegTree(int index, int val, int i, int l, int r) {
        if (l == r) {
            segmentTree[i] = val;
            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            updateSegTree(index, val, 2 * i + 1, l, mid);
        } else {
            updateSegTree(index, val, 2 * i + 2, mid + 1, r);
        }

        segmentTree[i] = segmentTree[2 * i + 1] ^ segmentTree[2 * i + 2];
    }

    int querySegmentTree(int start, int end, int i, int l, int r) {
        if (l > end || r < start) return 0;

        if (l >= start && r <= end) return segmentTree[i];

        int mid = l + (r - l) / 2;

        return querySegmentTree(start, end, 2 * i + 1, l, mid)
            ^ querySegmentTree(start, end, 2 * i + 2, mid + 1, r);
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        eulerTour = new int[2 * n];
        time = 0;

        cols = (int) (Math.log(n) / Math.log(2)) + 1;
        ancestorTable = new int[n][cols];

        for (int[] row : ancestorTable) {
            Arrays.fill(row, -1);
        }

        dfs(0, -1, 0, s);
        buildAncestorTable();

        segmentTree = new int[8 * n];
        buildSegmentTree(0, 0, 2 * n - 1, eulerTour);

        List<Boolean> result = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);
                int charValue = 1 << (c - 'a');

                updateSegTree(tin[node], charValue, 0, 0, 2 * n - 1);
                updateSegTree(tout[node], charValue, 0, 0, 2 * n - 1);
                s = s.substring(0, node) + c + s.substring(node + 1);
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLCA(u, v);

                int mask = querySegmentTree(0, tin[u], 0, 0, 2 * n - 1)
                    ^ querySegmentTree(0, tin[v], 0, 0, 2 * n - 1)
                    ^ (1 << (s.charAt(lca) - 'a'));

                result.add((mask & (mask - 1)) == 0);
            }
        }

        return result;
    }
}