class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums.length==0) return 0;
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
        return xor(result);
    }
    private static int xor(List<List<Integer>> result){
        int total = 0;
        for (List<Integer> list : result) {
            int currentXor = 0;
            for (int num : list) {
                currentXor ^= num;
            }
            total += currentXor;
        }
        return total;
    }
    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<>(tempList));
        
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}