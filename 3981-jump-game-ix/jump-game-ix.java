class Solution {
    public int[] maxValue(int[] nums) { //[2,1,3]
        int n = nums.length;
        int[] pre = new int[n]; //[2,2,3]
        pre[0] = nums[0];
        for(int i=1;i<n;i++){
            pre[i] = Math.max(pre[i-1], nums[i]);
        }
        int[] suf = new int[n]; //[1,1,3];
        suf[n-1] = nums[n-1];
        for(int i=n-1-1;i>=0;i--){
            suf[i] = Math.min(suf[i+1], nums[i]);
        }
        int[] res = new int[n];
        res[n - 1] = pre[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if (pre[i]>suf[i + 1]) {
                res[i] = res[i + 1];
            }
            else {
                res[i] = pre[i];
            }
        }
        return res;
    }
}