class Solution {
    public int[] concatWithReverse(int[] nums) {
        int n = nums.length;
        int[] result = new int[n*2];
        int m = result.length;
        for(int i=0;i<n;i++){
            result[i] = nums[i];
        }
        reverse(nums, n);
        int j=0;
        for(int i=n;i<m;i++){
            result[i] = nums[j];
            j++;
        }
        return result;
    }
    private static void reverse(int[]nums, int n){
        int i=0;
        int j=n-1;
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}