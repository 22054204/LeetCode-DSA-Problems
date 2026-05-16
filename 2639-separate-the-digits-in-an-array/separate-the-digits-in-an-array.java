class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int num = nums[i];
            helper(list, num);
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        int idx = 0;
        for(int number:list){
            result[idx++] = number;
        }
        return result;
    }
    private static void helper(List<Integer> list, int num){
        while(num>0){
            list.add(num%10);
            num = num/10;
        }
    }
}