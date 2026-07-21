class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int[] arr = {0,0};
        int i=0;
        while(i<nums.length){
            int j=i;
            arr[0] = nums[i];
            while(j<nums.length-1 && nums[j+1]==nums[j]+1){
                j++;
            }
            arr[1] = nums[j];
            String s = (arr[0]==arr[1])? arr[0] + "" : arr[0] + "->" + arr[1];
            list.add(s);
            i=j+1;
        }
        return list;
    }
}