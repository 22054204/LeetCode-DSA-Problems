class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] arr = new int[2];
        HashSet<Integer> set = new HashSet<>();
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                arr[k] = nums[i];
                k++;
            }
            set.add(nums[i]);
        }
        return arr;
    }
}