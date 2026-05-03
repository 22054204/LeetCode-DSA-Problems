class Solution {
    public void rotate(int[] nums, int k) {
        helper(nums, k);
    }
    private static void helper(int[] nums, int k){
        int n = nums.length;
        k = k%n;
        rotate(nums, 0, n-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, n-1);
    }
    private static void rotate(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    private static void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}