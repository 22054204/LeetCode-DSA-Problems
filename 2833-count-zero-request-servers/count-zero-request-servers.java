class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int[] ans = new int[queries.length];

        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[][] querie = new int[queries.length][2];
        for(int i=0;i<queries.length;i++){
            querie[i][0] = queries[i];
            querie[i][1] = i;
        }
        Arrays.sort(querie, (a, b) -> Integer.compare(a[0], b[0]));

        HashMap<Integer, Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        for(int[] que:querie){
            //range
            int st = que[0]-x;
            int end = que[0];
            int idx = que[1];
            //expansion 
            while(j<logs.length && logs[j][1]<=end){
                map.put(logs[j][0], map.getOrDefault(logs[j][0], 0)+1);
                j++;
            }
            //shirinking
            while(i<j && logs[i][1]<st){
                map.put(logs[i][0], map.get(logs[i][0])-1);
                if(map.get(logs[i][0])==0){
                    map.remove(logs[i][0]);
                }
                i++;
            }
            ans[idx] = n-map.size();
        }
        return ans;
    }
}