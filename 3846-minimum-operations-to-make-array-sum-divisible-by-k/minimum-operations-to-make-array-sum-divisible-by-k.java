class Solution {
    public int minOperations(int[] nums, int k) {
        //return Method1(nums, k);
        return Method2(nums, k);
    }
    private int Method2(int[] nums, int k) {
        return findSum(nums)%k;
    }
    private static int findSum(int[] nums){
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
        }
        return sum;
    }
    private int Method1(int[] nums, int k) {
        return helper(findSum(nums), k);
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