class Solution {
    int[][] dijkstr;

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        int minRes = dijkstra(n, edges, 0, labels, k);
        return minRes;
    }

    public int dijkstra(int V, int[][] edges, int src, String labels, int k) {
        dijkstr = new int[V][k + 1];
        for (int[] arr : dijkstr) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }

        HashMap<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < V; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph.get(u).add(new int[] { v, w });
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        dijkstr[src][1] = 0;
        minHeap.offer(new int[] { src, 1, 0 }); // {node, count, dist}

        while (!minHeap.isEmpty()) {
            int[] arr = minHeap.poll();

            int u = arr[0]; // node
            int count = arr[1]; // consecutive character count
            int d = arr[2]; // distance

            if (d > dijkstr[u][count])
                continue;

            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int w = edge[1];

                int newCount;

                if (labels.charAt(u) == labels.charAt(v)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k)
                    continue;

                if (d + w < dijkstr[v][newCount]) {
                    dijkstr[v][newCount] = d + w;
                    minHeap.offer(new int[] { v, newCount, dijkstr[v][newCount] });
                }
            }
        }
        int minRes = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            minRes = Math.min(minRes, dijkstr[V - 1][i]);
        }

        return minRes == Integer.MAX_VALUE ? -1 : minRes;
    }
}