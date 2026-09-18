class Solution {
    int result = Integer.MAX_VALUE;
    public int minSumOfLengths(int[] nums, int target) {
        int n = nums.length;
        int[] tillMinLen = new int[n];
        Arrays.fill(tillMinLen, Integer.MAX_VALUE);
        int i=0;
        int j=0;
        int currSum = 0;
        int bestMin = Integer.MAX_VALUE;
        while(i<n && j<n){
            currSum += nums[j];
            while(currSum>target){
                currSum-=nums[i];
                i++;
            }
            if(currSum==target){
                int len = j-i+1;
                if(i>0 && tillMinLen[i-1]!=Integer.MAX_VALUE){
                    result = Math.min(result, len+tillMinLen[i-1]);
                }
                bestMin = Math.min(bestMin, len);
            }
            tillMinLen[j] = bestMin;
            j++;
        }
        return result==Integer.MAX_VALUE?-1:result;
    }
}