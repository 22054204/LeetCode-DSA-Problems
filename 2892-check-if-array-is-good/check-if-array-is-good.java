class Solution {
    public boolean isGood(int[] nums) { //[1,2,3,4,5,5,6,7]
        int max = findMax(nums);
        if(nums.length!=max+1) return false;
        if(maxCount(nums)<2) return false;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        for(int i=1;i<=max;i++){
            if(!list.contains(i)) return false;
        }
        return true;
    }
    private static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max, nums[i]);
        }
        if(max==Integer.MIN_VALUE) return -1;
        return max;
    }
    private static int maxCount(int[] nums){
        int count = 0;
        int num = findMax(nums);
        for(int i=0;i<nums.length;i++){
            if(num==nums[i]){
                count++;
            }
        }
        return count;
    }
}