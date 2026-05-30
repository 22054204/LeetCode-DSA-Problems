class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return helper(sum, k);
    }
    private static int helper(int num, int k){
        int ans = 0;
        while(num%k!=0){
            num--;
            ans++;
        }
        return ans;
    }
}