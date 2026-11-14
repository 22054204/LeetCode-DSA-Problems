class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int i=0;
        int j=i;
        int finalSum;
        int minSum = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while(i<n){
            int cnt = 0;
            int sum = 0;
            while(j<n && cnt<l){
                sum+=nums.get(j);
                j++;
                cnt++;
            }
            if(cnt < l) break;
            minSum = sum;
            finalSum = Integer.MAX_VALUE;
            if(minSum > 0) {
                finalSum = minSum;
            }
            while(j<n && cnt<r){
                minSum+=nums.get(j);
                if(minSum>0) finalSum = Math.min(finalSum, minSum);
                j++;
                cnt++;
            }
            ans = Math.min(ans, finalSum);
            i++;
            j=i;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}