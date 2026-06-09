class Solution {
    public long maxTotalValue(int[] nums, int k) {
        return Optimal(nums, k);
    }
    public long Optimal(int[] nums, int k) {
        long max = nums[0];
        long min = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return (max-min)*k;
    }
    public long BruteForce(int[] nums, int k) {
        long ans = 0;
        long max = max(nums);
        long min = min(nums);
        while(k!=0){
            ans += max-min;
            k--;
        }
        return ans;
    }
    private static long max(int[] nums){
        long max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i], max);
        }
        if(max == Integer.MIN_VALUE) return -1;
        return max;
    }
    private static long min(int[] nums){
        long min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(nums[i], min);
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}