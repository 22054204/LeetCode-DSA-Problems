class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxLight = 0;
        for(int num:lights){
            maxLight = Math.max(maxLight, num);
        }
        int r = Integer.MIN_VALUE;
        int waiting_time = 0;
        int max = 0;
        for(int num:arrivalTime){
            r = num%period;
            if(r<maxLight) waiting_time = 0;
            else waiting_time = period-r;

            max = Math.max(max, waiting_time);
        }
        return max;
    }
}