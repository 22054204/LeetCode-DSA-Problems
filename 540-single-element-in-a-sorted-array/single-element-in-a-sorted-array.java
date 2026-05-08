class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int i=0;
        int j=i+1;
        while(j<nums.length){
            if(nums[i]==nums[j]){
                i=i+2;
                j=j+2;
            }else{
                break;
            }
        }
        return nums[i];
    }
}