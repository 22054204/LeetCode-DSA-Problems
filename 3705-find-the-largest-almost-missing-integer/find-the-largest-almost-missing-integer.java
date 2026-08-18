class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] freq = new int[51];
        for(int num:nums){
            freq[num]++;
        }

        if(k==1){
            for(int i=50;i>=0;i--){
                if(freq[i]==1){
                    return i;
                }
            }
        }else if(k==n){
            int max = nums[0];
            for(int num:nums){
                max = Math.max(max, num);
            }
            return max;
        }else{ //i<k<n
            if(freq[nums[0]]==1 && freq[nums[n-1]]==1) return Math.max(nums[0], nums[n-1]);
            if(freq[nums[0]]>1 && freq[nums[n-1]]>1) return -1;
            if(freq[nums[0]]==1 && freq[nums[n-1]]>1) return nums[0];
            if(freq[nums[0]]>1 && freq[nums[n-1]]==1) return nums[n-1];
        }
        return -1;
    }
}