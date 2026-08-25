class Solution {
    public int missingMultiple(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        int j=0;
        for(;j<set.size();j++){
            if(!set.contains(k*(j+1))){
                return k*(j+1);
            }
        }
        return k*(j+1);
    }
}