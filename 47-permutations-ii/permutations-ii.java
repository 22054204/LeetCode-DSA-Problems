class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generate(nums, 0, result);
        return result;
    }
    private static void generate(int[] nums, int start, List<List<Integer>> result){
        if(start==nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num:nums){
                list.add(num);
            }
            if(!result.contains(list)){
                result.add(list);
            }
        }
        for(int i=start;i<nums.length;i++){
            swap(nums, i, start);
            generate(nums, start+1, result);
            swap(nums, i, start);
        }
    }
    private static void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}