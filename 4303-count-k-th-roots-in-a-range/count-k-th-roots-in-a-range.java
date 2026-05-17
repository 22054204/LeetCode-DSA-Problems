class Solution {
    public int countKthRoots(int l, int r, int k) {
        if (k == 1) {
            return r - l + 1;
        }
        int count = 0;
        for(long i=0;i<=r;i++){
            long power = (long)Math.pow(i, k);
            if(power>r) break;
            if(power>=l&&power<=r){
                count++;
            }
        }
        return count;
    }
}