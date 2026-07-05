class Solution {
    public int maxDigitRange(int[] nums) {
        int[] arr = new int[nums.length];
        findDiff(arr, nums);
        System.out.println(Arrays.toString(arr));
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(max, arr[i]);
        }
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==max){
                sum+=nums[i];
            }
        }
        return sum;
    }
    public static void findDiff(int[] arr, int[] nums){
        for(int i=0;i<arr.length;i++){
            int max = findMax(nums[i]);
            int min = findMin(nums[i]);
            arr[i] = max-min;
        }
        
    }
    public static int findMax(int num){
        int max = 0;
        while(num>0){
            max = Math.max(max, num%10);
            num = num/10;
        }
        return max;
    }
    public static int findMin(int num){
        int min = 10;
        while(num>0){
            min = Math.min(min, num%10);
            num = num/10;
        }
        return min;
    }
}