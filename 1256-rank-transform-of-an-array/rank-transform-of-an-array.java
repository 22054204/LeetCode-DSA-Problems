class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] nums = arr.clone();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int k = 1;
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], k++);
            }
        }
        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}