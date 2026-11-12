class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maximumStrictlyIncreasing = 1;
        int i=0;
        while(i<nums.length){
            int j=i;
            while(j<nums.length-1 && nums[j]<nums[j+1]){
                j++;
            }
            maximumStrictlyIncreasing = Math.max(maximumStrictlyIncreasing, j-i+1);
            i=j+1;
        }
        int maximumStrictlyDecreasing = 1;
        i=0;
        while(i<nums.length){
            int j=i;
            while(j<nums.length-1 && nums[j]>nums[j+1]){
                j++;
            }
            maximumStrictlyDecreasing = Math.max(maximumStrictlyDecreasing, j-i+1);
            i=j+1;
        }
        return Math.max(maximumStrictlyIncreasing, maximumStrictlyDecreasing);
    }
}