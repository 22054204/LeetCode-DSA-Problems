class Solution {
    public int findMin(int[] nums) {
        return BS1(nums);
    }
    private int BS1(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int mid = start + (end - start)/2;
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return nums[start];
    }
    private int BS2(int[] nums) {
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(nums[mid]<min){
                min = nums[mid];
            }else if(nums[mid] >= nums[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return min;
    }
    private static int LinearSearch(int[] nums){
       int min = Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
        min = Math.min(min, nums[i]);
       } 
       if(min == Integer.MAX_VALUE) return -1;
       return min;
    }
    private static int Sorting(int[] nums){
        Arrays.sort(nums);
        return nums[0];
    }
}