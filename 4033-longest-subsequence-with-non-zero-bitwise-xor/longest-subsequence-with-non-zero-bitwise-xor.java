class Solution {
    public int longestSubsequence(int[] nums) {
        if(nums.length==1) return (nums[0]==0)?0:1;
        int i=0;
        while(i<nums.length){
            if(nums[i]!=0) break;
            else i++;
        }
        if(i==nums.length) return 0;
        if(nums.length-i==1) return nums.length;
        int zor = nums[i]^nums[i+1];
        if(nums.length==2 && zor!=0) return 2;
        if(nums.length==2 && zor==0) return 1;
        i+=2; 
        while(i<nums.length){
            zor^=nums[i++];
        }
        return (zor==0) ? nums.length-1:nums.length;
    }
}