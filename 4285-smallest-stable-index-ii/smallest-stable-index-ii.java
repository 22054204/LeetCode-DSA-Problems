class Solution {
    public int firstStableIndex(int[] nums, int k) {
        return Optimal(nums, k);
    }
    public int Optimal(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];
        for(int i=1; i<n; i++) {
            max[i] = Math.max(nums[i], max[i-1]);
        }
        int[] min = new int[n];
        min[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--) {
            min[i] = Math.min(nums[i], min[i+1]);
        }
        for(int i=0; i<n; i++) {
            if(max[i] - min[i] <= k) {
                return i;
            }
        }
        return -1;
    }
    public int BruteForce(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            int min = minimum(nums, i);
            int max = maximum(nums, i);
            int result = max-min;
            if(result<=k) return i;
        }
        return -1;
    }
    public static int minimum(int[] nums, int start){
        int min = Integer.MAX_VALUE;
        for(int i=start;i<nums.length;i++){
            min = Math.min(min, nums[i]);
        }
        return min;
    }
    public static int maximum(int[] nums, int end){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=end;i++){
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}