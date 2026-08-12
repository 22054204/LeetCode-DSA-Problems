class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int i=0;
        int j=0;
        int maxLen=0;
        int len = 0;
        Map<Integer,Integer> freq = new HashMap<>();

        while(i<n && j<n){
            freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
            len++;
            while(freq.get(nums[j])>k){
                freq.put(nums[i],freq.get(nums[i])-1);
                i++;
                len--;
            }
            maxLen=Math.max(maxLen,len);
            j++;
        }

        return maxLen;
    }
}