class Solution {
    public boolean partitionArray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        for(int value:map.values()){
            if(value>nums.length/k){
                return false;
            }
        }
        return nums.length%k==0;
    }
}