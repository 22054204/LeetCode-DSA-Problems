
import java.util.*;

class Solution {
    int[] bit;
    int n;

    void upd(int i, int v) {
        for (i++; i <= n; i += i & -i) bit[i] ^= v;
    }

    int qry(int i) {
        int r = 0;
        for (i++; i > 0; i -= i & -i) r ^= bit[i];
        return r;
    }

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;
        int[] hd = new int[n];
        Arrays.fill(hd, -1);
        int[] nx = new int[2 * (n - 1) + 1];
        int[] to = new int[2 * (n - 1) + 1];
        int ec = 0;

        for (int[] e : edges) {
            to[ec] = e[1];
            nx[ec] = hd[e[0]];
            hd[e[0]] = ec++;
            to[ec] = e[0];
            nx[ec] = hd[e[1]];
            hd[e[1]] = ec++;
        }

        int[] order = new int[n], parent = new int[n], depth = new int[n];
        int qh = 0, qt = 0;
        order[qt++] = 0;
        parent[0] = -1;

        while (qh < qt) {
            int u = order[qh++];
            for (int e = hd[u]; e != -1; e = nx[e]) {
                int v = to[e];
                if (v != parent[u]) {
                    parent[v] = u;
                    depth[v] = depth[u] + 1;
                    order[qt++] = v;
                }
            }
        }

        int[] sz = new int[n], heavy = new int[n];
        Arrays.fill(sz, 1);
        Arrays.fill(heavy, -1);

        for (int i = n - 1; i >= 1; i--) {
            int x = order[i], p = parent[x];
            sz[p] += sz[x];
        }

        for (int i = n - 1; i >= 1; i--) {
            int x = order[i], p = parent[x];
            if (heavy[p] == -1 || sz[x] > sz[heavy[p]]) heavy[p] = x;
        }

        int[] mask = new int[n], base = new int[n];
        int[] tin = new int[n], nextPos = new int[n], chead = new int[n];

        for (int i = 0; i < n; i++) mask[i] = 1 << (s.charAt(i) - 'a');

        base[0] = mask[0];
        tin[0] = 0;
        nextPos[0] = 1;
        chead[0] = 0;

        for (int i = 1; i < n; i++) {
            int x = order[i], p = parent[x];
            base[x] = base[p] ^ mask[x];
            tin[x] = nextPos[p];
            nextPos[p] += sz[x];
            nextPos[x] = tin[x] + 1;
            chead[x] = heavy[p] == x ? chead[p] : x;
        }

        bit = new int[n + 1];
        List<Boolean> ans = new ArrayList<>(queries.length);

        for (String q : queries) {
            boolean isUpdate = q.charAt(0) == 'u';
            int pos = isUpdate ? 7 : 6;
            int u = 0;

            while (q.charAt(pos) != ' ') {
                u = u * 10 + q.charAt(pos) - '0';
                pos++;
            }

            pos++;

            if (isUpdate) {
                int nm = 1 << (q.charAt(pos) - 'a');
                int delta = mask[u] ^ nm;

                if (delta != 0) {
                    mask[u] = nm;
                    upd(tin[u], delta);
                    int end = tin[u] + sz[u];
                    if (end < n) upd(end, delta);
                }
            } else {
                int v = 0;

                while (pos < q.length()) {
                    v = v * 10 + q.charAt(pos) - '0';
                    pos++;
                }

                int a = u, b = v;

                while (chead[a] != chead[b]) {
                    if (depth[chead[a]] > depth[chead[b]]) a = parent[chead[a]];
                    else b = parent[chead[b]];
                }

                int l = depth[a] < depth[b] ? a : b;
                int res = base[u] ^ qry(tin[u]) ^ base[v] ^ qry(tin[v]) ^ mask[l];
                ans.add((res & (res - 1)) == 0);
            }
        }

        return ans;
    }
}
