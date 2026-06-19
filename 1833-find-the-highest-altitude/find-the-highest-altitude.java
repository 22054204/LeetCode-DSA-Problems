class Solution {
    public int largestAltitude(int[] gain) {
        int stAlt = 0;
        int maxAlt = 0;
        for(int i=0;i<gain.length;i++){
            stAlt += gain[i];
            maxAlt = Math.max(maxAlt, stAlt);
        }
        return maxAlt;
    }
}