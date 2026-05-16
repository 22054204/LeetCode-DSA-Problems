class Solution {
    public int findMin(int[] nums) {
        return LinearSearch(nums);
    }
    private int LinearSearch(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            min = Math.min(min, nums[i]);
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
    private int Sorting(int[] nums){
        Arrays.sort(nums);
        return nums[0];
    }
}