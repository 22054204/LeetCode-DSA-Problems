class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int targ = sum - x;
        if (targ < 0)
            return -1;
        if (targ == 0)
            return n;

        int i = 0;
        sum = 0;
        int maxLen = -1;

        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (sum > targ) {
                sum -= nums[i++];
            }
            if (sum == targ) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}