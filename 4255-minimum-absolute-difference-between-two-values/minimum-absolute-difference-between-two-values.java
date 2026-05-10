class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int ans = Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==0) continue;
        if(nums[i]==2) continue;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==0) continue;
            if(nums[j]==1) continue;
            ans = Math.min(ans, Math.abs(i-j));
        }
       } 
       if(ans == Integer.MAX_VALUE) return -1;
       return ans;
    }
}