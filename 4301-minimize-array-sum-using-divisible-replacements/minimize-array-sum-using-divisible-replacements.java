class Solution {
    public long minArraySum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        replace(nums, set);
        return sum(nums);
    }
    private static void replace(int[] nums, HashSet<Integer> set){
        for(int i = 0; i < nums.length; i++){
            int mini = nums[i];
            for(int j = 1; j * j <= nums[i]; j++){
                if(nums[i] % j == 0){
                    if(set.contains(j)){
                        mini = Math.min(mini, j);
                    }
                    int other = nums[i] / j;
                    if(set.contains(other)){
                        mini = Math.min(mini, other);
                    }
                }   
            }
            nums[i] = mini;
        }
    }
    private static long sum(int[] nums){
        long sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        return sum;
    }
}