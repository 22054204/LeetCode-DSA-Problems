class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        list2.add(nums[1]);
        int i=2;
        while(i<nums.length){
            if( list1.get(list1.size()-1) > list2.get(list2.size()-1) ) list1.add(nums[i++]);
            else list2.add(nums[i++]);
        }

        int idx = 0;
        for(i=0;i<list1.size();i++){
            nums[idx++] = list1.get(i);
        }

        for(int j=0;j<list2.size();j++){
            nums[idx++] = list2.get(j);
        }
        return nums;
    }
}