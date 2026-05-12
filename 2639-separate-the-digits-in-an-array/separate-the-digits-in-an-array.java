class Solution {
    public int[] separateDigits(int[] nums) {
        String s = "";
        for(int i=0;i<nums.length;i++){
            s += nums[i];
        }
        int[] arr = new int[s.length()];
        for(int i=0;i<arr.length;i++){
            arr[i] = s.charAt(i) - '0';
        }
        return arr;
    }
}