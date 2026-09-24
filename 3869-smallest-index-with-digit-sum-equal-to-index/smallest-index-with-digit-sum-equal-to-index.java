class Solution {
    public int smallestIndex(int[] nums) {
        int[] arr = new int[1001];
        for(int i=0;i<1001;i++){
            int digitSum = digitSum(i);
            arr[i] = digitSum;
        }

        for(int i=0;i<nums.length;i++){
            if(i==arr[nums[i]]){
                return i;
            }
        }
        return -1;
    }
    public int digitSum(int num){
        int sum = 0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}