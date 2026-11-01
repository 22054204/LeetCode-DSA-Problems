class Solution {
    public int minMoves(int[] nums) {
       int min = nums[0];
       for(int num:nums) min = Math.min(min, num);
       int res = 0;
       for(int num:nums) res+=num-min;
       return res; 
    }
}