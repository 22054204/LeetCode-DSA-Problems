class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] nums) {
        Arrays.sort(nums); //[1,100,1000]
        if(nums[0]!=1) nums[0] = 1;

        for(int i=1;i<nums.length;i++){
            if(Math.abs(nums[i]-nums[i-1]) <= 1){
                continue;
            }else{
                nums[i] = nums[i-1]+1;
            }
        }
        return nums[nums.length-1];
    }
}