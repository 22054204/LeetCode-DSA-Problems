class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int num = nums[0];
        for(int i=1;i<nums.length;i++){
            num+=1;
            if(nums[i]==num) continue;
            else{
                list.add(num);
                i--;
            }
        }
        return list;
    }
}