class Solution {
    public int minElement(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = helper(nums[i]);
        }
        Arrays.sort(arr);
        return arr[0];
    }
    private static int helper(int num){
        int sum = 0;
        while(num>0){
            sum = sum + num%10;
            num = num/10;
        }
        return sum;
    }
}