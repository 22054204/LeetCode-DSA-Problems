class Solution {
    public int findMin(int[] nums) {
        return LinearSearch(nums);
    }
    private int BS(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid] > nums[end]){
                start = mid+1;
            }else if(nums[mid] > nums[start]){
                end = mid-1;
            }else{
                return nums[mid];
            }
        }
        return -1;
    }
    private static int LinearSearch(int[] nums){
       int min = Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
        min = Math.min(min, nums[i]);
       } 
       if(min == Integer.MAX_VALUE) return -1;
       return min;
    }
}