class Solution {
    public int firstStableIndex(int[] nums, int k) {
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