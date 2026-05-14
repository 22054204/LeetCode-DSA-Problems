class Solution {
    public boolean isGood(int[] nums) {
        int max = findMax(nums);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
        }
        if(list.size()!=max+1) return false;
        Collections.sort(list); //[1,2,3,4,5,5,6,7]
        if(nums[nums.length-1]!=nums[nums.length-2]) return false;
        for(int i=1;i<=max;i++){
            if(!list.contains(i)){
                return false;
            }
        }
        return true;
    }
    private static int findMax(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length-1];
    }
}