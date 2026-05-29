class Solution {
    public int minElement(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = helper(nums[i]);
        }
        return findMin(arr);
    }
    private static int helper(int num){
        int sum = 0;
        while(num>0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
    private static int findMin(int[] arr){
        int min = arr[0];
        for(int i=1;i<arr.length;i++){
            if(min>arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}