class Solution {
    public int missingMultiple(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]%k==0){
                set.add(nums[i]);
            }
        }
        for(int j=0;j<=set.size();j++){
            if(!set.contains(k*(j+1))){
                return k*(j+1);
            }
        }
        return 0;
    }
}