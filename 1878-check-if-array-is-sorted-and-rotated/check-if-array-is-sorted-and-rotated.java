class Solution {
    public boolean check(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int k = 0;
        int i=0;
        while(i<nums.length){
            int[] temp = nums.clone();
            rotate(temp, k);
            if(Arrays.equals(temp, arr)){
                return true;
            }
            k++;
            i++;
        }
        return false;
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
    }
    public static void swap(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}