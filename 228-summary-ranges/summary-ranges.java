class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] arr = {0,0};
        int i=0;
        while(i<nums.length){
            int j=i;
            arr[0] = nums[i];
            while(j<nums.length-1 && nums[j+1]==nums[j]+1){
                j++;
            }
            arr[1] = nums[j];
            sb.append(arr[0] == arr[1] ? arr[0] : arr[0] + "->" + arr[1]);
            list.add(sb.toString());
            sb.setLength(0);
            i=j+1;
        }
        return list;
    }
}