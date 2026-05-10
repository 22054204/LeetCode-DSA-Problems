class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] result = new int[n*2];
        int m = result.length;
        for(int i=0;i<n;i++){
            result[i] = nums[i];
        }
        int j=0;
        for(int i=n;i<m;i++){
            result[i] = nums[n-1-j];
            j++;
        }
        return result;
    }
}