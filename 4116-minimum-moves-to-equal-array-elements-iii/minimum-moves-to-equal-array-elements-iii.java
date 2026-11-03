class Solution {
    public int minMoves(int[] nums) {
        int max = nums[0];
        for(int num:nums) max=Math.max(max, num);
        int res = 0;
        for(int num:nums) res+=max-num;
        return res;
    }
}