class Solution {
    public int maximumProduct(int[] nums) {
        int max = -1001;
        int secMax = -1001;
        int thirdMax = -1001;
        int min = 1001;
        int secMin = 1001;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                thirdMax = secMax;
                secMax = max;
                max = nums[i];
            }else if(nums[i]>secMax){
                thirdMax = secMax;
                secMax = nums[i];
            }else if(nums[i]>thirdMax){
                thirdMax = nums[i];
            }
            if(nums[i]<min){
                secMin = min;
                min = nums[i];
            }else if(nums[i]<secMin){
                secMin = nums[i];
            }
        }
        return Math.max(max*secMax*thirdMax, min*secMin*max);
    }
}