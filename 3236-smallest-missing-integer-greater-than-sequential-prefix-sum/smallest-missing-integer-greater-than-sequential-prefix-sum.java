class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                break;
            }else{
                sum+=nums[i];
            }
        }
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
}


/*
class Solution {
    public int missingInteger(int[] nums) {
        int maxSum = nums[0];
        for(int i=0;i<nums.length;i++){
            int n = 1;
            int sum = 0;
            for(int j=i+1;j<nums.length;j++){
                while(n!=0){
                    sum+=nums[i];
                    n--;
                }
                if(nums[i]==nums[j]-1){
                    sum+=nums[j];
                }else{
                    break;
                }
            }
            maxSum = Math.max(sum, maxSum);
        }
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=sum){
                return nums[i];
            }
        }
        return nums.length;
    }
}
*/