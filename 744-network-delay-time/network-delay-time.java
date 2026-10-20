class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];
            graph.get(u).add(new int[]{v, w}); // directed
        }
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Arrays::compare);
        distance[k] = 0;
        pq.offer(new int[]{0, k});
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int d = arr[0];
            int u = arr[1];
            for(int[] edge:graph.get(u)){
                int v = edge[0];
                int dd = edge[1];
                if(d>distance[u]){
                    continue;
                }
                if(distance[v]>d+dd){
                    distance[v] = d+dd;
                    pq.offer(new int[]{distance[v], v});
                }
            }
        }
        //System.out.println(Arrays.toString(distance));
        int ans = 0;
        for(int i=1;i<=n;i++){
            ans = Math.max(ans, distance[i]);
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}