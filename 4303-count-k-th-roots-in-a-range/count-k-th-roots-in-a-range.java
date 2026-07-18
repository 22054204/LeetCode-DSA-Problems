class Solution {
    public int countKthRoots(int l, int r, int k) {
        if (k == 1) return r-l+1;
        int count = 0;
        for(int i=0;i<=r;i++){
            long num = (long)Math.pow(i, k);
            if(num>r) break;
            if(num>=l && num<=r) count++;
        }
        return count;
    }
}