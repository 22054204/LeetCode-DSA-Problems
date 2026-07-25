class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total_time = 0;
        for(int i=0;i<timeSeries.length-1;i++){
            if(timeSeries[i+1]>=timeSeries[i]+duration) total_time+=duration;
            else total_time+=timeSeries[i+1]-timeSeries[i];
        }
        total_time+=duration;
        return total_time;
    }
}