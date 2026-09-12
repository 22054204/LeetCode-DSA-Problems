class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       Arrays.sort(intervals, (a, b) -> {
            for(int i = 0; i < a.length; i++) {
                if(a[i] != b[i]) return Integer.compare(a[i], b[i]);
            }
            return 0;
        });
       //System.out.println(Arrays.deepToString(intervals));

       int count = 0;
       int st1 = intervals[0][0];
       int end1 = intervals[0][1];
       for(int i=1;i<intervals.length;i++){
        int st2 = intervals[i][0];
        int end2 = intervals[i][1];
        if(end1>st2){
            count++;
            end1 = Math.min(end1, end2);
        }else{
            end1 = end2;
        }
       } 
       return count;
    }
}