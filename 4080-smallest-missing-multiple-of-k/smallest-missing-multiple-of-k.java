class Solution {
    public int missingMultiple(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        int i=0;
        for(;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        i=0;
        for(int num:set){
            if(!set.contains(k*(i+1))){
                return k*(i+1);
            }
            i++;
        }
        return k*(i+1);
    }
}