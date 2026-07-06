class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0])
                return Integer.compare(b[1], a[1]);
            return Integer.compare(a[0], b[0]);
        });

        boolean[] removed = new boolean[intervals.length];
        int count = intervals.length;
        for(int i=0;i<intervals.length-1;i++){
            int a = intervals[i][0];
            int b = intervals[i][1];
            for(int j=i+1;j<intervals.length;j++){
                int c = intervals[j][0];
                int d = intervals[j][1];
                if(a<=c && b>=d && !removed[j]){
                    removed[j] = true;
                    count--;
                }
            }
        }
        return count;
    }
}