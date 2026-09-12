class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(row -> row[0]));
        int m = intervals.length;
        int st = intervals[0][0];
        int end = intervals[0][1];
        for(int i=1;i<m;i++){
            int st2 = intervals[i][0];
            int end2 = intervals[i][1];
            if(end>=st2){
                end = Math.max(end, end2);
            }else{
                list.add(Arrays.asList(st, end));
                st = st2;
                end = end2;
            }
        }
        list.add(Arrays.asList(st, end));

        int[][] ans = new int[list.size()][2];
        for(int i=0;i<ans.length;i++){
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}