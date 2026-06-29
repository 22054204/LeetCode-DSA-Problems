class Solution {
    public void nextPermutation(int[] nums) {
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[i-1]<nums[i]){
                int j=nums.length-1;
                while(nums[j]<=nums[i-1]){
                    j--;
                }
                swap(nums, i-1, j);
                reverse(nums, i, nums.length-1);
                return;
            }
            if(i==1){
                reverse(nums, 0, nums.length-1);
                return;
            }
        }
    }
    private static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    private static void reverse(int[] nums, int i, int j){
        while(i<j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}