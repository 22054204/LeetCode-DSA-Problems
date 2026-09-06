class Solution {
    int[] dp1 = new int[101];
    int[] dp2 = new int[101];
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(solve1(nums, 0), solve2(nums, 1));
    }
    public int solve1(int[] nums, int i){
        if(i>=nums.length-1){
            return 0;
        }

        if(dp1[i]!=-1) return dp1[i];
        int take = nums[i]+solve1(nums, i+2);
        int skip = solve1(nums, i+1);
        return dp1[i] = Math.max(take, skip);
    }
    public int solve2(int[] nums, int i){
        if(i>=nums.length){
            return 0;
        }

        if(dp2[i]!=-1) return dp2[i];
        int take = nums[i]+solve2(nums, i+2);
        int skip = solve2(nums, i+1);
        return dp2[i] = Math.max(take, skip);
    }
}